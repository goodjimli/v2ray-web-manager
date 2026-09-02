package com.jhl.admin.Interceptor;

import com.alibaba.fastjson.JSON;
import com.jhl.admin.VO.UserVO;
import com.jhl.admin.cache.UserCache;
import com.ljh.common.model.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Component
public class AuthInterceptor implements HandlerInterceptor {
    private static final String COOKIE_NAME = "auth";
    @Autowired
    UserCache userCache;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
         boolean result= check(request, response, handler);


         log.info("请求ip:{} URI:{} ,请求参数:{} ",getClientIp(request),request.getRequestURI(), JSON.toJSONString(request.getParameterMap()));
        return result;
    }

    private boolean check(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        if (handler ==null) return true;
        PreAuth preAuth = verifyAuth(handler);
        //无需要认证
        if (preAuth ==null) return  true;
        String token= getAuthCookie(request);
        UserVO userCache = this.userCache.getCache(token);
        //重新登录
        if (token ==null || userCache ==null) {
            Result<Object> result = Result.builder().code(403).message("请重新登录").build();
            response.setHeader("content-type","application/json;charset=UTF-8");
            response.getOutputStream().write(JSON.toJSONBytes(result));
            response.flushBuffer();
              return false;
        }

        String role = userCache.getRole();
        //超级管理员
        if (role.equals("admin")) return  true;

        String[] roles = preAuth.value();
        for (String need: roles){
            if (role.equals(need)){
                return true;
            }

        }
        //其他
        Result<Object> result = Result.builder().code(403).message("无权限").build();
        response.setHeader("content-type","application/json;charset=UTF-8");
        response.getOutputStream().write(JSON.toJSONBytes(result));
        response.flushBuffer();
        return false;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
       /* if (ex != null) {
            log.error("catch exception:{}", ex);
            String message = ex.getMessage();
            Result<Object> build = Result.builder().code(500).message(message).build();
            //response.sendError(500, JSON.toJSONString(build));
            response.getWriter().write(JSON.toJSONString(build));
            return;
        }*/
    }
    private PreAuth verifyAuth(Object handler) {
        PreAuth permit= null;
        if (handler instanceof HandlerMethod){
            permit = ((HandlerMethod) handler).getMethod().getAnnotation(PreAuth.class);
            if(permit == null){
                permit = ((HandlerMethod) handler).getBeanType().getAnnotation(PreAuth.class);
            }
        }
        return permit;
    }

   public String getAuthCookie(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
         if (cookies==null) return null;
        for (Cookie cookie:cookies){
            if (cookie.getName().equals(COOKIE_NAME)){
                return  cookie.getValue();
            }
        }
        return  null;
    }

    public static String getClientIp(HttpServletRequest request) {
        // 1. 优先检查 X-Forwarded-For
        String ip = request.getHeader("X-Forwarded-For");
        if (isValidIp(ip)) {
            // 如果包含多个IP（用逗号分隔），取第一个，即真实客户端IP[reference:5]
            int index = ip.indexOf(",");
            if (index != -1) {
                ip = ip.substring(0, index).trim();
            }
            return ip;
        }

        // 2. 检查其他常见的代理头
        ip = request.getHeader("Proxy-Client-IP");
        if (isValidIp(ip)) {
            return ip;
        }

        ip = request.getHeader("WL-Proxy-Client-IP");
        if (isValidIp(ip)) {
            return ip;
        }

        ip = request.getHeader("HTTP_CLIENT_IP");
        if (isValidIp(ip)) {
            return ip;
        }

        ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        if (isValidIp(ip)) {
            return ip;
        }

        ip = request.getHeader("X-Real-IP");
        if (isValidIp(ip)) {
            return ip;
        }

        // 3. 最后的备选方案
        return request.getRemoteAddr();
    }

    private static boolean isValidIp(String ip) {
        return ip != null && !ip.isEmpty() && !"unknown".equalsIgnoreCase(ip);
    }
}

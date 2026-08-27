package com.jhl.web.webConf;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.google.common.collect.Lists;
import com.jhl.web.interceptor.AuthInterceptor;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpRequestRetryHandler;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.ssl.SSLContextBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.net.ssl.SSLContext;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    AuthInterceptor authInterceptor;

    /**
     * 拦截器
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authInterceptor).addPathPatterns("/**");
    }

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {

        converters.add(0,fastJsonHttpMessageConverter());
    }
        @Bean
    public FastJsonHttpMessageConverter fastJsonHttpMessageConverter(){
        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
        fastJsonHttpMessageConverter.setSupportedMediaTypes(Lists.newArrayList(MediaType.APPLICATION_JSON));
        return fastJsonHttpMessageConverter;
    }

    @Bean
    public RestTemplate getRestTemplate() throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().removeIf(httpMessageConverter -> {
            String name = httpMessageConverter.getClass().getName();
            if (name.contains("json")) return true;
            else return false;
        });
        restTemplate.setRequestFactory(httpFactory());
        restTemplate.getMessageConverters().add(fastJsonHttpMessageConverter());
        return restTemplate;
    }

    // 低频率高延迟

    private HttpComponentsClientHttpRequestFactory httpFactory() throws Exception {
        // 1. SSL上下文（使用JDK默认的TLS实现）
        SSLContext sslContext = SSLContextBuilder.create()
                .setProtocol("TLS")
                .build(); // build() 方法内部会自动执行 init(null, null, null)

        // 2. 【关键】创建Socket工厂时，强制指定支持的协议数组
        SSLConnectionSocketFactory sslSocketFactory = new SSLConnectionSocketFactory(
                sslContext,
                new String[]{"TLSv1.2", "TLSv1.3"}, // 只允许这两个协议，拒绝低版本
                null, // 加密套件使用默认（JDK会选最高效的）
                SSLConnectionSocketFactory.getDefaultHostnameVerifier() // 生产环境保持默认主机名验证
        );
        Registry<ConnectionSocketFactory> registry = RegistryBuilder.<ConnectionSocketFactory>create()
                .register("http", PlainConnectionSocketFactory.getSocketFactory())
                .register("https", sslSocketFactory) // 注入自定义工厂
                .build();
        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager(registry);
        cm.setMaxTotal(50);
        cm.setDefaultMaxPerRoute(25);

        // 【关键】设置连接存活时间策略，主动探测并驱逐死连接
        cm.setValidateAfterInactivity(5000); // 空闲2秒后，下次请求先验证连接是否有效

        RequestConfig config = RequestConfig.custom()
                .setConnectTimeout(8000)
                .setSocketTimeout(20000)
                .setConnectionRequestTimeout(1000)
                .build();

        CloseableHttpClient client = HttpClientBuilder.create()
                .setConnectionManager(cm)
                .setDefaultRequestConfig(config)
                .evictExpiredConnections()  // 驱逐过期连接
                .evictIdleConnections(60L, TimeUnit.SECONDS) // 空闲超过30秒主动清除
                //默认失败的重发3次
                .setRetryHandler(new DefaultHttpRequestRetryHandler(3, false))
                .build();
        return new HttpComponentsClientHttpRequestFactory(client);
    }
}

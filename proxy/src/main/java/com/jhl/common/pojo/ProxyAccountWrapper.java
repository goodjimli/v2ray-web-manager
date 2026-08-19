package com.jhl.common.pojo;

import com.ljh.common.model.ProxyAccount;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProxyAccountWrapper extends ProxyAccount {
    /**
     * 版本号
     */
    private  Long version;

    private Integer code = 100;
    private String message ="默认";


}

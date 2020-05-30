package com.leeyom.scaffold.common.enums;

import java.io.Serializable;

/**
 * api接口响应的顶级抽象
 */
public interface ApiBaseEnum extends Serializable {

    /**
     * api响应code码
     *
     * @return 响应code
     */
    int getCode();

    /**
     * api响应code码描述
     *
     * @return 响应 code 描述
     */
    String getMsg();

}

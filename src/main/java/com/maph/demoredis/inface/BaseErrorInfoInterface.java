package com.maph.demoredis.inface;

/**
 * 自定义接口类
 */
public interface BaseErrorInfoInterface {
    /**
     * 错误码
     * @return
     */
    String getResultCode();

    /**
     * 错误描述
     * @return
     */
    String getResultMsg();
}

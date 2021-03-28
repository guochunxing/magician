package com.workabee.cloud.magician.common.exception;

import lombok.AllArgsConstructor;

/**
 * author: chunxing
 * date: 2021/2/5 14:35
 * description:
 */
@AllArgsConstructor
public enum CommonMessage implements MagicianMessage {

    PARAMETER_EX(400, "parameter exception"),
    API_PROTOCOL_SPEC_EX(1000, "protocol specification exception"),
    //Execute 10000-20000
    EXECUTE_NOT_SUPPORT_PROTOCOL(10000, "not support protocol"),
    ;

    //API


    Integer code;
    String message;

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}

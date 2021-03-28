package com.workabee.cloud.magician.gateway.domain.exception;

import com.workabee.cloud.magician.common.exception.MagicianMessage;
import lombok.AllArgsConstructor;

/**
 * author: chunxing
 * date: 2021/2/5 14:35
 * description:
 */
@AllArgsConstructor
public enum GatewayMessage implements MagicianMessage {

    HTTP_MISSING_PARAMETERS(1400, "missing parameters"),
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

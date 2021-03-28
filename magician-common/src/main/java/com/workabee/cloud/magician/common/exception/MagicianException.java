package com.workabee.cloud.magician.common.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * author: chunxing
 * date: 2021/1/13 10:14
 * description:
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class MagicianException extends RuntimeException implements Serializable {

    private Integer code;

    private String message;

    public MagicianException(Integer code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public MagicianException(MagicianMessage message) {
        super(message.getMessage());
        this.code = message.getCode();
        this.message = message.getMessage();
    }

    public static MagicianException EX(MagicianMessage message) {
        return new MagicianException(message);
    }


    public static MagicianException EX(MagicianMessage message, String replaceMessage) {
        return new MagicianException(message.getCode(), replaceMessage);
    }

}

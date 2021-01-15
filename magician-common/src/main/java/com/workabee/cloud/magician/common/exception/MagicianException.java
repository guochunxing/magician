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

}

package com.workabee.cloud.magician.common.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * author: chunxing
 * date: 2021/2/5 14:51
 * description:
 */
public class GatewayCt {

    /**
     * 操作类型
     */
    @Getter
    @AllArgsConstructor
    public enum Protocol {
        DUBBO, HTTP
    }

    /**
     * 支持的数据类型
     */
    @Getter
    @AllArgsConstructor
    public enum ContentType {
        JSON, FILE
    }

}

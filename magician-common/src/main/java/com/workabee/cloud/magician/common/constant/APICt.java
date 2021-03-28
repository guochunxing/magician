package com.workabee.cloud.magician.common.constant;

import lombok.Getter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * author: chunxing
 * date: 2021/2/7 17:07
 * description:
 */
public class APICt {


    /**
     * 操作类型
     */
    @Getter
    public enum TypeReference {
        STRING(Collections.singletonList(String.class.getCanonicalName())),
        NUMBER(
                Arrays.asList(
                        int.class.getCanonicalName(),
                        Integer.class.getCanonicalName(),
                        long.class.getCanonicalName(),
                        Long.class.getCanonicalName()
                )),
        ;

        List<String> className;

        TypeReference(List<String> className) {
            this.className = className;
        }
    }
}

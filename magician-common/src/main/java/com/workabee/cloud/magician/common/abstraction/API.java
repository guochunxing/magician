package com.workabee.cloud.magician.common.abstraction;

import com.workabee.cloud.magician.common.abstraction.value.Struct;
import lombok.Data;

import java.util.List;

/**
 * author: chunxing
 * date: 2021/1/13 17:12
 * description:
 */
@Data
public class API {

    /**
     * api 版本和 name/api 唯一标示
     */
    private String name;

    private String version;
    /**
     * 需要转化协议
     * HTTP/DUBBO/GRPC
     */
    private String protocolType;

    /**
     * 鉴权方式
     */
    private String authId;

    /**
     * 入参
     */
    private List<Struct> parameters;

    /**
     * 返回值
     */
    private Struct result;

    /**
     * 调用地址
     */
    private Object invokeAddress;

    /**
     * 超时时间
     */
    private Integer timeOut;
}

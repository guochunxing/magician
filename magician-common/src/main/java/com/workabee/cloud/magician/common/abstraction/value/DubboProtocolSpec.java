package com.workabee.cloud.magician.common.abstraction.value;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * author: chunxing
 * date: 2021/2/7 17:22
 * description:
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class DubboProtocolSpec extends ProtocolSpec {

    private String service;

    private String method;

    private String group;

    private String version;

    private String tag;

}

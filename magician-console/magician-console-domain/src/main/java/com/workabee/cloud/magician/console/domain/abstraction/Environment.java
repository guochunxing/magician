package com.workabee.cloud.magician.console.domain.abstraction;

import lombok.Data;

/**
 * author: chunxing
 * date: 2021/2/8 11:51
 * description:
 */
@Data
public class Environment {

    private String name;
    //唯一环境标示
    private String alias;
    //排序
    private Integer order;

    private String desc;
}

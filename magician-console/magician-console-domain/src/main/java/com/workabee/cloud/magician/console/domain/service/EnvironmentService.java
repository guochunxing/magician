package com.workabee.cloud.magician.console.domain.service;

import com.workabee.cloud.magician.console.domain.abstraction.Environment;

import java.util.List;

/**
 * author: chunxing
 * date: 2021/2/8 11:53
 * description:
 */
public interface EnvironmentService {

    //根据 order 排序
    List<Environment> select();
}

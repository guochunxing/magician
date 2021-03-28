package com.workabee.cloud.magician.console.biz.manager.impl;

import com.workabee.cloud.magician.common.abstraction.AbstractAPIDefinition;
import com.workabee.cloud.magician.common.exception.CommonMessage;
import com.workabee.cloud.magician.common.util.CheckUtil;
import com.workabee.cloud.magician.console.biz.manager.APIDefinitionManager;
import com.workabee.cloud.magician.console.domain.abstraction.Environment;
import com.workabee.cloud.magician.console.domain.service.EnvironmentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * author: chunxing
 * date: 2021/2/8 11:56
 * description:
 */
@Service
public class APIDefinitionManagerImpl implements APIDefinitionManager {

    @Resource
    private EnvironmentService environmentService;

    @Override
    public void initialize(AbstractAPIDefinition definition) {
        List<Environment> environments = environmentService.select();
        Optional<Environment> envOptional = environments.stream().findFirst();
        CheckUtil.checkArgument(envOptional.isPresent(), CommonMessage.PARAMETER_EX, "暂无初始化环境");
        //进行dubbo调用创建,设置 dubbo group


    }
}

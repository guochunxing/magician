package com.workabee.cloud.magician.console.infra.service;

import com.workabee.cloud.magician.common.abstraction.AbstractAPIDefinition;
import com.workabee.cloud.magician.common.factory.ProtocolSpecFactory;
import com.workabee.cloud.magician.common.service.ProtocolSpecService;
import com.workabee.cloud.magician.console.domain.service.APIDefinitionService;
import org.springframework.stereotype.Service;

/**
 * author: chunxing
 * date: 2021/2/8 10:34
 * description:
 */
@Service
public class APIDefinitionServiceImpl implements APIDefinitionService {

    @Override
    public void init(AbstractAPIDefinition definition) {
        //创建默认对外参数
        definition.private2openInDefinitions();
        definition.private2openOutDefinition();
        ProtocolSpecService protocolSpecService = ProtocolSpecFactory.getProtocolSpecService(definition.getProtocol());
        protocolSpecService.check(definition.getProtocolSpec());
        //存储
    }


}

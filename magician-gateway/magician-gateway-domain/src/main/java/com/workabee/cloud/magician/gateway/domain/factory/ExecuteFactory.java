package com.workabee.cloud.magician.gateway.domain.factory;

import com.workabee.cloud.magician.common.constant.GatewayCt;
import com.workabee.cloud.magician.common.exception.MagicianException;
import com.workabee.cloud.magician.gateway.domain.abstraction.APIDefinition;
import com.workabee.cloud.magician.gateway.domain.exception.GatewayMessage;
import com.workabee.cloud.magician.gateway.domain.service.ExecuteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * author: chunxing
 * date: 2021/2/5 14:22
 * description:
 */
@Component
public class ExecuteFactory {

    private static ApplicationContext applicationContext;

    @Autowired
    public void setApplicationContext(ApplicationContext applicationContext) {
        ExecuteFactory.applicationContext = applicationContext;
    }

    public static ExecuteService getExecuteService(APIDefinition api) {
        GatewayCt.Protocol protocol = api.getProtocol();
        Map<String, ExecuteService> serviceMap = applicationContext.getBeansOfType(ExecuteService.class);
        for (ExecuteService service : serviceMap.values()) {
            if (service.supportProtocol(protocol)) {
                return service;
            }
        }
        throw MagicianException.EX(GatewayMessage.EXECUTE_NOT_SUPPORT_PROTOCOL);
    }
}

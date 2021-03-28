package com.workabee.cloud.magician.common.factory;

import com.workabee.cloud.magician.common.service.ProtocolSpecService;
import com.workabee.cloud.magician.common.constant.GatewayCt;
import com.workabee.cloud.magician.common.exception.MagicianException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Map;

import static com.workabee.cloud.magician.common.exception.CommonMessage.API_PROTOCOL_SPEC_EX;

/**
 * author: chunxing
 * date: 2021/2/8 11:07
 * description:
 */
@Component
public class ProtocolSpecFactory {


    private static ApplicationContext applicationContext;

    @Autowired
    public void setApplicationContext(ApplicationContext applicationContext) {
        ProtocolSpecFactory.applicationContext = applicationContext;
    }

    public static ProtocolSpecService getProtocolSpecService(GatewayCt.Protocol protocol) {
        Map<String, ProtocolSpecService> beans = applicationContext.getBeansOfType(ProtocolSpecService.class);
        for (ProtocolSpecService service : beans.values()) {
            if (service.supportProtocol(protocol)) {
                return service;
            }
        }
        throw MagicianException.EX(API_PROTOCOL_SPEC_EX, "不支持的协议类型");
    }
}

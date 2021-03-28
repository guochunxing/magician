package com.workabee.cloud.magician.gateway.infra.service;

import com.workabee.cloud.magician.common.constant.GatewayCt;
import com.workabee.cloud.magician.gateway.domain.abstraction.value.Outcome;
import com.workabee.cloud.magician.gateway.domain.util.ExecuteRequest;
import org.springframework.stereotype.Service;

/**
 * author: chunxing
 * date: 2021/2/5 14:18
 * description:
 */
@Service
public class HttpExecuteServiceImpl extends AbstractExecuteService {

    @Override
    public Boolean supportProtocol(GatewayCt.Protocol protocol) {
        return protocol.equals(GatewayCt.Protocol.HTTP);
    }

    @Override
    public Boolean supportContentType(GatewayCt.ContentType contentType) {
        return contentType.equals(GatewayCt.ContentType.JSON);
    }

    @Override
    public Outcome execute(ExecuteRequest context) {
        return null;
    }
}

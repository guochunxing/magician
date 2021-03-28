package com.workabee.cloud.magician.gateway.domain.service;

import com.workabee.cloud.magician.common.constant.GatewayCt;
import com.workabee.cloud.magician.gateway.domain.abstraction.value.Outcome;
import com.workabee.cloud.magician.gateway.domain.util.ExecuteRequest;

/**
 * author: chunxing
 * date: 2021/2/5 14:09
 * description:
 */
public interface ExecuteService {

    Boolean supportProtocol(GatewayCt.Protocol protocol);

    Boolean supportContentType(GatewayCt.ContentType contentType);

    Outcome execute(ExecuteRequest context);

}

package com.workabee.cloud.magician.gateway.infra.service;

import com.workabee.cloud.magician.common.constant.GatewayCt;
import com.workabee.cloud.magician.gateway.domain.abstraction.value.Outcome;
import com.workabee.cloud.magician.gateway.domain.util.ExecuteRequest;
import org.springframework.stereotype.Service;

/**
 * author: chunxing
 * date: 2021/2/7 15:24
 * description:
 */
@Service
public class DubboFileExecuteServiceImpl extends DubboExecuteServiceImpl {


    @Override
    public Boolean supportContentType(GatewayCt.ContentType contentType) {
        return GatewayCt.ContentType.FILE.equals(contentType);
    }

    @Override
    public Outcome execute(ExecuteRequest context) {
        return null;
    }
}

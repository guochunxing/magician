package com.workabee.cloud.magician.gateway.infra.service;

import com.workabee.cloud.magician.gateway.domain.abstraction.APIDefinition;
import com.workabee.cloud.magician.gateway.domain.abstraction.value.Outcome;
import com.workabee.cloud.magician.gateway.domain.service.ExecuteService;
import com.workabee.cloud.magician.gateway.domain.util.ExecuteRequest;

/**
 * author: chunxing
 * date: 2021/2/5 14:41
 * description:
 */
public abstract class AbstractExecuteService implements ExecuteService {

    @Override
    public Outcome execute(ExecuteRequest context) {
        byte[] source = context.getContent();
        APIDefinition api = context.getApi();

        return null;
    }

}

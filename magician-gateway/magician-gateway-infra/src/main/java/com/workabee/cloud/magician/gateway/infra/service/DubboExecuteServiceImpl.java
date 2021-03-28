package com.workabee.cloud.magician.gateway.infra.service;

import com.workabee.cloud.magician.common.abstraction.value.AbstractAttributeDefinition;
import com.workabee.cloud.magician.common.constant.GatewayCt;
import com.workabee.cloud.magician.gateway.domain.abstraction.APIDefinition;
import com.workabee.cloud.magician.common.abstraction.value.DubboProtocolSpec;
import com.workabee.cloud.magician.common.abstraction.value.ProtocolSpec;
import com.workabee.cloud.magician.gateway.domain.abstraction.value.Outcome;
import com.workabee.cloud.magician.gateway.domain.service.TransformService;
import com.workabee.cloud.magician.gateway.domain.util.ExecuteRequest;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.rpc.service.GenericService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * author: chunxing
 * date: 2021/2/5 14:18
 * description:
 */
@Service
public class DubboExecuteServiceImpl extends AbstractExecuteService {

    @Resource
    private TransformService transformService;

    @Override
    public Boolean supportProtocol(GatewayCt.Protocol protocol) {
        return protocol.equals(GatewayCt.Protocol.DUBBO);
    }

    @Override
    public Boolean supportContentType(GatewayCt.ContentType contentType) {
        return contentType.equals(GatewayCt.ContentType.JSON);
    }


    @Override
    public Outcome execute(ExecuteRequest context) {
        byte[] source = context.getContent();
        APIDefinition api = context.getApi();
        //入参转化
        List<Object> parameters = transformService.transform(source, api.getOpenInDefinitions());
        //获取调用地址
        DubboProtocolSpec invokeAddress = (DubboProtocolSpec) api.getProtocolSpec();
        //执行
        Object result = invoke(api, invokeAddress, parameters);
        //返回值转化
        Object transformResult = transformService.transform(result, api.getOpenOutDefinition());
        return Outcome.builder()
                .result(transformResult)
                .success(true)
                .build();
    }


    public Object invoke(APIDefinition api, ProtocolSpec invokeAddress, List<Object> parameters) {
        DubboProtocolSpec dubboInvokeAddress = (DubboProtocolSpec) invokeAddress;
        ReferenceConfig<GenericService> reference = new ReferenceConfig<>();
        reference.setInterface(dubboInvokeAddress.getService());
        reference.setVersion(dubboInvokeAddress.getVersion());
        reference.setGroup(dubboInvokeAddress.getGroup());
        reference.setTag(dubboInvokeAddress.getTag());
        reference.setTimeout(api.getTimeOut());
        reference.setGeneric(true);
        GenericService genericService = reference.get();

        List<AbstractAttributeDefinition> attributeDefinitions = api.getOpenInDefinitions();
        List<String> originalTypes = attributeDefinitions.stream()
                .map(AbstractAttributeDefinition::getOriginalType)
                .collect(Collectors.toList());

        return genericService.$invoke(
                dubboInvokeAddress.getMethod(),
                originalTypes.toArray(new String[]{}),
                parameters.toArray());

    }
}

package com.workabee.cloud.magician.gateway.infra.repository;

import com.workabee.cloud.magician.common.constant.GatewayCt;
import com.workabee.cloud.magician.gateway.domain.abstraction.APIDefinition;
import com.workabee.cloud.magician.gateway.domain.repository.APIRepository;
import com.workabee.cloud.magician.gateway.infra.dao.condition.ApiDefinitionCondition;
import com.workabee.cloud.magician.gateway.infra.dao.mapper.base.BaseApiDefinitionMapper;
import com.workabee.cloud.magician.gateway.infra.dao.model.ApiDefinition;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * author: chunxing
 * date: 2021/2/7 15:58
 * description:
 */
@Repository
public class APIRepositoryImpl implements APIRepository {

    @Resource
    BaseApiDefinitionMapper apiMapper;


    @Override
    public APIDefinition select(String name, String version) {
        ApiDefinitionCondition condition = new ApiDefinitionCondition();
        condition.createCriteria()
                .andNameEqualTo(name)
                .andVersionEqualTo(version);
        List<ApiDefinition> apiDefinitions = apiMapper.selectByExample(condition);
        Optional<ApiDefinition> definitionOptional = apiDefinitions.stream().findFirst();
        return definitionOptional.map(this::do2domain).orElse(null);
    }

    public APIDefinition do2domain(ApiDefinition apiDefinition) {
        APIDefinition definition = new APIDefinition();
        definition.setName(apiDefinition.getName());
        definition.setVersion(apiDefinition.getVersion());
        definition.setProtocol(GatewayCt.Protocol.valueOf(apiDefinition.getProtocol()));
        return definition;
    }

}

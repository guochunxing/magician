package com.workabee.cloud.magician.gateway.infra.repository;

import com.workabee.cloud.magician.common.abstraction.value.AbstractAttributeDefinition;
import com.workabee.cloud.magician.gateway.domain.abstraction.value.AttributeDefinition;
import com.workabee.cloud.magician.gateway.domain.repository.AttributeDefinitionRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * author: chunxing
 * date: 2021/2/7 23:13
 * description:
 */
@Repository
public class AttributeDefinitionRepositoryImpl implements AttributeDefinitionRepository {

    @Override
    public List<AbstractAttributeDefinition> selectByApi(String name, String version) {
        return null;
    }
}

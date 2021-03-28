package com.workabee.cloud.magician.gateway.domain.repository;

import com.workabee.cloud.magician.common.abstraction.value.AbstractAttributeDefinition;
import com.workabee.cloud.magician.gateway.domain.abstraction.value.AttributeDefinition;

import java.util.List;

/**
 * author: chunxing
 * date: 2021/2/7 16:54
 * description:
 */
public interface AttributeDefinitionRepository {

    List<AbstractAttributeDefinition> selectByApi(String name, String version);
}

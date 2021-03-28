package com.workabee.cloud.magician.gateway.domain.service;

import com.workabee.cloud.magician.common.abstraction.value.AbstractAttributeDefinition;

import java.util.List;

/**
 * author: chunxing
 * date: 2021/2/7 15:25
 * description:
 */
public interface TransformService {

    List<Object> transform(byte[] source, List<AbstractAttributeDefinition> definitions);

    Object transform(Object source, AbstractAttributeDefinition definition);
}

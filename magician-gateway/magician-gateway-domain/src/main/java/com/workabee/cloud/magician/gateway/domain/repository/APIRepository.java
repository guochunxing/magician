package com.workabee.cloud.magician.gateway.domain.repository;

import com.workabee.cloud.magician.gateway.domain.abstraction.APIDefinition;

/**
 * author: chunxing
 * date: 2021/2/5 16:13
 * description:
 */
public interface APIRepository {

    APIDefinition select(String name, String version);
}

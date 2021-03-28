package com.workabee.cloud.magician.gateway.domain.factory;

import com.workabee.cloud.magician.gateway.domain.abstraction.APIDefinition;
import com.workabee.cloud.magician.gateway.domain.repository.APIRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * author: chunxing
 * date: 2021/2/5 16:10
 * description:
 */
@Component
public class APIFactory {

    private static ApplicationContext applicationContext;

    @Autowired
    public void setApplicationContext(ApplicationContext applicationContext) {
        APIFactory.applicationContext = applicationContext;
    }

    public static APIDefinition build(String name, String version) {
        APIRepository repository = applicationContext.getBean(APIRepository.class);
        return repository.select(name, version);
    }

}

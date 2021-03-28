package com.workabee.cloud.magician.console.infra.service;

import com.workabee.cloud.magician.console.domain.abstraction.Environment;
import com.workabee.cloud.magician.console.domain.service.EnvironmentService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author: chunxing
 * date: 2021/2/11 00:19
 * description:
 */
@Service
public class EnvironmentServiceImpl implements EnvironmentService {

    @Override
    public List<Environment> select() {
        return null;
    }
}

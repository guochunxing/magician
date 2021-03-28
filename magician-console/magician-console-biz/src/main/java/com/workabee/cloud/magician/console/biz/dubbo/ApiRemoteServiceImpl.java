package com.workabee.cloud.magician.console.biz.dubbo;

import com.workabee.cloud.magician.console.api.ApiRemoteService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;

/**
 * author: chunxing
 * date: 2021/1/22 00:02
 * description:
 */
@Service
@DubboService
public class ApiRemoteServiceImpl implements ApiRemoteService {

    @Override
    public Object apiInfo() {
        return null;
    }
}

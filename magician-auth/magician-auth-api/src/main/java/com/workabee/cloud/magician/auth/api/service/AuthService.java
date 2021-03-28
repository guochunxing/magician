package com.workabee.cloud.magician.auth.api.service;

import com.workabee.cloud.magician.auth.api.request.AuthCheckRequest;

/**
 * author: chunxing
 * date: 2021/3/5 16:36
 * description:
 */
public interface AuthService {

    boolean check(AuthCheckRequest request);

}

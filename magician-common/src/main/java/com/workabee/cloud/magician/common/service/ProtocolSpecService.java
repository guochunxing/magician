package com.workabee.cloud.magician.common.service;

import com.workabee.cloud.magician.common.abstraction.value.ProtocolSpec;
import com.workabee.cloud.magician.common.constant.GatewayCt;

/**
 * author: chunxing
 * date: 2021/2/8 11:03
 * description:
 */
public interface ProtocolSpecService {

    boolean supportProtocol(GatewayCt.Protocol protocol);

    void check(ProtocolSpec protocolSpec);
}

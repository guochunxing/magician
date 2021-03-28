package com.workabee.cloud.magician.gateway.domain.abstraction.value;

import lombok.Builder;
import lombok.Data;

/**
 * author: chunxing
 * date: 2021/2/5 14:13
 * description:
 */
@Data
@Builder
public class Outcome {

    private boolean success;

    private Object result;
}

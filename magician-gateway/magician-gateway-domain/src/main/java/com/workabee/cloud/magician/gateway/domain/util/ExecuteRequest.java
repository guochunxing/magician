package com.workabee.cloud.magician.gateway.domain.util;

import com.workabee.cloud.magician.gateway.domain.abstraction.APIDefinition;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * author: chunxing
 * date: 2021/2/7 14:28
 * description:
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExecuteRequest {

    private APIDefinition api;
    //标签
    private Map<String, String> tags;

    private String contentType;
    //内容
    private byte[] content;

}

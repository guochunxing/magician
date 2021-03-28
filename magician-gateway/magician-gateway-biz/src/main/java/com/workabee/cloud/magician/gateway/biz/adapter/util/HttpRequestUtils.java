package com.workabee.cloud.magician.gateway.biz.adapter.util;

import com.workabee.cloud.magician.common.util.CheckUtil;
import com.workabee.cloud.magician.gateway.domain.abstraction.APIDefinition;
import com.workabee.cloud.magician.gateway.domain.exception.GatewayMessage;
import com.workabee.cloud.magician.gateway.domain.util.ExecuteRequest;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpUtil;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * author: chunxing
 * date: 2021/2/7 11:40
 * description:
 */
public class HttpRequestUtils {

    public static void check(FullHttpRequest request) {
        String name = getApiName(request);
        CheckUtil.checkArgument(StringUtils.isNotBlank(name), GatewayMessage.HTTP_MISSING_PARAMETERS, "api_name is blank");
        String version = getApiVersion(request);
        CheckUtil.checkArgument(StringUtils.isNotBlank(version), GatewayMessage.HTTP_MISSING_PARAMETERS, "api_version is blank");
    }

    public static String getApiName(FullHttpRequest request) {
        HttpHeaders headers = request.headers();
        return headers.get("api_name");
    }

    public static String getApiVersion(FullHttpRequest request) {
        HttpHeaders headers = request.headers();
        return headers.get("api_version");
    }

    public static ExecuteRequest buildContext(ChannelHandlerContext ctx, FullHttpRequest request, APIDefinition api) {
        List<Map.Entry<String, String>> entries = request.headers().entries();
        Map<String, String> tags = new HashMap<>();
        for (Map.Entry<String, String> entry : entries) {
            tags.put(entry.getKey(), entry.getValue());
        }
        CharSequence mimeType = HttpUtil.getMimeType(request);
        ByteBuf content = request.content();
        byte[] bytes = new byte[content.readableBytes()];
        int readerIndex = content.readerIndex();
        content.getBytes(readerIndex, bytes);

        return ExecuteRequest.builder()
                .api(api)
                .tags(tags)
                .contentType(mimeType.toString())
                .content(bytes)
                .build();
    }
}

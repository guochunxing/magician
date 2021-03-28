package com.workabee.cloud.magician.gateway.biz.adapter.http;

import com.workabee.cloud.magician.gateway.biz.adapter.util.HttpRequestUtils;
import com.workabee.cloud.magician.gateway.domain.abstraction.APIDefinition;
import com.workabee.cloud.magician.gateway.domain.abstraction.value.Outcome;
import com.workabee.cloud.magician.gateway.domain.factory.APIFactory;
import com.workabee.cloud.magician.gateway.domain.factory.ExecuteFactory;
import com.workabee.cloud.magician.gateway.domain.service.ExecuteService;
import com.workabee.cloud.magician.gateway.domain.util.ExecuteRequest;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import lombok.extern.slf4j.Slf4j;

import java.nio.charset.Charset;

import static io.netty.handler.codec.http.HttpResponseStatus.OK;
import static io.netty.handler.codec.http.HttpVersion.HTTP_1_1;

/**
 * author: chunxing
 * date: 2021/2/5 15:31
 * description:
 */
@Slf4j
public class HttpBizHandler extends SimpleChannelInboundHandler<FullHttpRequest> {


    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        ctx.flush();
    }

    @Override
    public void channelRead0(ChannelHandlerContext ctx, FullHttpRequest request) {
        HttpRequestUtils.check(request);
        APIDefinition definition = APIFactory.build(HttpRequestUtils.getApiName(request), HttpRequestUtils.getApiVersion(request));

        ExecuteService execute = ExecuteFactory.getExecuteService(definition);
        ExecuteRequest context = HttpRequestUtils.buildContext(ctx, request, definition);
        Outcome outcome = execute.execute(context);
        FullHttpResponse response = new DefaultFullHttpResponse(HTTP_1_1, OK);
        response.headers().set(HttpHeaderNames.CONTENT_TYPE, HttpHeaderValues.APPLICATION_JSON);
        response.headers().setInt(HttpHeaderNames.CONTENT_LENGTH, response.content().readableBytes());
        boolean keepAlive = HttpUtil.isKeepAlive(request);
        if (!keepAlive) {
            ctx.write(response).addListener(ChannelFutureListener.CLOSE);
        } else {
            response.headers().set(HttpHeaderNames.CONNECTION, HttpHeaderValues.KEEP_ALIVE);
            ctx.write(response);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {

        ByteBufAllocator allocator = ctx.alloc();
        ByteBuf buffer = allocator.buffer();
        buffer.writeBytes("中国".getBytes(Charset.defaultCharset()));
        log.error(cause.getMessage());
        FullHttpResponse response = new DefaultFullHttpResponse(HTTP_1_1, OK, buffer);
        response.headers().set(HttpHeaderNames.CONTENT_TYPE, HttpHeaderValues.APPLICATION_JSON);
        response.headers().setInt(HttpHeaderNames.CONTENT_LENGTH, response.content().readableBytes());
        ctx.write(response).addListener(ChannelFutureListener.CLOSE);
    }
}

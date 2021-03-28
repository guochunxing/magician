package com.workabee.cloud.magician.gateway.biz.adapter.http;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * author: chunxing
 * date: 2021/2/5 15:19
 * description:
 */
@Slf4j
@Component
public class HttpApplicationListener implements ApplicationListener<ApplicationEvent> {

    static final int PORT = 8080;

    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        if (applicationEvent instanceof ContextRefreshedEvent) {
            //启动 netty 容器
            EventLoopGroup bossGroup = new NioEventLoopGroup(10);
            EventLoopGroup workerGroup = new NioEventLoopGroup(200);
            try {
                ServerBootstrap bootstrap = new ServerBootstrap();
                bootstrap.option(ChannelOption.SO_BACKLOG, 1024);
                bootstrap.group(bossGroup, workerGroup)
                        .channel(NioServerSocketChannel.class)
                        .handler(new LoggingHandler(LogLevel.INFO))
                        .childHandler(new HttpServerInitializer());

                Channel ch = bootstrap.bind(PORT).sync().channel();

                log.warn("Open your web browser and navigate to " + "http://127.0.0.1:" + PORT + '/');
                ch.closeFuture().sync();
            } catch (Exception exception) {
                System.err.println("EX");
            } finally {
                //关闭 netty 容器
                bossGroup.shutdownGracefully();
                workerGroup.shutdownGracefully();
            }
        }

    }
}

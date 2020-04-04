package com.kingsoft.netty.fourthexample;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.timeout.IdleStateHandler;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName TestServerInitializer
 * @Description TODO
 * @Author 黄育佳
 * @Date 2020/4/4 13:16
 * @Version 1.0
 **/

public class MyServerInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        // 空闲检测处理器
        pipeline.addLast("idleStateHandler", new IdleStateHandler(4,5,3, TimeUnit.SECONDS));
        // 自定义处理器
        pipeline.addLast("myServerHandler", new MyServerHandler());
    }
}

package com.kingsoft.netty.fourthexample;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

/**
 * @ClassName TestServer
 * @Description TODO
 * @Author 黄育佳
 * @Date 2020/4/4 13:08
 * @Version 1.0
 **/

/**
 * 服务器端
 */
public class MyServer {

    public static void main(String[] args) throws Exception {
        EventLoopGroup bossGroup = new NioEventLoopGroup(); //.handler()针对bossGroup
        EventLoopGroup workerGroup = new NioEventLoopGroup(); //.childHandler()针对workerGroup
        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();  // 用于简化服务端启动的类
            serverBootstrap.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class)  // NioServerSocketChannel管道,反射方式创建
                    .handler(new LoggingHandler(LogLevel.INFO))
                    .childHandler(new MyServerInitializer());
            ChannelFuture channelFuture = serverBootstrap.bind(8899).sync();
            channelFuture.channel().closeFuture().sync();  // 关闭监听
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}

package com.kingsoft.netty.firstexample;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

/**
 * @ClassName TestServerInitializer
 * @Description TODO
 * @Author 黄育佳
 * @Date 2020/4/4 13:16
 * @Version 1.0
 **/

/**
 * 客户端和服务端一旦建立连接TestServerInitializer就被创建,并且调用initChannel
 * 服务端初始化器 (若干个channelhandler(netty以及自定义))  连接被注册创建就会执行initChannel
 */
public class TestServerInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        pipeline.addLast("httpServerCodec", new HttpServerCodec());  // 请求响应编解码 HttpServerCodec为HttpRequestDecoder+HttpResponseEncoder组合
        pipeline.addLast("testHttpServerHandler", new TestHttpServerHandler());
    }
}

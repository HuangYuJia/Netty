package com.kingsoft.netty.fifthexample;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;


/**
 * @ClassName WebSocketChannelInitializer
 * @Description TODO
 * @Author 黄育佳
 * @Date 2020/4/4 21:25
 * @Version 1.0
 **/
public class WebSocketChannelInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        pipeline.addLast(new HttpServerCodec());
        // 以块的方式写的处理器
        pipeline.addLast(new ChunkedWriteHandler());
        // netty对与请求采取分块或者分段的形式,HttpObjectAggregator能聚合分段或者分块成一个完整的http请求或http响应.
        // HttpObjectAggregator:对HttpMessage和HttpContent进行聚合,聚合到FullHttpRequest或FullHttpResponse
        pipeline.addLast(new HttpObjectAggregator(8192));
        // websocket处理器
        pipeline.addLast(new WebSocketServerProtocolHandler("/ws"));
        pipeline.addLast(new TextWebSocketFrameHandler());
    }
}

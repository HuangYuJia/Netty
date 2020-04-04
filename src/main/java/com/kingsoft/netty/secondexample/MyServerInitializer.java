package com.kingsoft.netty.secondexample;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;

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
        // 解码器
        pipeline.addLast("lengthFieldBasedFrameDecoder", new LengthFieldBasedFrameDecoder(Integer.MAX_VALUE, 0, 4, 0, 4));
        // 编码器
        pipeline.addLast("lengthFieldPrepender", new LengthFieldPrepender(4));
        // 字符串解码
        pipeline.addLast("stringDecoder",new StringDecoder(CharsetUtil.UTF_8));
        // 字符串编码
        pipeline.addLast("stringEncoder", new StringEncoder(CharsetUtil.UTF_8));
        // 自定义处理器
        pipeline.addLast("myServerHandler", new MyServerHandler());
    }
}

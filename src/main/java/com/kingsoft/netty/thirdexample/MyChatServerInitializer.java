package com.kingsoft.netty.thirdexample;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
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


public class MyChatServerInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        // 根据一定的分隔符对消息进行解码
        pipeline.addLast(new DelimiterBasedFrameDecoder(4096, Delimiters.lineDelimiter()));
        // 字符串解码
        pipeline.addLast("stringDecoder",new StringDecoder(CharsetUtil.UTF_8));
        // 字符串编码
        pipeline.addLast("stringEncoder", new StringEncoder(CharsetUtil.UTF_8));
        // 自定义处理器
        pipeline.addLast("myServerHandler", new MyChatServerHandler());
    }
}

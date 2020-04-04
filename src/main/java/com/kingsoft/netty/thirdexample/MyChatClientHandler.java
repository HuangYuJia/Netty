package com.kingsoft.netty.thirdexample;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @ClassName MyChatClientHandler
 * @Description TODO
 * @Author 黄育佳
 * @Date 2020/4/4 20:00
 * @Version 1.0
 **/
public class MyChatClientHandler extends SimpleChannelInboundHandler<String> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        System.out.println(msg);
    }
}

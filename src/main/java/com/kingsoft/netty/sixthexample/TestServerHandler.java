package com.kingsoft.netty.sixthexample;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;


/**
 * @ClassName TestHttpServerHandler
 * @Description TODO
 * @Author 黄育佳
 * @Date 2020/4/4 13:26
 * @Version 1.0
 **/

/**
 * 定义了客户端和服务端之间相互传输的是字符串数据
 */
public class TestServerHandler extends SimpleChannelInboundHandler<MyDataInfo.Person> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MyDataInfo.Person msg) throws Exception {
        System.out.println(msg.getName());
        System.out.println(msg.getAge());
        System.out.println(msg.getAddress());
    }
}

package com.kingsoft.netty.sixthexample;


import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @ClassName MyClientHandler
 * @Description TODO
 * @Author 黄育佳
 * @Date 2020/4/4 16:35
 * @Version 1.0
 **/
public class TestClientHandler extends SimpleChannelInboundHandler<MyDataInfo.Person> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MyDataInfo.Person msg) throws Exception {

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        MyDataInfo.Person person = MyDataInfo.Person.newBuilder().setName("张三").setAddress("北京").setAge(18).build();
        ctx.channel().writeAndFlush(person);
    }

}

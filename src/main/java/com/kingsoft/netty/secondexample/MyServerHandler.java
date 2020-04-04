package com.kingsoft.netty.secondexample;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import java.util.UUID;


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
public class MyServerHandler extends SimpleChannelInboundHandler<String> {

    /**
     * @param ctx 上下文
     * @param msg 请求消息
     * @throws Exception
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        System.out.println(ctx.channel().remoteAddress() + "," + msg);
        ctx.channel().writeAndFlush("from server:" + UUID.randomUUID());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();  // 把连接关闭
    }
}

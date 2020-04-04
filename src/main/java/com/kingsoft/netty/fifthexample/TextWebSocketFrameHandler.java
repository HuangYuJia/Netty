package com.kingsoft.netty.fifthexample;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;

import java.time.LocalDateTime;

/**
 * @ClassName TextWebSocketFrameHandler
 * @Description TODO
 * @Author 黄育佳
 * @Date 2020/4/4 23:57
 * @Version 1.0
 **/

/**
 - WebSocketFrame有六种帧
 - BinaryWebSocketFrame         二进制
 - CloseWebSocketFrame          关闭
 - ContinuationWebSocketFrame   还会有数据,相同的一次请求
 - PingWebSocketFrame           心跳
 - PongWebSocketFrame           返回心跳
 - TextWebSocketFrame           普通文本
 */
public class TextWebSocketFrameHandler extends SimpleChannelInboundHandler<TextWebSocketFrame>{
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) throws Exception {
        System.out.println("收到消息:" + msg.text());
        // writeAndFlush()参数:根据特定的协议和处理器来定义真正传输的数据类型
        ctx.channel().writeAndFlush(new TextWebSocketFrame(("服务器时间:" + LocalDateTime.now())));
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        System.out.println("handlerAdded: " + ctx.channel().id().asLongText());
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        System.out.println("handlerRemoved: " + ctx.channel().id().asLongText());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("发生异常");
        ctx.close();
    }
}

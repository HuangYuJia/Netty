package com.kingsoft.netty.sixthexample;


import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Random;

/**
 * @ClassName MyClientHandler
 * @Description TODO
 * @Author 黄育佳
 * @Date 2020/4/4 16:35
 * @Version 1.0
 **/
/*
解决protobuf多协议
1.netty自定义协议的方式
2.采用本案例这种方式  oneof 并不会浪费内存,最多出现一个类型
 */
public class TestClientHandler extends SimpleChannelInboundHandler<MyDataInfo.MyMessage> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MyDataInfo.MyMessage msg) throws Exception {

    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        int randomInt = new Random().nextInt(3);
        MyDataInfo.MyMessage myMessage = null;

        if(0 == randomInt){
            myMessage = MyDataInfo.MyMessage.newBuilder().setDataType(MyDataInfo.MyMessage.DataType.PersonType)
                    .setPerson(MyDataInfo.Person.newBuilder().setName("张三").setAddress("北京").setAge(18).build()).build();
        }else if(1 == randomInt){
            myMessage = MyDataInfo.MyMessage.newBuilder().setDataType(MyDataInfo.MyMessage.DataType.DogType)
                    .setDog(MyDataInfo.Dog.newBuilder().setName("旺财").setAction("汪汪").build()).build();
        }else{
            myMessage = MyDataInfo.MyMessage.newBuilder().setDataType(MyDataInfo.MyMessage.DataType.HouseType)
                    .setHouse(MyDataInfo.House.newBuilder().setName("白宫").setCity("纽约").build()).build();
        }

        ctx.channel().writeAndFlush(myMessage);
    }

}

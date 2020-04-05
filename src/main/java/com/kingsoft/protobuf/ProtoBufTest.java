package com.kingsoft.protobuf;

/**
 * @ClassName ProtoBufTest
 * @Description TODO
 * @Author 黄育佳
 * @Date 2020/4/5 15:43
 * @Version 1.0
 **/
public class ProtoBufTest {

    public static void main(String[] args) throws Exception {
        // 1.构造Java对象
        DataInfo.Student student = DataInfo.Student.newBuilder().setName("张三").setAge(20).setAddress("北京").build();
        // 2.把Java对象转为字节数组   (字节数组:能在网络中传输)
        byte[] student2ByteArray = student.toByteArray();
        // 3.解析字节数组为Java对象
        DataInfo.Student student2 = DataInfo.Student.parseFrom(student2ByteArray);

        System.out.println(student2.toString());

        System.out.println(student2.getName());
        System.out.println(student2.getAge());
        System.out.println(student2.getAddress());
    }
}

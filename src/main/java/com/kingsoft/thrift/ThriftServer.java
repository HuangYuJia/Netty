package com.kingsoft.thrift;

import org.apache.thrift.TProcessorFactory;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.server.THsHaServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TNonblockingServerSocket;
import thrift.generated.PersonService;

/**
 * @ClassName ThriftServer
 * @Description TODO
 * @Author 黄育佳
 * @Date 2020/4/6 1:01
 * @Version 1.0
 **/
public class ThriftServer {
    public static void main(String[] args) throws Exception {
        // 异步非阻塞TNonblockingServerSocket
        TNonblockingServerSocket socket = new TNonblockingServerSocket(8899);
        THsHaServer.Args arg = new THsHaServer.Args(socket).minWorkerThreads(2).maxWorkerThreads(4);
        PersonService.Processor<PersonServiceImpl> processor = new PersonService.Processor<>(new PersonServiceImpl());  // 处理器
        arg.protocolFactory(new TCompactProtocol.Factory());  // 协议层
        arg.transportFactory(new TFramedTransport.Factory());  // 传输层 以frame为单位进行传输,非阻塞式服务中使用
        arg.processorFactory(new TProcessorFactory(processor));
        TServer server = new THsHaServer(arg);   // THsHaServer 半同步半异步
        System.out.println("Thrift Server Started");
        server.serve();
    }
}

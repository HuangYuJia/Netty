## netty
- https://search.maven.org/

- netty is asynchronous event-driven network application framework
- netty 异步 事件驱动 网络应用框架
- netty:  Core、 Transport Services、 Protocol Support
- netty  废弃 5.x    使用 4.x
- org.jboss.netty   3.x
- io.netty          4.x

- rpc框架 google protobuf(Protocol Buffers)   语言中立平台中立,对结构化数据进行序列化可扩展的机制
- Protocol Buffers:java python c 可以互相调用
- rpc调用 : 客户端先序列化 通过网络的形式给服务器端 服务器端反序列化  映射到服务器端中对应的结构中 完成代码的调用逻辑
- rpc框架都会根据特定的数据文件来生成stub,skeleton代码供程序员使用   网络数据传输  客户端生成的基础代码(stub)   服务器端生成的基础代码 (skeleton)

- rpc框架 apache thrift

- http1.1(keep-alive机制,一定程度上解决短链接的问题) 长链接(一段时间内有请求就使用原来的链接,否则新建立链接) 
- http1.0 短链接 无状态 基于请求响应(客户端主动发出数据 服务器段不可能主动发出数据)  必须传递header等信息
- websocket长链接,即时通讯(聊天)允许只传递数据本身而不需要传递header等,极大程度上降低数据传输的压力(主动关闭双方是能感知的)  
- (非主动)心跳检测,定期时间内没有心跳包,就会主动释放掉socket链接

- netty:
- 1.netty可以作为rpc通信的框架,实现远程调用,基于socket
- 2.长连接的服务器,基于websocket
- 3.http服务器,不是基于servlet规范

- C:\Users\黄育佳\.gradle\caches\modules-2\files-2.1\io.netty\netty-all\4.1.10.Final

- netty客户端请求完成后通过判断是http1.1(长链接keep-alive时间长度)或者1.0(短连接)来控制服务器和客户端断开

- WebSocketFrame有六种帧
- BinaryWebSocketFrame  二进制
- CloseWebSocketFrame   关闭
- ContinuationWebSocketFrame 还会有数据,相同的一次请求
- PingWebSocketFrame  心跳
- PongWebSocketFrame  返回心跳
- TextWebSocketFrame  普通文本

- websocket一旦建立上,整个请求和响应都是在已经存在的websocket长连接之上进行的,这个和http的区别是非常大的
- 注意:开飞行模式或者非正常退出,客户端和服务器端之前的连接是感知不到断掉的...(通过心跳包来解决这一问题)
- websocket注意事项：页面刷新长连接会被关闭,其实进入当前页面建立长连接的目的就是页面不需要用F5来刷新,所有数据自动实时刷新,如果还是用F5刷页面那就没有意义了
- google protobuf 用来进行rpc的数据传输,是一种自定的协议,以更小的体积对数据进行编码解码(序列化和反序列化)
- EJB 标准大量使用的技术 rmi remote method invocation远程方法调用,只针对Java
- RPC remote procedure call 远程过程调用,很多RPC框架是跨语言的

PRC传输基于socket WebServlet基于http
决定一个PRC框架的性能强与弱的因素有:1.编解码效率 2.socket传输
- RPC编写模式:
- 1.定义一个接口说明文件;描述了对象(结构体),对象成员,接口方法等一系列信息
- 2.通过RPC框架所提供的编译器,将接口说明文件编译成具体语言文件
- 3.在客户端与服务器端分别引入RPC编译器所生成的文件,即可像调用本地方法一样调用远程方法


- rpc框架 google protobuf(Protocol Buffers)是一种语言中立平台中立,对结构化数据进行序列化可扩展的机制
- netty对与google protobuf提供了原生的非常强大的支持,使得我们可以通过netty非常轻松的将google protobuf集成进来,因为编解码相关的事netty都已经做好了

- google protobuf 使用
- https://developers.google.com/protocol-buffers
- https://github.com/protocolbuffers/protobuf/releases/tag/v3.3.0
- https://developers.google.com/protocol-buffers/docs/javatutorial
- https://developers.google.com/protocol-buffers/docs/proto


package com.kingsoft.thrift;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import thrift.generated.Person;
import thrift.generated.PersonService;

/**
 * @ClassName ThriftClient
 * @Description TODO
 * @Author 黄育佳
 * @Date 2020/4/6 1:08
 * @Version 1.0
 **/
public class ThriftClient {
    public static void main(String[] args) {
        TTransport transport = new TFramedTransport(new TSocket("localhost", 8899), 600);
        TProtocol protocol = new TCompactProtocol(transport);
        PersonService.Client client = new PersonService.Client(protocol);

        try {
            transport.open();
            Person person = client.getPersonByUsername("张三");
            System.out.println(person.getUsername());
            System.out.println(person.getAge());
            System.out.println(person.isMarried());
            System.out.println("~~~~~~~~~");

            Person person1 = new Person();
            person1.setMarried(true);
            person1.setUsername("huangyjia");
            person1.setAge(25);
            client.savePerson(person1);
        } catch (TException e) {
            throw new RuntimeException(e.getMessage(), e);
        } finally {
            transport.close();
        }
    }
}

package com.guo.dubboprovider;


import com.guo.dubbo.ISayHelloService;
import org.apache.dubbo.config.annotation.Service;

@Service(loadbalance = "random",timeout = 50000,cluster = "failsafe")
public class SayHelloServiceImpl implements ISayHelloService {

    @Override
    public String sayHello() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Come in SayHello()");
        return "Hello Dubbo";
    }
}

package com.guo.dubboclient;


import com.guo.dubbo.ISayHelloService;

/**
 * 降级处理的类
 */
public class SayHelloServiceMock implements ISayHelloService {
    @Override
    public String sayHello() {
        return "服务端发生异常， 被降解了。返回兜底数据。。。";
    }
}

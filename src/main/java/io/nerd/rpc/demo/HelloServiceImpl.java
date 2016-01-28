package io.nerd.rpc.demo;

import io.nerd.rpc.core.annotation.RpcExport;

import java.util.concurrent.TimeUnit;

/**
 * HelloServiceImpl
 * 
 * @author chenjianhua
 */
@RpcExport(HelloService.class)
public class HelloServiceImpl implements HelloService {

    public String sayHello(String name) {

        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Hello, " + name;
    }

}

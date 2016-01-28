package io.nerd.rpc.demo;

import io.nerd.rpc.core.RpcFramework;

/**
 * RpcConsumer
 * 
 * @author chenjianhua
 */
public class RpcConsumer {
    
    public static void main(String[] args) throws Exception {
        HelloService service = RpcFramework.refer(HelloService.class, "127.0.0.1", 8000);
        for (int i = 0; i < 1000; i ++) {
            String hello = service.sayHello("World - " + i);
            System.out.println(hello);
        }
    }
    
}

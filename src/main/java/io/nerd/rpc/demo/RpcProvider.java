package io.nerd.rpc.demo;

import io.nerd.rpc.core.RpcFramework;

/**
 * RpcProvider
 * 
 * @author chenjianhua
 *
 */
public class RpcProvider {

    public static void main(String[] args) throws Exception {
        HelloService service = new HelloServiceImpl();
        RpcFramework.export(service, 8000);
    }
}

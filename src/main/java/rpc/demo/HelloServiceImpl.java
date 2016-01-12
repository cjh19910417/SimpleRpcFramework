package rpc.demo;

import java.util.concurrent.TimeUnit;

/**
 * HelloServiceImpl
 * 
 * @author chenjianhua
 */
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

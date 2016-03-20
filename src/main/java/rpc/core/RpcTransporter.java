package rpc.core;

import java.net.URL;

/**
 * Created by Jian on 16/1/13.
 */
public interface RpcTransporter {

    void connect(URL url);

    void bind(URL url);

}

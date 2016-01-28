package io.nerd.rpc.core.remoting.zookeeper;


import io.nerd.rpc.core.common.URL;

public interface ZookeeperTransporter {

	ZookeeperClient connect(URL url);

}

package io.nerd.rpc.core.remoting.zookeeper.curator;

import io.nerd.rpc.core.common.URL;
import io.nerd.rpc.core.remoting.zookeeper.ZookeeperClient;
import io.nerd.rpc.core.remoting.zookeeper.ZookeeperTransporter;

public class CuratorZookeeperTransporter implements ZookeeperTransporter {

	public ZookeeperClient connect(URL url) {
		return new CuratorZookeeperClient(url);
	}

}

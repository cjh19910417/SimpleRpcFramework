package io.nerd.rpc.core.remoting.zookeeper.zkclient;

import io.nerd.rpc.core.common.URL;
import io.nerd.rpc.core.remoting.zookeeper.ZookeeperClient;
import io.nerd.rpc.core.remoting.zookeeper.ZookeeperTransporter;

public class ZkclientZookeeperTransporter implements ZookeeperTransporter {

	public ZookeeperClient connect(URL url) {
		return new ZkclientZookeeperClient(url);
	}

}

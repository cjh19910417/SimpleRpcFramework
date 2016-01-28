package io.nerd.rpc.core.registry.zookeeper;


import io.nerd.rpc.core.common.URL;
import io.nerd.rpc.core.registry.api.Registry;
import io.nerd.rpc.core.registry.api.support.AbstractRegistryFactory;
import io.nerd.rpc.core.remoting.zookeeper.ZookeeperTransporter;

/**
 * ZookeeperRegistryFactory.
 * 
 */
public class ZookeeperRegistryFactory extends AbstractRegistryFactory {
	
	private ZookeeperTransporter zookeeperTransporter;

    public void setZookeeperTransporter(ZookeeperTransporter zookeeperTransporter) {
		this.zookeeperTransporter = zookeeperTransporter;
	}

	public Registry createRegistry(URL url) {
        return new ZookeeperRegistry(url, zookeeperTransporter);
    }

}
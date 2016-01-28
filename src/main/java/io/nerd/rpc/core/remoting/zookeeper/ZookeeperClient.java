package io.nerd.rpc.core.remoting.zookeeper;

import io.nerd.rpc.core.common.URL;

import java.util.List;

public interface ZookeeperClient {

	/**
	 * 创建path
	 * @param path
	 * @param ephemeral 是否为朝生暮死的
	 */
	void create(String path, boolean ephemeral);

	void delete(String path);

	List<String> getChildren(String path);

	List<String> addChildListener(String path, ChildListener listener);

	void removeChildListener(String path, ChildListener listener);

	void addStateListener(StateListener listener);
	
	void removeStateListener(StateListener listener);

	boolean isConnected();

	void close();

	URL getUrl();

}

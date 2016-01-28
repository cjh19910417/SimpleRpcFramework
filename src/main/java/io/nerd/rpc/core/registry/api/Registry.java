package io.nerd.rpc.core.registry.api;

import io.nerd.rpc.core.common.Node;
import io.nerd.rpc.core.common.URL;

/**
 * Registry. (SPI, Prototype, ThreadSafe)
 * 
 * @see io.nerd.rpc.core.registry.api.RegistryFactory#getRegistry(URL)
 * @see io.nerd.rpc.core.registry.api.support.AbstractRegistry
 */
public interface Registry extends Node, RegistryService {
}
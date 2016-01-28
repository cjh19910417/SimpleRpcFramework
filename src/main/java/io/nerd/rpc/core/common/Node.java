package io.nerd.rpc.core.common;

/**
 * Node. (API/SPI, Prototype, ThreadSafe)
 * 
 */
public interface Node {

    /**
     * get url.
     * 
     * @return url.
     */
    URL getUrl();
    
    /**
     * is available.
     * 
     * @return available.
     */
    boolean isAvailable();

    /**
     * destroy.
     */
    void destroy();

}
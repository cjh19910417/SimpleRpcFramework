package io.nerd.rpc.core.registry.api.support;

/**
 * Wrapper异常，用于指示 {@link FailbackRegistry}跳过Failback。
 * <p>
 * NOTE: 期望找到其它更常规的指示方式。
 *
 * @see FailbackRegistry
 */
public class SkipFailbackWrapperException extends RuntimeException {
    public SkipFailbackWrapperException(Throwable cause) {
        super(cause);
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        // do nothing
        return null;
    }
}

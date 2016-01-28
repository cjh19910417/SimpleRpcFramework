
package io.nerd.rpc.core.common.utils;

/**
 */
public abstract class Assert {

    protected Assert() {}

    public static void notNull(Object obj, String message) {
        if (obj == null) {
            throw new IllegalArgumentException(message);
        }
    }

}

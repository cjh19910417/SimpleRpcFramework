package io.nerd.rpc.core.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Decription:
 * Created on 2016/1/27 0027
 *
 * @author chenjianhua
 */
@Target(value = {ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Component
public @interface RpcExport {
    Class<?> value();
}

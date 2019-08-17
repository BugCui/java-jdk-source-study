/*
 * Copyright (c) 2010, 2013, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */
package java.util.function;

import java.util.Objects;

/**
 *  表示接受单个输入参数而不返回结果的操作。与大多数其他功能接口不同，(@code Consumer)预期通过副作用进行操作。
 *
 * @param <T> the type of the input to the operation
 *
 * @since 1.8
 */
@FunctionalInterface
public interface Consumer<T> {

    /**
     * 对给定的参数执行此操作。
     *
     * @param t the input argument
     */
    void accept(T t);

    /**
     *返回一个组合(@code Consumer)，该组合(@code Consumer)按顺序执行此操作，然后执行(@code after)操作。
     * 如果执行任何一个操作都会引发异常，则会将异常转发给组合操作的调用者。
     * 如果执行此操作引发异常，则不会执行(@code after)操作。
     * @param after the operation to perform after this operation
     * @return a composed {@code Consumer} that performs in sequence this
     * operation followed by the {@code after} operation
     * @throws NullPointerException if {@code after} is null
     */
    default Consumer<T> andThen(Consumer<? super T> after) {
        Objects.requireNonNull(after);
        return (T t) -> { accept(t); after.accept(t); };
    }
}

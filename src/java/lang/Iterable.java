/*
 * Copyright (c) 2003, 2013, Oracle and/or its affiliates. All rights reserved.
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
package java.lang;

import java.util.Iterator;
import java.util.Objects;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Consumer;

/**
 * 实现这个接口的类允许使用for..each循环
 *
 * @param <T> 通过iterator返回元素的迭代类型
 *
 * @since 1.5
 * @jls 14.14.2 The enhanced for statement
 */
public interface Iterable<T> {
    /**
     * 返回类型为{@code T}的元素的迭代器。
     *
     * @return an Iterator.
     */
    Iterator<T> iterator();

    /**
     *为{@code Iterable}的每个元素执行给定的操作，直到处理完所有元素或操作引发异常为止。
     * 除非实现类另有指定，否则操作将按迭代顺序执行(如果指定了迭代顺序)。
     * 操作引发的异常将转发到调用者.
     *
     * @param action The action to be performed for each element
     * @throws NullPointerException if the specified action is null
     * @since 1.8
     */
    default void forEach(Consumer<? super T> action) {
        Objects.requireNonNull(action);
        for (T t : this) {
            action.accept(t);
        }
    }

    /**
     *在Iterable描述的元素上创建一个Iterable 。
     * 实现要求：
     * 默认实现从iterable的Iterator创建一个early-binding拼接器。 Spliter继承了iterable的迭代器的fail-fast属性
     *
     * @return a {@code Spliterator} over the elements described by this
     * {@code Iterable}.
     * @since 1.8
     */
    default Spliterator<T> spliterator() {
        return Spliterators.spliteratorUnknownSize(iterator(), 0);
    }
}

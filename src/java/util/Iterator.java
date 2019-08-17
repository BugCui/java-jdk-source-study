/*
 * Copyright (c) 1997, 2013, Oracle and/or its affiliates. All rights reserved.
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

package java.util;

import java.util.function.Consumer;

/**
 *集合上的迭代器。{@code Iterator}代替
 * Java集合框架中的* {@link枚举}。迭代器
 * 与枚举有两方面的不同:
 *      1. 迭代器允许在迭代期间移除元素.
 *      2. 方法名得到了改进, 更加短了.
 *
 *  这个接口是Java Collections Framework的成员.
 *
 * @param <E> the type of elements returned by this iterator
 *
 * @author  Josh Bloch
 * @see Collection
 * @see ListIterator
 * @see Iterable
 * @since 1.2
 */
public interface Iterator<E> {
    /**
     *  返回是否有下一个元素
     * @return {@code true} if the iteration has more elements
     */
    boolean hasNext();

    /**
     * 返回下一个元素
     *
     * @throws NoSuchElementException if the iteration has no more elements
     */
    E next();

    /**
     *从基础集合中移除此迭代器返回的最后一个元素(可选操作)。
     * 此方法只能在每次调用(@link #next)时调用一次。
     * 如果底层集合在迭代过程中被修改，迭代器的行为是未指定的，除非调用这个方法.
     */
    default void remove() {
        throw new UnsupportedOperationException("remove");
    }

    /**
     * 为每个剩余元素执行给定的操作，直到处理完所有元素或操作引发异常为止。
     * 操作按照迭代的顺序执行，如果该顺序是指定的，则操作引发的异常将传递给调用者。
     * @param action The action to be performed for each element
     * @throws NullPointerException if the specified action is null
     * @since 1.8
     */
    default void forEachRemaining(Consumer<? super E> action) {
        Objects.requireNonNull(action);
        while (hasNext())
            action.accept(next());
    }
}

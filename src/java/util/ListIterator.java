/*
 * Copyright (c) 1997, 2011, Oracle and/or its affiliates. All rights reserved.
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

/**
 * 根据官方文档介绍, ListIterator 有以下功能：
 * 允许我们向前、向后两个方向遍历 List;
 * 在遍历时修改 List 的元素；
 * 遍历时获取迭代器当前游标所在位置。
 * 注意，迭代器 没有当前所在元素一说，它只有一个游标( cursor )的概念，这个游标总是在元素之间，如下:
 * <PRE>
 *                      Element(0)   Element(1)   Element(2)   ... Element(n-1)
 * cursor positions:  ^            ^            ^            ^                  ^
 * @author  Josh Bloch
 * @see Collection
 * @see List
 * @see Iterator
 * @see Enumeration
 * @see List#listIterator()
 * @since   1.2
 */
public interface ListIterator<E> extends Iterator<E> {
    // Query Operations

    /**
     *判断游标后面是否有元素
     */
    boolean hasNext();

    /**
     *  返回游标下一个元素,同时游标后移一位
     * @return the next element in the list
     * @throws NoSuchElementException if the iteration has no next element
     */
    E next();

    /**
     * 判断游标前面是否有元素;
     */
    boolean hasPrevious();

    /**
     * 返回游标前面的元素，同时游标前移一位。游标前没有元素就报 异常
     * @return the previous element in the list
     * @throws NoSuchElementException if the iteration has no previous
     *         element
     */
    E previous();

    /**
     *返回游标后边元素的索引位置，初始为 0 ；遍历 N 个元素结束时为 N;
     */
    int nextIndex();

    /**
     * 返回游标前面元素的位置，初始时为 -1，同时报 java.util.NoSuchElementException 错;
     */
    int previousIndex();


    // Modification Operations

    /**
     * 删除迭代器最后一次操作的元素，注意事项和 set 一样。
     */
    void remove();

    /**
     更新迭代器最后一次操作的元素为 E，也就是更新最后一次调用 next() 或者 previous() 返回的元素。
     注意，当没有迭代，也就是没有调用 next() 或者 previous() 直接调用 set 时会报 java.lang.IllegalStateException 错;
     */
    void set(E e);

    /**
     * 在游标 前面 插入一个元素
     * 注意，是前面
     */
    void add(E e);
}

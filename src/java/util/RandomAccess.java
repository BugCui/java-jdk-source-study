/*
 * Copyright (c) 2000, 2006, Oracle and/or its affiliates. All rights reserved.
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
 *
 * RandomAccess 是一个空的接口，它用来标识某个类是否支持 随机访问（随机访问，相对比“按顺序访问”）。
 * 一个支持随机访问的类明显可以使用更加高效的算法。
 *实现了 RandomAccess 接口的类有：
 * ArrayList, AttributeList, CopyOnWriteArrayList, Vector, Stack 等。
 *
 *
 * @since 1.4
 */
public interface RandomAccess {
}

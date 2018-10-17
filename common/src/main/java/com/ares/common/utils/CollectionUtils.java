package com.ares.common.utils;

import java.util.*;

/**
 * 集合工具类
 *
 * @author 0xZzzz
 */
@SuppressWarnings("unchecked")
public class CollectionUtils {

    /**
     * 判断collection是否为空
     */
    public static boolean isEmpty(Collection collection) {
        return collection == null || collection.isEmpty();
    }

    /**
     * 判断map是否为空
     *
     * @param map map
     * @return true：空，false：非空
     */
    public static boolean isEmpty(Map map) {
        return map == null || map.isEmpty();
    }

    /**
     * 将list转换成HashSet，注意会丢掉重复值
     *
     * @param list list集合
     * @return HashSet集合
     */
    public static <E> Set<E> transferListToHashSet(List<E> list) {
        return new HashSet<>(list);
    }

    /**
     * 将set转换成ArrayList
     *
     * @param set set集合
     * @return ArrayList集合
     */
    public static List transferSetToArrayList(Set set) {
        return new ArrayList(set);
    }

    /**
     * 获取集合的第一个元素，empty返回null
     *
     * @param list 集合
     * @param <T>  泛型
     * @return 集合的第一个元素
     */
    public static <T> T firstJudgeEmpty(List<T> list) {
        if (isEmpty(list)) return null;
        return first(list);
    }

    /**
     * @param list 集合
     * @param <T>  泛型
     * @return 集合的第一个元素
     */
    public static <T> T first(List<T> list) {
        return list.get(0);
    }

    /**
     * 获取Collection中的任何一个元素
     */
    public static <T> T any(Collection<T> list) {
        return list.iterator().next();
    }

    /**
     * @param list 集合
     * @param <T>  泛型
     * @return 集合的最后一个元素
     */
    public static <T> T last(List<T> list) {
        return list.get(list.size() - 1);
    }

    /**
     * 将对象添加到集合返回
     */
    public static <T> List<T> asArrayList(T t) {
        List<T> list = new ArrayList<>();
        list.add(t);
        return list;
    }

}

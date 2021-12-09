package com.ares.service.datasource.routing.datasource;

/**
 * 数据源 holder
 *
 * @author fansheng
 * @date 2021/11/17
 */
public class DataSourceHolder {

    /**
     * 数据源名称
     */
    public static final ThreadLocal<String> HOLDER = new ThreadLocal<String>();

    /**
     * 设置当前需要使用的数据源名称
     */
    public static void put(String datasource) {
        HOLDER.set(datasource);
    }

    /**
     * 获取数据源名称
     */
    public static String get() {
        return HOLDER.get();
    }

    /**
     * 重置
     */
    public static void reset() {
        HOLDER.remove();
    }
}

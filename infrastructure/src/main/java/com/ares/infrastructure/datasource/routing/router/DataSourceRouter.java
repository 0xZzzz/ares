package com.ares.infrastructure.datasource.routing.router;

import java.lang.reflect.Method;

/**
 * 数据源路由
 *
 * @author fansheng
 * @date 2021/11/25
 */
public interface DataSourceRouter {

    /**
     * 路由数据源
     *
     * @param method 路由方法
     * @return 是否路由成功
     */
    boolean route(Method method);

}

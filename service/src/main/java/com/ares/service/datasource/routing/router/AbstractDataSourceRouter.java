package com.ares.service.datasource.routing.router;


import com.ares.service.datasource.routing.configuration.DbRoutingProperties;

import java.lang.reflect.Method;

/**
 * 数据源路由基类
 *
 * @author fansheng
 * @date 2021/11/25
 */
public abstract class AbstractDataSourceRouter implements DataSourceRouter {

    /**
     * next router
     */
    private final DataSourceRouter next;

    /**
     * routing properties
     */
    protected final DbRoutingProperties properties;

    public AbstractDataSourceRouter(DataSourceRouter next, DbRoutingProperties properties) {
        this.next = next;
        this.properties = properties;
    }

    @Override
    public boolean route(Method method) {
        if (doRoute(method)) {
            return true;
        }
        return next.route(method);
    }

    /**
     * 路由数据源动作
     *
     * @param method 路由方法
     * @return 是否路由成功
     */
    protected abstract boolean doRoute(Method method);

}

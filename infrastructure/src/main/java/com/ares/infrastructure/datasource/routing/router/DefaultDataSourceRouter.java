package com.ares.infrastructure.datasource.routing.router;


import com.ares.infrastructure.datasource.routing.constant.DataSourceKey;
import com.ares.infrastructure.datasource.routing.datasource.DataSourceHolder;
import com.ares.infrastructure.datasource.routing.configuration.DbRoutingProperties;

import java.lang.reflect.Method;

/**
 * 默认路由主库
 *
 * @author fansheng
 * @date 2021/11/25
 */
public class DefaultDataSourceRouter extends AbstractDataSourceRouter {

    /**
     * 获取默认路由实例
     */
    public static DefaultDataSourceRouter getInstance(DbRoutingProperties properties) {
        // 默认路由不设置下一个节点
        return new DefaultDataSourceRouter(null, properties);
    }

    public DefaultDataSourceRouter(DataSourceRouter next, DbRoutingProperties properties) {
        super(next, properties);
    }

    @Override
    protected boolean doRoute(Method method) {
        DataSourceHolder.put(DataSourceKey.MASTER);
        return true;
    }
}

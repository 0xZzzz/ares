package com.ares.infrastructure.datasource.routing.router;


import com.ares.infrastructure.datasource.routing.configuration.DbRoutingProperties;

import java.lang.reflect.Method;

/**
 * 数据源路由责任链
 *
 * @author fansheng
 * @date 2021/11/25
 */
public class DataSourceRouterChain implements DataSourceRouter {

    /**
     * 链条开始节点
     */
    private final DataSourceRouter first;

    public DataSourceRouterChain(DbRoutingProperties properties) {
        /*
         * 优先级：注解匹配 > 方法名称匹配 > 方法前缀匹配 > 默认路由
         */
        DataSourceRouter defaultRouter = DefaultDataSourceRouter.getInstance(properties);
        DataSourceRouter methodPrefixRouter = new MethodPrefixRouter(defaultRouter, properties);
        DataSourceRouter methodNameRouter = new MethodNameRouter(methodPrefixRouter, properties);
        first = new AnnotationRouter(methodNameRouter, properties);
    }

    @Override
    public boolean route(Method method) {
        return first.route(method);
    }

}

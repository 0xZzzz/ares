package com.ares.infrastructure.datasource.routing.interceptor;

import com.ares.infrastructure.datasource.routing.datasource.DataSourceHolder;
import com.ares.infrastructure.datasource.routing.router.DataSourceRouter;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * 数据访问拦截，切换数据源
 *
 * @author fansheng
 * @date 2021/11/17
 */
public class DataAccessInterceptor implements MethodInterceptor {

    /**
     * 数据源路由
     */
    private final DataSourceRouter router;

    public DataAccessInterceptor(DataSourceRouter router) {
        this.router = router;
    }

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        try {
            setDataSourceKey(methodInvocation);
            return methodInvocation.proceed();
        } finally {
            DataSourceHolder.reset();
        }
    }

    /**
     * 设置数据源 key
     */
    private void setDataSourceKey(MethodInvocation invocation) {
        router.route(invocation.getMethod());
    }

}

package com.ares.service.datasource.routing.router;

import com.ares.service.datasource.routing.annotation.Master;
import com.ares.service.datasource.routing.annotation.Slave;
import com.ares.service.datasource.routing.configuration.DbRoutingProperties;
import com.ares.service.datasource.routing.constant.DataSourceKey;
import com.ares.service.datasource.routing.datasource.DataSourceHolder;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 注解路由
 *
 * @author fansheng
 * @date 2021/11/25
 */
@Component
public class AnnotationRouter extends AbstractDataSourceRouter {

    public AnnotationRouter(DataSourceRouter next, DbRoutingProperties properties) {
        super(next, properties);
    }

    @Override
    public boolean doRoute(Method method) {
        Master master = method.getAnnotation(Master.class);
        if (master != null) {
            DataSourceHolder.put(DataSourceKey.MASTER);
            return true;
        }
        Slave slave = method.getAnnotation(Slave.class);
        if (slave != null) {
            DataSourceHolder.put(DataSourceKey.SLAVE);
            return true;
        }
        return false;
    }

}

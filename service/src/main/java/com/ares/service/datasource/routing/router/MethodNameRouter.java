package com.ares.service.datasource.routing.router;

import com.ares.service.datasource.routing.configuration.DbRoutingProperties;
import com.ares.service.datasource.routing.constant.DataSourceKey;
import com.ares.service.datasource.routing.datasource.DataSourceHolder;
import com.google.common.collect.Maps;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.ares.service.datasource.routing.constant.Separator.*;

/**
 * 方法名路由
 *
 * @author fansheng
 * @date 2021/11/25
 */
public class MethodNameRouter extends AbstractDataSourceRouter {

    /**
     * key: dao interface, value: dao method set
     */
    private static final Map<String, Set<String>> SLAVE_METHODS = Maps.newHashMap();

    public MethodNameRouter(DataSourceRouter next, DbRoutingProperties properties) {
        super(next, properties);
        if (properties != null && properties.getSlaveMethods() != null) {
            properties.getSlaveMethods().values()
                    .forEach(method -> Arrays.stream(method.split(ITEM_SEP)).forEach(kv -> {
                        String[] interface2methods = StringUtils.split(kv, KV_SEP);
                        SLAVE_METHODS.put(interface2methods[0].trim(),
                                Arrays.stream(StringUtils.split(interface2methods[1], METHOD_SEP))
                                        .map(StringUtils::trim).collect(Collectors.toSet()));
                    }));
        }
    }

    @Override
    public boolean doRoute(Method method) {
        String declaringClass = method.getDeclaringClass().getSimpleName();
        Set<String> slaveMethods = SLAVE_METHODS.get(declaringClass);
        if (CollectionUtils.isNotEmpty(slaveMethods) && slaveMethods.contains(method.getName())) {
            DataSourceHolder.put(DataSourceKey.SLAVE);
            return true;
        }
        return false;
    }

}

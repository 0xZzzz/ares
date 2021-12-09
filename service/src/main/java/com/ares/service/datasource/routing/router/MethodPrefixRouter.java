package com.ares.service.datasource.routing.router;

import com.ares.service.datasource.routing.configuration.DbRoutingProperties;
import com.ares.service.datasource.routing.datasource.DataSourceHolder;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.ares.service.datasource.routing.constant.Separator.*;

/**
 * 方法前缀路由
 *
 * @author fansheng
 * @date 2021/11/25
 */
@Component
public class MethodPrefixRouter extends AbstractDataSourceRouter {

    /**
     * key: datasource key, value: method prefix set
     */
    private static final Map<String, Set<String>> KEY_PREFIXES = Maps.newHashMap();

    public MethodPrefixRouter(DataSourceRouter next, DbRoutingProperties properties) {
        super(next, properties);
        if (properties != null && StringUtils.isNotBlank(properties.getMethodPrefix())) {
            Arrays.stream(StringUtils.split(properties.getMethodPrefix(), ITEM_SEP)).forEach(kv -> {
                String[] key2prefix = StringUtils.split(kv, KV_SEP);
                KEY_PREFIXES.put(key2prefix[0].trim(), Arrays.stream(StringUtils.split(key2prefix[1], METHOD_SEP))
                        .map(StringUtils::trim).collect(Collectors.toSet()));
            });
        }
    }

    @Override
    public boolean doRoute(Method method) {
        for (Map.Entry<String, Set<String>> entry : KEY_PREFIXES.entrySet()) {
            for (String prefix : entry.getValue()) {
                if (method.getName().startsWith(prefix)) {
                    DataSourceHolder.put(entry.getKey());
                    return true;
                }
            }
        }
        return false;
    }

}

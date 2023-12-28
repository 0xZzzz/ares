package com.ares.infrastructure.datasource.routing.datasource;

import com.google.common.collect.Maps;

import javax.sql.DataSource;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Function;

/**
 * {@link MasterSlaveDataSource} cache
 *
 * @author fansheng
 * @date 2021/11/23
 */
public class MasterSlaveDataSourceCache {

    /**
     * key: DataSource, value: {@link MasterSlaveDataSource} based on master datasource
     */
    private static final ConcurrentMap<DataSource, MasterSlaveDataSource> DATASOURCE_CACHE = Maps.newConcurrentMap();

    /**
     * 构建或返回数据源缓存
     */
    public static MasterSlaveDataSource computeIfAbsent(DataSource dataSource,
                                                        Function<DataSource, MasterSlaveDataSource> function) {
        return DATASOURCE_CACHE.computeIfAbsent(dataSource, function);
    }

}

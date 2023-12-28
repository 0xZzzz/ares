package com.ares.infrastructure.datasource.routing.datasource;

import com.ares.infrastructure.datasource.routing.constant.DataSourceKey;
import com.google.common.collect.Maps;
import lombok.Getter;
import lombok.ToString;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;
import java.util.Map;

/**
 * 主从路由数据源
 *
 * @author fansheng
 * @date 2021/11/17
 */
@Getter
@ToString
public class MasterSlaveDataSource extends AbstractRoutingDataSource {

    /**
     * 主
     */
    private final DataSource master;

    /**
     * 从
     */
    private final DataSource slave;

    public MasterSlaveDataSource(DataSource master, DataSource slave) {
        this.master = master;
        this.slave = slave;
        afterPropertiesSet();
    }

    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceHolder.get();
    }

    @Override
    public void afterPropertiesSet() {
        Map<Object, Object> dataSources = Maps.newHashMap();
        dataSources.put(DataSourceKey.MASTER, master);
        dataSources.put(DataSourceKey.SLAVE, slave);
        setTargetDataSources(dataSources);
        setDefaultTargetDataSource(master);
        super.afterPropertiesSet();
    }
}


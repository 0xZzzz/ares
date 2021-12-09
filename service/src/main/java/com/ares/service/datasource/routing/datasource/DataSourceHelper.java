package com.ares.service.datasource.routing.datasource;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.commons.lang3.StringUtils;

import javax.sql.DataSource;

/**
 * 数据源工具类
 *
 * @author fansheng
 * @date 2021/11/24
 */
public class DataSourceHelper {

    private static final String PROTOCOL = "jdbc:mysql://";

    /**
     * 数据源升级为主从数据源
     */
    public static MasterSlaveDataSource upgrade(DataSource master) {
        String masterUrl = getJdbcUrl(master);
        String slaveHost = getSlaveHost(extractHost(masterUrl));
        if (StringUtils.isBlank(slaveHost)) {
            return null;
        }
        return MasterSlaveDataSourceCache.computeIfAbsent(master,
                d -> upgrade((HikariDataSource) d, generateSlaveUrl(masterUrl, slaveHost)));
    }

    /**
     * 获取数据连接地址
     */
    private static String getJdbcUrl(DataSource dataSource) {
        if (!(dataSource instanceof HikariDataSource)) {
            throw new IllegalArgumentException("unsupported DataSource type " + dataSource.getClass().getName());
        }
        HikariDataSource realDataSource = (HikariDataSource) dataSource;
        if (StringUtils.isNotBlank(realDataSource.getJdbcUrl())) {
            return realDataSource.getJdbcUrl();
        }
        return getJdbcUrl(realDataSource.getDataSource());
    }

    /**
     * 提取 host
     */
    public static String extractHost(String jdbcUrl) {
        String s = jdbcUrl.replaceFirst(PROTOCOL, "");
        int portIndex = s.indexOf(":");
        int endIndex = portIndex > 0 ? portIndex : s.indexOf("/");
        return s.substring(0, endIndex);
    }

    /**
     * 提取数据库名称
     */
    public static String extractDbName(String jdbcUrl) {
        int startIndex = jdbcUrl.indexOf("/", PROTOCOL.length()) + 1;
        return jdbcUrl.substring(startIndex, jdbcUrl.indexOf("?", startIndex));
    }

    /**
     * 根据主库 host 获取从库 host
     */
    public static String getSlaveHost(String masterHost) {
        String key = "db.slave." + masterHost;
        String slaveHost = System.getenv(key);
        if (StringUtils.isBlank(slaveHost)) {
            slaveHost = System.getProperty(key);
        }
        if (StringUtils.isBlank(slaveHost)) {
            return null;
        }
        // 先取第一个，后续如果支持一主多从，可以注册多个从库数据源，通过轮询、随机等方式选择从库数据源
        return StringUtils.split(slaveHost, ",")[0];
    }

    /**
     * 通过 master url 生成 slave url
     */
    private static String generateSlaveUrl(String masterUrl, String slaveHost) {
        return masterUrl.replaceFirst(extractHost(masterUrl), slaveHost);
    }

    /**
     * 数据源升级为主从数据源
     */
    private static MasterSlaveDataSource upgrade(HikariDataSource master, String slaveUrl) {
        HikariDataSource slave = new HikariDataSource();
        master.copyStateTo(slave);
        if (StringUtils.isNotBlank(master.getPoolName())) {
            slave.setPoolName(master.getPoolName() + "-Slave");
        }
        slave.setJdbcUrl(slaveUrl);
        return new MasterSlaveDataSource(master, slave);
    }

}

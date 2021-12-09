package com.ares.service.datasource.routing.interceptor;

import com.ares.service.datasource.routing.datasource.DataSourceHelper;
import com.ares.service.datasource.routing.datasource.MasterSlaveDataSource;
import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.executor.BaseExecutor;
import org.apache.ibatis.executor.CachingExecutor;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.transaction.Transaction;
import org.mybatis.spring.transaction.SpringManagedTransaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.lang.reflect.Field;
import java.lang.reflect.Proxy;
import java.util.Properties;

/**
 * 数据源切换拦截器
 *
 * @author fansheng
 * @date 2021/11/18
 */
@Intercepts({@Signature(type = Executor.class, method = "update", args = {MappedStatement.class, Object.class}),
        @Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class})})
public class DataSourceRoutingInterceptor implements Interceptor {

    private static final Logger LOGGER = LoggerFactory.getLogger(DataSourceRoutingInterceptor.class);

    private static final String VLINE = "|";

    /**
     * 是否打印 sql
     */
    private boolean printSql;

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        long startTime = System.currentTimeMillis();
        try {
            return invocation.proceed();
        } finally {
            long executeTime = System.currentTimeMillis() - startTime;
            MappedStatement mappedStatement = (MappedStatement) invocation.getArgs()[0];
            BoundSql boundSql = mappedStatement.getBoundSql(invocation.getArgs()[1]);
            String logContent = mappedStatement.getId() + VLINE + executeTime;
            if (printSql) {
                logContent += VLINE + replaceWrapCharacter(boundSql.getSql());
            }
            LOGGER.warn(logContent);
        }
    }

    @SneakyThrows
    @Override
    public Object plugin(Object target) {
        if (target instanceof Executor) {
            Executor executor = (Executor) target;
            DataSource dataSource = findCurrentDataSource(executor);
            // 如果当前的数据源已经是支持读写分离的数据源，跳过不处理
            if (!(dataSource instanceof MasterSlaveDataSource)) {
                // 设置读写分离数据源
                setMasterSlaveDataSource(executor, dataSource);
            }
        }
        return Plugin.wrap(target, this);
    }

    /**
     * 获取当前配置的数据源
     */
    private DataSource findCurrentDataSource(Executor executor) throws Exception {
        Transaction transaction = executor.getTransaction();
        if (!(transaction instanceof SpringManagedTransaction)) {
            throw new RuntimeException("unsupported transaction type " + transaction.getClass());
        }
        Field dataSourceField = SpringManagedTransaction.class.getDeclaredField("dataSource");
        dataSourceField.setAccessible(true);
        return (DataSource) dataSourceField.get(transaction);
    }

    /**
     * 设置读写分离数据源
     */
    private void setMasterSlaveDataSource(Executor executor, DataSource dataSource) throws Exception {
        BaseExecutor baseExecutor = findBaseExecutor(executor);
        Field transactionField = BaseExecutor.class.getDeclaredField("transaction");
        transactionField.setAccessible(true);
        DataSource masterSlaveDataSource = DataSourceHelper.upgrade(dataSource);
        LOGGER.warn("haloframe generate MasterSlaveDataSource {}", masterSlaveDataSource);
        if (masterSlaveDataSource != null) {
            // 替换 Executor 中的数据源为支持读写分离的数据源
            transactionField.set(baseExecutor, new SpringManagedTransaction(masterSlaveDataSource));
        }
    }

    /**
     * 寻找 BaseExecutor
     */
    private BaseExecutor findBaseExecutor(Executor executor) throws Exception {
        // executor 可能是被代理过的对象
        if (Proxy.isProxyClass(executor.getClass())) {
            executor = getRealExecutorFromProxy(executor);
        }
        BaseExecutor base;
        if (executor instanceof BaseExecutor) {
            base = (BaseExecutor) executor;
        } else if (executor instanceof CachingExecutor) {
            Field delegate = CachingExecutor.class.getDeclaredField("delegate");
            delegate.setAccessible(true);
            base = (BaseExecutor) delegate.get(executor);
        } else {
            throw new RuntimeException("unsupported executor type " + executor.getClass());
        }
        return base;
    }

    /**
     * 从代理对象中获取真实的 Executor 对象
     */
    private Executor getRealExecutorFromProxy(Object proxy) throws Exception {
        Field hField = proxy.getClass().getSuperclass().getDeclaredField("h");
        hField.setAccessible(true);
        Object t = hField.get(proxy);
        Field targetField = t.getClass().getDeclaredField("target");
        targetField.setAccessible(true);
        Object executor = targetField.get(t);
        if (Proxy.isProxyClass(executor.getClass())) {
            return getRealExecutorFromProxy(executor);
        }
        return (Executor) executor;
    }

    @Override
    public void setProperties(Properties properties) {
        if (properties != null) {
            String printSql = properties.getProperty("printSql");
            if (StringUtils.isNotBlank(printSql)) {
                this.printSql = Boolean.parseBoolean(printSql);
            }
        }
    }

    /**
     * 替换 sql 中的空格和换行符
     */
    private String replaceWrapCharacter(String sql) {
        if (StringUtils.isBlank(sql)) {
            return sql;
        }
        return sql.replaceAll("[\n\t]", " ");
    }

}

package com.ares.infrastructure.datasource.routing.datasource;

import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanInitializationException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.core.PriorityOrdered;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.lang.reflect.Field;

/**
 * 切换数据源
 *
 * @author fansheng
 * @date 2021/11/23
 */
public class DataSourceUpgradeBeanPostProcessor implements BeanPostProcessor, PriorityOrdered {

    private static final Logger LOGGER = LoggerFactory.getLogger(DataSourceUpgradeBeanPostProcessor.class);

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof DataSourceTransactionManager) {
            DataSourceTransactionManager transactionManager = (DataSourceTransactionManager) bean;
            DataSource dataSource = transactionManager.getDataSource();
            if (!(dataSource instanceof MasterSlaveDataSource)) {
                MasterSlaveDataSource masterSlaveDataSource = DataSourceHelper.upgrade(dataSource);
                if (masterSlaveDataSource != null) {
                    LOGGER.warn("TransactionManager upgrade MasterSlaveDataSource, beanName: {}", beanName);
                    transactionManager.setDataSource(masterSlaveDataSource);
                }
            }
        } else if (bean instanceof SqlSessionTemplate) {
            try {
                SqlSessionTemplate sqlSessionTemplate = (SqlSessionTemplate) bean;
                Configuration configuration = sqlSessionTemplate.getConfiguration();
                Environment environment = configuration.getEnvironment();
                DataSource dataSource = environment.getDataSource();
                if (!(dataSource instanceof MasterSlaveDataSource)) {
                    MasterSlaveDataSource masterSlaveDataSource = DataSourceHelper.upgrade(dataSource);
                    if (masterSlaveDataSource != null) {
                        LOGGER.warn("SqlSessionTemplate upgrade MasterSlaveDataSource, beanName: {}", beanName);
                        Field dataSourceField = Environment.class.getDeclaredField("dataSource");
                        dataSourceField.setAccessible(true);
                        dataSourceField.set(environment, masterSlaveDataSource);
                    }
                }
            } catch (Exception e) {
                throw new BeanInitializationException(
                        "SqlSessionTemplate upgrade MasterSlaveDataSource fail! beanName: " + beanName, e);
            }
        }
        return bean;
    }

    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE;
    }
}

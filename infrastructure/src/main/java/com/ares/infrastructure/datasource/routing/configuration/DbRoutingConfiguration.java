package com.ares.infrastructure.datasource.routing.configuration;

import com.ares.infrastructure.datasource.routing.datasource.DataSourceUpgradeBeanPostProcessor;
import com.ares.infrastructure.datasource.routing.interceptor.DataSourceRoutingInterceptor;
import com.ares.infrastructure.datasource.routing.interceptor.DataAccessInterceptor;
import com.ares.infrastructure.datasource.routing.router.DataSourceRouterChain;
import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.aspectj.AspectJExpressionPointcutAdvisor;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 数据源切换配置
 *
 * @author fansheng
 * @date 2021/11/17
 */
@Configuration
@ConditionalOnExpression("${db.routing.enable:true}")
@EnableConfigurationProperties(DbRoutingProperties.class)
public class DbRoutingConfiguration implements ApplicationContextAware {

    private static final Logger LOGGER = LoggerFactory.getLogger(DbRoutingConfiguration.class);

    private ApplicationContext applicationContext;

    @Bean(name = "dataSourceSwitchInterceptor")
    public DataSourceRoutingInterceptor dataSourceSwitchInterceptor() {
        return new DataSourceRoutingInterceptor();
    }

    @Bean(name = "dataSourceBeanPostProcessor")
    public DataSourceUpgradeBeanPostProcessor changeDataSourceBeanPostProcessor() {
        return new DataSourceUpgradeBeanPostProcessor();
    }

    @Bean("dataAccessAdvisor")
    public AspectJExpressionPointcutAdvisor dataAccessAdvisor(
            @Autowired(required = false) DbRoutingProperties properties) {
        LOGGER.warn("switchDataSourceAdvisor properties: {}", properties);
        AspectJExpressionPointcutAdvisor advisor = new AspectJExpressionPointcutAdvisor();
        advisor.setExpression(generateExecution(properties));
        advisor.setAdvice(new DataAccessInterceptor(new DataSourceRouterChain(properties)));
        return advisor;
    }

    /**
     * 生成 execution 表达式
     */
    private String generateExecution(DbRoutingProperties properties) {
        List<String> executions = Lists.newArrayList();
        if (properties != null && MapUtils.isNotEmpty(properties.getScanPackages())) {
            executions.addAll(properties.getScanPackages().values().stream()
                    .map(p -> StringUtils.split(p, ","))
                    .flatMap(Arrays::stream)
                    .map(this::generatePackageExecution)
                    .collect(Collectors.toList()));
        }
        Map<String, MapperFactoryBean> mappers = applicationContext.getBeansOfType(MapperFactoryBean.class);
        if (MapUtils.isNotEmpty(mappers)) {
            executions.addAll(mappers.values().stream().map(
                    m -> generateClassExecution(m.getMapperInterface().getName())).collect(Collectors.toList()));
        }
        if (CollectionUtils.isEmpty(executions)) {
            throw new RuntimeException("please configure scan-packages!");
        }
        return StringUtils.join(executions, " || ");
    }

    /**
     * 根据包路径生成 execution 表达式
     */
    private String generatePackageExecution(String p) {
        return "execution(* " + p.trim() + "..*(..))";
    }

    /**
     * 根据类路径生成 execution 表达式
     */
    private String generateClassExecution(String c) {
        return "execution(* " + c.trim() + ".*(..))";
    }

    @Override
    public void setApplicationContext(@NonNull ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}

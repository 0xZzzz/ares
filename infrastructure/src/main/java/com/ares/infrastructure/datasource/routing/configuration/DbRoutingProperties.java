package com.ares.infrastructure.datasource.routing.configuration;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

/**
 * 数据源切换配置
 *
 * @author fansheng
 * @date 2021/11/19
 */
@Getter
@Setter
@ToString
@ConfigurationProperties(prefix = "db.routing")
public class DbRoutingProperties {

    /**
     * 扫描DAO包路径，多个包路径用英文逗号分隔
     * key: appName, value eg: package1,package2,...
     */
    private Map<String, String> scanPackages;

    /**
     * 走从库的方法列表，考虑到后续可能会支持重载方法的匹配，多个方法采用|分隔，逗号留给参数列表
     * key: appName, value eg: Xxx1Mapper#method1|method2|...;Xxx2Mapper#method1|method2|...;...
     */
    private Map<String, String> slaveMethods;

    /**
     * 方法前缀配置，切面会根据此配置项与 dao 方法名做前缀匹配，匹配成功则采用对应的数据源
     * eg: slave:query,list,get,count,find,fetch,select;master:insert,update,delete,add,save,modify,remove
     */
    private String methodPrefix;

}

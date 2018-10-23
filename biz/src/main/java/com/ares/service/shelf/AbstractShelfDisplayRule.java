package com.ares.service.shelf;

import org.springframework.beans.factory.InitializingBean;

/**
 * 货架陈列规则
 *
 * @author 0xzzzz
 * @date 2018/10/18
 */
public abstract class AbstractShelfDisplayRule implements ShelfDisplayRule, InitializingBean {

    @Override
    public void afterPropertiesSet() throws Exception {
        ShelfDisplayRuleExecutorChain.add(this);
    }
}

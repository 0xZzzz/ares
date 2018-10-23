package com.ares.service.shelf;

import com.ares.domain.ShelfDisplayContext;
import com.google.common.collect.Lists;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

/**
 * 货架陈列规则执行链
 *
 * @author 0xzzzz
 * @date 2018/10/18
 */
@Service
public class ShelfDisplayRuleExecutorChain implements ApplicationListener {

    private static final List<ShelfDisplayRule> RULE_LIST = Lists.newArrayList();

    public static void add(ShelfDisplayRule rule) {
        RULE_LIST.add(rule);
    }

    /**
     * 执行规则
     *
     * @param ctx 货架陈列上下文
     */
    public void execute(ShelfDisplayContext ctx) {
        RULE_LIST.forEach(rule -> rule.execute(ctx));
    }

    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        if (applicationEvent instanceof ApplicationStartedEvent) {
            RULE_LIST.sort(Comparator.comparingInt(ShelfDisplayRule::getSort));
        }
    }
}

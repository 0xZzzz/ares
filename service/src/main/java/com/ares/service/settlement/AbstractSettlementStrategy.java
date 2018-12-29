package com.ares.service.settlement;

import com.ares.common.utils.Alarm;
import com.ares.model.ChargeInfo;
import com.ares.model.ChargeRequest;
import com.ares.model.FinanceChargeRequest;
import com.ares.model.FinanceChargeResponse;
import com.ares.enums.ChargeTypeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;

/**
 * 计费结算策略抽象类
 *
 * @author 0xzzzz
 * @date 2018/10/19
 */
public abstract class AbstractSettlementStrategy implements SettlementStrategy, InitializingBean {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void settlement(ChargeRequest request) {
        logger.info("settlement request: {}", request);
        Alarm.start();
        try {
            // 保存计费结算记录
            saveChargeRecord(request);
            ChargeInfo subRequest = buildSubRequest(request);
            processSubRequestBeforeSubmit(subRequest);
            FinanceChargeRequest mainRequest = buildRequest(request, subRequest);
            processRequestBeforeSubmit(mainRequest);
            FinanceChargeResponse response = submitCharge(mainRequest);
            processResponse(response);
        } catch (Exception e) {
            logger.error("settlement error!", e);
            Alarm.error();
        } finally {
            Alarm.end();
        }
    }

    /**
     * 提交前处理子请求，子类扩展
     *
     * @param request 子请求
     */
    protected void processSubRequestBeforeSubmit(ChargeInfo request) {

    }

    /**
     * 构建计费结算RPC子请求
     *
     * @param request 计费结算请求
     * @return 子请求
     */
    private ChargeInfo buildSubRequest(ChargeRequest request) {
        return new ChargeInfo();
    }

    /**
     * 提交前处理计费请求，子类扩展
     *
     * @param request 计费请求
     */
    protected void processRequestBeforeSubmit(FinanceChargeRequest request) {

    }

    /**
     * 构建请求
     *
     * @param request 计费结算请求
     * @param charge  计费信息
     * @return FinanceChargeRequest
     */
    private FinanceChargeRequest buildRequest(ChargeRequest request, ChargeInfo charge) {
        return new FinanceChargeRequest();
    }

    /**
     * 获取计费结算类型
     *
     * @return 计费结算类型x
     */
    protected abstract ChargeTypeEnum getChargeType();

    /**
     * 保存计费结算记录
     *
     * @param request 计费结算记录
     */
    private void saveChargeRecord(ChargeRequest request) {

    }

    /**
     * 提交计费结算请求
     *
     * @param request 计费结算请求对象
     * @return 响应结果
     */
    protected FinanceChargeResponse submitCharge(FinanceChargeRequest request) {
        System.out.println("提交计费结算：" + getChargeType().name());
        return new FinanceChargeResponse();
    }

    /**
     * 处理计费结算响应结果
     *
     * @param response 响应结果
     */
    private void processResponse(FinanceChargeResponse response) {
        /*
         * 1、保存响应结果
         * 2、根据响应结果盘点是否需要重试
         */
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Selector.add(getChargeType().getType(), this);
    }
}

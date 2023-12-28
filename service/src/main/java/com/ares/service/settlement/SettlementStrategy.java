package com.ares.service.settlement;

/**
 * 计费结算
 *
 * @author 0xzzzz
 * @date 2018/10/19
 */
public interface SettlementStrategy {

    /**
     * 结算
     *
     * @param request 结算请求
     */
    void settlement(ChargeRequest request);

}

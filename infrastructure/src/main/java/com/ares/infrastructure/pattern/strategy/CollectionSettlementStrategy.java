package com.ares.infrastructure.pattern.strategy;

import com.ares.enums.ChargeTypeEnum;
import org.springframework.stereotype.Service;

/**
 * 代收
 *
 * @author 0xzzzz
 * @date 2018/10/19
 */
@Service
public class CollectionSettlementStrategy extends AbstractSpecialSettlementStrategy {

    @Override
    protected ChargeTypeEnum getChargeType() {
        return ChargeTypeEnum.COLLECT;
    }

}

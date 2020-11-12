package com.ares.service.pattern.composite;

import lombok.ToString;

/**
 * base handling unit
 *
 * @author fansheng
 * @date 2020/11/12
 */
@ToString
public abstract class BaseHu {

    /**
     * hu 唯一标识
     */
    Long id;

    /**
     * 仓库标识
     */
    Long warehouseId;

    /**
     * 重量（单位：g）
     */
    Long weight;

    public BaseHu(Long id, Long warehouseId, Long weight) {
        this.id = id;
        this.warehouseId = warehouseId;
        this.weight = weight;
    }

    /**
     * 计算重量
     *
     * @return 重量值
     */
    public abstract long calculateTotalWeight();

    /**
     * 添加 HU
     *
     * @param hu hu 实例
     */
    public void add(BaseHu hu) {
        throw new UnsupportedOperationException();
    }

    /**
     * 取出 hu
     *
     * @param huId hu 标识
     * @return hu 实例
     */
    public BaseHu takeOut(Long huId) {
        throw new UnsupportedOperationException();
    }
}

package com.ares.service.pattern.creationmethod;

import lombok.AllArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 贷款
 *
 * @author 0xZzzz
 */
@AllArgsConstructor
public class Loan {

    /**
     * 承诺金额
     */
    private BigDecimal commitmentAmount;

    /**
     * 未清风险金额
     */
    private BigDecimal outstandingRiskAmount;

    /**
     * 风险评级
     */
    private Integer riskRating;

    /**
     * 到期日
     */
    private Date maturityDate;

    /**
     * 有效期
     */
    private Date expiryDate;

    public Loan(BigDecimal commitmentAmount, Integer riskRating, Date maturityDate) {
        this(commitmentAmount, BigDecimal.ZERO, riskRating, maturityDate, null);
    }

    public Loan(BigDecimal commitmentAmount, BigDecimal outstandingRiskAmount, Integer riskRating, Date expiryDate) {
        this(commitmentAmount, outstandingRiskAmount, riskRating, null, expiryDate);
    }

    /**
     * 定期贷款，是指在到期日必须偿还的借款
     */
    public static Loan createTermLoan(BigDecimal commitmentAmount, Integer riskRating, Date maturityDate) {
        return new Loan(commitmentAmount, BigDecimal.ZERO, riskRating, maturityDate, null);
    }

    /**
     * 循环贷款，类似于信用卡，是一种标明“循环信用”的贷款形式
     */
    public static Loan createRevolver(
            BigDecimal commitmentAmount, BigDecimal outstandingRiskAmount, Integer riskRating, Date expiryDate) {
        return new Loan(commitmentAmount, outstandingRiskAmount, riskRating, null, expiryDate);
    }

    /**
     * 循环信用定期贷款（revolving credit term loan, RCTL）是一种满期后可以转换为定期贷款的循环贷款
     */
    public static Loan createRCTL(BigDecimal commitmentAmount, BigDecimal outstandingRiskAmount,
                                  Integer riskRating, Date maturityDate, Date expiryDate) {
        return new Loan(commitmentAmount, outstandingRiskAmount, riskRating, maturityDate, expiryDate);
    }

}

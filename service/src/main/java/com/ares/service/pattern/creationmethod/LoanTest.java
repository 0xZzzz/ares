package com.ares.service.pattern.creationmethod;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 贷款测试类
 *
 * @author 0xZzzz
 */
public class LoanTest {

    public static void main(String[] args) {
        /*
         *
         */
        BigDecimal commitmentAmount = BigDecimal.ONE;
        BigDecimal outstandingRiskAmount = BigDecimal.ONE;
        int riskRating = 1;
        Date maturityDate = new Date();
        Date expiryDate = new Date();

        Loan termLoan = new Loan(commitmentAmount, riskRating, maturityDate);
        termLoan = Loan.createTermLoan(commitmentAmount, riskRating, maturityDate);

        Loan revolver = new Loan(commitmentAmount, outstandingRiskAmount, riskRating, expiryDate);
        revolver = Loan.createTermLoan(commitmentAmount, riskRating, maturityDate);

        Loan rctl = new Loan(commitmentAmount, outstandingRiskAmount, riskRating, maturityDate, expiryDate);
        rctl = Loan.createRCTL(commitmentAmount, outstandingRiskAmount, riskRating, maturityDate, expiryDate);
    }

}

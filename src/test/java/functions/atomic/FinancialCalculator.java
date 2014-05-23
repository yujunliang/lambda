package functions.atomic;

import java.math.BigDecimal;

import static java.math.BigDecimal.ROUND_HALF_UP;

public class FinancialCalculator {

    public static final BigDecimal ONE_HUNDRED = BigDecimal.valueOf(100);

    /**
     * This formula is from
     * http://www.kbapps.com/calculators/FinancialFormulas.php
     * Simple Interest Amortized FinancialInstrument Formula
     *
     * @param rate
     * @param term
     * @param principal
     * @return
     */
    public static BigDecimal monthlyLoanPayment(BigDecimal rate, int term, BigDecimal principal) {
        BigDecimal b = rate.divide(ONE_HUNDRED);
        BigDecimal v = b.add(BigDecimal.valueOf(1)).pow(term);
        return principal.multiply(v).divide(v.subtract(BigDecimal.ONE), 32, ROUND_HALF_UP).multiply(b);
    }

    /**
     * This formula is from
     * http://www.leaseguide.com/lease08.htm
     *
     * @param rate
     * @param term
     * @param principal
     * @param residual
     * @return
     */
    public static BigDecimal monthlyLeasePayment(BigDecimal rate, int term, BigDecimal principal, BigDecimal residual) {
        BigDecimal depreciationFee = principal.subtract(residual).divide(BigDecimal.valueOf(term), 32, ROUND_HALF_UP);
        BigDecimal financeFee = principal.add(residual).multiply(rate).divide(ONE_HUNDRED);
        return depreciationFee.add(financeFee);

    }
}

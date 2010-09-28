package functions.atomic;

public class FinancialCalculator {

    /**
     * This formula is from
     *      http://www.kbapps.com/finance.html
     *      Simple Interest Amortized FinancialInstrument Formula
     * @param rate
     * @param term
     * @param principal
     * @return
     */
    public static double monthlyLoanPayment(double rate, int term, double principal) {
        double b = rate / 100;
        double v = Math.pow(b + 1, term);
        return principal * v / (v - 1) * b;
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
    public static double monthlyLeasePayment(double rate, int term, double principal, double residual) {
        double depreciationFee = (principal - residual) / term;
        double financeFee = (principal + residual) * rate/100;
        return depreciationFee + financeFee;
        
    }
}

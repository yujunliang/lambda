package loan.domain;

public class FinancialCalculator {

    /**
     * This formula is from
     *      http://www.kbapps.com/finance.html
     *      Simple Interest Amortized Loan Formula
     * @param rate
     * @param term
     * @param principal
     * @return
     */
    public static double monthlyPayment(double rate, int term, double principal) {
        double b = rate / 100;
        double v = Math.pow(b + 1, term);
        return principal * v / (v - 1) * b;
    }
}

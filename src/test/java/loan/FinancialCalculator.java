package loan;

public class FinancialCalculator {
    public static double monthlyPayment(double rate, int term, double principle) {
        double b = rate / 100;
        double v = Math.pow(b + 1, term);
        return principle * v / (v - 1) * b;
    }
}

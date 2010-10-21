package legacy;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class LegacyLoanCalculation {
    public static void calculate(Loan loan) {

        if (loan.getCountry().equals("GD")) {
            double b = loan.getRate().doubleValue() / 100;
            double v = Math.pow(b + 1, loan.getTerm() * 12);
            double monthly = loan.getPrincipal().doubleValue() * v / (v - 1) * b;

            loan.setMonthPayment(new BigDecimal(monthly).setScale(2, BigDecimal.ROUND_HALF_UP));
            loan.setStampDuty(
                    loan.getMonthPayment().multiply(new BigDecimal(0.02)).setScale(2, BigDecimal.ROUND_HALF_UP)
            );
            loan.setFirstMonthPayment(
                    loan.getMonthPayment().add(
                            loan.getStampDuty()
                    )

            );
        } else if (loan.getCountry().equals("NR")) {
            if (loan.isFinanceApplicationFee()) {
                loan.setPrincipal(loan.getPrincipal().add(loan.getApplicationFee()));
            }
            double b = loan.getRate().doubleValue() / 100;
            double v = Math.pow(b + 1, loan.getTerm() * 12);
            double monthly = loan.getPrincipal().doubleValue() * v / (v - 1) * b;

            loan.setMonthPayment(new BigDecimal(monthly).setScale(2, BigDecimal.ROUND_HALF_UP));

            if (!loan.isFirstTimeBuyer()) {
                loan.setStampDuty(
                        loan.getMonthPayment().multiply(new BigDecimal(0.03)).setScale(2, BigDecimal.ROUND_HALF_UP)
                );
            } else {
                 loan.setStampDuty(new BigDecimal(0.00).setScale(2,BigDecimal.ROUND_HALF_UP)); 
            }
            BigDecimal monthPayment = loan.getMonthPayment();
            if (loan.getStampDuty() != null) {
                monthPayment = monthPayment.add(loan.getStampDuty());
            }
            loan.setFirstMonthPayment(monthPayment);
            if (!loan.isFinanceApplicationFee()) {
                loan.setFirstMonthPayment(loan.getFirstMonthPayment().add(loan.getApplicationFee()));
            }

        } else if (loan.getCountry().equals("WL")) {
            double b = loan.getRate().doubleValue() / 100;
            double v = Math.pow(b + 1, loan.getTerm() * 12);
            double monthly = loan.getPrincipal().doubleValue() * v / (v - 1) * b;

            loan.setMonthPayment(new BigDecimal(monthly).setScale(2, BigDecimal.ROUND_HALF_UP));

            loan.setStampDuty(
                    loan.getPrincipal().multiply(new BigDecimal(0.03)).setScale(2, BigDecimal.ROUND_HALF_UP)
            );
            loan.setFirstMonthPayment(
                    loan.getMonthPayment().add(
                            loan.getStampDuty()
                    )

            );
        }

    }
}

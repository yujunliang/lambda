package traditional;

import composite.Country;
import composite.loan.Loan;
import functions.primitives.Amount;
import functions.primitives.Rate;

public class TranditionalLoanCalculation {
    public static void calculate(Loan loan) {

        if (loan.getCountry() == Country.GD) {
            double b = loan.getRate().doubleValue() / 100;
            double v = Math.pow(b + 1, loan.getTerm() * 12);
            double monthly = loan.getPrincipal().doubleValue() * v / (v - 1) * b;

            loan.setMonthPayment(Amount.valueOf(monthly));
            loan.setStampDuty(
                    loan.getMonthPayment().multiply(Rate.valueOf(0.02))
            );
            loan.setFirstMonthPayment(
                    loan.getMonthPayment().plus(
                            loan.getStampDuty()
                    )

            );
        } else if (loan.getCountry() == Country.NR) {
            if (loan.isFinanceApplicationFee()) {
                loan.setPrincipal(loan.getPrincipal().plus(loan.getApplicationFee()));
            }
            double b = loan.getRate().doubleValue() / 100;
            double v = Math.pow(b + 1, loan.getTerm() * 12);
            double monthly = loan.getPrincipal().doubleValue() * v / (v - 1) * b;

            loan.setMonthPayment(Amount.valueOf(monthly));

            if (!loan.isFirstTimeBuyer()) {
                loan.setStampDuty(
                        loan.getMonthPayment().multiply(Rate.valueOf(0.03))
                );
            }
            loan.setFirstMonthPayment(
                    loan.getMonthPayment().plus(
                            loan.getStampDuty()
                    )
            );
            if (!loan.isFinanceApplicationFee()) {
                loan.setFirstMonthPayment(loan.getFirstMonthPayment().plus(loan.getApplicationFee()));
            }

        } else if (loan.getCountry() == Country.WL) {
            double b = loan.getRate().doubleValue() / 100;
            double v = Math.pow(b + 1, loan.getTerm() * 12);
            double monthly = loan.getPrincipal().doubleValue() * v / (v - 1) * b;

            loan.setMonthPayment(Amount.valueOf(monthly));

            loan.setStampDuty(
                    loan.getPrincipal().multiply(Rate.valueOf(0.03))
            );
            loan.setFirstMonthPayment(
                    loan.getMonthPayment().plus(
                            loan.getStampDuty()
                    )

            );
        }

    }
}

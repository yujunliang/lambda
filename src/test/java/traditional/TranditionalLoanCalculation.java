package traditional;

import composite.Country;
import composite.FinancialInstrument;
import composite.loan.Loan;
import functions.primitives.Amount;
import functions.primitives.Rate;

import static functions.atomic.FinancialCalculator.monthlyLoanPayment;

public class TranditionalLoanCalculation {
    public static void calculate(Loan loan) {

       if (loan.getCountry() == Country.GD) {
           loan.setMonthPayment(
               Amount.valueOf(
                       monthlyLoanPayment(loan.getRate().doubleValue(),
                               loan.getTerm()*12,
                               loan.getPrincipal().doubleValue())
               )
           );
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
           loan.setMonthPayment(
               Amount.valueOf(
                   monthlyLoanPayment(loan.getRate().doubleValue(),
                           loan.getTerm()*12,
                           loan.getPrincipal().doubleValue())
                   )
           );
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
           loan.setMonthPayment(
               Amount.valueOf(
                       monthlyLoanPayment(loan.getRate().doubleValue(),
                               loan.getTerm()*12,
                               loan.getPrincipal().doubleValue())
                       )
           );
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

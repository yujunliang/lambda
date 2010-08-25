package loan.composite;

import loan.domain.Amount;
import loan.domain.Country;
import loan.domain.Loan;
import loan.domain.Rate;

import static loan.domain.FinancialCalculator.monthlyPayment;

public class TranditionalLoanCalculation {
    public static void calculate(Loan loan) {

       if (loan.getCountry() == Country.GD) {
           loan.setMonthPayment(
               Amount.valueOf(
                       monthlyPayment(loan.getRate().doubleValue(),
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
           if (loan.isBorrowLoanApplicationFee()) {
               loan.setPrincipal(loan.getPrincipal().plus(loan.getApplicationFee()));
           }
           loan.setMonthPayment(
               Amount.valueOf(
                   monthlyPayment(loan.getRate().doubleValue(),
                           loan.getTerm()*12,
                           loan.getPrincipal().doubleValue())
                   )
           );
           if (!loan.isFTBuyer()) {
               loan.setStampDuty(
                    loan.getMonthPayment().multiply(Rate.valueOf(0.03))
               );
           }
           loan.setFirstMonthPayment(
                loan.getMonthPayment().plus(
                    loan.getStampDuty()
                 )
           );
           if (!loan.isBorrowLoanApplicationFee()) {
               loan.setFirstMonthPayment(loan.getFirstMonthPayment().plus(loan.getApplicationFee()));
           }

       } else if (loan.getCountry() == Country.WL) {
           loan.setMonthPayment(
               Amount.valueOf(
                       monthlyPayment(loan.getRate().doubleValue(),
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

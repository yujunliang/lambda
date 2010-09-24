package traditional;

import composite.Country;
import composite.lease.Lease;
import composite.loan.Loan;
import functions.primitives.Amount;
import functions.primitives.Rate;

import static functions.atomic.FinancialCalculator.monthlyLeasePayment;
import static functions.atomic.FinancialCalculator.monthlyLoanPayment;

public class TranditionalLeaseCalculation {
    public static void calculate(Lease lease) {

       if (lease.getCountry() == Country.GD) {
           lease.setMonthPayment(
               Amount.valueOf(
                       monthlyLeasePayment(lease.getRate().doubleValue(),
                               lease.getTerm()*12,
                               lease.getPrincipal().doubleValue(),
                               lease.getResidualValue().doubleValue())
               )
           );
           lease.setStampDuty(
                lease.getMonthPayment().multiply(Rate.valueOf(0.02))
           );
           lease.setFirstMonthPayment(
                lease.getMonthPayment().plus(
                        lease.getStampDuty()
                )

        );
       } else if (lease.getCountry() == Country.NR) {
           lease.setMonthPayment(
               Amount.valueOf(
                   monthlyLeasePayment(lease.getRate().doubleValue(),
                           lease.getTerm()*12,
                           lease.getPrincipal().doubleValue(),
                           lease.getResidualValue().doubleValue())
                   )
           );

               lease.setStampDuty(
                    lease.getMonthPayment().multiply(Rate.valueOf(0.03))
               );

           lease.setFirstMonthPayment(
                lease.getMonthPayment().plus(
                    lease.getStampDuty()
                 )
           );

               lease.setFirstMonthPayment(lease.getFirstMonthPayment().plus(lease.getApplicationFee()));


       } else if (lease.getCountry() == Country.WL) {
           lease.setMonthPayment(
               Amount.valueOf(
                       monthlyLeasePayment(lease.getRate().doubleValue(),
                               lease.getTerm()*12,
                               lease.getPrincipal().doubleValue(),
                               lease.getResidualValue().doubleValue())
                       )
           );
           lease.setStampDuty(
                lease.getPrincipal().multiply(Rate.valueOf(0.03))
           );
           lease.setFirstMonthPayment(
                lease.getMonthPayment().plus(
                        lease.getStampDuty()
                )

           );
       }

    }
}

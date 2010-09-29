package traditional;

import composite.Country;
import composite.lease.Lease;
import functions.primitives.Amount;
import functions.primitives.Rate;

public class TranditionalLeaseCalculation {
    public static void calculate(Lease lease) {

        if (lease.getCountry() == Country.GD) {

            double depreciationFee = (lease.getPrincipal().doubleValue() - lease.getResidualValue().doubleValue()) / (lease.getTerm() * 12);
            double financeFee = (lease.getPrincipal().doubleValue() + lease.getResidualValue().doubleValue()) * lease.getRate().doubleValue() / 100;


            lease.setMonthPayment(Amount.valueOf(depreciationFee + financeFee));
            lease.setStampDuty(
                    lease.getMonthPayment().multiply(Rate.valueOf(0.02))
            );
            lease.setFirstMonthPayment(
                    lease.getMonthPayment().plus(
                            lease.getStampDuty()
                    )

            );
        } else if (lease.getCountry() == Country.NR) {
            double depreciationFee = (lease.getPrincipal().doubleValue() - lease.getResidualValue().doubleValue()) / (lease.getTerm() * 12);
            double financeFee = (lease.getPrincipal().doubleValue() + lease.getResidualValue().doubleValue()) * lease.getRate().doubleValue() / 100;


            lease.setMonthPayment(Amount.valueOf(depreciationFee + financeFee));

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
            double depreciationFee = (lease.getPrincipal().doubleValue() - lease.getResidualValue().doubleValue()) / (lease.getTerm() * 12);
            double financeFee = (lease.getPrincipal().doubleValue() + lease.getResidualValue().doubleValue()) * lease.getRate().doubleValue() / 100;


            lease.setMonthPayment(Amount.valueOf(depreciationFee + financeFee));

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

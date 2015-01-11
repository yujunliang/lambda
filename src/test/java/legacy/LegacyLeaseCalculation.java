package legacy;

import java.math.BigDecimal;

public class LegacyLeaseCalculation {
    public static void calculate(Lease lease) {

        if (lease.getCountry().equals("GD")) {

            double depreciationFee = (lease.getPrincipal().doubleValue() - lease.getResidualValue().doubleValue()) / (lease.getTerm() * 12);
            double financeFee = (lease.getPrincipal().doubleValue() + lease.getResidualValue().doubleValue()) * lease.getRate().doubleValue() / 100;


            lease.setMonthPayment(new BigDecimal(depreciationFee + financeFee).setScale(2, BigDecimal.ROUND_HALF_UP));
            lease.setStampDuty(
                lease.getMonthPayment().multiply(new BigDecimal(0.02)).setScale(2, BigDecimal.ROUND_HALF_UP)
            );
            lease.setFirstMonthPayment(
                lease.getMonthPayment().add(
                    lease.getStampDuty()
                ).setScale(2, BigDecimal.ROUND_HALF_UP)

            );
        } else if (lease.getCountry().equals("NR")) {
            double depreciationFee = (lease.getPrincipal().doubleValue() - lease.getResidualValue().doubleValue()) / (lease.getTerm() * 12);
            double financeFee = (lease.getPrincipal().doubleValue() + lease.getResidualValue().doubleValue()) * lease.getRate().doubleValue() / 100;


            lease.setMonthPayment(new BigDecimal(depreciationFee + financeFee).setScale(2, BigDecimal.ROUND_HALF_UP));

            lease.setStampDuty(
                lease.getMonthPayment().multiply(new BigDecimal(0.03)).setScale(2, BigDecimal.ROUND_HALF_UP)
            );

            lease.setFirstMonthPayment(
                lease.getMonthPayment().add(
                    lease.getStampDuty().setScale(2, BigDecimal.ROUND_HALF_UP)
                )
            );

            lease.setFirstMonthPayment(lease.getFirstMonthPayment().add(lease.getApplicationFee()));


        } else if (lease.getCountry().equals("WL")) {
            double depreciationFee = (lease.getPrincipal().doubleValue() - lease.getResidualValue().doubleValue()) / (lease.getTerm() * 12);
            double financeFee = (lease.getPrincipal().doubleValue() + lease.getResidualValue().doubleValue()) * lease.getRate().doubleValue() / 100;


            lease.setMonthPayment(new BigDecimal(depreciationFee + financeFee).setScale(2, BigDecimal.ROUND_HALF_UP));

            lease.setStampDuty(
                lease.getPrincipal().multiply(new BigDecimal(0.03)).setScale(2, BigDecimal.ROUND_HALF_UP)
            );
            lease.setFirstMonthPayment(
                lease.getMonthPayment().add(
                    lease.getStampDuty()
                ).setScale(2, BigDecimal.ROUND_HALF_UP)

            );
        }

    }
}

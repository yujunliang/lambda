package loan.atomic;

import com.google.common.base.Function;
import loan.domain.Amount;
import loan.domain.Lease;

import static loan.domain.FinancialCalculator.monthlyLeasePayment;
import static loan.domain.FinancialCalculator.monthlyLoanPayment;

public enum MonthlyLeasePaymentCalculation implements Function<Lease, Lease>{
    INSTANCE;
    @Override
    public Lease apply(Lease lease) {
        lease.setMonthPayment(
               Amount.valueOf(
                       monthlyLeasePayment(lease.getRate().doubleValue(),
                               lease.getTerm()*12,
                               lease.getPrincipal().doubleValue(),lease.getResidualValue().doubleValue()
                       )
               )
        );
        return lease;
    }    
}

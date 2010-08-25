package loan.atomic;

import com.google.common.base.Function;
import loan.domain.Loan;
import loan.domain.Rate;

public class StampDutyOnMonthlyPaymentCalculation implements Function<Loan, Loan> {

    private final Rate rate;

    public StampDutyOnMonthlyPaymentCalculation(Rate rate) {
        this.rate = rate;
    }

    @Override
    public Loan apply(Loan loan) {
        loan.setStampDuty(
                loan.getMonthPayment().multiply(rate)
        );
        return loan;
    }
}

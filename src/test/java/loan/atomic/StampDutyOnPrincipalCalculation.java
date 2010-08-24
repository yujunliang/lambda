package loan.atomic;

import com.google.common.base.Function;
import loan.domain.Loan;
import loan.domain.Rate;

public class StampDutyOnPrincipalCalculation implements Function<Loan, Loan>{
    private final Rate rate;

    public StampDutyOnPrincipalCalculation(Rate rate) {
        this.rate = rate;
    }

    @Override
    public Loan apply(Loan loan) {
        loan.setStampDuty(
                loan.getPrincipal().multiply(rate)
        );
        return loan;
    }
}

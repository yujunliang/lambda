package loan.atomic;

import com.google.common.base.Function;
import loan.domain.Loan;

public enum AddApplicationFeeToPrincipalCalculation implements Function<Loan, Loan> {
    INSTANCE;
    @Override
    public Loan apply(Loan loan) {
        loan.setPrincipal(loan.getPrincipal().plus(loan.getApplicationFee()));
        return loan;
    }
}

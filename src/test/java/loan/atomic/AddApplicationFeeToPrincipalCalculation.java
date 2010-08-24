package loan.atomic;

import com.google.common.base.Function;
import loan.domain.Loan;

public class AddApplicationFeeToPrincipalCalculation implements Function<Loan, Loan> {
    @Override
    public Loan apply(Loan loan) {
        loan.setPrincipal(loan.getPrincipal().plus(loan.getApplicationFee()));
        return loan;
    }
}

package loan.atomic;

import com.google.common.base.Function;
import loan.domain.Loan;

public class AddApplicationFeeToFirstMonthPaymentCalculation implements Function<Loan, Loan> {
    @Override
    public Loan apply(Loan loan) {
        loan.setFirstMonthPayment(loan.getFirstMonthPayment().plus(loan.getApplicationFee()));
        return loan;
    }
}

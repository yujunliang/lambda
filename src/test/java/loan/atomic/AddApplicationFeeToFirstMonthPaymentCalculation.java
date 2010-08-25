package loan.atomic;

import com.google.common.base.Function;
import loan.domain.Loan;

public enum AddApplicationFeeToFirstMonthPaymentCalculation implements Function<Loan, Loan> {
    INSTANCE;
    
    @Override
    public Loan apply(Loan loan) {
        loan.setFirstMonthPayment(loan.getFirstMonthPayment().plus(loan.getApplicationFee()));
        return loan;
    }
}

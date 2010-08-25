package loan.atomic;

import com.google.common.base.Function;
import loan.domain.Loan;

public enum FirstMonthPaymentCalculation implements Function<Loan, Loan> {
    INSTANCE;

    @Override
    public Loan apply(Loan loan) {

        loan.setFirstMonthPayment(
                loan.getMonthPayment().plus(
                        loan.getStampDuty()
                )

        );
        return loan;
    }
}

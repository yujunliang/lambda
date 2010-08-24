package loan.atomic;

import com.google.common.base.Function;
import loan.domain.Loan;

public class FirstMonthPaymentCalculation implements Function<Loan, Loan>{

    @Override
    public Loan apply(Loan loan) {

        loan.setFirstMonthPayment(
                loan.getMonthPayment().plus(
                        loan.getStampDuty())

        );
        return loan;
    }
}

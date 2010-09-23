package loan.atomic;

import com.google.common.base.Function;
import loan.domain.Loan;
import loan.primitives.Amount;

import static loan.atomic.FinancialCalculator.monthlyLoanPayment;

public enum MonthlyLoanPaymentCalculation implements Function<Loan, Loan>{
    INSTANCE;
    @Override
    public Loan apply(Loan loan) {
        loan.setMonthPayment(
               Amount.valueOf(
                       monthlyLoanPayment(loan.getRate().doubleValue(),
                               loan.getTerm()*12,
                               loan.getPrincipal().doubleValue())
                       )
        );
        return loan;
    }    
}

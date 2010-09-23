package loan.atomic;

import com.google.common.base.Predicate;
import loan.domain.FinancialInstrument;

public enum BorrowLoanApplicationFeePredicate implements Predicate<FinancialInstrument> {
    INSTANCE;
	@Override
	public boolean apply(final FinancialInstrument financialInstrument) {
		return financialInstrument.isBorrowLoanApplicationFee();
	}
}
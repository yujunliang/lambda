package loan.atomic;

import com.google.common.base.Predicate;
import loan.domain.FinancialInstrument;

public class FirstTimeBuyerPredicate<T extends FinancialInstrument> implements Predicate<T> {

	@Override
	public boolean apply(final T financialInstrument) {
		return financialInstrument.isFirstTimeBuyer();
	}
}
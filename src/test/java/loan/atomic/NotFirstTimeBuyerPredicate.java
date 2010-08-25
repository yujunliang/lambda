package loan.atomic;

import com.google.common.base.Predicate;
import loan.domain.Loan;

import static algocraft.util.Logic.not;

public enum NotFirstTimeBuyerPredicate implements Predicate<Loan> {
    INSTANCE;
	@Override
	public boolean apply(final Loan loan) {
		return not(loan.isFTBuyer());
	}
}
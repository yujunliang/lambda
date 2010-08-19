package amortization;

import algorithm.atomic.Problem;
import com.google.common.base.Predicate;

public final class StampDutyPredicate implements Predicate<Worksheet> {

	@Override
	public boolean apply(final Worksheet worksheet) {
		return worksheet.isFTBuyer();
	}
}


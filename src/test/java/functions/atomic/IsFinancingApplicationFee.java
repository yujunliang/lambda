package functions.atomic;


import functions.primitives.FinanceApplicationFee;

import java.util.function.Predicate;

public class IsFinancingApplicationFee<T extends FinanceApplicationFee> implements Predicate<T> {

	@Override
	public boolean test(final T t) {
		return t.isFinanceApplicationFee();
	}
}

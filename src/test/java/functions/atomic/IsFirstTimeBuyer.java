package functions.atomic;

import functions.primitives.FirstTimeBuyer;

import java.util.function.Predicate;

public class IsFirstTimeBuyer<T extends FirstTimeBuyer> implements Predicate<T> {

	@Override
	public boolean test(final T t) {
		return t.isFirstTimeBuyer();
	}
}

package algocraft.function;

import com.google.common.base.Function;
import com.google.common.base.Predicate;

/**
 * Created by cosmin on Aug 11, 2010
 */
public class ConditionalFunction <T> implements Function<T,T> {
	private Function<T, T> function;
	Predicate<T> predicate;

	public ConditionalFunction(Function<T,T> function, Predicate<T> predicate) {
		this.function = function;
		this.predicate = predicate;
	}

	@Override
	public T apply(T from) {
		if (predicate.apply(from)) {
			return function.apply(from);
		} else {
			return from;
		}
	}
}

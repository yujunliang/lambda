package algocraft.function;

import com.google.common.base.Function;
import com.google.common.base.Predicate;

/**
 * Created by cosmin on Aug 11, 2010
 */
public class OtherwiseFunction <A,B> implements Function<A,B> {
	private Function<A, B> ifFunction;
	private Predicate<A> predicate;
	private Function<A, B> elseFunction;

	public OtherwiseFunction(Predicate<A> predicate, Function<A, B> ifFuntion, Function<A,B> elseFunction) {
		this.ifFunction = ifFuntion;
		this.predicate = predicate;
		this.elseFunction = elseFunction;
	}

	@Override
	public B apply(A from) {
		if (predicate.apply(from)) {
			return ifFunction.apply(from);
		} else {
			return elseFunction.apply(from);
		}
	}
}

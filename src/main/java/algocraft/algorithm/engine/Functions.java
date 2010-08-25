package algocraft.algorithm.engine;

import com.google.common.base.Function;
import com.google.common.base.Predicate;

import static com.google.common.base.Functions.compose;

/**
 * This class is designed for extension, not for instantiation, its derived
 * class can add algorithms in the constructor.
 * 
 * @author yujunliang
 */
public class Functions {
	public static <A> Function<A,A> conditional(Predicate<A> predicate, Function<A, A> function) {
		return new ConditionalFunction(function, predicate);
	}

	public static <A,B> Function<A,B> conditional(Predicate<A> predicate, Function<A, B> ifFunction, Function<A,B> elseFunction) {
		return new OtherwiseFunction(predicate, ifFunction, elseFunction);
	}

    public static <A, B, C> Function<A,C> left(Function<A,B> function1, Function<B, C> function2) {
        return compose(function2, function1);
    }
}

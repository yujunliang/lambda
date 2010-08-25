package algocraft.function;

import com.google.common.base.Function;
import com.google.common.base.Predicate;

/**
 * This class is designed for extension, not for instantiation, its derived
 * class can add algorithms in the constructor.
 * 
 * @author yujunliang
 */
public class Functions {

	public static <A> Function<A,A> conditional(Predicate<A> predicate, Function<A, A> function) {
		return new ConditionalFunction<A>(function, predicate);
	}

	public static <A,B> Function<A,B> conditional(Predicate<A> predicate, Function<A, B> ifFunction, Function<A,B> elseFunction) {
		return new OtherwiseFunction<A,B>(predicate, ifFunction, elseFunction);
	}

    public static <A, B, C> Function<A,C> compose(Function<A,B> f1, Function<B, C> f2) {
        return com.google.common.base.Functions.compose(f2, f1);
    }

    public static <A, B, C, D> Function<A,D> compose(Function<A,B> f1, Function<B, C> f2, Function<C, D> f3) {
        return compose(compose(f1, f2), f3);
    }

    public static <A, B, C, D, E> Function<A,E> compose(Function<A,B> f1, Function<B, C> f2, Function<C, D> f3, Function<D,E> f4) {
        return compose(compose(compose(f1, f2), f3), f4);
    }

    public static <A, B, C, D, E, F> Function<A,F> compose(Function<A,B> f1, Function<B, C> f2, Function<C, D> f3, Function<D,E> f4, Function<E,F> f5) {
        return compose(compose(compose(compose(f1, f2), f3), f4), f5);
    }
    /**
     * Created by cosmin on Aug 11, 2010
     */
    private static final class ConditionalFunction <T> implements Function<T,T> {
        private final Function<T, T> function;
        private final Predicate<T> predicate;

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

    /**
     * Created by cosmin on Aug 11, 2010
     */
    private static class OtherwiseFunction <A,B> implements Function<A,B> {
        private final Predicate<A> predicate;
        private final Function<A, B> ifFunction;
        private final Function<A, B> elseFunction;

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
}

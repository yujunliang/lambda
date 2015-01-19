package algocraft.function;


import java.util.function.Function;


public class CompositeFunction<T1, T2> implements Function<T1, T2> {

    private final Function<T1,T2> function;

    protected <A> CompositeFunction(Function<T1, A> f1, Function<A, T2> f2) {
        function = f1.andThen(f2);
    }

    protected <A, B> CompositeFunction(Function<T1, A> f1, Function<A, B> f2, Function<B, T2> f3) {
        function = f1.andThen(f2).andThen(f3);
    }

    protected <A, B, C> CompositeFunction(Function<T1, A> f1, Function<A, B> f2, Function<B, C> f3, Function<C, T2> f4) {
        function = f1.andThen(f2).andThen(f3).andThen(f4);
    }

    protected <A, B, C, D> CompositeFunction(Function<T1, A> f1, Function<A, B> f2, Function<B, C> f3, Function<C, D> f4, Function<D, T2> f5) {
        function = f1.andThen(f2).andThen(f3).andThen(f4).andThen(f5);
    }

    @Override
    public final T2 apply(T1 from) {
        return function.apply(from);
    }
}

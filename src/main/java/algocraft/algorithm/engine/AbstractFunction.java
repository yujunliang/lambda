package algocraft.algorithm.engine;


import com.google.common.base.Function;
import com.google.common.base.Predicate;

import java.util.List;

import static algocraft.algorithm.engine.AlgorithmComposer.conditional;
import static com.google.common.base.Functions.compose;
import static com.google.common.collect.Lists.newArrayList;

public class AbstractFunction<T1,T2> implements Function<T1, T2> {

	private final Function<T1,T2> function;

    protected AbstractFunction(Function ... functions ) {
        int length = functions.length;

        Function function = compose(functions[length-1], functions[length-2]);
        if (length > 2) {
            for (int i = length-3; i >=0; i--) {
                function = compose( function, functions[i]);
            }
        }
        this.function = (Function<T1,T2>)function;
    }

	@Override
	public final T2 apply(T1 from) {
		return function.apply(from);
	}
}

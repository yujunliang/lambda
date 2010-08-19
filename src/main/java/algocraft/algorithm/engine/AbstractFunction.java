package algocraft.algorithm.engine;


import com.google.common.base.Function;

import static com.google.common.base.Functions.compose;

public class AbstractFunction<T1,T2> implements Function<T1, T2> {
	private final Function<T1,T2> topAlgorithm;

	public AbstractFunction(Function<T1, T2> topAlgorithm) {
        this.topAlgorithm = topAlgorithm;
    }

	@Override
	public T2 apply(T1 from) {
		return topAlgorithm.apply(from);
	}
}

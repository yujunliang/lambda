package problem2;

import com.google.common.base.Function;

import static com.google.common.base.Functions.compose;

public final class CompositeAlgoIProblem2 implements Function<Problem2,Problem2> {
	private Function<Problem2,Problem2> topFunction;

	public CompositeAlgoIProblem2() {
		topFunction = compose(new Algo0Problem2(), new Algo1Problem2());
	}


	@Override
	public Problem2 apply(Problem2 from) {
		return topFunction.apply(from);
	}
}

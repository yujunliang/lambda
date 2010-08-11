package algocraft.algorithm;

import static algocraft.creation.FlyweightFactory.get;
import algocraft.algorithm.engine.AbstractAlgorithmCore;

/**
 * This class is designed for extension, not for instantiation, its derived
 * class can add algorithms in the constructor.
 * 
 * @author yujunliang
 * 
 * @param <T>
 */
public abstract class AbstractAlgorithm<T> extends AbstractAlgorithmCore<T> {

	/**
	 * Create an instance of the Algorithm can call add(Algorithm) method.
	 * 
	 * @param class1
	 */
	protected final void add(final Class<? extends Solution<T>> class1) {
		this.add(get(class1));
	}
}

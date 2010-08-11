package algorithm.atomic;

import domain.Input;
import domain.Output;

/**
 * @author  yujunliang
 */
public final class Problem {
	

	private Input domain1;
	
	private Output output;

	public Input getInput() {
		return domain1;
	}

	public void setInput(final Input domain1) {
		this.domain1 = domain1;
	}

	public Output getOutput() {
		return output;
	}

	public void setOutput(final Output output) {
		this.output = output;
	}	
}

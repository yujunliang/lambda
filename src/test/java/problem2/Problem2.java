package problem2;

import domain.Input;
import domain.Output;

/**
 * @author  yujunliang
 */
public final class Problem2 {
	
	/**
	 * @uml.property  name="domain1"
	 * @uml.associationEnd  
	 */
	private Input domain1;
	
	/**
	 * @uml.property  name="output"
	 * @uml.associationEnd  
	 */
	private volatile Output output;

	public Input getInput() {
		return domain1;
	}

	public void setInput(Input domain1) {
		this.domain1 = domain1;
	}

	/**
	 * @return
	 * @uml.property  name="output"
	 */
	public Output getOutput() {
		return output;
	}

	/**
	 * @param output
	 * @uml.property  name="output"
	 */
	public void setOutput(Output output) {
		this.output = output;
	}	
}

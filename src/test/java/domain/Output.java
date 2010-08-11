package domain;

import java.util.List;

/**
 * @author  yujunliang
 */
public final class Output extends Domain{
	
	private List<SubOutput1> subOutput1List;
	
	private OutputType type;
	
	private SubOutput2 subOutput2;

	public List<SubOutput1> getSubOutput1List() {
		return subOutput1List;
	}

	public SubOutput2 getSubOutput2() {
		return subOutput2;
	}

	public OutputType getType() {
		return type;
	}

	public void setSubOutput1List(final List<SubOutput1> domain3List) {
		this.subOutput1List = domain3List;
	}

	public void setSubOutput2(final SubOutput2 domain4) {
		this.subOutput2 = domain4;
	}

	public void setType(final OutputType type) {
		this.type = type;
	}
}

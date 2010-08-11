package algorithm.tranditional;

import java.util.ArrayList;

import algocraft.util.Stopwatch;
import domain.Input;
import domain.Output;
import domain.OutputType;
import domain.SubOutput1;
import domain.SubOutput2;

public class TraditionalAlgorithm2 {
	
	/**
	 * Compare this method to the methods in Algo1, Algo2, ... Algo5
	 * 
	 */
	public Output solve(Input input) {

		Output output = new Output();
		ArrayList<SubOutput1> list1 = new ArrayList<SubOutput1>();
		output.setSubOutput1List(list1);

		Stopwatch.busyWork();
		
		output.setType(OutputType.TYPE1);
		

		if (input.isCondition2()) {
			SubOutput2 subOutput2 = new SubOutput2();
			subOutput2.setDate(input.getDate1());
			output.setSubOutput2(subOutput2);
			subOutput2.getDate().setTime(subOutput2.getDate().getTime() + 6000);
		} 
		
		for (SubOutput1 subOutput1 : output.getSubOutput1List()) {
			System.out.println(subOutput1);
		}
		return output;
	}
}

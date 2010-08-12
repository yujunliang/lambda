package algorithm.tranditional;

import java.util.Date;
import java.util.List;

import domain.Input;
import domain.Output;
import domain.OutputType;
import domain.SubOutput1;
import domain.SubOutput2;

public class CopyOfTraditionalAlgorithm {
	
	/**
	 * Compare this method to the methods in Algo1, Algo2If, ... Algo5
	 * 
	 */
	public Output solve(Input input) {

		Output output = doAlgo1();
		
		if (input.isCondition1()) {

			for (int i = 0; i < input.getInt1(); i++) {
				doAlgo2(input, output, i);
			}
		} else {
			System.out.println("algorithm.primitive.Algo2If@7a187814 is not applicable.");
		}

		if (input.isCondition2()) {
			doAlgo3(input, output);
		} else {
			System.out.println("algorithm.composite.CompositeAlgoI@664883c is not applicable.");	
		}
		
		for (SubOutput1 subOutput1 : output.getSubOutput1List()) {
			doAlgo5(subOutput1);
		}
		return output;
	}

	private void doAlgo5(SubOutput1 subOutput1) {
		System.out.println(subOutput1);
	}

	private void doAlgo3(Input input, Output output) {
		SubOutput2 subOutput2 = new SubOutput2();
		subOutput2.setDate(input.getDate1());
		output.setSubOutput2(subOutput2);
		subOutput2.getDate().setTime(subOutput2.getDate().getTime() + 6000);
	}

	private void doAlgo2(Input input, Output output, int i) {
		try {
			wait(2000);//just to simulate a logic taking two sends to finish
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		SubOutput1 subOutput1 = new SubOutput1();
		subOutput1.setAmount(input.getAmount1()
				.devide(input.getInt1()).plus(i));
		subOutput1.setInt1(i);
		subOutput1.setDate1(new Date(input.getDate1().getTime() + i * 10000));

		List<SubOutput1> list = output.getSubOutput1List();
		list.add(subOutput1);
	}

	private Output doAlgo1() {
		try {
			wait(2000);//just to simulate a logic taking two sends to finish
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Output output = new Output();
		output.setType(OutputType.TYPE1);
		return output;
	}
}

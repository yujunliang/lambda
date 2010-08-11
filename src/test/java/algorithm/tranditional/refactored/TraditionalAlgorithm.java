package algorithm.tranditional.refactored;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import algocraft.util.Stopwatch;
import domain.Input;
import domain.Output;
import domain.OutputType;
import domain.SubOutput1;
import domain.SubOutput2;

public class TraditionalAlgorithm {
	
	/**
	 * Compare this method to the methods in Algo1, Algo2, ... Algo5
	 * 
	 */
	public Output solve(final Input input) {

		final Output output = method1();
		
		method2(input, output);

		method4(input, output); 
		
		method5(output);
		return output;
	}

	private void method5(final Output output) {
		for (SubOutput1 subOutput1 : output.getSubOutput1List()) {
			System.out.println(subOutput1);
		}
	}

	private void method4(final Input input, final Output output) {
		if (input.isCondition2()) {
			final SubOutput2 subOutput2 = new SubOutput2();
			subOutput2.setDate(input.getDate1());
			output.setSubOutput2(subOutput2);
			subOutput2.getDate().setTime(subOutput2.getDate().getTime() + 6000);
		}
	}

	private void method2(final Input input, final Output output) {
		if (input.isCondition1()) {


			for (int i = 0; i < input.getInt1(); i++) {
				Stopwatch.busyWork();
				final SubOutput1 subOutput1 = new SubOutput1();
				subOutput1.setAmount(input.getAmount1()
						.devide(input.getInt1()).plus(i));
				subOutput1.setInt1(i);
				subOutput1.setDate1(new Date(input.getDate1().getTime() + i * 10000));

				final List<SubOutput1> list = output.getSubOutput1List();
				list.add(subOutput1);
			}
		} else {
			System.out.println("algorithm.primitive.Algo2@7a187814 is not applicable.");	
		}
	}

	private Output method1() {
		final Output output = new Output();
		final List<SubOutput1> list1 = new ArrayList<SubOutput1>();
		output.setSubOutput1List(list1);

		Stopwatch.busyWork();
		
		output.setType(OutputType.TYPE1);
		return output;
	}
}

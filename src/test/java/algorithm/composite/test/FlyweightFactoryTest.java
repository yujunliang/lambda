package algorithm.composite.test;

import static algocraft.creation.FlyweightFactory.get;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import algorithm.atomic.Algo1;
import algorithm.atomic.Algo2;
import algorithm.atomic.Problem;


public class FlyweightFactoryTest {
	
	@Test
	public void singleton() {
		Algo1 algo11 = get(Algo1.class);
		Algo1 algo12 = get(Algo1.class);
		Assert.assertTrue(algo11 == algo12);
		
		List<Class<?>> list1 = new ArrayList<Class<?>>();
		List<Class<?>> list2 = new ArrayList<Class<?>>();
		
		list1.add(Algo1.class);
		list1.add(Algo2.class);

		list2.add(Algo1.class);
		list2.add(Algo2.class);
		
		Assert.assertTrue(list1.equals(list2));
		Assert.assertTrue(list1.hashCode() == list2.hashCode());
		
	}

	@Test
	public void nonSingleton() {
		Problem algo11 = get(Problem.class);
		Problem algo12 = get(Problem.class);
		Assert.assertFalse(algo11 == algo12);
	}
}

package model.quantity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import common.SummableHashMap;

public class QuantityTest {

	@Test
	public void testSub() {
		fail("Not yet implemented");
	}

	@Test
	public void testMul() {
		fail("Not yet implemented");
	}

	@Test
	public void testDiv() {
		fail("Not yet implemented");
	}

	@Test
	public void testAdd() {
		fail("Not yet implemented");
	}

	/**
	 * tests common.SummableHashMap aggregate operation
	 */
	@Test
	public void testMergeMaps() {
		SummableHashMap<String> map1 = new SummableHashMap<String>();
		SummableHashMap<String> map2 = new SummableHashMap<String>();
		SummableHashMap<String> exp = new SummableHashMap<String>();

		map1.getMap().put("a", (long) 1);
		map1.getMap().put("b", (long) 2);

		map2.getMap().put("a", (long) 2);
		map2.getMap().put("b", (long) -5);
		map2.getMap().put("c", (long) 7);

		exp.getMap().put("a", (long) 3);
		exp.getMap().put("b", (long) -3);
		exp.getMap().put("c", (long) 7);

		map1.aggregate(map2);

		assertEquals(exp.getMap(), map1.getMap());
	}

}

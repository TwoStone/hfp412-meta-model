package model.quantity;

import static org.junit.Assert.fail;

import org.junit.Test;

import persistence.PersistentQuantityManager;
import persistence.PersistentUnitTypeManager;
import util.AbstractTest;
import util.InjectSingleton;

public class CalculationTest extends AbstractTest {

	public CalculationTest() {
		super();
	}

	@InjectSingleton(QuantityManager.class)
	private PersistentQuantityManager quanMan;

	@InjectSingleton(UnitTypeManager.class)
	private PersistentUnitTypeManager utman;

	@Test
	public void addAtomarQuantities() {
		fail("Not yet implemented");
	}

}

package model.quantity;

import junit.framework.Assert;
import model.DoubleDefinitionException;

import org.junit.Test;

import persistence.PersistenceException;
import persistence.PersistentCompUnit;
import persistence.PersistentReference;
import persistence.PersistentUnit;
import persistence.PersistentUnitType;
import persistence.PersistentUnitTypeManager;
import util.AbstractTest;
import util.InjectSingleton;

public class AddReferenceTest extends AbstractTest {

	public AddReferenceTest() {
		super();
	}

	@InjectSingleton(UnitTypeManager.class)
	private PersistentUnitTypeManager utman;

	/**
	 * Unit "m" -> addRef(m) => m²
	 */
	@Test
	public void addReferenceForUnit_1() throws PersistenceException, DoubleDefinitionException {
		final PersistentUnitType unitTypeStrecke = UnitType.createUnitType("Strecke");
		final PersistentUnit unitM = Unit.createUnit(unitTypeStrecke, "m");

		final PersistentCompUnit compUnit = utman.addReference("Fläche", unitM, unitM, 1);

		Assert.assertEquals(1, compUnit.getRefs().getLength());
		final PersistentReference reference = compUnit.getRefs().iterator().next();
		Assert.assertEquals(unitM, reference.getRef());
		Assert.assertEquals(2, reference.getExponent());

	}
	
	
	/**
	 * Scalar holen
	 */
	@Test
	public void fetchScalar() {
		// TODO
	}

}

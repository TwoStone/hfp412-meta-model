package model.quantity;

import junit.framework.Assert;
import model.ConsistencyException;
import model.DoubleDefinitionException;
import model.NotComputableException;

import org.junit.Test;

import persistence.PersistenceException;
import persistence.PersistentAbsQuantity;
import persistence.PersistentAbsUnit;
import persistence.PersistentAddition;
import persistence.PersistentQuantity;
import persistence.PersistentQuantityManager;
import persistence.PersistentUnit;
import persistence.PersistentUnitType;
import persistence.PersistentUnitTypeManager;
import util.AbstractTest;
import util.InjectSingleton;

import common.Fraction;

public class IsLessOrEqualTest extends AbstractTest {

	public IsLessOrEqualTest() {
		super();
	}

	@InjectSingleton(UnitTypeManager.class)
	private PersistentUnitTypeManager utman;

	@InjectSingleton(QuantityManager.class)
	private PersistentQuantityManager qman;

	/**
	 * 
	 * @throws NotComputableException
	 */
	@Test
	public void Two_ne_one() throws PersistenceException, DoubleDefinitionException, NotComputableException {
		final PersistentUnitType unitTypeStrecke = UnitType.createUnitType("Strecke");
		final PersistentUnit unitM = Unit.createUnit(unitTypeStrecke, "m");

		final PersistentQuantity m5 = Quantity.createQuantity(Fraction.parse("5"), unitM);
		final PersistentQuantity m1 = Quantity.createQuantity(Fraction.parse("1"), unitM);

		Assert.assertFalse(qman.isLessOrEqual(m5, m1).toBoolean());
	}

	/**
	 * 
	 * @throws NotComputableException
	 */
	@Test
	public void One_eq_one() throws PersistenceException, DoubleDefinitionException, NotComputableException {
		final PersistentUnitType unitTypeStrecke = UnitType.createUnitType("Strecke");
		final PersistentUnit unitM = Unit.createUnit(unitTypeStrecke, "m");

		final PersistentQuantity Mquantity1 = qman.createQuantity(unitM, Fraction.parse("1"));
		final PersistentQuantity Mquantity2 = qman.createQuantity(unitM, Fraction.parse("1"));

		Assert.assertTrue(qman.isLessOrEqual(Mquantity1, Mquantity2).toBoolean());
	}

	/**
	 * 
	 * @throws NotComputableException
	 * @throws ConsistencyException
	 */
	@Test
	public void OneM_le_OneKM() throws PersistenceException, DoubleDefinitionException, NotComputableException,
			ConsistencyException {
		final PersistentUnitType unitTypeStrecke = UnitType.createUnitType("Strecke");
		final PersistentUnit unitM = Unit.createUnit(unitTypeStrecke, "m");
		final PersistentUnit unitKm = Unit.createUnit(unitTypeStrecke, "km");
		utman.setDefaultUnit(unitTypeStrecke, unitM);
		utman.setConversion(unitKm, Fraction.parse("1/1000"), Fraction.Null);

		final PersistentQuantity Mquantity1 = qman.createQuantity(unitM, Fraction.parse("1"));
		final PersistentQuantity Mquantity2 = qman.createQuantity(unitKm, Fraction.parse("1"));

		Assert.assertTrue(qman.isLessOrEqual(Mquantity1, Mquantity2).toBoolean());
	}

	/**
	 * 
	 * @throws NotComputableException
	 * @throws ConsistencyException
	 */
	@Test
	public void OnethousandM_eq_OneKM() throws PersistenceException, DoubleDefinitionException, NotComputableException,
			ConsistencyException {
		final PersistentUnitType unitTypeStrecke = UnitType.createUnitType("Strecke");
		final PersistentUnit unitM = Unit.createUnit(unitTypeStrecke, "m");
		final PersistentUnit unitKm = Unit.createUnit(unitTypeStrecke, "km");
		utman.setDefaultUnit(unitTypeStrecke, unitM);
		utman.setConversion(unitKm, Fraction.parse("1/1000"), Fraction.Null);

		final PersistentQuantity Mquantity1 = Quantity.createQuantity(Fraction.parse("1"), unitKm);

		final PersistentQuantity Mquantity1000m = Quantity.createQuantity(Fraction.parse("1000"), unitM);
		final PersistentQuantity Mquantity1001m = Quantity.createQuantity(Fraction.parse("1001"), unitM);

		Assert.assertTrue(qman.isLessOrEqual(Mquantity1, Mquantity1000m).toBoolean());
		Assert.assertTrue(qman.isLessOrEqual(Mquantity1, Mquantity1001m).toBoolean());
		Assert.assertFalse(qman.isLessOrEqual(Mquantity1001m, Mquantity1).toBoolean());
	}

	/**
	 * 
	 * @throws NotComputableException
	 */
	@Test(expected = model.NotComputableException.class)
	public void Different_UnitTypes_AtomQuantity() throws PersistenceException, DoubleDefinitionException,
			NotComputableException {
		final PersistentUnitType unitTypeStrecke = UnitType.createUnitType("Strecke");
		final PersistentUnit unitM = Unit.createUnit(unitTypeStrecke, "m");
		final PersistentUnitType unitTypeZeit = UnitType.createUnitType("Zeit");
		final PersistentUnit unitH = Unit.createUnit(unitTypeZeit, "h");

		final PersistentQuantity Mquantity1 = qman.createQuantity(unitM, Fraction.parse("1"));
		final PersistentQuantity Mquantity2 = qman.createQuantity(unitH, Fraction.parse("1"));

		qman.isLessOrEqual(Mquantity1, Mquantity2).toBoolean();
	}

	/**
	 * 
	 * @throws NotComputableException
	 * @throws ConsistencyException
	 */
	@Test
	public void CompoundQuantity_AtomarQuantity() throws PersistenceException, DoubleDefinitionException,
			NotComputableException, ConsistencyException {
		final PersistentUnitType unitTypeStrecke = UnitType.createUnitType("Strecke");
		final PersistentUnit unitM = Unit.createUnit(unitTypeStrecke, "m");
		final PersistentUnit unitKm = Unit.createUnit(unitTypeStrecke, "km");

		utman.setDefaultUnit(unitTypeStrecke, unitM);
		utman.setConversion(unitKm, Fraction.parse("1/1000"), Fraction.Null);

		final PersistentQuantity km1 = Quantity.createQuantity(Fraction.parse("1"), unitKm);
		final PersistentQuantity m1 = Quantity.createQuantity(Fraction.parse("1"), unitM);

		final PersistentQuantity m1000 = Quantity.createQuantity(Fraction.parse("1000"), unitM);
		// final PersistentAbsQuantity km1_m1 = qman.add(km1, m1);

		final PersistentAddition addi = Addition.createAddition();
		addi.setArg1(km1);
		addi.setArg2(m1);
		addi.calculate();
		final PersistentAbsQuantity km1_m1 = addi.getResultt();

		Assert.assertTrue(qman.isLessOrEqual(m1000, km1_m1).toBoolean());
	}

	/**
	 * 
	 * @throws NotComputableException
	 */
	@Test(expected = model.NotComputableException.class)
	public void Different_UnitTypes_MixedUnitsQuantities_1() throws PersistenceException, DoubleDefinitionException,
			NotComputableException {
		final PersistentUnitType unitTypeStrecke = UnitType.createUnitType("Strecke");
		final PersistentUnit unitM = Unit.createUnit(unitTypeStrecke, "m");
		final PersistentUnitType unitTypeZeit = UnitType.createUnitType("Zeit");
		final PersistentUnit unitH = Unit.createUnit(unitTypeZeit, "h");

		final PersistentAbsUnit compUnit = utman.addReference("m/h", unitM, unitH, -1);

		final PersistentQuantity Mquantity1 = qman.createQuantity(unitM, Fraction.parse("1"));
		final PersistentQuantity Mquantity2 = qman.createQuantity(compUnit, Fraction.parse("1"));

		qman.isLessOrEqual(Mquantity1, Mquantity2).toBoolean();
	}

	/**
	 * 
	 * @throws NotComputableException
	 */
	@Test(expected = model.NotComputableException.class)
	public void Different_UnitTypes_MixedUnitsQuantities_2() throws PersistenceException, DoubleDefinitionException,
			NotComputableException {
		final PersistentUnitType unitTypeStrecke = UnitType.createUnitType("Strecke");
		final PersistentUnit unitM = Unit.createUnit(unitTypeStrecke, "m");
		final PersistentUnitType unitTypeZeit = UnitType.createUnitType("Zeit");
		final PersistentUnit unitH = Unit.createUnit(unitTypeZeit, "h");

		final PersistentAbsUnit compUnit = utman.addReference("m/h", unitM, unitH, -1);

		final PersistentQuantity Mquantity1 = qman.createQuantity(unitM, Fraction.parse("1"));
		final PersistentQuantity Mquantity2 = qman.createQuantity(compUnit, Fraction.parse("1"));

		qman.isLessOrEqual(Mquantity2, Mquantity1).toBoolean();
	}

	/**
	 * 
	 * @throws NotComputableException
	 */
	@Test(expected = model.NotComputableException.class)
	public void Different_UnitTypes_CompUnitsQuantities() throws PersistenceException, DoubleDefinitionException,
			NotComputableException {
		final PersistentUnitType unitTypeStrecke = UnitType.createUnitType("Strecke");
		final PersistentUnit unitM = Unit.createUnit(unitTypeStrecke, "m");
		final PersistentUnitType unitTypeZeit = UnitType.createUnitType("Zeit");
		final PersistentUnit unitH = Unit.createUnit(unitTypeZeit, "h");

		final PersistentAbsUnit compUnit1 = utman.addReference("m/h", unitM, unitH, -1);
		final PersistentAbsUnit compUnit2 = utman.addReference("h/m", unitH, unitM, -1);

		final PersistentQuantity Mquantity1 = qman.createQuantity(compUnit1, Fraction.parse("1"));
		final PersistentQuantity Mquantity2 = qman.createQuantity(compUnit2, Fraction.parse("1"));

		qman.isLessOrEqual(Mquantity2, Mquantity1).toBoolean();
	}

	/**
	 * 
	 * @throws NotComputableException
	 * @throws ConsistencyException
	 */
	@Test(expected = NotComputableException.class)
	public void without_conversion_negative_1() throws PersistenceException, DoubleDefinitionException,
			NotComputableException, ConsistencyException {
		final PersistentUnitType unitTypeStrecke = UnitType.createUnitType("Strecke");
		final PersistentUnit unitM = Unit.createUnit(unitTypeStrecke, "m");
		final PersistentUnit unitKm = Unit.createUnit(unitTypeStrecke, "km");

		final PersistentQuantity Mquantity2 = Quantity.createQuantity(Fraction.parse("1"), unitM);
		final PersistentQuantity Mquantity1 = Quantity.createQuantity(Fraction.parse("1"), unitKm);

		Assert.assertTrue(qman.isLessOrEqual(Mquantity1, Mquantity2).toBoolean());
	}

	/**
	 * 
	 * @throws NotComputableException
	 * @throws ConsistencyException
	 */
	@Test
	public void without_conversion_positive_1() throws PersistenceException, DoubleDefinitionException,
			NotComputableException, ConsistencyException {
		final PersistentUnitType unitTypeStrecke = UnitType.createUnitType("Strecke");
		final PersistentUnit unitM = Unit.createUnit(unitTypeStrecke, "m");

		final PersistentQuantity Mquantity2 = Quantity.createQuantity(Fraction.parse("5"), unitM);
		final PersistentQuantity Mquantity1 = Quantity.createQuantity(Fraction.parse("3"), unitM);

		Assert.assertTrue(qman.isLessOrEqual(Mquantity1, Mquantity2).toBoolean());
	}
}

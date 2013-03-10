package model.quantity;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.sql.SQLException;

import model.DoubleDefinitionException;
import model.NotComputableException;

import org.junit.Before;
import org.junit.Test;

import persistence.PersistenceException;
import persistence.PersistentCompUnit;
import persistence.PersistentCompUnitType;
import persistence.PersistentFractionManager;
import persistence.PersistentQuantity;
import persistence.PersistentQuantityManager;
import persistence.PersistentUnit;
import persistence.PersistentUnitType;
import persistence.PersistentUnitTypeManager;
import util.InjectSingleton;
import util.TestingBase;

import common.Fraction;

public class CalculationTest extends TestingBase {

	public CalculationTest() {
		super();
	}

	@InjectSingleton(FractionManager.class)
	private PersistentFractionManager fracMan;
	@InjectSingleton(QuantityManager.class)
	private PersistentQuantityManager quanMan;

	@InjectSingleton(UnitTypeManager.class)
	private PersistentUnitTypeManager utman;

	/* Definition der Stammdaten */

	/*
	 * vorgefertigte Einheitstypen
	 */
	private PersistentUnitType distance;
	private PersistentUnitType time;
	private PersistentCompUnitType area;
	private PersistentCompUnitType speed;
	/*
	 * vorgefertigte Einheiten
	 */
	private PersistentUnit meter;
	private PersistentUnit second;
	private PersistentCompUnit squareMeter;
	private PersistentCompUnit meterPerSecond;

	/* vorgefertigte Quantities */

	@Before
	public void setup() throws PersistenceException, SQLException, IOException {
		try {
			this.init();
		} catch (final DoubleDefinitionException e) {
			e.printStackTrace();
		}
	}

	private void init() throws DoubleDefinitionException, PersistenceException {
		distance = utman.createUnitType("Distance");
		time = utman.createUnitType("Time");
		area = (PersistentCompUnitType) utman.addReferenceType("Area", distance, distance, 1);
		speed = (PersistentCompUnitType) utman.addReferenceType("Speed", distance, time, -1);

		meter = utman.createUnit("m", distance);
		second = utman.createUnit("s", time);
		squareMeter = (PersistentCompUnit) utman.addReference("m^2", meter, meter, 1);
		meterPerSecond = (PersistentCompUnit) utman.addReference("m/s", meter, second, -1);

		return;
	}

	/**
	 * testet die Addition mit der gleichen Einheit.
	 * 
	 * @throws PersistenceException
	 * @throws NotComputableException
	 */
	@Test
	public void testBasicCalculation_Same_Unit_add() throws PersistenceException, NotComputableException {
		final PersistentQuantity two = quanMan.createQuantity(meter, Fraction.parse("2"));
		final PersistentQuantity minusOne = quanMan.createQuantity(meter, Fraction.parse("-1"));
		final PersistentQuantity eight = quanMan.createQuantity(meter, Fraction.parse("8"));

		/*
		 * Test 1: -1 +2 = 1
		 */
		final PersistentQuantity test1_act = (PersistentQuantity) quanMan.add(minusOne, two);
		final PersistentQuantity test1_exp = quanMan.createQuantity(meter, Fraction.parse("1"));
		assertEquals(test1_exp.getUnit(), test1_act.getUnit());
		assertEquals(test1_exp.getAmount(), test1_act.getAmount());

		/*
		 * Test 2: 8 + -1 = 7
		 */
		final PersistentQuantity test2_act = (PersistentQuantity) quanMan.add(eight, minusOne);
		final PersistentQuantity test2_exp = quanMan.createQuantity(meter, Fraction.parse("7"));
		assertEquals(test1_exp.getUnit(), test1_act.getUnit());
		assertEquals(test1_exp.getAmount(), test1_act.getAmount());
	}

	/**
	 * testet die Subtraktion mit der gleichen Einheit.
	 * 
	 * @throws PersistenceException
	 * @throws NotComputableException
	 */
	@Test
	public void testBasicCalculation_Same_Unit_sub() throws PersistenceException, NotComputableException {
		final PersistentQuantity two = quanMan.createQuantity(meter, Fraction.parse("2"));
		final PersistentQuantity minusOne = quanMan.createQuantity(meter, Fraction.parse("-1"));
		final PersistentQuantity eight = quanMan.createQuantity(meter, Fraction.parse("8"));

		/*
		 * Test 1: -1 - 2 = -3
		 */
		final PersistentQuantity test1_act = (PersistentQuantity) quanMan.sub(minusOne, two);
		final PersistentQuantity test1_exp = quanMan.createQuantity(meter, Fraction.parse("-3"));
		assertEquals(test1_exp.getUnit(), test1_act.getUnit());
		assertEquals(test1_exp.getAmount(), test1_act.getAmount());

		/*
		 * Test 2: 8 - -1 = 9
		 */
		final PersistentQuantity test2_act = (PersistentQuantity) quanMan.sub(eight, minusOne);
		final PersistentQuantity test2_exp = quanMan.createQuantity(meter, Fraction.parse("9"));
		assertEquals(test2_exp.getUnit(), test2_act.getUnit());
		assertEquals(test2_exp.getAmount(), test2_act.getAmount());
	}

	/**
	 * testet die Multiplikation mit der gleichen Einheit .
	 * 
	 * @throws PersistenceException
	 * @throws NotComputableException
	 */
	@Test
	public void testBasicCalculation_Same_Unit_mul() throws PersistenceException, NotComputableException {
		final PersistentQuantity two = quanMan.createQuantity(meter, Fraction.parse("2"));
		final PersistentQuantity eight = quanMan.createQuantity(meter, Fraction.parse("8"));

		/*
		 * Test 1: 2m * 8m = 16m^2 (simple)
		 */
		final PersistentQuantity test1_act = (PersistentQuantity) quanMan.mul(two, eight);
		final PersistentQuantity test1_exp = quanMan.createQuantity(squareMeter, Fraction.parse("16"));
		assertEquals(test1_exp.getUnit(), test1_act.getUnit());
		assertEquals(test1_exp.getAmount(), test1_act.getAmount());
	}

	/**
	 * testet die Division mit der gleichen Einheit .
	 * 
	 * @throws PersistenceException
	 * @throws NotComputableException
	 */
	@Test
	public void testBasicCalculation_Same_Unit_div() throws PersistenceException, NotComputableException {
		final PersistentQuantity two = quanMan.createQuantity(meter, Fraction.parse("2"));
		final PersistentQuantity eight = quanMan.createQuantity(squareMeter, Fraction.parse("8"));

		final PersistentQuantity fiveMeter = quanMan.createQuantity(meter, Fraction.parse("5"));
		final PersistentQuantity twoSeconds = quanMan.createQuantity(second, Fraction.parse("2"));

		/*
		 * Test 16m^2 / 8m = 2m (simple)
		 */
		final PersistentQuantity test1_act = (PersistentQuantity) quanMan.div(eight, two);
		final PersistentQuantity test1_exp = quanMan.createQuantity(meter, Fraction.parse("4"));
		assertEquals(test1_exp.getUnit(), test1_act.getUnit());
		assertEquals(test1_exp.getAmount(), test1_act.getAmount());

		/*
		 * Test 5m / 2s = 5/2 m/s
		 */
		final PersistentQuantity test2_act = (PersistentQuantity) quanMan.div(fiveMeter, twoSeconds);
		final PersistentQuantity test2_exp = quanMan.createQuantity(meterPerSecond, Fraction.parse("5/2"));
		assertEquals(test2_exp.getUnit(), test2_act.getUnit());
		assertEquals(test2_exp.getAmount(), test2_act.getAmount());
	}

}

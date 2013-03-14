package model.measurement;

import static org.junit.Assert.assertEquals;
import model.ConsistencyException;
import model.CycleException;
import model.NotComputableException;
import model.quantity.Quantity;
import model.quantity.Unit;
import model.quantity.UnitType;
import model.typeSystem.MAspect;
import model.typeSystem.MAtomicType;
import model.typeSystem.MEmptyTypeConjunction;
import model.typeSystem.MObject;

import org.junit.Test;

import persistence.PersistenceException;
import persistence.PersistentAccount;
import persistence.PersistentAccountManager;
import persistence.PersistentAccountTypeManager;
import persistence.PersistentAvgStrategy;
import persistence.PersistentMAccountType;
import persistence.PersistentMAspect;
import persistence.PersistentMMeasurementType;
import persistence.PersistentMObject;
import persistence.PersistentMType;
import persistence.PersistentMaxStrategy;
import persistence.PersistentMeasurement;
import persistence.PersistentMeasurementTypeManager;
import persistence.PersistentMinStrategy;
import persistence.PersistentQuantity;
import persistence.PersistentSumStrategy;
import persistence.PersistentUnit;
import persistence.PersistentUnitType;
import util.InjectSingleton;
import util.TestingBase;

import common.Fraction;

public class StrategyTest extends TestingBase {

	@InjectSingleton(AccountManager.class)
	private PersistentAccountManager accountMan;

	@InjectSingleton(AccountTypeManager.class)
	private PersistentAccountTypeManager accountTypeMan;

	@InjectSingleton(MeasurementTypeManager.class)
	private PersistentMeasurementTypeManager msmntTypeMan;

	@Test
	public void onSumStrategy_test01() throws PersistenceException, CycleException, ConsistencyException, NotComputableException {

		final PersistentMAspect aspect1 = MAspect.createMAspect("bla");
		final PersistentMType type = MAtomicType.createMAtomicType("A", mFalse, mFalse, aspect1, MEmptyTypeConjunction.getTheMEmptyTypeConjunction());
		final PersistentUnitType unitType1 = UnitType.createUnitType("Strecke");

		final PersistentMAccountType accType1 = MAccountType.createMAccountType(type, unitType1, "jau");

		final PersistentSumStrategy sumStrategy = SumStrategy.getTheSumStrategy();

		final PersistentMObject obj1 = MObject.createMObject();
		final PersistentMObject obj2 = MObject.createMObject();

		final PersistentAccount account = Account.createAccount(obj1, accType1, "jau");

		final PersistentUnit unit = Unit.createUnit(unitType1, "cm");
		unitType1.setDefaultUnit(unit);
		final PersistentQuantity quantity1 = Quantity.createQuantity(Fraction.parse("1/3"), unit);
		final PersistentQuantity quantity2 = Quantity.createQuantity(Fraction.parse("4/3"), unit);
		final PersistentQuantity quantity3 = Quantity.createQuantity(Fraction.parse("2/3"), unit);

		final PersistentMMeasurementType msmntType1 = MMeasurementType.createMMeasurementType(type, unitType1, "jau");
		final PersistentMeasurement msmnt1 = Measurement.createMeasurement(obj2, msmntType1, quantity1);
		final PersistentMeasurement msmnt2 = Measurement.createMeasurement(obj2, msmntType1, quantity2);
		final PersistentMeasurement msmnt3 = Measurement.createMeasurement(obj2, msmntType1, quantity3);

		// "1/3 cm"
		account.addEntry(msmnt1);
		// "4/3 cm"
		account.addEntry(msmnt2);
		// "2/3 cm"
		account.addEntry(msmnt3);

		final PersistentQuantity resultQuantity = (PersistentQuantity) account.aggregate(sumStrategy);
		assertEquals(Fraction.parse("7/3"), resultQuantity.getAmount());
		assertEquals(unit, resultQuantity.getUnit());

	}

	@Test
	public void onMinStrategy_test01() throws PersistenceException, CycleException, ConsistencyException, NotComputableException {

		final PersistentMAspect aspect1 = MAspect.createMAspect("bla");
		final PersistentMType type = MAtomicType.createMAtomicType("A", mFalse, mFalse, aspect1, MEmptyTypeConjunction.getTheMEmptyTypeConjunction());
		final PersistentUnitType unitType1 = UnitType.createUnitType("Strecke");

		final PersistentMAccountType accType1 = MAccountType.createMAccountType(type, unitType1, "jau");

		final PersistentMinStrategy minStrategy = MinStrategy.getTheMinStrategy();

		final PersistentMObject obj1 = MObject.createMObject();
		final PersistentMObject obj2 = MObject.createMObject();

		final PersistentAccount account = Account.createAccount(obj1, accType1, "jau");

		final PersistentUnit unit = Unit.createUnit(unitType1, "cm");
		unitType1.setDefaultUnit(unit);
		final PersistentQuantity quantity1 = Quantity.createQuantity(Fraction.parse("1/3"), unit);
		final PersistentQuantity quantity2 = Quantity.createQuantity(Fraction.parse("4/3"), unit);
		final PersistentQuantity quantity3 = Quantity.createQuantity(Fraction.parse("2/3"), unit);

		final PersistentMMeasurementType msmntType1 = MMeasurementType.createMMeasurementType(type, unitType1, "jau");
		final PersistentMeasurement msmnt1 = Measurement.createMeasurement(obj2, msmntType1, quantity1);
		final PersistentMeasurement msmnt2 = Measurement.createMeasurement(obj2, msmntType1, quantity2);
		final PersistentMeasurement msmnt3 = Measurement.createMeasurement(obj2, msmntType1, quantity3);

		// "1/3 cm"
		account.addEntry(msmnt1);
		// "4/3 cm"
		account.addEntry(msmnt2);
		// "2/3 cm"
		account.addEntry(msmnt3);

		final PersistentQuantity resultQuantity = (PersistentQuantity) account.aggregate(minStrategy);
		assertEquals(Fraction.parse("1/3"), resultQuantity.getAmount());
		assertEquals(unit, resultQuantity.getUnit());

	}

	@Test
	public void onMaxStrategy_test01() throws PersistenceException, CycleException, ConsistencyException, NotComputableException {

		final PersistentMAspect aspect1 = MAspect.createMAspect("bla");
		final PersistentMType type = MAtomicType.createMAtomicType("A", mFalse, mFalse, aspect1, MEmptyTypeConjunction.getTheMEmptyTypeConjunction());
		final PersistentUnitType unitType1 = UnitType.createUnitType("Strecke");

		final PersistentMAccountType accType1 = MAccountType.createMAccountType(type, unitType1, "jau");

		final PersistentMaxStrategy maxStrategy = MaxStrategy.getTheMaxStrategy();

		final PersistentMObject obj1 = MObject.createMObject();
		final PersistentMObject obj2 = MObject.createMObject();

		final PersistentAccount account = Account.createAccount(obj1, accType1, "jau");

		final PersistentUnit unit = Unit.createUnit(unitType1, "cm");
		unitType1.setDefaultUnit(unit);
		final PersistentQuantity quantity1 = Quantity.createQuantity(Fraction.parse("1/3"), unit);
		final PersistentQuantity quantity2 = Quantity.createQuantity(Fraction.parse("4/3"), unit);
		final PersistentQuantity quantity3 = Quantity.createQuantity(Fraction.parse("2/3"), unit);

		final PersistentMMeasurementType msmntType1 = MMeasurementType.createMMeasurementType(type, unitType1, "jau");
		final PersistentMeasurement msmnt1 = Measurement.createMeasurement(obj2, msmntType1, quantity1);
		final PersistentMeasurement msmnt2 = Measurement.createMeasurement(obj2, msmntType1, quantity2);
		final PersistentMeasurement msmnt3 = Measurement.createMeasurement(obj2, msmntType1, quantity3);

		// "1/3 cm"
		account.addEntry(msmnt1);
		// "4/3 cm"
		account.addEntry(msmnt2);
		// "2/3 cm"
		account.addEntry(msmnt3);

		final PersistentQuantity resultQuantity = (PersistentQuantity) account.aggregate(maxStrategy);
		assertEquals(Fraction.parse("4/3"), resultQuantity.getAmount());
		assertEquals(unit, resultQuantity.getUnit());
	}

	@Test
	public void onAvgStrategy_test01() throws PersistenceException, CycleException, ConsistencyException, NotComputableException {

		final PersistentMAspect aspect1 = MAspect.createMAspect("bla");
		final PersistentMType type = MAtomicType.createMAtomicType("A", mFalse, mFalse, aspect1, MEmptyTypeConjunction.getTheMEmptyTypeConjunction());
		final PersistentUnitType unitType1 = UnitType.createUnitType("Strecke");

		final PersistentMAccountType accType1 = MAccountType.createMAccountType(type, unitType1, "jau");

		final PersistentAvgStrategy avgStrategy = AvgStrategy.getTheAvgStrategy();

		final PersistentMObject obj1 = MObject.createMObject();
		final PersistentMObject obj2 = MObject.createMObject();

		final PersistentAccount account = Account.createAccount(obj1, accType1, "jau");

		final PersistentUnit unit = Unit.createUnit(unitType1, "cm");
		unitType1.setDefaultUnit(unit);
		final PersistentQuantity quantity1 = Quantity.createQuantity(Fraction.parse("1/3"), unit);
		final PersistentQuantity quantity2 = Quantity.createQuantity(Fraction.parse("4/3"), unit);
		final PersistentQuantity quantity3 = Quantity.createQuantity(Fraction.parse("2/3"), unit);

		final PersistentMMeasurementType msmntType1 = MMeasurementType.createMMeasurementType(type, unitType1, "jau");
		final PersistentMeasurement msmnt1 = Measurement.createMeasurement(obj2, msmntType1, quantity1);
		final PersistentMeasurement msmnt2 = Measurement.createMeasurement(obj2, msmntType1, quantity2);
		final PersistentMeasurement msmnt3 = Measurement.createMeasurement(obj2, msmntType1, quantity3);

		// "1/3 cm"
		account.addEntry(msmnt1);
		// "4/3 cm"
		account.addEntry(msmnt2);
		// "2/3 cm"
		account.addEntry(msmnt3);

		// Was ist der Durchschnitt von 1/3, 4/3 und 2/3? ~0,7777
		final PersistentQuantity resultQuantity = (PersistentQuantity) account.aggregate(avgStrategy);
		assertEquals(Fraction.parse("7/1"), resultQuantity.getAmount());
		assertEquals(unit, resultQuantity.getUnit());

	}
}

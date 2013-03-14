package model.measurement;

import static org.junit.Assert.fail;
import model.ConsistencyException;
import model.CycleException;
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
import persistence.PersistentMAccountType;
import persistence.PersistentMAspect;
import persistence.PersistentMMeasurementType;
import persistence.PersistentMObject;
import persistence.PersistentMType;
import persistence.PersistentMeasurement;
import persistence.PersistentMeasurementTypeManager;
import persistence.PersistentQuantity;
import persistence.PersistentSumStrategy;
import persistence.PersistentUnit;
import persistence.PersistentUnitType;
import util.InjectSingleton;
import util.TestingBase;

import common.Fraction;

public class MeasurementTest extends TestingBase {

	@InjectSingleton(AccountManager.class)
	private PersistentAccountManager accountMan;

	@InjectSingleton(AccountTypeManager.class)
	private PersistentAccountTypeManager accountTypeMan;

	@InjectSingleton(MeasurementTypeManager.class)
	private PersistentMeasurementTypeManager msmntTypeMan;

	@Test
	public void onMeasurement_test01() throws PersistenceException, CycleException, ConsistencyException {

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

		try {
			msmnt1.delete();
		} catch (final ConsistencyException e) {
			fail("Measurements sollen immer gelöscht werden können!");
		}
	}

}

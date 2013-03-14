package model.measurement;

import static org.junit.Assert.fail;
import model.ConsistencyException;
import model.CycleException;
import model.quantity.UnitType;
import model.typeSystem.MAspect;
import model.typeSystem.MAtomicType;
import model.typeSystem.MEmptyTypeConjunction;
import model.typeSystem.MObject;

import org.junit.Test;

import persistence.PersistenceException;
import persistence.PersistentAccountManager;
import persistence.PersistentAccountTypeManager;
import persistence.PersistentMAccountType;
import persistence.PersistentMAspect;
import persistence.PersistentMAtomicType;
import persistence.PersistentMObject;
import persistence.PersistentUnitType;
import util.InjectSingleton;
import util.TestingBase;

public class AccountTypeManagerTest extends TestingBase {

	@InjectSingleton(AccountManager.class)
	private PersistentAccountManager accountMan;

	@InjectSingleton(AccountTypeManager.class)
	private PersistentAccountTypeManager accountTypeMan;

	@Test(expected = ConsistencyException.class)
	public void onAccount_test01() throws PersistenceException, CycleException, ConsistencyException {
		final PersistentMAspect aspect1 = MAspect.createMAspect("bla");
		final PersistentMAtomicType type1 = MAtomicType.createMAtomicType("A", mFalse, mFalse, aspect1,
				MEmptyTypeConjunction.getTheMEmptyTypeConjunction());
		final PersistentUnitType unitType1 = UnitType.createUnitType("Zeit");

		final PersistentMAccountType accType1 = MAccountType.createMAccountType(type1, unitType1);

		final PersistentMObject obj1 = MObject.createMObject();

		Account.createAccount(obj1, accType1);

		accType1.delete();
		fail("Es existieren Exemplare!");
	}

}

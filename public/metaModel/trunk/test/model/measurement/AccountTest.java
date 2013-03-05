package model.measurement;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import model.ConsistencyException;
import model.CycleException;
import model.quantity.UnitType;
import model.typeSystem.MAspect;
import model.typeSystem.MAtomicType;
import model.typeSystem.MObject;

import org.junit.Test;

import persistence.PersistenceException;
import persistence.PersistentAccount;
import persistence.PersistentAccountManager;
import persistence.PersistentAccountTypeManager;
import persistence.PersistentMAccountType;
import persistence.PersistentMAspect;
import persistence.PersistentMAtomicType;
import persistence.PersistentMObject;
import persistence.PersistentUnitType;
import util.InjectSingleton;
import util.TestingBase;
import constants.ExceptionConstants;

public class AccountTest extends TestingBase {

	@InjectSingleton(AccountManager.class)
	private PersistentAccountManager accountMan;

	@InjectSingleton(AccountTypeManager.class)
	private PersistentAccountTypeManager accountTypeMan;

	@Test
	public void onAccount_test01() throws PersistenceException, CycleException {

		final PersistentMAspect aspect1 = MAspect.createMAspect("bla");
		final PersistentMAtomicType type1 = MAtomicType.createMAtomicType("A", mFalse, mFalse, aspect1);
		final PersistentUnitType unitType1 = UnitType.createUnitType("Zeit");

		final PersistentMAccountType accType1 = MAccountType.createMAccountType(type1, unitType1);
		final PersistentMAccountType accType2 = MAccountType.createMAccountType(type1, unitType1);

		final PersistentMObject obj1 = MObject.createMObject();
		final PersistentMObject obj2 = MObject.createMObject();

		final PersistentAccount a1 = Account.createAccount(obj1, accType1);

		final PersistentAccount a2 = Account.createAccount(obj2, accType2);

		try {
			a1.addSubAccount(a2);
			fail("Accounts sind nicht vom gleichen Typ!");
		} catch (final ConsistencyException e) {
			// Exception korrekt!
			assertEquals(ExceptionConstants.WRONG_ACCOUNT_TYPE, e.getMessage());
		}
	}

}

package model.measurement;

import static org.junit.Assert.assertEquals;
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
		final PersistentMAtomicType type1 = MAtomicType.createMAtomicType("A", mFalse, mFalse, aspect1,
				MEmptyTypeConjunction.getTheMEmptyTypeConjunction());
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

	@Test
	public void onAccount_test02() throws PersistenceException, CycleException {

		final PersistentMAspect aspect1 = MAspect.createMAspect("bla");
		final PersistentMAtomicType type1 = MAtomicType.createMAtomicType("A", mFalse, mFalse, aspect1,
				MEmptyTypeConjunction.getTheMEmptyTypeConjunction());
		final PersistentUnitType unitType1 = UnitType.createUnitType("Zeit");

		final PersistentMAccountType accType1 = MAccountType.createMAccountType(type1, unitType1);
		final PersistentMAccountType accType2 = MAccountType.createMAccountType(type1, unitType1);
		accType1.addSubAccountType(accType2);

		final PersistentMObject obj1 = MObject.createMObject();
		final PersistentMObject obj2 = MObject.createMObject();

		final PersistentAccount a1 = Account.createAccount(obj1, accType1);
		final PersistentAccount a2 = Account.createAccount(obj2, accType2);

		try {
			a1.addSubAccount(a2);
		} catch (final ConsistencyException e) {
			// Exception falsch!
			fail("Muss funktionieren, da accType2 <= accType1!");
		}
	}

	@Test
	public void onAccount_test03() throws PersistenceException, CycleException {

		final PersistentMAspect aspect1 = MAspect.createMAspect("bla");
		final PersistentMAtomicType type1 = MAtomicType.createMAtomicType("A", mFalse, mFalse, aspect1,
				MEmptyTypeConjunction.getTheMEmptyTypeConjunction());
		final PersistentUnitType unitType1 = UnitType.createUnitType("Zeit");

		final PersistentMAccountType accType1 = MAccountType.createMAccountType(type1, unitType1);
		final PersistentMAccountType accType2 = MAccountType.createMAccountType(type1, unitType1);
		final PersistentMAccountType accType3 = MAccountType.createMAccountType(type1, unitType1);
		accType1.addSubAccountType(accType2);
		accType2.addSubAccountType(accType3);

		final PersistentMObject obj1 = MObject.createMObject();
		final PersistentMObject obj2 = MObject.createMObject();

		final PersistentAccount a1 = Account.createAccount(obj1, accType1);
		final PersistentAccount a2 = Account.createAccount(obj2, accType3);

		try {
			a1.addSubAccount(a2);
		} catch (final ConsistencyException e) {
			// Exception falsch!
			fail("Muss funktionieren, da accType3 <= accType1!");
		}
	}

	@Test
	public void onAccount_test04() throws PersistenceException, CycleException {

		final PersistentMAspect aspect1 = MAspect.createMAspect("bla");
		final PersistentMAtomicType type1 = MAtomicType.createMAtomicType("A", mFalse, mFalse, aspect1,
				MEmptyTypeConjunction.getTheMEmptyTypeConjunction());
		final PersistentUnitType unitType1 = UnitType.createUnitType("Zeit");

		final PersistentMAccountType accType1 = MAccountType.createMAccountType(type1, unitType1);
		final PersistentMAccountType accType2 = MAccountType.createMAccountType(type1, unitType1);
		final PersistentMAccountType accType3 = MAccountType.createMAccountType(type1, unitType1);
		accType1.addSubAccountType(accType2);
		accType2.addSubAccountType(accType3);

		final PersistentMObject obj1 = MObject.createMObject();
		final PersistentMObject obj2 = MObject.createMObject();

		final PersistentAccount a1 = Account.createAccount(obj1, accType3);
		final PersistentAccount a2 = Account.createAccount(obj2, accType1);

		try {
			a1.addSubAccount(a2);
			fail("Darf nicht funktionieren, da accType3 NICHT<= accType1!");
		} catch (final ConsistencyException e) {
			// Exception korrekt!
			assertEquals(ExceptionConstants.WRONG_ACCOUNT_TYPE, e.getMessage());
		}
	}

	@Test
	public void onAccount_test05() throws PersistenceException, CycleException {

		final PersistentMAspect aspect1 = MAspect.createMAspect("bla");
		final PersistentMAtomicType type1 = MAtomicType.createMAtomicType("A", mFalse, mFalse, aspect1,
				MEmptyTypeConjunction.getTheMEmptyTypeConjunction());
		final PersistentUnitType unitType1 = UnitType.createUnitType("Zeit");

		final PersistentMAccountType accType1 = MAccountType.createMAccountType(type1, unitType1);
		final PersistentMAccountType accType2 = MAccountType.createMAccountType(type1, unitType1);
		final PersistentMAccountType accType3 = MAccountType.createMAccountType(type1, unitType1);
		final PersistentMAccountType accType4 = MAccountType.createMAccountType(type1, unitType1);
		accType1.addSubAccountType(accType2);
		accType2.addSubAccountType(accType3);
		accType2.addSubAccountType(accType4);

		final PersistentMObject obj1 = MObject.createMObject();
		final PersistentMObject obj2 = MObject.createMObject();
		final PersistentMObject obj3 = MObject.createMObject();

		final PersistentAccount a1 = Account.createAccount(obj1, accType1);
		final PersistentAccount a2 = Account.createAccount(obj2, accType3);
		final PersistentAccount a3 = Account.createAccount(obj2, accType4);

		try {
			a1.addSubAccount(a2);
			a1.addSubAccount(a3);
		} catch (final ConsistencyException e) {
			// Exception falsch!
			fail("Muss funktionieren, da accType3 und accType4<=accType2 und accType2<=accType1!");
		}
	}

	@Test
	public void onAccount_test06() throws PersistenceException, CycleException {

		final PersistentMAspect aspect1 = MAspect.createMAspect("bla");
		final PersistentMAtomicType type1 = MAtomicType.createMAtomicType("A", mFalse, mFalse, aspect1,
				MEmptyTypeConjunction.getTheMEmptyTypeConjunction());
		final PersistentUnitType unitType1 = UnitType.createUnitType("Zeit");

		final PersistentMAccountType accType1 = MAccountType.createMAccountType(type1, unitType1);
		final PersistentMAccountType accType2 = MAccountType.createMAccountType(type1, unitType1);
		final PersistentMAccountType accType3 = MAccountType.createMAccountType(type1, unitType1);
		final PersistentMAccountType accType4 = MAccountType.createMAccountType(type1, unitType1);
		final PersistentMAccountType accType5 = MAccountType.createMAccountType(type1, unitType1);
		accType1.addSubAccountType(accType2);
		accType1.addSubAccountType(accType3);
		accType3.addSubAccountType(accType4);
		accType3.addSubAccountType(accType5);

		final PersistentMObject obj1 = MObject.createMObject();
		final PersistentMObject obj2 = MObject.createMObject();

		final PersistentAccount a1 = Account.createAccount(obj1, accType2);
		final PersistentAccount a2 = Account.createAccount(obj2, accType5);

		try {
			a1.addSubAccount(a2);
			fail("Darf nicht funktionieren, da accType5 NICHT<= accType2!");
		} catch (final ConsistencyException e) {
			// Exception korrekt!
			assertEquals(ExceptionConstants.WRONG_ACCOUNT_TYPE, e.getMessage());
		}
	}

}

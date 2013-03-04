package model.measurement;

import org.junit.Test;

import persistence.PersistenceException;
import persistence.PersistentAccountManager;
import persistence.PersistentAccountTypeManager;
import util.InjectSingleton;
import util.TestingBase;

public class AccountTest extends TestingBase {

	@InjectSingleton(AccountManager.class)
	private PersistentAccountManager accountMan;

	@InjectSingleton(AccountTypeManager.class)
	private PersistentAccountTypeManager accountTypeMan;

	@Test
	public void onAccount_test01() throws PersistenceException {

		// PersistentAccount a1 = accountMan.createAccount(name, type, object);

		// org.junit.Assert.assertEquals();
	}

}

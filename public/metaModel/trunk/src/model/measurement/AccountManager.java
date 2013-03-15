package model.measurement;

import model.UserException;
import model.visitor.AnythingExceptionVisitor;
import model.visitor.AnythingReturnExceptionVisitor;
import model.visitor.AnythingReturnVisitor;
import model.visitor.AnythingVisitor;
import persistence.AccountManagerProxi;
import persistence.AccountManager_AccountsProxi;
import persistence.Anything;
import persistence.ConnectionHandler;
import persistence.Invoker;
import persistence.PersistenceException;
import persistence.PersistentAccount;
import persistence.PersistentAccountManager;
import persistence.PersistentCreateAccountCommand;
import persistence.PersistentDeleteAccountCommand;
import persistence.PersistentDeleteEntryCommand;
import persistence.PersistentMAccountType;
import persistence.PersistentMObject;
import persistence.PersistentMeasurement;
import persistence.PersistentObject;
import persistence.PersistentProxi;
import persistence.Predcate;
import persistence.TDObserver;

/* Additional import section end */

public class AccountManager extends PersistentObject implements PersistentAccountManager {

	private static PersistentAccountManager theAccountManager = null;
	public static boolean reset$For$Test = false;
	private static final Object $$lock = new Object();

	public static PersistentAccountManager getTheAccountManager() throws PersistenceException {
		if (theAccountManager == null || reset$For$Test) {
			class Initializer implements Runnable {
				PersistenceException exception = null;

				@Override
				public void run() {
					try {
						AccountManagerProxi proxi = null;
						synchronized ($$lock) {
							proxi = ConnectionHandler.getTheConnectionHandler().theAccountManagerFacade.getTheAccountManager();
							theAccountManager = proxi;
						}
						if (proxi.getId() < 0) {
							proxi.setId(proxi.getId() * -1);
							proxi.initialize(proxi, new java.util.Hashtable<String, Object>());
							proxi.initializeOnCreation();
						}
					} catch (final PersistenceException e) {
						exception = e;
					}
					synchronized ($$lock) {
						$$lock.notify();
					}
				}

				PersistentAccountManager getResult() throws PersistenceException {
					if (exception != null)
						throw exception;
					return theAccountManager;
				}
			}
			synchronized ($$lock) {
				reset$For$Test = false;
				final Initializer initializer = new Initializer();
				new Thread(initializer).start();
				try {
					$$lock.wait();
				} catch (final InterruptedException e) {
				} // Need not to be interrupted
				return initializer.getResult();
			}
		}
		return theAccountManager;
	}

	@Override
	public java.util.Hashtable<String, Object> toHashtable(final java.util.Hashtable<String, Object> allResults, final int depth,
			final int essentialLevel, final boolean forGUI, final boolean leaf, final TDObserver tdObserver) throws PersistenceException {
		java.util.Hashtable<String, Object> result = null;
		if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth) {
			result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
			result.put("accounts", this.getAccounts().getVector(allResults, depth, essentialLevel, forGUI, tdObserver, false, essentialLevel == 0));
			final String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
			if (leaf && !allResults.contains(uniqueKey))
				allResults.put(uniqueKey, result);
		}
		return result;
	}

	@Override
	public AccountManager provideCopy() throws PersistenceException {
		AccountManager result = this;
		result = new AccountManager(this.This, this.getId());
		result.accounts = this.accounts.copy(result);
		this.copyingPrivateUserAttributes(result);
		return result;
	}

	@Override
	public boolean hasEssentialFields() throws PersistenceException {
		return false;
	}

	protected AccountManager_AccountsProxi accounts;
	protected PersistentAccountManager This;

	public AccountManager(final PersistentAccountManager This, final long id) throws persistence.PersistenceException {
		/* Shall not be used by clients for object construction! Use static create operation instead! */
		super(id);
		this.accounts = new AccountManager_AccountsProxi(this);
		if (This != null && !(this.equals(This)))
			this.This = This;
	}

	static public long getTypeId() {
		return 143;
	}

	@Override
	public long getClassId() {
		return getTypeId();
	}

	@Override
	public void store() throws PersistenceException {
		// Singletons cannot be delayed!
	}

	@Override
	public AccountManager_AccountsProxi getAccounts() throws PersistenceException {
		return this.accounts;
	}

	protected void setThis(final PersistentAccountManager newValue) throws PersistenceException {
		if (newValue == null)
			throw new PersistenceException("Null values not allowed!", 0);
		if (newValue.equals(this)) {
			this.This = null;
			return;
		}
		if (newValue.equals(this.This))
			return;
		final long objectId = newValue.getId();
		final long classId = newValue.getClassId();
		this.This = (PersistentAccountManager) PersistentProxi.createProxi(objectId, classId);
		if (!this.isDelayed$Persistence()) {
			newValue.store();
			ConnectionHandler.getTheConnectionHandler().theAccountManagerFacade.ThisSet(this.getId(), newValue);
		}
	}

	@Override
	public PersistentAccountManager getThis() throws PersistenceException {
		if (this.This == null) {
			final PersistentAccountManager result = new AccountManagerProxi(this.getId());
			result.getTheObject();
			return result;
		}
		return this.This;
	}

	@Override
	public void accept(final AnythingVisitor visitor) throws PersistenceException {
		visitor.handleAccountManager(this);
	}

	@Override
	public <R> R accept(final AnythingReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleAccountManager(this);
	}

	@Override
	public <E extends UserException> void accept(final AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
		visitor.handleAccountManager(this);
	}

	@Override
	public <R, E extends UserException> R accept(final AnythingReturnExceptionVisitor<R, E> visitor) throws PersistenceException, E {
		return visitor.handleAccountManager(this);
	}

	@Override
	public int getLeafInfo() throws PersistenceException {
		if (this.getAccounts().getLength() > 0)
			return 1;
		return 0;
	}

	@Override
	public void createAccount(final String name, final PersistentMAccountType type, final PersistentMObject object, final Invoker invoker)
			throws PersistenceException {
		final java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		final PersistentCreateAccountCommand command = model.meta.CreateAccountCommand.createCreateAccountCommand(name, now, now);
		command.setType(type);
		command.setObject(object);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
	}

	// Start of section that contains operations that must be implemented.

	@Override
	public void deleteAccount(final PersistentAccount account, final Invoker invoker) throws PersistenceException {
		final java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		final PersistentDeleteAccountCommand command = model.meta.DeleteAccountCommand.createDeleteAccountCommand(now, now);
		command.setAccount(account);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
	}

	@Override
	public void deleteEntry(final PersistentMeasurement measurement, final Invoker invoker) throws PersistenceException {
		final java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		final PersistentDeleteEntryCommand command = model.meta.DeleteEntryCommand.createDeleteEntryCommand(now, now);
		command.setMeasurement(measurement);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
	}

	@Override
	public void initialize(final Anything This, final java.util.Hashtable<String, Object> final$$Fields) throws PersistenceException {
		this.setThis((PersistentAccountManager) This);
		if (this.equals(This)) {
		}
	}

	@Override
	public void copyingPrivateUserAttributes(final Anything copy) throws PersistenceException {
	}

	@Override
	public PersistentAccount createAccount(final String name, final PersistentMAccountType type, final PersistentMObject object)
			throws PersistenceException {
		final PersistentAccount result = Account.createAccount(object, type, name);
		this.getThis().getAccounts().add(result);
		return result;
	}

	@Override
	public void deleteAccount(final PersistentAccount account) throws model.ConsistencyException, PersistenceException {
		this.getThis().getAccounts().removeFirstSuccess(new Predcate<PersistentAccount>() {

			@Override
			public boolean test(final PersistentAccount argument) throws PersistenceException {
				return account.equals(argument);
			}
		});
		account.delete();
	}

	@Override
	public void deleteEntry(final PersistentMeasurement measurement) throws model.ConsistencyException, PersistenceException {
		measurement.inverseGetEntries().getEntries().removeFirstSuccess(new Predcate<PersistentMeasurement>() {

			@Override
			public boolean test(final PersistentMeasurement argument) throws PersistenceException {
				return measurement.equals(argument);
			}
		});
		measurement.delete();
	}

	@Override
	public void initializeOnCreation() throws PersistenceException {

	}

	@Override
	public void initializeOnInstantiation() throws PersistenceException {

	}

	// Start of section that contains overridden operations only.

	/* Start of protected part that is not overridden by persistence generator */

	/* End of protected part that is not overridden by persistence generator */

}

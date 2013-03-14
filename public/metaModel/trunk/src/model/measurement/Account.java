package model.measurement;

import model.ConsistencyException;
import model.UserException;
import model.visitor.AccountHierarchyHIERARCHYExceptionVisitor;
import model.visitor.AccountHierarchyHIERARCHYReturnExceptionVisitor;
import model.visitor.AccountHierarchyHIERARCHYReturnVisitor;
import model.visitor.AccountHierarchyHIERARCHYVisitor;
import model.visitor.AnythingExceptionVisitor;
import model.visitor.AnythingReturnExceptionVisitor;
import model.visitor.AnythingReturnVisitor;
import model.visitor.AnythingVisitor;
import model.visitor.MModelItemExceptionVisitor;
import model.visitor.MModelItemReturnExceptionVisitor;
import model.visitor.MModelItemReturnVisitor;
import model.visitor.MModelItemVisitor;
import model.visitor.QuantifObjectExceptionVisitor;
import model.visitor.QuantifObjectReturnExceptionVisitor;
import model.visitor.QuantifObjectReturnVisitor;
import model.visitor.QuantifObjectVisitor;
import persistence.AbstractPersistentRoot;
import persistence.AccountHierarchyHIERARCHY;
import persistence.AccountHierarchyHIERARCHYStrategy;
import persistence.AccountProxi;
import persistence.AccountSearchList;
import persistence.Account_EntriesProxi;
import persistence.Account_SubAccountsProxi;
import persistence.Anything;
import persistence.ConnectionHandler;
import persistence.Invoker;
import persistence.MModelItemSearchList;
import persistence.PersistenceException;
import persistence.PersistentAbsQuantity;
import persistence.PersistentAccount;
import persistence.PersistentAddEntryCommand;
import persistence.PersistentAddSubAccountCommand;
import persistence.PersistentAggregationStrategy;
import persistence.PersistentCONCMModelItem;
import persistence.PersistentMAccountType;
import persistence.PersistentMModelItem;
import persistence.PersistentMObject;
import persistence.PersistentMeasurement;
import persistence.PersistentProxi;
import persistence.PersistentQuantifObject;
import persistence.Predcate;
import persistence.TDObserver;
import utils.SearchLists;
import constants.ExceptionConstants;

/* Additional import section end */

public class Account extends model.measurement.QuantifObject implements PersistentAccount {

	public static PersistentAccount createAccount(final PersistentMObject object, final PersistentMAccountType type, final String name)
			throws PersistenceException {
		return createAccount(object, type, name, false);
	}

	public static PersistentAccount createAccount(final PersistentMObject object, final PersistentMAccountType type, final String name,
			final boolean delayed$Persistence) throws PersistenceException {
		if (name == null)
			throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
		PersistentAccount result = null;
		if (delayed$Persistence) {
			result = ConnectionHandler.getTheConnectionHandler().theAccountFacade.newDelayedAccount(name);
			result.setDelayed$Persistence(true);
		} else {
			result = ConnectionHandler.getTheConnectionHandler().theAccountFacade.newAccount(name, -1);
		}
		final java.util.Hashtable<String, Object> final$$Fields = new java.util.Hashtable<String, Object>();
		final$$Fields.put("object", object);
		final$$Fields.put("type", type);
		final$$Fields.put("name", name);
		result.initialize(result, final$$Fields);
		result.initializeOnCreation();
		return result;
	}

	public static PersistentAccount createAccount(final PersistentMObject object, final PersistentMAccountType type, final String name,
			final boolean delayed$Persistence, final PersistentAccount This) throws PersistenceException {
		if (name == null)
			throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
		PersistentAccount result = null;
		if (delayed$Persistence) {
			result = ConnectionHandler.getTheConnectionHandler().theAccountFacade.newDelayedAccount(name);
			result.setDelayed$Persistence(true);
		} else {
			result = ConnectionHandler.getTheConnectionHandler().theAccountFacade.newAccount(name, -1);
		}
		final java.util.Hashtable<String, Object> final$$Fields = new java.util.Hashtable<String, Object>();
		final$$Fields.put("object", object);
		final$$Fields.put("type", type);
		final$$Fields.put("name", name);
		result.initialize(This, final$$Fields);
		result.initializeOnCreation();
		return result;
	}

	@Override
	public java.util.Hashtable<String, Object> toHashtable(final java.util.Hashtable<String, Object> allResults, final int depth,
			final int essentialLevel, final boolean forGUI, final boolean leaf, final TDObserver tdObserver) throws PersistenceException {
		java.util.Hashtable<String, Object> result = null;
		if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth) {
			result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
			final AbstractPersistentRoot type = this.getType();
			if (type != null) {
				result.put("type", type.createProxiInformation(false, essentialLevel == 0));
				if (depth > 1) {
					type.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true, tdObserver);
				} else {
					if (forGUI && type.hasEssentialFields())
						type.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
				}
			}
			result.put("subAccounts",
					this.getSubAccounts().getVector(allResults, depth, essentialLevel, forGUI, tdObserver, false, essentialLevel == 0));
			result.put("entries", this.getEntries().getVector(allResults, depth, essentialLevel, forGUI, tdObserver, false, essentialLevel == 0));
			result.put("name", this.getName());
			final String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
			if (leaf && !allResults.contains(uniqueKey))
				allResults.put(uniqueKey, result);
		}
		return result;
	}

	public static AccountSearchList getAccountByName(final String name) throws PersistenceException {
		return ConnectionHandler.getTheConnectionHandler().theAccountFacade.getAccountByName(name);
	}

	@Override
	public Account provideCopy() throws PersistenceException {
		Account result = this;
		result = new Account(this.object, this.This, this.myCONCMModelItem, this.type, this.name, this.getId());
		result.subAccounts = this.subAccounts.copy(result);
		result.entries = this.entries.copy(result);
		this.copyingPrivateUserAttributes(result);
		return result;
	}

	@Override
	public boolean hasEssentialFields() throws PersistenceException {
		return true;
	}

	protected PersistentMAccountType type;
	protected Account_SubAccountsProxi subAccounts;
	protected Account_EntriesProxi entries;
	protected String name;

	public Account(final PersistentMObject object, final PersistentQuantifObject This, final PersistentMModelItem myCONCMModelItem,
			final PersistentMAccountType type, final String name, final long id) throws persistence.PersistenceException {
		/* Shall not be used by clients for object construction! Use static create operation instead! */
		super(object, This, myCONCMModelItem, id);
		this.type = type;
		this.subAccounts = new Account_SubAccountsProxi(this);
		this.entries = new Account_EntriesProxi(this);
		this.name = name;
	}

	static public long getTypeId() {
		return 183;
	}

	@Override
	public long getClassId() {
		return getTypeId();
	}

	@Override
	public void store() throws PersistenceException {
		if (!this.isDelayed$Persistence())
			return;
		if (this.getClassId() == 183)
			ConnectionHandler.getTheConnectionHandler().theAccountFacade.newAccount(name, this.getId());
		super.store();
		if (this.getType() != null) {
			this.getType().store();
			ConnectionHandler.getTheConnectionHandler().theAccountFacade.typeSet(this.getId(), getType());
		}
		this.getSubAccounts().store();
		this.getEntries().store();

	}

	@Override
	public PersistentMAccountType getType() throws PersistenceException {
		return this.type;
	}

	@Override
	public void setType(final PersistentMAccountType newValue) throws PersistenceException {
		if (newValue == null)
			throw new PersistenceException("Null values not allowed!", 0);
		if (newValue.equals(this.type))
			return;
		final long objectId = newValue.getId();
		final long classId = newValue.getClassId();
		this.type = (PersistentMAccountType) PersistentProxi.createProxi(objectId, classId);
		if (!this.isDelayed$Persistence()) {
			newValue.store();
			ConnectionHandler.getTheConnectionHandler().theAccountFacade.typeSet(this.getId(), newValue);
		}
	}

	@Override
	public Account_SubAccountsProxi getSubAccounts() throws PersistenceException {
		return this.subAccounts;
	}

	@Override
	public Account_EntriesProxi getEntries() throws PersistenceException {
		return this.entries;
	}

	@Override
	public String getName() throws PersistenceException {
		return this.name;
	}

	@Override
	public void setName(final String newValue) throws PersistenceException {
		if (newValue == null)
			throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
		if (!this.isDelayed$Persistence())
			ConnectionHandler.getTheConnectionHandler().theAccountFacade.nameSet(this.getId(), newValue);
		this.name = newValue;
	}

	@Override
	public PersistentAccount getThis() throws PersistenceException {
		if (this.This == null) {
			final PersistentAccount result = new AccountProxi(this.getId());
			result.getTheObject();
			return result;
		}
		return (PersistentAccount) this.This;
	}

	@Override
	public void accept(final QuantifObjectVisitor visitor) throws PersistenceException {
		visitor.handleAccount(this);
	}

	@Override
	public <R> R accept(final QuantifObjectReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleAccount(this);
	}

	@Override
	public <E extends UserException> void accept(final QuantifObjectExceptionVisitor<E> visitor) throws PersistenceException, E {
		visitor.handleAccount(this);
	}

	@Override
	public <R, E extends UserException> R accept(final QuantifObjectReturnExceptionVisitor<R, E> visitor) throws PersistenceException, E {
		return visitor.handleAccount(this);
	}

	@Override
	public void accept(final MModelItemVisitor visitor) throws PersistenceException {
		visitor.handleAccount(this);
	}

	@Override
	public <R> R accept(final MModelItemReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleAccount(this);
	}

	@Override
	public <E extends UserException> void accept(final MModelItemExceptionVisitor<E> visitor) throws PersistenceException, E {
		visitor.handleAccount(this);
	}

	@Override
	public <R, E extends UserException> R accept(final MModelItemReturnExceptionVisitor<R, E> visitor) throws PersistenceException, E {
		return visitor.handleAccount(this);
	}

	@Override
	public void accept(final AnythingVisitor visitor) throws PersistenceException {
		visitor.handleAccount(this);
	}

	@Override
	public <R> R accept(final AnythingReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleAccount(this);
	}

	@Override
	public <E extends UserException> void accept(final AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
		visitor.handleAccount(this);
	}

	@Override
	public <R, E extends UserException> R accept(final AnythingReturnExceptionVisitor<R, E> visitor) throws PersistenceException, E {
		return visitor.handleAccount(this);
	}

	@Override
	public void accept(final AccountHierarchyHIERARCHYVisitor visitor) throws PersistenceException {
		visitor.handleAccount(this);
	}

	@Override
	public <R> R accept(final AccountHierarchyHIERARCHYReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleAccount(this);
	}

	@Override
	public <E extends UserException> void accept(final AccountHierarchyHIERARCHYExceptionVisitor<E> visitor) throws PersistenceException, E {
		visitor.handleAccount(this);
	}

	@Override
	public <R, E extends UserException> R accept(final AccountHierarchyHIERARCHYReturnExceptionVisitor<R, E> visitor) throws PersistenceException, E {
		return visitor.handleAccount(this);
	}

	@Override
	public int getLeafInfo() throws PersistenceException {
		if (this.getObject() != null)
			return 1;
		if (this.getType() != null)
			return 1;
		if (this.getSubAccounts().getLength() > 0)
			return 1;
		if (this.getEntries().getLength() > 0)
			return 1;
		return 0;
	}

	@Override
	public void addEntry(final PersistentMeasurement measurement, final Invoker invoker) throws PersistenceException {
		final java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		final PersistentAddEntryCommand command = model.meta.AddEntryCommand.createAddEntryCommand(now, now);
		command.setMeasurement(measurement);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
	}

	// Start of section that contains operations that must be implemented.

	@Override
	public void addSubAccount(final PersistentAccount account, final Invoker invoker) throws PersistenceException {
		final java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		final PersistentAddSubAccountCommand command = model.meta.AddSubAccountCommand.createAddSubAccountCommand(now, now);
		command.setAccount(account);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
	}

	@Override
	public boolean containsAccountHierarchy(final AccountHierarchyHIERARCHY part) throws PersistenceException {
		if (getThis().equals(part))
			return true;
		final java.util.Iterator iterator0 = getThis().getSubAccounts().iterator();
		while (iterator0.hasNext())
			if (((AccountHierarchyHIERARCHY) iterator0.next()).containsAccountHierarchy(part))
				return true;
		return false;
	}

	@Override
	public void initialize(final Anything This, final java.util.Hashtable<String, Object> final$$Fields) throws PersistenceException {
		this.setThis((PersistentAccount) This);
		if (this.equals(This)) {
			final PersistentCONCMModelItem myCONCMModelItem = model.CONCMModelItem.createCONCMModelItem(this.isDelayed$Persistence(),
					(PersistentAccount) This);
			this.setMyCONCMModelItem(myCONCMModelItem);
			this.setObject((PersistentMObject) final$$Fields.get("object"));
			this.setType((PersistentMAccountType) final$$Fields.get("type"));
			this.setName((String) final$$Fields.get("name"));
		}
	}

	@Override
	public AccountSearchList inverseGetSubAccounts() throws PersistenceException {
		AccountSearchList result = null;
		if (result == null)
			result = ConnectionHandler.getTheConnectionHandler().theAccountFacade.inverseGetSubAccounts(this.getId(), this.getClassId());
		return result;
	}

	@Override
	public <T> T strategyAccountHierarchy(final T parameter, final AccountHierarchyHIERARCHYStrategy<T> strategy) throws PersistenceException {
		T result$$subAccounts$$Account = strategy.initialize$$Account$$subAccounts(getThis(), parameter);
		final java.util.Iterator iterator$$ = getThis().getSubAccounts().iterator();
		while (iterator$$.hasNext()) {
			final PersistentAccount current$$Field = (PersistentAccount) iterator$$.next();
			final T current$$ = current$$Field.strategyAccountHierarchy(result$$subAccounts$$Account, strategy);
			result$$subAccounts$$Account = strategy.consolidate$$Account$$subAccounts(getThis(), result$$subAccounts$$Account, current$$);
		}
		return strategy.finalize$$Account(getThis(), parameter, result$$subAccounts$$Account);
	}

	@Override
	public void addEntry(final PersistentMeasurement measurement) throws model.ConsistencyException, PersistenceException {
		if (!measurement.getType().getUnitType().equals(this.getThis().getType().getUnitType())) {
			throw new ConsistencyException(ExceptionConstants.UNIT_TYPE_DOES_NOT_MATCH_MEASUREMENT_ACCOUNT);
		}
		this.getThis().getEntries().add(measurement);
	}

	@Override
	public void addSubAccount(final PersistentAccount account) throws model.ConsistencyException, model.CycleException, PersistenceException {

		final PersistentMAccountType newAccType = account.getType();

		if (this.hasSameSuperType(newAccType)) {
			this.getThis().getSubAccounts().add(account);
		} else {
			throw new ConsistencyException(ExceptionConstants.WRONG_ACCOUNT_TYPE);
		}

	}

	@Override
	public void copyingPrivateUserAttributes(final Anything copy) throws PersistenceException {

	}

	@Override
	public MModelItemSearchList fetchDependentItems() throws PersistenceException {
		final MModelItemSearchList result = new MModelItemSearchList();

		// Subaccount Types
		SearchLists.addSecondToFirst(result, getThis().getEntries());

		// Accounts
		SearchLists.addSecondToFirst(result, getThis().getSubAccounts());

		return result;
	}

	@Override
	public void initializeOnCreation() throws PersistenceException {
	}

	@Override
	public void initializeOnInstantiation() throws PersistenceException {

	}

	@Override
	public void prepareForDeletion() throws model.ConsistencyException, PersistenceException {
		// TODO: implement method: prepareForDeletion

	}

	// Start of section that contains overridden operations only.

	@Override
	public PersistentAbsQuantity aggregate(final PersistentAggregationStrategy strategy) throws model.ConsistencyException,
			model.NotComputableException, PersistenceException {
		return strategy.aggregateMeasurements(this.getThis().getType().getUnitType(), this.getThis().getEntries().getList());
	}

	/* Start of protected part that is not overridden by persistence generator */

	private boolean hasSameSuperType(final PersistentMAccountType accType) throws PersistenceException {
		if (accType.equals(this.getThis().getType())) {
			return true;
		} else if (accType.inverseGetSubAccountTypes().getLength() > 0) {

			final PersistentMAccountType parent = accType.inverseGetSubAccountTypes().findFirst(new Predcate<PersistentMAccountType>() {

				@Override
				public boolean test(final PersistentMAccountType argument) throws PersistenceException {
					return true;
				}
			});

			return this.hasSameSuperType(parent);
		}
		return false;
	}

	/* End of protected part that is not overridden by persistence generator */

}

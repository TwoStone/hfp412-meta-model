package model;

import model.basic.MBoolean;
import model.basic.MFalse;
import model.measurement.Measurement;
import model.measurement.MeasurementTypeManager;
import model.meta.StringFACTORY;
import model.observations.EnumValueManager;
import model.observations.EnumerationManager;
import model.observations.ObsTypeManager;
import model.observations.ObservationManager;
import model.quantity.QuantityManager;
import model.visitor.AnythingExceptionVisitor;
import model.visitor.AnythingReturnExceptionVisitor;
import model.visitor.AnythingReturnVisitor;
import model.visitor.AnythingVisitor;
import model.visitor.InvokerExceptionVisitor;
import model.visitor.InvokerReturnExceptionVisitor;
import model.visitor.InvokerReturnVisitor;
import model.visitor.InvokerVisitor;
import model.visitor.RemoteExceptionVisitor;
import model.visitor.RemoteReturnExceptionVisitor;
import model.visitor.RemoteReturnVisitor;
import model.visitor.RemoteVisitor;
import persistence.AbsQuantitySearchList;
import persistence.AbsUnitSearchList;
import persistence.AbstractPersistentRoot;
import persistence.AccountSearchList;
import persistence.Anything;
import persistence.AssociationSearchList;
import persistence.Command;
import persistence.ConnectionHandler;
import persistence.FormalParameterSearchList;
import persistence.MAccountTypeSearchList;
import persistence.MAtomicTypeSearchList;
import persistence.MEnumSearchList;
import persistence.MEnumValueSearchList;
import persistence.MMeasurementTypeSearchList;
import persistence.MObjectSearchList;
import persistence.MTypeSearchList;
import persistence.NameSchemeSearchList;
import persistence.PersistenceException;
import persistence.PersistentAbsQuantity;
import persistence.PersistentAbsUnit;
import persistence.PersistentAbsUnitType;
import persistence.PersistentAccount;
import persistence.PersistentAccountManager;
import persistence.PersistentAccountTypeManager;
import persistence.PersistentAspectManager;
import persistence.PersistentAssociation;
import persistence.PersistentAssociationManager;
import persistence.PersistentEnumValueManager;
import persistence.PersistentEnumerationManager;
import persistence.PersistentFormalParameter;
import persistence.PersistentFractionManager;
import persistence.PersistentHierarchy;
import persistence.PersistentLink;
import persistence.PersistentLinkManager;
import persistence.PersistentMAccountType;
import persistence.PersistentMAspect;
import persistence.PersistentMAtomicType;
import persistence.PersistentMComplexType;
import persistence.PersistentMEnum;
import persistence.PersistentMEnumValue;
import persistence.PersistentMMeasurementType;
import persistence.PersistentMObject;
import persistence.PersistentMObservation;
import persistence.PersistentMObservationType;
import persistence.PersistentMType;
import persistence.PersistentMeasurement;
import persistence.PersistentMeasurementTypeManager;
import persistence.PersistentMessageManager;
import persistence.PersistentName;
import persistence.PersistentNameScheme;
import persistence.PersistentNameSchemeManager;
import persistence.PersistentObject;
import persistence.PersistentObjectManager;
import persistence.PersistentObsTypeManager;
import persistence.PersistentObservationManager;
import persistence.PersistentOperation;
import persistence.PersistentOperationManager;
import persistence.PersistentProxi;
import persistence.PersistentQuantity;
import persistence.PersistentQuantityManager;
import persistence.PersistentServer;
import persistence.PersistentTypeManager;
import persistence.PersistentUnit;
import persistence.PersistentUnitType;
import persistence.PersistentUnitTypeManager;
import persistence.Predcate;
import persistence.ServerProxi;
import persistence.ServerSearchList;
import persistence.Server_ErrorsProxi;
import persistence.TDObserver;
import persistence.UnitTypeSearchList;

import common.Fraction;

/* Additional import section end */

public class Server extends PersistentObject implements PersistentServer {

	/** Throws persistence exception if the object with the given id does not exist. */
	public static PersistentServer getById(final long objectId) throws PersistenceException {
		final long classId = ConnectionHandler.getTheConnectionHandler().theServerFacade.getClass(objectId);
		return (PersistentServer) PersistentProxi.createProxi(objectId, classId);
	}

	public static PersistentServer createServer(final String password, final String user, final long hackCount, final java.sql.Timestamp hackDelay)
			throws PersistenceException {
		return createServer(password, user, hackCount, hackDelay, false);
	}

	public static PersistentServer createServer(final String password, final String user, final long hackCount, final java.sql.Timestamp hackDelay,
			final boolean delayed$Persistence) throws PersistenceException {
		if (password == null)
			throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
		if (user == null)
			throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
		PersistentServer result = null;
		if (delayed$Persistence) {
			result = ConnectionHandler.getTheConnectionHandler().theServerFacade.newDelayedServer(password, user, hackCount, hackDelay);
			result.setDelayed$Persistence(true);
		} else {
			result = ConnectionHandler.getTheConnectionHandler().theServerFacade.newServer(password, user, hackCount, hackDelay, -1);
		}
		final java.util.Hashtable<String, Object> final$$Fields = new java.util.Hashtable<String, Object>();
		final$$Fields.put("password", password);
		final$$Fields.put("user", user);
		final$$Fields.put("hackCount", hackCount);
		final$$Fields.put("hackDelay", hackDelay);
		result.initialize(result, final$$Fields);
		result.initializeOnCreation();
		return result;
	}

	public static PersistentServer createServer(final String password, final String user, final long hackCount, final java.sql.Timestamp hackDelay,
			final boolean delayed$Persistence, final PersistentServer This) throws PersistenceException {
		if (password == null)
			throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
		if (user == null)
			throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
		PersistentServer result = null;
		if (delayed$Persistence) {
			result = ConnectionHandler.getTheConnectionHandler().theServerFacade.newDelayedServer(password, user, hackCount, hackDelay);
			result.setDelayed$Persistence(true);
		} else {
			result = ConnectionHandler.getTheConnectionHandler().theServerFacade.newServer(password, user, hackCount, hackDelay, -1);
		}
		final java.util.Hashtable<String, Object> final$$Fields = new java.util.Hashtable<String, Object>();
		final$$Fields.put("password", password);
		final$$Fields.put("user", user);
		final$$Fields.put("hackCount", hackCount);
		final$$Fields.put("hackDelay", hackDelay);
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
			final AbstractPersistentRoot aspectManager = this.getAspectManager(tdObserver);
			if (aspectManager != null) {
				result.put("aspectManager", aspectManager.createProxiInformation(false, essentialLevel == 0));
				if (depth > 1) {
					aspectManager.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true, tdObserver);
				} else {
					if (forGUI && aspectManager.hasEssentialFields())
						aspectManager.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
				}
			}
			final AbstractPersistentRoot typeManager = this.getTypeManager(tdObserver);
			if (typeManager != null) {
				result.put("typeManager", typeManager.createProxiInformation(false, essentialLevel == 0));
				if (depth > 1) {
					typeManager.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true, tdObserver);
				} else {
					if (forGUI && typeManager.hasEssentialFields())
						typeManager.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
				}
			}
			final AbstractPersistentRoot objectManager = this.getObjectManager(tdObserver);
			if (objectManager != null) {
				result.put("objectManager", objectManager.createProxiInformation(false, essentialLevel == 0));
				if (depth > 1) {
					objectManager.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true, tdObserver);
				} else {
					if (forGUI && objectManager.hasEssentialFields())
						objectManager.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
				}
			}
			final AbstractPersistentRoot associationManager = this.getAssociationManager(tdObserver);
			if (associationManager != null) {
				result.put("associationManager", associationManager.createProxiInformation(false, essentialLevel == 0));
				if (depth > 1) {
					associationManager.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true, tdObserver);
				} else {
					if (forGUI && associationManager.hasEssentialFields())
						associationManager.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
				}
			}
			final AbstractPersistentRoot linkManager = this.getLinkManager(tdObserver);
			if (linkManager != null) {
				result.put("linkManager", linkManager.createProxiInformation(false, essentialLevel == 0));
				if (depth > 1) {
					linkManager.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true, tdObserver);
				} else {
					if (forGUI && linkManager.hasEssentialFields())
						linkManager.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
				}
			}
			final AbstractPersistentRoot operationManager = this.getOperationManager(tdObserver);
			if (operationManager != null) {
				result.put("operationManager", operationManager.createProxiInformation(false, essentialLevel == 0));
				if (depth > 1) {
					operationManager.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true, tdObserver);
				} else {
					if (forGUI && operationManager.hasEssentialFields())
						operationManager.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
				}
			}
			final AbstractPersistentRoot messageManager = this.getMessageManager(tdObserver);
			if (messageManager != null) {
				result.put("messageManager", messageManager.createProxiInformation(false, essentialLevel == 0));
				if (depth > 1) {
					messageManager.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true, tdObserver);
				} else {
					if (forGUI && messageManager.hasEssentialFields())
						messageManager.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
				}
			}
			final AbstractPersistentRoot unitTypeManager = this.getUnitTypeManager(tdObserver);
			if (unitTypeManager != null) {
				result.put("unitTypeManager", unitTypeManager.createProxiInformation(false, essentialLevel == 0));
				if (depth > 1) {
					unitTypeManager.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true, tdObserver);
				} else {
					if (forGUI && unitTypeManager.hasEssentialFields())
						unitTypeManager.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
				}
			}
			final AbstractPersistentRoot quantityManager = this.getQuantityManager(tdObserver);
			if (quantityManager != null) {
				result.put("quantityManager", quantityManager.createProxiInformation(false, essentialLevel == 0));
				if (depth > 1) {
					quantityManager.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true, tdObserver);
				} else {
					if (forGUI && quantityManager.hasEssentialFields())
						quantityManager.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
				}
			}
			final AbstractPersistentRoot fractionManager = this.getFractionManager(tdObserver);
			if (fractionManager != null) {
				result.put("fractionManager", fractionManager.createProxiInformation(false, essentialLevel == 0));
				if (depth > 1) {
					fractionManager.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true, tdObserver);
				} else {
					if (forGUI && fractionManager.hasEssentialFields())
						fractionManager.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
				}
			}
			final AbstractPersistentRoot accountTypeManager = this.getAccountTypeManager(tdObserver);
			if (accountTypeManager != null) {
				result.put("accountTypeManager", accountTypeManager.createProxiInformation(false, essentialLevel == 0));
				if (depth > 1) {
					accountTypeManager.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true, tdObserver);
				} else {
					if (forGUI && accountTypeManager.hasEssentialFields())
						accountTypeManager.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
				}
			}
			final AbstractPersistentRoot accountManager = this.getAccountManager(tdObserver);
			if (accountManager != null) {
				result.put("accountManager", accountManager.createProxiInformation(false, essentialLevel == 0));
				if (depth > 1) {
					accountManager.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true, tdObserver);
				} else {
					if (forGUI && accountManager.hasEssentialFields())
						accountManager.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
				}
			}
			final AbstractPersistentRoot measurementTypeManager = this.getMeasurementTypeManager(tdObserver);
			if (measurementTypeManager != null) {
				result.put("measurementTypeManager", measurementTypeManager.createProxiInformation(false, essentialLevel == 0));
				if (depth > 1) {
					measurementTypeManager.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true, tdObserver);
				} else {
					if (forGUI && measurementTypeManager.hasEssentialFields())
						measurementTypeManager.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
				}
			}
			final AbstractPersistentRoot obsTypeManager = this.getObsTypeManager(tdObserver);
			if (obsTypeManager != null) {
				result.put("obsTypeManager", obsTypeManager.createProxiInformation(false, essentialLevel == 0));
				if (depth > 1) {
					obsTypeManager.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true, tdObserver);
				} else {
					if (forGUI && obsTypeManager.hasEssentialFields())
						obsTypeManager.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
				}
			}
			final AbstractPersistentRoot observationManager = this.getObservationManager(tdObserver);
			if (observationManager != null) {
				result.put("observationManager", observationManager.createProxiInformation(false, essentialLevel == 0));
				if (depth > 1) {
					observationManager.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true, tdObserver);
				} else {
					if (forGUI && observationManager.hasEssentialFields())
						observationManager.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
				}
			}
			final AbstractPersistentRoot enumManager = this.getEnumManager(tdObserver);
			if (enumManager != null) {
				result.put("enumManager", enumManager.createProxiInformation(false, essentialLevel == 0));
				if (depth > 1) {
					enumManager.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true, tdObserver);
				} else {
					if (forGUI && enumManager.hasEssentialFields())
						enumManager.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
				}
			}
			final AbstractPersistentRoot enumValueManager = this.getEnumValueManager(tdObserver);
			if (enumValueManager != null) {
				result.put("enumValueManager", enumValueManager.createProxiInformation(false, essentialLevel == 0));
				if (depth > 1) {
					enumValueManager.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true, tdObserver);
				} else {
					if (forGUI && enumValueManager.hasEssentialFields())
						enumValueManager.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
				}
			}
			final AbstractPersistentRoot nameSchemeManager = this.getNameSchemeManager(tdObserver);
			if (nameSchemeManager != null) {
				result.put("nameSchemeManager", nameSchemeManager.createProxiInformation(false, essentialLevel == 0));
				if (depth > 1) {
					nameSchemeManager.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true, tdObserver);
				} else {
					if (forGUI && nameSchemeManager.hasEssentialFields())
						nameSchemeManager.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
				}
			}
			result.put("errors", this.getErrors().getVector(allResults, depth, essentialLevel, forGUI, tdObserver, false, essentialLevel == 0));
			result.put("user", this.getUser());
			final String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
			if (leaf && !allResults.contains(uniqueKey))
				allResults.put(uniqueKey, result);
		}
		return result;
	}

	public static ServerSearchList getServerByUser(final String user) throws PersistenceException {
		return ConnectionHandler.getTheConnectionHandler().theServerFacade.getServerByUser(user);
	}

	@Override
	public Server provideCopy() throws PersistenceException {
		Server result = this;
		result = new Server(this.This, this.password, this.user, this.hackCount, this.hackDelay, this.getId());
		result.errors = this.errors.copy(result);
		result.errors = this.errors.copy(result);
		this.copyingPrivateUserAttributes(result);
		return result;
	}

	@Override
	public boolean hasEssentialFields() throws PersistenceException {
		return false;
	}

	protected PersistenceException exception = null;
	protected model.UserException userException = null;
	protected boolean changed = false;

	protected PersistentServer This;
	protected Server_ErrorsProxi errors;
	protected String password;
	protected String user;
	protected long hackCount;
	protected java.sql.Timestamp hackDelay;

	public Server(final PersistentServer This, final String password, final String user, final long hackCount, final java.sql.Timestamp hackDelay,
			final long id) throws persistence.PersistenceException {
		/* Shall not be used by clients for object construction! Use static create operation instead! */
		super(id);
		if (This != null && !(this.equals(This)))
			this.This = This;
		this.errors = new Server_ErrorsProxi(this);
		this.password = password;
		this.user = user;
		this.hackCount = hackCount;
		this.hackDelay = hackDelay;
	}

	static public long getTypeId() {
		return -112;
	}

	@Override
	public long getClassId() {
		return getTypeId();
	}

	@Override
	public void store() throws PersistenceException {
		if (!this.isDelayed$Persistence())
			return;
		if (this.getClassId() == -112)
			ConnectionHandler.getTheConnectionHandler().theServerFacade.newServer(password, user, hackCount, hackDelay, this.getId());
		super.store();
		if (!this.equals(this.getThis())) {
			this.getThis().store();
			ConnectionHandler.getTheConnectionHandler().theServerFacade.ThisSet(this.getId(), getThis());
		}

	}

	protected void setThis(final PersistentServer newValue) throws PersistenceException {
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
		this.This = (PersistentServer) PersistentProxi.createProxi(objectId, classId);
		if (!this.isDelayed$Persistence()) {
			newValue.store();
			ConnectionHandler.getTheConnectionHandler().theServerFacade.ThisSet(this.getId(), newValue);
		}
	}

	@Override
	public Server_ErrorsProxi getErrors() throws PersistenceException {
		return this.errors;
	}

	@Override
	public String getPassword() throws PersistenceException {
		return this.password;
	}

	@Override
	public void setPassword(final String newValue) throws PersistenceException {
		if (newValue == null)
			throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
		if (!this.isDelayed$Persistence())
			ConnectionHandler.getTheConnectionHandler().theServerFacade.passwordSet(this.getId(), newValue);
		this.password = newValue;
	}

	@Override
	public String getUser() throws PersistenceException {
		return this.user;
	}

	@Override
	public void setUser(final String newValue) throws PersistenceException {
		if (newValue == null)
			throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
		if (!this.isDelayed$Persistence())
			ConnectionHandler.getTheConnectionHandler().theServerFacade.userSet(this.getId(), newValue);
		this.user = newValue;
	}

	@Override
	public long getHackCount() throws PersistenceException {
		return this.hackCount;
	}

	@Override
	public void setHackCount(final long newValue) throws PersistenceException {
		if (!this.isDelayed$Persistence())
			ConnectionHandler.getTheConnectionHandler().theServerFacade.hackCountSet(this.getId(), newValue);
		this.hackCount = newValue;
	}

	@Override
	public java.sql.Timestamp getHackDelay() throws PersistenceException {
		return this.hackDelay;
	}

	@Override
	public void setHackDelay(final java.sql.Timestamp newValue) throws PersistenceException {
		if (!this.isDelayed$Persistence())
			ConnectionHandler.getTheConnectionHandler().theServerFacade.hackDelaySet(this.getId(), newValue);
		this.hackDelay = newValue;
	}

	@Override
	public PersistentServer getThis() throws PersistenceException {
		if (this.This == null) {
			final PersistentServer result = new ServerProxi(this.getId());
			result.getTheObject();
			return result;
		}
		return this.This;
	}

	@Override
	public void accept(final InvokerVisitor visitor) throws PersistenceException {
		visitor.handleServer(this);
	}

	@Override
	public <R> R accept(final InvokerReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleServer(this);
	}

	@Override
	public <E extends UserException> void accept(final InvokerExceptionVisitor<E> visitor) throws PersistenceException, E {
		visitor.handleServer(this);
	}

	@Override
	public <R, E extends UserException> R accept(final InvokerReturnExceptionVisitor<R, E> visitor) throws PersistenceException, E {
		return visitor.handleServer(this);
	}

	@Override
	public void accept(final RemoteVisitor visitor) throws PersistenceException {
		visitor.handleServer(this);
	}

	@Override
	public <R> R accept(final RemoteReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleServer(this);
	}

	@Override
	public <E extends UserException> void accept(final RemoteExceptionVisitor<E> visitor) throws PersistenceException, E {
		visitor.handleServer(this);
	}

	@Override
	public <R, E extends UserException> R accept(final RemoteReturnExceptionVisitor<R, E> visitor) throws PersistenceException, E {
		return visitor.handleServer(this);
	}

	@Override
	public void accept(final AnythingVisitor visitor) throws PersistenceException {
		visitor.handleServer(this);
	}

	@Override
	public <R> R accept(final AnythingReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleServer(this);
	}

	@Override
	public <E extends UserException> void accept(final AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
		visitor.handleServer(this);
	}

	@Override
	public <R, E extends UserException> R accept(final AnythingReturnExceptionVisitor<R, E> visitor) throws PersistenceException, E {
		return visitor.handleServer(this);
	}

	@Override
	public int getLeafInfo() throws PersistenceException {
		if (this.getAspectManager() != null)
			return 1;
		if (this.getTypeManager() != null)
			return 1;
		if (this.getObjectManager() != null)
			return 1;
		if (this.getAssociationManager() != null)
			return 1;
		if (this.getLinkManager() != null)
			return 1;
		if (this.getOperationManager() != null)
			return 1;
		if (this.getMessageManager() != null)
			return 1;
		if (this.getUnitTypeManager() != null)
			return 1;
		if (this.getQuantityManager() != null)
			return 1;
		if (this.getFractionManager() != null)
			return 1;
		if (this.getAccountTypeManager() != null)
			return 1;
		if (this.getAccountManager() != null)
			return 1;
		if (this.getMeasurementTypeManager() != null)
			return 1;
		if (this.getObsTypeManager() != null)
			return 1;
		if (this.getObservationManager() != null)
			return 1;
		if (this.getEnumManager() != null)
			return 1;
		if (this.getEnumValueManager() != null)
			return 1;
		if (this.getNameSchemeManager() != null)
			return 1;
		return 0;
	}

	@Override
	public AssociationSearchList a_Path_In_CreateHierarchy() throws model.UserException, PersistenceException {
		return new AssociationSearchList(getThis().getAssociationManager().getAssociations().getList());
	}

	// Start of section that contains operations that must be implemented.

	@Override
	public MAccountTypeSearchList child_Path_In_AddSubAccountType() throws model.UserException, PersistenceException {
		return new MAccountTypeSearchList(getThis().getAccountTypeManager().getAccountTypes().getList());
	}

	@Override
	public AccountSearchList child_Path_In_AddSubAccount() throws model.UserException, PersistenceException {
		return new AccountSearchList(getThis().getAccountManager().getAccounts().getList());
	}

	@Override
	public MTypeSearchList containees_Path_In_CreateTypeConjunction() throws model.UserException, PersistenceException {
		return new MTypeSearchList(getThis().getTypeManager().getTypes().getList());
	}

	@Override
	public MTypeSearchList containees_Path_In_CreateTypeDisjunction() throws model.UserException, PersistenceException {
		return new MTypeSearchList(getThis().getTypeManager().getTypes().getList());
	}

	@Override
	public AbsUnitSearchList defaultUnit_Path_In_SetDefaultUnit() throws model.UserException, PersistenceException {
		return new AbsUnitSearchList(getThis().getUnitTypeManager().getUnits().getList());
	}

	@Override
	public AbsQuantitySearchList dividend_Path_In_Div() throws model.UserException, PersistenceException {
		return new AbsQuantitySearchList(getThis().getQuantityManager().getQuantities().getList());
	}

	@Override
	public AbsQuantitySearchList divisor_Path_In_Div() throws model.UserException, PersistenceException {
		return new AbsQuantitySearchList(getThis().getQuantityManager().getQuantities().getList());
	}

	@Override
	public MEnumSearchList enumType_Path_In_CreateObsType() throws model.UserException, PersistenceException {
		return new MEnumSearchList(getThis().getEnumManager().getEnumTypes().getList());
	}

	@Override
	public MEnumValueSearchList enumValue_Path_In_CreateObservation() throws model.UserException, PersistenceException {
		return new MEnumValueSearchList(getThis().getEnumValueManager().getEnumValues().getList());
	}

	@Override
	public AbsQuantitySearchList factor1_Path_In_Mul() throws model.UserException, PersistenceException {
		return new AbsQuantitySearchList(getThis().getQuantityManager().getQuantities().getList());
	}

	@Override
	public AbsQuantitySearchList factor2_Path_In_Mul() throws model.UserException, PersistenceException {
		return new AbsQuantitySearchList(getThis().getQuantityManager().getQuantities().getList());
	}

	@Override
	public FormalParameterSearchList fp_Path_In_AddFp() throws model.UserException, PersistenceException {
		return new FormalParameterSearchList(getThis().getOperationManager().getFormalParameters().getList());
	}

	@Override
	public FormalParameterSearchList fp_Path_In_CreateOperation() throws model.UserException, PersistenceException {
		return new FormalParameterSearchList(getThis().getOperationManager().getFormalParameters().getList());
	}

	@Override
	public FormalParameterSearchList fp_Path_In_CreateStaticOp() throws model.UserException, PersistenceException {
		return new FormalParameterSearchList(getThis().getOperationManager().getFormalParameters().getList());
	}

	@Override
	public FormalParameterSearchList fp_Path_In_CreateVoidOperation() throws model.UserException, PersistenceException {
		return new FormalParameterSearchList(getThis().getOperationManager().getFormalParameters().getList());
	}

	@Override
	public PersistentAccountManager getAccountManager() throws PersistenceException {
		return model.measurement.AccountManager.getTheAccountManager();
	}

	@Override
	public PersistentAccountTypeManager getAccountTypeManager() throws PersistenceException {
		return model.measurement.AccountTypeManager.getTheAccountTypeManager();
	}

	@Override
	public PersistentAspectManager getAspectManager() throws PersistenceException {
		return model.typeSystem.AspectManager.getTheAspectManager();
	}

	@Override
	public PersistentAssociationManager getAssociationManager() throws PersistenceException {
		return model.abstractOperation.AssociationManager.getTheAssociationManager();
	}

	@Override
	public PersistentEnumerationManager getEnumManager() throws PersistenceException {
		return model.observations.EnumerationManager.getTheEnumerationManager();
	}

	@Override
	public PersistentEnumValueManager getEnumValueManager() throws PersistenceException {
		return model.observations.EnumValueManager.getTheEnumValueManager();
	}

	@Override
	public PersistentFractionManager getFractionManager() throws PersistenceException {
		return model.quantity.FractionManager.getTheFractionManager();
	}

	@Override
	public PersistentLinkManager getLinkManager() throws PersistenceException {
		return model.messageOrLink.LinkManager.getTheLinkManager();
	}

	@Override
	public PersistentMeasurementTypeManager getMeasurementTypeManager() throws PersistenceException {
		return model.measurement.MeasurementTypeManager.getTheMeasurementTypeManager();
	}

	@Override
	public PersistentMessageManager getMessageManager() throws PersistenceException {
		return model.messageOrLink.MessageManager.getTheMessageManager();
	}

	@Override
	public PersistentNameSchemeManager getNameSchemeManager() throws PersistenceException {
		return model.naming.NameSchemeManager.getTheNameSchemeManager();
	}

	@Override
	public PersistentObjectManager getObjectManager() throws PersistenceException {
		return model.typeSystem.ObjectManager.getTheObjectManager();
	}

	@Override
	public PersistentObsTypeManager getObsTypeManager() throws PersistenceException {
		return model.observations.ObsTypeManager.getTheObsTypeManager();
	}

	@Override
	public PersistentObservationManager getObservationManager() throws PersistenceException {
		return model.observations.ObservationManager.getTheObservationManager();
	}

	@Override
	public PersistentOperationManager getOperationManager() throws PersistenceException {
		return model.abstractOperation.OperationManager.getTheOperationManager();
	}

	@Override
	public PersistentQuantityManager getQuantityManager() throws PersistenceException {
		return model.quantity.QuantityManager.getTheQuantityManager();
	}

	@Override
	public PersistentTypeManager getTypeManager() throws PersistenceException {
		return model.typeSystem.TypeManager.getTheTypeManager();
	}

	@Override
	public PersistentUnitTypeManager getUnitTypeManager() throws PersistenceException {
		return model.quantity.UnitTypeManager.getTheUnitTypeManager();
	}

	@Override
	public void initialize(final Anything This, final java.util.Hashtable<String, Object> final$$Fields) throws PersistenceException {
		this.setThis((PersistentServer) This);
		if (this.equals(This)) {
			this.setPassword((String) final$$Fields.get("password"));
			this.setUser((String) final$$Fields.get("user"));
			this.setHackCount((Long) final$$Fields.get("hackCount"));
			this.setHackDelay((java.sql.Timestamp) final$$Fields.get("hackDelay"));
		}
	}

	@Override
	public MMeasurementTypeSearchList measurementType_Path_In_CreateEntry() throws model.UserException, PersistenceException {
		return new MMeasurementTypeSearchList(getThis().getMeasurementTypeManager().getMeasurementTypes().getList());
	}

	@Override
	public AbsQuantitySearchList minuend_Path_In_Sub() throws model.UserException, PersistenceException {
		return new AbsQuantitySearchList(getThis().getQuantityManager().getQuantities().getList());
	}

	@Override
	public MTypeSearchList newType_Path_In_AddType() throws model.UserException, PersistenceException {
		return new MTypeSearchList(getThis().getTypeManager().getTypes().getList());
	}

	@Override
	public MAtomicTypeSearchList newType_Path_In_ReplaceType(final PersistentMAtomicType oldType) throws model.UserException, PersistenceException {
		return new MAtomicTypeSearchList(oldType.getAspect().getTypes());
	}

	@Override
	public MObjectSearchList object_Path_In_CreateAccount() throws model.UserException, PersistenceException {
		return new MObjectSearchList(getThis().getObjectManager().getObjects().getList());
	}

	@Override
	public MObjectSearchList object_Path_In_CreateEntry() throws model.UserException, PersistenceException {
		return new MObjectSearchList(getThis().getObjectManager().getObjects().getList());
	}

	@Override
	public MTypeSearchList ofType_Path_In_CreateFp() throws model.UserException, PersistenceException {
		return new MTypeSearchList(getThis().getTypeManager().getTypes().getList());
	}

	@Override
	public MAtomicTypeSearchList oldType_Path_In_RemoveType(final PersistentMObject object) throws model.UserException, PersistenceException {
		return new MAtomicTypeSearchList(object.getTypes().getList());
	}

	@Override
	public MAtomicTypeSearchList oldType_Path_In_ReplaceType(final PersistentMObject object) throws model.UserException, PersistenceException {
		return new MAtomicTypeSearchList(object.getTypes().getList());
	}

	@Override
	public MTypeSearchList otherTypes_Path_In_CreateMObject() throws model.UserException, PersistenceException {
		return new MTypeSearchList(getThis().getTypeManager().getTypes().getList());
	}

	@Override
	public AbsQuantitySearchList quantity_Path_In_CreateEntry() throws model.UserException, PersistenceException {
		return new AbsQuantitySearchList(getThis().getQuantityManager().getQuantities().getList());
	}

	@Override
	public UnitTypeSearchList referenceUnitType_Path_In_AddReferenceType() throws model.UserException, PersistenceException {
		return new UnitTypeSearchList(getThis().getUnitTypeManager().getAtomicUnitTypes());
	}

	@Override
	public AbsUnitSearchList referenceUnit_Path_In_AddReference() throws model.UserException, PersistenceException {
		return new AbsUnitSearchList(getThis().getUnitTypeManager().getUnits().getList());
	}

	@Override
	public NameSchemeSearchList scheme_Path_In_AssignNameScheme() throws model.UserException, PersistenceException {
		return new NameSchemeSearchList(getThis().getNameSchemeManager().getSchemes().getList());
	}

	@Override
	public MAtomicTypeSearchList scheme_Path_In_AssignName(final PersistentMObject object) throws model.UserException, PersistenceException {
		return new MAtomicTypeSearchList(object.getTypes().getList());
	}

	@Override
	public void signalChanged(final boolean signal) throws PersistenceException {
		this.changed = signal;
	}

	@Override
	public MTypeSearchList source_Path_In_CreateAssociation() throws model.UserException, PersistenceException {
		return new MTypeSearchList(getThis().getTypeManager().getTypes().getList());
	}

	@Override
	public MObjectSearchList source_Path_In_CreateLink() throws model.UserException, PersistenceException {
		return new MObjectSearchList(getThis().getObjectManager().getObjects().getList());
	}

	@Override
	public MTypeSearchList source_Path_In_CreateOperation() throws model.UserException, PersistenceException {
		return new MTypeSearchList(getThis().getTypeManager().getTypes().getList());
	}

	@Override
	public MTypeSearchList source_Path_In_CreateVoidOperation() throws model.UserException, PersistenceException {
		return new MTypeSearchList(getThis().getTypeManager().getTypes().getList());
	}

	@Override
	public AbsQuantitySearchList subtrahend_Path_In_Sub() throws model.UserException, PersistenceException {
		return new AbsQuantitySearchList(getThis().getQuantityManager().getQuantities().getList());
	}

	@Override
	public AbsQuantitySearchList summand1_Path_In_Add() throws model.UserException, PersistenceException {
		return new AbsQuantitySearchList(getThis().getQuantityManager().getQuantities().getList());
	}

	@Override
	public AbsQuantitySearchList summand2_Path_In_Add() throws model.UserException, PersistenceException {
		return new AbsQuantitySearchList(getThis().getQuantityManager().getQuantities().getList());
	}

	@Override
	public MTypeSearchList target_Path_In_CreateAssociation() throws model.UserException, PersistenceException {
		return new MTypeSearchList(getThis().getTypeManager().getTypes().getList());
	}

	@Override
	public MTypeSearchList target_Path_In_CreateConstant() throws model.UserException, PersistenceException {
		return new MTypeSearchList(getThis().getTypeManager().getTypes().getList());
	}

	@Override
	public MObjectSearchList target_Path_In_CreateLink() throws model.UserException, PersistenceException {
		return new MObjectSearchList(getThis().getObjectManager().getObjects().getList());
	}

	@Override
	public MTypeSearchList target_Path_In_CreateOperation() throws model.UserException, PersistenceException {
		return new MTypeSearchList(getThis().getTypeManager().getTypes().getList());
	}

	@Override
	public MTypeSearchList target_Path_In_CreateStaticOp() throws model.UserException, PersistenceException {
		return new MTypeSearchList(getThis().getTypeManager().getTypes().getList());
	}

	@Override
	public MObjectSearchList theObsObject_Path_In_CreateObservation() throws model.UserException, PersistenceException {
		return new MObjectSearchList(getThis().getObjectManager().getObjects().getList());
	}

	@Override
	public MTypeSearchList theType_Path_In_CreateObsType() throws model.UserException, PersistenceException {
		return new MTypeSearchList(getThis().getTypeManager().getTypes().getList());
	}

	@Override
	public MTypeSearchList type_Path_In_CreateAccountType() throws model.UserException, PersistenceException {
		return new MTypeSearchList(getThis().getTypeManager().getTypes().getList());
	}

	@Override
	public MAccountTypeSearchList type_Path_In_CreateAccount() throws model.UserException, PersistenceException {
		return new MAccountTypeSearchList(getThis().getAccountTypeManager().getAccountTypes().getList());
	}

	@Override
	public AssociationSearchList type_Path_In_CreateLink() throws model.UserException, PersistenceException {
		return new AssociationSearchList(getThis().getAssociationManager().getAssociations().getList());
	}

	@Override
	public MTypeSearchList type_Path_In_CreateMObject() throws model.UserException, PersistenceException {
		return new MTypeSearchList(getThis().getTypeManager().getTypes().getList());
	}

	@Override
	public MTypeSearchList type_Path_In_CreateMeasurementType() throws model.UserException, PersistenceException {
		return new MTypeSearchList(getThis().getTypeManager().getTypes().getList());
	}

	@Override
	public UnitTypeSearchList unitType_Path_In_CreateAccountType() throws model.UserException, PersistenceException {
		return new UnitTypeSearchList(getThis().getUnitTypeManager().getAtomicUnitTypes());
	}

	@Override
	public UnitTypeSearchList unitType_Path_In_CreateMeasurementType() throws model.UserException, PersistenceException {
		return new UnitTypeSearchList(getThis().getUnitTypeManager().getAtomicUnitTypes());
	}

	@Override
	public AbsUnitSearchList unit_Path_In_Convert() throws model.UserException, PersistenceException {
		return new AbsUnitSearchList(getThis().getUnitTypeManager().getUnits().getList());
	}

	@Override
	public AbsUnitSearchList unit_Path_In_CreateQuantity() throws model.UserException, PersistenceException {
		return new AbsUnitSearchList(getThis().getUnitTypeManager().getUnits().getList());
	}

	@Override
	public void addAssociation(final PersistentHierarchy h, final PersistentAssociation a) throws PersistenceException {
		getThis().getAssociationManager().addAssociation(h, a, getThis());
	}

	@Override
	public void addFp(final PersistentOperation op, final PersistentFormalParameter fp) throws PersistenceException {
		getOperationManager().addFp(op, fp, getThis());

	}

	@Override
	public void addReferenceType(final PersistentAbsUnitType unitType, final String name, final PersistentUnitType referenceUnitType,
			final long exponent) throws PersistenceException {
		getUnitTypeManager().addReferenceType(name, unitType, referenceUnitType, exponent, getThis());

	}

	@Override
	public void addReference(final PersistentAbsUnit unit, final String name, final PersistentUnit referenceUnit, final long exponent)
			throws PersistenceException {
		getUnitTypeManager().addReference(name, unit, referenceUnit, exponent, getThis());

	}

	@Override
	public void addSubAccountType(final PersistentMAccountType parent, final PersistentMAccountType child) throws model.CycleException,
			PersistenceException {
		parent.addSubAccountType(child, this.getThis());
	}

	@Override
	public void addSubAccount(final PersistentAccount parent, final PersistentAccount child) throws model.CycleException, PersistenceException {
		parent.addSubAccount(child, this.getThis());
	}

	@Override
	public void addToHierarchy(final PersistentAssociation association, final PersistentHierarchy theHierarchy) throws PersistenceException {
		getAssociationManager().addAssociation(theHierarchy, association, getThis());
	}

	@Override
	public void addType(final PersistentMObject object, final PersistentMAtomicType newType) throws PersistenceException {
		getObjectManager().addType(object, newType, getThis());

	}

	@Override
	public void add(final PersistentAbsQuantity summand1, final PersistentAbsQuantity summand2) throws model.NotComputableException,
			PersistenceException {
		getThis().getQuantityManager().add(summand1, summand2, getThis());
	}

	@Override
	public PersistentAbsQuantity aggregateByStrategy(final PersistentAccount account, final String strategy) throws model.ConsistencyException,
			model.NotComputableException, PersistenceException {
		return account.aggregate(StringFACTORY.createObjectBySubTypeNameForAggregationStrategy(strategy));
	}

	@Override
	public void assignNameScheme(final PersistentMAtomicType type, final PersistentNameScheme scheme) throws PersistenceException {
		getNameSchemeManager().assignType(scheme, type, getThis());

	}

	@Override
	public void assignName(final PersistentMObject object, final PersistentName scheme, final String name) throws PersistenceException {
		getNameSchemeManager().assignName(object, scheme, name, getThis());

	}

	@Override
	public void assignType(final PersistentNameScheme scheme, final PersistentMAtomicType type) throws PersistenceException {
		getNameSchemeManager().assignType(scheme, type, getThis());
	}

	@Override
	public void changeAbstract(final PersistentMAtomicType type, final String newAbstractType) throws PersistenceException {
		getTypeManager().changeAbstract(type, MBoolean.createFromFactoryString(newAbstractType), getThis());
	}

	@Override
	public void changeSingleton(final PersistentMAtomicType type, final String newSingletonType) throws PersistenceException {
		getTypeManager().changeSingleton(type, MBoolean.createFromFactoryString(newSingletonType), getThis());
	}

	@Override
	public void changeUnitName(final PersistentAbsUnit unit, final String name) throws PersistenceException {
		getThis().getUnitTypeManager().changeUName(unit, name, getThis());
	}

	@Override
	public void changeUnitTypeName(final PersistentAbsUnitType unitType, final String name) throws PersistenceException {
		getThis().getUnitTypeManager().changeUTName(unitType, name, getThis());
	}

	@Override
	public void connected(final String user) throws PersistenceException {
	}

	@Override
	public void convert(final PersistentQuantity quantity, final PersistentAbsUnit unit) throws PersistenceException {
		getQuantityManager().convert(quantity, unit, getThis());
	}

	@Override
	public void copyingPrivateUserAttributes(final Anything copy) throws PersistenceException {
	}

	@Override
	public void createAccountType(final PersistentAccountTypeManager accountTypeManager, final String name, final PersistentMType type,
			final PersistentUnitType unitType) throws PersistenceException {
		getAccountTypeManager().createAccountType(name, type, unitType, getThis());
	}

	@Override
	public void createAccount(final PersistentAccountManager accountManager, final String name, final PersistentMAccountType type,
			final PersistentMObject object) throws PersistenceException {
		accountManager.createAccount(name, type, object, getThis());
	}

	@Override
	public void createAspect(final PersistentAspectManager aspectManager, final String name) throws PersistenceException {
		getThis().getAspectManager().createAspect(name, getThis());
	}

	@Override
	public void createAssociation(final PersistentAssociationManager manager, final PersistentMType source, final PersistentMType target,
			final String name) throws PersistenceException {
		manager.createAssociation(source, target, name, getThis());
	}

	@Override
	public void createAtomicRootType(final PersistentMAspect aspect, final String typeName, final String singletonType, final String abstractType)
			throws PersistenceException {
		getTypeManager().createAtomicRootType(aspect, typeName, MBoolean.createFromFactoryString(singletonType),
				MBoolean.createFromFactoryString(abstractType), getThis());

	}

	@Override
	public void createAtomicSubType(final PersistentMAtomicType superType, final String typeName, final String singletonType,
			final String abstractType) throws PersistenceException {
		getTypeManager().createAtomicSubType(superType, typeName, MBoolean.createFromFactoryString(singletonType),
				MBoolean.createFromFactoryString(abstractType), getThis());

	}

	@Override
	public void createConstant(final PersistentOperationManager operationManager, final String name, final PersistentMType target)
			throws PersistenceException {
		operationManager.createConstant(name, target, getThis());
	}

	@Override
	public void createEntry(final PersistentAccount account, final PersistentMObject object, final PersistentMMeasurementType measurementType,
			final PersistentQuantity quantity) throws model.ConsistencyException, PersistenceException {
		account.addEntry(Measurement.createMeasurement(object, measurementType, quantity), getThis());
	}

	@Override
	public void createEnumValue(final PersistentMEnum type, final String name) throws PersistenceException {
		EnumValueManager.getTheEnumValueManager().createEnumValue(name, type, getThis());
	}

	@Override
	public void createEnum(final PersistentEnumerationManager enumManager, final String name) throws PersistenceException {
		EnumerationManager.getTheEnumerationManager().createEnum(name, getThis());

	}

	@Override
	public void createFp(final PersistentOperationManager operationManager, final String name, final PersistentMType ofType)
			throws PersistenceException {
		operationManager.createFp(name, ofType, getThis());
	}

	@Override
	public void createHierarchy(final PersistentAssociationManager manager, final PersistentAssociation a, final String name)
			throws PersistenceException {
		manager.createHierarchy(a, name, getThis());

	}

	@Override
	public void createHierarchy(final PersistentAssociation a, final String name) throws PersistenceException {
		getThis().getAssociationManager().createHierarchy(a, name, getThis());

	}

	@Override
	public void createLink(final PersistentLinkManager link, final PersistentAssociation type, final PersistentMObject source,
			final PersistentMObject target) throws PersistenceException {
		link.createLink(type, source, target, getThis());

	}

	@Override
	public void createLink(final PersistentMObject source, final PersistentAssociation type, final PersistentMObject target)
			throws PersistenceException {
		getLinkManager().createLink(type, source, target, getThis());
	}

	@Override
	public void createMObject(final PersistentMAtomicType type, final MAtomicTypeSearchList otherTypes) throws PersistenceException {
		getObjectManager().createMObject(type, otherTypes, getThis());
	}

	@Override
	public void createMeasurementType(final PersistentMeasurementTypeManager measurementTypeManager, final String name, final PersistentMType type,
			final PersistentUnitType unitType) throws PersistenceException {
		getMeasurementTypeManager().createMeasurementType(name, type, unitType, getThis());
	}

	@Override
	public void createNameScheme(final PersistentNameSchemeManager manager, final String schemeName, final String regExp, final String isIterable)
			throws PersistenceException {
		getNameSchemeManager().createNameScheme(schemeName, regExp, MBoolean.createFromFactoryString(isIterable), getThis());
	}

	@Override
	public void createObsType(final PersistentObsTypeManager obsTypeManager, final String name, final PersistentMEnum enumType,
			final PersistentMType theType) throws PersistenceException {
		ObsTypeManager.getTheObsTypeManager().createObsType(name, enumType, theType, getThis());

	}

	@Override
	public void createObservation(final PersistentMObservationType theType, final String name, final PersistentMObject theObsObject,
			final PersistentMEnumValue enumValue) throws PersistenceException {
		ObservationManager.getTheObservationManager().createObservation(name, theType, theObsObject, enumValue, getThis());
	}

	@Override
	public void createOperation(final PersistentMType source, final PersistentMType target, final String name, final FormalParameterSearchList fp)
			throws PersistenceException {
		getOperationManager().createOperation(source, target, name, fp, getThis());
	}

	@Override
	public void createOperation(final PersistentOperationManager operationManager, final PersistentMType source, final PersistentMType target,
			final String name, final FormalParameterSearchList fp) throws PersistenceException {
		getOperationManager().createOperation(source, target, name, fp, getThis());
	}

	@Override
	public void createQuantity(final PersistentQuantityManager manager, final PersistentAbsUnit unit, final common.Fraction f)
			throws PersistenceException {
		getQuantityManager().createQuantity(unit, f, getThis());
	}

	@Override
	public void createStaticOp(final PersistentOperationManager operationManager, final String name, final PersistentMType target,
			final FormalParameterSearchList fp) throws PersistenceException {
		getOperationManager().createStaticOp(name, target, fp, getThis());
	}

	@Override
	public void createTypeConjunction(final PersistentTypeManager typeManager, final MTypeSearchList containees) throws PersistenceException {
		getThis().getTypeManager().createTypeConjunction(containees, getThis());

	}

	@Override
	public void createTypeDisjunction(final PersistentTypeManager typeManager, final MTypeSearchList containees) throws PersistenceException {
		getThis().getTypeManager().createTypeDisjunction(containees, getThis());

	}

	@Override
	public void createUnitType(final PersistentUnitTypeManager manager, final String name) throws PersistenceException {
		getUnitTypeManager().createUnitType(name, getThis());
	}

	@Override
	public void createUnit(final PersistentUnitType type, final String name) throws PersistenceException {
		getUnitTypeManager().createUnit(name, type, getThis());
	}

	@Override
	public void createVoidOperation(final PersistentMType source, final String name, final FormalParameterSearchList fp) throws PersistenceException {
		getOperationManager().createVoidOperation(source, name, fp, getThis());
	}

	@Override
	public void createVoidOperation(final PersistentOperationManager operationManager, final PersistentMType source, final String name,
			final FormalParameterSearchList fp) throws PersistenceException {
		getOperationManager().createVoidOperation(source, name, fp, getThis());
	}

	@Override
	public void deleteAccountType(final PersistentMAccountType accountType) throws model.ConsistencyException, PersistenceException {
		getAccountTypeManager().deleteAccountType(accountType, getThis());
	}

	@Override
	public void deleteAccount(final PersistentAccount account) throws model.ConsistencyException, PersistenceException {
		getAccountManager().deleteAccount(account, getThis());
	}

	@Override
	public void deleteAspect(final PersistentMAspect aspect) throws PersistenceException {
		getAspectManager().deleteAspect(aspect, getThis());
	}

	@Override
	public void deleteAtomicType(final PersistentMAtomicType type) throws PersistenceException {
		getTypeManager().deleteAtomicType(type, getThis());
	}

	@Override
	public void deleteComplexType(final PersistentMComplexType type) throws PersistenceException {
		getTypeManager().deleteComplexeType(type, getThis());
	}

	@Override
	public void deleteEntry(final PersistentMeasurement measurement) throws model.ConsistencyException, PersistenceException {
		measurement.inverseGetEntries().removeFirstSuccess(new Predcate<PersistentAccount>() {

			@Override
			public boolean test(final PersistentAccount argument) throws PersistenceException {
				return measurement.equals(argument);
			}
		});
		measurement.delete();
	}

	@Override
	public void deleteEnumValue(final PersistentMEnumValue enumValue) throws PersistenceException {
		EnumValueManager.getTheEnumValueManager().deleteEnumValue(enumValue, getThis());
	}

	@Override
	public void deleteEnum(final PersistentMEnum type) throws PersistenceException {
		EnumerationManager.getTheEnumerationManager().deleteEnum(type, getThis());
	}

	@Override
	public void deleteMeasurementType(final PersistentMMeasurementType measurementType) throws model.ConsistencyException, PersistenceException {
		MeasurementTypeManager.getTheMeasurementTypeManager().deleteMeasurementType(measurementType, getThis());
	}

	@Override
	public void deleteObject(final PersistentMObject object) throws PersistenceException {
		getThis().getObjectManager().deleteObject(object, getThis());
	}

	@Override
	public void deleteObsType(final PersistentMObservationType theType) throws PersistenceException {
		ObsTypeManager.getTheObsTypeManager().deleteObsType(theType, getThis());

	}

	@Override
	public void deleteObservation(final PersistentMObservation observation) throws PersistenceException {
		ObservationManager.getTheObservationManager().deleteObservation(observation, getThis());

	}

	@Override
	public void disconnected() throws PersistenceException {
	}

	@Override
	public void div(final PersistentAbsQuantity dividend, final PersistentAbsQuantity divisor) throws model.NotComputableException,
			PersistenceException {
		getThis().getQuantityManager().div(dividend, divisor, getThis());

	}

	@Override
	public void fetchScalarType(final PersistentUnitTypeManager manager) throws PersistenceException {
		manager.fetchScalarType(getThis());
	}

	@Override
	public void fetchScalar(final PersistentUnitTypeManager manager) throws PersistenceException {
		manager.fetchScalar(getThis());
	}

	@Override
	public PersistentAccountManager getAccountManager(final TDObserver observer) throws PersistenceException {
		final PersistentAccountManager result = getThis().getAccountManager();
		observer.updateTransientDerived(getThis(), "accountManager", result);
		return result;
	}

	@Override
	public PersistentAccountTypeManager getAccountTypeManager(final TDObserver observer) throws PersistenceException {
		final PersistentAccountTypeManager result = getThis().getAccountTypeManager();
		observer.updateTransientDerived(getThis(), "accountTypeManager", result);
		return result;
	}

	@Override
	public PersistentAspectManager getAspectManager(final TDObserver observer) throws PersistenceException {
		final PersistentAspectManager result = getThis().getAspectManager();
		observer.updateTransientDerived(getThis(), "aspectManager", result);
		return result;
	}

	@Override
	public PersistentAssociationManager getAssociationManager(final TDObserver observer) throws PersistenceException {
		final PersistentAssociationManager result = getThis().getAssociationManager();
		observer.updateTransientDerived(getThis(), "associationManager", result);
		return result;
	}

	@Override
	public PersistentEnumerationManager getEnumManager(final TDObserver observer) throws PersistenceException {
		final PersistentEnumerationManager result = getThis().getEnumManager();
		observer.updateTransientDerived(getThis(), "enumManager", result);
		return result;
	}

	@Override
	public PersistentEnumValueManager getEnumValueManager(final TDObserver observer) throws PersistenceException {
		final PersistentEnumValueManager result = getThis().getEnumValueManager();
		observer.updateTransientDerived(getThis(), "enumValueManager", result);
		return result;
	}

	@Override
	public PersistentFractionManager getFractionManager(final TDObserver observer) throws PersistenceException {
		final PersistentFractionManager result = getThis().getFractionManager();
		observer.updateTransientDerived(getThis(), "fractionManager", result);
		return result;
	}

	@Override
	public PersistentLinkManager getLinkManager(final TDObserver observer) throws PersistenceException {
		final PersistentLinkManager result = getThis().getLinkManager();
		observer.updateTransientDerived(getThis(), "linkManager", result);
		return result;
	}

	@Override
	public PersistentMeasurementTypeManager getMeasurementTypeManager(final TDObserver observer) throws PersistenceException {
		final PersistentMeasurementTypeManager result = getThis().getMeasurementTypeManager();
		observer.updateTransientDerived(getThis(), "measurementTypeManager", result);
		return result;
	}

	@Override
	public PersistentMessageManager getMessageManager(final TDObserver observer) throws PersistenceException {
		final PersistentMessageManager result = getThis().getMessageManager();
		observer.updateTransientDerived(getThis(), "messageManager", result);
		return result;
	}

	@Override
	public PersistentNameSchemeManager getNameSchemeManager(final TDObserver observer) throws PersistenceException {
		final PersistentNameSchemeManager result = getThis().getNameSchemeManager();
		observer.updateTransientDerived(getThis(), "nameSchemeManager", result);
		return result;
	}

	@Override
	public PersistentObjectManager getObjectManager(final TDObserver observer) throws PersistenceException {
		final PersistentObjectManager result = getThis().getObjectManager();
		observer.updateTransientDerived(getThis(), "objectManager", result);
		return result;
	}

	@Override
	public PersistentObsTypeManager getObsTypeManager(final TDObserver observer) throws PersistenceException {
		final PersistentObsTypeManager result = getThis().getObsTypeManager();
		observer.updateTransientDerived(getThis(), "obsTypeManager", result);
		return result;
	}

	@Override
	public PersistentObservationManager getObservationManager(final TDObserver observer) throws PersistenceException {
		final PersistentObservationManager result = getThis().getObservationManager();
		observer.updateTransientDerived(getThis(), "observationManager", result);
		return result;
	}

	@Override
	public PersistentOperationManager getOperationManager(final TDObserver observer) throws PersistenceException {
		final PersistentOperationManager result = getThis().getOperationManager();
		observer.updateTransientDerived(getThis(), "operationManager", result);
		return result;
	}

	@Override
	public PersistentQuantityManager getQuantityManager(final TDObserver observer) throws PersistenceException {
		final PersistentQuantityManager result = getThis().getQuantityManager();
		observer.updateTransientDerived(getThis(), "quantityManager", result);
		return result;
	}

	@Override
	public PersistentTypeManager getTypeManager(final TDObserver observer) throws PersistenceException {
		final PersistentTypeManager result = getThis().getTypeManager();
		observer.updateTransientDerived(getThis(), "typeManager", result);
		return result;
	}

	@Override
	public PersistentUnitTypeManager getUnitTypeManager(final TDObserver observer) throws PersistenceException {
		final PersistentUnitTypeManager result = getThis().getUnitTypeManager();
		observer.updateTransientDerived(getThis(), "unitTypeManager", result);
		return result;
	}

	@Override
	public void handleException(final Command command, final PersistenceException exception) throws PersistenceException {
		new Thread(new Runnable() {
			@Override
			public/* INTERNAL */void run() {
				// Handle exception!
			}
		}).start();
	}

	@Override
	public void handleResult(final Command command) throws PersistenceException {
		new Thread(new Runnable() {
			@Override
			public void /* INTERNAL */run() {
				try {
					try {
						command.checkException();
						// Handle result!
						signalChanged(true);
					} catch (final model.UserException e) {
						final model.UserExceptionToDisplayVisitor visitor = new model.UserExceptionToDisplayVisitor();
						e.accept(visitor);
						getErrors().add(visitor.getResult());
						signalChanged(true);
					}
				} catch (final PersistenceException e) {
					// Handle fatal exception!
				}
			}
		}).start();
	}

	@Override
	public boolean hasChanged() throws PersistenceException {
		final boolean result = this.changed;
		this.changed = false;
		return result;
	}

	@Override
	public void initializeOnCreation() throws PersistenceException {
		try {
			this.demoUnits();
			this.demoTypes();
			this.demoMeasurement();
		} catch (final DoubleDefinitionException e) {
			e.printStackTrace();
			System.err.println("Fehler bei der Initialisierung des Servers!");
		} catch (final ConsistencyException e) {
			e.printStackTrace();
			System.err.println("Fehler bei der Initialisierung des Servers!");
		} catch (final CycleException e) {
			e.printStackTrace();
			System.err.println("Fehler bei der Initialisierung des Servers!");
		}

	}

	@Override
	public void initializeOnInstantiation() throws PersistenceException {
	}

	@Override
	public void mul(final PersistentAbsQuantity factor1, final PersistentAbsQuantity factor2) throws model.DoubleDefinitionException,
			model.NotComputableException, PersistenceException {
		getThis().getQuantityManager().mul(factor1, factor2, getThis());

	}

	@Override
	public void removeAssociation(final PersistentAssociation a) throws PersistenceException {
		getAssociationManager().removeAssociation(a, getThis());
	}

	@Override
	public void removeFpFromOp(final PersistentOperation operation, final PersistentFormalParameter fp) throws PersistenceException {
		getOperationManager().removeFpFromOp(operation, fp, getThis());
	}

	@Override
	public void removeFp(final PersistentFormalParameter fp) throws PersistenceException {
		getOperationManager().removeFp(fp, getThis());
	}

	@Override
	public void removeFromHierarchy(final PersistentHierarchy h, final PersistentAssociation a) throws PersistenceException {
		getAssociationManager().removeAssoFrmHier(h, a, getThis());
	}

	@Override
	public void removeHierarchy(final PersistentHierarchy h) throws PersistenceException {
		getAssociationManager().removeHierarchy(h, getThis());
	}

	@Override
	public void removeLink(final PersistentLink link) throws PersistenceException {
		getLinkManager().removeLink(link, getThis());
	}

	@Override
	public void removeOperation(final PersistentOperation op) throws PersistenceException {
		getOperationManager().removeOperation(op, getThis());
	}

	@Override
	public void removeType(final PersistentMObject object, final PersistentMAtomicType oldType) throws PersistenceException {
		getObjectManager().removeType(object, oldType, getThis());
	}

	@Override
	public void renameAspect(final PersistentMAspect aspect, final String newName) throws PersistenceException {
		getAspectManager().renameAspect(aspect, newName, getThis());
	}

	@Override
	public void renameAtomicType(final PersistentMAtomicType type, final String newName) throws PersistenceException {
		getTypeManager().renameAtomicType(type, newName, getThis());
	}

	@Override
	public void replaceType(final PersistentMObject object, final PersistentMAtomicType oldType, final PersistentMAtomicType newType)
			throws PersistenceException {
		getObjectManager().replaceType(object, oldType, newType, getThis());
	}

	@Override
	public void setConversion(final PersistentUnit unit, final common.Fraction factor, final common.Fraction constant) throws PersistenceException {
		getUnitTypeManager().setConversion(unit, factor, constant, getThis());
	}

	@Override
	public void setDefaultUnit(final PersistentUnitType type, final PersistentUnit defaultUnit) throws PersistenceException {
		getUnitTypeManager().setDefaultUnit(type, defaultUnit, getThis());

	}

	@Override
	public void sub(final PersistentAbsQuantity minuend, final PersistentAbsQuantity subtrahend) throws model.NotComputableException,
			PersistenceException {
		getThis().getQuantityManager().sub(minuend, subtrahend, getThis());
	}

	// Start of section that contains overridden operations only.

	/* Start of protected part that is not overridden by persistence generator */

	private void demoUnits() throws DoubleDefinitionException, PersistenceException {
		final PersistentUnitType distance = getThis().getUnitTypeManager().createUnitType("Strecke");
		final PersistentUnit meter = getThis().getUnitTypeManager().createUnit("m", distance);

		QuantityManager.getTheQuantityManager().createQuantity(meter, Fraction.parse("3"));
		QuantityManager.getTheQuantityManager().createQuantity(meter, Fraction.parse("2"));
	}

	private void demoTypes() throws ConsistencyException, PersistenceException {
		final PersistentMAspect aspect = getAspectManager().createAspect("Aspect1");
		getTypeManager().createAtomicRootType(aspect, "AT1", MFalse.getTheMFalse(), MFalse.getTheMFalse());
	}

	private void demoMeasurement() throws CycleException, PersistenceException, ConsistencyException, DoubleDefinitionException {
		final PersistentMAspect aspect1 = getAspectManager().createAspect("Bankkunde");
		final PersistentMAtomicType type = getTypeManager().createAtomicRootType(aspect1, "Person", MFalse.getTheMFalse(), MFalse.getTheMFalse());
		final PersistentUnitType unitType1 = getUnitTypeManager().createUnitType("Währung");

		final PersistentMAccountType accType1 = getAccountTypeManager().createAccountType("Bankkonto", type, unitType1);

		final PersistentMObject obj1 = getObjectManager().createMObject(type, new MAtomicTypeSearchList());
		final PersistentMObject obj2 = getObjectManager().createMObject(type, new MAtomicTypeSearchList());

		final PersistentAccount account = getAccountManager().createAccount("Hugos Konto", accType1, obj1);

		final PersistentUnit unit = getUnitTypeManager().createUnit("Euro", unitType1);
		this.getThis().getUnitTypeManager().setDefaultUnit(unitType1, unit);
		final PersistentQuantity quantity1_3Euro = getQuantityManager().createQuantity(unit, Fraction.parse("1/3"));
		final PersistentQuantity quantity4_3Euro = getQuantityManager().createQuantity(unit, Fraction.parse("4/3"));
		final PersistentQuantity quantity2_3Euro = getQuantityManager().createQuantity(unit, Fraction.parse("2/3"));

		final PersistentMMeasurementType msmntType1 = getMeasurementTypeManager().createMeasurementType("Buchung", type, unitType1);
		final PersistentMeasurement measurement1_3Euro = Measurement.createMeasurement(obj2, msmntType1, quantity1_3Euro);
		final PersistentMeasurement measurement4_3Euro = Measurement.createMeasurement(obj2, msmntType1, quantity4_3Euro);
		final PersistentMeasurement measurement2_3Euro = Measurement.createMeasurement(obj2, msmntType1, quantity2_3Euro);

		account.addEntry(measurement1_3Euro);
		account.addEntry(measurement4_3Euro);
		account.addEntry(measurement2_3Euro);
	}
	/* End of protected part that is not overridden by persistence generator */

}

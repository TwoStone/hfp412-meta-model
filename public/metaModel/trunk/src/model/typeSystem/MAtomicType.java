package model.typeSystem;

import java.util.Iterator;

import model.CycleException;
import model.UserException;
import model.basic.MBoolean;
import model.basic.MFalse;
import model.basic.MTrue;
import model.visitor.AnythingExceptionVisitor;
import model.visitor.AnythingORMATomicTypeExceptionVisitor;
import model.visitor.AnythingORMATomicTypeReturnExceptionVisitor;
import model.visitor.AnythingORMATomicTypeReturnVisitor;
import model.visitor.AnythingORMATomicTypeVisitor;
import model.visitor.AnythingReturnExceptionVisitor;
import model.visitor.AnythingReturnVisitor;
import model.visitor.AnythingVisitor;
import model.visitor.MAtomicTypeHierarchyHIERARCHYExceptionVisitor;
import model.visitor.MAtomicTypeHierarchyHIERARCHYReturnExceptionVisitor;
import model.visitor.MAtomicTypeHierarchyHIERARCHYReturnVisitor;
import model.visitor.MAtomicTypeHierarchyHIERARCHYVisitor;
import model.visitor.MComplexTypeHierarchyHIERARCHYExceptionVisitor;
import model.visitor.MComplexTypeHierarchyHIERARCHYReturnExceptionVisitor;
import model.visitor.MComplexTypeHierarchyHIERARCHYReturnVisitor;
import model.visitor.MComplexTypeHierarchyHIERARCHYVisitor;
import model.visitor.MModelItemExceptionVisitor;
import model.visitor.MModelItemReturnExceptionVisitor;
import model.visitor.MModelItemReturnVisitor;
import model.visitor.MModelItemVisitor;
import model.visitor.MTypeExceptionVisitor;
import model.visitor.MTypeReturnExceptionVisitor;
import model.visitor.MTypeReturnVisitor;
import model.visitor.MTypeVisitor;
import persistence.AbstractPersistentRoot;
import persistence.Anything;
import persistence.AnythingORMATomicType;
import persistence.ConnectionHandler;
import persistence.MAspectSearchList;
import persistence.MAtomicTypeHierarchyHIERARCHY;
import persistence.MAtomicTypeHierarchyHIERARCHYStrategy;
import persistence.MAtomicTypeProxi;
import persistence.MAtomicTypeSearchList;
import persistence.MComplexTypeHierarchyHIERARCHY;
import persistence.MComplexTypeHierarchyHIERARCHYStrategy;
import persistence.MModelItemSearchList;
import persistence.MNonEmptyAtomicTypeConjunctionSearchList;
import persistence.MObjectSearchList;
import persistence.MTypeSearchList;
import persistence.NameSearchList;
import persistence.PersistenceException;
import persistence.PersistentCONCMModelItem;
import persistence.PersistentMAspect;
import persistence.PersistentMAtomicType;
import persistence.PersistentMAtomicTypeConjunction;
import persistence.PersistentMBoolean;
import persistence.PersistentMDisjunctiveNormalForm;
import persistence.PersistentMEmptyTypeConjunction;
import persistence.PersistentMEmptyTypeDisjunction;
import persistence.PersistentMMixedConjunction;
import persistence.PersistentMMixedTypeDisjunction;
import persistence.PersistentMModelItem;
import persistence.PersistentMNonEmptyAtomicTypeConjunction;
import persistence.PersistentMNonEmptyDisjunctiveNormalForm;
import persistence.PersistentMType;
import persistence.PersistentProxi;
import persistence.TDObserver;
import utils.SearchLists;
import constants.ExceptionConstants;

/* Additional import section end */

public class MAtomicType extends model.typeSystem.MType implements PersistentMAtomicType {

	public static PersistentMAtomicType createMAtomicType(final String name, final PersistentMBoolean singletonType,
			final PersistentMBoolean abstractType, final PersistentMAspect aspect, final AnythingORMATomicType superType)
			throws PersistenceException, CycleException {
		return createMAtomicType(name, singletonType, abstractType, aspect, superType, false);
	}

	public static PersistentMAtomicType createMAtomicType(final String name, final PersistentMBoolean singletonType,
			final PersistentMBoolean abstractType, final PersistentMAspect aspect, final AnythingORMATomicType superType,
			final boolean delayed$Persistence) throws PersistenceException, CycleException {
		if (name == null)
			throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
		PersistentMAtomicType result = null;
		if (delayed$Persistence) {
			result = ConnectionHandler.getTheConnectionHandler().theMAtomicTypeFacade.newDelayedMAtomicType(name);
			result.setDelayed$Persistence(true);
		} else {
			result = ConnectionHandler.getTheConnectionHandler().theMAtomicTypeFacade.newMAtomicType(name, -1);
		}
		final java.util.Hashtable<String, Object> final$$Fields = new java.util.Hashtable<String, Object>();
		final$$Fields.put("name", name);
		final$$Fields.put("singletonType", singletonType);
		final$$Fields.put("abstractType", abstractType);
		final$$Fields.put("aspect", aspect);
		final$$Fields.put("superType", superType);
		try {
			result.initialize(result, final$$Fields);
			result.initializeOnCreation();
		} catch (final persistence.PersistenceExceptionCycleTunnel ce) {
			throw ce.cycleException;
		}
		return result;
	}

	public static PersistentMAtomicType createMAtomicType(final String name, final PersistentMBoolean singletonType,
			final PersistentMBoolean abstractType, final PersistentMAspect aspect, final AnythingORMATomicType superType,
			final boolean delayed$Persistence, final PersistentMAtomicType This) throws PersistenceException, CycleException {
		if (name == null)
			throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
		PersistentMAtomicType result = null;
		if (delayed$Persistence) {
			result = ConnectionHandler.getTheConnectionHandler().theMAtomicTypeFacade.newDelayedMAtomicType(name);
			result.setDelayed$Persistence(true);
		} else {
			result = ConnectionHandler.getTheConnectionHandler().theMAtomicTypeFacade.newMAtomicType(name, -1);
		}
		final java.util.Hashtable<String, Object> final$$Fields = new java.util.Hashtable<String, Object>();
		final$$Fields.put("name", name);
		final$$Fields.put("singletonType", singletonType);
		final$$Fields.put("abstractType", abstractType);
		final$$Fields.put("aspect", aspect);
		final$$Fields.put("superType", superType);
		try {
			result.initialize(This, final$$Fields);
			result.initializeOnCreation();
		} catch (final persistence.PersistenceExceptionCycleTunnel ce) {
			throw ce.cycleException;
		}
		return result;
	}

	@Override
	public java.util.Hashtable<String, Object> toHashtable(final java.util.Hashtable<String, Object> allResults, final int depth,
			final int essentialLevel, final boolean forGUI, final boolean leaf, final TDObserver tdObserver) throws PersistenceException {
		java.util.Hashtable<String, Object> result = null;
		if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth) {
			result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
			result.put("name", this.getName());
			result.put("singletonType", this.singletonTypeAsString());
			result.put("abstractType", this.abstractTypeAsString());
			final AbstractPersistentRoot aspect = this.getAspect();
			if (aspect != null) {
				result.put("aspect", aspect.createProxiInformation(false, essentialLevel == 0));
				if (depth > 1) {
					aspect.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true, tdObserver);
				} else {
					if (forGUI && aspect.hasEssentialFields())
						aspect.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
				}
			}
			final AbstractPersistentRoot superType = this.getSuperType();
			if (superType != null) {
				result.put("superType", superType.createProxiInformation(false, essentialLevel == 0));
				if (depth > 1) {
					superType.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true, tdObserver);
				} else {
					if (forGUI && superType.hasEssentialFields())
						superType.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
				}
			}
			result.put(
					"nEATCContainingMe",
					this.getNEATCContainingMe().getVector(allResults, (depth > 1 ? depth : depth + 1), essentialLevel, forGUI, tdObserver, false,
							essentialLevel == 0));
			result.put(
					"subTypes",
					this.getSubTypes().getVector(allResults, (depth > 1 ? depth : depth + 1), essentialLevel, forGUI, tdObserver, false,
							essentialLevel == 0));
			result.put(
					"possibleNames",
					this.getPossibleNames().getVector(allResults, (depth > 1 ? depth : depth + 1), essentialLevel, forGUI, tdObserver, false,
							essentialLevel == 0));
			final String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
			if (leaf && !allResults.contains(uniqueKey))
				allResults.put(uniqueKey, result);
		}
		return result;
	}

	public static MAtomicTypeSearchList getMAtomicTypeByName(final String name) throws PersistenceException {
		return ConnectionHandler.getTheConnectionHandler().theMAtomicTypeFacade.getMAtomicTypeByName(name);
	}

	@Override
	public MAtomicType provideCopy() throws PersistenceException {
		MAtomicType result = this;
		result = new MAtomicType(this.This, this.myCONCMModelItem, this.name, this.singletonType, this.abstractType, this.aspect, this.superType,
				this.getId());
		this.copyingPrivateUserAttributes(result);
		return result;
	}

	@Override
	public boolean hasEssentialFields() throws PersistenceException {
		return true;
	}

	protected String name;
	protected PersistentMBoolean singletonType;
	protected PersistentMBoolean abstractType;
	protected PersistentMAspect aspect;
	protected AnythingORMATomicType superType;

	public MAtomicType(final PersistentMType This, final PersistentMModelItem myCONCMModelItem, final String name,
			final PersistentMBoolean singletonType, final PersistentMBoolean abstractType, final PersistentMAspect aspect,
			final AnythingORMATomicType superType, final long id) throws persistence.PersistenceException {
		/* Shall not be used by clients for object construction! Use static create operation instead! */
		super(This, myCONCMModelItem, id);
		this.name = name;
		this.singletonType = singletonType;
		this.abstractType = abstractType;
		this.aspect = aspect;
		this.superType = superType;
	}

	static public long getTypeId() {
		return 113;
	}

	@Override
	public long getClassId() {
		return getTypeId();
	}

	@Override
	public void store() throws PersistenceException {
		if (!this.isDelayed$Persistence())
			return;
		if (this.getClassId() == 113)
			ConnectionHandler.getTheConnectionHandler().theMAtomicTypeFacade.newMAtomicType(name, this.getId());
		super.store();
		if (this.getSingletonType() != null) {
			this.getSingletonType().store();
			ConnectionHandler.getTheConnectionHandler().theMAtomicTypeFacade.singletonTypeSet(this.getId(), getSingletonType());
		}
		if (this.getAbstractType() != null) {
			this.getAbstractType().store();
			ConnectionHandler.getTheConnectionHandler().theMAtomicTypeFacade.abstractTypeSet(this.getId(), getAbstractType());
		}
		if (this.getAspect() != null) {
			this.getAspect().store();
			ConnectionHandler.getTheConnectionHandler().theMAtomicTypeFacade.aspectSet(this.getId(), getAspect());
		}
		if (this.getSuperType() != null) {
			this.getSuperType().store();
			ConnectionHandler.getTheConnectionHandler().theMAtomicTypeFacade.superTypeSet(this.getId(), getSuperType());
		}

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
			ConnectionHandler.getTheConnectionHandler().theMAtomicTypeFacade.nameSet(this.getId(), newValue);
		this.name = newValue;
	}

	@Override
	public PersistentMBoolean getSingletonType() throws PersistenceException {
		return this.singletonType;
	}

	@Override
	public void setSingletonType(final PersistentMBoolean newValue) throws PersistenceException {
		if (newValue == null)
			throw new PersistenceException("Null values not allowed!", 0);
		if (newValue.equals(this.singletonType))
			return;
		final long objectId = newValue.getId();
		final long classId = newValue.getClassId();
		this.singletonType = (PersistentMBoolean) PersistentProxi.createProxi(objectId, classId);
		if (!this.isDelayed$Persistence()) {
			newValue.store();
			ConnectionHandler.getTheConnectionHandler().theMAtomicTypeFacade.singletonTypeSet(this.getId(), newValue);
		}
	}

	@Override
	public PersistentMBoolean getAbstractType() throws PersistenceException {
		return this.abstractType;
	}

	@Override
	public void setAbstractType(final PersistentMBoolean newValue) throws PersistenceException {
		if (newValue == null)
			throw new PersistenceException("Null values not allowed!", 0);
		if (newValue.equals(this.abstractType))
			return;
		final long objectId = newValue.getId();
		final long classId = newValue.getClassId();
		this.abstractType = (PersistentMBoolean) PersistentProxi.createProxi(objectId, classId);
		if (!this.isDelayed$Persistence()) {
			newValue.store();
			ConnectionHandler.getTheConnectionHandler().theMAtomicTypeFacade.abstractTypeSet(this.getId(), newValue);
		}
	}

	@Override
	public PersistentMAspect getAspect() throws PersistenceException {
		return this.aspect;
	}

	@Override
	public void setAspect(final PersistentMAspect newValue) throws PersistenceException {
		if (newValue == null)
			throw new PersistenceException("Null values not allowed!", 0);
		if (newValue.equals(this.aspect))
			return;
		final long objectId = newValue.getId();
		final long classId = newValue.getClassId();
		this.aspect = (PersistentMAspect) PersistentProxi.createProxi(objectId, classId);
		if (!this.isDelayed$Persistence()) {
			newValue.store();
			ConnectionHandler.getTheConnectionHandler().theMAtomicTypeFacade.aspectSet(this.getId(), newValue);
		}
	}

	@Override
	public AnythingORMATomicType getSuperType() throws PersistenceException {
		return this.superType;
	}

	@Override
	public void setSuperType(final AnythingORMATomicType newValue) throws PersistenceException, model.CycleException {
		if (newValue == null)
			throw new PersistenceException("Null values not allowed!", 0);
		if (newValue.containsMAtomicTypeHierarchy(getThis()))
			throw new model.CycleException("Cycle in MAtomicTypeHierarchy detected!");
		if (newValue.equals(this.superType))
			return;
		final long objectId = newValue.getId();
		final long classId = newValue.getClassId();
		this.superType = (AnythingORMATomicType) PersistentProxi.createProxi(objectId, classId);
		if (!this.isDelayed$Persistence()) {
			newValue.store();
			ConnectionHandler.getTheConnectionHandler().theMAtomicTypeFacade.superTypeSet(this.getId(), newValue);
		}
	}

	@Override
	public PersistentMAtomicType getThis() throws PersistenceException {
		if (this.This == null) {
			final PersistentMAtomicType result = new MAtomicTypeProxi(this.getId());
			result.getTheObject();
			return result;
		}
		return (PersistentMAtomicType) this.This;
	}

	@Override
	public void accept(final MTypeVisitor visitor) throws PersistenceException {
		visitor.handleMAtomicType(this);
	}

	@Override
	public <R> R accept(final MTypeReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleMAtomicType(this);
	}

	@Override
	public <E extends UserException> void accept(final MTypeExceptionVisitor<E> visitor) throws PersistenceException, E {
		visitor.handleMAtomicType(this);
	}

	@Override
	public <R, E extends UserException> R accept(final MTypeReturnExceptionVisitor<R, E> visitor) throws PersistenceException, E {
		return visitor.handleMAtomicType(this);
	}

	@Override
	public void accept(final MModelItemVisitor visitor) throws PersistenceException {
		visitor.handleMAtomicType(this);
	}

	@Override
	public <R> R accept(final MModelItemReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleMAtomicType(this);
	}

	@Override
	public <E extends UserException> void accept(final MModelItemExceptionVisitor<E> visitor) throws PersistenceException, E {
		visitor.handleMAtomicType(this);
	}

	@Override
	public <R, E extends UserException> R accept(final MModelItemReturnExceptionVisitor<R, E> visitor) throws PersistenceException, E {
		return visitor.handleMAtomicType(this);
	}

	@Override
	public void accept(final AnythingVisitor visitor) throws PersistenceException {
		visitor.handleMAtomicType(this);
	}

	@Override
	public <R> R accept(final AnythingReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleMAtomicType(this);
	}

	@Override
	public <E extends UserException> void accept(final AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
		visitor.handleMAtomicType(this);
	}

	@Override
	public <R, E extends UserException> R accept(final AnythingReturnExceptionVisitor<R, E> visitor) throws PersistenceException, E {
		return visitor.handleMAtomicType(this);
	}

	@Override
	public void accept(final MComplexTypeHierarchyHIERARCHYVisitor visitor) throws PersistenceException {
		visitor.handleMAtomicType(this);
	}

	@Override
	public <R> R accept(final MComplexTypeHierarchyHIERARCHYReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleMAtomicType(this);
	}

	@Override
	public <E extends UserException> void accept(final MComplexTypeHierarchyHIERARCHYExceptionVisitor<E> visitor) throws PersistenceException, E {
		visitor.handleMAtomicType(this);
	}

	@Override
	public <R, E extends UserException> R accept(final MComplexTypeHierarchyHIERARCHYReturnExceptionVisitor<R, E> visitor)
			throws PersistenceException, E {
		return visitor.handleMAtomicType(this);
	}

	@Override
	public void accept(final AnythingORMATomicTypeVisitor visitor) throws PersistenceException {
		visitor.handleMAtomicType(this);
	}

	@Override
	public <R> R accept(final AnythingORMATomicTypeReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleMAtomicType(this);
	}

	@Override
	public <E extends UserException> void accept(final AnythingORMATomicTypeExceptionVisitor<E> visitor) throws PersistenceException, E {
		visitor.handleMAtomicType(this);
	}

	@Override
	public <R, E extends UserException> R accept(final AnythingORMATomicTypeReturnExceptionVisitor<R, E> visitor) throws PersistenceException, E {
		return visitor.handleMAtomicType(this);
	}

	@Override
	public void accept(final MAtomicTypeHierarchyHIERARCHYVisitor visitor) throws PersistenceException {
		visitor.handleMAtomicType(this);
	}

	@Override
	public <R> R accept(final MAtomicTypeHierarchyHIERARCHYReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleMAtomicType(this);
	}

	@Override
	public <E extends UserException> void accept(final MAtomicTypeHierarchyHIERARCHYExceptionVisitor<E> visitor) throws PersistenceException, E {
		visitor.handleMAtomicType(this);
	}

	@Override
	public <R, E extends UserException> R accept(final MAtomicTypeHierarchyHIERARCHYReturnExceptionVisitor<R, E> visitor)
			throws PersistenceException, E {
		return visitor.handleMAtomicType(this);
	}

	@Override
	public int getLeafInfo() throws PersistenceException {
		if (this.getSingletonType() != null)
			return 1;
		if (this.getAbstractType() != null)
			return 1;
		if (this.getSubTypes().getLength() > 0)
			return 1;
		if (this.getPossibleNames().getLength() > 0)
			return 1;
		return 0;
	}

	@Override
	public boolean containsMAtomicTypeHierarchy(final MAtomicTypeHierarchyHIERARCHY part) throws PersistenceException {
		if (getThis().equals(part))
			return true;
		if (getThis().getSuperType() != null && getThis().getSuperType().containsMAtomicTypeHierarchy(part))
			return true;
		return false;
	}

	// Start of section that contains operations that must be implemented.

	@Override
	public boolean containsMComplexTypeHierarchy(final MComplexTypeHierarchyHIERARCHY part) throws PersistenceException {
		if (getThis().equals(part))
			return true;
		return false;
	}

	@Override
	public MNonEmptyAtomicTypeConjunctionSearchList getNEATCContainingMe() throws PersistenceException {
		MNonEmptyAtomicTypeConjunctionSearchList result = null;
		if (result == null)
			result = ConnectionHandler.getTheConnectionHandler().theMNonEmptyAtomicTypeConjunctionFacade.inverseGetFactors(this.getId(),
					this.getClassId());
		return result;
	}

	@Override
	public NameSearchList getPossibleNames() throws PersistenceException {
		NameSearchList result = null;
		if (result == null)
			result = ConnectionHandler.getTheConnectionHandler().theNameFacade.inverseGetFromType(this.getId(), this.getClassId());
		return result;
	}

	@Override
	public MAtomicTypeSearchList getSubTypes() throws PersistenceException {
		MAtomicTypeSearchList result = null;
		if (result == null)
			result = ConnectionHandler.getTheConnectionHandler().theMAtomicTypeFacade.inverseGetSuperType(this.getId(), this.getClassId());
		return result;
	}

	@Override
	public void initialize(final Anything This, final java.util.Hashtable<String, Object> final$$Fields) throws PersistenceException {
		this.setThis((PersistentMAtomicType) This);
		if (this.equals(This)) {
			final PersistentCONCMModelItem myCONCMModelItem = model.CONCMModelItem.createCONCMModelItem(this.isDelayed$Persistence(),
					(PersistentMAtomicType) This);
			this.setMyCONCMModelItem(myCONCMModelItem);
			this.setName((String) final$$Fields.get("name"));
			this.setSingletonType((PersistentMBoolean) final$$Fields.get("singletonType"));
			this.setAbstractType((PersistentMBoolean) final$$Fields.get("abstractType"));
			this.setAspect((PersistentMAspect) final$$Fields.get("aspect"));
			try {
				this.setSuperType((AnythingORMATomicType) final$$Fields.get("superType"));
			} catch (final model.CycleException e) {
				throw new persistence.PersistenceExceptionCycleTunnel(e);
			}
		}
	}

	@Override
	public MObjectSearchList inverseGetTypes() throws PersistenceException {
		MObjectSearchList result = null;
		if (result == null)
			result = ConnectionHandler.getTheConnectionHandler().theMObjectFacade.inverseGetTypes(this.getId(), this.getClassId());
		return result;
	}

	@Override
	public <T> T strategyMAtomicTypeHierarchy(final T parameter, final MAtomicTypeHierarchyHIERARCHYStrategy<T> strategy) throws PersistenceException {
		T result$$superType$$MAtomicType = strategy.initialize$$MAtomicType$$superType(getThis(), parameter);
		result$$superType$$MAtomicType = this.getSuperType().strategyMAtomicTypeHierarchy(result$$superType$$MAtomicType, strategy);
		return strategy.finalize$$MAtomicType(getThis(), parameter, result$$superType$$MAtomicType);
	}

	@Override
	public <T> T strategyMComplexTypeHierarchy(final T parameter, final MComplexTypeHierarchyHIERARCHYStrategy<T> strategy)
			throws PersistenceException {
		return strategy.finalize$$MAtomicType(getThis(), parameter);
	}

	@Override
	public String abstractTypeAsString() throws PersistenceException {
		return getThis().getAbstractType().toString();
	}

	@Override
	public void changeAbstract(final PersistentMBoolean newAbstractType) throws model.ConsistencyException, PersistenceException {
		if (getThis().getAbstractType().equals(newAbstractType)) {
			return;
		}

		if (newAbstractType.toBoolean()) {
			if (getThis().getSingletonType().toBoolean()) {
				throw new model.ConsistencyException(ExceptionConstants.CE_AT_SINGLETON_AND_ABSTRACT);
			}
			if (getThis().inverseGetTypes().getLength() > 0) {
				throw new model.ConsistencyException(ExceptionConstants.CE_AT_ABSTRACT_WITH_OBJECTS);
			}
		}
		getThis().setAbstractType(newAbstractType);
	}

	@Override
	public void changeSingleton(final PersistentMBoolean newSingletonType) throws model.ConsistencyException, PersistenceException {
		if (getThis().getSingletonType().equals(newSingletonType)) {
			return;
		}
		if (newSingletonType.toBoolean()) {
			if (getThis().getAbstractType().toBoolean()) {
				throw new model.ConsistencyException(ExceptionConstants.CE_AT_SINGLETON_AND_ABSTRACT);
			}
			if (getThis().inverseGetTypes().getLength() > 0) {
				throw new model.ConsistencyException(ExceptionConstants.CE_AT_SINGLETON_WITH_OBJECTS);
			}
		} else {
			// TODO Singleton consistency check
		}

	}

	@Override
	public void copyingPrivateUserAttributes(final Anything copy) throws PersistenceException {
	}

	@Override
	public MAspectSearchList fetchAspects() throws PersistenceException {
		final MAspectSearchList result = new MAspectSearchList();
		result.add(getThis().getAspect());
		return result;
	}

	@Override
	public MModelItemSearchList fetchDependentItems() throws PersistenceException {
		final MModelItemSearchList result = new MModelItemSearchList();
		SearchLists.addSecondToFirst(result, getThis().fetchTypesContainingThisDirectly());
		SearchLists.addSecondToFirst(result, getThis().inverseGetTypes());
		// TODO add other dependencies (assocs, MMTypes, etc)
		return result;
	}

	@Override
	public PersistentMDisjunctiveNormalForm fetchDisjunctiveNormalform() throws PersistenceException {
		return MNonEmptyDisjunctiveNormalForm.transientCreateDNFromAtomicType(getThis());
	}

	@Override
	public String fetchName() throws PersistenceException {
		return this.getName();
	}

	@Override
	public MTypeSearchList fetchTypesContainingThisDirectly() throws PersistenceException {
		final MTypeSearchList result = new MTypeSearchList();
		SearchLists.addSecondToFirst(result, getThis().getMTCContainingMe());
		SearchLists.addSecondToFirst(result, getThis().getMTDJContainingMe());
		SearchLists.addSecondToFirst(result, getThis().getNEATCContainingMe());
		return result;
	}

	@Override
	public PersistentMBoolean hasConcreteSubType() throws PersistenceException {
		final Iterator<PersistentMAtomicType> subTypesI = getThis().getSubTypes().iterator();
		while (subTypesI.hasNext()) {
			final PersistentMAtomicType currentType = subTypesI.next();
			if (!currentType.isAbstract().toBoolean() || currentType.hasConcreteSubType().toBoolean()) {
				return MTrue.getTheMTrue();
			}
		}
		return MFalse.getTheMFalse();
	}

	@Override
	public void initializeOnCreation() throws PersistenceException {
	}

	@Override
	public void initializeOnInstantiation() throws PersistenceException {
	}

	@Override
	public PersistentMBoolean isAbstract() throws PersistenceException {
		return getThis().getAbstractType();
	}

	@Override
	public PersistentMBoolean isLessOrEqual(final PersistentMType other) throws PersistenceException {
		return MBoolean.createFromBoolean(other.accept(new MTypeReturnVisitor<Boolean>() {

			@Override
			public Boolean handleMMixedTypeDisjunction(final PersistentMMixedTypeDisjunction mMixedTypeDisjunction) throws PersistenceException {
				final Iterator<PersistentMType> iterator = mMixedTypeDisjunction.getAddends().iterator();
				while (iterator.hasNext()) {
					if (getThis().isLessOrEqual(iterator.next()).toBoolean()) {
						return true;
					}
				}
				return false;
			}

			@Override
			public Boolean handleMEmptyTypeDisjunction(final PersistentMEmptyTypeDisjunction mEmptyTypeDisjunction) throws PersistenceException {
				return false;
			}

			@Override
			public Boolean handleMNonEmptyDisjunctiveNormalForm(final PersistentMNonEmptyDisjunctiveNormalForm mNonEmptyDisjunctiveNormalForm)
					throws PersistenceException {
				final Iterator<PersistentMAtomicTypeConjunction> iterator = mNonEmptyDisjunctiveNormalForm.getAddends().iterator();
				while (iterator.hasNext()) {
					if (getThis().isLessOrEqual(iterator.next()).toBoolean()) {
						return true;
					}
				}
				return false;
			}

			@Override
			public Boolean handleMMixedConjunction(final PersistentMMixedConjunction mMixedConjunction) throws PersistenceException {
				final Iterator<PersistentMType> iterator = mMixedConjunction.getFactors().iterator();
				while (iterator.hasNext()) {
					if (!getThis().isLessOrEqual(iterator.next()).toBoolean()) {
						return false;
					}
				}
				return true;
			}

			@Override
			public Boolean handleMNonEmptyAtomicTypeConjunction(final PersistentMNonEmptyAtomicTypeConjunction mNonEmptyAtomicTypeConjunction)
					throws PersistenceException {
				final Iterator<PersistentMAtomicType> iterator = mNonEmptyAtomicTypeConjunction.getFactors().iterator();
				while (iterator.hasNext()) {
					if (!getThis().isLessOrEqual(iterator.next()).toBoolean()) {
						return false;
					}
				}
				return true;
			}

			@Override
			public Boolean handleMEmptyTypeConjunction(final PersistentMEmptyTypeConjunction mEmptyTypeConjunction) throws PersistenceException {
				return true;
			}

			@Override
			public Boolean handleMAtomicType(final PersistentMAtomicType mAtomicType) throws PersistenceException {
				return getThis().containsMAtomicTypeHierarchy(mAtomicType);
			}
		}));
	}

	@Override
	public PersistentMBoolean isSingleton() throws PersistenceException {
		return getSingletonType();
		// return MBoolean.createFromBoolean(getThis().getSingletonType().toBoolean()
		// && !getThis().hasConcreteSubType().toBoolean());
	}

	@Override
	public PersistentMBoolean isStructuralEquivalant(final PersistentMType other) throws PersistenceException {
		return MBoolean.createFromBoolean(getThis().equals(other));
	}

	@Override
	public void prepareForDeletion() throws model.ConsistencyException, PersistenceException {
		// No prep needed
	}

	@Override
	public String singletonTypeAsString() throws PersistenceException {
		return getThis().getSingletonType().toString();
	}

	// Start of section that contains overridden operations only.

	/* Start of protected part that is not overridden by persistence generator */

	/* End of protected part that is not overridden by persistence generator */

}

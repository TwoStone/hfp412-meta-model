package model;

import model.visitor.AnythingExceptionVisitor;
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
import model.visitor.MTypeExceptionVisitor;
import model.visitor.MTypeReturnExceptionVisitor;
import model.visitor.MTypeReturnVisitor;
import model.visitor.MTypeVisitor;
import persistence.AbstractPersistentRoot;
import persistence.Anything;
import persistence.ConnectionHandler;
import persistence.MAtomicTypeHierarchyHIERARCHY;
import persistence.MAtomicTypeHierarchyHIERARCHYStrategy;
import persistence.MAtomicTypeProxi;
import persistence.MAtomicTypeSearchList;
import persistence.MComplexTypeHierarchyHIERARCHY;
import persistence.MComplexTypeHierarchyHIERARCHYStrategy;
import persistence.MType;
import persistence.PersistenceException;
import persistence.PersistentMAspect;
import persistence.PersistentMAtomicType;
import persistence.PersistentMBoolean;
import persistence.PersistentObject;
import persistence.PersistentProxi;
import persistence.TDObserver;

/* Additional import section end */

public class MAtomicType extends PersistentObject implements PersistentMAtomicType {

	/**
	 * Throws persistence exception if the object with the given id does not
	 * exist.
	 */
	public static PersistentMAtomicType getById(long objectId) throws PersistenceException {
		long classId = ConnectionHandler.getTheConnectionHandler().theMAtomicTypeFacade.getClass(objectId);
		return (PersistentMAtomicType) PersistentProxi.createProxi(objectId, classId);
	}

	public static PersistentMAtomicType createMAtomicType(String name, PersistentMAspect aspect) throws PersistenceException {
		return createMAtomicType(name, aspect, false);
	}

	public static PersistentMAtomicType createMAtomicType(String name, PersistentMAspect aspect, boolean delayed$Persistence)
			throws PersistenceException {
		if (name == null)
			throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
		PersistentMAtomicType result = null;
		if (delayed$Persistence) {
			result = ConnectionHandler.getTheConnectionHandler().theMAtomicTypeFacade.newDelayedMAtomicType(name);
			result.setDelayed$Persistence(true);
		} else {
			result = ConnectionHandler.getTheConnectionHandler().theMAtomicTypeFacade.newMAtomicType(name, -1);
		}
		java.util.Hashtable<String, Object> final$$Fields = new java.util.Hashtable<String, Object>();
		final$$Fields.put("name", name);
		final$$Fields.put("aspect", aspect);
		result.initialize(result, final$$Fields);
		result.initializeOnCreation();
		return result;
	}

	public static PersistentMAtomicType createMAtomicType(String name, PersistentMAspect aspect, boolean delayed$Persistence,
			PersistentMAtomicType This) throws PersistenceException {
		if (name == null)
			throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
		PersistentMAtomicType result = null;
		if (delayed$Persistence) {
			result = ConnectionHandler.getTheConnectionHandler().theMAtomicTypeFacade.newDelayedMAtomicType(name);
			result.setDelayed$Persistence(true);
		} else {
			result = ConnectionHandler.getTheConnectionHandler().theMAtomicTypeFacade.newMAtomicType(name, -1);
		}
		java.util.Hashtable<String, Object> final$$Fields = new java.util.Hashtable<String, Object>();
		final$$Fields.put("name", name);
		final$$Fields.put("aspect", aspect);
		result.initialize(This, final$$Fields);
		result.initializeOnCreation();
		return result;
	}

	public java.util.Hashtable<String, Object> toHashtable(java.util.Hashtable<String, Object> allResults, int depth, int essentialLevel,
			boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
		java.util.Hashtable<String, Object> result = null;
		if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth) {
			result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
			result.put("name", this.getName());
			AbstractPersistentRoot aspect = (AbstractPersistentRoot) this.getAspect();
			if (aspect != null) {
				result.put("aspect", aspect.createProxiInformation(false));
				if (depth > 1) {
					aspect.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true, tdObserver);
				} else {
					if (forGUI && aspect.hasEssentialFields())
						aspect.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
				}
			}
			AbstractPersistentRoot superType = (AbstractPersistentRoot) this.getSuperType();
			if (superType != null) {
				result.put("superType", superType.createProxiInformation(false));
				if (depth > 1) {
					superType.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true, tdObserver);
				} else {
					if (forGUI && superType.hasEssentialFields())
						superType.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
				}
			}
			result.put("subTypes",
					this.getSubTypes().getVector(allResults, (depth > 1 ? depth : depth + 1), essentialLevel, forGUI, tdObserver, false));
			String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
			if (leaf && !allResults.contains(uniqueKey))
				allResults.put(uniqueKey, result);
		}
		return result;
	}

	public static MAtomicTypeSearchList getMAtomicTypeByName(String name) throws PersistenceException {
		return ConnectionHandler.getTheConnectionHandler().theMAtomicTypeFacade.getMAtomicTypeByName(name);
	}

	public MAtomicType provideCopy() throws PersistenceException {
		MAtomicType result = this;
		result = new MAtomicType(this.name, this.aspect, this.superType, this.This, this.getId());
		this.copyingPrivateUserAttributes(result);
		return result;
	}

	public boolean hasEssentialFields() throws PersistenceException {
		return false;
	}

	protected String name;
	protected PersistentMAspect aspect;
	protected PersistentMAtomicType superType;
	protected PersistentMAtomicType This;

	public MAtomicType(String name, PersistentMAspect aspect, PersistentMAtomicType superType, PersistentMAtomicType This, long id)
			throws persistence.PersistenceException {
		/*
		 * Shall not be used by clients for object construction! Use static
		 * create operation instead!
		 */
		super(id);
		this.name = name;
		this.aspect = aspect;
		this.superType = superType;
		if (This != null && !(this.equals(This)))
			this.This = This;
	}

	static public long getTypeId() {
		return 102;
	}

	public long getClassId() {
		return getTypeId();
	}

	public void store() throws PersistenceException {
		if (!this.isDelayed$Persistence())
			return;
		if (this.getClassId() == 102)
			ConnectionHandler.getTheConnectionHandler().theMAtomicTypeFacade.newMAtomicType(name, this.getId());
		super.store();
		if (this.getAspect() != null) {
			this.getAspect().store();
			ConnectionHandler.getTheConnectionHandler().theMAtomicTypeFacade.aspectSet(this.getId(), getAspect());
		}
		if (this.getSuperType() != null) {
			this.getSuperType().store();
			ConnectionHandler.getTheConnectionHandler().theMAtomicTypeFacade.superTypeSet(this.getId(), getSuperType());
		}
		if (!this.equals(this.getThis())) {
			this.getThis().store();
			ConnectionHandler.getTheConnectionHandler().theMAtomicTypeFacade.ThisSet(this.getId(), getThis());
		}

	}

	public String getName() throws PersistenceException {
		return this.name;
	}

	public void setName(String newValue) throws PersistenceException {
		if (newValue == null)
			throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
		if (!this.isDelayed$Persistence())
			ConnectionHandler.getTheConnectionHandler().theMAtomicTypeFacade.nameSet(this.getId(), newValue);
		this.name = newValue;
	}

	public PersistentMAspect getAspect() throws PersistenceException {
		return this.aspect;
	}

	public void setAspect(PersistentMAspect newValue) throws PersistenceException {
		if (newValue == null)
			throw new PersistenceException("Null values not allowed!", 0);
		if (newValue.equals(this.aspect))
			return;
		long objectId = newValue.getId();
		long classId = newValue.getClassId();
		this.aspect = (PersistentMAspect) PersistentProxi.createProxi(objectId, classId);
		if (!this.isDelayed$Persistence()) {
			newValue.store();
			ConnectionHandler.getTheConnectionHandler().theMAtomicTypeFacade.aspectSet(this.getId(), newValue);
		}
	}

	public PersistentMAtomicType getSuperType() throws PersistenceException {
		return this.superType;
	}

	public void setSuperType(PersistentMAtomicType newValue) throws PersistenceException, model.CycleException {
		if (newValue == null)
			throw new PersistenceException("Null values not allowed!", 0);
		if (newValue.containsMAtomicTypeHierarchy(getThis()))
			throw new model.CycleException("Cycle in MAtomicTypeHierarchy detected!");
		if (newValue.equals(this.superType))
			return;
		long objectId = newValue.getId();
		long classId = newValue.getClassId();
		this.superType = (PersistentMAtomicType) PersistentProxi.createProxi(objectId, classId);
		if (!this.isDelayed$Persistence()) {
			newValue.store();
			ConnectionHandler.getTheConnectionHandler().theMAtomicTypeFacade.superTypeSet(this.getId(), newValue);
		}
	}

	protected void setThis(PersistentMAtomicType newValue) throws PersistenceException {
		if (newValue == null)
			throw new PersistenceException("Null values not allowed!", 0);
		if (newValue.equals(this)) {
			this.This = null;
			return;
		}
		if (newValue.equals(this.This))
			return;
		long objectId = newValue.getId();
		long classId = newValue.getClassId();
		this.This = (PersistentMAtomicType) PersistentProxi.createProxi(objectId, classId);
		if (!this.isDelayed$Persistence()) {
			newValue.store();
			ConnectionHandler.getTheConnectionHandler().theMAtomicTypeFacade.ThisSet(this.getId(), newValue);
		}
	}

	public PersistentMAtomicType getThis() throws PersistenceException {
		if (this.This == null) {
			PersistentMAtomicType result = new MAtomicTypeProxi(this.getId());
			result.getTheObject();
			return result;
		}
		return (PersistentMAtomicType) this.This;
	}

	public void accept(MComplexTypeHierarchyHIERARCHYVisitor visitor) throws PersistenceException {
		visitor.handleMAtomicType(this);
	}

	public <R> R accept(MComplexTypeHierarchyHIERARCHYReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleMAtomicType(this);
	}

	public <E extends UserException> void accept(MComplexTypeHierarchyHIERARCHYExceptionVisitor<E> visitor) throws PersistenceException, E {
		visitor.handleMAtomicType(this);
	}

	public <R, E extends UserException> R accept(MComplexTypeHierarchyHIERARCHYReturnExceptionVisitor<R, E> visitor) throws PersistenceException, E {
		return visitor.handleMAtomicType(this);
	}

	public void accept(MTypeVisitor visitor) throws PersistenceException {
		visitor.handleMAtomicType(this);
	}

	public <R> R accept(MTypeReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleMAtomicType(this);
	}

	public <E extends UserException> void accept(MTypeExceptionVisitor<E> visitor) throws PersistenceException, E {
		visitor.handleMAtomicType(this);
	}

	public <R, E extends UserException> R accept(MTypeReturnExceptionVisitor<R, E> visitor) throws PersistenceException, E {
		return visitor.handleMAtomicType(this);
	}

	public void accept(MAtomicTypeHierarchyHIERARCHYVisitor visitor) throws PersistenceException {
		visitor.handleMAtomicType(this);
	}

	public <R> R accept(MAtomicTypeHierarchyHIERARCHYReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleMAtomicType(this);
	}

	public <E extends UserException> void accept(MAtomicTypeHierarchyHIERARCHYExceptionVisitor<E> visitor) throws PersistenceException, E {
		visitor.handleMAtomicType(this);
	}

	public <R, E extends UserException> R accept(MAtomicTypeHierarchyHIERARCHYReturnExceptionVisitor<R, E> visitor) throws PersistenceException, E {
		return visitor.handleMAtomicType(this);
	}

	public void accept(AnythingVisitor visitor) throws PersistenceException {
		visitor.handleMAtomicType(this);
	}

	public <R> R accept(AnythingReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleMAtomicType(this);
	}

	public <E extends UserException> void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
		visitor.handleMAtomicType(this);
	}

	public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E> visitor) throws PersistenceException, E {
		return visitor.handleMAtomicType(this);
	}

	public int getLeafInfo() throws PersistenceException {
		return (int) (0 + this.getSubTypes().getLength());
	}

	public boolean containsMAtomicTypeHierarchy(final MAtomicTypeHierarchyHIERARCHY part) throws PersistenceException {
		if (getThis().equals(part))
			return true;
		if (getThis().getSuperType() != null && getThis().getSuperType().containsMAtomicTypeHierarchy(part))
			return true;
		return false;
	}

	public <T> T strategyMAtomicTypeHierarchy(final T parameter, final MAtomicTypeHierarchyHIERARCHYStrategy<T> strategy) throws PersistenceException {
		T result$$superType$$MAtomicType = strategy.initialize$$MAtomicType$$superType(getThis(), parameter);
		result$$superType$$MAtomicType = this.getSuperType().strategyMAtomicTypeHierarchy(result$$superType$$MAtomicType, strategy);
		return strategy.finalize$$MAtomicType(getThis(), parameter, result$$superType$$MAtomicType);
	}

	public void initializeOnInstantiation() throws PersistenceException {
		// TODO: implement method: initializeOnInstantiation

	}

	public void copyingPrivateUserAttributes(final Anything copy) throws PersistenceException {
		// TODO: implement method: copyingPrivateUserAttributes

	}

	public boolean containsMComplexTypeHierarchy(final MComplexTypeHierarchyHIERARCHY part) throws PersistenceException {
		if (getThis().equals(part))
			return true;
		return false;
	}

	public String fetchName() throws PersistenceException {
		return getThis().getName();
	}

	public void initialize(final Anything This, final java.util.Hashtable<String, Object> final$$Fields) throws PersistenceException {
		this.setThis((PersistentMAtomicType) This);
		if (this.equals(This)) {
			this.setName((String) final$$Fields.get("name"));
			this.setAspect((PersistentMAspect) final$$Fields.get("aspect"));
		}
	}

	public PersistentMBoolean lessOrEqual(final MType otherType) throws PersistenceException {
		if (getThis().equals(otherType)) {
			return MTrue.getTheMTrue();
		}
		if (getThis().getSuperType() == null) {
			return MFalse.getTheMFalse();
		}
		if (getThis().getSuperType().equals(otherType)) {
			return MTrue.getTheMTrue();
		}
		return getThis().getSuperType().lessOrEqual(otherType);
	}

	public <T> T strategyMComplexTypeHierarchy(final T parameter, final MComplexTypeHierarchyHIERARCHYStrategy<T> strategy)
			throws PersistenceException {
		return strategy.finalize$$MAtomicType(getThis(), parameter);
	}

	public void initializeOnCreation() throws PersistenceException {
		// TODO: implement method: initializeOnCreation

	}

	public void addSubType(final PersistentMAtomicType typeunder) throws model.WrongSubTypeAspectException, model.CycleException,
			PersistenceException {
		if (typeunder.getAspect().equals(getThis().getAspect())) {
			typeunder.setSuperType(getThis());
		} else {
			throw new WrongSubTypeAspectException("Subtype has not the aspect of the super type!");
		}

	}

	public MAtomicTypeSearchList getSubTypes() throws PersistenceException {
		MAtomicTypeSearchList result = null;
		if (result == null)
			result = ConnectionHandler.getTheConnectionHandler().theMAtomicTypeFacade.inverseGetSuperType(this.getId(), this.getClassId());
		return result;
	}

	/* Start of protected part that is not overridden by persistence generator */

	// public MTypeSearchList getSuperTypes(final TDObserver observer)
	// throws PersistenceException{
	// MTypeSearchList result = getThis().getSuperTypes();
	// observer.updateTransientDerived(getThis(), "superTypes", result);
	// return result;
	// }

	/* End of protected part that is not overridden by persistence generator */

}

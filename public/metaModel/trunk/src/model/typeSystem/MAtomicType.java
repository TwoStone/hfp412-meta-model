package model.typeSystem;

import java.util.Iterator;

import model.UserException;
import model.basic.MBoolean;
import model.basic.MFalse;
import model.basic.MTrue;
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
import persistence.PersistenceException;
import persistence.PersistentMAbstractProductType;
import persistence.PersistentMAspect;
import persistence.PersistentMAtomicType;
import persistence.PersistentMBoolean;
import persistence.PersistentMEmptyProduct;
import persistence.PersistentMEmptySumType;
import persistence.PersistentMProductType;
import persistence.PersistentMSumType;
import persistence.PersistentMType;
import persistence.PersistentProxi;
import persistence.TDObserver;

/* Additional import section end */

public class MAtomicType extends model.typeSystem.MType implements PersistentMAtomicType {

	public static PersistentMAtomicType createMAtomicType(String name, PersistentMBoolean singletonType,
			PersistentMBoolean abstractType, PersistentMAspect aspect) throws PersistenceException {
		return createMAtomicType(name, singletonType, abstractType, aspect, false);
	}

	public static PersistentMAtomicType createMAtomicType(String name, PersistentMBoolean singletonType,
			PersistentMBoolean abstractType, PersistentMAspect aspect, boolean delayed$Persistence)
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
		final$$Fields.put("singletonType", singletonType);
		final$$Fields.put("abstractType", abstractType);
		final$$Fields.put("aspect", aspect);
		result.initialize(result, final$$Fields);
		result.initializeOnCreation();
		return result;
	}

	public static PersistentMAtomicType createMAtomicType(String name, PersistentMBoolean singletonType,
			PersistentMBoolean abstractType, PersistentMAspect aspect, boolean delayed$Persistence,
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
		final$$Fields.put("singletonType", singletonType);
		final$$Fields.put("abstractType", abstractType);
		final$$Fields.put("aspect", aspect);
		result.initialize(This, final$$Fields);
		result.initializeOnCreation();
		return result;
	}

	@Override
	public java.util.Hashtable<String, Object> toHashtable(java.util.Hashtable<String, Object> allResults, int depth,
			int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
		java.util.Hashtable<String, Object> result = null;
		if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth) {
			result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
			result.put("name", this.getName());
			AbstractPersistentRoot singletonType = this.getSingletonType();
			if (singletonType != null) {
				result.put("singletonType", singletonType.createProxiInformation(false));
				if (depth > 1) {
					singletonType.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true, tdObserver);
				} else {
					if (forGUI && singletonType.hasEssentialFields())
						singletonType.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
				}
			}
			AbstractPersistentRoot abstractType = this.getAbstractType();
			if (abstractType != null) {
				result.put("abstractType", abstractType.createProxiInformation(false));
				if (depth > 1) {
					abstractType.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true, tdObserver);
				} else {
					if (forGUI && abstractType.hasEssentialFields())
						abstractType.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
				}
			}
			AbstractPersistentRoot aspect = this.getAspect();
			if (aspect != null) {
				result.put("aspect", aspect.createProxiInformation(false));
				if (depth > 1) {
					aspect.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true, tdObserver);
				} else {
					if (forGUI && aspect.hasEssentialFields())
						aspect.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
				}
			}
			AbstractPersistentRoot superType = this.getSuperType();
			if (superType != null) {
				result.put("superType", superType.createProxiInformation(false));
				if (depth > 1) {
					superType.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true, tdObserver);
				} else {
					if (forGUI && superType.hasEssentialFields())
						superType.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
				}
			}
			result.put(
					"subTypes",
					this.getSubTypes().getVector(allResults, (depth > 1 ? depth : depth + 1), essentialLevel, forGUI,
							tdObserver, false));
			String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
			if (leaf && !allResults.contains(uniqueKey))
				allResults.put(uniqueKey, result);
		}
		return result;
	}

	public static MAtomicTypeSearchList getMAtomicTypeByName(String name) throws PersistenceException {
		return ConnectionHandler.getTheConnectionHandler().theMAtomicTypeFacade.getMAtomicTypeByName(name);
	}

	@Override
	public MAtomicType provideCopy() throws PersistenceException {
		MAtomicType result = this;
		result = new MAtomicType(this.This, this.name, this.singletonType, this.abstractType, this.aspect,
				this.superType, this.getId());
		this.copyingPrivateUserAttributes(result);
		return result;
	}

	@Override
	public boolean hasEssentialFields() throws PersistenceException {
		return false;
	}

	protected String name;
	protected PersistentMBoolean singletonType;
	protected PersistentMBoolean abstractType;
	protected PersistentMAspect aspect;
	protected PersistentMAtomicType superType;

	public MAtomicType(PersistentMType This, String name, PersistentMBoolean singletonType,
			PersistentMBoolean abstractType, PersistentMAspect aspect, PersistentMAtomicType superType, long id)
			throws persistence.PersistenceException {
		/* Shall not be used by clients for object construction! Use static create operation instead! */
		super(This, id);
		this.name = name;
		this.singletonType = singletonType;
		this.abstractType = abstractType;
		this.aspect = aspect;
		this.superType = superType;
	}

	static public long getTypeId() {
		return 102;
	}

	@Override
	public long getClassId() {
		return getTypeId();
	}

	@Override
	public void store() throws PersistenceException {
		if (!this.isDelayed$Persistence())
			return;
		if (this.getClassId() == 102)
			ConnectionHandler.getTheConnectionHandler().theMAtomicTypeFacade.newMAtomicType(name, this.getId());
		super.store();
		if (this.getSingletonType() != null) {
			this.getSingletonType().store();
			ConnectionHandler.getTheConnectionHandler().theMAtomicTypeFacade.singletonTypeSet(this.getId(),
					getSingletonType());
		}
		if (this.getAbstractType() != null) {
			this.getAbstractType().store();
			ConnectionHandler.getTheConnectionHandler().theMAtomicTypeFacade.abstractTypeSet(this.getId(),
					getAbstractType());
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
	public void setName(String newValue) throws PersistenceException {
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
	public void setSingletonType(PersistentMBoolean newValue) throws PersistenceException {
		if (newValue == null)
			throw new PersistenceException("Null values not allowed!", 0);
		if (newValue.equals(this.singletonType))
			return;
		long objectId = newValue.getId();
		long classId = newValue.getClassId();
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
	public void setAbstractType(PersistentMBoolean newValue) throws PersistenceException {
		if (newValue == null)
			throw new PersistenceException("Null values not allowed!", 0);
		if (newValue.equals(this.abstractType))
			return;
		long objectId = newValue.getId();
		long classId = newValue.getClassId();
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

	@Override
	public PersistentMAtomicType getSuperType() throws PersistenceException {
		return this.superType;
	}

	@Override
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

	@Override
	public PersistentMAtomicType getThis() throws PersistenceException {
		if (this.This == null) {
			PersistentMAtomicType result = new MAtomicTypeProxi(this.getId());
			result.getTheObject();
			return result;
		}
		return (PersistentMAtomicType) this.This;
	}

	@Override
	public void accept(MTypeVisitor visitor) throws PersistenceException {
		visitor.handleMAtomicType(this);
	}

	@Override
	public <R> R accept(MTypeReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleMAtomicType(this);
	}

	@Override
	public <E extends UserException> void accept(MTypeExceptionVisitor<E> visitor) throws PersistenceException, E {
		visitor.handleMAtomicType(this);
	}

	@Override
	public <R, E extends UserException> R accept(MTypeReturnExceptionVisitor<R, E> visitor)
			throws PersistenceException, E {
		return visitor.handleMAtomicType(this);
	}

	@Override
	public void accept(MComplexTypeHierarchyHIERARCHYVisitor visitor) throws PersistenceException {
		visitor.handleMAtomicType(this);
	}

	@Override
	public <R> R accept(MComplexTypeHierarchyHIERARCHYReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleMAtomicType(this);
	}

	@Override
	public <E extends UserException> void accept(MComplexTypeHierarchyHIERARCHYExceptionVisitor<E> visitor)
			throws PersistenceException, E {
		visitor.handleMAtomicType(this);
	}

	@Override
	public <R, E extends UserException> R accept(MComplexTypeHierarchyHIERARCHYReturnExceptionVisitor<R, E> visitor)
			throws PersistenceException, E {
		return visitor.handleMAtomicType(this);
	}

	@Override
	public void accept(AnythingVisitor visitor) throws PersistenceException {
		visitor.handleMAtomicType(this);
	}

	@Override
	public <R> R accept(AnythingReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleMAtomicType(this);
	}

	@Override
	public <E extends UserException> void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
		visitor.handleMAtomicType(this);
	}

	@Override
	public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E> visitor)
			throws PersistenceException, E {
		return visitor.handleMAtomicType(this);
	}

	@Override
	public void accept(MAtomicTypeHierarchyHIERARCHYVisitor visitor) throws PersistenceException {
		visitor.handleMAtomicType(this);
	}

	@Override
	public <R> R accept(MAtomicTypeHierarchyHIERARCHYReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleMAtomicType(this);
	}

	@Override
	public <E extends UserException> void accept(MAtomicTypeHierarchyHIERARCHYExceptionVisitor<E> visitor)
			throws PersistenceException, E {
		visitor.handleMAtomicType(this);
	}

	@Override
	public <R, E extends UserException> R accept(MAtomicTypeHierarchyHIERARCHYReturnExceptionVisitor<R, E> visitor)
			throws PersistenceException, E {
		return visitor.handleMAtomicType(this);
	}

	@Override
	public int getLeafInfo() throws PersistenceException {
		return (int) (0 + (this.getSingletonType() == null ? 0 : 1) + (this.getAbstractType() == null ? 0 : 1) + this
				.getSubTypes().getLength());
	}

	@Override
	public boolean containsMAtomicTypeHierarchy(final MAtomicTypeHierarchyHIERARCHY part) throws PersistenceException {
		if (getThis().equals(part))
			return true;
		if (getThis().getSuperType() != null && getThis().getSuperType().containsMAtomicTypeHierarchy(part))
			return true;
		return false;
	}

	@Override
	public void initializeOnInstantiation() throws PersistenceException {
		// TODO: implement method: initializeOnInstantiation

	}

	@Override
	public boolean containsMComplexTypeHierarchy(final MComplexTypeHierarchyHIERARCHY part) throws PersistenceException {
		if (getThis().equals(part))
			return true;
		return false;
	}

	@Override
	public String fetchName() throws PersistenceException {
		return this.getName();
	}

	@Override
	public PersistentMBoolean isStructuralEquivalant(final PersistentMType other) throws PersistenceException {
		return other.accept(new MTypeReturnVisitor<PersistentMBoolean>() {

			@Override
			public PersistentMBoolean handleMAbstractProductType(PersistentMAbstractProductType mAbstractProductType)
					throws PersistenceException {
				return MFalse.getTheMFalse();
			}

			@Override
			public PersistentMBoolean handleMEmptySumType(PersistentMEmptySumType mEmptySumType)
					throws PersistenceException {
				return MFalse.getTheMFalse();
			}

			@Override
			public PersistentMBoolean handleMSumType(PersistentMSumType mSumType) throws PersistenceException {
				return MFalse.getTheMFalse();
			}

			@Override
			public PersistentMBoolean handleMProductType(PersistentMProductType mProductType)
					throws PersistenceException {
				return MFalse.getTheMFalse();
			}

			@Override
			public PersistentMBoolean handleMEmptyProduct(PersistentMEmptyProduct mEmptyProduct)
					throws PersistenceException {
				return MFalse.getTheMFalse();
			}

			@Override
			public PersistentMBoolean handleMAtomicType(PersistentMAtomicType mAtomicType) throws PersistenceException {
				return MBoolean.createFromBoolean(getThis().getAspect().equals(mAtomicType.getAspect())
						&& getThis().getName().equals(mAtomicType.getName()));
			}
		});
	}

	@Override
	public <T> T strategyMComplexTypeHierarchy(final T parameter,
			final MComplexTypeHierarchyHIERARCHYStrategy<T> strategy) throws PersistenceException {
		return strategy.finalize$$MAtomicType(getThis(), parameter);
	}

	@Override
	public void initializeOnCreation() throws PersistenceException {
		// TODO: implement method: initializeOnCreation

	}

	@Override
	public PersistentMBoolean hasConcreteSubType() throws PersistenceException {
		Iterator<PersistentMAtomicType> subTypesI = getThis().getSubTypes().iterator();
		while (subTypesI.hasNext()) {
			PersistentMAtomicType currentType = subTypesI.next();
			if (!currentType.isAbstract().toBoolean() || currentType.hasConcreteSubType().toBoolean()) {
				return MTrue.getTheMTrue();
			}
		}
		return MFalse.getTheMFalse();
	}

	@Override
	public PersistentMBoolean isLessOrEqual() throws PersistenceException {
		// TODO: implement method: isLessOrEqual
		try {
			throw new java.lang.UnsupportedOperationException("Method \"isLessOrEqual\" not implemented yet.");
		} catch (java.lang.UnsupportedOperationException uoe) {
			uoe.printStackTrace();
			throw uoe;
		}
	}

	@Override
	public MAtomicTypeSearchList getSubTypes() throws PersistenceException {
		MAtomicTypeSearchList result = null;
		if (result == null)
			result = ConnectionHandler.getTheConnectionHandler().theMAtomicTypeFacade.inverseGetSuperType(this.getId(),
					this.getClassId());
		return result;
	}

	@Override
	public <T> T strategyMAtomicTypeHierarchy(final T parameter, final MAtomicTypeHierarchyHIERARCHYStrategy<T> strategy)
			throws PersistenceException {
		T result$$superType$$MAtomicType = strategy.initialize$$MAtomicType$$superType(getThis(), parameter);
		result$$superType$$MAtomicType = this.getSuperType().strategyMAtomicTypeHierarchy(
				result$$superType$$MAtomicType, strategy);
		return strategy.finalize$$MAtomicType(getThis(), parameter, result$$superType$$MAtomicType);
	}

	@Override
	public void copyingPrivateUserAttributes(final Anything copy) throws PersistenceException {
		// TODO: implement method: copyingPrivateUserAttributes

	}

	@Override
	public void initialize(final Anything This, final java.util.Hashtable<String, Object> final$$Fields)
			throws PersistenceException {
		this.setThis((PersistentMAtomicType) This);
		if (this.equals(This)) {
			this.setName((String) final$$Fields.get("name"));
			this.setSingletonType((PersistentMBoolean) final$$Fields.get("singletonType"));
			this.setAbstractType((PersistentMBoolean) final$$Fields.get("abstractType"));
			this.setAspect((PersistentMAspect) final$$Fields.get("aspect"));
		}
	}

	@Override
	public PersistentMBoolean isSingleton() throws PersistenceException {
		return MBoolean.createFromBoolean(getThis().getSingletonType().toBoolean()
				&& !getThis().hasConcreteSubType().toBoolean());
	}

	@Override
	public PersistentMBoolean isAbstract() throws PersistenceException {
		return getThis().getAbstractType();
	}

	/* Start of protected part that is not overridden by persistence generator */

	/* End of protected part that is not overridden by persistence generator */

}

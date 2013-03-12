package model.abstractOperation;

import persistence.AbsOperationSearchList;
import persistence.AbsOperation_ParametersProxi;
import persistence.AbstractPersistentRoot;
import persistence.Anything;
import persistence.ConnectionHandler;
import persistence.PersistenceException;
import persistence.PersistentAbsOperation;
import persistence.PersistentCONCMModelItem;
import persistence.PersistentMModelItem;
import persistence.PersistentMType;
import persistence.PersistentObject;
import persistence.PersistentProxi;
import persistence.TDObserver;

/* Additional import section end */

public abstract class AbsOperation extends PersistentObject implements PersistentAbsOperation {

	/** Throws persistence exception if the object with the given id does not exist. */
	public static PersistentAbsOperation getById(final long objectId) throws PersistenceException {
		final long classId = ConnectionHandler.getTheConnectionHandler().theAbsOperationFacade.getClass(objectId);
		return (PersistentAbsOperation) PersistentProxi.createProxi(objectId, classId);
	}

	@Override
	public java.util.Hashtable<String, Object> toHashtable(final java.util.Hashtable<String, Object> allResults, final int depth,
			final int essentialLevel, final boolean forGUI, final boolean leaf, final TDObserver tdObserver) throws PersistenceException {
		java.util.Hashtable<String, Object> result = null;
		if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth) {
			result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
			result.put("name", this.getName());
			final AbstractPersistentRoot source = this.getSource();
			if (source != null) {
				result.put("source", source.createProxiInformation(false, essentialLevel == 0));
				if (depth > 1) {
					source.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true, tdObserver);
				} else {
					if (forGUI && source.hasEssentialFields())
						source.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
				}
			}
			final AbstractPersistentRoot target = this.getTarget();
			if (target != null) {
				result.put("target", target.createProxiInformation(false, essentialLevel == 0));
				if (depth > 1) {
					target.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true, tdObserver);
				} else {
					if (forGUI && target.hasEssentialFields())
						target.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
				}
			}
			result.put("parameters", this.getParameters()
					.getVector(allResults, depth, essentialLevel, forGUI, tdObserver, false, essentialLevel == 0));
			final AbstractPersistentRoot myCONCMModelItem = this.getMyCONCMModelItem();
			if (myCONCMModelItem != null) {
				result.put("myCONCMModelItem", myCONCMModelItem.createProxiInformation(false, essentialLevel == 0));
				if (depth > 1) {
					myCONCMModelItem.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true, tdObserver);
				} else {
					myCONCMModelItem.toHashtable(allResults, depth, essentialLevel + 1, forGUI, true, tdObserver);
				}
			}
			final String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
			if (leaf && !allResults.contains(uniqueKey))
				allResults.put(uniqueKey, result);
		}
		return result;
	}

	public static AbsOperationSearchList getAbsOperationByName(final String name) throws PersistenceException {
		return ConnectionHandler.getTheConnectionHandler().theAbsOperationFacade.getAbsOperationByName(name);
	}

	@Override
	public abstract AbsOperation provideCopy() throws PersistenceException;

	@Override
	public boolean hasEssentialFields() throws PersistenceException {
		return true;
	}

	protected String name;
	protected PersistentMType source;
	protected PersistentMType target;
	protected AbsOperation_ParametersProxi parameters;
	protected PersistentAbsOperation This;
	protected PersistentMModelItem myCONCMModelItem;

	public AbsOperation(final String name, final PersistentMType source, final PersistentMType target, final PersistentAbsOperation This,
			final PersistentMModelItem myCONCMModelItem, final long id) throws persistence.PersistenceException {
		/* Shall not be used by clients for object construction! Use static create operation instead! */
		super(id);
		this.name = name;
		this.source = source;
		this.target = target;
		this.parameters = new AbsOperation_ParametersProxi(this);
		if (This != null && !(this.equals(This)))
			this.This = This;
		this.myCONCMModelItem = myCONCMModelItem;
	}

	static public long getTypeId() {
		return 107;
	}

	@Override
	public long getClassId() {
		return getTypeId();
	}

	@Override
	public void store() throws PersistenceException {
		if (!this.isDelayed$Persistence())
			return;
		super.store();
		if (this.getSource() != null) {
			this.getSource().store();
			ConnectionHandler.getTheConnectionHandler().theAbsOperationFacade.sourceSet(this.getId(), getSource());
		}
		if (this.getTarget() != null) {
			this.getTarget().store();
			ConnectionHandler.getTheConnectionHandler().theAbsOperationFacade.targetSet(this.getId(), getTarget());
		}
		this.getParameters().store();
		if (!this.equals(this.getThis())) {
			this.getThis().store();
			ConnectionHandler.getTheConnectionHandler().theAbsOperationFacade.ThisSet(this.getId(), getThis());
		}
		if (this.getMyCONCMModelItem() != null) {
			this.getMyCONCMModelItem().store();
			ConnectionHandler.getTheConnectionHandler().theAbsOperationFacade.myCONCMModelItemSet(this.getId(), getMyCONCMModelItem());
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
			ConnectionHandler.getTheConnectionHandler().theAbsOperationFacade.nameSet(this.getId(), newValue);
		this.name = newValue;
	}

	@Override
	public PersistentMType getSource() throws PersistenceException {
		return this.source;
	}

	@Override
	public void setSource(final PersistentMType newValue) throws PersistenceException {
		if (newValue == null)
			throw new PersistenceException("Null values not allowed!", 0);
		if (newValue.equals(this.source))
			return;
		final long objectId = newValue.getId();
		final long classId = newValue.getClassId();
		this.source = (PersistentMType) PersistentProxi.createProxi(objectId, classId);
		if (!this.isDelayed$Persistence()) {
			newValue.store();
			ConnectionHandler.getTheConnectionHandler().theAbsOperationFacade.sourceSet(this.getId(), newValue);
		}
	}

	@Override
	public PersistentMType getTarget() throws PersistenceException {
		return this.target;
	}

	@Override
	public void setTarget(final PersistentMType newValue) throws PersistenceException {
		if (newValue == null)
			throw new PersistenceException("Null values not allowed!", 0);
		if (newValue.equals(this.target))
			return;
		final long objectId = newValue.getId();
		final long classId = newValue.getClassId();
		this.target = (PersistentMType) PersistentProxi.createProxi(objectId, classId);
		if (!this.isDelayed$Persistence()) {
			newValue.store();
			ConnectionHandler.getTheConnectionHandler().theAbsOperationFacade.targetSet(this.getId(), newValue);
		}
	}

	@Override
	public AbsOperation_ParametersProxi getParameters() throws PersistenceException {
		return this.parameters;
	}

	protected void setThis(final PersistentAbsOperation newValue) throws PersistenceException {
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
		this.This = (PersistentAbsOperation) PersistentProxi.createProxi(objectId, classId);
		if (!this.isDelayed$Persistence()) {
			newValue.store();
			ConnectionHandler.getTheConnectionHandler().theAbsOperationFacade.ThisSet(this.getId(), newValue);
		}
	}

	@Override
	public PersistentMModelItem getMyCONCMModelItem() throws PersistenceException {
		return this.myCONCMModelItem;
	}

	@Override
	public void setMyCONCMModelItem(final PersistentMModelItem newValue) throws PersistenceException {
		if (newValue == null)
			throw new PersistenceException("Null values not allowed!", 0);
		if (newValue.equals(this.myCONCMModelItem))
			return;
		final long objectId = newValue.getId();
		final long classId = newValue.getClassId();
		this.myCONCMModelItem = (PersistentMModelItem) PersistentProxi.createProxi(objectId, classId);
		if (!this.isDelayed$Persistence()) {
			newValue.store();
			ConnectionHandler.getTheConnectionHandler().theAbsOperationFacade.myCONCMModelItemSet(this.getId(), newValue);
		}
	}

	@Override
	public abstract PersistentAbsOperation getThis() throws PersistenceException;

	@Override
	public void delete$Me() throws PersistenceException {
		super.delete$Me();
		this.getMyCONCMModelItem().delete$Me();
	}

	@Override
	public void initialize(final Anything This, final java.util.Hashtable<String, Object> final$$Fields) throws PersistenceException {
		this.setThis((PersistentAbsOperation) This);
		if (this.equals(This)) {
			final PersistentCONCMModelItem myCONCMModelItem = model.CONCMModelItem.createCONCMModelItem(this.isDelayed$Persistence(),
					(PersistentAbsOperation) This);
			this.setMyCONCMModelItem(myCONCMModelItem);
			this.setName((String) final$$Fields.get("name"));
			this.setSource((PersistentMType) final$$Fields.get("source"));
			this.setTarget((PersistentMType) final$$Fields.get("target"));
		}
	}

	// Start of section that contains operations that must be implemented.

	@Override
	public void copyingPrivateUserAttributes(final Anything copy) throws PersistenceException {
	}

	@Override
	public void initializeOnCreation() throws PersistenceException {
	}

	@Override
	public void initializeOnInstantiation() throws PersistenceException {
	}

	// Start of section that contains overridden operations only.

	@Override
	public void delete() throws model.ConsistencyException, PersistenceException {
		getThis().getMyCONCMModelItem().delete();
	}

	@Override
	public void prepareForDeletion() throws model.ConsistencyException, PersistenceException {
	}
	/* Start of protected part that is not overridden by persistence generator */

	/* End of protected part that is not overridden by persistence generator */

}

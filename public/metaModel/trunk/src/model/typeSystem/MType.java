package model.typeSystem;

import persistence.AbsOperationSearchList;
import persistence.AbstractPersistentRoot;
import persistence.Anything;
import persistence.ConnectionHandler;
import persistence.MMixedConjunctionSearchList;
import persistence.MMixedTypeDisjunctionSearchList;
import persistence.PersistenceException;
import persistence.PersistentCONCMModelItem;
import persistence.PersistentMModelItem;
import persistence.PersistentMType;
import persistence.PersistentObject;
import persistence.PersistentProxi;
import persistence.TDObserver;

/* Additional import section end */

public abstract class MType extends PersistentObject implements PersistentMType {

	/** Throws persistence exception if the object with the given id does not exist. */
	public static PersistentMType getById(final long objectId) throws PersistenceException {
		final long classId = ConnectionHandler.getTheConnectionHandler().theMTypeFacade.getClass(objectId);
		return (PersistentMType) PersistentProxi.createProxi(objectId, classId);
	}

	@Override
	public java.util.Hashtable<String, Object> toHashtable(final java.util.Hashtable<String, Object> allResults,
			final int depth, final int essentialLevel, final boolean forGUI, final boolean leaf,
			final TDObserver tdObserver) throws PersistenceException {
		java.util.Hashtable<String, Object> result = null;
		if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth) {
			result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
			result.put(
					"mTDJContainingMe",
					this.getMTDJContainingMe().getVector(allResults, (depth > 1 ? depth : depth + 1), essentialLevel,
							forGUI, tdObserver, false, essentialLevel == 0));
			result.put(
					"mTCContainingMe",
					this.getMTCContainingMe().getVector(allResults, (depth > 1 ? depth : depth + 1), essentialLevel,
							forGUI, tdObserver, false, essentialLevel == 0));
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

	@Override
	public abstract MType provideCopy() throws PersistenceException;

	@Override
	public boolean hasEssentialFields() throws PersistenceException {
		return true;
	}

	protected PersistentMType This;
	protected PersistentMModelItem myCONCMModelItem;

	public MType(final PersistentMType This, final PersistentMModelItem myCONCMModelItem, final long id)
			throws persistence.PersistenceException {
		/* Shall not be used by clients for object construction! Use static create operation instead! */
		super(id);
		if (This != null && !(this.equals(This)))
			this.This = This;
		this.myCONCMModelItem = myCONCMModelItem;
	}

	static public long getTypeId() {
		return 172;
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
		if (!this.equals(this.getThis())) {
			this.getThis().store();
			ConnectionHandler.getTheConnectionHandler().theMTypeFacade.ThisSet(this.getId(), getThis());
		}
		if (this.getMyCONCMModelItem() != null) {
			this.getMyCONCMModelItem().store();
			ConnectionHandler.getTheConnectionHandler().theMTypeFacade.myCONCMModelItemSet(this.getId(),
					getMyCONCMModelItem());
		}

	}

	protected void setThis(final PersistentMType newValue) throws PersistenceException {
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
		this.This = (PersistentMType) PersistentProxi.createProxi(objectId, classId);
		if (!this.isDelayed$Persistence()) {
			newValue.store();
			ConnectionHandler.getTheConnectionHandler().theMTypeFacade.ThisSet(this.getId(), newValue);
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
			ConnectionHandler.getTheConnectionHandler().theMTypeFacade.myCONCMModelItemSet(this.getId(), newValue);
		}
	}

	@Override
	public abstract PersistentMType getThis() throws PersistenceException;

	@Override
	public void delete$Me() throws PersistenceException {
		super.delete$Me();
		this.getMyCONCMModelItem().delete$Me();
	}

	@Override
	public MMixedConjunctionSearchList getMTCContainingMe() throws PersistenceException {
		MMixedConjunctionSearchList result = null;
		if (result == null)
			result = ConnectionHandler.getTheConnectionHandler().theMMixedConjunctionFacade.inverseGetFactors(
					this.getId(), this.getClassId());
		return result;
	}

	// Start of section that contains operations that must be implemented.

	@Override
	public MMixedTypeDisjunctionSearchList getMTDJContainingMe() throws PersistenceException {
		MMixedTypeDisjunctionSearchList result = null;
		if (result == null)
			result = ConnectionHandler.getTheConnectionHandler().theMMixedTypeDisjunctionFacade.inverseGetAddends(
					this.getId(), this.getClassId());
		return result;
	}

	@Override
	public void initialize(final Anything This, final java.util.Hashtable<String, Object> final$$Fields)
			throws PersistenceException {
		this.setThis((PersistentMType) This);
		if (this.equals(This)) {
			final PersistentCONCMModelItem myCONCMModelItem = model.CONCMModelItem.createCONCMModelItem(
					this.isDelayed$Persistence(), (PersistentMType) This);
			this.setMyCONCMModelItem(myCONCMModelItem);
		}
	}

	@Override
	public AbsOperationSearchList inverseGetSource() throws PersistenceException {
		AbsOperationSearchList result = null;
		if (result == null)
			result = ConnectionHandler.getTheConnectionHandler().theAbsOperationFacade.inverseGetSource(this.getId(),
					this.getClassId());
		return result;
	}

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
		this.getMyCONCMModelItem().delete();
	}

	/* Start of protected part that is not overridden by persistence generator */

	/* End of protected part that is not overridden by persistence generator */

}

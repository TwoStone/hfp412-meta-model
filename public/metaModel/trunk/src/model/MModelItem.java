package model;

import persistence.Anything;
import persistence.ConnectionHandler;
import persistence.MModelItemSearchList;
import persistence.PersistenceException;
import persistence.PersistentMModelItem;
import persistence.PersistentObject;
import persistence.PersistentProxi;
import persistence.TDObserver;

/* Additional import section end */

public abstract class MModelItem extends PersistentObject implements PersistentMModelItem {

	/** Throws persistence exception if the object with the given id does not exist. */
	public static PersistentMModelItem getById(long objectId) throws PersistenceException {
		long classId = ConnectionHandler.getTheConnectionHandler().theMModelItemFacade.getClass(objectId);
		return (PersistentMModelItem) PersistentProxi.createProxi(objectId, classId);
	}

	@Override
	public java.util.Hashtable<String, Object> toHashtable(java.util.Hashtable<String, Object> allResults, int depth,
			int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
		java.util.Hashtable<String, Object> result = null;
		if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth) {
			result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
			result.put(
					"dependentItems",
					this.getDependentItems(tdObserver).getVector(allResults, (depth > 1 ? depth : depth + 1),
							essentialLevel, forGUI, tdObserver, false));
			String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
			if (leaf && !allResults.contains(uniqueKey))
				allResults.put(uniqueKey, result);
		}
		return result;
	}

	@Override
	public abstract MModelItem provideCopy() throws PersistenceException;

	@Override
	public boolean hasEssentialFields() throws PersistenceException {
		return false;
	}

	protected PersistentMModelItem This;

	public MModelItem(PersistentMModelItem This, long id) throws persistence.PersistenceException {
		/* Shall not be used by clients for object construction! Use static create operation instead! */
		super(id);
		if (This != null && !(this.equals(This)))
			this.This = This;
	}

	static public long getTypeId() {
		return 322;
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
			ConnectionHandler.getTheConnectionHandler().theMModelItemFacade.ThisSet(this.getId(), getThis());
		}

	}

	protected void setThis(PersistentMModelItem newValue) throws PersistenceException {
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
		this.This = (PersistentMModelItem) PersistentProxi.createProxi(objectId, classId);
		if (!this.isDelayed$Persistence()) {
			newValue.store();
			ConnectionHandler.getTheConnectionHandler().theMModelItemFacade.ThisSet(this.getId(), newValue);
		}
	}

	@Override
	public abstract PersistentMModelItem getThis() throws PersistenceException;

	@Override
	public MModelItemSearchList getDependentItems(final TDObserver observer) throws PersistenceException {
		MModelItemSearchList result = getThis().getDependentItems();
		observer.updateTransientDerived(getThis(), "dependentItems", result);
		return result;
	}

	@Override
	public void initializeOnInstantiation() throws PersistenceException {
	}

	@Override
	public void copyingPrivateUserAttributes(final Anything copy) throws PersistenceException {
	}

	@Override
	public void initialize(final Anything This, final java.util.Hashtable<String, Object> final$$Fields)
			throws PersistenceException {
		this.setThis((PersistentMModelItem) This);
		if (this.equals(This)) {
		}
	}

	@Override
	public void initializeOnCreation() throws PersistenceException {
	}

	@Override
	public void delete() throws model.ConsistencyException, PersistenceException {
		MModelItemSearchList dependentItems = getThis().getDependentItems();
		if (dependentItems.getLength() > 0) {
			throw new ConsistencyException("Cant delete " + getThis() + " because it has " + dependentItems.getLength()
					+ " ModelItems");
			// TODO ueber besseren Text nachdenken (objekte nennen)
		}
		getThis().prepareForDeletion();
		getThis().delete$Me();
	}
	/* Start of protected part that is not overridden by persistence generator */

	/* End of protected part that is not overridden by persistence generator */

}

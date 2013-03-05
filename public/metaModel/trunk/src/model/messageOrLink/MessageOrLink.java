package model.messageOrLink;

import persistence.AbstractPersistentRoot;
import persistence.Anything;
import persistence.ConnectionHandler;
import persistence.MModelItemSearchList;
import persistence.PersistenceException;
import persistence.PersistentCONCMModelItem;
import persistence.PersistentMModelItem;
import persistence.PersistentMObject;
import persistence.PersistentMessageOrLink;
import persistence.PersistentObject;
import persistence.PersistentProxi;
import persistence.TDObserver;

/* Additional import section end */

public abstract class MessageOrLink extends PersistentObject implements PersistentMessageOrLink {

	/** Throws persistence exception if the object with the given id does not exist. */
	public static PersistentMessageOrLink getById(final long objectId) throws PersistenceException {
		final long classId = ConnectionHandler.getTheConnectionHandler().theMessageOrLinkFacade.getClass(objectId);
		return (PersistentMessageOrLink) PersistentProxi.createProxi(objectId, classId);
	}

	@Override
	public java.util.Hashtable<String, Object> toHashtable(final java.util.Hashtable<String, Object> allResults,
			final int depth, final int essentialLevel, final boolean forGUI, final boolean leaf,
			final TDObserver tdObserver) throws PersistenceException {
		java.util.Hashtable<String, Object> result = null;
		if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth) {
			result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
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
	public abstract MessageOrLink provideCopy() throws PersistenceException;

	@Override
	public boolean hasEssentialFields() throws PersistenceException {
		return true;
	}

	protected PersistentMObject source;
	protected PersistentMObject target;
	protected PersistentMessageOrLink This;
	protected PersistentMModelItem myCONCMModelItem;

	public MessageOrLink(final PersistentMObject source, final PersistentMObject target,
			final PersistentMessageOrLink This, final PersistentMModelItem myCONCMModelItem, final long id)
			throws persistence.PersistenceException {
		/* Shall not be used by clients for object construction! Use static create operation instead! */
		super(id);
		this.source = source;
		this.target = target;
		if (This != null && !(this.equals(This)))
			this.This = This;
		this.myCONCMModelItem = myCONCMModelItem;
	}

	static public long getTypeId() {
		return 190;
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
			ConnectionHandler.getTheConnectionHandler().theMessageOrLinkFacade.sourceSet(this.getId(), getSource());
		}
		if (this.getTarget() != null) {
			this.getTarget().store();
			ConnectionHandler.getTheConnectionHandler().theMessageOrLinkFacade.targetSet(this.getId(), getTarget());
		}
		if (!this.equals(this.getThis())) {
			this.getThis().store();
			ConnectionHandler.getTheConnectionHandler().theMessageOrLinkFacade.ThisSet(this.getId(), getThis());
		}
		if (this.getMyCONCMModelItem() != null) {
			this.getMyCONCMModelItem().store();
			ConnectionHandler.getTheConnectionHandler().theMessageOrLinkFacade.myCONCMModelItemSet(this.getId(),
					getMyCONCMModelItem());
		}

	}

	@Override
	public PersistentMObject getSource() throws PersistenceException {
		return this.source;
	}

	@Override
	public void setSource(final PersistentMObject newValue) throws PersistenceException {
		if (newValue == null)
			throw new PersistenceException("Null values not allowed!", 0);
		if (newValue.equals(this.source))
			return;
		final long objectId = newValue.getId();
		final long classId = newValue.getClassId();
		this.source = (PersistentMObject) PersistentProxi.createProxi(objectId, classId);
		if (!this.isDelayed$Persistence()) {
			newValue.store();
			ConnectionHandler.getTheConnectionHandler().theMessageOrLinkFacade.sourceSet(this.getId(), newValue);
		}
	}

	@Override
	public PersistentMObject getTarget() throws PersistenceException {
		return this.target;
	}

	@Override
	public void setTarget(final PersistentMObject newValue) throws PersistenceException {
		if (newValue == null)
			throw new PersistenceException("Null values not allowed!", 0);
		if (newValue.equals(this.target))
			return;
		final long objectId = newValue.getId();
		final long classId = newValue.getClassId();
		this.target = (PersistentMObject) PersistentProxi.createProxi(objectId, classId);
		if (!this.isDelayed$Persistence()) {
			newValue.store();
			ConnectionHandler.getTheConnectionHandler().theMessageOrLinkFacade.targetSet(this.getId(), newValue);
		}
	}

	protected void setThis(final PersistentMessageOrLink newValue) throws PersistenceException {
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
		this.This = (PersistentMessageOrLink) PersistentProxi.createProxi(objectId, classId);
		if (!this.isDelayed$Persistence()) {
			newValue.store();
			ConnectionHandler.getTheConnectionHandler().theMessageOrLinkFacade.ThisSet(this.getId(), newValue);
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
			ConnectionHandler.getTheConnectionHandler().theMessageOrLinkFacade.myCONCMModelItemSet(this.getId(),
					newValue);
		}
	}

	@Override
	public abstract PersistentMessageOrLink getThis() throws PersistenceException;

	@Override
	public void delete$Me() throws PersistenceException {
		super.delete$Me();
		this.getMyCONCMModelItem().delete$Me();
	}

	@Override
	public void initialize(final Anything This, final java.util.Hashtable<String, Object> final$$Fields)
			throws PersistenceException {
		this.setThis((PersistentMessageOrLink) This);
		if (this.equals(This)) {
			final PersistentCONCMModelItem myCONCMModelItem = model.CONCMModelItem.createCONCMModelItem(
					this.isDelayed$Persistence(), (PersistentMessageOrLink) This);
			this.setMyCONCMModelItem(myCONCMModelItem);
			this.setSource((PersistentMObject) final$$Fields.get("source"));
			this.setTarget((PersistentMObject) final$$Fields.get("target"));
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
		// TODO: Christin: Check delegation to abstract class and overwrite if necessary!
		this.getMyCONCMModelItem().delete();
	}

	@Override
	public MModelItemSearchList getDependentItems() throws PersistenceException {
		// Weder Messages noch Links haben dependentItems
		return new MModelItemSearchList();
	}

	/* Start of protected part that is not overridden by persistence generator */

	/* End of protected part that is not overridden by persistence generator */

}

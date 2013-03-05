package model.messageOrLink;

import model.UserException;
import model.visitor.AnythingExceptionVisitor;
import model.visitor.AnythingReturnExceptionVisitor;
import model.visitor.AnythingReturnVisitor;
import model.visitor.AnythingVisitor;
import model.visitor.MModelItemExceptionVisitor;
import model.visitor.MModelItemReturnExceptionVisitor;
import model.visitor.MModelItemReturnVisitor;
import model.visitor.MModelItemVisitor;
import model.visitor.MessageOrLinkExceptionVisitor;
import model.visitor.MessageOrLinkReturnExceptionVisitor;
import model.visitor.MessageOrLinkReturnVisitor;
import model.visitor.MessageOrLinkVisitor;
import persistence.AbstractPersistentRoot;
import persistence.Anything;
import persistence.ConnectionHandler;
import persistence.LinkProxi;
import persistence.MModelItemSearchList;
import persistence.PersistenceException;
import persistence.PersistentAssociation;
import persistence.PersistentCONCMModelItem;
import persistence.PersistentLink;
import persistence.PersistentMModelItem;
import persistence.PersistentMObject;
import persistence.PersistentMessageOrLink;
import persistence.PersistentProxi;
import persistence.TDObserver;

/* Additional import section end */

public class Link extends model.messageOrLink.MessageOrLink implements PersistentLink {

	public static PersistentLink createLink(final PersistentMObject source, final PersistentMObject target,
			final PersistentAssociation type) throws PersistenceException {
		return createLink(source, target, type, false);
	}

	public static PersistentLink createLink(final PersistentMObject source, final PersistentMObject target,
			final PersistentAssociation type, final boolean delayed$Persistence) throws PersistenceException {
		PersistentLink result = null;
		if (delayed$Persistence) {
			result = ConnectionHandler.getTheConnectionHandler().theLinkFacade.newDelayedLink();
			result.setDelayed$Persistence(true);
		} else {
			result = ConnectionHandler.getTheConnectionHandler().theLinkFacade.newLink(-1);
		}
		final java.util.Hashtable<String, Object> final$$Fields = new java.util.Hashtable<String, Object>();
		final$$Fields.put("source", source);
		final$$Fields.put("target", target);
		final$$Fields.put("type", type);
		result.initialize(result, final$$Fields);
		result.initializeOnCreation();
		return result;
	}

	public static PersistentLink createLink(final PersistentMObject source, final PersistentMObject target,
			final PersistentAssociation type, final boolean delayed$Persistence, final PersistentLink This)
			throws PersistenceException {
		PersistentLink result = null;
		if (delayed$Persistence) {
			result = ConnectionHandler.getTheConnectionHandler().theLinkFacade.newDelayedLink();
			result.setDelayed$Persistence(true);
		} else {
			result = ConnectionHandler.getTheConnectionHandler().theLinkFacade.newLink(-1);
		}
		final java.util.Hashtable<String, Object> final$$Fields = new java.util.Hashtable<String, Object>();
		final$$Fields.put("source", source);
		final$$Fields.put("target", target);
		final$$Fields.put("type", type);
		result.initialize(This, final$$Fields);
		result.initializeOnCreation();
		return result;
	}

	@Override
	public java.util.Hashtable<String, Object> toHashtable(final java.util.Hashtable<String, Object> allResults,
			final int depth, final int essentialLevel, final boolean forGUI, final boolean leaf,
			final TDObserver tdObserver) throws PersistenceException {
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
			final String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
			if (leaf && !allResults.contains(uniqueKey))
				allResults.put(uniqueKey, result);
		}
		return result;
	}

	@Override
	public Link provideCopy() throws PersistenceException {
		Link result = this;
		result = new Link(this.source, this.target, this.This, this.myCONCMModelItem, this.type, this.getId());
		this.copyingPrivateUserAttributes(result);
		return result;
	}

	@Override
	public boolean hasEssentialFields() throws PersistenceException {
		return true;
	}

	protected PersistentAssociation type;

	public Link(final PersistentMObject source, final PersistentMObject target, final PersistentMessageOrLink This,
			final PersistentMModelItem myCONCMModelItem, final PersistentAssociation type, final long id)
			throws persistence.PersistenceException {
		/* Shall not be used by clients for object construction! Use static create operation instead! */
		super(source, target, This, myCONCMModelItem, id);
		this.type = type;
	}

	static public long getTypeId() {
		return 141;
	}

	@Override
	public long getClassId() {
		return getTypeId();
	}

	@Override
	public void store() throws PersistenceException {
		if (!this.isDelayed$Persistence())
			return;
		if (this.getClassId() == 141)
			ConnectionHandler.getTheConnectionHandler().theLinkFacade.newLink(this.getId());
		super.store();
		if (this.getType() != null) {
			this.getType().store();
			ConnectionHandler.getTheConnectionHandler().theLinkFacade.typeSet(this.getId(), getType());
		}

	}

	@Override
	public PersistentAssociation getType() throws PersistenceException {
		return this.type;
	}

	@Override
	public void setType(final PersistentAssociation newValue) throws PersistenceException {
		if (newValue == null)
			throw new PersistenceException("Null values not allowed!", 0);
		if (newValue.equals(this.type))
			return;
		final long objectId = newValue.getId();
		final long classId = newValue.getClassId();
		this.type = (PersistentAssociation) PersistentProxi.createProxi(objectId, classId);
		if (!this.isDelayed$Persistence()) {
			newValue.store();
			ConnectionHandler.getTheConnectionHandler().theLinkFacade.typeSet(this.getId(), newValue);
		}
	}

	@Override
	public PersistentLink getThis() throws PersistenceException {
		if (this.This == null) {
			final PersistentLink result = new LinkProxi(this.getId());
			result.getTheObject();
			return result;
		}
		return (PersistentLink) this.This;
	}

	@Override
	public void accept(final MessageOrLinkVisitor visitor) throws PersistenceException {
		visitor.handleLink(this);
	}

	@Override
	public <R> R accept(final MessageOrLinkReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleLink(this);
	}

	@Override
	public <E extends UserException> void accept(final MessageOrLinkExceptionVisitor<E> visitor)
			throws PersistenceException, E {
		visitor.handleLink(this);
	}

	@Override
	public <R, E extends UserException> R accept(final MessageOrLinkReturnExceptionVisitor<R, E> visitor)
			throws PersistenceException, E {
		return visitor.handleLink(this);
	}

	@Override
	public void accept(final MModelItemVisitor visitor) throws PersistenceException {
		visitor.handleLink(this);
	}

	@Override
	public <R> R accept(final MModelItemReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleLink(this);
	}

	@Override
	public <E extends UserException> void accept(final MModelItemExceptionVisitor<E> visitor)
			throws PersistenceException, E {
		visitor.handleLink(this);
	}

	@Override
	public <R, E extends UserException> R accept(final MModelItemReturnExceptionVisitor<R, E> visitor)
			throws PersistenceException, E {
		return visitor.handleLink(this);
	}

	@Override
	public void accept(final AnythingVisitor visitor) throws PersistenceException {
		visitor.handleLink(this);
	}

	@Override
	public <R> R accept(final AnythingReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleLink(this);
	}

	@Override
	public <E extends UserException> void accept(final AnythingExceptionVisitor<E> visitor)
			throws PersistenceException, E {
		visitor.handleLink(this);
	}

	@Override
	public <R, E extends UserException> R accept(final AnythingReturnExceptionVisitor<R, E> visitor)
			throws PersistenceException, E {
		return visitor.handleLink(this);
	}

	@Override
	public int getLeafInfo() throws PersistenceException {
		if (this.getSource() != null)
			return 1;
		if (this.getTarget() != null)
			return 1;
		if (this.getType() != null)
			return 1;
		if (this.getDependentItems().getLength() > 0)
			return 1;
		return 0;
	}

	@Override
	public void initialize(final Anything This, final java.util.Hashtable<String, Object> final$$Fields)
			throws PersistenceException {
		this.setThis((PersistentLink) This);
		if (this.equals(This)) {
			final PersistentCONCMModelItem myCONCMModelItem = model.CONCMModelItem.createCONCMModelItem(
					this.isDelayed$Persistence(), (PersistentLink) This);
			this.setMyCONCMModelItem(myCONCMModelItem);
			this.setSource((PersistentMObject) final$$Fields.get("source"));
			this.setTarget((PersistentMObject) final$$Fields.get("target"));
			this.setType((PersistentAssociation) final$$Fields.get("type"));
		}
	}

	// Start of section that contains operations that must be implemented.

	@Override
	public void copyingPrivateUserAttributes(final Anything copy) throws PersistenceException {
	}

	@Override
	public MModelItemSearchList getDependentItems(final TDObserver observer) throws PersistenceException {
		final MModelItemSearchList result = getThis().getDependentItems();
		observer.updateTransientDerived(getThis(), "dependentItems", result);
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
		// TODO: Christin implement method: prepareForDeletion

	}

	// Start of section that contains overridden operations only.

	/* Start of protected part that is not overridden by persistence generator */

	/* End of protected part that is not overridden by persistence generator */

}

package model.abstractOperation;

import model.UserException;
import model.visitor.AbsOperationExceptionVisitor;
import model.visitor.AbsOperationReturnExceptionVisitor;
import model.visitor.AbsOperationReturnVisitor;
import model.visitor.AbsOperationVisitor;
import model.visitor.AnythingExceptionVisitor;
import model.visitor.AnythingReturnExceptionVisitor;
import model.visitor.AnythingReturnVisitor;
import model.visitor.AnythingVisitor;
import model.visitor.MModelItemExceptionVisitor;
import model.visitor.MModelItemReturnExceptionVisitor;
import model.visitor.MModelItemReturnVisitor;
import model.visitor.MModelItemVisitor;
import persistence.Anything;
import persistence.AssociationProxi;
import persistence.Association_HierarchiesProxi;
import persistence.ConnectionHandler;
import persistence.LinkSearchList;
import persistence.MModelItemSearchList;
import persistence.PersistenceException;
import persistence.PersistentAbsOperation;
import persistence.PersistentAssociation;
import persistence.PersistentCONCMModelItem;
import persistence.PersistentMModelItem;
import persistence.PersistentMType;
import persistence.TDObserver;
import utils.SearchLists;

/* Additional import section end */

public class Association extends model.abstractOperation.AbsOperation implements PersistentAssociation {

	public static PersistentAssociation createAssociation(final String name, final PersistentMType source, final PersistentMType target)
			throws PersistenceException {
		return createAssociation(name, source, target, false);
	}

	public static PersistentAssociation createAssociation(final String name, final PersistentMType source, final PersistentMType target,
			final boolean delayed$Persistence) throws PersistenceException {
		PersistentAssociation result = null;
		if (delayed$Persistence) {
			result = ConnectionHandler.getTheConnectionHandler().theAssociationFacade.newDelayedAssociation(name);
			result.setDelayed$Persistence(true);
		} else {
			result = ConnectionHandler.getTheConnectionHandler().theAssociationFacade.newAssociation(name, -1);
		}
		final java.util.Hashtable<String, Object> final$$Fields = new java.util.Hashtable<String, Object>();
		final$$Fields.put("name", name);
		final$$Fields.put("source", source);
		final$$Fields.put("target", target);
		result.initialize(result, final$$Fields);
		result.initializeOnCreation();
		return result;
	}

	public static PersistentAssociation createAssociation(final String name, final PersistentMType source, final PersistentMType target,
			final boolean delayed$Persistence, final PersistentAssociation This) throws PersistenceException {
		PersistentAssociation result = null;
		if (delayed$Persistence) {
			result = ConnectionHandler.getTheConnectionHandler().theAssociationFacade.newDelayedAssociation(name);
			result.setDelayed$Persistence(true);
		} else {
			result = ConnectionHandler.getTheConnectionHandler().theAssociationFacade.newAssociation(name, -1);
		}
		final java.util.Hashtable<String, Object> final$$Fields = new java.util.Hashtable<String, Object>();
		final$$Fields.put("name", name);
		final$$Fields.put("source", source);
		final$$Fields.put("target", target);
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
			result.put("hierarchies",
					this.getHierarchies().getVector(allResults, depth, essentialLevel, forGUI, tdObserver, false, essentialLevel == 0));
			final String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
			if (leaf && !allResults.contains(uniqueKey))
				allResults.put(uniqueKey, result);
		}
		return result;
	}

	@Override
	public Association provideCopy() throws PersistenceException {
		Association result = this;
		result = new Association(this.name, this.source, this.target, this.This, this.myCONCMModelItem, this.getId());
		result.parameters = this.parameters.copy(result);
		result.hierarchies = this.hierarchies.copy(result);
		this.copyingPrivateUserAttributes(result);
		return result;
	}

	@Override
	public boolean hasEssentialFields() throws PersistenceException {
		return true;
	}

	protected Association_HierarchiesProxi hierarchies;

	public Association(final String name, final PersistentMType source, final PersistentMType target, final PersistentAbsOperation This,
			final PersistentMModelItem myCONCMModelItem, final long id) throws persistence.PersistenceException {
		/* Shall not be used by clients for object construction! Use static create operation instead! */
		super(name, source, target, This, myCONCMModelItem, id);
		this.hierarchies = new Association_HierarchiesProxi(this);
	}

	static public long getTypeId() {
		return 117;
	}

	@Override
	public long getClassId() {
		return getTypeId();
	}

	@Override
	public void store() throws PersistenceException {
		if (!this.isDelayed$Persistence())
			return;
		if (this.getClassId() == 117)
			ConnectionHandler.getTheConnectionHandler().theAssociationFacade.newAssociation(name, this.getId());
		super.store();
		this.getHierarchies().store();

	}

	@Override
	public Association_HierarchiesProxi getHierarchies() throws PersistenceException {
		return this.hierarchies;
	}

	@Override
	public PersistentAssociation getThis() throws PersistenceException {
		if (this.This == null) {
			final PersistentAssociation result = new AssociationProxi(this.getId());
			result.getTheObject();
			return result;
		}
		return (PersistentAssociation) this.This;
	}

	@Override
	public void accept(final AbsOperationVisitor visitor) throws PersistenceException {
		visitor.handleAssociation(this);
	}

	@Override
	public <R> R accept(final AbsOperationReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleAssociation(this);
	}

	@Override
	public <E extends UserException> void accept(final AbsOperationExceptionVisitor<E> visitor) throws PersistenceException, E {
		visitor.handleAssociation(this);
	}

	@Override
	public <R, E extends UserException> R accept(final AbsOperationReturnExceptionVisitor<R, E> visitor) throws PersistenceException, E {
		return visitor.handleAssociation(this);
	}

	@Override
	public void accept(final MModelItemVisitor visitor) throws PersistenceException {
		visitor.handleAssociation(this);
	}

	@Override
	public <R> R accept(final MModelItemReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleAssociation(this);
	}

	@Override
	public <E extends UserException> void accept(final MModelItemExceptionVisitor<E> visitor) throws PersistenceException, E {
		visitor.handleAssociation(this);
	}

	@Override
	public <R, E extends UserException> R accept(final MModelItemReturnExceptionVisitor<R, E> visitor) throws PersistenceException, E {
		return visitor.handleAssociation(this);
	}

	@Override
	public void accept(final AnythingVisitor visitor) throws PersistenceException {
		visitor.handleAssociation(this);
	}

	@Override
	public <R> R accept(final AnythingReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleAssociation(this);
	}

	@Override
	public <E extends UserException> void accept(final AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
		visitor.handleAssociation(this);
	}

	@Override
	public <R, E extends UserException> R accept(final AnythingReturnExceptionVisitor<R, E> visitor) throws PersistenceException, E {
		return visitor.handleAssociation(this);
	}

	@Override
	public int getLeafInfo() throws PersistenceException {
		if (this.getSource() != null)
			return 1;
		if (this.getTarget() != null)
			return 1;
		if (this.getParameters().getLength() > 0)
			return 1;
		if (this.getHierarchies().getLength() > 0)
			return 1;
		return 0;
	}

	@Override
	public void initialize(final Anything This, final java.util.Hashtable<String, Object> final$$Fields) throws PersistenceException {
		this.setThis((PersistentAssociation) This);
		if (this.equals(This)) {
			final PersistentCONCMModelItem myCONCMModelItem = model.CONCMModelItem.createCONCMModelItem(this.isDelayed$Persistence(),
					(PersistentAssociation) This);
			this.setMyCONCMModelItem(myCONCMModelItem);
			this.setName((String) final$$Fields.get("name"));
			this.setSource((PersistentMType) final$$Fields.get("source"));
			this.setTarget((PersistentMType) final$$Fields.get("target"));
		}
	}

	// Start of section that contains operations that must be implemented.

	@Override
	public LinkSearchList inverseGetType() throws PersistenceException {
		LinkSearchList result = null;
		if (result == null)
			result = ConnectionHandler.getTheConnectionHandler().theLinkFacade.inverseGetType(this.getId(), this.getClassId());
		return result;
	}

	@Override
	public void copyingPrivateUserAttributes(final Anything copy) throws PersistenceException {
	}

	@Override
	public MModelItemSearchList fetchDependentItems() throws PersistenceException {
		final MModelItemSearchList result = new MModelItemSearchList();
		SearchLists.addSecondToFirst(result, getThis().getHierarchies());
		SearchLists.addSecondToFirst(result, getThis().inverseGetType());
		return result;
	}

	@Override
	public void initializeOnCreation() throws PersistenceException {
	}

	@Override
	public void initializeOnInstantiation() throws PersistenceException {
	}
	// Start of section that contains overridden operations only.

	/* Start of protected part that is not overridden by persistence generator */

	/* End of protected part that is not overridden by persistence generator */

}

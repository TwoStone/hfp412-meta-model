package model.naming;

import model.UserException;
import model.visitor.AnythingExceptionVisitor;
import model.visitor.AnythingReturnExceptionVisitor;
import model.visitor.AnythingReturnVisitor;
import model.visitor.AnythingVisitor;
import model.visitor.MModelItemExceptionVisitor;
import model.visitor.MModelItemReturnExceptionVisitor;
import model.visitor.MModelItemReturnVisitor;
import model.visitor.MModelItemVisitor;
import persistence.*;
import utils.SearchLists;

/* Additional import section end */

public class Name extends PersistentObject implements PersistentName {

	/** Throws persistence exception if the object with the given id does not exist. */
	public static PersistentName getById(final long objectId) throws PersistenceException {
		final long classId = ConnectionHandler.getTheConnectionHandler().theNameFacade.getClass(objectId);
		return (PersistentName) PersistentProxi.createProxi(objectId, classId);
	}

	public static PersistentName createName(final PersistentMAtomicType fromType, final PersistentNameScheme nameScheme) throws PersistenceException {
		return createName(fromType, nameScheme, false);
	}

	public static PersistentName createName(final PersistentMAtomicType fromType, final PersistentNameScheme nameScheme,
			final boolean delayed$Persistence) throws PersistenceException {
		PersistentName result = null;
		if (delayed$Persistence) {
			result = ConnectionHandler.getTheConnectionHandler().theNameFacade.newDelayedName();
			result.setDelayed$Persistence(true);
		} else {
			result = ConnectionHandler.getTheConnectionHandler().theNameFacade.newName(-1);
		}
		final java.util.Hashtable<String, Object> final$$Fields = new java.util.Hashtable<String, Object>();
		final$$Fields.put("fromType", fromType);
		final$$Fields.put("nameScheme", nameScheme);
		result.initialize(result, final$$Fields);
		result.initializeOnCreation();
		return result;
	}

	public static PersistentName createName(final PersistentMAtomicType fromType, final PersistentNameScheme nameScheme,
			final boolean delayed$Persistence, final PersistentName This) throws PersistenceException {
		PersistentName result = null;
		if (delayed$Persistence) {
			result = ConnectionHandler.getTheConnectionHandler().theNameFacade.newDelayedName();
			result.setDelayed$Persistence(true);
		} else {
			result = ConnectionHandler.getTheConnectionHandler().theNameFacade.newName(-1);
		}
		final java.util.Hashtable<String, Object> final$$Fields = new java.util.Hashtable<String, Object>();
		final$$Fields.put("fromType", fromType);
		final$$Fields.put("nameScheme", nameScheme);
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
			final AbstractPersistentRoot fromType = this.getFromType();
			if (fromType != null) {
				result.put("fromType", fromType.createProxiInformation(false, essentialLevel == 0));
				if (depth > 1) {
					fromType.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true, tdObserver);
				} else {
					if (forGUI && fromType.hasEssentialFields())
						fromType.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
				}
			}
			final AbstractPersistentRoot nameScheme = this.getNameScheme();
			if (nameScheme != null) {
				result.put("nameScheme", nameScheme.createProxiInformation(false, essentialLevel == 0));
				if (depth > 1) {
					nameScheme.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true, tdObserver);
				} else {
					if (forGUI && nameScheme.hasEssentialFields())
						nameScheme.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
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
	public Name provideCopy() throws PersistenceException {
		Name result = this;
		result = new Name(this.fromType, this.nameScheme, this.This, this.myCONCMModelItem, this.getId());
		this.copyingPrivateUserAttributes(result);
		return result;
	}

	@Override
	public boolean hasEssentialFields() throws PersistenceException {
		return true;
	}

	protected PersistentMAtomicType fromType;
	protected PersistentNameScheme nameScheme;
	protected PersistentName This;
	protected PersistentMModelItem myCONCMModelItem;

	public Name(final PersistentMAtomicType fromType, final PersistentNameScheme nameScheme, final PersistentName This,
			final PersistentMModelItem myCONCMModelItem, final long id) throws persistence.PersistenceException {
		/* Shall not be used by clients for object construction! Use static create operation instead! */
		super(id);
		this.fromType = fromType;
		this.nameScheme = nameScheme;
		if (This != null && !(this.equals(This)))
			this.This = This;
		this.myCONCMModelItem = myCONCMModelItem;
	}

	static public long getTypeId() {
		return 258;
	}

	@Override
	public long getClassId() {
		return getTypeId();
	}

	@Override
	public void store() throws PersistenceException {
		if (!this.isDelayed$Persistence())
			return;
		if (this.getClassId() == 258)
			ConnectionHandler.getTheConnectionHandler().theNameFacade.newName(this.getId());
		super.store();
		if (this.getFromType() != null) {
			this.getFromType().store();
			ConnectionHandler.getTheConnectionHandler().theNameFacade.fromTypeSet(this.getId(), getFromType());
		}
		if (this.getNameScheme() != null) {
			this.getNameScheme().store();
			ConnectionHandler.getTheConnectionHandler().theNameFacade.nameSchemeSet(this.getId(), getNameScheme());
		}
		if (!this.equals(this.getThis())) {
			this.getThis().store();
			ConnectionHandler.getTheConnectionHandler().theNameFacade.ThisSet(this.getId(), getThis());
		}
		if (this.getMyCONCMModelItem() != null) {
			this.getMyCONCMModelItem().store();
			ConnectionHandler.getTheConnectionHandler().theNameFacade.myCONCMModelItemSet(this.getId(), getMyCONCMModelItem());
		}

	}

	@Override
	public PersistentMAtomicType getFromType() throws PersistenceException {
		return this.fromType;
	}

	@Override
	public void setFromType(final PersistentMAtomicType newValue) throws PersistenceException {
		if (newValue == null)
			throw new PersistenceException("Null values not allowed!", 0);
		if (newValue.equals(this.fromType))
			return;
		final long objectId = newValue.getId();
		final long classId = newValue.getClassId();
		this.fromType = (PersistentMAtomicType) PersistentProxi.createProxi(objectId, classId);
		if (!this.isDelayed$Persistence()) {
			newValue.store();
			ConnectionHandler.getTheConnectionHandler().theNameFacade.fromTypeSet(this.getId(), newValue);
		}
	}

	@Override
	public PersistentNameScheme getNameScheme() throws PersistenceException {
		return this.nameScheme;
	}

	@Override
	public void setNameScheme(final PersistentNameScheme newValue) throws PersistenceException {
		if (newValue == null)
			throw new PersistenceException("Null values not allowed!", 0);
		if (newValue.equals(this.nameScheme))
			return;
		final long objectId = newValue.getId();
		final long classId = newValue.getClassId();
		this.nameScheme = (PersistentNameScheme) PersistentProxi.createProxi(objectId, classId);
		if (!this.isDelayed$Persistence()) {
			newValue.store();
			ConnectionHandler.getTheConnectionHandler().theNameFacade.nameSchemeSet(this.getId(), newValue);
		}
	}

	protected void setThis(final PersistentName newValue) throws PersistenceException {
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
		this.This = (PersistentName) PersistentProxi.createProxi(objectId, classId);
		if (!this.isDelayed$Persistence()) {
			newValue.store();
			ConnectionHandler.getTheConnectionHandler().theNameFacade.ThisSet(this.getId(), newValue);
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
			ConnectionHandler.getTheConnectionHandler().theNameFacade.myCONCMModelItemSet(this.getId(), newValue);
		}
	}

	@Override
	public PersistentName getThis() throws PersistenceException {
		if (this.This == null) {
			final PersistentName result = new NameProxi(this.getId());
			result.getTheObject();
			return result;
		}
		return this.This;
	}

	@Override
	public void delete$Me() throws PersistenceException {
		super.delete$Me();
		this.getMyCONCMModelItem().delete$Me();
	}

	@Override
	public void accept(final MModelItemVisitor visitor) throws PersistenceException {
		visitor.handleName(this);
	}

	@Override
	public <R> R accept(final MModelItemReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleName(this);
	}

	@Override
	public <E extends UserException> void accept(final MModelItemExceptionVisitor<E> visitor) throws PersistenceException, E {
		visitor.handleName(this);
	}

	@Override
	public <R, E extends UserException> R accept(final MModelItemReturnExceptionVisitor<R, E> visitor) throws PersistenceException, E {
		return visitor.handleName(this);
	}

	@Override
	public void accept(final AnythingVisitor visitor) throws PersistenceException {
		visitor.handleName(this);
	}

	@Override
	public <R> R accept(final AnythingReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleName(this);
	}

	@Override
	public <E extends UserException> void accept(final AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
		visitor.handleName(this);
	}

	@Override
	public <R, E extends UserException> R accept(final AnythingReturnExceptionVisitor<R, E> visitor) throws PersistenceException, E {
		return visitor.handleName(this);
	}

	@Override
	public int getLeafInfo() throws PersistenceException {
		if (this.getFromType() != null)
			return 1;
		if (this.getNameScheme() != null)
			return 1;
		return 0;
	}

	@Override
	public void initialize(final Anything This, final java.util.Hashtable<String, Object> final$$Fields) throws PersistenceException {
		this.setThis((PersistentName) This);
		if (this.equals(This)) {
			final PersistentCONCMModelItem myCONCMModelItem = model.CONCMModelItem.createCONCMModelItem(this.isDelayed$Persistence(),
					(PersistentName) This);
			this.setMyCONCMModelItem(myCONCMModelItem);
			this.setFromType((PersistentMAtomicType) final$$Fields.get("fromType"));
			this.setNameScheme((PersistentNameScheme) final$$Fields.get("nameScheme"));
		}
	}

	// Start of section that contains operations that must be implemented.

	@Override
	public NameInstanceSearchList inverseGetType() throws PersistenceException {
		NameInstanceSearchList result = null;
		if (result == null)
			result = ConnectionHandler.getTheConnectionHandler().theNameInstanceFacade.inverseGetType(this.getId(), this.getClassId());
		return result;
	}

	@Override
	public void copyingPrivateUserAttributes(final Anything copy) throws PersistenceException {
	}

	@Override
	public void delete() throws model.ConsistencyException, PersistenceException {
		// TODO Check delegation to abstract class and overwrite if necessary!
		this.getMyCONCMModelItem().delete();
	}

	@Override
	public MModelItemSearchList fetchDependentItems() throws PersistenceException {
		final MModelItemSearchList result = new MModelItemSearchList();
		SearchLists.addSecondToFirst(result, getThis().inverseGetType());
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
	}

	// Start of section that contains overridden operations only.

	/* Start of protected part that is not overridden by persistence generator */

	/* End of protected part that is not overridden by persistence generator */

}

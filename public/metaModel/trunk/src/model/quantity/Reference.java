package model.quantity;

import model.UserException;
import model.visitor.AnythingExceptionVisitor;
import model.visitor.AnythingReturnExceptionVisitor;
import model.visitor.AnythingReturnVisitor;
import model.visitor.AnythingVisitor;
import model.visitor.MModelItemExceptionVisitor;
import model.visitor.MModelItemReturnExceptionVisitor;
import model.visitor.MModelItemReturnVisitor;
import model.visitor.MModelItemVisitor;
import persistence.AbstractPersistentRoot;
import persistence.Anything;
import persistence.CompUnitSearchList;
import persistence.ConnectionHandler;
import persistence.MModelItemSearchList;
import persistence.PersistenceException;
import persistence.PersistentCONCMModelItem;
import persistence.PersistentMModelItem;
import persistence.PersistentObject;
import persistence.PersistentProxi;
import persistence.PersistentReference;
import persistence.PersistentUnit;
import persistence.ReferenceProxi;
import persistence.TDObserver;

/* Additional import section end */

public class Reference extends PersistentObject implements PersistentReference {

	/** Throws persistence exception if the object with the given id does not exist. */
	public static PersistentReference getById(final long objectId) throws PersistenceException {
		final long classId = ConnectionHandler.getTheConnectionHandler().theReferenceFacade.getClass(objectId);
		return (PersistentReference) PersistentProxi.createProxi(objectId, classId);
	}

	public static PersistentReference createReference(final long exponent, final PersistentUnit ref) throws PersistenceException {
		return createReference(exponent, ref, false);
	}

	public static PersistentReference createReference(final long exponent, final PersistentUnit ref, final boolean delayed$Persistence)
			throws PersistenceException {
		PersistentReference result = null;
		if (delayed$Persistence) {
			result = ConnectionHandler.getTheConnectionHandler().theReferenceFacade.newDelayedReference(exponent);
			result.setDelayed$Persistence(true);
		} else {
			result = ConnectionHandler.getTheConnectionHandler().theReferenceFacade.newReference(exponent, -1);
		}
		final java.util.Hashtable<String, Object> final$$Fields = new java.util.Hashtable<String, Object>();
		final$$Fields.put("exponent", exponent);
		final$$Fields.put("ref", ref);
		result.initialize(result, final$$Fields);
		result.initializeOnCreation();
		return result;
	}

	public static PersistentReference createReference(final long exponent, final PersistentUnit ref, final boolean delayed$Persistence,
			final PersistentReference This) throws PersistenceException {
		PersistentReference result = null;
		if (delayed$Persistence) {
			result = ConnectionHandler.getTheConnectionHandler().theReferenceFacade.newDelayedReference(exponent);
			result.setDelayed$Persistence(true);
		} else {
			result = ConnectionHandler.getTheConnectionHandler().theReferenceFacade.newReference(exponent, -1);
		}
		final java.util.Hashtable<String, Object> final$$Fields = new java.util.Hashtable<String, Object>();
		final$$Fields.put("exponent", exponent);
		final$$Fields.put("ref", ref);
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
			result.put("exponent", new Long(this.getExponent()).toString());
			final AbstractPersistentRoot ref = this.getRef();
			if (ref != null) {
				result.put("ref", ref.createProxiInformation(false, essentialLevel == 0));
				if (depth > 1) {
					ref.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true, tdObserver);
				} else {
					if (forGUI && ref.hasEssentialFields())
						ref.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
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
	public Reference provideCopy() throws PersistenceException {
		Reference result = this;
		result = new Reference(this.exponent, this.ref, this.This, this.myCONCMModelItem, this.getId());
		this.copyingPrivateUserAttributes(result);
		return result;
	}

	@Override
	public boolean hasEssentialFields() throws PersistenceException {
		return true;
	}

	protected long exponent;
	protected PersistentUnit ref;
	protected PersistentReference This;
	protected PersistentMModelItem myCONCMModelItem;

	public Reference(final long exponent, final PersistentUnit ref, final PersistentReference This, final PersistentMModelItem myCONCMModelItem,
			final long id) throws persistence.PersistenceException {
		/* Shall not be used by clients for object construction! Use static create operation instead! */
		super(id);
		this.exponent = exponent;
		this.ref = ref;
		if (This != null && !(this.equals(This)))
			this.This = This;
		this.myCONCMModelItem = myCONCMModelItem;
	}

	static public long getTypeId() {
		return 180;
	}

	@Override
	public long getClassId() {
		return getTypeId();
	}

	@Override
	public void store() throws PersistenceException {
		if (!this.isDelayed$Persistence())
			return;
		if (this.getClassId() == 180)
			ConnectionHandler.getTheConnectionHandler().theReferenceFacade.newReference(exponent, this.getId());
		super.store();
		if (this.getRef() != null) {
			this.getRef().store();
			ConnectionHandler.getTheConnectionHandler().theReferenceFacade.refSet(this.getId(), getRef());
		}
		if (!this.equals(this.getThis())) {
			this.getThis().store();
			ConnectionHandler.getTheConnectionHandler().theReferenceFacade.ThisSet(this.getId(), getThis());
		}
		if (this.getMyCONCMModelItem() != null) {
			this.getMyCONCMModelItem().store();
			ConnectionHandler.getTheConnectionHandler().theReferenceFacade.myCONCMModelItemSet(this.getId(), getMyCONCMModelItem());
		}

	}

	@Override
	public long getExponent() throws PersistenceException {
		return this.exponent;
	}

	@Override
	public void setExponent(final long newValue) throws PersistenceException {
		if (!this.isDelayed$Persistence())
			ConnectionHandler.getTheConnectionHandler().theReferenceFacade.exponentSet(this.getId(), newValue);
		this.exponent = newValue;
	}

	@Override
	public PersistentUnit getRef() throws PersistenceException {
		return this.ref;
	}

	@Override
	public void setRef(final PersistentUnit newValue) throws PersistenceException {
		if (newValue == null)
			throw new PersistenceException("Null values not allowed!", 0);
		if (newValue.equals(this.ref))
			return;
		final long objectId = newValue.getId();
		final long classId = newValue.getClassId();
		this.ref = (PersistentUnit) PersistentProxi.createProxi(objectId, classId);
		if (!this.isDelayed$Persistence()) {
			newValue.store();
			ConnectionHandler.getTheConnectionHandler().theReferenceFacade.refSet(this.getId(), newValue);
		}
	}

	protected void setThis(final PersistentReference newValue) throws PersistenceException {
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
		this.This = (PersistentReference) PersistentProxi.createProxi(objectId, classId);
		if (!this.isDelayed$Persistence()) {
			newValue.store();
			ConnectionHandler.getTheConnectionHandler().theReferenceFacade.ThisSet(this.getId(), newValue);
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
			ConnectionHandler.getTheConnectionHandler().theReferenceFacade.myCONCMModelItemSet(this.getId(), newValue);
		}
	}

	@Override
	public PersistentReference getThis() throws PersistenceException {
		if (this.This == null) {
			final PersistentReference result = new ReferenceProxi(this.getId());
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
		visitor.handleReference(this);
	}

	@Override
	public <R> R accept(final MModelItemReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleReference(this);
	}

	@Override
	public <E extends UserException> void accept(final MModelItemExceptionVisitor<E> visitor) throws PersistenceException, E {
		visitor.handleReference(this);
	}

	@Override
	public <R, E extends UserException> R accept(final MModelItemReturnExceptionVisitor<R, E> visitor) throws PersistenceException, E {
		return visitor.handleReference(this);
	}

	@Override
	public void accept(final AnythingVisitor visitor) throws PersistenceException {
		visitor.handleReference(this);
	}

	@Override
	public <R> R accept(final AnythingReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleReference(this);
	}

	@Override
	public <E extends UserException> void accept(final AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
		visitor.handleReference(this);
	}

	@Override
	public <R, E extends UserException> R accept(final AnythingReturnExceptionVisitor<R, E> visitor) throws PersistenceException, E {
		return visitor.handleReference(this);
	}

	@Override
	public int getLeafInfo() throws PersistenceException {
		return 0;
	}

	@Override
	public void initialize(final Anything This, final java.util.Hashtable<String, Object> final$$Fields) throws PersistenceException {
		this.setThis((PersistentReference) This);
		if (this.equals(This)) {
			final PersistentCONCMModelItem myCONCMModelItem = model.CONCMModelItem.createCONCMModelItem(this.isDelayed$Persistence(),
					(PersistentReference) This);
			this.setMyCONCMModelItem(myCONCMModelItem);
			this.setExponent((Long) final$$Fields.get("exponent"));
			this.setRef((PersistentUnit) final$$Fields.get("ref"));
		}
	}

	// Start of section that contains operations that must be implemented.

	@Override
	public CompUnitSearchList inverseGetRefs() throws PersistenceException {
		CompUnitSearchList result = null;
		if (result == null)
			result = ConnectionHandler.getTheConnectionHandler().theCompUnitFacade.inverseGetRefs(this.getId(), this.getClassId());
		return result;
	}

	@Override
	public void copyingPrivateUserAttributes(final Anything copy) throws PersistenceException {
		// TODO: implement method: copyingPrivateUserAttributes

	}

	@Override
	public void delete() throws model.ConsistencyException, PersistenceException {
		// TODO Check delegation to abstract class and overwrite if necessary!
		this.getMyCONCMModelItem().delete();
	}

	@Override
	public MModelItemSearchList fetchDependentItems() throws PersistenceException {
		// TODO: implement method: fetchDependentItems
		try {
			throw new java.lang.UnsupportedOperationException("Method \"fetchDependentItems\" not implemented yet.");
		} catch (final java.lang.UnsupportedOperationException uoe) {
			uoe.printStackTrace();
			throw uoe;
		}
	}

	@Override
	public void initializeOnCreation() throws PersistenceException {
		// TODO: implement method: initializeOnCreation

	}

	@Override
	public void initializeOnInstantiation() throws PersistenceException {
		// TODO: implement method: initializeOnInstantiation

	}

	@Override
	public void prepareForDeletion() throws model.ConsistencyException, PersistenceException {
		// TODO: implement method: prepareForDeletion

	}

	// Start of section that contains overridden operations only.

	/* Start of protected part that is not overridden by persistence generator */

	/* End of protected part that is not overridden by persistence generator */

}

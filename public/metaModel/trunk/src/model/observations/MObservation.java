package model.observations;

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
import persistence.ConnectionHandler;
import persistence.MModelItemSearchList;
import persistence.MObservationProxi;
import persistence.MObservationSearchList;
import persistence.PersistenceException;
import persistence.PersistentCONCMModelItem;
import persistence.PersistentMEnumValue;
import persistence.PersistentMModelItem;
import persistence.PersistentMObject;
import persistence.PersistentMObservation;
import persistence.PersistentMObservationType;
import persistence.PersistentObject;
import persistence.PersistentProxi;
import persistence.TDObserver;

/* Additional import section end */

public class MObservation extends PersistentObject implements PersistentMObservation {

	/** Throws persistence exception if the object with the given id does not exist. */
	public static PersistentMObservation getById(final long objectId) throws PersistenceException {
		final long classId = ConnectionHandler.getTheConnectionHandler().theMObservationFacade.getClass(objectId);
		return (PersistentMObservation) PersistentProxi.createProxi(objectId, classId);
	}

	public static PersistentMObservation createMObservation(final String name,
			final PersistentMObservationType theType, final PersistentMEnumValue enumValue,
			final PersistentMObject theObsObject) throws PersistenceException {
		return createMObservation(name, theType, enumValue, theObsObject, false);
	}

	public static PersistentMObservation createMObservation(final String name,
			final PersistentMObservationType theType, final PersistentMEnumValue enumValue,
			final PersistentMObject theObsObject, final boolean delayed$Persistence) throws PersistenceException {
		if (name == null)
			throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
		PersistentMObservation result = null;
		if (delayed$Persistence) {
			result = ConnectionHandler.getTheConnectionHandler().theMObservationFacade.newDelayedMObservation(name);
			result.setDelayed$Persistence(true);
		} else {
			result = ConnectionHandler.getTheConnectionHandler().theMObservationFacade.newMObservation(name, -1);
		}
		final java.util.Hashtable<String, Object> final$$Fields = new java.util.Hashtable<String, Object>();
		final$$Fields.put("name", name);
		final$$Fields.put("theType", theType);
		final$$Fields.put("enumValue", enumValue);
		final$$Fields.put("theObsObject", theObsObject);
		result.initialize(result, final$$Fields);
		result.initializeOnCreation();
		return result;
	}

	public static PersistentMObservation createMObservation(final String name,
			final PersistentMObservationType theType, final PersistentMEnumValue enumValue,
			final PersistentMObject theObsObject, final boolean delayed$Persistence, final PersistentMObservation This)
			throws PersistenceException {
		if (name == null)
			throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
		PersistentMObservation result = null;
		if (delayed$Persistence) {
			result = ConnectionHandler.getTheConnectionHandler().theMObservationFacade.newDelayedMObservation(name);
			result.setDelayed$Persistence(true);
		} else {
			result = ConnectionHandler.getTheConnectionHandler().theMObservationFacade.newMObservation(name, -1);
		}
		final java.util.Hashtable<String, Object> final$$Fields = new java.util.Hashtable<String, Object>();
		final$$Fields.put("name", name);
		final$$Fields.put("theType", theType);
		final$$Fields.put("enumValue", enumValue);
		final$$Fields.put("theObsObject", theObsObject);
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
			result.put("name", this.getName());
			final AbstractPersistentRoot theType = this.getTheType();
			if (theType != null) {
				result.put("theType", theType.createProxiInformation(false, essentialLevel == 0));
				if (depth > 1) {
					theType.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true, tdObserver);
				} else {
					if (forGUI && theType.hasEssentialFields())
						theType.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
				}
			}
			final AbstractPersistentRoot enumValue = this.getEnumValue();
			if (enumValue != null) {
				result.put("enumValue", enumValue.createProxiInformation(false, essentialLevel == 0));
				if (depth > 1) {
					enumValue.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true, tdObserver);
				} else {
					if (forGUI && enumValue.hasEssentialFields())
						enumValue.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
				}
			}
			final AbstractPersistentRoot theObsObject = this.getTheObsObject();
			if (theObsObject != null) {
				result.put("theObsObject", theObsObject.createProxiInformation(false, essentialLevel == 0));
				if (depth > 1) {
					theObsObject.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true, tdObserver);
				} else {
					if (forGUI && theObsObject.hasEssentialFields())
						theObsObject.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
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

	public static MObservationSearchList getMObservationByName(final String name) throws PersistenceException {
		return ConnectionHandler.getTheConnectionHandler().theMObservationFacade.getMObservationByName(name);
	}

	@Override
	public MObservation provideCopy() throws PersistenceException {
		MObservation result = this;
		result = new MObservation(this.name, this.theType, this.enumValue, this.theObsObject, this.This,
				this.myCONCMModelItem, this.getId());
		this.copyingPrivateUserAttributes(result);
		return result;
	}

	@Override
	public boolean hasEssentialFields() throws PersistenceException {
		return true;
	}

	protected String name;
	protected PersistentMObservationType theType;
	protected PersistentMEnumValue enumValue;
	protected PersistentMObject theObsObject;
	protected PersistentMObservation This;
	protected PersistentMModelItem myCONCMModelItem;

	public MObservation(final String name, final PersistentMObservationType theType,
			final PersistentMEnumValue enumValue, final PersistentMObject theObsObject,
			final PersistentMObservation This, final PersistentMModelItem myCONCMModelItem, final long id)
			throws persistence.PersistenceException {
		/* Shall not be used by clients for object construction! Use static create operation instead! */
		super(id);
		this.name = name;
		this.theType = theType;
		this.enumValue = enumValue;
		this.theObsObject = theObsObject;
		if (This != null && !(this.equals(This)))
			this.This = This;
		this.myCONCMModelItem = myCONCMModelItem;
	}

	static public long getTypeId() {
		return 345;
	}

	@Override
	public long getClassId() {
		return getTypeId();
	}

	@Override
	public void store() throws PersistenceException {
		if (!this.isDelayed$Persistence())
			return;
		if (this.getClassId() == 345)
			ConnectionHandler.getTheConnectionHandler().theMObservationFacade.newMObservation(name, this.getId());
		super.store();
		if (this.getTheType() != null) {
			this.getTheType().store();
			ConnectionHandler.getTheConnectionHandler().theMObservationFacade.theTypeSet(this.getId(), getTheType());
		}
		if (this.getEnumValue() != null) {
			this.getEnumValue().store();
			ConnectionHandler.getTheConnectionHandler().theMObservationFacade
					.enumValueSet(this.getId(), getEnumValue());
		}
		if (this.getTheObsObject() != null) {
			this.getTheObsObject().store();
			ConnectionHandler.getTheConnectionHandler().theMObservationFacade.theObsObjectSet(this.getId(),
					getTheObsObject());
		}
		if (!this.equals(this.getThis())) {
			this.getThis().store();
			ConnectionHandler.getTheConnectionHandler().theMObservationFacade.ThisSet(this.getId(), getThis());
		}
		if (this.getMyCONCMModelItem() != null) {
			this.getMyCONCMModelItem().store();
			ConnectionHandler.getTheConnectionHandler().theMObservationFacade.myCONCMModelItemSet(this.getId(),
					getMyCONCMModelItem());
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
			ConnectionHandler.getTheConnectionHandler().theMObservationFacade.nameSet(this.getId(), newValue);
		this.name = newValue;
	}

	@Override
	public PersistentMObservationType getTheType() throws PersistenceException {
		return this.theType;
	}

	@Override
	public void setTheType(final PersistentMObservationType newValue) throws PersistenceException {
		if (newValue == null)
			throw new PersistenceException("Null values not allowed!", 0);
		if (newValue.equals(this.theType))
			return;
		final long objectId = newValue.getId();
		final long classId = newValue.getClassId();
		this.theType = (PersistentMObservationType) PersistentProxi.createProxi(objectId, classId);
		if (!this.isDelayed$Persistence()) {
			newValue.store();
			ConnectionHandler.getTheConnectionHandler().theMObservationFacade.theTypeSet(this.getId(), newValue);
		}
	}

	@Override
	public PersistentMEnumValue getEnumValue() throws PersistenceException {
		return this.enumValue;
	}

	@Override
	public void setEnumValue(final PersistentMEnumValue newValue) throws PersistenceException {
		if (newValue == null)
			throw new PersistenceException("Null values not allowed!", 0);
		if (newValue.equals(this.enumValue))
			return;
		final long objectId = newValue.getId();
		final long classId = newValue.getClassId();
		this.enumValue = (PersistentMEnumValue) PersistentProxi.createProxi(objectId, classId);
		if (!this.isDelayed$Persistence()) {
			newValue.store();
			ConnectionHandler.getTheConnectionHandler().theMObservationFacade.enumValueSet(this.getId(), newValue);
		}
	}

	@Override
	public PersistentMObject getTheObsObject() throws PersistenceException {
		return this.theObsObject;
	}

	@Override
	public void setTheObsObject(final PersistentMObject newValue) throws PersistenceException {
		if (newValue == null)
			throw new PersistenceException("Null values not allowed!", 0);
		if (newValue.equals(this.theObsObject))
			return;
		final long objectId = newValue.getId();
		final long classId = newValue.getClassId();
		this.theObsObject = (PersistentMObject) PersistentProxi.createProxi(objectId, classId);
		if (!this.isDelayed$Persistence()) {
			newValue.store();
			ConnectionHandler.getTheConnectionHandler().theMObservationFacade.theObsObjectSet(this.getId(), newValue);
		}
	}

	protected void setThis(final PersistentMObservation newValue) throws PersistenceException {
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
		this.This = (PersistentMObservation) PersistentProxi.createProxi(objectId, classId);
		if (!this.isDelayed$Persistence()) {
			newValue.store();
			ConnectionHandler.getTheConnectionHandler().theMObservationFacade.ThisSet(this.getId(), newValue);
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
			ConnectionHandler.getTheConnectionHandler().theMObservationFacade.myCONCMModelItemSet(this.getId(),
					newValue);
		}
	}

	@Override
	public PersistentMObservation getThis() throws PersistenceException {
		if (this.This == null) {
			final PersistentMObservation result = new MObservationProxi(this.getId());
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
		visitor.handleMObservation(this);
	}

	@Override
	public <R> R accept(final MModelItemReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleMObservation(this);
	}

	@Override
	public <E extends UserException> void accept(final MModelItemExceptionVisitor<E> visitor)
			throws PersistenceException, E {
		visitor.handleMObservation(this);
	}

	@Override
	public <R, E extends UserException> R accept(final MModelItemReturnExceptionVisitor<R, E> visitor)
			throws PersistenceException, E {
		return visitor.handleMObservation(this);
	}

	@Override
	public void accept(final AnythingVisitor visitor) throws PersistenceException {
		visitor.handleMObservation(this);
	}

	@Override
	public <R> R accept(final AnythingReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleMObservation(this);
	}

	@Override
	public <E extends UserException> void accept(final AnythingExceptionVisitor<E> visitor)
			throws PersistenceException, E {
		visitor.handleMObservation(this);
	}

	@Override
	public <R, E extends UserException> R accept(final AnythingReturnExceptionVisitor<R, E> visitor)
			throws PersistenceException, E {
		return visitor.handleMObservation(this);
	}

	@Override
	public int getLeafInfo() throws PersistenceException {
		if (this.getTheType() != null)
			return 1;
		if (this.getEnumValue() != null)
			return 1;
		if (this.getTheObsObject() != null)
			return 1;
		if (this.getDependentItems().getLength() > 0)
			return 1;
		return 0;
	}

	@Override
	public void initialize(final Anything This, final java.util.Hashtable<String, Object> final$$Fields)
			throws PersistenceException {
		this.setThis((PersistentMObservation) This);
		if (this.equals(This)) {
			final PersistentCONCMModelItem myCONCMModelItem = model.CONCMModelItem.createCONCMModelItem(
					this.isDelayed$Persistence(), (PersistentMObservation) This);
			this.setMyCONCMModelItem(myCONCMModelItem);
			this.setName((String) final$$Fields.get("name"));
			this.setTheType((PersistentMObservationType) final$$Fields.get("theType"));
			this.setEnumValue((PersistentMEnumValue) final$$Fields.get("enumValue"));
			this.setTheObsObject((PersistentMObject) final$$Fields.get("theObsObject"));
		}
	}

	// Start of section that contains operations that must be implemented.

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
	public MModelItemSearchList getDependentItems() throws PersistenceException {
		return this.getMyCONCMModelItem().getDependentItems();
	}

	@Override
	public MModelItemSearchList getDependentItems(final TDObserver observer) throws PersistenceException {
		return this.getMyCONCMModelItem().getDependentItems(observer);
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

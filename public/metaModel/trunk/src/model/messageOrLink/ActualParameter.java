package model.messageOrLink;

import model.UserException;
import model.visitor.AnythingExceptionVisitor;
import model.visitor.AnythingReturnExceptionVisitor;
import model.visitor.AnythingReturnVisitor;
import model.visitor.AnythingVisitor;
import persistence.AbstractPersistentRoot;
import persistence.ActualParameterProxi;
import persistence.Anything;
import persistence.ConnectionHandler;
import persistence.PersistenceException;
import persistence.PersistentActualParameter;
import persistence.PersistentFormalParameter;
import persistence.PersistentMObject;
import persistence.PersistentObject;
import persistence.PersistentProxi;
import persistence.TDObserver;

/* Additional import section end */

public class ActualParameter extends PersistentObject implements PersistentActualParameter {

	/** Throws persistence exception if the object with the given id does not exist. */
	public static PersistentActualParameter getById(final long objectId) throws PersistenceException {
		final long classId = ConnectionHandler.getTheConnectionHandler().theActualParameterFacade.getClass(objectId);
		return (PersistentActualParameter) PersistentProxi.createProxi(objectId, classId);
	}

	public static PersistentActualParameter createActualParameter(final PersistentFormalParameter type,
			final PersistentMObject value) throws PersistenceException {
		return createActualParameter(type, value, false);
	}

	public static PersistentActualParameter createActualParameter(final PersistentFormalParameter type,
			final PersistentMObject value, final boolean delayed$Persistence) throws PersistenceException {
		PersistentActualParameter result = null;
		if (delayed$Persistence) {
			result = ConnectionHandler.getTheConnectionHandler().theActualParameterFacade.newDelayedActualParameter();
			result.setDelayed$Persistence(true);
		} else {
			result = ConnectionHandler.getTheConnectionHandler().theActualParameterFacade.newActualParameter(-1);
		}
		final java.util.Hashtable<String, Object> final$$Fields = new java.util.Hashtable<String, Object>();
		final$$Fields.put("type", type);
		final$$Fields.put("value", value);
		result.initialize(result, final$$Fields);
		result.initializeOnCreation();
		return result;
	}

	public static PersistentActualParameter createActualParameter(final PersistentFormalParameter type,
			final PersistentMObject value, final boolean delayed$Persistence, final PersistentActualParameter This)
			throws PersistenceException {
		PersistentActualParameter result = null;
		if (delayed$Persistence) {
			result = ConnectionHandler.getTheConnectionHandler().theActualParameterFacade.newDelayedActualParameter();
			result.setDelayed$Persistence(true);
		} else {
			result = ConnectionHandler.getTheConnectionHandler().theActualParameterFacade.newActualParameter(-1);
		}
		final java.util.Hashtable<String, Object> final$$Fields = new java.util.Hashtable<String, Object>();
		final$$Fields.put("type", type);
		final$$Fields.put("value", value);
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
			final AbstractPersistentRoot value = this.getValue();
			if (value != null) {
				result.put("value", value.createProxiInformation(false, essentialLevel == 0));
				if (depth > 1) {
					value.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true, tdObserver);
				} else {
					if (forGUI && value.hasEssentialFields())
						value.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
				}
			}
			final String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
			if (leaf && !allResults.contains(uniqueKey))
				allResults.put(uniqueKey, result);
		}
		return result;
	}

	@Override
	public ActualParameter provideCopy() throws PersistenceException {
		ActualParameter result = this;
		result = new ActualParameter(this.type, this.value, this.This, this.getId());
		this.copyingPrivateUserAttributes(result);
		return result;
	}

	@Override
	public boolean hasEssentialFields() throws PersistenceException {
		return false;
	}

	protected PersistentFormalParameter type;
	protected PersistentMObject value;
	protected PersistentActualParameter This;

	public ActualParameter(final PersistentFormalParameter type, final PersistentMObject value,
			final PersistentActualParameter This, final long id) throws persistence.PersistenceException {
		/* Shall not be used by clients for object construction! Use static create operation instead! */
		super(id);
		this.type = type;
		this.value = value;
		if (This != null && !(this.equals(This)))
			this.This = This;
	}

	static public long getTypeId() {
		return 196;
	}

	@Override
	public long getClassId() {
		return getTypeId();
	}

	@Override
	public void store() throws PersistenceException {
		if (!this.isDelayed$Persistence())
			return;
		if (this.getClassId() == 196)
			ConnectionHandler.getTheConnectionHandler().theActualParameterFacade.newActualParameter(this.getId());
		super.store();
		if (this.getType() != null) {
			this.getType().store();
			ConnectionHandler.getTheConnectionHandler().theActualParameterFacade.typeSet(this.getId(), getType());
		}
		if (this.getValue() != null) {
			this.getValue().store();
			ConnectionHandler.getTheConnectionHandler().theActualParameterFacade.valueSet(this.getId(), getValue());
		}
		if (!this.equals(this.getThis())) {
			this.getThis().store();
			ConnectionHandler.getTheConnectionHandler().theActualParameterFacade.ThisSet(this.getId(), getThis());
		}

	}

	@Override
	public PersistentFormalParameter getType() throws PersistenceException {
		return this.type;
	}

	@Override
	public void setType(final PersistentFormalParameter newValue) throws PersistenceException {
		if (newValue == null)
			throw new PersistenceException("Null values not allowed!", 0);
		if (newValue.equals(this.type))
			return;
		final long objectId = newValue.getId();
		final long classId = newValue.getClassId();
		this.type = (PersistentFormalParameter) PersistentProxi.createProxi(objectId, classId);
		if (!this.isDelayed$Persistence()) {
			newValue.store();
			ConnectionHandler.getTheConnectionHandler().theActualParameterFacade.typeSet(this.getId(), newValue);
		}
	}

	@Override
	public PersistentMObject getValue() throws PersistenceException {
		return this.value;
	}

	@Override
	public void setValue(final PersistentMObject newValue) throws PersistenceException {
		if (newValue == null)
			throw new PersistenceException("Null values not allowed!", 0);
		if (newValue.equals(this.value))
			return;
		final long objectId = newValue.getId();
		final long classId = newValue.getClassId();
		this.value = (PersistentMObject) PersistentProxi.createProxi(objectId, classId);
		if (!this.isDelayed$Persistence()) {
			newValue.store();
			ConnectionHandler.getTheConnectionHandler().theActualParameterFacade.valueSet(this.getId(), newValue);
		}
	}

	protected void setThis(final PersistentActualParameter newValue) throws PersistenceException {
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
		this.This = (PersistentActualParameter) PersistentProxi.createProxi(objectId, classId);
		if (!this.isDelayed$Persistence()) {
			newValue.store();
			ConnectionHandler.getTheConnectionHandler().theActualParameterFacade.ThisSet(this.getId(), newValue);
		}
	}

	@Override
	public PersistentActualParameter getThis() throws PersistenceException {
		if (this.This == null) {
			final PersistentActualParameter result = new ActualParameterProxi(this.getId());
			result.getTheObject();
			return result;
		}
		return this.This;
	}

	@Override
	public void accept(final AnythingVisitor visitor) throws PersistenceException {
		visitor.handleActualParameter(this);
	}

	@Override
	public <R> R accept(final AnythingReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleActualParameter(this);
	}

	@Override
	public <E extends UserException> void accept(final AnythingExceptionVisitor<E> visitor)
			throws PersistenceException, E {
		visitor.handleActualParameter(this);
	}

	@Override
	public <R, E extends UserException> R accept(final AnythingReturnExceptionVisitor<R, E> visitor)
			throws PersistenceException, E {
		return visitor.handleActualParameter(this);
	}

	@Override
	public int getLeafInfo() throws PersistenceException {
		if (this.getType() != null)
			return 1;
		if (this.getValue() != null)
			return 1;
		return 0;
	}

	@Override
	public void initialize(final Anything This, final java.util.Hashtable<String, Object> final$$Fields)
			throws PersistenceException {
		this.setThis((PersistentActualParameter) This);
		if (this.equals(This)) {
			this.setType((PersistentFormalParameter) final$$Fields.get("type"));
			this.setValue((PersistentMObject) final$$Fields.get("value"));
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

	/* Start of protected part that is not overridden by persistence generator */

	/* End of protected part that is not overridden by persistence generator */

}

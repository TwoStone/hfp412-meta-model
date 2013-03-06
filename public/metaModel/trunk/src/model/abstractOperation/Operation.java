package model.abstractOperation;

import model.UserException;
import model.basic.MBoolean;
import model.typeSystem.MEmptyTypeDisjunction;
import model.visitor.AbsOperationExceptionVisitor;
import model.visitor.AbsOperationReturnExceptionVisitor;
import model.visitor.AbsOperationReturnVisitor;
import model.visitor.AbsOperationVisitor;
import model.visitor.AnythingExceptionVisitor;
import model.visitor.AnythingReturnExceptionVisitor;
import model.visitor.AnythingReturnVisitor;
import model.visitor.AnythingVisitor;
import persistence.Anything;
import persistence.ConnectionHandler;
import persistence.MessageSearchList;
import persistence.OperationProxi;
import persistence.PersistenceException;
import persistence.PersistentAbsOperation;
import persistence.PersistentMBoolean;
import persistence.PersistentMType;
import persistence.PersistentOperation;
import persistence.TDObserver;

/* Additional import section end */

public class Operation extends model.abstractOperation.AbsOperation implements PersistentOperation {

	public static PersistentOperation createOperation(final String name, final PersistentMType source,
			final PersistentMType target) throws PersistenceException {
		return createOperation(name, source, target, false);
	}

	public static PersistentOperation createOperation(final String name, final PersistentMType source,
			final PersistentMType target, final boolean delayed$Persistence) throws PersistenceException {
		PersistentOperation result = null;
		if (delayed$Persistence) {
			result = ConnectionHandler.getTheConnectionHandler().theOperationFacade.newDelayedOperation(name);
			result.setDelayed$Persistence(true);
		} else {
			result = ConnectionHandler.getTheConnectionHandler().theOperationFacade.newOperation(name, -1);
		}
		final java.util.Hashtable<String, Object> final$$Fields = new java.util.Hashtable<String, Object>();
		final$$Fields.put("name", name);
		final$$Fields.put("source", source);
		final$$Fields.put("target", target);
		result.initialize(result, final$$Fields);
		result.initializeOnCreation();
		return result;
	}

	public static PersistentOperation createOperation(final String name, final PersistentMType source,
			final PersistentMType target, final boolean delayed$Persistence, final PersistentOperation This)
			throws PersistenceException {
		PersistentOperation result = null;
		if (delayed$Persistence) {
			result = ConnectionHandler.getTheConnectionHandler().theOperationFacade.newDelayedOperation(name);
			result.setDelayed$Persistence(true);
		} else {
			result = ConnectionHandler.getTheConnectionHandler().theOperationFacade.newOperation(name, -1);
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
	public java.util.Hashtable<String, Object> toHashtable(final java.util.Hashtable<String, Object> allResults,
			final int depth, final int essentialLevel, final boolean forGUI, final boolean leaf,
			final TDObserver tdObserver) throws PersistenceException {
		java.util.Hashtable<String, Object> result = null;
		if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth) {
			result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
			final String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
			if (leaf && !allResults.contains(uniqueKey))
				allResults.put(uniqueKey, result);
		}
		return result;
	}

	@Override
	public Operation provideCopy() throws PersistenceException {
		Operation result = this;
		result = new Operation(this.name, this.source, this.target, this.This, this.getId());
		result.parameters = this.parameters.copy(result);
		this.copyingPrivateUserAttributes(result);
		return result;
	}

	@Override
	public boolean hasEssentialFields() throws PersistenceException {
		return false;
	}

	public Operation(final String name, final PersistentMType source, final PersistentMType target,
			final PersistentAbsOperation This, final long id) throws persistence.PersistenceException {
		/* Shall not be used by clients for object construction! Use static create operation instead! */
		super(name, source, target, This, id);
	}

	static public long getTypeId() {
		return 148;
	}

	@Override
	public long getClassId() {
		return getTypeId();
	}

	@Override
	public void store() throws PersistenceException {
		if (!this.isDelayed$Persistence())
			return;
		if (this.getClassId() == 148)
			ConnectionHandler.getTheConnectionHandler().theOperationFacade.newOperation(name, this.getId());
		super.store();

	}

	@Override
	public PersistentOperation getThis() throws PersistenceException {
		if (this.This == null) {
			final PersistentOperation result = new OperationProxi(this.getId());
			result.getTheObject();
			return result;
		}
		return (PersistentOperation) this.This;
	}

	@Override
	public void accept(final AbsOperationVisitor visitor) throws PersistenceException {
		visitor.handleOperation(this);
	}

	@Override
	public <R> R accept(final AbsOperationReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleOperation(this);
	}

	@Override
	public <E extends UserException> void accept(final AbsOperationExceptionVisitor<E> visitor)
			throws PersistenceException, E {
		visitor.handleOperation(this);
	}

	@Override
	public <R, E extends UserException> R accept(final AbsOperationReturnExceptionVisitor<R, E> visitor)
			throws PersistenceException, E {
		return visitor.handleOperation(this);
	}

	@Override
	public void accept(final AnythingVisitor visitor) throws PersistenceException {
		visitor.handleOperation(this);
	}

	@Override
	public <R> R accept(final AnythingReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleOperation(this);
	}

	@Override
	public <E extends UserException> void accept(final AnythingExceptionVisitor<E> visitor)
			throws PersistenceException, E {
		visitor.handleOperation(this);
	}

	@Override
	public <R, E extends UserException> R accept(final AnythingReturnExceptionVisitor<R, E> visitor)
			throws PersistenceException, E {
		return visitor.handleOperation(this);
	}

	@Override
	public int getLeafInfo() throws PersistenceException {
		if (this.getSource() != null)
			return 1;
		if (this.getTarget() != null)
			return 1;
		if (this.getParameters().getLength() > 0)
			return 1;
		return 0;
	}

	@Override
	public void initialize(final Anything This, final java.util.Hashtable<String, Object> final$$Fields)
			throws PersistenceException {
		this.setThis((PersistentOperation) This);
		if (this.equals(This)) {
			this.setName((String) final$$Fields.get("name"));
			this.setSource((PersistentMType) final$$Fields.get("source"));
			this.setTarget((PersistentMType) final$$Fields.get("target"));
		}
	}

	// Start of section that contains operations that must be implemented.

	@Override
	public MessageSearchList inverseGetType() throws PersistenceException {
		MessageSearchList result = null;
		if (result == null)
			result = ConnectionHandler.getTheConnectionHandler().theMessageFacade.inverseGetType(this.getId(),
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

	@Override
	public PersistentMBoolean isConstant() throws PersistenceException {
		return MBoolean.createFromBoolean(this.getSource().equals(MEmptyTypeDisjunction.getTheMEmptyTypeDisjunction())
				&& getThis().getParameters().getLength() == 0);
	}

	@Override
	public PersistentMBoolean isStatic() throws PersistenceException {
		return MBoolean.createFromBoolean(getThis().getSource().equals(
				MEmptyTypeDisjunction.getTheMEmptyTypeDisjunction()));
	}

	// Start of section that contains overridden operations only.

	/* Start of protected part that is not overridden by persistence generator */

	/* End of protected part that is not overridden by persistence generator */

}

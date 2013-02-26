package model.quantity;

import model.UserException;
import model.visitor.AbsQuantityExceptionVisitor;
import model.visitor.AbsQuantityReturnExceptionVisitor;
import model.visitor.AbsQuantityReturnVisitor;
import model.visitor.AbsQuantityVisitor;
import model.visitor.AnythingExceptionVisitor;
import model.visitor.AnythingReturnExceptionVisitor;
import model.visitor.AnythingReturnVisitor;
import model.visitor.AnythingVisitor;
import persistence.Anything;
import persistence.CompoundQuantityProxi;
import persistence.CompoundQuantity_PartsProxi;
import persistence.ConnectionHandler;
import persistence.PersistenceException;
import persistence.PersistentAbsQuantity;
import persistence.PersistentCompoundQuantity;
import persistence.PersistentMBoolean;
import persistence.TDObserver;

/* Additional import section end */

public class CompoundQuantity extends model.quantity.AbsQuantity implements PersistentCompoundQuantity {

	public static PersistentCompoundQuantity createCompoundQuantity() throws PersistenceException {
		return createCompoundQuantity(false);
	}

	public static PersistentCompoundQuantity createCompoundQuantity(final boolean delayed$Persistence)
			throws PersistenceException {
		PersistentCompoundQuantity result = null;
		if (delayed$Persistence) {
			result = ConnectionHandler.getTheConnectionHandler().theCompoundQuantityFacade.newDelayedCompoundQuantity();
			result.setDelayed$Persistence(true);
		} else {
			result = ConnectionHandler.getTheConnectionHandler().theCompoundQuantityFacade.newCompoundQuantity(-1);
		}
		final java.util.Hashtable<String, Object> final$$Fields = new java.util.Hashtable<String, Object>();
		result.initialize(result, final$$Fields);
		result.initializeOnCreation();
		return result;
	}

	public static PersistentCompoundQuantity createCompoundQuantity(final boolean delayed$Persistence,
			final PersistentCompoundQuantity This) throws PersistenceException {
		PersistentCompoundQuantity result = null;
		if (delayed$Persistence) {
			result = ConnectionHandler.getTheConnectionHandler().theCompoundQuantityFacade.newDelayedCompoundQuantity();
			result.setDelayed$Persistence(true);
		} else {
			result = ConnectionHandler.getTheConnectionHandler().theCompoundQuantityFacade.newCompoundQuantity(-1);
		}
		final java.util.Hashtable<String, Object> final$$Fields = new java.util.Hashtable<String, Object>();
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
			result.put(
					"parts",
					this.getParts().getVector(allResults, depth, essentialLevel, forGUI, tdObserver, false,
							essentialLevel == 0));
			final String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
			if (leaf && !allResults.contains(uniqueKey))
				allResults.put(uniqueKey, result);
		}
		return result;
	}

	@Override
	public CompoundQuantity provideCopy() throws PersistenceException {
		CompoundQuantity result = this;
		result = new CompoundQuantity(this.This, this.getId());
		result.parts = this.parts.copy(result);
		this.copyingPrivateUserAttributes(result);
		return result;
	}

	@Override
	public boolean hasEssentialFields() throws PersistenceException {
		return false;
	}

	protected CompoundQuantity_PartsProxi parts;

	public CompoundQuantity(final PersistentAbsQuantity This, final long id) throws persistence.PersistenceException {
		/* Shall not be used by clients for object construction! Use static create operation instead! */
		super(This, id);
		this.parts = new CompoundQuantity_PartsProxi(this);
	}

	static public long getTypeId() {
		return 109;
	}

	@Override
	public long getClassId() {
		return getTypeId();
	}

	@Override
	public void store() throws PersistenceException {
		if (!this.isDelayed$Persistence())
			return;
		if (this.getClassId() == 109)
			ConnectionHandler.getTheConnectionHandler().theCompoundQuantityFacade.newCompoundQuantity(this.getId());
		super.store();
		this.getParts().store();

	}

	@Override
	public CompoundQuantity_PartsProxi getParts() throws PersistenceException {
		return this.parts;
	}

	@Override
	public PersistentCompoundQuantity getThis() throws PersistenceException {
		if (this.This == null) {
			final PersistentCompoundQuantity result = new CompoundQuantityProxi(this.getId());
			result.getTheObject();
			return result;
		}
		return (PersistentCompoundQuantity) this.This;
	}

	@Override
	public void accept(final AbsQuantityVisitor visitor) throws PersistenceException {
		visitor.handleCompoundQuantity(this);
	}

	@Override
	public <R> R accept(final AbsQuantityReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleCompoundQuantity(this);
	}

	@Override
	public <E extends UserException> void accept(final AbsQuantityExceptionVisitor<E> visitor)
			throws PersistenceException, E {
		visitor.handleCompoundQuantity(this);
	}

	@Override
	public <R, E extends UserException> R accept(final AbsQuantityReturnExceptionVisitor<R, E> visitor)
			throws PersistenceException, E {
		return visitor.handleCompoundQuantity(this);
	}

	@Override
	public void accept(final AnythingVisitor visitor) throws PersistenceException {
		visitor.handleCompoundQuantity(this);
	}

	@Override
	public <R> R accept(final AnythingReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleCompoundQuantity(this);
	}

	@Override
	public <E extends UserException> void accept(final AnythingExceptionVisitor<E> visitor)
			throws PersistenceException, E {
		visitor.handleCompoundQuantity(this);
	}

	@Override
	public <R, E extends UserException> R accept(final AnythingReturnExceptionVisitor<R, E> visitor)
			throws PersistenceException, E {
		return visitor.handleCompoundQuantity(this);
	}

	@Override
	public int getLeafInfo() throws PersistenceException {
		if (this.getParts().getLength() > 0)
			return 1;
		return 0;
	}

	@Override
	public void initialize(final Anything This, final java.util.Hashtable<String, Object> final$$Fields)
			throws PersistenceException {
		this.setThis((PersistentCompoundQuantity) This);
		if (this.equals(This)) {
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
	public PersistentAbsQuantity add(final PersistentAbsQuantity summand) throws model.NotComputableException,
			PersistenceException {
		// TODO Auto-generated method stub hugo ist da
		return null;
	}

	@Override
	public PersistentAbsQuantity div(final PersistentAbsQuantity divisor) throws model.NotComputableException,
			PersistenceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PersistentAbsQuantity mul(final PersistentAbsQuantity factor) throws model.NotComputableException,
			PersistenceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PersistentAbsQuantity sub(final PersistentAbsQuantity subtrahend) throws model.NotComputableException,
			PersistenceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PersistentMBoolean isLessOrEqualThan(final PersistentAbsQuantity compareValue) throws UserException,
			PersistenceException {
		// TODO Auto-generated method stub
		return null;
	}

	/* Start of protected part that is not overridden by persistence generator */

	/* End of protected part that is not overridden by persistence generator */

}

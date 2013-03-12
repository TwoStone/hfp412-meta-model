package model.quantity;

import model.UserException;
import model.basic.MFalse;
import model.visitor.AnythingExceptionVisitor;
import model.visitor.AnythingReturnExceptionVisitor;
import model.visitor.AnythingReturnVisitor;
import model.visitor.AnythingVisitor;
import model.visitor.BasicCalculationExceptionVisitor;
import model.visitor.BasicCalculationReturnExceptionVisitor;
import model.visitor.BasicCalculationReturnVisitor;
import model.visitor.BasicCalculationVisitor;
import model.visitor.UnitImutabCalcExceptionVisitor;
import model.visitor.UnitImutabCalcReturnExceptionVisitor;
import model.visitor.UnitImutabCalcReturnVisitor;
import model.visitor.UnitImutabCalcVisitor;
import persistence.AdditionProxi;
import persistence.Anything;
import persistence.ConnectionHandler;
import persistence.PersistenceException;
import persistence.PersistentAbsQuantity;
import persistence.PersistentAddition;
import persistence.PersistentBasicCalculation;
import persistence.PersistentMBoolean;
import persistence.TDObserver;

/* Additional import section end */

public class Addition extends model.quantity.UnitImutabCalc implements PersistentAddition {

	public static PersistentAddition createAddition() throws PersistenceException {
		return createAddition(false);
	}

	public static PersistentAddition createAddition(final boolean delayed$Persistence) throws PersistenceException {
		PersistentAddition result = null;
		if (delayed$Persistence) {
			result = ConnectionHandler.getTheConnectionHandler().theAdditionFacade.newDelayedAddition();
			result.setDelayed$Persistence(true);
		} else {
			result = ConnectionHandler.getTheConnectionHandler().theAdditionFacade.newAddition(-1);
		}
		final java.util.Hashtable<String, Object> final$$Fields = new java.util.Hashtable<String, Object>();
		result.initialize(result, final$$Fields);
		result.initializeOnCreation();
		return result;
	}

	public static PersistentAddition createAddition(final boolean delayed$Persistence, final PersistentAddition This) throws PersistenceException {
		PersistentAddition result = null;
		if (delayed$Persistence) {
			result = ConnectionHandler.getTheConnectionHandler().theAdditionFacade.newDelayedAddition();
			result.setDelayed$Persistence(true);
		} else {
			result = ConnectionHandler.getTheConnectionHandler().theAdditionFacade.newAddition(-1);
		}
		final java.util.Hashtable<String, Object> final$$Fields = new java.util.Hashtable<String, Object>();
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
			final String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
			if (leaf && !allResults.contains(uniqueKey))
				allResults.put(uniqueKey, result);
		}
		return result;
	}

	@Override
	public Addition provideCopy() throws PersistenceException {
		Addition result = this;
		result = new Addition(this.arg1, this.arg2, this.resultt, this.This, this.getId());
		this.copyingPrivateUserAttributes(result);
		return result;
	}

	@Override
	public boolean hasEssentialFields() throws PersistenceException {
		return false;
	}

	public Addition(final PersistentAbsQuantity arg1, final PersistentAbsQuantity arg2, final PersistentAbsQuantity resultt,
			final PersistentBasicCalculation This, final long id) throws persistence.PersistenceException {
		/* Shall not be used by clients for object construction! Use static create operation instead! */
		super(arg1, arg2, resultt, This, id);
	}

	static public long getTypeId() {
		return 332;
	}

	@Override
	public long getClassId() {
		return getTypeId();
	}

	@Override
	public void store() throws PersistenceException {
		if (!this.isDelayed$Persistence())
			return;
		if (this.getClassId() == 332)
			ConnectionHandler.getTheConnectionHandler().theAdditionFacade.newAddition(this.getId());
		super.store();

	}

	@Override
	public PersistentAddition getThis() throws PersistenceException {
		if (this.This == null) {
			final PersistentAddition result = new AdditionProxi(this.getId());
			result.getTheObject();
			return result;
		}
		return (PersistentAddition) this.This;
	}

	@Override
	public void accept(final UnitImutabCalcVisitor visitor) throws PersistenceException {
		visitor.handleAddition(this);
	}

	@Override
	public <R> R accept(final UnitImutabCalcReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleAddition(this);
	}

	@Override
	public <E extends UserException> void accept(final UnitImutabCalcExceptionVisitor<E> visitor) throws PersistenceException, E {
		visitor.handleAddition(this);
	}

	@Override
	public <R, E extends UserException> R accept(final UnitImutabCalcReturnExceptionVisitor<R, E> visitor) throws PersistenceException, E {
		return visitor.handleAddition(this);
	}

	@Override
	public void accept(final BasicCalculationVisitor visitor) throws PersistenceException {
		visitor.handleAddition(this);
	}

	@Override
	public <R> R accept(final BasicCalculationReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleAddition(this);
	}

	@Override
	public <E extends UserException> void accept(final BasicCalculationExceptionVisitor<E> visitor) throws PersistenceException, E {
		visitor.handleAddition(this);
	}

	@Override
	public <R, E extends UserException> R accept(final BasicCalculationReturnExceptionVisitor<R, E> visitor) throws PersistenceException, E {
		return visitor.handleAddition(this);
	}

	@Override
	public void accept(final AnythingVisitor visitor) throws PersistenceException {
		visitor.handleAddition(this);
	}

	@Override
	public <R> R accept(final AnythingReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleAddition(this);
	}

	@Override
	public <E extends UserException> void accept(final AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
		visitor.handleAddition(this);
	}

	@Override
	public <R, E extends UserException> R accept(final AnythingReturnExceptionVisitor<R, E> visitor) throws PersistenceException, E {
		return visitor.handleAddition(this);
	}

	@Override
	public int getLeafInfo() throws PersistenceException {
		if (this.getArg1() != null)
			return 1;
		if (this.getArg2() != null)
			return 1;
		if (this.getResultt() != null)
			return 1;
		return 0;
	}

	@Override
	public void initialize(final Anything This, final java.util.Hashtable<String, Object> final$$Fields) throws PersistenceException {
		this.setThis((PersistentAddition) This);
		if (this.equals(This)) {
		}
	}

	// Start of section that contains operations that must be implemented.

	@Override
	public common.Fraction calcFraction(final common.Fraction arg1, final common.Fraction arg2) throws model.NotComputableException,
			PersistenceException {
		try {
			return arg1.add(arg2);
		} catch (final Throwable e) {
			throw new model.NotComputableException(e.getMessage());
		}
	}

	@Override
	public void copyingPrivateUserAttributes(final Anything copy) throws PersistenceException {
		// implement method: copyingPrivateUserAttributes

	}

	@Override
	public void initializeOnCreation() throws PersistenceException {
		// implement method: initializeOnCreation

	}

	@Override
	public void initializeOnInstantiation() throws PersistenceException {
		// implement method: initializeOnInstantiation

	}

	@Override
	public PersistentMBoolean mustSignInverted() throws PersistenceException {
		return MFalse.getTheMFalse();
	}

	// Start of section that contains overridden operations only.

	/* Start of protected part that is not overridden by persistence generator */

	/* End of protected part that is not overridden by persistence generator */

}

package model.quantity;

import model.UserException;
import model.visitor.AnythingExceptionVisitor;
import model.visitor.AnythingReturnExceptionVisitor;
import model.visitor.AnythingReturnVisitor;
import model.visitor.AnythingVisitor;
import model.visitor.BasicCalculationExceptionVisitor;
import model.visitor.BasicCalculationReturnExceptionVisitor;
import model.visitor.BasicCalculationReturnVisitor;
import model.visitor.BasicCalculationVisitor;
import model.visitor.UnitMutabCalcExceptionVisitor;
import model.visitor.UnitMutabCalcReturnExceptionVisitor;
import model.visitor.UnitMutabCalcReturnVisitor;
import model.visitor.UnitMutabCalcVisitor;
import persistence.Anything;
import persistence.ConnectionHandler;
import persistence.MultiplicationProxi;
import persistence.PersistenceException;
import persistence.PersistentAbsQuantity;
import persistence.PersistentAbsUnit;
import persistence.PersistentAbsUnitType;
import persistence.PersistentBasicCalculation;
import persistence.PersistentMultiplication;
import persistence.TDObserver;

import common.Fraction;

/* Additional import section end */

public class Multiplication extends model.quantity.UnitMutabCalc implements PersistentMultiplication {

	public static PersistentMultiplication createMultiplication() throws PersistenceException {
		return createMultiplication(false);
	}

	public static PersistentMultiplication createMultiplication(final boolean delayed$Persistence)
			throws PersistenceException {
		PersistentMultiplication result = null;
		if (delayed$Persistence) {
			result = ConnectionHandler.getTheConnectionHandler().theMultiplicationFacade.newDelayedMultiplication();
			result.setDelayed$Persistence(true);
		} else {
			result = ConnectionHandler.getTheConnectionHandler().theMultiplicationFacade.newMultiplication(-1);
		}
		final java.util.Hashtable<String, Object> final$$Fields = new java.util.Hashtable<String, Object>();
		result.initialize(result, final$$Fields);
		result.initializeOnCreation();
		return result;
	}

	public static PersistentMultiplication createMultiplication(final boolean delayed$Persistence,
			final PersistentMultiplication This) throws PersistenceException {
		PersistentMultiplication result = null;
		if (delayed$Persistence) {
			result = ConnectionHandler.getTheConnectionHandler().theMultiplicationFacade.newDelayedMultiplication();
			result.setDelayed$Persistence(true);
		} else {
			result = ConnectionHandler.getTheConnectionHandler().theMultiplicationFacade.newMultiplication(-1);
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
			final String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
			if (leaf && !allResults.contains(uniqueKey))
				allResults.put(uniqueKey, result);
		}
		return result;
	}

	@Override
	public Multiplication provideCopy() throws PersistenceException {
		Multiplication result = this;
		result = new Multiplication(this.arg1, this.arg2, this.resultt, this.This, this.targetUnit,
				this.targetUnitType, this.getId());
		this.copyingPrivateUserAttributes(result);
		return result;
	}

	@Override
	public boolean hasEssentialFields() throws PersistenceException {
		return false;
	}

	public Multiplication(final PersistentAbsQuantity arg1, final PersistentAbsQuantity arg2,
			final PersistentAbsQuantity resultt, final PersistentBasicCalculation This,
			final PersistentAbsUnit targetUnit, final PersistentAbsUnitType targetUnitType, final long id)
			throws persistence.PersistenceException {
		/* Shall not be used by clients for object construction! Use static create operation instead! */
		super(arg1, arg2, resultt, This, targetUnit, targetUnitType, id);
	}

	static public long getTypeId() {
		return 328;
	}

	@Override
	public long getClassId() {
		return getTypeId();
	}

	@Override
	public void store() throws PersistenceException {
		if (!this.isDelayed$Persistence())
			return;
		if (this.getClassId() == 328)
			ConnectionHandler.getTheConnectionHandler().theMultiplicationFacade.newMultiplication(this.getId());
		super.store();

	}

	@Override
	public PersistentMultiplication getThis() throws PersistenceException {
		if (this.This == null) {
			final PersistentMultiplication result = new MultiplicationProxi(this.getId());
			result.getTheObject();
			return result;
		}
		return (PersistentMultiplication) this.This;
	}

	@Override
	public void accept(final UnitMutabCalcVisitor visitor) throws PersistenceException {
		visitor.handleMultiplication(this);
	}

	@Override
	public <R> R accept(final UnitMutabCalcReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleMultiplication(this);
	}

	@Override
	public <E extends UserException> void accept(final UnitMutabCalcExceptionVisitor<E> visitor)
			throws PersistenceException, E {
		visitor.handleMultiplication(this);
	}

	@Override
	public <R, E extends UserException> R accept(final UnitMutabCalcReturnExceptionVisitor<R, E> visitor)
			throws PersistenceException, E {
		return visitor.handleMultiplication(this);
	}

	@Override
	public void accept(final BasicCalculationVisitor visitor) throws PersistenceException {
		visitor.handleMultiplication(this);
	}

	@Override
	public <R> R accept(final BasicCalculationReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleMultiplication(this);
	}

	@Override
	public <E extends UserException> void accept(final BasicCalculationExceptionVisitor<E> visitor)
			throws PersistenceException, E {
		visitor.handleMultiplication(this);
	}

	@Override
	public <R, E extends UserException> R accept(final BasicCalculationReturnExceptionVisitor<R, E> visitor)
			throws PersistenceException, E {
		return visitor.handleMultiplication(this);
	}

	@Override
	public void accept(final AnythingVisitor visitor) throws PersistenceException {
		visitor.handleMultiplication(this);
	}

	@Override
	public <R> R accept(final AnythingReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleMultiplication(this);
	}

	@Override
	public <E extends UserException> void accept(final AnythingExceptionVisitor<E> visitor)
			throws PersistenceException, E {
		visitor.handleMultiplication(this);
	}

	@Override
	public <R, E extends UserException> R accept(final AnythingReturnExceptionVisitor<R, E> visitor)
			throws PersistenceException, E {
		return visitor.handleMultiplication(this);
	}

	@Override
	public int getLeafInfo() throws PersistenceException {
		if (this.getArg1() != null)
			return 1;
		if (this.getArg2() != null)
			return 1;
		if (this.getResultt() != null)
			return 1;
		if (this.getTargetUnit() != null)
			return 1;
		if (this.getTargetUnitType() != null)
			return 1;
		return 0;
	}

	@Override
	public void initializeOnInstantiation() throws PersistenceException {
	}

	@Override
	public void copyingPrivateUserAttributes(final Anything copy) throws PersistenceException {
	}

	@Override
	public void calcTargetRefs() throws model.NotComputableException, PersistenceException {
		// TODO: implement method: calcTargetRefs

	}

	@Override
	public void initialize(final Anything This, final java.util.Hashtable<String, Object> final$$Fields)
			throws PersistenceException {
		this.setThis((PersistentMultiplication) This);
		if (this.equals(This)) {
		}
	}

	@Override
	public Fraction calcFraction(final Fraction arg1, final Fraction arg2) throws model.NotComputableException,
			PersistenceException {
		try {
			return arg1.div(arg2);
		} catch (final Throwable e) {
			throw new model.NotComputableException(e.getMessage());
		}
	}

	@Override
	public void initializeOnCreation() throws PersistenceException {
	}

	@Override
	public void calcTargetRefTypes() throws model.NotComputableException, PersistenceException {
		// TODO: implement method: calcTargetRefType

	}

	/* Start of protected part that is not overridden by persistence generator */

	/* End of protected part that is not overridden by persistence generator */

}

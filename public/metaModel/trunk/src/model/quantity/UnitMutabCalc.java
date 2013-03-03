package model.quantity;

import persistence.AbstractPersistentRoot;
import persistence.Anything;
import persistence.ConnectionHandler;
import persistence.PersistenceException;
import persistence.PersistentAbsQuantity;
import persistence.PersistentAbsUnit;
import persistence.PersistentAbsUnitType;
import persistence.PersistentBasicCalculation;
import persistence.PersistentCompoundQuantity;
import persistence.PersistentProxi;
import persistence.PersistentQuantity;
import persistence.PersistentUnit;
import persistence.PersistentUnitMutabCalc;
import persistence.PersistentUnitType;
import persistence.TDObserver;

import common.SummableHashMap;

/* Additional import section end */

public abstract class UnitMutabCalc extends model.quantity.BasicCalculation implements PersistentUnitMutabCalc {

	@Override
	public java.util.Hashtable<String, Object> toHashtable(final java.util.Hashtable<String, Object> allResults,
			final int depth, final int essentialLevel, final boolean forGUI, final boolean leaf,
			final TDObserver tdObserver) throws PersistenceException {
		java.util.Hashtable<String, Object> result = null;
		if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth) {
			result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
			final AbstractPersistentRoot targetUnit = this.getTargetUnit();
			if (targetUnit != null) {
				result.put("targetUnit", targetUnit.createProxiInformation(false, essentialLevel == 0));
				if (depth > 1) {
					targetUnit.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true, tdObserver);
				} else {
					if (forGUI && targetUnit.hasEssentialFields())
						targetUnit.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
				}
			}
			final AbstractPersistentRoot targetUnitType = this.getTargetUnitType();
			if (targetUnitType != null) {
				result.put("targetUnitType", targetUnitType.createProxiInformation(false, essentialLevel == 0));
				if (depth > 1) {
					targetUnitType.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true, tdObserver);
				} else {
					if (forGUI && targetUnitType.hasEssentialFields())
						targetUnitType.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
				}
			}
			final String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
			if (leaf && !allResults.contains(uniqueKey))
				allResults.put(uniqueKey, result);
		}
		return result;
	}

	@Override
	public abstract UnitMutabCalc provideCopy() throws PersistenceException;

	@Override
	public boolean hasEssentialFields() throws PersistenceException {
		return false;
	}

	protected PersistentAbsUnit targetUnit;
	protected PersistentAbsUnitType targetUnitType;

	public UnitMutabCalc(final PersistentAbsQuantity arg1, final PersistentAbsQuantity arg2,
			final PersistentAbsQuantity resultt, final PersistentBasicCalculation This,
			final PersistentAbsUnit targetUnit, final PersistentAbsUnitType targetUnitType, final long id)
			throws persistence.PersistenceException {
		/* Shall not be used by clients for object construction! Use static create operation instead! */
		super(arg1, arg2, resultt, This, id);
		this.targetUnit = targetUnit;
		this.targetUnitType = targetUnitType;
	}

	static public long getTypeId() {
		return 334;
	}

	@Override
	public long getClassId() {
		return getTypeId();
	}

	@Override
	public void store() throws PersistenceException {
		if (!this.isDelayed$Persistence())
			return;
		super.store();
		if (this.getTargetUnit() != null) {
			this.getTargetUnit().store();
			ConnectionHandler.getTheConnectionHandler().theUnitMutabCalcFacade.targetUnitSet(this.getId(),
					getTargetUnit());
		}
		if (this.getTargetUnitType() != null) {
			this.getTargetUnitType().store();
			ConnectionHandler.getTheConnectionHandler().theUnitMutabCalcFacade.targetUnitTypeSet(this.getId(),
					getTargetUnitType());
		}

	}

	@Override
	public PersistentAbsUnit getTargetUnit() throws PersistenceException {
		return this.targetUnit;
	}

	@Override
	public void setTargetUnit(final PersistentAbsUnit newValue) throws PersistenceException {
		if (newValue == null)
			throw new PersistenceException("Null values not allowed!", 0);
		if (newValue.equals(this.targetUnit))
			return;
		final long objectId = newValue.getId();
		final long classId = newValue.getClassId();
		this.targetUnit = (PersistentAbsUnit) PersistentProxi.createProxi(objectId, classId);
		if (!this.isDelayed$Persistence()) {
			newValue.store();
			ConnectionHandler.getTheConnectionHandler().theUnitMutabCalcFacade.targetUnitSet(this.getId(), newValue);
		}
	}

	@Override
	public PersistentAbsUnitType getTargetUnitType() throws PersistenceException {
		return this.targetUnitType;
	}

	@Override
	public void setTargetUnitType(final PersistentAbsUnitType newValue) throws PersistenceException {
		if (newValue == null)
			throw new PersistenceException("Null values not allowed!", 0);
		if (newValue.equals(this.targetUnitType))
			return;
		final long objectId = newValue.getId();
		final long classId = newValue.getClassId();
		this.targetUnitType = (PersistentAbsUnitType) PersistentProxi.createProxi(objectId, classId);
		if (!this.isDelayed$Persistence()) {
			newValue.store();
			ConnectionHandler.getTheConnectionHandler().theUnitMutabCalcFacade
					.targetUnitTypeSet(this.getId(), newValue);
		}
	}

	@Override
	public abstract PersistentUnitMutabCalc getThis() throws PersistenceException;

	@Override
	public void initializeOnInstantiation() throws PersistenceException {
		// TODO: implement method: initializeOnInstantiation

	}

	@Override
	public void copyingPrivateUserAttributes(final Anything copy) throws PersistenceException {
		// TODO: implement method: copyingPrivateUserAttributes

	}

	@Override
	public void initialize(final Anything This, final java.util.Hashtable<String, Object> final$$Fields)
			throws PersistenceException {
		this.setThis((PersistentUnitMutabCalc) This);
		if (this.equals(This)) {
		}
	}

	@Override
	public void initializeOnCreation() throws PersistenceException {
		// TODO: implement method: initializeOnCreation

	}

	@Override
	public void createTargetUnitType() throws model.NotComputableException, PersistenceException {
		// TODO Auto-generated method stub

	}

	@Override
	public void findTargetUnit() throws model.NotComputableException, PersistenceException {
		// TODO Auto-generated method stub

	}

	@Override
	public void calcAtomar(final PersistentQuantity atom1, final PersistentQuantity atom2)
			throws model.NotComputableException, PersistenceException {
		// TODO Auto-generated method stub

	}

	@Override
	public void calc1Compound1Atomar(final PersistentQuantity atom, final PersistentCompoundQuantity comp)
			throws model.NotComputableException, PersistenceException {
		// TODO Auto-generated method stub

	}

	@Override
	public void findTargetUnitType() throws model.NotComputableException, PersistenceException {
		// TODO Auto-generated method stub

	}

	@Override
	public void createTargetUnit() throws model.NotComputableException, PersistenceException {
		// TODO Auto-generated method stub

	}

	@Override
	public void calcComp(final PersistentCompoundQuantity comp1, final PersistentCompoundQuantity comp2)
			throws model.NotComputableException, PersistenceException {
		// TODO Auto-generated method stub

	}

	/* Start of protected part that is not overridden by persistence generator */

	protected SummableHashMap<PersistentUnit> targetRefs;
	protected SummableHashMap<PersistentUnitType> targetRefTypes;

	/* End of protected part that is not overridden by persistence generator */

}

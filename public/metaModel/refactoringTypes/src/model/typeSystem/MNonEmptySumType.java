package model.typeSystem;

import model.basic.MFalse;
import model.basic.MTrue;
import persistence.Anything;
import persistence.PersistenceException;
import persistence.PersistentMBoolean;
import persistence.PersistentMNonEmptySumType;
import persistence.PersistentMType;
import persistence.TDObserver;

/* Additional import section end */

public abstract class MNonEmptySumType extends model.typeSystem.MAbstractSumType implements PersistentMNonEmptySumType {

	@Override
	public java.util.Hashtable<String, Object> toHashtable(java.util.Hashtable<String, Object> allResults, int depth,
			int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
		java.util.Hashtable<String, Object> result = null;
		if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth) {
			result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
			String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
			if (leaf && !allResults.contains(uniqueKey))
				allResults.put(uniqueKey, result);
		}
		return result;
	}

	@Override
	public abstract MNonEmptySumType provideCopy() throws PersistenceException;

	@Override
	public boolean hasEssentialFields() throws PersistenceException {
		return false;
	}

	public MNonEmptySumType(PersistentMType This, long id) throws persistence.PersistenceException {
		/* Shall not be used by clients for object construction! Use static create operation instead! */
		super(This, id);
	}

	static public long getTypeId() {
		return 279;
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

	}

	@Override
	public abstract PersistentMNonEmptySumType getThis() throws PersistenceException;

	@Override
	public void initializeOnInstantiation() throws PersistenceException {
	}

	@Override
	public void copyingPrivateUserAttributes(final Anything copy) throws PersistenceException {
	}

	@Override
	public void initialize(final Anything This, final java.util.Hashtable<String, Object> final$$Fields)
			throws PersistenceException {
		this.setThis((PersistentMNonEmptySumType) This);
		if (this.equals(This)) {
		}
	}

	@Override
	public void initializeOnCreation() throws PersistenceException {
	}

	@Override
	public PersistentMBoolean isSingleton() throws PersistenceException {
		if (getThis().getContainedTypes().getLength() == 1) {
			return getThis().getContainedTypes().iterator().next().isSingleton();
		}

		return MFalse.getTheMFalse();
	}

	@Override
	public PersistentMBoolean isAbstract() throws PersistenceException {
		if (getThis().getContainedTypes().getLength() == 1) {
			return getThis().getContainedTypes().iterator().next().isAbstract();
		}

		return MTrue.getTheMTrue();
	}

	/* Start of protected part that is not overridden by persistence generator */

	/* End of protected part that is not overridden by persistence generator */

}

package model.typeSystem;

import java.util.Iterator;

import model.basic.MFalse;
import model.basic.MTrue;
import persistence.Anything;
import persistence.PersistenceException;
import persistence.PersistentMBoolean;
import persistence.PersistentMNonEmptyProductType;
import persistence.PersistentMType;
import persistence.TDObserver;

/* Additional import section end */

public abstract class MNonEmptyProductType extends model.typeSystem.MAbstractProductType implements
		PersistentMNonEmptyProductType {

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
	public abstract MNonEmptyProductType provideCopy() throws PersistenceException;

	@Override
	public boolean hasEssentialFields() throws PersistenceException {
		return false;
	}

	public MNonEmptyProductType(PersistentMType This, long id) throws persistence.PersistenceException {
		/* Shall not be used by clients for object construction! Use static create operation instead! */
		super(This, id);
	}

	static public long getTypeId() {
		return 278;
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
	public abstract PersistentMNonEmptyProductType getThis() throws PersistenceException;

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
		this.setThis((PersistentMNonEmptyProductType) This);
		if (this.equals(This)) {
		}
	}

	@Override
	public void initializeOnCreation() throws PersistenceException {
		// TODO: implement method: initializeOnCreation

	}

	@Override
	public PersistentMBoolean isSingleton() throws PersistenceException {
		Iterator<PersistentMType> i = getThis().getContainedTypes().iterator();

		while (i.hasNext()) {
			if (!i.next().isSingleton().toBoolean()) {
				return MFalse.getTheMFalse();
			}
		}
		return MTrue.getTheMTrue();
	}

	@Override
	public PersistentMBoolean isAbstract() throws PersistenceException {
		Iterator<PersistentMType> i = getThis().getContainedTypes().iterator();

		while (i.hasNext()) {
			if (i.next().isAbstract().toBoolean()) {
				return MTrue.getTheMTrue();
			}
		}
		return MFalse.getTheMFalse();

	}

	@Override
	public PersistentMBoolean isStructuralEquivalant(final PersistentMType other) throws PersistenceException {
		// TODO: implement method: isStructuralEquivalant
		try {
			throw new java.lang.UnsupportedOperationException("Method \"isStructuralEquivalant\" not implemented yet.");
		} catch (java.lang.UnsupportedOperationException uoe) {
			uoe.printStackTrace();
			throw uoe;
		}
	}

	/* Start of protected part that is not overridden by persistence generator */

	/* End of protected part that is not overridden by persistence generator */

}

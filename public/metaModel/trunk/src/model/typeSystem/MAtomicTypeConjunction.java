package model.typeSystem;

import persistence.Anything;
import persistence.PersistenceException;
import persistence.PersistentCONCMModelItem;
import persistence.PersistentMAtomicTypeConjunction;
import persistence.PersistentMModelItem;
import persistence.PersistentMType;
import persistence.TDObserver;

/* Additional import section end */

public abstract class MAtomicTypeConjunction extends model.typeSystem.MAbstractTypeConjunction implements
		PersistentMAtomicTypeConjunction {

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
	public abstract MAtomicTypeConjunction provideCopy() throws PersistenceException;

	@Override
	public boolean hasEssentialFields() throws PersistenceException {
		return true;
	}

	public MAtomicTypeConjunction(PersistentMType This, PersistentMModelItem myCONCMModelItem, long id)
			throws persistence.PersistenceException {
		/* Shall not be used by clients for object construction! Use static create operation instead! */
		super((PersistentMType) This, (PersistentMModelItem) myCONCMModelItem, id);
	}

	static public long getTypeId() {
		return 311;
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
	public abstract PersistentMAtomicTypeConjunction getThis() throws PersistenceException;

	@Override
	public void initializeOnInstantiation() throws PersistenceException {
	}

	@Override
	public void copyingPrivateUserAttributes(final Anything copy) throws PersistenceException {
	}

	@Override
	public void initialize(final Anything This, final java.util.Hashtable<String, Object> final$$Fields)
			throws PersistenceException {
		this.setThis((PersistentMAtomicTypeConjunction) This);
		if (this.equals(This)) {
			PersistentCONCMModelItem myCONCMModelItem = model.CONCMModelItem.createCONCMModelItem(
					this.isDelayed$Persistence(), (PersistentMAtomicTypeConjunction) This);
			this.setMyCONCMModelItem(myCONCMModelItem);
		}
	}

	@Override
	public void initializeOnCreation() throws PersistenceException {
	}

	/* Start of protected part that is not overridden by persistence generator */

	/* End of protected part that is not overridden by persistence generator */

}

package model.typeSystem;

import java.util.Iterator;

import model.basic.MFalse;
import model.basic.MTrue;
import persistence.Anything;
import persistence.MTypeSearchList;
import persistence.PersistenceException;
import persistence.PersistentMAbstractTypeDisjunction;
import persistence.PersistentMBoolean;
import persistence.PersistentMType;
import persistence.TDObserver;
import utils.SearchLists;
import utils.TruePredcate;

/* Additional import section end */

public abstract class MAbstractTypeDisjunction extends model.typeSystem.MComplexType implements
		PersistentMAbstractTypeDisjunction {

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
	public abstract MAbstractTypeDisjunction provideCopy() throws PersistenceException;

	@Override
	public boolean hasEssentialFields() throws PersistenceException {
		return false;
	}

	public MAbstractTypeDisjunction(PersistentMType This, long id) throws persistence.PersistenceException {
		/* Shall not be used by clients for object construction! Use static create operation instead! */
		super(This, id);
	}

	static public long getTypeId() {
		return 305;
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
	public abstract PersistentMAbstractTypeDisjunction getThis() throws PersistenceException;

	@Override
	public void initializeOnInstantiation() throws PersistenceException {
	}

	@Override
	public void copyingPrivateUserAttributes(final Anything copy) throws PersistenceException {
	}

	@Override
	public void initialize(final Anything This, final java.util.Hashtable<String, Object> final$$Fields)
			throws PersistenceException {
		this.setThis((PersistentMAbstractTypeDisjunction) This);
		if (this.equals(This)) {
		}
	}

	@Override
	public void initializeOnCreation() throws PersistenceException {
	}

	@Override
	public String fetchName() throws PersistenceException {
		StringBuilder builder = new StringBuilder();

		builder.append("{");
		Iterator<PersistentMType> iterator = this.getContainedTypes().iterator();
		if (iterator.hasNext()) {
			builder.append(iterator.next().fetchName());
		}

		while (iterator.hasNext()) {
			PersistentMType persistentMType = iterator.next();
			builder.append(this.getThis().fetchTypeLinkOperator());
			builder.append(persistentMType.fetchName());
		}

		builder.append("}");

		return builder.toString();
	}

	@Override
	public MTypeSearchList getContainedTypes() throws PersistenceException {
		return SearchLists.toMTypeSearchList(fetchContainedTypes());
	}

	@Override
	public String fetchTypeLinkOperator() throws PersistenceException {
		return MAbstractTypeDisjunction.TYPE_LINK_OP;
	}

	@Override
	public PersistentMBoolean isSingleton() throws PersistenceException {
		if (getThis().getContainedTypes().getLength() == 1) {
			return getThis().getContainedTypes().findFirst(new TruePredcate<PersistentMType>()).isSingleton();
		}
		return MFalse.getTheMFalse();
	}

	@Override
	public PersistentMBoolean isAbstract() throws PersistenceException {
		if (getThis().getContainedTypes().getLength() == 1) {
			return getThis().getContainedTypes().findFirst(new TruePredcate<PersistentMType>()).isAbstract();
		}
		return MTrue.getTheMTrue();
	}

	/* Start of protected part that is not overridden by persistence generator */
	public static String TYPE_LINK_OP = "++";
	/* End of protected part that is not overridden by persistence generator */

}

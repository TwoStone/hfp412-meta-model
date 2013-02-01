package model.typeSystem;

import java.util.Iterator;

import model.basic.MBoolean;
import model.basic.MFalse;
import persistence.Anything;
import persistence.MTypeSearchList;
import persistence.PersistenceException;
import persistence.PersistentMBoolean;
import persistence.PersistentMComplexType;
import persistence.PersistentMType;
import persistence.TDObserver;

/* Additional import section end */

public abstract class MComplexType extends model.typeSystem.MType implements PersistentMComplexType {

	@Override
	public java.util.Hashtable<String, Object> toHashtable(java.util.Hashtable<String, Object> allResults, int depth,
			int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
		java.util.Hashtable<String, Object> result = null;
		if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth) {
			result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
			result.put(
					"containedTypes",
					this.getContainedTypes(tdObserver).getVector(allResults, (depth > 1 ? depth : depth + 1),
							essentialLevel, forGUI, tdObserver, false));
			String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
			if (leaf && !allResults.contains(uniqueKey))
				allResults.put(uniqueKey, result);
		}
		return result;
	}

	@Override
	public abstract MComplexType provideCopy() throws PersistenceException;

	@Override
	public boolean hasEssentialFields() throws PersistenceException {
		return false;
	}

	public MComplexType(PersistentMType This, long id) throws persistence.PersistenceException {
		/* Shall not be used by clients for object construction! Use static create operation instead! */
		super(This, id);
	}

	static public long getTypeId() {
		return 103;
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
	public abstract PersistentMComplexType getThis() throws PersistenceException;

	@Override
	public void initializeOnInstantiation() throws PersistenceException {
	}

	@Override
	public void copyingPrivateUserAttributes(final Anything copy) throws PersistenceException {
	}

	@Override
	public MTypeSearchList getContainedTypes(final TDObserver observer) throws PersistenceException {
		MTypeSearchList result = getThis().getContainedTypes();
		observer.updateTransientDerived(getThis(), "containedTypes", result);
		return result;
	}

	@Override
	public void initialize(final Anything This, final java.util.Hashtable<String, Object> final$$Fields)
			throws PersistenceException {
		this.setThis((PersistentMComplexType) This);
		if (this.equals(This)) {
		}
	}

	@Override
	public void initializeOnCreation() throws PersistenceException {
	}

	@Override
	public String fetchName() throws PersistenceException {
		StringBuilder builder = new StringBuilder();

		builder.append("(");
		Iterator<PersistentMType> iterator = this.getContainedTypes().iterator();
		if (iterator.hasNext()) {
			builder.append(iterator.next().fetchName());
		}

		while (iterator.hasNext()) {
			PersistentMType persistentMType = iterator.next();
			builder.append(this.getThis().fetchTypeLinkOperator());
			builder.append(persistentMType.fetchName());
		}

		builder.append(")");

		return builder.toString();
	}

	/* Start of protected part that is not overridden by persistence generator */

	protected PersistentMBoolean allChildrenAreStructuralEquivalent(final PersistentMComplexType other)
			throws PersistenceException {
		Iterator<PersistentMType> thisI = getThis().getContainedTypes().iterator();
		Iterator<PersistentMType> otherI = other.getContainedTypes().iterator();
		while (thisI.hasNext()) {
			if (!otherI.hasNext()) {
				return MFalse.getTheMFalse();
			}
			if (!thisI.next().isStructuralEquivalant(otherI.next()).toBoolean()) {
				return MFalse.getTheMFalse();
			}
		}
		return MBoolean.createFromBoolean(!otherI.hasNext());
	}
	/* End of protected part that is not overridden by persistence generator */

}

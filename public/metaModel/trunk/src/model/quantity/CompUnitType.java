package model.quantity;

import java.util.Iterator;

import model.ConsistencyException;
import model.DoubleDefinitionException;
import model.UserException;
import model.basic.MFalse;
import model.basic.MTrue;
import model.visitor.AbsUnitTypeExceptionVisitor;
import model.visitor.AbsUnitTypeReturnExceptionVisitor;
import model.visitor.AbsUnitTypeReturnVisitor;
import model.visitor.AbsUnitTypeVisitor;
import model.visitor.AnythingExceptionVisitor;
import model.visitor.AnythingReturnExceptionVisitor;
import model.visitor.AnythingReturnVisitor;
import model.visitor.AnythingVisitor;
import model.visitor.MModelItemExceptionVisitor;
import model.visitor.MModelItemReturnExceptionVisitor;
import model.visitor.MModelItemReturnVisitor;
import model.visitor.MModelItemVisitor;
import persistence.Anything;
import persistence.CompUnitTypeProxi;
import persistence.CompUnitType_RefsProxi;
import persistence.ConnectionHandler;
import persistence.MModelItemSearchList;
import persistence.PersistenceException;
import persistence.PersistentAbsUnit;
import persistence.PersistentAbsUnitType;
import persistence.PersistentCONCMModelItem;
import persistence.PersistentCompUnitType;
import persistence.PersistentMBoolean;
import persistence.PersistentMModelItem;
import persistence.PersistentReferenceType;
import persistence.PersistentUnit;
import persistence.PersistentUnitTypeManager;
import persistence.ReferenceSearchList;
import persistence.ReferenceTypeSearchList;
import persistence.TDObserver;
import constants.ExceptionConstants;

/* Additional import section end */

public class CompUnitType extends model.quantity.AbsUnitType implements PersistentCompUnitType {

	public static PersistentCompUnitType createCompUnitType(final String name) throws PersistenceException {
		return createCompUnitType(name, false);
	}

	public static PersistentCompUnitType createCompUnitType(final String name, final boolean delayed$Persistence) throws PersistenceException {
		PersistentCompUnitType result = null;
		if (delayed$Persistence) {
			result = ConnectionHandler.getTheConnectionHandler().theCompUnitTypeFacade.newDelayedCompUnitType(name);
			result.setDelayed$Persistence(true);
		} else {
			result = ConnectionHandler.getTheConnectionHandler().theCompUnitTypeFacade.newCompUnitType(name, -1);
		}
		final java.util.Hashtable<String, Object> final$$Fields = new java.util.Hashtable<String, Object>();
		final$$Fields.put("name", name);
		result.initialize(result, final$$Fields);
		result.initializeOnCreation();
		return result;
	}

	public static PersistentCompUnitType createCompUnitType(final String name, final boolean delayed$Persistence, final PersistentCompUnitType This)
			throws PersistenceException {
		PersistentCompUnitType result = null;
		if (delayed$Persistence) {
			result = ConnectionHandler.getTheConnectionHandler().theCompUnitTypeFacade.newDelayedCompUnitType(name);
			result.setDelayed$Persistence(true);
		} else {
			result = ConnectionHandler.getTheConnectionHandler().theCompUnitTypeFacade.newCompUnitType(name, -1);
		}
		final java.util.Hashtable<String, Object> final$$Fields = new java.util.Hashtable<String, Object>();
		final$$Fields.put("name", name);
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
			result.put("refs", this.getRefs().getVector(allResults, depth, essentialLevel, forGUI, tdObserver, false, essentialLevel == 0));
			final String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
			if (leaf && !allResults.contains(uniqueKey))
				allResults.put(uniqueKey, result);
		}
		return result;
	}

	@Override
	public CompUnitType provideCopy() throws PersistenceException {
		CompUnitType result = this;
		result = new CompUnitType(this.name, this.This, this.myCONCMModelItem, this.getId());
		result.refs = this.refs.copy(result);
		this.copyingPrivateUserAttributes(result);
		return result;
	}

	@Override
	public boolean hasEssentialFields() throws PersistenceException {
		return true;
	}

	protected CompUnitType_RefsProxi refs;

	public CompUnitType(final String name, final PersistentAbsUnitType This, final PersistentMModelItem myCONCMModelItem, final long id)
			throws persistence.PersistenceException {
		/* Shall not be used by clients for object construction! Use static create operation instead! */
		super(name, This, myCONCMModelItem, id);
		this.refs = new CompUnitType_RefsProxi(this);
	}

	static public long getTypeId() {
		return 114;
	}

	@Override
	public long getClassId() {
		return getTypeId();
	}

	@Override
	public void store() throws PersistenceException {
		if (!this.isDelayed$Persistence())
			return;
		if (this.getClassId() == 114)
			ConnectionHandler.getTheConnectionHandler().theCompUnitTypeFacade.newCompUnitType(name, this.getId());
		super.store();
		this.getRefs().store();

	}

	@Override
	public CompUnitType_RefsProxi getRefs() throws PersistenceException {
		return this.refs;
	}

	@Override
	public PersistentCompUnitType getThis() throws PersistenceException {
		if (this.This == null) {
			final PersistentCompUnitType result = new CompUnitTypeProxi(this.getId());
			result.getTheObject();
			return result;
		}
		return (PersistentCompUnitType) this.This;
	}

	@Override
	public void accept(final AbsUnitTypeVisitor visitor) throws PersistenceException {
		visitor.handleCompUnitType(this);
	}

	@Override
	public <R> R accept(final AbsUnitTypeReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleCompUnitType(this);
	}

	@Override
	public <E extends UserException> void accept(final AbsUnitTypeExceptionVisitor<E> visitor) throws PersistenceException, E {
		visitor.handleCompUnitType(this);
	}

	@Override
	public <R, E extends UserException> R accept(final AbsUnitTypeReturnExceptionVisitor<R, E> visitor) throws PersistenceException, E {
		return visitor.handleCompUnitType(this);
	}

	@Override
	public void accept(final MModelItemVisitor visitor) throws PersistenceException {
		visitor.handleCompUnitType(this);
	}

	@Override
	public <R> R accept(final MModelItemReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleCompUnitType(this);
	}

	@Override
	public <E extends UserException> void accept(final MModelItemExceptionVisitor<E> visitor) throws PersistenceException, E {
		visitor.handleCompUnitType(this);
	}

	@Override
	public <R, E extends UserException> R accept(final MModelItemReturnExceptionVisitor<R, E> visitor) throws PersistenceException, E {
		return visitor.handleCompUnitType(this);
	}

	@Override
	public void accept(final AnythingVisitor visitor) throws PersistenceException {
		visitor.handleCompUnitType(this);
	}

	@Override
	public <R> R accept(final AnythingReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleCompUnitType(this);
	}

	@Override
	public <E extends UserException> void accept(final AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
		visitor.handleCompUnitType(this);
	}

	@Override
	public <R, E extends UserException> R accept(final AnythingReturnExceptionVisitor<R, E> visitor) throws PersistenceException, E {
		return visitor.handleCompUnitType(this);
	}

	@Override
	public int getLeafInfo() throws PersistenceException {
		if (this.getRefs().getLength() > 0)
			return 1;
		return 0;
	}

	@Override
	public void initialize(final Anything This, final java.util.Hashtable<String, Object> final$$Fields) throws PersistenceException {
		this.setThis((PersistentCompUnitType) This);
		if (this.equals(This)) {
			final PersistentCONCMModelItem myCONCMModelItem = model.CONCMModelItem.createCONCMModelItem(this.isDelayed$Persistence(),
					(PersistentCompUnitType) This);
			this.setMyCONCMModelItem(myCONCMModelItem);
			this.setName((String) final$$Fields.get("name"));
		}
	}

	// Start of section that contains operations that must be implemented.

	@Override
	public void copyingPrivateUserAttributes(final Anything copy) throws PersistenceException {
		// implement method: copyingPrivateUserAttributes

	}

	@Override
	public void delete() throws model.ConsistencyException, PersistenceException {
		throw new ConsistencyException(ExceptionConstants.DONT_DELETE_UNITTYPE);
	}

	@Override
	public PersistentAbsUnit fetchDefaultUnit() throws model.ConsistencyException, PersistenceException {
		final PersistentUnitTypeManager unitTypeManager = UnitTypeManager.getTheUnitTypeManager();
		PersistentAbsUnit result = unitTypeManager.fetchScalar();
		if (getThis().getRefs().getLength() != 0) {
			final ReferenceSearchList refs = new ReferenceSearchList();
			final Iterator<PersistentReferenceType> i = getThis().getRefs().iterator();
			String name = "";
			while (i.hasNext()) {
				final PersistentReferenceType next = i.next();
				refs.add(unitTypeManager.fetchReference((PersistentUnit) next.getRef().fetchDefaultUnit(), next.getExponent()));
				if (name != "") {
					name += " * ";
				}
				name += next.getRef().toString() + "^" + next.getExponent();
			}
			try {
				result = unitTypeManager.fetchCU("", refs);
			} catch (final DoubleDefinitionException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	@Override
	public MModelItemSearchList fetchDependentItems() throws PersistenceException {
		// TODO: implement method: fetchDependentItems
		try {
			throw new java.lang.UnsupportedOperationException("Method \"fetchDependentItems\" not implemented yet.");
		} catch (final java.lang.UnsupportedOperationException uoe) {
			uoe.printStackTrace();
			throw uoe;
		}
	}

	@Override
	public PersistentMBoolean hasReferences(final ReferenceTypeSearchList refs) throws PersistenceException {
		final Iterator<PersistentReferenceType> refsIterator = refs.iterator();

		// leere ReferenceTypeList ist immer enthalten (sinnvoll?)
		if (!refsIterator.hasNext()) {
			return MTrue.getTheMTrue();
		}

		PersistentMBoolean result = MFalse.getTheMFalse();
		while (refsIterator.hasNext()) {
			final PersistentReferenceType ref = refsIterator.next();
			final Iterator<PersistentReferenceType> myRefIterator = getThis().getRefs().iterator();
			while (myRefIterator.hasNext()) {
				final PersistentReferenceType myRef = myRefIterator.next();
				if (ref.equals(myRef)) {
					result = MTrue.getTheMTrue();
					break;
				} else {
					result = MFalse.getTheMFalse();
				}
			}
			if (!result.toBoolean()) {
				break;
			}
		}

		return result;
	}

	@Override
	public void initializeOnCreation() throws PersistenceException {
	}

	@Override
	public void initializeOnInstantiation() throws PersistenceException {
		// implement method: initializeOnInstantiation

	}

	@Override
	public void prepareForDeletion() throws model.ConsistencyException, PersistenceException {
		// TODO: implement method: prepareForDeletion

	}

	// Start of section that contains overridden operations only.

	/* Start of protected part that is not overridden by persistence generator */

	/* End of protected part that is not overridden by persistence generator */

}

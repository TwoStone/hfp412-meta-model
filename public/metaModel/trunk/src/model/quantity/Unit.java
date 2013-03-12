package model.quantity;

import model.ConsistencyException;
import model.UserException;
import model.visitor.AbsUnitExceptionVisitor;
import model.visitor.AbsUnitReturnExceptionVisitor;
import model.visitor.AbsUnitReturnVisitor;
import model.visitor.AbsUnitVisitor;
import model.visitor.AnythingExceptionVisitor;
import model.visitor.AnythingReturnExceptionVisitor;
import model.visitor.AnythingReturnVisitor;
import model.visitor.AnythingVisitor;
import model.visitor.MModelItemExceptionVisitor;
import model.visitor.MModelItemReturnExceptionVisitor;
import model.visitor.MModelItemReturnVisitor;
import model.visitor.MModelItemVisitor;
import persistence.AbstractPersistentRoot;
import persistence.Anything;
import persistence.ConnectionHandler;
import persistence.MModelItemSearchList;
import persistence.PersistenceException;
import persistence.PersistentAbsUnit;
import persistence.PersistentAbsUnitType;
import persistence.PersistentCONCMModelItem;
import persistence.PersistentConversion;
import persistence.PersistentMModelItem;
import persistence.PersistentUnit;
import persistence.TDObserver;
import persistence.UnitProxi;
import constants.ExceptionConstants;

/* Additional import section end */

public class Unit extends model.quantity.AbsUnit implements PersistentUnit {

	public static PersistentUnit createUnit(final PersistentAbsUnitType type, final String name) throws PersistenceException {
		return createUnit(type, name, false);
	}

	public static PersistentUnit createUnit(final PersistentAbsUnitType type, final String name, final boolean delayed$Persistence)
			throws PersistenceException {
		PersistentUnit result = null;
		if (delayed$Persistence) {
			result = ConnectionHandler.getTheConnectionHandler().theUnitFacade.newDelayedUnit(name);
			result.setDelayed$Persistence(true);
		} else {
			result = ConnectionHandler.getTheConnectionHandler().theUnitFacade.newUnit(name, -1);
		}
		final java.util.Hashtable<String, Object> final$$Fields = new java.util.Hashtable<String, Object>();
		final$$Fields.put("type", type);
		final$$Fields.put("name", name);
		result.initialize(result, final$$Fields);
		result.initializeOnCreation();
		return result;
	}

	public static PersistentUnit createUnit(final PersistentAbsUnitType type, final String name, final boolean delayed$Persistence,
			final PersistentUnit This) throws PersistenceException {
		PersistentUnit result = null;
		if (delayed$Persistence) {
			result = ConnectionHandler.getTheConnectionHandler().theUnitFacade.newDelayedUnit(name);
			result.setDelayed$Persistence(true);
		} else {
			result = ConnectionHandler.getTheConnectionHandler().theUnitFacade.newUnit(name, -1);
		}
		final java.util.Hashtable<String, Object> final$$Fields = new java.util.Hashtable<String, Object>();
		final$$Fields.put("type", type);
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
			final AbstractPersistentRoot myConversion = this.getMyConversion();
			if (myConversion != null) {
				result.put("myConversion", myConversion.createProxiInformation(false, essentialLevel == 0));
				if (depth > 1) {
					myConversion.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true, tdObserver);
				} else {
					if (forGUI && myConversion.hasEssentialFields())
						myConversion.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
				}
			}
			final String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
			if (leaf && !allResults.contains(uniqueKey))
				allResults.put(uniqueKey, result);
		}
		return result;
	}

	@Override
	public Unit provideCopy() throws PersistenceException {
		Unit result = this;
		result = new Unit(this.type, this.name, this.This, this.myCONCMModelItem, this.getId());
		this.copyingPrivateUserAttributes(result);
		return result;
	}

	@Override
	public boolean hasEssentialFields() throws PersistenceException {
		return true;
	}

	public Unit(final PersistentAbsUnitType type, final String name, final PersistentAbsUnit This, final PersistentMModelItem myCONCMModelItem,
			final long id) throws persistence.PersistenceException {
		/* Shall not be used by clients for object construction! Use static create operation instead! */
		super(type, name, This, myCONCMModelItem, id);
	}

	static public long getTypeId() {
		return 124;
	}

	@Override
	public long getClassId() {
		return getTypeId();
	}

	@Override
	public void store() throws PersistenceException {
		if (!this.isDelayed$Persistence())
			return;
		if (this.getClassId() == 124)
			ConnectionHandler.getTheConnectionHandler().theUnitFacade.newUnit(name, this.getId());
		super.store();

	}

	@Override
	public PersistentUnit getThis() throws PersistenceException {
		if (this.This == null) {
			final PersistentUnit result = new UnitProxi(this.getId());
			result.getTheObject();
			return result;
		}
		return (PersistentUnit) this.This;
	}

	@Override
	public void accept(final AbsUnitVisitor visitor) throws PersistenceException {
		visitor.handleUnit(this);
	}

	@Override
	public <R> R accept(final AbsUnitReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleUnit(this);
	}

	@Override
	public <E extends UserException> void accept(final AbsUnitExceptionVisitor<E> visitor) throws PersistenceException, E {
		visitor.handleUnit(this);
	}

	@Override
	public <R, E extends UserException> R accept(final AbsUnitReturnExceptionVisitor<R, E> visitor) throws PersistenceException, E {
		return visitor.handleUnit(this);
	}

	@Override
	public void accept(final MModelItemVisitor visitor) throws PersistenceException {
		visitor.handleUnit(this);
	}

	@Override
	public <R> R accept(final MModelItemReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleUnit(this);
	}

	@Override
	public <E extends UserException> void accept(final MModelItemExceptionVisitor<E> visitor) throws PersistenceException, E {
		visitor.handleUnit(this);
	}

	@Override
	public <R, E extends UserException> R accept(final MModelItemReturnExceptionVisitor<R, E> visitor) throws PersistenceException, E {
		return visitor.handleUnit(this);
	}

	@Override
	public void accept(final AnythingVisitor visitor) throws PersistenceException {
		visitor.handleUnit(this);
	}

	@Override
	public <R> R accept(final AnythingReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleUnit(this);
	}

	@Override
	public <E extends UserException> void accept(final AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
		visitor.handleUnit(this);
	}

	@Override
	public <R, E extends UserException> R accept(final AnythingReturnExceptionVisitor<R, E> visitor) throws PersistenceException, E {
		return visitor.handleUnit(this);
	}

	@Override
	public int getLeafInfo() throws PersistenceException {
		if (this.getMyConversion() != null)
			return 1;
		return 0;
	}

	@Override
	public PersistentConversion getMyConversion() throws PersistenceException {
		PersistentConversion result = null;
		try {
			if (result == null)
				result = ConnectionHandler.getTheConnectionHandler().theConversionFacade.inverseGetSource(this.getId(), this.getClassId()).iterator()
						.next();
		} catch (final java.util.NoSuchElementException nsee) {
		}
		return result;
	}

	// Start of section that contains operations that must be implemented.

	@Override
	public void initialize(final Anything This, final java.util.Hashtable<String, Object> final$$Fields) throws PersistenceException {
		this.setThis((PersistentUnit) This);
		if (this.equals(This)) {
			final PersistentCONCMModelItem myCONCMModelItem = model.CONCMModelItem.createCONCMModelItem(this.isDelayed$Persistence(),
					(PersistentUnit) This);
			this.setMyCONCMModelItem(myCONCMModelItem);
			this.setType((PersistentAbsUnitType) final$$Fields.get("type"));
			this.setName((String) final$$Fields.get("name"));
		}
	}

	@Override
	public void copyingPrivateUserAttributes(final Anything copy) throws PersistenceException {
		// TODO: implement method: copyingPrivateUserAttributes

	}

	@Override
	public void delete() throws model.ConsistencyException, PersistenceException {
		throw new ConsistencyException(ExceptionConstants.DONT_DELETE_UNIT);
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
	public void initializeOnCreation() throws PersistenceException {
		// TODO: implement method: initializeOnCreation

	}

	@Override
	public void initializeOnInstantiation() throws PersistenceException {
		// TODO: implement method: initializeOnInstantiation

	}

	@Override
	public void prepareForDeletion() throws model.ConsistencyException, PersistenceException {
		// TODO: implement method: prepareForDeletion

	}

	// Start of section that contains overridden operations only.

	/* Start of protected part that is not overridden by persistence generator */

	/* End of protected part that is not overridden by persistence generator */

}

package model.measurement;

import model.UserException;
import model.visitor.AbsQuantityReturnVisitor;
import model.visitor.AnythingExceptionVisitor;
import model.visitor.AnythingReturnExceptionVisitor;
import model.visitor.AnythingReturnVisitor;
import model.visitor.AnythingVisitor;
import model.visitor.MModelItemExceptionVisitor;
import model.visitor.MModelItemReturnExceptionVisitor;
import model.visitor.MModelItemReturnVisitor;
import model.visitor.MModelItemVisitor;
import model.visitor.QuantifObjectExceptionVisitor;
import model.visitor.QuantifObjectReturnExceptionVisitor;
import model.visitor.QuantifObjectReturnVisitor;
import model.visitor.QuantifObjectVisitor;
import persistence.AbstractPersistentRoot;
import persistence.Anything;
import persistence.ConnectionHandler;
import persistence.MModelItemSearchList;
import persistence.MeasurementProxi;
import persistence.MeasurementSearchList;
import persistence.PersistenceException;
import persistence.PersistentAbsQuantity;
import persistence.PersistentAbsUnitType;
import persistence.PersistentAccount;
import persistence.PersistentAggregationStrategy;
import persistence.PersistentCONCMModelItem;
import persistence.PersistentCompoundQuantity;
import persistence.PersistentMMeasurementType;
import persistence.PersistentMModelItem;
import persistence.PersistentMObject;
import persistence.PersistentMeasurement;
import persistence.PersistentProxi;
import persistence.PersistentQuantifObject;
import persistence.PersistentQuantity;
import persistence.Predcate;
import persistence.TDObserver;
import constants.ExceptionConstants;

/* Additional import section end */

public class Measurement extends model.measurement.QuantifObject implements PersistentMeasurement {

	public static PersistentMeasurement createMeasurement(final PersistentMObject object, final PersistentMMeasurementType type,
			final PersistentAbsQuantity quantity) throws PersistenceException {
		return createMeasurement(object, type, quantity, false);
	}

	public static PersistentMeasurement createMeasurement(final PersistentMObject object, final PersistentMMeasurementType type,
			final PersistentAbsQuantity quantity, final boolean delayed$Persistence) throws PersistenceException {
		PersistentMeasurement result = null;
		if (delayed$Persistence) {
			result = ConnectionHandler.getTheConnectionHandler().theMeasurementFacade.newDelayedMeasurement();
			result.setDelayed$Persistence(true);
		} else {
			result = ConnectionHandler.getTheConnectionHandler().theMeasurementFacade.newMeasurement(-1);
		}
		final java.util.Hashtable<String, Object> final$$Fields = new java.util.Hashtable<String, Object>();
		final$$Fields.put("object", object);
		final$$Fields.put("type", type);
		final$$Fields.put("quantity", quantity);
		result.initialize(result, final$$Fields);
		result.initializeOnCreation();
		return result;
	}

	public static PersistentMeasurement createMeasurement(final PersistentMObject object, final PersistentMMeasurementType type,
			final PersistentAbsQuantity quantity, final boolean delayed$Persistence, final PersistentMeasurement This) throws PersistenceException {
		PersistentMeasurement result = null;
		if (delayed$Persistence) {
			result = ConnectionHandler.getTheConnectionHandler().theMeasurementFacade.newDelayedMeasurement();
			result.setDelayed$Persistence(true);
		} else {
			result = ConnectionHandler.getTheConnectionHandler().theMeasurementFacade.newMeasurement(-1);
		}
		final java.util.Hashtable<String, Object> final$$Fields = new java.util.Hashtable<String, Object>();
		final$$Fields.put("object", object);
		final$$Fields.put("type", type);
		final$$Fields.put("quantity", quantity);
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
			final AbstractPersistentRoot type = this.getType();
			if (type != null) {
				result.put("type", type.createProxiInformation(false, essentialLevel == 0));
				if (depth > 1) {
					type.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true, tdObserver);
				} else {
					if (forGUI && type.hasEssentialFields())
						type.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
				}
			}
			final AbstractPersistentRoot quantity = this.getQuantity();
			if (quantity != null) {
				result.put("quantity", quantity.createProxiInformation(false, essentialLevel == 0));
				if (depth > 1) {
					quantity.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true, tdObserver);
				} else {
					if (forGUI && quantity.hasEssentialFields())
						quantity.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
				}
			}
			final String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
			if (leaf && !allResults.contains(uniqueKey))
				allResults.put(uniqueKey, result);
		}
		return result;
	}

	@Override
	public Measurement provideCopy() throws PersistenceException {
		Measurement result = this;
		result = new Measurement(this.object, this.This, this.myCONCMModelItem, this.type, this.quantity, this.getId());
		this.copyingPrivateUserAttributes(result);
		return result;
	}

	@Override
	public boolean hasEssentialFields() throws PersistenceException {
		return true;
	}

	protected PersistentMMeasurementType type;
	protected PersistentAbsQuantity quantity;

	public Measurement(final PersistentMObject object, final PersistentQuantifObject This, final PersistentMModelItem myCONCMModelItem,
			final PersistentMMeasurementType type, final PersistentAbsQuantity quantity, final long id) throws persistence.PersistenceException {
		/* Shall not be used by clients for object construction! Use static create operation instead! */
		super(object, This, myCONCMModelItem, id);
		this.type = type;
		this.quantity = quantity;
	}

	static public long getTypeId() {
		return 116;
	}

	@Override
	public long getClassId() {
		return getTypeId();
	}

	@Override
	public void store() throws PersistenceException {
		if (!this.isDelayed$Persistence())
			return;
		if (this.getClassId() == 116)
			ConnectionHandler.getTheConnectionHandler().theMeasurementFacade.newMeasurement(this.getId());
		super.store();
		if (this.getType() != null) {
			this.getType().store();
			ConnectionHandler.getTheConnectionHandler().theMeasurementFacade.typeSet(this.getId(), getType());
		}
		if (this.getQuantity() != null) {
			this.getQuantity().store();
			ConnectionHandler.getTheConnectionHandler().theMeasurementFacade.quantitySet(this.getId(), getQuantity());
		}

	}

	@Override
	public PersistentMMeasurementType getType() throws PersistenceException {
		return this.type;
	}

	@Override
	public void setType(final PersistentMMeasurementType newValue) throws PersistenceException {
		if (newValue == null)
			throw new PersistenceException("Null values not allowed!", 0);
		if (newValue.equals(this.type))
			return;
		final long objectId = newValue.getId();
		final long classId = newValue.getClassId();
		this.type = (PersistentMMeasurementType) PersistentProxi.createProxi(objectId, classId);
		if (!this.isDelayed$Persistence()) {
			newValue.store();
			ConnectionHandler.getTheConnectionHandler().theMeasurementFacade.typeSet(this.getId(), newValue);
		}
	}

	@Override
	public PersistentAbsQuantity getQuantity() throws PersistenceException {
		return this.quantity;
	}

	@Override
	public void setQuantity(final PersistentAbsQuantity newValue) throws PersistenceException {
		if (newValue == null)
			throw new PersistenceException("Null values not allowed!", 0);
		if (newValue.equals(this.quantity))
			return;
		final long objectId = newValue.getId();
		final long classId = newValue.getClassId();
		this.quantity = (PersistentAbsQuantity) PersistentProxi.createProxi(objectId, classId);
		if (!this.isDelayed$Persistence()) {
			newValue.store();
			ConnectionHandler.getTheConnectionHandler().theMeasurementFacade.quantitySet(this.getId(), newValue);
		}
	}

	@Override
	public PersistentMeasurement getThis() throws PersistenceException {
		if (this.This == null) {
			final PersistentMeasurement result = new MeasurementProxi(this.getId());
			result.getTheObject();
			return result;
		}
		return (PersistentMeasurement) this.This;
	}

	@Override
	public void accept(final QuantifObjectVisitor visitor) throws PersistenceException {
		visitor.handleMeasurement(this);
	}

	@Override
	public <R> R accept(final QuantifObjectReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleMeasurement(this);
	}

	@Override
	public <E extends UserException> void accept(final QuantifObjectExceptionVisitor<E> visitor) throws PersistenceException, E {
		visitor.handleMeasurement(this);
	}

	@Override
	public <R, E extends UserException> R accept(final QuantifObjectReturnExceptionVisitor<R, E> visitor) throws PersistenceException, E {
		return visitor.handleMeasurement(this);
	}

	@Override
	public void accept(final MModelItemVisitor visitor) throws PersistenceException {
		visitor.handleMeasurement(this);
	}

	@Override
	public <R> R accept(final MModelItemReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleMeasurement(this);
	}

	@Override
	public <E extends UserException> void accept(final MModelItemExceptionVisitor<E> visitor) throws PersistenceException, E {
		visitor.handleMeasurement(this);
	}

	@Override
	public <R, E extends UserException> R accept(final MModelItemReturnExceptionVisitor<R, E> visitor) throws PersistenceException, E {
		return visitor.handleMeasurement(this);
	}

	@Override
	public void accept(final AnythingVisitor visitor) throws PersistenceException {
		visitor.handleMeasurement(this);
	}

	@Override
	public <R> R accept(final AnythingReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleMeasurement(this);
	}

	@Override
	public <E extends UserException> void accept(final AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
		visitor.handleMeasurement(this);
	}

	@Override
	public <R, E extends UserException> R accept(final AnythingReturnExceptionVisitor<R, E> visitor) throws PersistenceException, E {
		return visitor.handleMeasurement(this);
	}

	@Override
	public int getLeafInfo() throws PersistenceException {
		if (this.getObject() != null)
			return 1;
		if (this.getType() != null)
			return 1;
		if (this.getQuantity() != null)
			return 1;
		return 0;
	}

	@Override
	public void initialize(final Anything This, final java.util.Hashtable<String, Object> final$$Fields) throws PersistenceException {
		this.setThis((PersistentMeasurement) This);
		if (this.equals(This)) {
			final PersistentCONCMModelItem myCONCMModelItem = model.CONCMModelItem.createCONCMModelItem(this.isDelayed$Persistence(),
					(PersistentMeasurement) This);
			this.setMyCONCMModelItem(myCONCMModelItem);
			this.setObject((PersistentMObject) final$$Fields.get("object"));
			this.setType((PersistentMMeasurementType) final$$Fields.get("type"));
			this.setQuantity((PersistentAbsQuantity) final$$Fields.get("quantity"));
		}
	}

	// Start of section that contains operations that must be implemented.

	@Override
	public PersistentAccount inverseGetEntries() throws PersistenceException {
		PersistentAccount result = null;
		try {
			if (result == null)
				result = ConnectionHandler.getTheConnectionHandler().theAccountFacade.inverseGetEntries(this.getId(), this.getClassId()).iterator()
						.next();
		} catch (final java.util.NoSuchElementException nsee) {
		}
		return result;
	}

	@Override
	public void copyingPrivateUserAttributes(final Anything copy) throws PersistenceException {
	}

	@Override
	public MModelItemSearchList fetchDependentItems() throws PersistenceException {
		final MModelItemSearchList result = new MModelItemSearchList();
		return result;
	}

	@Override
	public void initializeOnCreation() throws PersistenceException {
		// Prüfen, ob m aus Measurement : m.quantity.unit.type = m.type.unitType
		final PersistentAbsUnitType unitType = this.getThis().getQuantity().accept(new AbsQuantityReturnVisitor<PersistentAbsUnitType>() {
			@Override
			public PersistentAbsUnitType handleCompoundQuantity(final PersistentCompoundQuantity compoundQuantity) throws PersistenceException {
				return compoundQuantity.getParts().findFirst(new Predcate<PersistentQuantity>() {
					@Override
					public boolean test(final PersistentQuantity argument) throws PersistenceException {
						return true;
					}
				}).getUnit().getType();
			}

			@Override
			public PersistentAbsUnitType handleQuantity(final PersistentQuantity quantity) throws PersistenceException {
				return quantity.getUnit().getType();
			}
		});
		if (!this.getThis().getType().getUnitType().equals(unitType)) {
			throw new PersistenceException(ExceptionConstants.UNIT_TYPE_DOES_NOT_MATCH_MEASUREMENT_QUANTITY, 0);
		}
	}

	@Override
	public void initializeOnInstantiation() throws PersistenceException {
	}

	@Override
	public void prepareForDeletion() throws model.ConsistencyException, PersistenceException {
		// TODO: implement method: prepareForDeletion

	}

	// Start of section that contains overridden operations only.

	@Override
	public PersistentAbsQuantity aggregate(final PersistentAggregationStrategy strategy) throws model.ConsistencyException,
			model.NotComputableException, PersistenceException {
		final MeasurementSearchList measurements = new MeasurementSearchList();
		measurements.add(this.getThis());
		return strategy.aggregateMeasurements(this.getThis().getType().getUnitType(), measurements);
	}

	/* Start of protected part that is not overridden by persistence generator */

	/* End of protected part that is not overridden by persistence generator */

}

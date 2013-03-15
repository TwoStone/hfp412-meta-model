package model.measurement;

import model.UserException;
import model.visitor.AnythingExceptionVisitor;
import model.visitor.AnythingReturnExceptionVisitor;
import model.visitor.AnythingReturnVisitor;
import model.visitor.AnythingVisitor;
import persistence.Anything;
import persistence.ConnectionHandler;
import persistence.Invoker;
import persistence.MeasurementTypeManagerProxi;
import persistence.MeasurementTypeManager_MeasurementTypesProxi;
import persistence.PersistenceException;
import persistence.PersistentCreateMeasurementTypeCommand;
import persistence.PersistentDeleteMeasurementTypeCommand;
import persistence.PersistentMMeasurementType;
import persistence.PersistentMType;
import persistence.PersistentMeasurementTypeManager;
import persistence.PersistentObject;
import persistence.PersistentProxi;
import persistence.PersistentUnitType;
import persistence.Predcate;
import persistence.TDObserver;

/* Additional import section end */

public class MeasurementTypeManager extends PersistentObject implements PersistentMeasurementTypeManager {

	private static PersistentMeasurementTypeManager theMeasurementTypeManager = null;
	public static boolean reset$For$Test = false;
	private static final Object $$lock = new Object();

	public static PersistentMeasurementTypeManager getTheMeasurementTypeManager() throws PersistenceException {
		if (theMeasurementTypeManager == null || reset$For$Test) {
			class Initializer implements Runnable {
				PersistenceException exception = null;

				@Override
				public void run() {
					try {
						MeasurementTypeManagerProxi proxi = null;
						synchronized ($$lock) {
							proxi = ConnectionHandler.getTheConnectionHandler().theMeasurementTypeManagerFacade.getTheMeasurementTypeManager();
							theMeasurementTypeManager = proxi;
						}
						if (proxi.getId() < 0) {
							proxi.setId(proxi.getId() * -1);
							proxi.initialize(proxi, new java.util.Hashtable<String, Object>());
							proxi.initializeOnCreation();
						}
					} catch (final PersistenceException e) {
						exception = e;
					}
					synchronized ($$lock) {
						$$lock.notify();
					}
				}

				PersistentMeasurementTypeManager getResult() throws PersistenceException {
					if (exception != null)
						throw exception;
					return theMeasurementTypeManager;
				}
			}
			synchronized ($$lock) {
				reset$For$Test = false;
				final Initializer initializer = new Initializer();
				new Thread(initializer).start();
				try {
					$$lock.wait();
				} catch (final InterruptedException e) {
				} // Need not to be interrupted
				return initializer.getResult();
			}
		}
		return theMeasurementTypeManager;
	}

	@Override
	public java.util.Hashtable<String, Object> toHashtable(final java.util.Hashtable<String, Object> allResults, final int depth,
			final int essentialLevel, final boolean forGUI, final boolean leaf, final TDObserver tdObserver) throws PersistenceException {
		java.util.Hashtable<String, Object> result = null;
		if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth) {
			result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
			result.put("measurementTypes",
					this.getMeasurementTypes().getVector(allResults, depth, essentialLevel, forGUI, tdObserver, false, essentialLevel == 0));
			final String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
			if (leaf && !allResults.contains(uniqueKey))
				allResults.put(uniqueKey, result);
		}
		return result;
	}

	@Override
	public MeasurementTypeManager provideCopy() throws PersistenceException {
		MeasurementTypeManager result = this;
		result = new MeasurementTypeManager(this.This, this.getId());
		result.measurementTypes = this.measurementTypes.copy(result);
		this.copyingPrivateUserAttributes(result);
		return result;
	}

	@Override
	public boolean hasEssentialFields() throws PersistenceException {
		return false;
	}

	protected MeasurementTypeManager_MeasurementTypesProxi measurementTypes;
	protected PersistentMeasurementTypeManager This;

	public MeasurementTypeManager(final PersistentMeasurementTypeManager This, final long id) throws persistence.PersistenceException {
		/* Shall not be used by clients for object construction! Use static create operation instead! */
		super(id);
		this.measurementTypes = new MeasurementTypeManager_MeasurementTypesProxi(this);
		if (This != null && !(this.equals(This)))
			this.This = This;
	}

	static public long getTypeId() {
		return 186;
	}

	@Override
	public long getClassId() {
		return getTypeId();
	}

	@Override
	public void store() throws PersistenceException {
		// Singletons cannot be delayed!
	}

	@Override
	public MeasurementTypeManager_MeasurementTypesProxi getMeasurementTypes() throws PersistenceException {
		return this.measurementTypes;
	}

	protected void setThis(final PersistentMeasurementTypeManager newValue) throws PersistenceException {
		if (newValue == null)
			throw new PersistenceException("Null values not allowed!", 0);
		if (newValue.equals(this)) {
			this.This = null;
			return;
		}
		if (newValue.equals(this.This))
			return;
		final long objectId = newValue.getId();
		final long classId = newValue.getClassId();
		this.This = (PersistentMeasurementTypeManager) PersistentProxi.createProxi(objectId, classId);
		if (!this.isDelayed$Persistence()) {
			newValue.store();
			ConnectionHandler.getTheConnectionHandler().theMeasurementTypeManagerFacade.ThisSet(this.getId(), newValue);
		}
	}

	@Override
	public PersistentMeasurementTypeManager getThis() throws PersistenceException {
		if (this.This == null) {
			final PersistentMeasurementTypeManager result = new MeasurementTypeManagerProxi(this.getId());
			result.getTheObject();
			return result;
		}
		return this.This;
	}

	@Override
	public void accept(final AnythingVisitor visitor) throws PersistenceException {
		visitor.handleMeasurementTypeManager(this);
	}

	@Override
	public <R> R accept(final AnythingReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleMeasurementTypeManager(this);
	}

	@Override
	public <E extends UserException> void accept(final AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
		visitor.handleMeasurementTypeManager(this);
	}

	@Override
	public <R, E extends UserException> R accept(final AnythingReturnExceptionVisitor<R, E> visitor) throws PersistenceException, E {
		return visitor.handleMeasurementTypeManager(this);
	}

	@Override
	public int getLeafInfo() throws PersistenceException {
		if (this.getMeasurementTypes().getLength() > 0)
			return 1;
		return 0;
	}

	@Override
	public void createMeasurementType(final String name, final PersistentMType type, final PersistentUnitType unitType, final Invoker invoker)
			throws PersistenceException {
		final java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		final PersistentCreateMeasurementTypeCommand command = model.meta.CreateMeasurementTypeCommand.createCreateMeasurementTypeCommand(name, now,
				now);
		command.setType(type);
		command.setUnitType(unitType);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
	}

	// Start of section that contains operations that must be implemented.

	@Override
	public void deleteMeasurementType(final PersistentMMeasurementType measurementType, final Invoker invoker) throws PersistenceException {
		final java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		final PersistentDeleteMeasurementTypeCommand command = model.meta.DeleteMeasurementTypeCommand.createDeleteMeasurementTypeCommand(now, now);
		command.setMeasurementType(measurementType);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
	}

	@Override
	public void initialize(final Anything This, final java.util.Hashtable<String, Object> final$$Fields) throws PersistenceException {
		this.setThis((PersistentMeasurementTypeManager) This);
		if (this.equals(This)) {
		}
	}

	@Override
	public void copyingPrivateUserAttributes(final Anything copy) throws PersistenceException {
	}

	@Override
	public PersistentMMeasurementType createMeasurementType(final String name, final PersistentMType type, final PersistentUnitType unitType)
			throws PersistenceException {
		final PersistentMMeasurementType result = MMeasurementType.createMMeasurementType(type, unitType, name);
		this.getThis().getMeasurementTypes().add(result);
		return result;
	}

	@Override
	public void deleteMeasurementType(final PersistentMMeasurementType measurementType) throws model.ConsistencyException, PersistenceException {
		this.getThis().getMeasurementTypes().removeFirstSuccess(new Predcate<PersistentMMeasurementType>() {

			@Override
			public boolean test(final PersistentMMeasurementType argument) throws PersistenceException {
				return measurementType.equals(argument);
			}
		});
		measurementType.delete();

	}

	@Override
	public void initializeOnCreation() throws PersistenceException {

	}

	@Override
	public void initializeOnInstantiation() throws PersistenceException {

	}

	// Start of section that contains overridden operations only.

	/* Start of protected part that is not overridden by persistence generator */

	/* End of protected part that is not overridden by persistence generator */

}

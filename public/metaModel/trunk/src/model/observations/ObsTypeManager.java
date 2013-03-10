package model.observations;

import model.UserException;
import model.visitor.AnythingExceptionVisitor;
import model.visitor.AnythingReturnExceptionVisitor;
import model.visitor.AnythingReturnVisitor;
import model.visitor.AnythingVisitor;
import persistence.Anything;
import persistence.ConnectionHandler;
import persistence.Invoker;
import persistence.ObsTypeManagerProxi;
import persistence.ObsTypeManager_ObservationTypesProxi;
import persistence.PersistenceException;
import persistence.PersistentCreateObsTypeCommand;
import persistence.PersistentDeleteObsTypeCommand;
import persistence.PersistentMEnum;
import persistence.PersistentMObservationType;
import persistence.PersistentMType;
import persistence.PersistentObject;
import persistence.PersistentObsTypeManager;
import persistence.PersistentProxi;
import persistence.Predcate;
import persistence.TDObserver;

/* Additional import section end */

public class ObsTypeManager extends PersistentObject implements PersistentObsTypeManager {

	private static PersistentObsTypeManager theObsTypeManager = null;
	public static boolean reset$For$Test = false;
	private static final Object $$lock = new Object();

	public static PersistentObsTypeManager getTheObsTypeManager() throws PersistenceException {
		if (theObsTypeManager == null || reset$For$Test) {
			class Initializer implements Runnable {
				PersistenceException exception = null;

				@Override
				public void run() {
					try {
						ObsTypeManagerProxi proxi = null;
						synchronized ($$lock) {
							proxi = ConnectionHandler.getTheConnectionHandler().theObsTypeManagerFacade.getTheObsTypeManager();
							theObsTypeManager = proxi;
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

				PersistentObsTypeManager getResult() throws PersistenceException {
					if (exception != null)
						throw exception;
					return theObsTypeManager;
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
		return theObsTypeManager;
	}

	@Override
	public java.util.Hashtable<String, Object> toHashtable(final java.util.Hashtable<String, Object> allResults, final int depth,
			final int essentialLevel, final boolean forGUI, final boolean leaf, final TDObserver tdObserver) throws PersistenceException {
		java.util.Hashtable<String, Object> result = null;
		if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth) {
			result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
			result.put("observationTypes",
					this.getObservationTypes().getVector(allResults, depth, essentialLevel, forGUI, tdObserver, false, essentialLevel == 0));
			final String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
			if (leaf && !allResults.contains(uniqueKey))
				allResults.put(uniqueKey, result);
		}
		return result;
	}

	@Override
	public ObsTypeManager provideCopy() throws PersistenceException {
		ObsTypeManager result = this;
		result = new ObsTypeManager(this.This, this.getId());
		result.observationTypes = this.observationTypes.copy(result);
		this.copyingPrivateUserAttributes(result);
		return result;
	}

	@Override
	public boolean hasEssentialFields() throws PersistenceException {
		return false;
	}

	protected ObsTypeManager_ObservationTypesProxi observationTypes;
	protected PersistentObsTypeManager This;

	public ObsTypeManager(final PersistentObsTypeManager This, final long id) throws persistence.PersistenceException {
		/* Shall not be used by clients for object construction! Use static create operation instead! */
		super(id);
		this.observationTypes = new ObsTypeManager_ObservationTypesProxi(this);
		if (This != null && !(this.equals(This)))
			this.This = This;
	}

	static public long getTypeId() {
		return 361;
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
	public ObsTypeManager_ObservationTypesProxi getObservationTypes() throws PersistenceException {
		return this.observationTypes;
	}

	protected void setThis(final PersistentObsTypeManager newValue) throws PersistenceException {
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
		this.This = (PersistentObsTypeManager) PersistentProxi.createProxi(objectId, classId);
		if (!this.isDelayed$Persistence()) {
			newValue.store();
			ConnectionHandler.getTheConnectionHandler().theObsTypeManagerFacade.ThisSet(this.getId(), newValue);
		}
	}

	@Override
	public PersistentObsTypeManager getThis() throws PersistenceException {
		if (this.This == null) {
			final PersistentObsTypeManager result = new ObsTypeManagerProxi(this.getId());
			result.getTheObject();
			return result;
		}
		return this.This;
	}

	@Override
	public void accept(final AnythingVisitor visitor) throws PersistenceException {
		visitor.handleObsTypeManager(this);
	}

	@Override
	public <R> R accept(final AnythingReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleObsTypeManager(this);
	}

	@Override
	public <E extends UserException> void accept(final AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
		visitor.handleObsTypeManager(this);
	}

	@Override
	public <R, E extends UserException> R accept(final AnythingReturnExceptionVisitor<R, E> visitor) throws PersistenceException, E {
		return visitor.handleObsTypeManager(this);
	}

	@Override
	public int getLeafInfo() throws PersistenceException {
		if (this.getObservationTypes().getLength() > 0)
			return 1;
		return 0;
	}

	@Override
	public void createObsType(final String name, final PersistentMEnum enumType, final PersistentMType theType, final Invoker invoker)
			throws PersistenceException {
		final java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		final PersistentCreateObsTypeCommand command = model.meta.CreateObsTypeCommand.createCreateObsTypeCommand(name, now, now);
		command.setEnumType(enumType);
		command.setTheType(theType);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
	}

	// Start of section that contains operations that must be implemented.

	@Override
	public void deleteObsType(final PersistentMObservationType theType, final Invoker invoker) throws PersistenceException {
		final java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		final PersistentDeleteObsTypeCommand command = model.meta.DeleteObsTypeCommand.createDeleteObsTypeCommand(now, now);
		command.setTheType(theType);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
	}

	@Override
	public void initialize(final Anything This, final java.util.Hashtable<String, Object> final$$Fields) throws PersistenceException {
		this.setThis((PersistentObsTypeManager) This);
		if (this.equals(This)) {
		}
	}

	@Override
	public void copyingPrivateUserAttributes(final Anything copy) throws PersistenceException {

	}

	@Override
	public PersistentMObservationType createObsType(final String name, final PersistentMEnum enumType, final PersistentMType theType)
			throws model.DoubleDefinitionException, PersistenceException {
		if (MObservationType.getMObservationTypeByName(name).getLength() == 0) {
			final PersistentMObservationType ret = MObservationType.createMObservationType(name, enumType, theType);
			getThis().getObservationTypes().add(ret);
			return ret;
		} else {
			throw new model.DoubleDefinitionException("An observation type with name " + name + " already exists.");
		}
	}

	@Override
	public void deleteObsType(final PersistentMObservationType theType) throws model.ConsistencyException, PersistenceException {
		if (theType.fetchDependentItems().getLength() == 0) {
			getThis().getObservationTypes().removeFirstSuccess(new Predcate<PersistentMObservationType>() {

				@Override
				public boolean test(final PersistentMObservationType argument) throws PersistenceException {
					return theType.equals(argument);
				}
			});
			theType.delete();
		} else {
			throw new model.ConsistencyException("Cannot delete Observation Type because there are dependent observations");
		}

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

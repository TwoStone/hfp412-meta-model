package model.quantity;

import model.DoubleDefinitionException;
import model.NotFoundException;
import model.UserException;
import model.visitor.AnythingExceptionVisitor;
import model.visitor.AnythingReturnExceptionVisitor;
import model.visitor.AnythingReturnVisitor;
import model.visitor.AnythingVisitor;
import persistence.Anything;
import persistence.ConnectionHandler;
import persistence.FractionManagerProxi;
import persistence.FractionManager_ManagedFractionsProxi;
import persistence.Invoker;
import persistence.PersistenceException;
import persistence.PersistentAddFractionCommand;
import persistence.PersistentFractionManager;
import persistence.PersistentFractionWrapper;
import persistence.PersistentObject;
import persistence.PersistentProxi;
import persistence.TDObserver;

import common.Fraction;

import constants.ExceptionConstants;

/* Additional import section end */

public class FractionManager extends PersistentObject implements PersistentFractionManager {

	private static PersistentFractionManager theFractionManager = null;
	public static boolean reset$For$Test = false;
	private static final Object $$lock = new Object();

	public static PersistentFractionManager getTheFractionManager() throws PersistenceException {
		if (theFractionManager == null || reset$For$Test) {
			class Initializer implements Runnable {
				PersistenceException exception = null;

				@Override
				public void run() {
					try {
						FractionManagerProxi proxi = null;
						synchronized ($$lock) {
							proxi = ConnectionHandler.getTheConnectionHandler().theFractionManagerFacade.getTheFractionManager();
							theFractionManager = proxi;
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

				PersistentFractionManager getResult() throws PersistenceException {
					if (exception != null)
						throw exception;
					return theFractionManager;
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
		return theFractionManager;
	}

	@Override
	public java.util.Hashtable<String, Object> toHashtable(final java.util.Hashtable<String, Object> allResults, final int depth,
			final int essentialLevel, final boolean forGUI, final boolean leaf, final TDObserver tdObserver) throws PersistenceException {
		java.util.Hashtable<String, Object> result = null;
		if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth) {
			result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
			result.put(
					"managedFractions",
					this.getManagedFractions().getValues()
							.getVector(allResults, depth, essentialLevel, forGUI, tdObserver, false, essentialLevel == 0));
			final String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
			if (leaf && !allResults.contains(uniqueKey))
				allResults.put(uniqueKey, result);
		}
		return result;
	}

	@Override
	public FractionManager provideCopy() throws PersistenceException {
		FractionManager result = this;
		result = new FractionManager(this.This, this.getId());
		result.managedFractions = this.managedFractions.copy(result);
		this.copyingPrivateUserAttributes(result);
		return result;
	}

	@Override
	public boolean hasEssentialFields() throws PersistenceException {
		return false;
	}

	protected FractionManager_ManagedFractionsProxi managedFractions;
	protected PersistentFractionManager This;

	public FractionManager(final PersistentFractionManager This, final long id) throws persistence.PersistenceException {
		/* Shall not be used by clients for object construction! Use static create operation instead! */
		super(id);
		this.managedFractions = new FractionManager_ManagedFractionsProxi(this);
		if (This != null && !(this.equals(This)))
			this.This = This;
	}

	static public long getTypeId() {
		return 177;
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
	public FractionManager_ManagedFractionsProxi getManagedFractions() throws PersistenceException {
		return this.managedFractions;
	}

	protected void setThis(final PersistentFractionManager newValue) throws PersistenceException {
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
		this.This = (PersistentFractionManager) PersistentProxi.createProxi(objectId, classId);
		if (!this.isDelayed$Persistence()) {
			newValue.store();
			ConnectionHandler.getTheConnectionHandler().theFractionManagerFacade.ThisSet(this.getId(), newValue);
		}
	}

	@Override
	public PersistentFractionManager getThis() throws PersistenceException {
		if (this.This == null) {
			final PersistentFractionManager result = new FractionManagerProxi(this.getId());
			result.getTheObject();
			return result;
		}
		return this.This;
	}

	@Override
	public void accept(final AnythingVisitor visitor) throws PersistenceException {
		visitor.handleFractionManager(this);
	}

	@Override
	public <R> R accept(final AnythingReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleFractionManager(this);
	}

	@Override
	public <E extends UserException> void accept(final AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
		visitor.handleFractionManager(this);
	}

	@Override
	public <R, E extends UserException> R accept(final AnythingReturnExceptionVisitor<R, E> visitor) throws PersistenceException, E {
		return visitor.handleFractionManager(this);
	}

	@Override
	public int getLeafInfo() throws PersistenceException {
		if (this.getManagedFractions().getValues().getLength() > 0)
			return 1;
		return 0;
	}

	@Override
	public void addFraction(final String key, final common.Fraction newFraction, final Invoker invoker) throws PersistenceException {
		final java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		final PersistentAddFractionCommand command = model.meta.AddFractionCommand.createAddFractionCommand(key, newFraction, now, now);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
	}

	// Start of section that contains operations that must be implemented.

	@Override
	public void initialize(final Anything This, final java.util.Hashtable<String, Object> final$$Fields) throws PersistenceException {
		this.setThis((PersistentFractionManager) This);
		if (this.equals(This)) {
		}
	}

	@Override
	public void addFraction(final String key, final common.Fraction newFraction) throws model.DoubleDefinitionException, PersistenceException {
		common.Fraction preExisting;
		try {
			preExisting = getThis().getFraction(key);
			if (preExisting != null)
				throw new DoubleDefinitionException(ExceptionConstants.DDE_FRACTION + key);
		} catch (final NotFoundException e) {
			final PersistentFractionWrapper newFractionWrapper = FractionWrapper.createFractionWrapper();
			newFractionWrapper.setFraction(newFraction);
			getThis().getManagedFractions().put(key, newFractionWrapper);
		}

	}

	@Override
	public void copyingPrivateUserAttributes(final Anything copy) throws PersistenceException {
	}

	@Override
	public common.Fraction getFraction(final String key) throws model.NotFoundException, PersistenceException {

		final PersistentFractionWrapper wrapper = FractionManager.getTheFractionManager().getManagedFractions().get(key);
		if (wrapper == null)
			throw new NotFoundException(key + ExceptionConstants.NOT_FOUND);
		return wrapper.getFraction();

	}

	@Override
	public void initializeOnCreation() throws PersistenceException {
	}

	@Override
	public void initializeOnInstantiation() throws PersistenceException {
	}

	@Override
	public common.Fraction invertSign(final common.Fraction fraction) throws PersistenceException {
		try {
			return Fraction.parse("-1").mul(fraction);
		} catch (final Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

		// Start of section that contains overridden operations only.

		/* Start of protected part that is not overridden by persistence generator */

		/* End of protected part that is not overridden by persistence generator */

	}

	// Start of section that contains overridden operations only.

	/* Start of protected part that is not overridden by persistence generator */

	/* End of protected part that is not overridden by persistence generator */

}

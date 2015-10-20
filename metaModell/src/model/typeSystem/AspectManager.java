package model.typeSystem;

import model.ConsistencyException;
import model.UserException;
import model.visitor.AnythingExceptionVisitor;
import model.visitor.AnythingReturnExceptionVisitor;
import model.visitor.AnythingReturnVisitor;
import model.visitor.AnythingVisitor;
import persistence.Anything;
import persistence.AspectManagerProxi;
import persistence.AspectManager_AspectsProxi;
import persistence.ConnectionHandler;
import persistence.Invoker;
import persistence.PersistenceException;
import persistence.PersistentAspectManager;
import persistence.PersistentCreateAspectCommand;
import persistence.PersistentDeleteAspectCommand;
import persistence.PersistentMAspect;
import persistence.PersistentObject;
import persistence.PersistentProxi;
import persistence.PersistentRenameAspectCommand;
import persistence.Predcate;
import persistence.TDObserver;
import constants.ExceptionConstants;

/* Additional import section end */

public class AspectManager extends PersistentObject implements PersistentAspectManager {

	private static PersistentAspectManager theAspectManager = null;
	public static boolean reset$For$Test = false;
	private static final Object $$lock = new Object();

	public static PersistentAspectManager getTheAspectManager() throws PersistenceException {
		if (theAspectManager == null || reset$For$Test) {
			class Initializer implements Runnable {
				PersistenceException exception = null;

				@Override
				public void run() {
					try {
						AspectManagerProxi proxi = null;
						synchronized ($$lock) {
							proxi = ConnectionHandler.getTheConnectionHandler().theAspectManagerFacade.getTheAspectManager();
							theAspectManager = proxi;
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

				PersistentAspectManager getResult() throws PersistenceException {
					if (exception != null)
						throw exception;
					return theAspectManager;
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
		return theAspectManager;
	}

	@Override
	public java.util.Hashtable<String, Object> toHashtable(final java.util.Hashtable<String, Object> allResults, final int depth,
			final int essentialLevel, final boolean forGUI, final boolean leaf, final TDObserver tdObserver) throws PersistenceException {
		java.util.Hashtable<String, Object> result = null;
		if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth) {
			result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
			result.put("aspects", this.getAspects().getVector(allResults, depth, essentialLevel, forGUI, tdObserver, false, essentialLevel == 0));
			final String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
			if (leaf && !allResults.contains(uniqueKey))
				allResults.put(uniqueKey, result);
		}
		return result;
	}

	@Override
	public AspectManager provideCopy() throws PersistenceException {
		AspectManager result = this;
		result = new AspectManager(this.This, this.getId());
		result.aspects = this.aspects.copy(result);
		this.copyingPrivateUserAttributes(result);
		return result;
	}

	@Override
	public boolean hasEssentialFields() throws PersistenceException {
		return false;
	}

	protected AspectManager_AspectsProxi aspects;
	protected PersistentAspectManager This;

	public AspectManager(final PersistentAspectManager This, final long id) throws persistence.PersistenceException {
		/* Shall not be used by clients for object construction! Use static create operation instead! */
		super(id);
		this.aspects = new AspectManager_AspectsProxi(this);
		if (This != null && !(this.equals(This)))
			this.This = This;
	}

	static public long getTypeId() {
		return 138;
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
	public AspectManager_AspectsProxi getAspects() throws PersistenceException {
		return this.aspects;
	}

	protected void setThis(final PersistentAspectManager newValue) throws PersistenceException {
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
		this.This = (PersistentAspectManager) PersistentProxi.createProxi(objectId, classId);
		if (!this.isDelayed$Persistence()) {
			newValue.store();
			ConnectionHandler.getTheConnectionHandler().theAspectManagerFacade.ThisSet(this.getId(), newValue);
		}
	}

	@Override
	public PersistentAspectManager getThis() throws PersistenceException {
		if (this.This == null) {
			final PersistentAspectManager result = new AspectManagerProxi(this.getId());
			result.getTheObject();
			return result;
		}
		return this.This;
	}

	@Override
	public void accept(final AnythingVisitor visitor) throws PersistenceException {
		visitor.handleAspectManager(this);
	}

	@Override
	public <R> R accept(final AnythingReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleAspectManager(this);
	}

	@Override
	public <E extends UserException> void accept(final AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
		visitor.handleAspectManager(this);
	}

	@Override
	public <R, E extends UserException> R accept(final AnythingReturnExceptionVisitor<R, E> visitor) throws PersistenceException, E {
		return visitor.handleAspectManager(this);
	}

	@Override
	public int getLeafInfo() throws PersistenceException {
		if (this.getAspects().getLength() > 0)
			return 1;
		return 0;
	}

	@Override
	public void createAspect(final String name, final Invoker invoker) throws PersistenceException {
		final java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		final PersistentCreateAspectCommand command = model.meta.CreateAspectCommand.createCreateAspectCommand(name, now, now);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
	}

	// Start of section that contains operations that must be implemented.

	@Override
	public void deleteAspect(final PersistentMAspect aspect, final Invoker invoker) throws PersistenceException {
		final java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		final PersistentDeleteAspectCommand command = model.meta.DeleteAspectCommand.createDeleteAspectCommand(now, now);
		command.setAspect(aspect);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
	}

	@Override
	public void initialize(final Anything This, final java.util.Hashtable<String, Object> final$$Fields) throws PersistenceException {
		this.setThis((PersistentAspectManager) This);
		if (this.equals(This)) {
		}
	}

	@Override
	public void renameAspect(final PersistentMAspect aspect, final String newName, final Invoker invoker) throws PersistenceException {
		final java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		final PersistentRenameAspectCommand command = model.meta.RenameAspectCommand.createRenameAspectCommand(newName, now, now);
		command.setAspect(aspect);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
	}

	@Override
	public void copyingPrivateUserAttributes(final Anything copy) throws PersistenceException {
	}

	@Override
	public PersistentMAspect createAspect(final String name) throws model.ConsistencyException, PersistenceException {
		if (existsAspectWithName(name)) {
			throw new ConsistencyException(ExceptionConstants.CE_ASP_NAME_UNIQUE + name);
		}
		final PersistentMAspect result = MAspect.createMAspect(name);
		getThis().getAspects().add(result);
		return result;
	}

	@Override
	public void deleteAspect(final PersistentMAspect aspect) throws model.ConsistencyException, PersistenceException {
		getThis().getAspects().removeFirstSuccess(new Predcate<PersistentMAspect>() {

			@Override
			public boolean test(final PersistentMAspect argument) throws PersistenceException {
				return argument.equals(aspect);
			}
		});
		aspect.delete();
	}

	@Override
	public void initializeOnCreation() throws PersistenceException {
	}

	@Override
	public void initializeOnInstantiation() throws PersistenceException {
	}

	@Override
	public void renameAspect(final PersistentMAspect aspect, final String newName) throws model.ConsistencyException, PersistenceException {
		if (aspect.getName().equals(newName)) {
			return;
		}
		if (existsAspectWithName(newName)) {
			throw new ConsistencyException(ExceptionConstants.CE_ASP_NAME_UNIQUE + newName);
		}
		aspect.setName(newName);
	}

	// Start of section that contains overridden operations only.

	/* Start of protected part that is not overridden by persistence generator */

	private boolean existsAspectWithName(final String name) throws PersistenceException {
		return MAspect.getMAspectByName(name).getLength() > 0;
	}

	/* End of protected part that is not overridden by persistence generator */

}

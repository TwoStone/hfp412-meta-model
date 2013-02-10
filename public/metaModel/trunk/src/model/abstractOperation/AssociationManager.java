package model.abstractOperation;

import model.CycleException;
import model.UserException;
import model.visitor.AnythingExceptionVisitor;
import model.visitor.AnythingReturnExceptionVisitor;
import model.visitor.AnythingReturnVisitor;
import model.visitor.AnythingVisitor;
import persistence.Anything;
import persistence.AssociationManagerProxi;
import persistence.AssociationManager_AssociationsProxi;
import persistence.AssociationManager_HierarchiesProxi;
import persistence.ConnectionHandler;
import persistence.Invoker;
import persistence.PersistenceException;
import persistence.PersistentAddAssociationCommand;
import persistence.PersistentAssociation;
import persistence.PersistentAssociationManager;
import persistence.PersistentCreateAssociationCommand;
import persistence.PersistentCreateHierarchyCommand;
import persistence.PersistentHierarchy;
import persistence.PersistentMType;
import persistence.PersistentObject;
import persistence.PersistentProxi;
import persistence.PersistentRemoveAssoFrmHierCommand;
import persistence.PersistentRemoveAssociationCommand;
import persistence.Predcate;
import persistence.TDObserver;

/* Additional import section end */

public class AssociationManager extends PersistentObject implements PersistentAssociationManager {

	private static PersistentAssociationManager theAssociationManager = null;
	public static boolean reset$For$Test = false;
	private static final Object $$lock = new Object();

	public static PersistentAssociationManager getTheAssociationManager() throws PersistenceException {
		if (theAssociationManager == null || reset$For$Test) {
			class Initializer implements Runnable {
				PersistenceException exception = null;

				@Override
				public void run() {
					try {
						AssociationManagerProxi proxi = null;
						synchronized ($$lock) {
							proxi = ConnectionHandler.getTheConnectionHandler().theAssociationManagerFacade
									.getTheAssociationManager();
							theAssociationManager = proxi;
						}
						if (proxi.getId() < 0) {
							proxi.setId(proxi.getId() * -1);
							proxi.initialize(proxi, new java.util.Hashtable<String, Object>());
							proxi.initializeOnCreation();
						}
					} catch (PersistenceException e) {
						exception = e;
					}
					synchronized ($$lock) {
						$$lock.notify();
					}
				}

				PersistentAssociationManager getResult() throws PersistenceException {
					if (exception != null)
						throw exception;
					return theAssociationManager;
				}
			}
			synchronized ($$lock) {
				reset$For$Test = false;
				Initializer initializer = new Initializer();
				new Thread(initializer).start();
				try {
					$$lock.wait();
				} catch (InterruptedException e) {
				} // Need not to be interrupted
				return initializer.getResult();
			}
		}
		return theAssociationManager;
	}

	@Override
	public java.util.Hashtable<String, Object> toHashtable(java.util.Hashtable<String, Object> allResults, int depth,
			int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
		java.util.Hashtable<String, Object> result = null;
		if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth) {
			result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
			result.put("associations",
					this.getAssociations().getVector(allResults, depth, essentialLevel, forGUI, tdObserver, false));
			result.put("hierarchies",
					this.getHierarchies().getVector(allResults, depth, essentialLevel, forGUI, tdObserver, false));
			String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
			if (leaf && !allResults.contains(uniqueKey))
				allResults.put(uniqueKey, result);
		}
		return result;
	}

	@Override
	public AssociationManager provideCopy() throws PersistenceException {
		AssociationManager result = this;
		result = new AssociationManager(this.This, this.getId());
		result.associations = this.associations.copy(result);
		result.hierarchies = this.hierarchies.copy(result);
		this.copyingPrivateUserAttributes(result);
		return result;
	}

	@Override
	public boolean hasEssentialFields() throws PersistenceException {
		return false;
	}

	protected AssociationManager_AssociationsProxi associations;
	protected AssociationManager_HierarchiesProxi hierarchies;
	protected PersistentAssociationManager This;

	public AssociationManager(PersistentAssociationManager This, long id) throws persistence.PersistenceException {
		/* Shall not be used by clients for object construction! Use static create operation instead! */
		super(id);
		this.associations = new AssociationManager_AssociationsProxi(this);
		this.hierarchies = new AssociationManager_HierarchiesProxi(this);
		if (This != null && !(this.equals(This)))
			this.This = This;
	}

	static public long getTypeId() {
		return 154;
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
	public AssociationManager_AssociationsProxi getAssociations() throws PersistenceException {
		return this.associations;
	}

	@Override
	public AssociationManager_HierarchiesProxi getHierarchies() throws PersistenceException {
		return this.hierarchies;
	}

	protected void setThis(PersistentAssociationManager newValue) throws PersistenceException {
		if (newValue == null)
			throw new PersistenceException("Null values not allowed!", 0);
		if (newValue.equals(this)) {
			this.This = null;
			return;
		}
		if (newValue.equals(this.This))
			return;
		long objectId = newValue.getId();
		long classId = newValue.getClassId();
		this.This = (PersistentAssociationManager) PersistentProxi.createProxi(objectId, classId);
		if (!this.isDelayed$Persistence()) {
			newValue.store();
			ConnectionHandler.getTheConnectionHandler().theAssociationManagerFacade.ThisSet(this.getId(), newValue);
		}
	}

	@Override
	public PersistentAssociationManager getThis() throws PersistenceException {
		if (this.This == null) {
			PersistentAssociationManager result = new AssociationManagerProxi(this.getId());
			result.getTheObject();
			return result;
		}
		return this.This;
	}

	@Override
	public void accept(AnythingVisitor visitor) throws PersistenceException {
		visitor.handleAssociationManager(this);
	}

	@Override
	public <R> R accept(AnythingReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleAssociationManager(this);
	}

	@Override
	public <E extends UserException> void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
		visitor.handleAssociationManager(this);
	}

	@Override
	public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E> visitor)
			throws PersistenceException, E {
		return visitor.handleAssociationManager(this);
	}

	@Override
	public int getLeafInfo() throws PersistenceException {
		return (int) (0 + this.getAssociations().getLength() + this.getHierarchies().getLength());
	}

	@Override
	public void createAssociation(final PersistentMType source, final PersistentMType target, final String name)
			throws model.DoubleDefinitionException, PersistenceException {
		// TODO: implement method: createAssociation

	}

	@Override
	public void addAssociation(final PersistentHierarchy h, final PersistentAssociation a, final Invoker invoker)
			throws PersistenceException {
		java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		PersistentAddAssociationCommand command = model.meta.AddAssociationCommand
				.createAddAssociationCommand(now, now);
		command.setH(h);
		command.setA(a);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
	}

	@Override
	public void initializeOnInstantiation() throws PersistenceException {
	}

	@Override
	public void addAssociation(final PersistentHierarchy h, final PersistentAssociation a)
			throws model.DoubleDefinitionException, model.CycleException, PersistenceException {
		a.getHierarchies().add(h);
	}

	@Override
	public void removeAssoFrmHier(final PersistentHierarchy h, final PersistentAssociation a)
			throws model.NotAvailableException, model.CycleException, PersistenceException {
		a.getHierarchies().removeFirstSuccess(new Predcate<PersistentHierarchy>() {

			@Override
			public boolean test(PersistentHierarchy argument) throws PersistenceException {
				return h.equals(argument);
			}
		});
	}

	@Override
	public void initializeOnCreation() throws PersistenceException {
	}

	@Override
	public void removeAssoFrmHier(final PersistentHierarchy h, final PersistentAssociation a, final Invoker invoker)
			throws PersistenceException {
		java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		PersistentRemoveAssoFrmHierCommand command = model.meta.RemoveAssoFrmHierCommand
				.createRemoveAssoFrmHierCommand(now, now);
		command.setH(h);
		command.setA(a);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
	}

	@Override
	public void removeAssociation(final PersistentAssociation a) throws model.ConsistencyException,
			model.CycleException, PersistenceException {
		// TODO: implement method: removeAssociation

	}

	@Override
	public void createAssociation(final PersistentMType source, final PersistentMType target, final String name,
			final Invoker invoker) throws PersistenceException {
		java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		PersistentCreateAssociationCommand command = model.meta.CreateAssociationCommand
				.createCreateAssociationCommand(name, now, now);
		command.setSource(source);
		command.setTarget(target);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
	}

	@Override
	public void copyingPrivateUserAttributes(final Anything copy) throws PersistenceException {
	}

	@Override
	public void createHierarchy(final PersistentAssociation a, final String name, final Invoker invoker)
			throws PersistenceException {
		java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		PersistentCreateHierarchyCommand command = model.meta.CreateHierarchyCommand.createCreateHierarchyCommand(name,
				now, now);
		command.setA(a);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
	}

	@Override
	public void initialize(final Anything This, final java.util.Hashtable<String, Object> final$$Fields)
			throws PersistenceException {
		this.setThis((PersistentAssociationManager) This);
		if (this.equals(This)) {
		}
	}

	@Override
	public void removeAssociation(final PersistentAssociation a, final Invoker invoker) throws PersistenceException {
		java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		PersistentRemoveAssociationCommand command = model.meta.RemoveAssociationCommand
				.createRemoveAssociationCommand(now, now);
		command.setA(a);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
	}

	@Override
	public void createHierarchy(final PersistentAssociation a, final String name)
			throws model.DoubleDefinitionException, PersistenceException {
		PersistentHierarchy h = Hierarchy.createHierarchy(name);
		try {
			getThis().addAssociation(h, a);
		} catch (CycleException e) {
			// TODO Eigentlich haben wir hier gar keine Cycle! Thimo nochmal fragen...
			e.printStackTrace();
		}
		getThis().getHierarchies().add(h);
	}

	/* Start of protected part that is not overridden by persistence generator */

	/* End of protected part that is not overridden by persistence generator */

}

package model.abstractOperation;

import model.ConsistencyException;
import model.CycleException;
import model.DoubleDefinitionException;
import model.NotAvailableException;
import model.UserException;
import model.basic.MFalse;
import model.basic.MTrue;
import model.visitor.AbsOperationReturnVisitor;
import model.visitor.AnythingExceptionVisitor;
import model.visitor.AnythingReturnExceptionVisitor;
import model.visitor.AnythingReturnVisitor;
import model.visitor.AnythingVisitor;
import persistence.AbsOperationSearchList;
import persistence.Anything;
import persistence.AssociationManagerProxi;
import persistence.AssociationManager_AssociationsProxi;
import persistence.AssociationManager_HierarchiesProxi;
import persistence.ConnectionHandler;
import persistence.Invoker;
import persistence.LinkSearchList;
import persistence.PersistenceException;
import persistence.PersistentAbsOperation;
import persistence.PersistentAddAssociationCommand;
import persistence.PersistentAssociation;
import persistence.PersistentAssociationManager;
import persistence.PersistentCreateAssociationCommand;
import persistence.PersistentCreateHierarchyCommand;
import persistence.PersistentHierarchy;
import persistence.PersistentLink;
import persistence.PersistentMBoolean;
import persistence.PersistentMType;
import persistence.PersistentObject;
import persistence.PersistentOperation;
import persistence.PersistentProxi;
import persistence.PersistentRemoveAssoFrmHierCommand;
import persistence.PersistentRemoveAssociationCommand;
import persistence.PersistentRemoveHierarchyCommand;
import persistence.Predcate;
import persistence.TDObserver;
import utils.EmptyTypeDisjReturnBooleanVisitor;
import constants.ExceptionConstants;

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
							proxi = ConnectionHandler.getTheConnectionHandler().theAssociationManagerFacade.getTheAssociationManager();
							theAssociationManager = proxi;
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

				PersistentAssociationManager getResult() throws PersistenceException {
					if (exception != null)
						throw exception;
					return theAssociationManager;
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
		return theAssociationManager;
	}

	@Override
	public java.util.Hashtable<String, Object> toHashtable(final java.util.Hashtable<String, Object> allResults, final int depth,
			final int essentialLevel, final boolean forGUI, final boolean leaf, final TDObserver tdObserver) throws PersistenceException {
		java.util.Hashtable<String, Object> result = null;
		if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth) {
			result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
			result.put("associations",
					this.getAssociations().getVector(allResults, depth, essentialLevel, forGUI, tdObserver, false, essentialLevel == 0));
			result.put("hierarchies",
					this.getHierarchies().getVector(allResults, depth, essentialLevel, forGUI, tdObserver, false, essentialLevel == 0));
			final String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
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

	public AssociationManager(final PersistentAssociationManager This, final long id) throws persistence.PersistenceException {
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

	protected void setThis(final PersistentAssociationManager newValue) throws PersistenceException {
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
		this.This = (PersistentAssociationManager) PersistentProxi.createProxi(objectId, classId);
		if (!this.isDelayed$Persistence()) {
			newValue.store();
			ConnectionHandler.getTheConnectionHandler().theAssociationManagerFacade.ThisSet(this.getId(), newValue);
		}
	}

	@Override
	public PersistentAssociationManager getThis() throws PersistenceException {
		if (this.This == null) {
			final PersistentAssociationManager result = new AssociationManagerProxi(this.getId());
			result.getTheObject();
			return result;
		}
		return this.This;
	}

	@Override
	public void accept(final AnythingVisitor visitor) throws PersistenceException {
		visitor.handleAssociationManager(this);
	}

	@Override
	public <R> R accept(final AnythingReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleAssociationManager(this);
	}

	@Override
	public <E extends UserException> void accept(final AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
		visitor.handleAssociationManager(this);
	}

	@Override
	public <R, E extends UserException> R accept(final AnythingReturnExceptionVisitor<R, E> visitor) throws PersistenceException, E {
		return visitor.handleAssociationManager(this);
	}

	@Override
	public int getLeafInfo() throws PersistenceException {
		if (this.getAssociations().getLength() > 0)
			return 1;
		if (this.getHierarchies().getLength() > 0)
			return 1;
		return 0;
	}

	@Override
	public void addAssociation(final PersistentHierarchy h, final PersistentAssociation a, final Invoker invoker) throws PersistenceException {
		final java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		final PersistentAddAssociationCommand command = model.meta.AddAssociationCommand.createAddAssociationCommand(now, now);
		command.setH(h);
		command.setA(a);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
	}

	// Start of section that contains operations that must be implemented.

	@Override
	public void createAssociation(final PersistentMType source, final PersistentMType target, final String name, final Invoker invoker)
			throws PersistenceException {
		final java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		final PersistentCreateAssociationCommand command = model.meta.CreateAssociationCommand.createCreateAssociationCommand(name, now, now);
		command.setSource(source);
		command.setTarget(target);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
	}

	@Override
	public void createHierarchy(final PersistentAssociation a, final String name, final Invoker invoker) throws PersistenceException {
		final java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		final PersistentCreateHierarchyCommand command = model.meta.CreateHierarchyCommand.createCreateHierarchyCommand(name, now, now);
		command.setA(a);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
	}

	@Override
	public void initialize(final Anything This, final java.util.Hashtable<String, Object> final$$Fields) throws PersistenceException {
		this.setThis((PersistentAssociationManager) This);
		if (this.equals(This)) {
		}
	}

	@Override
	public void removeAssoFrmHier(final PersistentHierarchy h, final PersistentAssociation a, final Invoker invoker) throws PersistenceException {
		final java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		final PersistentRemoveAssoFrmHierCommand command = model.meta.RemoveAssoFrmHierCommand.createRemoveAssoFrmHierCommand(now, now);
		command.setH(h);
		command.setA(a);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
	}

	@Override
	public void removeAssociation(final PersistentAssociation a, final Invoker invoker) throws PersistenceException {
		final java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		final PersistentRemoveAssociationCommand command = model.meta.RemoveAssociationCommand.createRemoveAssociationCommand(now, now);
		command.setA(a);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
	}

	@Override
	public void removeHierarchy(final PersistentHierarchy h, final Invoker invoker) throws PersistenceException {
		final java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		final PersistentRemoveHierarchyCommand command = model.meta.RemoveHierarchyCommand.createRemoveHierarchyCommand(now, now);
		command.setH(h);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
	}

	@Override
	public void addAssociation(final PersistentHierarchy h, final PersistentAssociation a) throws model.ConsistencyException, model.CycleException,
			PersistenceException {
		// Consistency, wenn Assoc schon in Hierarchy
		if (h.getAssociations().findFirst(new Predcate<PersistentAssociation>() {
			@Override
			public boolean test(final PersistentAssociation argument) throws PersistenceException {
				return argument.equals(a);
			}
		}) != null) {
			throw new ConsistencyException(ExceptionConstants.CE_ASSOC_ALREADY_IN_HIERARCHY);
		}

		// Pruefen ob durch bestehende Links ein Zyklus entstehen wuerde
		final LinkSearchList allLinksOfAssociation = a.inverseGetType();

		final PersistentLink firstCycle = allLinksOfAssociation.findFirst(new Predcate<PersistentLink>() {

			@Override
			public boolean test(final PersistentLink argument) throws PersistenceException {
				return argument.getTarget().containsInHierarchy(argument.getSource(), h).toBoolean();
			}
		});
		if (firstCycle != null) {
			throw new CycleException(ExceptionConstants.CYCLE_ADD_ASSOC + firstCycle.toString());
		}

		a.getHierarchies().add(h);
	}

	@Override
	public void copyingPrivateUserAttributes(final Anything copy) throws PersistenceException {
	}

	@Override
	public PersistentAssociation createAssociation(final PersistentMType source, final PersistentMType target, final String name)
			throws model.DoubleDefinitionException, model.ConsistencyException, PersistenceException {
		// DoubleDefinition prüfen
		final AbsOperationSearchList absOperationWithSameName = Association.getAbsOperationByName(name);
		PersistentAbsOperation doubleDefinition = null;
		if (absOperationWithSameName != null) {
			doubleDefinition = absOperationWithSameName.findFirst(new Predcate<PersistentAbsOperation>() {

				@Override
				public boolean test(final PersistentAbsOperation argument) throws PersistenceException {
					return argument.accept(new AbsOperationReturnVisitor<PersistentMBoolean>() {

						@Override
						public PersistentMBoolean handleOperation(final PersistentOperation operation) throws PersistenceException {
							return MFalse.getTheMFalse();
						}

						@Override
						public PersistentMBoolean handleAssociation(final PersistentAssociation association) throws PersistenceException {
							return MTrue.getTheMTrue();
						}
					}).toBoolean();
				}
			});
		}

		if (doubleDefinition != null) {
			throw new DoubleDefinitionException(ExceptionConstants.DDE_ASSOC);
		}

		// Consistency, wenn source oder target = emptySum
		final EmptyTypeDisjReturnBooleanVisitor vis = new EmptyTypeDisjReturnBooleanVisitor();
		if (source.accept(vis)) {
			throw new ConsistencyException(ExceptionConstants.CE_ASSOC_WRONG_SOURCE_EMPTY_DIS);
		}
		if (target.accept(vis)) {
			throw new ConsistencyException(ExceptionConstants.CE_ASSOC_WRONG_SOURCE_EMPTY_DIS);
		}
		final PersistentAssociation a = Association.createAssociation(name, source, target);
		getThis().getAssociations().add(a);
		return a;
	}

	@Override
	public PersistentHierarchy createHierarchy(final PersistentAssociation a, final String name) throws model.DoubleDefinitionException,
			model.ConsistencyException, model.CycleException, PersistenceException {
		if (getThis().getHierarchies().findFirst(new Predcate<PersistentHierarchy>() {
			@Override
			public boolean test(final PersistentHierarchy argument) throws PersistenceException {
				return argument.getName().equals(name);
			}
		}) != null) {
			throw new DoubleDefinitionException(ExceptionConstants.DDE_HIERARCHY);
		}

		final PersistentHierarchy h = Hierarchy.createHierarchy(name);
		getThis().addAssociation(h, a);
		getThis().getHierarchies().add(h);
		return h;
	}

	@Override
	public void initializeOnCreation() throws PersistenceException {
	}

	@Override
	public void initializeOnInstantiation() throws PersistenceException {
	}

	@Override
	public void removeAssoFrmHier(final PersistentHierarchy h, final PersistentAssociation a) throws model.NotAvailableException,
			model.ConsistencyException, PersistenceException {

		// Wenn die Assoziation gar nicht in der Hierarchy ist => Exception
		final PersistentAssociation findFirst = h.getAssociations().findFirst(new Predcate<PersistentAssociation>() {

			@Override
			public boolean test(final PersistentAssociation argument) throws PersistenceException {
				return argument.equals(a);
			}
		});
		if (findFirst == null) {
			throw new NotAvailableException(ExceptionConstants.NA_IN_HIERARCHY);
		}

		// Wenn versucht wird die letzte Assoziation einer Hierarchie zu entfernen
		if (h.getAssociations().getLength() <= 1) {
			throw new ConsistencyException(ExceptionConstants.CE_LAST_ASSOC_IN_HIERARCHY);
		}

		a.getHierarchies().removeFirstSuccess(new Predcate<PersistentHierarchy>() {
			@Override
			public boolean test(final PersistentHierarchy argument) throws PersistenceException {
				return h.equals(argument);
			}
		});
	}

	@Override
	public void removeAssociation(final PersistentAssociation a) throws model.ConsistencyException, PersistenceException {
		getThis().getAssociations().removeFirstSuccess(new Predcate<PersistentAssociation>() {
			@Override
			public boolean test(final PersistentAssociation argument) throws PersistenceException {
				return a.equals(argument);
			}
		});
		a.delete();
	}

	@Override
	public void removeHierarchy(final PersistentHierarchy h) throws model.ConsistencyException, PersistenceException {
		getThis().getHierarchies().removeFirstSuccess(new Predcate<PersistentHierarchy>() {
			@Override
			public boolean test(final PersistentHierarchy argument) throws PersistenceException {
				return argument.equals(h);
			}
		});
		h.delete();
	}

	// Start of section that contains overridden operations only.

	/* Start of protected part that is not overridden by persistence generator */

	/* End of protected part that is not overridden by persistence generator */

}

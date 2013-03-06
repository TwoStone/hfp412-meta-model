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
import model.visitor.MTypeExceptionVisitor;
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
import persistence.PersistentMAtomicType;
import persistence.PersistentMBoolean;
import persistence.PersistentMEmptyTypeConjunction;
import persistence.PersistentMEmptyTypeDisjunction;
import persistence.PersistentMMixedConjunction;
import persistence.PersistentMMixedTypeDisjunction;
import persistence.PersistentMNonEmptyAtomicTypeConjunction;
import persistence.PersistentMNonEmptyDisjunctiveNormalForm;
import persistence.PersistentMType;
import persistence.PersistentObject;
import persistence.PersistentOperation;
import persistence.PersistentProxi;
import persistence.PersistentRemoveAssoFrmHierCommand;
import persistence.PersistentRemoveAssociationCommand;
import persistence.PersistentRemoveHierarchyCommand;
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
	public java.util.Hashtable<String, Object> toHashtable(final java.util.Hashtable<String, Object> allResults,
			final int depth, final int essentialLevel, final boolean forGUI, final boolean leaf,
			final TDObserver tdObserver) throws PersistenceException {
		java.util.Hashtable<String, Object> result = null;
		if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth) {
			result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
			result.put(
					"associations",
					this.getAssociations().getVector(allResults, depth, essentialLevel, forGUI, tdObserver, false,
							essentialLevel == 0));
			result.put(
					"hierarchies",
					this.getHierarchies().getVector(allResults, depth, essentialLevel, forGUI, tdObserver, false,
							essentialLevel == 0));
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

	public AssociationManager(final PersistentAssociationManager This, final long id)
			throws persistence.PersistenceException {
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
	public <E extends UserException> void accept(final AnythingExceptionVisitor<E> visitor)
			throws PersistenceException, E {
		visitor.handleAssociationManager(this);
	}

	@Override
	public <R, E extends UserException> R accept(final AnythingReturnExceptionVisitor<R, E> visitor)
			throws PersistenceException, E {
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
	public void addAssociation(final PersistentHierarchy h, final PersistentAssociation a, final Invoker invoker)
			throws PersistenceException {
		final java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		final PersistentAddAssociationCommand command = model.meta.AddAssociationCommand.createAddAssociationCommand(
				now, now);
		command.setH(h);
		command.setA(a);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
	}

	// Start of section that contains operations that must be implemented.

	@Override
	public void createAssociation(final PersistentMType source, final PersistentMType target, final String name,
			final Invoker invoker) throws PersistenceException {
		final java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		final PersistentCreateAssociationCommand command = model.meta.CreateAssociationCommand
				.createCreateAssociationCommand(name, now, now);
		command.setSource(source);
		command.setTarget(target);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
	}

	@Override
	public void createHierarchy(final PersistentAssociation a, final String name, final Invoker invoker)
			throws PersistenceException {
		final java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		final PersistentCreateHierarchyCommand command = model.meta.CreateHierarchyCommand
				.createCreateHierarchyCommand(name, now, now);
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
	public void removeAssoFrmHier(final PersistentHierarchy h, final PersistentAssociation a, final Invoker invoker)
			throws PersistenceException {
		final java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		final PersistentRemoveAssoFrmHierCommand command = model.meta.RemoveAssoFrmHierCommand
				.createRemoveAssoFrmHierCommand(now, now);
		command.setH(h);
		command.setA(a);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
	}

	@Override
	public void removeAssociation(final PersistentAssociation a, final Invoker invoker) throws PersistenceException {
		final java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		final PersistentRemoveAssociationCommand command = model.meta.RemoveAssociationCommand
				.createRemoveAssociationCommand(now, now);
		command.setA(a);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
	}

	@Override
	public void removeHierarchy(final PersistentHierarchy h, final Invoker invoker) throws PersistenceException {
		final java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		final PersistentRemoveHierarchyCommand command = model.meta.RemoveHierarchyCommand
				.createRemoveHierarchyCommand(now, now);
		command.setH(h);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
	}

	@Override
	public void addAssociation(final PersistentHierarchy h, final PersistentAssociation a)
			throws model.DoubleDefinitionException, model.ConsistencyException, model.CycleException,
			PersistenceException {
		// Consistency, wenn Assoc schon in Hierarchy
		if (h.getAssociations().findFirst(new Predcate<PersistentAssociation>() {
			@Override
			public boolean test(final PersistentAssociation argument) throws PersistenceException {
				return argument.equals(a);
			}
		}) != null) {
			throw new ConsistencyException("Eine Assoziation mit diesem Namen existiert bereits");
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
			throw new CycleException(
					"Es entstuende ein Zyklus, hinzufuegen der Assoziation zu dieser Hierarchy. Erster Zyklus durch: "
							+ firstCycle.toString());
		}

		a.getHierarchies().add(h);
	}

	@Override
	public void copyingPrivateUserAttributes(final Anything copy) throws PersistenceException {
	}

	@Override
	public PersistentAssociation createAssociation(final PersistentMType source, final PersistentMType target,
			final String name) throws model.DoubleDefinitionException, model.ConsistencyException, PersistenceException {
		// DoubleDefinition prüfen
		final AbsOperationSearchList absOperationWithSameName = Association.getAbsOperationByName(name);
		PersistentAbsOperation doubleDefinition = null;
		if (absOperationWithSameName != null) {
			doubleDefinition = absOperationWithSameName.findFirst(new Predcate<PersistentAbsOperation>() {

				@Override
				public boolean test(final PersistentAbsOperation argument) throws PersistenceException {
					return argument.accept(new AbsOperationReturnVisitor<PersistentMBoolean>() {

						@Override
						public PersistentMBoolean handleOperation(final PersistentOperation operation)
								throws PersistenceException {
							return MFalse.getTheMFalse();
						}

						@Override
						public PersistentMBoolean handleAssociation(final PersistentAssociation association)
								throws PersistenceException {
							return MTrue.getTheMTrue();
						}
					}).toBoolean();
				}
			});
		}

		if (doubleDefinition != null) {
			throw new DoubleDefinitionException("Eine Assoziation mit diesem Namen existiert bereits");
		}

		// Consistency, wenn source oder target = emptySum oder emptyProd
		checkType(source, "Quelle");
		checkType(target, "Ziel");

		final PersistentAssociation a = Association.createAssociation(name, source, target);
		getThis().getAssociations().add(a);
		return a;
	}

	@Override
	public void createHierarchy(final PersistentAssociation a, final String name)
			throws model.DoubleDefinitionException, model.ConsistencyException, model.CycleException,
			PersistenceException {
		if (getThis().getHierarchies().findFirst(new Predcate<PersistentHierarchy>() {
			@Override
			public boolean test(final PersistentHierarchy argument) throws PersistenceException {
				return argument.getName().equals(name);
			}
		}) != null) {
			throw new DoubleDefinitionException("Eine Hierarchie mit dem Namen '" + name + "'existiert bereits.");
		}

		final PersistentHierarchy h = Hierarchy.createHierarchy(name);
		getThis().addAssociation(h, a);
		getThis().getHierarchies().add(h);

	}

	@Override
	public void initializeOnCreation() throws PersistenceException {
	}

	@Override
	public void initializeOnInstantiation() throws PersistenceException {
	}

	@Override
	public void removeAssoFrmHier(final PersistentHierarchy h, final PersistentAssociation a)
			throws model.NotAvailableException, model.ConsistencyException, model.CycleException, PersistenceException {

		// Wenn die Assoziation gar nicht in der Hierarchy ist => Exception
		final PersistentAssociation findFirst = h.getAssociations().findFirst(new Predcate<PersistentAssociation>() {

			@Override
			public boolean test(final PersistentAssociation argument) throws PersistenceException {
				return argument.equals(a);
			}
		});
		if (findFirst == null) {
			throw new NotAvailableException("Die Assoziation '" + a + "' ist nicht in der Hierarchy '" + h + "'");
		}

		// Wenn versucht wird die letzte Assoziation einer Hierarchie zu entfernen
		if (h.getAssociations().getLength() <= 1) {
			throw new ConsistencyException(
					"Die Assoziation '"
							+ a
							+ "' ist die letzte Assoziation in der gewählten Hierarchie. Diese kann nicht aus der Hierarchie entfernt werden.");
		}

		a.getHierarchies().removeFirstSuccess(new Predcate<PersistentHierarchy>() {
			// TODO: Christin: NotAvailableException Testfall dazu
			@Override
			public boolean test(final PersistentHierarchy argument) throws PersistenceException {
				return h.equals(argument);
			}
		});
	}

	@Override
	public void removeAssociation(final PersistentAssociation a) throws model.ConsistencyException,
			model.CycleException, PersistenceException {
		// Consistency, falls es Links gibt.
		if (a.inverseGetType().getLength() > 0) {
			throw new ConsistencyException("Die Assoziation '" + a
					+ "' kann nicht gelöscht werden, solang Exemplare existieren.");
		}
		// Consistency wenn es Element einer Hierarchy ist
		if (getThis().getHierarchies().getLength() > 0) {
			throw new ConsistencyException("Die Assoziation '" + a
					+ "' kann nicht gelöscht werden, da sie Element mindestens einer Hierarchy ist.");
		}

		getThis().getAssociations().removeFirstSuccess(new Predcate<PersistentAssociation>() {
			@Override
			public boolean test(final PersistentAssociation argument) throws PersistenceException {
				return a.equals(argument);
			}
		});
	}

	@Override
	public void removeHierarchy(final PersistentHierarchy h) throws PersistenceException {
		getThis().getHierarchies().removeFirstSuccess(new Predcate<PersistentHierarchy>() {

			@Override
			public boolean test(final PersistentHierarchy argument) throws PersistenceException {
				return argument.equals(h);
			}
		});
	}

	// Start of section that contains overridden operations only.

	/* Start of protected part that is not overridden by persistence generator */

	private void checkType(final PersistentMType type, final String sort) throws PersistenceException,
			ConsistencyException {
		type.accept(new MTypeExceptionVisitor<ConsistencyException>() {

			@Override
			public void handleMMixedTypeDisjunction(final PersistentMMixedTypeDisjunction mMixedTypeDisjunction)
					throws PersistenceException, ConsistencyException {
			}

			@Override
			public void handleMNonEmptyDisjunctiveNormalForm(
					final PersistentMNonEmptyDisjunctiveNormalForm mNonEmptyDisjunctiveNormalForm)
					throws PersistenceException, ConsistencyException {
			}

			@Override
			public void handleMEmptyTypeDisjunction(final PersistentMEmptyTypeDisjunction mEmptyTypeDisjunction)
					throws PersistenceException, ConsistencyException {
				throw new ConsistencyException(sort + " darf nicht vom Typ " + type + " sein.");
			}

			@Override
			public void handleMMixedConjunction(final PersistentMMixedConjunction mMixedConjunction)
					throws PersistenceException, ConsistencyException {
			}

			@Override
			public void handleMNonEmptyAtomicTypeConjunction(
					final PersistentMNonEmptyAtomicTypeConjunction mNonEmptyAtomicTypeConjunction)
					throws PersistenceException, ConsistencyException {
			}

			@Override
			public void handleMEmptyTypeConjunction(final PersistentMEmptyTypeConjunction mEmptyTypeConjunction)
					throws PersistenceException, ConsistencyException {
				throw new ConsistencyException(sort + " darf nicht vom Typ " + type + " sein.");
			}

			@Override
			public void handleMAtomicType(final PersistentMAtomicType mAtomicType) throws PersistenceException,
					ConsistencyException {
			}
		});
	}
	/* End of protected part that is not overridden by persistence generator */

}

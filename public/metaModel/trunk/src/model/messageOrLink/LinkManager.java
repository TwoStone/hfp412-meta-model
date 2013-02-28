package model.messageOrLink;

import model.ConsistencyException;
import model.CycleException;
import model.UserException;
import model.typeSystem.ObjectManager;
import model.visitor.AnythingExceptionVisitor;
import model.visitor.AnythingReturnExceptionVisitor;
import model.visitor.AnythingReturnVisitor;
import model.visitor.AnythingVisitor;
import persistence.Anything;
import persistence.ConnectionHandler;
import persistence.Invoker;
import persistence.LinkManagerProxi;
import persistence.LinkManager_LinksProxi;
import persistence.MObjectSearchList;
import persistence.PersistenceException;
import persistence.PersistentAssociation;
import persistence.PersistentCreateLinkCommand;
import persistence.PersistentLink;
import persistence.PersistentLinkManager;
import persistence.PersistentMObject;
import persistence.PersistentObject;
import persistence.PersistentProxi;
import persistence.PersistentRemoveLinkCommand;
import persistence.Predcate;
import persistence.TDObserver;

/* Additional import section end */

public class LinkManager extends PersistentObject implements PersistentLinkManager {

	private static PersistentLinkManager theLinkManager = null;
	public static boolean reset$For$Test = false;
	private static final Object $$lock = new Object();

	public static PersistentLinkManager getTheLinkManager() throws PersistenceException {
		if (theLinkManager == null || reset$For$Test) {
			class Initializer implements Runnable {
				PersistenceException exception = null;

				@Override
				public void run() {
					try {
						LinkManagerProxi proxi = null;
						synchronized ($$lock) {
							proxi = ConnectionHandler.getTheConnectionHandler().theLinkManagerFacade
									.getTheLinkManager();
							theLinkManager = proxi;
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

				PersistentLinkManager getResult() throws PersistenceException {
					if (exception != null)
						throw exception;
					return theLinkManager;
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
		return theLinkManager;
	}

	@Override
	public java.util.Hashtable<String, Object> toHashtable(final java.util.Hashtable<String, Object> allResults,
			final int depth, final int essentialLevel, final boolean forGUI, final boolean leaf,
			final TDObserver tdObserver) throws PersistenceException {
		java.util.Hashtable<String, Object> result = null;
		if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth) {
			result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
			result.put(
					"links",
					this.getLinks().getVector(allResults, depth, essentialLevel, forGUI, tdObserver, false,
							essentialLevel == 0));
			final String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
			if (leaf && !allResults.contains(uniqueKey))
				allResults.put(uniqueKey, result);
		}
		return result;
	}

	@Override
	public LinkManager provideCopy() throws PersistenceException {
		LinkManager result = this;
		result = new LinkManager(this.This, this.getId());
		result.links = this.links.copy(result);
		this.copyingPrivateUserAttributes(result);
		return result;
	}

	@Override
	public boolean hasEssentialFields() throws PersistenceException {
		return false;
	}

	protected LinkManager_LinksProxi links;
	protected PersistentLinkManager This;

	public LinkManager(final PersistentLinkManager This, final long id) throws persistence.PersistenceException {
		/* Shall not be used by clients for object construction! Use static create operation instead! */
		super(id);
		this.links = new LinkManager_LinksProxi(this);
		if (This != null && !(this.equals(This)))
			this.This = This;
	}

	static public long getTypeId() {
		return 188;
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
	public LinkManager_LinksProxi getLinks() throws PersistenceException {
		return this.links;
	}

	protected void setThis(final PersistentLinkManager newValue) throws PersistenceException {
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
		this.This = (PersistentLinkManager) PersistentProxi.createProxi(objectId, classId);
		if (!this.isDelayed$Persistence()) {
			newValue.store();
			ConnectionHandler.getTheConnectionHandler().theLinkManagerFacade.ThisSet(this.getId(), newValue);
		}
	}

	@Override
	public PersistentLinkManager getThis() throws PersistenceException {
		if (this.This == null) {
			final PersistentLinkManager result = new LinkManagerProxi(this.getId());
			result.getTheObject();
			return result;
		}
		return this.This;
	}

	@Override
	public void accept(final AnythingVisitor visitor) throws PersistenceException {
		visitor.handleLinkManager(this);
	}

	@Override
	public <R> R accept(final AnythingReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleLinkManager(this);
	}

	@Override
	public <E extends UserException> void accept(final AnythingExceptionVisitor<E> visitor)
			throws PersistenceException, E {
		visitor.handleLinkManager(this);
	}

	@Override
	public <R, E extends UserException> R accept(final AnythingReturnExceptionVisitor<R, E> visitor)
			throws PersistenceException, E {
		return visitor.handleLinkManager(this);
	}

	@Override
	public int getLeafInfo() throws PersistenceException {
		if (this.getLinks().getLength() > 0)
			return 1;
		return 0;
	}

	@Override
	public void createLink(final PersistentAssociation type, final PersistentMObject source,
			final PersistentMObject target, final Invoker invoker) throws PersistenceException {
		final java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		final PersistentCreateLinkCommand command = model.meta.CreateLinkCommand.createCreateLinkCommand(now, now);
		command.setType(type);
		command.setSource(source);
		command.setTarget(target);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
	}

	// Start of section that contains operations that must be implemented.

	@Override
	public void initialize(final Anything This, final java.util.Hashtable<String, Object> final$$Fields)
			throws PersistenceException {
		this.setThis((PersistentLinkManager) This);
		if (this.equals(This)) {
		}
	}

	@Override
	public void removeLink(final PersistentLink link, final Invoker invoker) throws PersistenceException {
		final java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		final PersistentRemoveLinkCommand command = model.meta.RemoveLinkCommand.createRemoveLinkCommand(now, now);
		command.setLink(link);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
	}

	@Override
	public void copyingPrivateUserAttributes(final Anything copy) throws PersistenceException {
	}

	@Override
	public void createLink(final PersistentAssociation type, final PersistentMObject source,
			final PersistentMObject target) throws model.ConsistencyException, model.CycleException,
			PersistenceException {

		if (target.containsInHierarchies(source, type.getHierarchies().getList()).toBoolean()) {
			throw new CycleException("Es entstuende ein Zyklus, beim anlegen einer des Links von " + source + " nach "
					+ target);
		}

		final MObjectSearchList possibleSources = ObjectManager.getTheObjectManager().fetchObjectsWithTypeLE(
				type.getSource());

		final MObjectSearchList possibleTargets = ObjectManager.getTheObjectManager().fetchObjectsWithTypeLE(
				type.getTarget());

		// Passt die Source zum Association,Type?
		if (possibleSources.findFirst(new Predcate<PersistentMObject>() {

			@Override
			public boolean test(final PersistentMObject argument) throws PersistenceException {
				return argument.equals(source);
			}
		}) == null) {
			throw new ConsistencyException("Die gewaehlte Source passt nicht zum AssoicationType!");
		}

		// Ist das Target gemaess Typebene korrekt?
		if (possibleTargets.findFirst(new Predcate<PersistentMObject>() {

			@Override
			public boolean test(final PersistentMObject argument) throws PersistenceException {
				return argument.equals(target);
			}
		}) == null) {
			throw new ConsistencyException("Das gewaehlte Target passt nicht zum AssoicationType!");
		}

		getThis().getLinks().add(Link.createLink(source, target, type));
	}

	@Override
	public void initializeOnCreation() throws PersistenceException {
	}

	@Override
	public void initializeOnInstantiation() throws PersistenceException {
	}

	@Override
	public void removeLink(final PersistentLink link) throws PersistenceException {
		// TODO: implement method: removeLink
	}

	// Start of section that contains overridden operations only.

	/* Start of protected part that is not overridden by persistence generator */

	/* End of protected part that is not overridden by persistence generator */

}

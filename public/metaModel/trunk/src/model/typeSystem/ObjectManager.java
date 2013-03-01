package model.typeSystem;

import model.UserException;
import model.visitor.AnythingExceptionVisitor;
import model.visitor.AnythingReturnExceptionVisitor;
import model.visitor.AnythingReturnVisitor;
import model.visitor.AnythingVisitor;
import persistence.Anything;
import persistence.ConnectionHandler;
import persistence.Invoker;
import persistence.MAtomicTypeSearchList;
import persistence.MObjectSearchList;
import persistence.ObjectManagerProxi;
import persistence.ObjectManager_ObjectsProxi;
import persistence.PersistenceException;
import persistence.PersistentAddTypeCommand;
import persistence.PersistentCreateMObjectCommand;
import persistence.PersistentMAtomicType;
import persistence.PersistentMObject;
import persistence.PersistentMType;
import persistence.PersistentObject;
import persistence.PersistentObjectManager;
import persistence.PersistentProxi;
import persistence.PersistentRemoveTypeCommand;
import persistence.PersistentReplaceTypeCommand;
import persistence.Predcate;
import persistence.TDObserver;

/* Additional import section end */

public class ObjectManager extends PersistentObject implements PersistentObjectManager {

	private static PersistentObjectManager theObjectManager = null;
	public static boolean reset$For$Test = false;
	private static final Object $$lock = new Object();

	public static PersistentObjectManager getTheObjectManager() throws PersistenceException {
		if (theObjectManager == null || reset$For$Test) {
			class Initializer implements Runnable {
				PersistenceException exception = null;

				@Override
				public void run() {
					try {
						ObjectManagerProxi proxi = null;
						synchronized ($$lock) {
							proxi = ConnectionHandler.getTheConnectionHandler().theObjectManagerFacade
									.getTheObjectManager();
							theObjectManager = proxi;
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

				PersistentObjectManager getResult() throws PersistenceException {
					if (exception != null)
						throw exception;
					return theObjectManager;
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
		return theObjectManager;
	}

	@Override
	public java.util.Hashtable<String, Object> toHashtable(final java.util.Hashtable<String, Object> allResults,
			final int depth, final int essentialLevel, final boolean forGUI, final boolean leaf,
			final TDObserver tdObserver) throws PersistenceException {
		java.util.Hashtable<String, Object> result = null;
		if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth) {
			result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
			result.put(
					"objects",
					this.getObjects().getVector(allResults, depth, essentialLevel, forGUI, tdObserver, false,
							essentialLevel == 0));
			final String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
			if (leaf && !allResults.contains(uniqueKey))
				allResults.put(uniqueKey, result);
		}
		return result;
	}

	@Override
	public ObjectManager provideCopy() throws PersistenceException {
		ObjectManager result = this;
		result = new ObjectManager(this.This, this.getId());
		result.objects = this.objects.copy(result);
		this.copyingPrivateUserAttributes(result);
		return result;
	}

	@Override
	public boolean hasEssentialFields() throws PersistenceException {
		return false;
	}

	protected ObjectManager_ObjectsProxi objects;
	protected PersistentObjectManager This;

	public ObjectManager(final PersistentObjectManager This, final long id) throws persistence.PersistenceException {
		/* Shall not be used by clients for object construction! Use static create operation instead! */
		super(id);
		this.objects = new ObjectManager_ObjectsProxi(this);
		if (This != null && !(this.equals(This)))
			this.This = This;
	}

	static public long getTypeId() {
		return 200;
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
	public ObjectManager_ObjectsProxi getObjects() throws PersistenceException {
		return this.objects;
	}

	protected void setThis(final PersistentObjectManager newValue) throws PersistenceException {
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
		this.This = (PersistentObjectManager) PersistentProxi.createProxi(objectId, classId);
		if (!this.isDelayed$Persistence()) {
			newValue.store();
			ConnectionHandler.getTheConnectionHandler().theObjectManagerFacade.ThisSet(this.getId(), newValue);
		}
	}

	@Override
	public PersistentObjectManager getThis() throws PersistenceException {
		if (this.This == null) {
			final PersistentObjectManager result = new ObjectManagerProxi(this.getId());
			result.getTheObject();
			return result;
		}
		return this.This;
	}

	@Override
	public void accept(final AnythingVisitor visitor) throws PersistenceException {
		visitor.handleObjectManager(this);
	}

	@Override
	public <R> R accept(final AnythingReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleObjectManager(this);
	}

	@Override
	public <E extends UserException> void accept(final AnythingExceptionVisitor<E> visitor)
			throws PersistenceException, E {
		visitor.handleObjectManager(this);
	}

	@Override
	public <R, E extends UserException> R accept(final AnythingReturnExceptionVisitor<R, E> visitor)
			throws PersistenceException, E {
		return visitor.handleObjectManager(this);
	}

	@Override
	public int getLeafInfo() throws PersistenceException {
		if (this.getObjects().getLength() > 0)
			return 1;
		return 0;
	}

	@Override
	public void addType(final PersistentMObject object, final PersistentMAtomicType newType, final Invoker invoker)
			throws PersistenceException {
		final java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		final PersistentAddTypeCommand command = model.meta.AddTypeCommand.createAddTypeCommand(now, now);
		command.setObject(object);
		command.setNewType(newType);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
	}

	// Start of section that contains operations that must be implemented.

	@Override
	public void createMObject(final PersistentMAtomicType type, final MAtomicTypeSearchList otherTypes,
			final Invoker invoker) throws PersistenceException {
		final java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		final PersistentCreateMObjectCommand command = model.meta.CreateMObjectCommand.createCreateMObjectCommand(now,
				now);
		command.setType(type);
		final java.util.Iterator<PersistentMAtomicType> otherTypesIterator = otherTypes.iterator();
		while (otherTypesIterator.hasNext()) {
			command.getOtherTypes().add(otherTypesIterator.next());
		}
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
	}

	@Override
	public void initialize(final Anything This, final java.util.Hashtable<String, Object> final$$Fields)
			throws PersistenceException {
		this.setThis((PersistentObjectManager) This);
		if (this.equals(This)) {
		}
	}

	@Override
	public void removeType(final PersistentMObject object, final PersistentMAtomicType oldType, final Invoker invoker)
			throws PersistenceException {
		final java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		final PersistentRemoveTypeCommand command = model.meta.RemoveTypeCommand.createRemoveTypeCommand(now, now);
		command.setObject(object);
		command.setOldType(oldType);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
	}

	@Override
	public void replaceType(final PersistentMObject object, final PersistentMAtomicType oldType,
			final PersistentMAtomicType newType, final Invoker invoker) throws PersistenceException {
		final java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		final PersistentReplaceTypeCommand command = model.meta.ReplaceTypeCommand.createReplaceTypeCommand(now, now);
		command.setObject(object);
		command.setOldType(oldType);
		command.setNewType(newType);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
	}

	@Override
	public void addType(final PersistentMObject object, final PersistentMAtomicType newType)
			throws model.ConsistencyException, PersistenceException {
		// TODO: implement method: addType

	}

	@Override
	public void copyingPrivateUserAttributes(final Anything copy) throws PersistenceException {
	}

	@Override
	public PersistentMObject createMObject(final PersistentMAtomicType type, final MAtomicTypeSearchList otherTypes)
			throws model.ConsistencyException, PersistenceException {
		// TODO: implement method: createMObject
		try {
			throw new java.lang.UnsupportedOperationException("Method \"createMObject\" not implemented yet.");
		} catch (final java.lang.UnsupportedOperationException uoe) {
			uoe.printStackTrace();
			throw uoe;
		}
	}

	@Override
	public MObjectSearchList fetchObjectsWithTypeLE(final PersistentMType type) throws PersistenceException {
		return new MObjectSearchList(getThis().getObjects().findAll(new Predcate<PersistentMObject>() {

			@Override
			public boolean test(final PersistentMObject argument) throws PersistenceException {
				return argument.getProductType().isLessOrEqual(type).toBoolean();
			}
		}));
	}

	@Override
	public void initializeOnCreation() throws PersistenceException {
	}

	@Override
	public void initializeOnInstantiation() throws PersistenceException {
	}

	@Override
	public void removeType(final PersistentMObject object, final PersistentMAtomicType oldType)
			throws model.ConsistencyException, PersistenceException {
		// TODO: implement method: removeType

	}

	@Override
	public void replaceType(final PersistentMObject object, final PersistentMAtomicType oldType,
			final PersistentMAtomicType newType) throws model.ConsistencyException, PersistenceException {
		// TODO: implement method: replaceType

	}

	// Start of section that contains overridden operations only.

	/* Start of protected part that is not overridden by persistence generator */

	/* End of protected part that is not overridden by persistence generator */

}

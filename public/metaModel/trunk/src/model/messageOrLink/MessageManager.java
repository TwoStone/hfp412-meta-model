package model.messageOrLink;

import java.util.Iterator;

import model.ConsistencyException;
import model.UserException;
import model.visitor.AnythingExceptionVisitor;
import model.visitor.AnythingReturnExceptionVisitor;
import model.visitor.AnythingReturnVisitor;
import model.visitor.AnythingVisitor;
import persistence.ActualParameterSearchList;
import persistence.Anything;
import persistence.ConnectionHandler;
import persistence.Invoker;
import persistence.MessageManagerProxi;
import persistence.MessageManager_MessagesProxi;
import persistence.PersistenceException;
import persistence.PersistentActualParameter;
import persistence.PersistentCreateConstCommand;
import persistence.PersistentCreateMessageCommand;
import persistence.PersistentCreateStaticMessageCommand;
import persistence.PersistentCreateVoidMessageCommand;
import persistence.PersistentMObject;
import persistence.PersistentMessage;
import persistence.PersistentMessageManager;
import persistence.PersistentObject;
import persistence.PersistentOperation;
import persistence.PersistentProxi;
import persistence.PersistentRemoveMessageCommand;
import persistence.Predcate;
import persistence.TDObserver;

/* Additional import section end */

public class MessageManager extends PersistentObject implements PersistentMessageManager {

	private static PersistentMessageManager theMessageManager = null;
	public static boolean reset$For$Test = false;
	private static final Object $$lock = new Object();

	public static PersistentMessageManager getTheMessageManager() throws PersistenceException {
		if (theMessageManager == null || reset$For$Test) {
			class Initializer implements Runnable {
				PersistenceException exception = null;

				@Override
				public void run() {
					try {
						MessageManagerProxi proxi = null;
						synchronized ($$lock) {
							proxi = ConnectionHandler.getTheConnectionHandler().theMessageManagerFacade
									.getTheMessageManager();
							theMessageManager = proxi;
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

				PersistentMessageManager getResult() throws PersistenceException {
					if (exception != null)
						throw exception;
					return theMessageManager;
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
		return theMessageManager;
	}

	@Override
	public java.util.Hashtable<String, Object> toHashtable(final java.util.Hashtable<String, Object> allResults,
			final int depth, final int essentialLevel, final boolean forGUI, final boolean leaf,
			final TDObserver tdObserver) throws PersistenceException {
		java.util.Hashtable<String, Object> result = null;
		if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth) {
			result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
			result.put(
					"messages",
					this.getMessages().getVector(allResults, depth, essentialLevel, forGUI, tdObserver, false,
							essentialLevel == 0));
			final String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
			if (leaf && !allResults.contains(uniqueKey))
				allResults.put(uniqueKey, result);
		}
		return result;
	}

	@Override
	public MessageManager provideCopy() throws PersistenceException {
		MessageManager result = this;
		result = new MessageManager(this.This, this.getId());
		result.messages = this.messages.copy(result);
		this.copyingPrivateUserAttributes(result);
		return result;
	}

	@Override
	public boolean hasEssentialFields() throws PersistenceException {
		return false;
	}

	protected MessageManager_MessagesProxi messages;
	protected PersistentMessageManager This;

	public MessageManager(final PersistentMessageManager This, final long id) throws persistence.PersistenceException {
		/* Shall not be used by clients for object construction! Use static create operation instead! */
		super(id);
		this.messages = new MessageManager_MessagesProxi(this);
		if (This != null && !(this.equals(This)))
			this.This = This;
	}

	static public long getTypeId() {
		return 170;
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
	public MessageManager_MessagesProxi getMessages() throws PersistenceException {
		return this.messages;
	}

	protected void setThis(final PersistentMessageManager newValue) throws PersistenceException {
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
		this.This = (PersistentMessageManager) PersistentProxi.createProxi(objectId, classId);
		if (!this.isDelayed$Persistence()) {
			newValue.store();
			ConnectionHandler.getTheConnectionHandler().theMessageManagerFacade.ThisSet(this.getId(), newValue);
		}
	}

	@Override
	public PersistentMessageManager getThis() throws PersistenceException {
		if (this.This == null) {
			final PersistentMessageManager result = new MessageManagerProxi(this.getId());
			result.getTheObject();
			return result;
		}
		return this.This;
	}

	@Override
	public void accept(final AnythingVisitor visitor) throws PersistenceException {
		visitor.handleMessageManager(this);
	}

	@Override
	public <R> R accept(final AnythingReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleMessageManager(this);
	}

	@Override
	public <E extends UserException> void accept(final AnythingExceptionVisitor<E> visitor)
			throws PersistenceException, E {
		visitor.handleMessageManager(this);
	}

	@Override
	public <R, E extends UserException> R accept(final AnythingReturnExceptionVisitor<R, E> visitor)
			throws PersistenceException, E {
		return visitor.handleMessageManager(this);
	}

	@Override
	public int getLeafInfo() throws PersistenceException {
		if (this.getMessages().getLength() > 0)
			return 1;
		return 0;
	}

	@Override
	public void createConst(final PersistentOperation type, final String name, final PersistentMObject target,
			final Invoker invoker) throws PersistenceException {
		final java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		final PersistentCreateConstCommand command = model.meta.CreateConstCommand.createCreateConstCommand(name, now,
				now);
		command.setType(type);
		command.setTarget(target);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
	}

	// Start of section that contains operations that must be implemented.

	@Override
	public void createMessage(final PersistentOperation type, final PersistentMObject source,
			final PersistentMObject target, final ActualParameterSearchList ap, final Invoker invoker)
			throws PersistenceException {
		final java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		final PersistentCreateMessageCommand command = model.meta.CreateMessageCommand.createCreateMessageCommand(now,
				now);
		command.setType(type);
		command.setSource(source);
		command.setTarget(target);
		final java.util.Iterator<PersistentActualParameter> apIterator = ap.iterator();
		while (apIterator.hasNext()) {
			command.getAp().add(apIterator.next());
		}
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
	}

	@Override
	public void createStaticMessage(final PersistentOperation type, final String name, final PersistentMObject target,
			final ActualParameterSearchList ap, final Invoker invoker) throws PersistenceException {
		final java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		final PersistentCreateStaticMessageCommand command = model.meta.CreateStaticMessageCommand
				.createCreateStaticMessageCommand(name, now, now);
		command.setType(type);
		command.setTarget(target);
		final java.util.Iterator<PersistentActualParameter> apIterator = ap.iterator();
		while (apIterator.hasNext()) {
			command.getAp().add(apIterator.next());
		}
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
	}

	@Override
	public void createVoidMessage(final PersistentOperation type, final PersistentMObject source,
			final ActualParameterSearchList ap, final Invoker invoker) throws PersistenceException {
		final java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		final PersistentCreateVoidMessageCommand command = model.meta.CreateVoidMessageCommand
				.createCreateVoidMessageCommand(now, now);
		command.setType(type);
		command.setSource(source);
		final java.util.Iterator<PersistentActualParameter> apIterator = ap.iterator();
		while (apIterator.hasNext()) {
			command.getAp().add(apIterator.next());
		}
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
	}

	@Override
	public void initialize(final Anything This, final java.util.Hashtable<String, Object> final$$Fields)
			throws PersistenceException {
		this.setThis((PersistentMessageManager) This);
		if (this.equals(This)) {
		}
	}

	@Override
	public void removeMessage(final PersistentMessage m, final Invoker invoker) throws PersistenceException {
		final java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		final PersistentRemoveMessageCommand command = model.meta.RemoveMessageCommand.createRemoveMessageCommand(now,
				now);
		command.setM(m);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
	}

	@Override
	public void copyingPrivateUserAttributes(final Anything copy) throws PersistenceException {
	}

	@Override
	public void createConst(final PersistentOperation type, final String name, final PersistentMObject target)
			throws model.DoubleDefinitionException, model.ConsistencyException, PersistenceException {
		// TODO: Christin: EmptyType nicht als Object verfügbar
		// getThis().createMessage(type, MEmptySumType.getTheMEmptySumType(), target, ap);
	}

	@Override
	public void createMessage(final PersistentOperation type, final PersistentMObject source,
			final PersistentMObject target, final ActualParameterSearchList ap) throws model.DoubleDefinitionException,
			model.ConsistencyException, PersistenceException {
		final boolean consEx = false;
		// TODO: später: SumTypes auseinandernehmen und einzelne Summanden als mögliches Target/Source

		if (!type.getTarget().equals(target.getTypes())) {

		}
		if (consEx) {
			throw new ConsistencyException("");
		}
		// TODO: Christin DDE
		final PersistentMessage m = Message.createMessage(source, target, type);
		final Iterator<PersistentActualParameter> it = ap.iterator();
		while (it.hasNext()) {
			m.getActualParameters().add(it.next());
		}
		getThis().getMessages().add(m);
	}

	@Override
	public void createStaticMessage(final PersistentOperation type, final String name, final PersistentMObject target,
			final ActualParameterSearchList ap) throws model.DoubleDefinitionException, model.ConsistencyException,
			PersistenceException {
		// TODO: Christin: EmptyType nicht als Object verf??gbar
		// getThis().createMessage(type, MEmptySumType.getTheMEmptySumType(), target, ap);
	}

	@Override
	public void createVoidMessage(final PersistentOperation type, final PersistentMObject source,
			final ActualParameterSearchList ap) throws model.DoubleDefinitionException, model.ConsistencyException,
			PersistenceException {
		// TODO: Christin: EmptyType nicht als Object verf??gbar
		// getThis().createMessage(type, source, MEmptySumType.getTheMEmptySumType(), ap);
	}

	@Override
	public void initializeOnCreation() throws PersistenceException {
	}

	@Override
	public void initializeOnInstantiation() throws PersistenceException {
	}

	@Override
	public void removeMessage(final PersistentMessage m) throws PersistenceException {
		getThis().getMessages().removeFirstSuccess(new Predcate<PersistentMessage>() {

			@Override
			public boolean test(final PersistentMessage argument) throws PersistenceException {
				if (argument.equals(m)) {
					return true;
				}
				return false;
			}
		});

	}

	// Start of section that contains overridden operations only.

	/* Start of protected part that is not overridden by persistence generator */

	/* End of protected part that is not overridden by persistence generator */

}

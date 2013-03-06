package model.meta;

import model.UserException;
import model.visitor.AnythingExceptionVisitor;
import model.visitor.AnythingReturnExceptionVisitor;
import model.visitor.AnythingReturnVisitor;
import model.visitor.AnythingVisitor;
import model.visitor.CommandExceptionVisitor;
import model.visitor.CommandReturnExceptionVisitor;
import model.visitor.CommandReturnVisitor;
import model.visitor.CommandVisitor;
import model.visitor.CommonDateExceptionVisitor;
import model.visitor.CommonDateReturnExceptionVisitor;
import model.visitor.CommonDateReturnVisitor;
import model.visitor.CommonDateVisitor;
import model.visitor.LinkManagerCommandExceptionVisitor;
import model.visitor.LinkManagerCommandReturnExceptionVisitor;
import model.visitor.LinkManagerCommandReturnVisitor;
import model.visitor.LinkManagerCommandVisitor;
import persistence.ConnectionHandler;
import persistence.Invoker;
import persistence.PersistenceException;
import persistence.PersistentAssociation;
import persistence.PersistentCommonDate;
import persistence.PersistentCreateLinkCommand;
import persistence.PersistentLink;
import persistence.PersistentLinkManager;
import persistence.PersistentMObject;
import persistence.PersistentObject;
import persistence.PersistentProxi;

/* Additional import section end */

public class CreateLinkCommand extends PersistentObject implements PersistentCreateLinkCommand {

	/** Throws persistence exception if the object with the given id does not exist. */
	public static PersistentCreateLinkCommand getById(final long objectId) throws PersistenceException {
		final long classId = ConnectionHandler.getTheConnectionHandler().theCreateLinkCommandFacade.getClass(objectId);
		return (PersistentCreateLinkCommand) PersistentProxi.createProxi(objectId, classId);
	}

	public static PersistentCreateLinkCommand createCreateLinkCommand(final java.sql.Date createDate,
			final java.sql.Date commitDate) throws PersistenceException {
		return createCreateLinkCommand(createDate, commitDate, false);
	}

	public static PersistentCreateLinkCommand createCreateLinkCommand(final java.sql.Date createDate,
			final java.sql.Date commitDate, final boolean delayed$Persistence) throws PersistenceException {
		PersistentCreateLinkCommand result = null;
		if (delayed$Persistence) {
			result = ConnectionHandler.getTheConnectionHandler().theCreateLinkCommandFacade
					.newDelayedCreateLinkCommand();
			result.setDelayed$Persistence(true);
		} else {
			result = ConnectionHandler.getTheConnectionHandler().theCreateLinkCommandFacade.newCreateLinkCommand(-1);
		}
		result.setMyCommonDate(CommonDate.createCommonDate(createDate, createDate));
		return result;
	}

	@Override
	public boolean hasEssentialFields() throws PersistenceException {
		return true;
	}

	protected PersistentAssociation type;
	protected PersistentMObject source;
	protected PersistentMObject target;
	protected Invoker invoker;
	protected PersistentLinkManager commandReceiver;
	protected PersistentLink commandResult;
	protected PersistentCommonDate myCommonDate;

	private model.UserException commandException = null;

	public CreateLinkCommand(final PersistentAssociation type, final PersistentMObject source,
			final PersistentMObject target, final Invoker invoker, final PersistentLinkManager commandReceiver,
			final PersistentLink commandResult, final PersistentCommonDate myCommonDate, final long id)
			throws persistence.PersistenceException {
		/* Shall not be used by clients for object construction! Use static create operation instead! */
		super(id);
		this.type = type;
		this.source = source;
		this.target = target;
		this.invoker = invoker;
		this.commandReceiver = commandReceiver;
		this.commandResult = commandResult;
		this.myCommonDate = myCommonDate;
	}

	static public long getTypeId() {
		return 160;
	}

	@Override
	public long getClassId() {
		return getTypeId();
	}

	@Override
	public void store() throws PersistenceException {
		if (!this.isDelayed$Persistence())
			return;
		if (this.getClassId() == 160)
			ConnectionHandler.getTheConnectionHandler().theCreateLinkCommandFacade.newCreateLinkCommand(this.getId());
		super.store();
		if (this.getType() != null) {
			this.getType().store();
			ConnectionHandler.getTheConnectionHandler().theCreateLinkCommandFacade.typeSet(this.getId(), getType());
		}
		if (this.getSource() != null) {
			this.getSource().store();
			ConnectionHandler.getTheConnectionHandler().theCreateLinkCommandFacade.sourceSet(this.getId(), getSource());
		}
		if (this.getTarget() != null) {
			this.getTarget().store();
			ConnectionHandler.getTheConnectionHandler().theCreateLinkCommandFacade.targetSet(this.getId(), getTarget());
		}
		if (this.getInvoker() != null) {
			this.getInvoker().store();
			ConnectionHandler.getTheConnectionHandler().theCreateLinkCommandFacade.invokerSet(this.getId(),
					getInvoker());
		}
		if (this.getCommandReceiver() != null) {
			this.getCommandReceiver().store();
			ConnectionHandler.getTheConnectionHandler().theCreateLinkCommandFacade.commandReceiverSet(this.getId(),
					getCommandReceiver());
		}
		if (this.getCommandResult() != null) {
			this.getCommandResult().store();
			ConnectionHandler.getTheConnectionHandler().theCreateLinkCommandFacade.commandResultSet(this.getId(),
					getCommandResult());
		}
		if (this.getMyCommonDate() != null) {
			this.getMyCommonDate().store();
			ConnectionHandler.getTheConnectionHandler().theCreateLinkCommandFacade.myCommonDateSet(this.getId(),
					getMyCommonDate());
		}

	}

	@Override
	public PersistentAssociation getType() throws PersistenceException {
		return this.type;
	}

	@Override
	public void setType(final PersistentAssociation newValue) throws PersistenceException {
		if (newValue == null)
			throw new PersistenceException("Null values not allowed!", 0);
		if (newValue.equals(this.type))
			return;
		final long objectId = newValue.getId();
		final long classId = newValue.getClassId();
		this.type = (PersistentAssociation) PersistentProxi.createProxi(objectId, classId);
		if (!this.isDelayed$Persistence()) {
			newValue.store();
			ConnectionHandler.getTheConnectionHandler().theCreateLinkCommandFacade.typeSet(this.getId(), newValue);
		}
	}

	@Override
	public PersistentMObject getSource() throws PersistenceException {
		return this.source;
	}

	@Override
	public void setSource(final PersistentMObject newValue) throws PersistenceException {
		if (newValue == null)
			throw new PersistenceException("Null values not allowed!", 0);
		if (newValue.equals(this.source))
			return;
		final long objectId = newValue.getId();
		final long classId = newValue.getClassId();
		this.source = (PersistentMObject) PersistentProxi.createProxi(objectId, classId);
		if (!this.isDelayed$Persistence()) {
			newValue.store();
			ConnectionHandler.getTheConnectionHandler().theCreateLinkCommandFacade.sourceSet(this.getId(), newValue);
		}
	}

	@Override
	public PersistentMObject getTarget() throws PersistenceException {
		return this.target;
	}

	@Override
	public void setTarget(final PersistentMObject newValue) throws PersistenceException {
		if (newValue == null)
			throw new PersistenceException("Null values not allowed!", 0);
		if (newValue.equals(this.target))
			return;
		final long objectId = newValue.getId();
		final long classId = newValue.getClassId();
		this.target = (PersistentMObject) PersistentProxi.createProxi(objectId, classId);
		if (!this.isDelayed$Persistence()) {
			newValue.store();
			ConnectionHandler.getTheConnectionHandler().theCreateLinkCommandFacade.targetSet(this.getId(), newValue);
		}
	}

	@Override
	public Invoker getInvoker() throws PersistenceException {
		return this.invoker;
	}

	@Override
	public void setInvoker(final Invoker newValue) throws PersistenceException {
		if (newValue == null)
			throw new PersistenceException("Null values not allowed!", 0);
		if (newValue.equals(this.invoker))
			return;
		final long objectId = newValue.getId();
		final long classId = newValue.getClassId();
		this.invoker = (Invoker) PersistentProxi.createProxi(objectId, classId);
		if (!this.isDelayed$Persistence()) {
			newValue.store();
			ConnectionHandler.getTheConnectionHandler().theCreateLinkCommandFacade.invokerSet(this.getId(), newValue);
		}
	}

	@Override
	public PersistentLinkManager getCommandReceiver() throws PersistenceException {
		return this.commandReceiver;
	}

	@Override
	public void setCommandReceiver(final PersistentLinkManager newValue) throws PersistenceException {
		if (newValue == null)
			throw new PersistenceException("Null values not allowed!", 0);
		if (newValue.equals(this.commandReceiver))
			return;
		final long objectId = newValue.getId();
		final long classId = newValue.getClassId();
		this.commandReceiver = (PersistentLinkManager) PersistentProxi.createProxi(objectId, classId);
		if (!this.isDelayed$Persistence()) {
			newValue.store();
			ConnectionHandler.getTheConnectionHandler().theCreateLinkCommandFacade.commandReceiverSet(this.getId(),
					newValue);
		}
	}

	@Override
	public PersistentLink getCommandResult() throws PersistenceException {
		return this.commandResult;
	}

	@Override
	public void setCommandResult(final PersistentLink newValue) throws PersistenceException {
		if (newValue == null)
			throw new PersistenceException("Null values not allowed!", 0);
		if (newValue.equals(this.commandResult))
			return;
		final long objectId = newValue.getId();
		final long classId = newValue.getClassId();
		this.commandResult = (PersistentLink) PersistentProxi.createProxi(objectId, classId);
		if (!this.isDelayed$Persistence()) {
			newValue.store();
			ConnectionHandler.getTheConnectionHandler().theCreateLinkCommandFacade.commandResultSet(this.getId(),
					newValue);
		}
	}

	@Override
	public PersistentCommonDate getMyCommonDate() throws PersistenceException {
		return this.myCommonDate;
	}

	@Override
	public void setMyCommonDate(final PersistentCommonDate newValue) throws PersistenceException {
		if (newValue == null)
			throw new PersistenceException("Null values not allowed!", 0);
		if (newValue.equals(this.myCommonDate))
			return;
		final long objectId = newValue.getId();
		final long classId = newValue.getClassId();
		this.myCommonDate = (PersistentCommonDate) PersistentProxi.createProxi(objectId, classId);
		if (!this.isDelayed$Persistence()) {
			newValue.store();
			ConnectionHandler.getTheConnectionHandler().theCreateLinkCommandFacade.myCommonDateSet(this.getId(),
					newValue);
		}
	}

	@Override
	public java.sql.Date getCreateDate() throws PersistenceException {
		return this.getMyCommonDate().getCreateDate();
	}

	@Override
	public void setCreateDate(final java.sql.Date newValue) throws PersistenceException {
		this.getMyCommonDate().setCreateDate(newValue);
	}

	@Override
	public java.sql.Date getCommitDate() throws PersistenceException {
		return this.getMyCommonDate().getCommitDate();
	}

	@Override
	public void setCommitDate(final java.sql.Date newValue) throws PersistenceException {
		this.getMyCommonDate().setCommitDate(newValue);
	}

	@Override
	public void delete$Me() throws PersistenceException {
		super.delete$Me();
		this.getMyCommonDate().delete$Me();
	}

	@Override
	public void accept(final CommonDateVisitor visitor) throws PersistenceException {
		visitor.handleCreateLinkCommand(this);
	}

	@Override
	public <R> R accept(final CommonDateReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleCreateLinkCommand(this);
	}

	@Override
	public <E extends UserException> void accept(final CommonDateExceptionVisitor<E> visitor)
			throws PersistenceException, E {
		visitor.handleCreateLinkCommand(this);
	}

	@Override
	public <R, E extends UserException> R accept(final CommonDateReturnExceptionVisitor<R, E> visitor)
			throws PersistenceException, E {
		return visitor.handleCreateLinkCommand(this);
	}

	@Override
	public void accept(final AnythingVisitor visitor) throws PersistenceException {
		visitor.handleCreateLinkCommand(this);
	}

	@Override
	public <R> R accept(final AnythingReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleCreateLinkCommand(this);
	}

	@Override
	public <E extends UserException> void accept(final AnythingExceptionVisitor<E> visitor)
			throws PersistenceException, E {
		visitor.handleCreateLinkCommand(this);
	}

	@Override
	public <R, E extends UserException> R accept(final AnythingReturnExceptionVisitor<R, E> visitor)
			throws PersistenceException, E {
		return visitor.handleCreateLinkCommand(this);
	}

	@Override
	public void accept(final CommandVisitor visitor) throws PersistenceException {
		visitor.handleCreateLinkCommand(this);
	}

	@Override
	public <R> R accept(final CommandReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleCreateLinkCommand(this);
	}

	@Override
	public <E extends UserException> void accept(final CommandExceptionVisitor<E> visitor) throws PersistenceException,
			E {
		visitor.handleCreateLinkCommand(this);
	}

	@Override
	public <R, E extends UserException> R accept(final CommandReturnExceptionVisitor<R, E> visitor)
			throws PersistenceException, E {
		return visitor.handleCreateLinkCommand(this);
	}

	@Override
	public void accept(final LinkManagerCommandVisitor visitor) throws PersistenceException {
		visitor.handleCreateLinkCommand(this);
	}

	@Override
	public <R> R accept(final LinkManagerCommandReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleCreateLinkCommand(this);
	}

	@Override
	public <E extends UserException> void accept(final LinkManagerCommandExceptionVisitor<E> visitor)
			throws PersistenceException, E {
		visitor.handleCreateLinkCommand(this);
	}

	@Override
	public <R, E extends UserException> R accept(final LinkManagerCommandReturnExceptionVisitor<R, E> visitor)
			throws PersistenceException, E {
		return visitor.handleCreateLinkCommand(this);
	}

	@Override
	public int getLeafInfo() throws PersistenceException {
		if (this.getType() != null)
			return 1;
		if (this.getSource() != null)
			return 1;
		if (this.getTarget() != null)
			return 1;
		if (this.getCommandReceiver() != null)
			return 1;
		if (this.getCommandResult() != null)
			return 1;
		return 0;
	}

	@Override
	public void checkException() throws UserException, PersistenceException {
		if (this.commandException != null)
			throw this.commandException;
	}

	@Override
	public void execute() throws PersistenceException {
		try {
			this.setCommandResult(this.getCommandReceiver().createLink(this.getType(), this.getSource(),
					this.getTarget()));
		} catch (final model.ConsistencyException e) {
			this.commandException = e;
		} catch (final model.CycleException e) {
			this.commandException = e;
		}
	}

	@Override
	public Invoker fetchInvoker() throws PersistenceException {
		return this.getInvoker();
	}

	@Override
	public void sendException(final PersistenceException exception) throws PersistenceException {
		this.invoker.handleException(this, exception);
	}

	@Override
	public void sendResult() throws PersistenceException {
		this.invoker.handleResult(this);
	}

	// Start of section that contains overridden operations only.

	/* Start of protected part that is not overridden by persistence generator */

	/* End of protected part that is not overridden by persistence generator */

}

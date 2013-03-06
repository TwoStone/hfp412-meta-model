package model.meta;

import model.UserException;
import model.visitor.AnythingExceptionVisitor;
import model.visitor.AnythingReturnExceptionVisitor;
import model.visitor.AnythingReturnVisitor;
import model.visitor.AnythingVisitor;
import model.visitor.AssociationManagerCommandExceptionVisitor;
import model.visitor.AssociationManagerCommandReturnExceptionVisitor;
import model.visitor.AssociationManagerCommandReturnVisitor;
import model.visitor.AssociationManagerCommandVisitor;
import model.visitor.CommandExceptionVisitor;
import model.visitor.CommandReturnExceptionVisitor;
import model.visitor.CommandReturnVisitor;
import model.visitor.CommandVisitor;
import model.visitor.CommonDateExceptionVisitor;
import model.visitor.CommonDateReturnExceptionVisitor;
import model.visitor.CommonDateReturnVisitor;
import model.visitor.CommonDateVisitor;
import persistence.ConnectionHandler;
import persistence.Invoker;
import persistence.PersistenceException;
import persistence.PersistentAssociation;
import persistence.PersistentAssociationManager;
import persistence.PersistentCommonDate;
import persistence.PersistentCreateAssociationCommand;
import persistence.PersistentMType;
import persistence.PersistentObject;
import persistence.PersistentProxi;

/* Additional import section end */

public class CreateAssociationCommand extends PersistentObject implements PersistentCreateAssociationCommand {

	/** Throws persistence exception if the object with the given id does not exist. */
	public static PersistentCreateAssociationCommand getById(final long objectId) throws PersistenceException {
		final long classId = ConnectionHandler.getTheConnectionHandler().theCreateAssociationCommandFacade
				.getClass(objectId);
		return (PersistentCreateAssociationCommand) PersistentProxi.createProxi(objectId, classId);
	}

	public static PersistentCreateAssociationCommand createCreateAssociationCommand(final String name,
			final java.sql.Date createDate, final java.sql.Date commitDate) throws PersistenceException {
		return createCreateAssociationCommand(name, createDate, commitDate, false);
	}

	public static PersistentCreateAssociationCommand createCreateAssociationCommand(final String name,
			final java.sql.Date createDate, final java.sql.Date commitDate, final boolean delayed$Persistence)
			throws PersistenceException {
		if (name == null)
			throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
		PersistentCreateAssociationCommand result = null;
		if (delayed$Persistence) {
			result = ConnectionHandler.getTheConnectionHandler().theCreateAssociationCommandFacade
					.newDelayedCreateAssociationCommand(name);
			result.setDelayed$Persistence(true);
		} else {
			result = ConnectionHandler.getTheConnectionHandler().theCreateAssociationCommandFacade
					.newCreateAssociationCommand(name, -1);
		}
		result.setMyCommonDate(CommonDate.createCommonDate(createDate, createDate));
		return result;
	}

	@Override
	public boolean hasEssentialFields() throws PersistenceException {
		return true;
	}

	protected PersistentMType source;
	protected PersistentMType target;
	protected String name;
	protected Invoker invoker;
	protected PersistentAssociationManager commandReceiver;
	protected PersistentAssociation commandResult;
	protected PersistentCommonDate myCommonDate;

	private model.UserException commandException = null;

	public CreateAssociationCommand(final PersistentMType source, final PersistentMType target, final String name,
			final Invoker invoker, final PersistentAssociationManager commandReceiver,
			final PersistentAssociation commandResult, final PersistentCommonDate myCommonDate, final long id)
			throws persistence.PersistenceException {
		/* Shall not be used by clients for object construction! Use static create operation instead! */
		super(id);
		this.source = source;
		this.target = target;
		this.name = name;
		this.invoker = invoker;
		this.commandReceiver = commandReceiver;
		this.commandResult = commandResult;
		this.myCommonDate = myCommonDate;
	}

	static public long getTypeId() {
		return 189;
	}

	@Override
	public long getClassId() {
		return getTypeId();
	}

	@Override
	public void store() throws PersistenceException {
		if (!this.isDelayed$Persistence())
			return;
		if (this.getClassId() == 189)
			ConnectionHandler.getTheConnectionHandler().theCreateAssociationCommandFacade.newCreateAssociationCommand(
					name, this.getId());
		super.store();
		if (this.getSource() != null) {
			this.getSource().store();
			ConnectionHandler.getTheConnectionHandler().theCreateAssociationCommandFacade.sourceSet(this.getId(),
					getSource());
		}
		if (this.getTarget() != null) {
			this.getTarget().store();
			ConnectionHandler.getTheConnectionHandler().theCreateAssociationCommandFacade.targetSet(this.getId(),
					getTarget());
		}
		if (this.getInvoker() != null) {
			this.getInvoker().store();
			ConnectionHandler.getTheConnectionHandler().theCreateAssociationCommandFacade.invokerSet(this.getId(),
					getInvoker());
		}
		if (this.getCommandReceiver() != null) {
			this.getCommandReceiver().store();
			ConnectionHandler.getTheConnectionHandler().theCreateAssociationCommandFacade.commandReceiverSet(
					this.getId(), getCommandReceiver());
		}
		if (this.getCommandResult() != null) {
			this.getCommandResult().store();
			ConnectionHandler.getTheConnectionHandler().theCreateAssociationCommandFacade.commandResultSet(
					this.getId(), getCommandResult());
		}
		if (this.getMyCommonDate() != null) {
			this.getMyCommonDate().store();
			ConnectionHandler.getTheConnectionHandler().theCreateAssociationCommandFacade.myCommonDateSet(this.getId(),
					getMyCommonDate());
		}

	}

	@Override
	public PersistentMType getSource() throws PersistenceException {
		return this.source;
	}

	@Override
	public void setSource(final PersistentMType newValue) throws PersistenceException {
		if (newValue == null)
			throw new PersistenceException("Null values not allowed!", 0);
		if (newValue.equals(this.source))
			return;
		final long objectId = newValue.getId();
		final long classId = newValue.getClassId();
		this.source = (PersistentMType) PersistentProxi.createProxi(objectId, classId);
		if (!this.isDelayed$Persistence()) {
			newValue.store();
			ConnectionHandler.getTheConnectionHandler().theCreateAssociationCommandFacade.sourceSet(this.getId(),
					newValue);
		}
	}

	@Override
	public PersistentMType getTarget() throws PersistenceException {
		return this.target;
	}

	@Override
	public void setTarget(final PersistentMType newValue) throws PersistenceException {
		if (newValue == null)
			throw new PersistenceException("Null values not allowed!", 0);
		if (newValue.equals(this.target))
			return;
		final long objectId = newValue.getId();
		final long classId = newValue.getClassId();
		this.target = (PersistentMType) PersistentProxi.createProxi(objectId, classId);
		if (!this.isDelayed$Persistence()) {
			newValue.store();
			ConnectionHandler.getTheConnectionHandler().theCreateAssociationCommandFacade.targetSet(this.getId(),
					newValue);
		}
	}

	@Override
	public String getName() throws PersistenceException {
		return this.name;
	}

	@Override
	public void setName(final String newValue) throws PersistenceException {
		if (newValue == null)
			throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
		if (!this.isDelayed$Persistence())
			ConnectionHandler.getTheConnectionHandler().theCreateAssociationCommandFacade.nameSet(this.getId(),
					newValue);
		this.name = newValue;
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
			ConnectionHandler.getTheConnectionHandler().theCreateAssociationCommandFacade.invokerSet(this.getId(),
					newValue);
		}
	}

	@Override
	public PersistentAssociationManager getCommandReceiver() throws PersistenceException {
		return this.commandReceiver;
	}

	@Override
	public void setCommandReceiver(final PersistentAssociationManager newValue) throws PersistenceException {
		if (newValue == null)
			throw new PersistenceException("Null values not allowed!", 0);
		if (newValue.equals(this.commandReceiver))
			return;
		final long objectId = newValue.getId();
		final long classId = newValue.getClassId();
		this.commandReceiver = (PersistentAssociationManager) PersistentProxi.createProxi(objectId, classId);
		if (!this.isDelayed$Persistence()) {
			newValue.store();
			ConnectionHandler.getTheConnectionHandler().theCreateAssociationCommandFacade.commandReceiverSet(
					this.getId(), newValue);
		}
	}

	@Override
	public PersistentAssociation getCommandResult() throws PersistenceException {
		return this.commandResult;
	}

	@Override
	public void setCommandResult(final PersistentAssociation newValue) throws PersistenceException {
		if (newValue == null)
			throw new PersistenceException("Null values not allowed!", 0);
		if (newValue.equals(this.commandResult))
			return;
		final long objectId = newValue.getId();
		final long classId = newValue.getClassId();
		this.commandResult = (PersistentAssociation) PersistentProxi.createProxi(objectId, classId);
		if (!this.isDelayed$Persistence()) {
			newValue.store();
			ConnectionHandler.getTheConnectionHandler().theCreateAssociationCommandFacade.commandResultSet(
					this.getId(), newValue);
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
			ConnectionHandler.getTheConnectionHandler().theCreateAssociationCommandFacade.myCommonDateSet(this.getId(),
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
		visitor.handleCreateAssociationCommand(this);
	}

	@Override
	public <R> R accept(final CommonDateReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleCreateAssociationCommand(this);
	}

	@Override
	public <E extends UserException> void accept(final CommonDateExceptionVisitor<E> visitor)
			throws PersistenceException, E {
		visitor.handleCreateAssociationCommand(this);
	}

	@Override
	public <R, E extends UserException> R accept(final CommonDateReturnExceptionVisitor<R, E> visitor)
			throws PersistenceException, E {
		return visitor.handleCreateAssociationCommand(this);
	}

	@Override
	public void accept(final AnythingVisitor visitor) throws PersistenceException {
		visitor.handleCreateAssociationCommand(this);
	}

	@Override
	public <R> R accept(final AnythingReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleCreateAssociationCommand(this);
	}

	@Override
	public <E extends UserException> void accept(final AnythingExceptionVisitor<E> visitor)
			throws PersistenceException, E {
		visitor.handleCreateAssociationCommand(this);
	}

	@Override
	public <R, E extends UserException> R accept(final AnythingReturnExceptionVisitor<R, E> visitor)
			throws PersistenceException, E {
		return visitor.handleCreateAssociationCommand(this);
	}

	@Override
	public void accept(final CommandVisitor visitor) throws PersistenceException {
		visitor.handleCreateAssociationCommand(this);
	}

	@Override
	public <R> R accept(final CommandReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleCreateAssociationCommand(this);
	}

	@Override
	public <E extends UserException> void accept(final CommandExceptionVisitor<E> visitor) throws PersistenceException,
			E {
		visitor.handleCreateAssociationCommand(this);
	}

	@Override
	public <R, E extends UserException> R accept(final CommandReturnExceptionVisitor<R, E> visitor)
			throws PersistenceException, E {
		return visitor.handleCreateAssociationCommand(this);
	}

	@Override
	public void accept(final AssociationManagerCommandVisitor visitor) throws PersistenceException {
		visitor.handleCreateAssociationCommand(this);
	}

	@Override
	public <R> R accept(final AssociationManagerCommandReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleCreateAssociationCommand(this);
	}

	@Override
	public <E extends UserException> void accept(final AssociationManagerCommandExceptionVisitor<E> visitor)
			throws PersistenceException, E {
		visitor.handleCreateAssociationCommand(this);
	}

	@Override
	public <R, E extends UserException> R accept(final AssociationManagerCommandReturnExceptionVisitor<R, E> visitor)
			throws PersistenceException, E {
		return visitor.handleCreateAssociationCommand(this);
	}

	@Override
	public int getLeafInfo() throws PersistenceException {
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
			this.setCommandResult(this.getCommandReceiver().createAssociation(this.getSource(), this.getTarget(),
					this.getName()));
		} catch (final model.DoubleDefinitionException e) {
			this.commandException = e;
		} catch (final model.ConsistencyException e) {
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

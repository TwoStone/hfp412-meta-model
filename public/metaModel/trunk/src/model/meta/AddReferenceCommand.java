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
import model.visitor.UnitTypeManagerCommandExceptionVisitor;
import model.visitor.UnitTypeManagerCommandReturnExceptionVisitor;
import model.visitor.UnitTypeManagerCommandReturnVisitor;
import model.visitor.UnitTypeManagerCommandVisitor;
import persistence.ConnectionHandler;
import persistence.Invoker;
import persistence.PersistenceException;
import persistence.PersistentAbsUnit;
import persistence.PersistentAddReferenceCommand;
import persistence.PersistentCommonDate;
import persistence.PersistentCompUnit;
import persistence.PersistentObject;
import persistence.PersistentProxi;
import persistence.PersistentUnit;
import persistence.PersistentUnitTypeManager;

/* Additional import section end */

public class AddReferenceCommand extends PersistentObject implements PersistentAddReferenceCommand {

	/** Throws persistence exception if the object with the given id does not exist. */
	public static PersistentAddReferenceCommand getById(long objectId) throws PersistenceException {
		long classId = ConnectionHandler.getTheConnectionHandler().theAddReferenceCommandFacade.getClass(objectId);
		return (PersistentAddReferenceCommand) PersistentProxi.createProxi(objectId, classId);
	}

	public static PersistentAddReferenceCommand createAddReferenceCommand(String name, long exponent,
			java.sql.Date createDate, java.sql.Date commitDate) throws PersistenceException {
		return createAddReferenceCommand(name, exponent, createDate, commitDate, false);
	}

	public static PersistentAddReferenceCommand createAddReferenceCommand(String name, long exponent,
			java.sql.Date createDate, java.sql.Date commitDate, boolean delayed$Persistence)
			throws PersistenceException {
		if (name == null)
			throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
		PersistentAddReferenceCommand result = null;
		if (delayed$Persistence) {
			result = ConnectionHandler.getTheConnectionHandler().theAddReferenceCommandFacade
					.newDelayedAddReferenceCommand(name, exponent);
			result.setDelayed$Persistence(true);
		} else {
			result = ConnectionHandler.getTheConnectionHandler().theAddReferenceCommandFacade.newAddReferenceCommand(
					name, exponent, -1);
		}
		result.setMyCommonDate(CommonDate.createCommonDate(createDate, createDate));
		return result;
	}

	@Override
	public boolean hasEssentialFields() throws PersistenceException {
		return true;
	}

	protected String name;
	protected PersistentAbsUnit unit;
	protected PersistentUnit referenceUnit;
	protected long exponent;
	protected Invoker invoker;
	protected PersistentUnitTypeManager commandReceiver;
	protected PersistentCompUnit commandResult;
	protected PersistentCommonDate myCommonDate;

	private model.UserException commandException = null;

	public AddReferenceCommand(String name, PersistentAbsUnit unit, PersistentUnit referenceUnit, long exponent,
			Invoker invoker, PersistentUnitTypeManager commandReceiver, PersistentCompUnit commandResult,
			PersistentCommonDate myCommonDate, long id) throws persistence.PersistenceException {
		/* Shall not be used by clients for object construction! Use static create operation instead! */
		super(id);
		this.name = name;
		this.unit = unit;
		this.referenceUnit = referenceUnit;
		this.exponent = exponent;
		this.invoker = invoker;
		this.commandReceiver = commandReceiver;
		this.commandResult = commandResult;
		this.myCommonDate = myCommonDate;
	}

	static public long getTypeId() {
		return 268;
	}

	@Override
	public long getClassId() {
		return getTypeId();
	}

	@Override
	public void store() throws PersistenceException {
		if (!this.isDelayed$Persistence())
			return;
		if (this.getClassId() == 268)
			ConnectionHandler.getTheConnectionHandler().theAddReferenceCommandFacade.newAddReferenceCommand(name,
					exponent, this.getId());
		super.store();
		if (this.getUnit() != null) {
			this.getUnit().store();
			ConnectionHandler.getTheConnectionHandler().theAddReferenceCommandFacade.unitSet(this.getId(), getUnit());
		}
		if (this.getReferenceUnit() != null) {
			this.getReferenceUnit().store();
			ConnectionHandler.getTheConnectionHandler().theAddReferenceCommandFacade.referenceUnitSet(this.getId(),
					getReferenceUnit());
		}
		if (this.getInvoker() != null) {
			this.getInvoker().store();
			ConnectionHandler.getTheConnectionHandler().theAddReferenceCommandFacade.invokerSet(this.getId(),
					getInvoker());
		}
		if (this.getCommandReceiver() != null) {
			this.getCommandReceiver().store();
			ConnectionHandler.getTheConnectionHandler().theAddReferenceCommandFacade.commandReceiverSet(this.getId(),
					getCommandReceiver());
		}
		if (this.getCommandResult() != null) {
			this.getCommandResult().store();
			ConnectionHandler.getTheConnectionHandler().theAddReferenceCommandFacade.commandResultSet(this.getId(),
					getCommandResult());
		}
		if (this.getMyCommonDate() != null) {
			this.getMyCommonDate().store();
			ConnectionHandler.getTheConnectionHandler().theAddReferenceCommandFacade.myCommonDateSet(this.getId(),
					getMyCommonDate());
		}

	}

	@Override
	public String getName() throws PersistenceException {
		return this.name;
	}

	@Override
	public void setName(String newValue) throws PersistenceException {
		if (newValue == null)
			throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
		if (!this.isDelayed$Persistence())
			ConnectionHandler.getTheConnectionHandler().theAddReferenceCommandFacade.nameSet(this.getId(), newValue);
		this.name = newValue;
	}

	@Override
	public PersistentAbsUnit getUnit() throws PersistenceException {
		return this.unit;
	}

	@Override
	public void setUnit(PersistentAbsUnit newValue) throws PersistenceException {
		if (newValue == null)
			throw new PersistenceException("Null values not allowed!", 0);
		if (newValue.equals(this.unit))
			return;
		long objectId = newValue.getId();
		long classId = newValue.getClassId();
		this.unit = (PersistentAbsUnit) PersistentProxi.createProxi(objectId, classId);
		if (!this.isDelayed$Persistence()) {
			newValue.store();
			ConnectionHandler.getTheConnectionHandler().theAddReferenceCommandFacade.unitSet(this.getId(), newValue);
		}
	}

	@Override
	public PersistentUnit getReferenceUnit() throws PersistenceException {
		return this.referenceUnit;
	}

	@Override
	public void setReferenceUnit(PersistentUnit newValue) throws PersistenceException {
		if (newValue == null)
			throw new PersistenceException("Null values not allowed!", 0);
		if (newValue.equals(this.referenceUnit))
			return;
		long objectId = newValue.getId();
		long classId = newValue.getClassId();
		this.referenceUnit = (PersistentUnit) PersistentProxi.createProxi(objectId, classId);
		if (!this.isDelayed$Persistence()) {
			newValue.store();
			ConnectionHandler.getTheConnectionHandler().theAddReferenceCommandFacade.referenceUnitSet(this.getId(),
					newValue);
		}
	}

	@Override
	public long getExponent() throws PersistenceException {
		return this.exponent;
	}

	@Override
	public void setExponent(long newValue) throws PersistenceException {
		if (!this.isDelayed$Persistence())
			ConnectionHandler.getTheConnectionHandler().theAddReferenceCommandFacade
					.exponentSet(this.getId(), newValue);
		this.exponent = newValue;
	}

	@Override
	public Invoker getInvoker() throws PersistenceException {
		return this.invoker;
	}

	@Override
	public void setInvoker(Invoker newValue) throws PersistenceException {
		if (newValue == null)
			throw new PersistenceException("Null values not allowed!", 0);
		if (newValue.equals(this.invoker))
			return;
		long objectId = newValue.getId();
		long classId = newValue.getClassId();
		this.invoker = (Invoker) PersistentProxi.createProxi(objectId, classId);
		if (!this.isDelayed$Persistence()) {
			newValue.store();
			ConnectionHandler.getTheConnectionHandler().theAddReferenceCommandFacade.invokerSet(this.getId(), newValue);
		}
	}

	@Override
	public PersistentUnitTypeManager getCommandReceiver() throws PersistenceException {
		return this.commandReceiver;
	}

	@Override
	public void setCommandReceiver(PersistentUnitTypeManager newValue) throws PersistenceException {
		if (newValue == null)
			throw new PersistenceException("Null values not allowed!", 0);
		if (newValue.equals(this.commandReceiver))
			return;
		long objectId = newValue.getId();
		long classId = newValue.getClassId();
		this.commandReceiver = (PersistentUnitTypeManager) PersistentProxi.createProxi(objectId, classId);
		if (!this.isDelayed$Persistence()) {
			newValue.store();
			ConnectionHandler.getTheConnectionHandler().theAddReferenceCommandFacade.commandReceiverSet(this.getId(),
					newValue);
		}
	}

	@Override
	public PersistentCompUnit getCommandResult() throws PersistenceException {
		return this.commandResult;
	}

	@Override
	public void setCommandResult(PersistentCompUnit newValue) throws PersistenceException {
		if (newValue == null)
			throw new PersistenceException("Null values not allowed!", 0);
		if (newValue.equals(this.commandResult))
			return;
		long objectId = newValue.getId();
		long classId = newValue.getClassId();
		this.commandResult = (PersistentCompUnit) PersistentProxi.createProxi(objectId, classId);
		if (!this.isDelayed$Persistence()) {
			newValue.store();
			ConnectionHandler.getTheConnectionHandler().theAddReferenceCommandFacade.commandResultSet(this.getId(),
					newValue);
		}
	}

	@Override
	public PersistentCommonDate getMyCommonDate() throws PersistenceException {
		return this.myCommonDate;
	}

	@Override
	public void setMyCommonDate(PersistentCommonDate newValue) throws PersistenceException {
		if (newValue == null)
			throw new PersistenceException("Null values not allowed!", 0);
		if (newValue.equals(this.myCommonDate))
			return;
		long objectId = newValue.getId();
		long classId = newValue.getClassId();
		this.myCommonDate = (PersistentCommonDate) PersistentProxi.createProxi(objectId, classId);
		if (!this.isDelayed$Persistence()) {
			newValue.store();
			ConnectionHandler.getTheConnectionHandler().theAddReferenceCommandFacade.myCommonDateSet(this.getId(),
					newValue);
		}
	}

	@Override
	public java.sql.Date getCreateDate() throws PersistenceException {
		return this.getMyCommonDate().getCreateDate();
	}

	@Override
	public void setCreateDate(java.sql.Date newValue) throws PersistenceException {
		this.getMyCommonDate().setCreateDate(newValue);
	}

	@Override
	public java.sql.Date getCommitDate() throws PersistenceException {
		return this.getMyCommonDate().getCommitDate();
	}

	@Override
	public void setCommitDate(java.sql.Date newValue) throws PersistenceException {
		this.getMyCommonDate().setCommitDate(newValue);
	}

	@Override
	public void delete$Me() throws PersistenceException {
		super.delete$Me();
		this.getMyCommonDate().delete$Me();
	}

	@Override
	public void accept(CommonDateVisitor visitor) throws PersistenceException {
		visitor.handleAddReferenceCommand(this);
	}

	@Override
	public <R> R accept(CommonDateReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleAddReferenceCommand(this);
	}

	@Override
	public <E extends UserException> void accept(CommonDateExceptionVisitor<E> visitor) throws PersistenceException, E {
		visitor.handleAddReferenceCommand(this);
	}

	@Override
	public <R, E extends UserException> R accept(CommonDateReturnExceptionVisitor<R, E> visitor)
			throws PersistenceException, E {
		return visitor.handleAddReferenceCommand(this);
	}

	@Override
	public void accept(AnythingVisitor visitor) throws PersistenceException {
		visitor.handleAddReferenceCommand(this);
	}

	@Override
	public <R> R accept(AnythingReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleAddReferenceCommand(this);
	}

	@Override
	public <E extends UserException> void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
		visitor.handleAddReferenceCommand(this);
	}

	@Override
	public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E> visitor)
			throws PersistenceException, E {
		return visitor.handleAddReferenceCommand(this);
	}

	@Override
	public void accept(CommandVisitor visitor) throws PersistenceException {
		visitor.handleAddReferenceCommand(this);
	}

	@Override
	public <R> R accept(CommandReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleAddReferenceCommand(this);
	}

	@Override
	public <E extends UserException> void accept(CommandExceptionVisitor<E> visitor) throws PersistenceException, E {
		visitor.handleAddReferenceCommand(this);
	}

	@Override
	public <R, E extends UserException> R accept(CommandReturnExceptionVisitor<R, E> visitor)
			throws PersistenceException, E {
		return visitor.handleAddReferenceCommand(this);
	}

	@Override
	public void accept(UnitTypeManagerCommandVisitor visitor) throws PersistenceException {
		visitor.handleAddReferenceCommand(this);
	}

	@Override
	public <R> R accept(UnitTypeManagerCommandReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleAddReferenceCommand(this);
	}

	@Override
	public <E extends UserException> void accept(UnitTypeManagerCommandExceptionVisitor<E> visitor)
			throws PersistenceException, E {
		visitor.handleAddReferenceCommand(this);
	}

	@Override
	public <R, E extends UserException> R accept(UnitTypeManagerCommandReturnExceptionVisitor<R, E> visitor)
			throws PersistenceException, E {
		return visitor.handleAddReferenceCommand(this);
	}

	@Override
	public int getLeafInfo() throws PersistenceException {
		return 0 + (this.getUnit() == null ? 0 : 1) + (this.getReferenceUnit() == null ? 0 : 1)
				+ (this.getCommandReceiver() == null ? 0 : 1) + (this.getCommandResult() == null ? 0 : 1);
	}

	@Override
	public void execute() throws PersistenceException {
		try {
			this.setCommandResult(this.getCommandReceiver().addReference(this.getName(), this.getUnit(),
					this.getReferenceUnit(), this.getExponent()));
		} catch (model.DoubleDefinitionException e) {
			this.commandException = e;
		}
	}

	@Override
	public void checkException() throws UserException, PersistenceException {
		if (this.commandException != null)
			throw this.commandException;
	}

	@Override
	public void sendResult() throws PersistenceException {
		this.invoker.handleResult(this);
	}

	@Override
	public Invoker fetchInvoker() throws PersistenceException {
		return this.getInvoker();
	}

	@Override
	public void sendException(final PersistenceException exception) throws PersistenceException {
		this.invoker.handleException(this, exception);
	}

	/* Start of protected part that is not overridden by persistence generator */

	/* End of protected part that is not overridden by persistence generator */

}

package model.abstractOperation;

import java.util.Iterator;

import model.DoubleDefinitionException;
import model.UserException;
import model.typeSystem.MEmptySumType;
import model.visitor.AbsOperationReturnExceptionVisitor;
import model.visitor.AnythingExceptionVisitor;
import model.visitor.AnythingReturnExceptionVisitor;
import model.visitor.AnythingReturnVisitor;
import model.visitor.AnythingVisitor;
import persistence.Anything;
import persistence.ConnectionHandler;
import persistence.FormalParameterSearchList;
import persistence.Invoker;
import persistence.OperationManagerProxi;
import persistence.OperationManager_FormalParametersProxi;
import persistence.OperationManager_OperationsProxi;
import persistence.OperationSearchList;
import persistence.PersistenceException;
import persistence.PersistentAbsOperation;
import persistence.PersistentAddFpCommand;
import persistence.PersistentAddMultipleFpCommand;
import persistence.PersistentAssociation;
import persistence.PersistentCreateConstantCommand;
import persistence.PersistentCreateFpCommand;
import persistence.PersistentCreateOperationCommand;
import persistence.PersistentCreateStaticOpCommand;
import persistence.PersistentCreateVoidOperationCommand;
import persistence.PersistentFormalParameter;
import persistence.PersistentMEmptySumType;
import persistence.PersistentMType;
import persistence.PersistentObject;
import persistence.PersistentOperation;
import persistence.PersistentOperationManager;
import persistence.PersistentProxi;
import persistence.PersistentRemoveFpCommand;
import persistence.PersistentRemoveFpFromOpCommand;
import persistence.PersistentRemoveOperationCommand;
import persistence.Predcate;
import persistence.TDObserver;

/* Additional import section end */

public class OperationManager extends PersistentObject implements PersistentOperationManager {

	private static PersistentOperationManager theOperationManager = null;
	private static boolean reset$For$Test = false;
	private static final Object $$lock = new Object();

	public static PersistentOperationManager getTheOperationManager() throws PersistenceException {
		if (theOperationManager == null || reset$For$Test) {
			class Initializer implements Runnable {
				PersistenceException exception = null;

				@Override
				public void run() {
					try {
						OperationManagerProxi proxi = null;
						synchronized ($$lock) {
							proxi = ConnectionHandler.getTheConnectionHandler().theOperationManagerFacade
									.getTheOperationManager();
							theOperationManager = proxi;
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

				PersistentOperationManager getResult() throws PersistenceException {
					if (exception != null)
						throw exception;
					return theOperationManager;
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
		return theOperationManager;
	}

	@Override
	public java.util.Hashtable<String, Object> toHashtable(java.util.Hashtable<String, Object> allResults, int depth,
			int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
		java.util.Hashtable<String, Object> result = null;
		if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth) {
			result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
			result.put("operations",
					this.getOperations().getVector(allResults, depth, essentialLevel, forGUI, tdObserver, false));
			result.put(
					"staticOperations",
					this.getStaticOperations(tdObserver).getVector(allResults, (depth > 1 ? depth : depth + 1),
							essentialLevel, forGUI, tdObserver, false));
			result.put(
					"constants",
					this.getConstants(tdObserver).getVector(allResults, (depth > 1 ? depth : depth + 1),
							essentialLevel, forGUI, tdObserver, false));
			result.put("formalParameters",
					this.getFormalParameters().getVector(allResults, depth, essentialLevel, forGUI, tdObserver, false));
			String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
			if (leaf && !allResults.contains(uniqueKey))
				allResults.put(uniqueKey, result);
		}
		return result;
	}

	@Override
	public OperationManager provideCopy() throws PersistenceException {
		OperationManager result = this;
		result = new OperationManager(this.This, this.getId());
		result.operations = this.operations.copy(result);
		result.formalParameters = this.formalParameters.copy(result);
		this.copyingPrivateUserAttributes(result);
		return result;
	}

	@Override
	public boolean hasEssentialFields() throws PersistenceException {
		return false;
	}

	protected OperationManager_OperationsProxi operations;
	protected OperationManager_FormalParametersProxi formalParameters;
	protected PersistentOperationManager This;

	public OperationManager(PersistentOperationManager This, long id) throws persistence.PersistenceException {
		/* Shall not be used by clients for object construction! Use static create operation instead! */
		super(id);
		this.operations = new OperationManager_OperationsProxi(this);
		this.formalParameters = new OperationManager_FormalParametersProxi(this);
		if (This != null && !(this.equals(This)))
			this.This = This;
	}

	static public long getTypeId() {
		return 120;
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
	public OperationManager_OperationsProxi getOperations() throws PersistenceException {
		return this.operations;
	}

	@Override
	public OperationManager_FormalParametersProxi getFormalParameters() throws PersistenceException {
		return this.formalParameters;
	}

	protected void setThis(PersistentOperationManager newValue) throws PersistenceException {
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
		this.This = (PersistentOperationManager) PersistentProxi.createProxi(objectId, classId);
		if (!this.isDelayed$Persistence()) {
			newValue.store();
			ConnectionHandler.getTheConnectionHandler().theOperationManagerFacade.ThisSet(this.getId(), newValue);
		}
	}

	@Override
	public PersistentOperationManager getThis() throws PersistenceException {
		if (this.This == null) {
			PersistentOperationManager result = new OperationManagerProxi(this.getId());
			result.getTheObject();
			return result;
		}
		return this.This;
	}

	@Override
	public void accept(AnythingVisitor visitor) throws PersistenceException {
		visitor.handleOperationManager(this);
	}

	@Override
	public <R> R accept(AnythingReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleOperationManager(this);
	}

	@Override
	public <E extends UserException> void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
		visitor.handleOperationManager(this);
	}

	@Override
	public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E> visitor)
			throws PersistenceException, E {
		return visitor.handleOperationManager(this);
	}

	@Override
	public int getLeafInfo() throws PersistenceException {
		return (int) (0 + this.getOperations().getLength() + this.getStaticOperations().getLength()
				+ this.getConstants().getLength() + this.getFormalParameters().getLength());
	}

	@Override
	public OperationSearchList getConstants(final TDObserver observer) throws PersistenceException {
		OperationSearchList result = getThis().getConstants();
		observer.updateTransientDerived(getThis(), "constants", result);
		return result;
	}

	@Override
	public void removeOperation(final PersistentOperation op, final Invoker invoker) throws PersistenceException {
		java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		PersistentRemoveOperationCommand command = model.meta.RemoveOperationCommand.createRemoveOperationCommand(now,
				now);
		command.setOp(op);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
	}

	@Override
	public void createOperation(final PersistentMType source, final PersistentMType target, final String name,
			final FormalParameterSearchList fp, final Invoker invoker) throws PersistenceException {
		java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		PersistentCreateOperationCommand command = model.meta.CreateOperationCommand.createCreateOperationCommand(name,
				now, now);
		command.setSource(source);
		command.setTarget(target);
		java.util.Iterator<PersistentFormalParameter> fpIterator = fp.iterator();
		while (fpIterator.hasNext()) {
			command.getFp().add(fpIterator.next());
		}
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
	}

	@Override
	public void createConstant(final String name, final PersistentMType target) throws model.DoubleDefinitionException,
			PersistenceException {
		PersistentMEmptySumType theMEmptySumType = MEmptySumType.getTheMEmptySumType();
		getThis().createOperation(theMEmptySumType, target, name, new FormalParameterSearchList());
	}

	@Override
	public void createFp(final String name, final PersistentMType ofType, final Invoker invoker)
			throws PersistenceException {
		java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		PersistentCreateFpCommand command = model.meta.CreateFpCommand.createCreateFpCommand(name, now, now);
		command.setOfType(ofType);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
	}

	@Override
	public void createOperation(final PersistentMType source, final PersistentMType target, final String name,
			final FormalParameterSearchList fp) throws model.DoubleDefinitionException, PersistenceException {

		// 1. DDE Pruefen
		checkOperationDoubleDefinition(name);

		// 2. Operation erstellen
		PersistentOperation createOperation = Operation.createOperation(name, source, target);
		getThis().getOperations().add(createOperation);
		getThis().addMultipleFp(createOperation, fp);
	}

	@Override
	public void createVoidOperation(final PersistentMType source, final String name, final FormalParameterSearchList fp)
			throws model.DoubleDefinitionException, PersistenceException {

		PersistentMEmptySumType theMEmptySumType = MEmptySumType.getTheMEmptySumType();
		getThis().createOperation(source, theMEmptySumType, name, fp);
	}

	@Override
	public void removeFp(final PersistentFormalParameter fp, final Invoker invoker) throws PersistenceException {
		java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		PersistentRemoveFpCommand command = model.meta.RemoveFpCommand.createRemoveFpCommand(now, now);
		command.setFp(fp);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
	}

	@Override
	public void copyingPrivateUserAttributes(final Anything copy) throws PersistenceException {
		// TODO: implement method: copyingPrivateUserAttributes

	}

	@Override
	public void removeFpFromOp(final PersistentOperation op, final PersistentFormalParameter fp, final Invoker invoker)
			throws PersistenceException {
		java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		PersistentRemoveFpFromOpCommand command = model.meta.RemoveFpFromOpCommand
				.createRemoveFpFromOpCommand(now, now);
		command.setOp(op);
		command.setFp(fp);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
	}

	@Override
	public void createStaticOp(final String name, final PersistentMType target, final FormalParameterSearchList fp)
			throws model.DoubleDefinitionException, PersistenceException {

		PersistentMEmptySumType theMEmptySumType = MEmptySumType.getTheMEmptySumType();
		getThis().createOperation(theMEmptySumType, target, name, fp);
	}

	@Override
	public OperationSearchList getConstants() throws PersistenceException {
		// Konstanten sind wie statische Operationen ohne Parameter
		return new OperationSearchList(getThis().getStaticOperations().findAll(new Predcate<PersistentOperation>() {

			@Override
			public boolean test(PersistentOperation argument) throws PersistenceException {
				return argument.getParameters().getLength() <= 0;
			}

		}));
	}

	@Override
	public void createConstant(final String name, final PersistentMType target, final Invoker invoker)
			throws PersistenceException {
		java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		PersistentCreateConstantCommand command = model.meta.CreateConstantCommand.createCreateConstantCommand(name,
				now, now);
		command.setTarget(target);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
	}

	@Override
	public OperationSearchList getStaticOperations() throws PersistenceException {

		return new OperationSearchList(getThis().getOperations().findAll(new Predcate<PersistentOperation>() {

			@Override
			public boolean test(PersistentOperation argument) throws PersistenceException {
				return argument.isStatic().toBoolean();
			}

		}));
	}

	@Override
	public void removeOperation(final PersistentOperation op) throws PersistenceException {
		// TODO: implement method: removeOperation

	}

	@Override
	public void createVoidOperation(final PersistentMType source, final String name,
			final FormalParameterSearchList fp, final Invoker invoker) throws PersistenceException {
		java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		PersistentCreateVoidOperationCommand command = model.meta.CreateVoidOperationCommand
				.createCreateVoidOperationCommand(name, now, now);
		command.setSource(source);
		java.util.Iterator<PersistentFormalParameter> fpIterator = fp.iterator();
		while (fpIterator.hasNext()) {
			command.getFp().add(fpIterator.next());
		}
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
	}

	@Override
	public void initializeOnInstantiation() throws PersistenceException {
	}

	@Override
	public void initializeOnCreation() throws PersistenceException {
		getStaticOperations();
		getConstants();
	}

	@Override
	public OperationSearchList getStaticOperations(final TDObserver observer) throws PersistenceException {
		OperationSearchList result = getThis().getStaticOperations();
		observer.updateTransientDerived(getThis(), "staticOperations", result);
		return result;
	}

	@Override
	public void createStaticOp(final String name, final PersistentMType target, final FormalParameterSearchList fp,
			final Invoker invoker) throws PersistenceException {
		java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		PersistentCreateStaticOpCommand command = model.meta.CreateStaticOpCommand.createCreateStaticOpCommand(name,
				now, now);
		command.setTarget(target);
		java.util.Iterator<PersistentFormalParameter> fpIterator = fp.iterator();
		while (fpIterator.hasNext()) {
			command.getFp().add(fpIterator.next());
		}
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
	}

	@Override
	public void removeFp(final PersistentFormalParameter fp) throws PersistenceException {
		// TODO: implement method: removeFp

	}

	@Override
	public void createFp(final String name, final PersistentMType ofType) throws model.DoubleDefinitionException,
			PersistenceException {
		// TODO: implement method: createFp

	}

	@Override
	public void addFp(final PersistentOperation op, final PersistentFormalParameter fp, final Invoker invoker)
			throws PersistenceException {
		java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		PersistentAddFpCommand command = model.meta.AddFpCommand.createAddFpCommand(now, now);
		command.setOp(op);
		command.setFp(fp);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
	}

	@Override
	public void addFp(final PersistentOperation op, final PersistentFormalParameter fp) throws PersistenceException {
		// TODO: implement method: addFp

	}

	@Override
	public void initialize(final Anything This, final java.util.Hashtable<String, Object> final$$Fields)
			throws PersistenceException {
		this.setThis((PersistentOperationManager) This);
		if (this.equals(This)) {
		}
	}

	@Override
	public void addMultipleFp(final PersistentOperation op, final FormalParameterSearchList fp, final Invoker invoker)
			throws PersistenceException {
		java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		PersistentAddMultipleFpCommand command = model.meta.AddMultipleFpCommand.createAddMultipleFpCommand(now, now);
		command.setOp(op);
		java.util.Iterator<PersistentFormalParameter> fpIterator = fp.iterator();
		while (fpIterator.hasNext()) {
			command.getFp().add(fpIterator.next());
		}
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
	}

	@Override
	public void addMultipleFp(final PersistentOperation op, final FormalParameterSearchList fp)
			throws PersistenceException {
		// TODO: implement method: addMultipleFp

	}

	@Override
	public void removeFpFromOp(final PersistentOperation op, final PersistentFormalParameter fp)
			throws model.NotAvailableException, PersistenceException {
		// TODO: implement method: removeFpFromOp

	}

	/* Start of protected part that is not overridden by persistence generator */

	private void checkOperationDoubleDefinition(String name) throws DoubleDefinitionException, PersistenceException {
		Iterator<PersistentAbsOperation> iterator = Operation.getAbsOperationByName(name).iterator();
		while (iterator.hasNext()) {
			iterator.next().accept(new AbsOperationReturnExceptionVisitor<AbsOperation, DoubleDefinitionException>() {

				@Override
				public AbsOperation handleOperation(PersistentOperation operation) throws PersistenceException,
						DoubleDefinitionException {
					throw new DoubleDefinitionException(
							"Die Namen der Operationen sind eindeutig! Bitte waehlen Sie einen anderen Namen.");
				}

				@Override
				public AbsOperation handleAssociation(PersistentAssociation association) throws PersistenceException,
						DoubleDefinitionException {
					return null;
				}
			});
		}
	}

	/* End of protected part that is not overridden by persistence generator */

}

package model.quantity;

import model.DoubleDefinitionException;
import model.NotFoundException;
import model.UserException;
import model.visitor.AnythingExceptionVisitor;
import model.visitor.AnythingReturnExceptionVisitor;
import model.visitor.AnythingReturnVisitor;
import model.visitor.AnythingVisitor;
import persistence.Anything;
import persistence.ConnectionHandler;
import persistence.Invoker;
import persistence.PersistenceException;
import persistence.PersistentAbsUnit;
import persistence.PersistentConvertCommand;
import persistence.PersistentConvertToDefaultCommand;
import persistence.PersistentCreateQuantityCommand;
import persistence.PersistentObject;
import persistence.PersistentProxi;
import persistence.PersistentQuantity;
import persistence.PersistentQuantityManager;
import persistence.QuantityManagerProxi;
import persistence.QuantityManager_QuantitiesProxi;
import persistence.TDObserver;

/* Additional import section end */

public class QuantityManager extends PersistentObject implements PersistentQuantityManager {

	private static PersistentQuantityManager theQuantityManager = null;
	public static boolean reset$For$Test = false;
	private static final Object $$lock = new Object();

	public static PersistentQuantityManager getTheQuantityManager() throws PersistenceException {
		if (theQuantityManager == null || reset$For$Test) {
			class Initializer implements Runnable {
				PersistenceException exception = null;

				@Override
				public void run() {
					try {
						QuantityManagerProxi proxi = null;
						synchronized ($$lock) {
							proxi = ConnectionHandler.getTheConnectionHandler().theQuantityManagerFacade
									.getTheQuantityManager();
							theQuantityManager = proxi;
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

				PersistentQuantityManager getResult() throws PersistenceException {
					if (exception != null)
						throw exception;
					return theQuantityManager;
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
		return theQuantityManager;
	}

	@Override
	public java.util.Hashtable<String, Object> toHashtable(java.util.Hashtable<String, Object> allResults, int depth,
			int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
		java.util.Hashtable<String, Object> result = null;
		if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth) {
			result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
			result.put("quantities",
					this.getQuantities().getVector(allResults, depth, essentialLevel, forGUI, tdObserver, false));
			String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
			if (leaf && !allResults.contains(uniqueKey))
				allResults.put(uniqueKey, result);
		}
		return result;
	}

	@Override
	public QuantityManager provideCopy() throws PersistenceException {
		QuantityManager result = this;
		result = new QuantityManager(this.This, this.getId());
		result.quantities = this.quantities.copy(result);
		this.copyingPrivateUserAttributes(result);
		return result;
	}

	@Override
	public boolean hasEssentialFields() throws PersistenceException {
		return false;
	}

	protected QuantityManager_QuantitiesProxi quantities;
	protected PersistentQuantityManager This;

	public QuantityManager(PersistentQuantityManager This, long id) throws persistence.PersistenceException {
		/* Shall not be used by clients for object construction! Use static create operation instead! */
		super(id);
		this.quantities = new QuantityManager_QuantitiesProxi(this);
		if (This != null && !(this.equals(This)))
			this.This = This;
	}

	static public long getTypeId() {
		return 150;
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
	public QuantityManager_QuantitiesProxi getQuantities() throws PersistenceException {
		return this.quantities;
	}

	protected void setThis(PersistentQuantityManager newValue) throws PersistenceException {
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
		this.This = (PersistentQuantityManager) PersistentProxi.createProxi(objectId, classId);
		if (!this.isDelayed$Persistence()) {
			newValue.store();
			ConnectionHandler.getTheConnectionHandler().theQuantityManagerFacade.ThisSet(this.getId(), newValue);
		}
	}

	@Override
	public PersistentQuantityManager getThis() throws PersistenceException {
		if (this.This == null) {
			PersistentQuantityManager result = new QuantityManagerProxi(this.getId());
			result.getTheObject();
			return result;
		}
		return this.This;
	}

	@Override
	public void accept(AnythingVisitor visitor) throws PersistenceException {
		visitor.handleQuantityManager(this);
	}

	@Override
	public <R> R accept(AnythingReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleQuantityManager(this);
	}

	@Override
	public <E extends UserException> void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
		visitor.handleQuantityManager(this);
	}

	@Override
	public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E> visitor)
			throws PersistenceException, E {
		return visitor.handleQuantityManager(this);
	}

	@Override
	public int getLeafInfo() throws PersistenceException {
		return (int) (0 + this.getQuantities().getLength());
	}

	@Override
	public void createQuantity(final PersistentAbsUnit unit, final common.Fraction amount, final Invoker invoker)
			throws PersistenceException {
		java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		PersistentCreateQuantityCommand command = model.meta.CreateQuantityCommand.createCreateQuantityCommand(amount,
				now, now);
		command.setUnit(unit);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
	}

	@Override
	public void initializeOnInstantiation() throws PersistenceException {
		// TODO: implement method: initializeOnInstantiation

	}

	@Override
	public void convertToDefault(final PersistentQuantity quantity, final Invoker invoker) throws PersistenceException {
		java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		PersistentConvertToDefaultCommand command = model.meta.ConvertToDefaultCommand.createConvertToDefaultCommand(
				now, now);
		command.setQuantity(quantity);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
	}

	@Override
	public void copyingPrivateUserAttributes(final Anything copy) throws PersistenceException {
		// TODO: implement method: copyingPrivateUserAttributes

	}

	@Override
	public PersistentQuantity createQuantity(final PersistentAbsUnit unit, final common.Fraction amount)
			throws PersistenceException {
		// amount in FractionManager suchen oder neu erstellen.
		final String fractionStroke = "/";
		final String enumeratorString = amount.getEnumerator().toString();
		final String denominatorString = amount.getEnumerator().toString();
		final String fractionSearchString = enumeratorString + fractionStroke + denominatorString;
		common.Fraction persistentAmount;

		try {
			persistentAmount = FractionManager.getTheFractionManager().getFraction(fractionSearchString);

		} catch (NotFoundException e) {
			persistentAmount = amount;
			try {
				FractionManager.getTheFractionManager().addFraction(fractionSearchString, persistentAmount);
			} catch (DoubleDefinitionException e1) {
				System.out.println("error while fraction creation");
			}

		}

		PersistentQuantity newQuantity = Quantity.createQuantity(amount, unit);
		getThis().getQuantities().add(newQuantity);
		return newQuantity;
	}

	@Override
	public void initialize(final Anything This, final java.util.Hashtable<String, Object> final$$Fields)
			throws PersistenceException {
		this.setThis((PersistentQuantityManager) This);
		if (this.equals(This)) {
		}
	}

	@Override
	public void convert(final PersistentQuantity quantity, final PersistentAbsUnit unit) throws PersistenceException {
		// TODO: implement method: convert

	}

	@Override
	public void initializeOnCreation() throws PersistenceException {
		// TODO: implement method: initializeOnCreation

	}

	@Override
	public void convertToDefault(final PersistentQuantity quantity) throws PersistenceException {
		// TODO: implement method: convertToDefault

	}

	@Override
	public void convert(final PersistentQuantity quantity, final PersistentAbsUnit unit, final Invoker invoker)
			throws PersistenceException {
		java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		PersistentConvertCommand command = model.meta.ConvertCommand.createConvertCommand(now, now);
		command.setQuantity(quantity);
		command.setUnit(unit);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
	}

	/* Start of protected part that is not overridden by persistence generator */

	/* End of protected part that is not overridden by persistence generator */

}

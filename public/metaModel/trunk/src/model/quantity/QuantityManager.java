package model.quantity;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import model.DoubleDefinitionException;
import model.NotComputableException;
import model.NotFoundException;
import model.UserException;
import model.visitor.AbsQuantityReturnVisitor;
import model.visitor.AbsUnitReturnExceptionVisitor;
import model.visitor.AnythingExceptionVisitor;
import model.visitor.AnythingReturnExceptionVisitor;
import model.visitor.AnythingReturnVisitor;
import model.visitor.AnythingVisitor;
import persistence.Anything;
import persistence.CompoundQuantitySearchList;
import persistence.ConnectionHandler;
import persistence.Invoker;
import persistence.PersistenceException;
import persistence.PersistentAbsQuantity;
import persistence.PersistentAbsUnit;
import persistence.PersistentAddCommand;
import persistence.PersistentAddition;
import persistence.PersistentCompUnit;
import persistence.PersistentCompoundQuantity;
import persistence.PersistentConversion;
import persistence.PersistentConvertAmountCommand;
import persistence.PersistentConvertCommand;
import persistence.PersistentCreateQuantityCommand;
import persistence.PersistentDivCommand;
import persistence.PersistentDivision;
import persistence.PersistentLessOrEqualComparison;
import persistence.PersistentMBoolean;
import persistence.PersistentMulCommand;
import persistence.PersistentMultiplication;
import persistence.PersistentObject;
import persistence.PersistentProxi;
import persistence.PersistentQuantity;
import persistence.PersistentQuantityManager;
import persistence.PersistentReference;
import persistence.PersistentSubCommand;
import persistence.PersistentSubtraction;
import persistence.PersistentUnit;
import persistence.QuantityManagerProxi;
import persistence.QuantityManager_QuantitiesProxi;
import persistence.TDObserver;

import common.Fraction;

import constants.ExceptionConstants;

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
							proxi = ConnectionHandler.getTheConnectionHandler().theQuantityManagerFacade.getTheQuantityManager();
							theQuantityManager = proxi;
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

				PersistentQuantityManager getResult() throws PersistenceException {
					if (exception != null)
						throw exception;
					return theQuantityManager;
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
		return theQuantityManager;
	}

	@Override
	public java.util.Hashtable<String, Object> toHashtable(final java.util.Hashtable<String, Object> allResults, final int depth,
			final int essentialLevel, final boolean forGUI, final boolean leaf, final TDObserver tdObserver) throws PersistenceException {
		java.util.Hashtable<String, Object> result = null;
		if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth) {
			result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
			result.put("quantities", this.getQuantities()
					.getVector(allResults, depth, essentialLevel, forGUI, tdObserver, false, essentialLevel == 0));
			final String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
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

	public QuantityManager(final PersistentQuantityManager This, final long id) throws persistence.PersistenceException {
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

	protected void setThis(final PersistentQuantityManager newValue) throws PersistenceException {
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
		this.This = (PersistentQuantityManager) PersistentProxi.createProxi(objectId, classId);
		if (!this.isDelayed$Persistence()) {
			newValue.store();
			ConnectionHandler.getTheConnectionHandler().theQuantityManagerFacade.ThisSet(this.getId(), newValue);
		}
	}

	@Override
	public PersistentQuantityManager getThis() throws PersistenceException {
		if (this.This == null) {
			final PersistentQuantityManager result = new QuantityManagerProxi(this.getId());
			result.getTheObject();
			return result;
		}
		return this.This;
	}

	@Override
	public void accept(final AnythingVisitor visitor) throws PersistenceException {
		visitor.handleQuantityManager(this);
	}

	@Override
	public <R> R accept(final AnythingReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleQuantityManager(this);
	}

	@Override
	public <E extends UserException> void accept(final AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
		visitor.handleQuantityManager(this);
	}

	@Override
	public <R, E extends UserException> R accept(final AnythingReturnExceptionVisitor<R, E> visitor) throws PersistenceException, E {
		return visitor.handleQuantityManager(this);
	}

	@Override
	public int getLeafInfo() throws PersistenceException {
		if (this.getQuantities().getLength() > 0)
			return 1;
		return 0;
	}

	@Override
	public void add(final PersistentAbsQuantity summand1, final PersistentAbsQuantity summand2, final Invoker invoker) throws PersistenceException {
		final java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		final PersistentAddCommand command = model.meta.AddCommand.createAddCommand(now, now);
		command.setSummand1(summand1);
		command.setSummand2(summand2);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
	}

	// Start of section that contains operations that must be implemented.

	@Override
	public void convertAmount(final PersistentQuantity quantity, final PersistentAbsUnit unit, final Invoker invoker) throws PersistenceException {
		final java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		final PersistentConvertAmountCommand command = model.meta.ConvertAmountCommand.createConvertAmountCommand(common.Fraction.Null, now, now);
		command.setQuantity(quantity);
		command.setUnit(unit);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
	}

	@Override
	public void convert(final PersistentQuantity quantity, final PersistentAbsUnit unit, final Invoker invoker) throws PersistenceException {
		final java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		final PersistentConvertCommand command = model.meta.ConvertCommand.createConvertCommand(now, now);
		command.setQuantity(quantity);
		command.setUnit(unit);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
	}

	@Override
	public void createQuantity(final PersistentAbsUnit unit, final common.Fraction amount, final Invoker invoker) throws PersistenceException {
		final java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		final PersistentCreateQuantityCommand command = model.meta.CreateQuantityCommand.createCreateQuantityCommand(amount, now, now);
		command.setUnit(unit);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
	}

	@Override
	public void div(final PersistentAbsQuantity dividend, final PersistentAbsQuantity divisor, final Invoker invoker) throws PersistenceException {
		final java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		final PersistentDivCommand command = model.meta.DivCommand.createDivCommand(now, now);
		command.setDividend(dividend);
		command.setDivisor(divisor);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
	}

	@Override
	public void initialize(final Anything This, final java.util.Hashtable<String, Object> final$$Fields) throws PersistenceException {
		this.setThis((PersistentQuantityManager) This);
		if (this.equals(This)) {
		}
	}

	@Override
	public void mul(final PersistentAbsQuantity factor1, final PersistentAbsQuantity factor2, final Invoker invoker) throws PersistenceException {
		final java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		final PersistentMulCommand command = model.meta.MulCommand.createMulCommand(now, now);
		command.setFactor1(factor1);
		command.setFactor2(factor2);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
	}

	@Override
	public void sub(final PersistentAbsQuantity minuend, final PersistentAbsQuantity subtrahend, final Invoker invoker) throws PersistenceException {
		final java.sql.Date now = new java.sql.Date(new java.util.Date().getTime());
		final PersistentSubCommand command = model.meta.SubCommand.createSubCommand(now, now);
		command.setMinuend(minuend);
		command.setSubtrahend(subtrahend);
		command.setInvoker(invoker);
		command.setCommandReceiver(getThis());
		model.meta.CommandCoordinator.getTheCommandCoordinator().coordinate(command);
	}

	@Override
	public PersistentAbsQuantity add(final PersistentAbsQuantity summand1, final PersistentAbsQuantity summand2) throws model.NotComputableException,
			PersistenceException {
		final PersistentAddition addi = Addition.createAddition();
		addi.setArg1(summand1);
		addi.setArg2(summand2);
		addi.calculate();
		return addi.getResultt();
	}

	@Override
	public PersistentAbsQuantity concludeQuantity(final PersistentAbsQuantity quantity) throws PersistenceException {
		return quantity.accept(new AbsQuantityReturnVisitor<PersistentAbsQuantity>() {

			@Override
			public PersistentAbsQuantity handleCompoundQuantity(final PersistentCompoundQuantity compoundQuantity) throws PersistenceException {
				final Map<PersistentAbsUnit, PersistentQuantity> exisitingQuantitiesWithUnits = new HashMap<PersistentAbsUnit, PersistentQuantity>();
				final Iterator<PersistentQuantity> i = compoundQuantity.getParts().iterator();
				while (i.hasNext()) {
					final PersistentQuantity curQuantity = i.next();
					final PersistentQuantity existingQuantityForUnit = exisitingQuantitiesWithUnits.get(curQuantity.getUnit());
					if (existingQuantityForUnit != null) {
						try {
							existingQuantityForUnit.setAmount(existingQuantityForUnit.getAmount().add(curQuantity.getAmount()));
						} catch (final Throwable e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						i.remove();
					} else {
						exisitingQuantitiesWithUnits.put(curQuantity.getUnit(), curQuantity);
					}
				}
				return compoundQuantity;
			}

			@Override
			public PersistentAbsQuantity handleQuantity(final PersistentQuantity quantity) throws PersistenceException {
				final CompoundQuantitySearchList compoundQuantitySearchList = quantity.inverseGetParts();
				if (compoundQuantitySearchList.getLength() > 0) {
					return QuantityManager.this.getThis().concludeQuantity(compoundQuantitySearchList.iterator().next());
				}
				return quantity;
			}
		});
	}

	@Override
	public common.Fraction convertAmount(final PersistentQuantity quantity, final PersistentAbsUnit unit) throws model.NotComputableException,
			PersistenceException {
		if (!(quantity.getUnit().getType().equals(unit.getType()))) {
			throw new NotComputableException(ExceptionConstants.WRONG_UNIT_TYPE_FOR_CONVERSION);
		}
		final Fraction resultAmount = quantity.getUnit().accept(new AbsUnitReturnExceptionVisitor<Fraction, NotComputableException>() {

			@Override
			public Fraction handleUnit(final PersistentUnit unit1) throws PersistenceException, NotComputableException {
				final PersistentConversion conversion1 = unit1.getMyConversion();
				if (conversion1 == null) {
					throw new NotComputableException(ExceptionConstants.NO_CONVERSION + unit1);
				}
				final Fraction amount = conversion1.convertToDefault(quantity.getAmount());
				final PersistentConversion conversion2 = ((PersistentUnit) unit).getMyConversion();
				if (conversion2 == null) {
					throw new NotComputableException(ExceptionConstants.NO_CONVERSION + unit);
				}
				return conversion2.convertFromDefault(amount);
			}

			@Override
			public Fraction handleCompUnit(final PersistentCompUnit compUnit) throws PersistenceException, NotComputableException {
				Iterator<PersistentReference> iterator = compUnit.getRefs().iterator();
				Fraction amount = quantity.getAmount();
				while (iterator.hasNext()) {
					final PersistentReference ref = iterator.next();
					final PersistentConversion conversion = ref.getRef().getMyConversion();
					if (conversion == null) {
						throw new NotComputableException(ExceptionConstants.NO_CONVERSION + ref.getRef());
					}

					amount = conversion.convertToDefault(amount);
					try {
						amount = amount.pow(ref.getExponent());
					} catch (final Throwable e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				iterator = ((PersistentCompUnit) unit).getRefs().iterator();
				while (iterator.hasNext()) {
					final PersistentReference ref = iterator.next();
					final PersistentConversion conversion = ref.getRef().getMyConversion();
					if (conversion == null) {
						throw new NotComputableException(ExceptionConstants.NO_CONVERSION + ref.getRef());
					}

					amount = conversion.convertFromDefault(amount);
					try {
						amount = amount.pow(ref.getExponent());
					} catch (final Throwable e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				return amount;
			}
		});
		return resultAmount;
	}

	@Override
	public void convert(final PersistentQuantity quantity, final PersistentAbsUnit unit) throws model.NotComputableException, PersistenceException {
		final Fraction resultAmount = getThis().convertAmount(quantity, unit);
		quantity.setAmount(resultAmount);
		quantity.setUnit(unit);
	}

	@Override
	public void copyingPrivateUserAttributes(final Anything copy) throws PersistenceException {
	}

	@Override
	public PersistentQuantity createQuantity(final PersistentAbsUnit unit, final common.Fraction amount) throws PersistenceException {
		// amount in FractionManager suchen oder neu erstellen.
		final String fractionStroke = "/";
		final String enumeratorString = amount.getEnumerator().toString();
		final String denominatorString = amount.getEnumerator().toString();
		final String fractionSearchString = enumeratorString + fractionStroke + denominatorString;
		common.Fraction persistentAmount;

		try {
			persistentAmount = FractionManager.getTheFractionManager().getFraction(fractionSearchString);

		} catch (final NotFoundException e) {
			persistentAmount = amount;
			try {
				FractionManager.getTheFractionManager().addFraction(fractionSearchString, persistentAmount);
			} catch (final DoubleDefinitionException e1) {
				System.out.println("error while fraction creation");
			}

		}

		final PersistentQuantity newQuantity = Quantity.createQuantity(amount, unit);
		getThis().getQuantities().add(newQuantity);
		return newQuantity;
	}

	@Override
	public PersistentAbsQuantity div(final PersistentAbsQuantity dividend, final PersistentAbsQuantity divisor) throws model.NotComputableException,
			PersistenceException {
		final PersistentDivision div = Division.createDivision();
		div.setArg1(dividend);
		div.setArg2(divisor);
		div.calculate();
		return div.getResultt();

	}

	@Override
	public void initializeOnCreation() throws PersistenceException {
	}

	@Override
	public void initializeOnInstantiation() throws PersistenceException {
	}

	@Override
	public PersistentAbsQuantity invertSign(final PersistentAbsQuantity absQuantity) throws PersistenceException {
		return absQuantity.accept(new AbsQuantityReturnVisitor<PersistentAbsQuantity>() {

			@Override
			public PersistentAbsQuantity handleCompoundQuantity(final PersistentCompoundQuantity compoundQuantity) throws PersistenceException {
				return QuantityManager.this.doInvertSign(compoundQuantity);
			}

			@Override
			public PersistentAbsQuantity handleQuantity(final PersistentQuantity quantity) throws PersistenceException {
				return QuantityManager.this.doInvertSign(quantity);
			}
		});
	}

	@Override
	public PersistentMBoolean isLessOrEqual(final PersistentAbsQuantity arg1, final PersistentAbsQuantity arg2) throws model.NotComputableException,
			PersistenceException {
		final PersistentLessOrEqualComparison comparison = LessOrEqualComparison.createLessOrEqualComparison();
		comparison.setArg1(arg1);
		comparison.setArg2(arg2);
		return comparison.compare();
	}

	@Override
	public PersistentAbsQuantity mul(final PersistentAbsQuantity factor1, final PersistentAbsQuantity factor2) throws model.NotComputableException,
			PersistenceException {
		final PersistentMultiplication multi = Multiplication.createMultiplication();
		multi.setArg1(factor1);
		multi.setArg2(factor2);
		multi.calculate();
		return multi.getResultt();
	}

	@Override
	public PersistentAbsQuantity sub(final PersistentAbsQuantity minuend, final PersistentAbsQuantity subtrahend)
			throws model.NotComputableException, PersistenceException {
		final PersistentSubtraction sub = Subtraction.createSubtraction();
		sub.setArg1(minuend);
		sub.setArg2(subtrahend);
		sub.calculate();
		return sub.getResultt();
	}

	// Start of section that contains overridden operations only.

	/* Start of protected part that is not overridden by persistence generator */

	protected PersistentQuantity doInvertSign(final PersistentQuantity q) throws PersistenceException {
		final Fraction amount = FractionManager.getTheFractionManager().invertSign(q.getAmount());
		final PersistentQuantity res = Quantity.createQuantity(amount, q.getUnit());
		getThis().getQuantities().add(res);
		return res;
	}

	protected PersistentCompoundQuantity doInvertSign(final PersistentCompoundQuantity q) throws PersistenceException {
		final PersistentCompoundQuantity cp = CompoundQuantity.createCompoundQuantity();
		final Iterator<PersistentQuantity> i = q.getParts().iterator();
		while (i.hasNext()) {
			final PersistentQuantity current = i.next();
			final PersistentQuantity invertedQuantity = this.doInvertSign(current);
			cp.getParts().add(invertedQuantity);
		}
		getThis().getQuantities().add(cp);
		return cp;
	}

	/* End of protected part that is not overridden by persistence generator */

}

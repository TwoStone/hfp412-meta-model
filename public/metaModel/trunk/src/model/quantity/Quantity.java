package model.quantity;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import model.NotComputableException;
import model.NotFoundException;
import model.UserException;
import model.visitor.AbsQuantityExceptionVisitor;
import model.visitor.AbsQuantityReturnExceptionVisitor;
import model.visitor.AbsQuantityReturnVisitor;
import model.visitor.AbsQuantityVisitor;
import model.visitor.AbsUnitTypeReturnVisitor;
import model.visitor.AnythingExceptionVisitor;
import model.visitor.AnythingReturnExceptionVisitor;
import model.visitor.AnythingReturnVisitor;
import model.visitor.AnythingVisitor;
import persistence.AbstractPersistentRoot;
import persistence.Anything;
import persistence.ConnectionHandler;
import persistence.PersistenceException;
import persistence.PersistentAbsQuantity;
import persistence.PersistentAbsUnit;
import persistence.PersistentAbsUnitType;
import persistence.PersistentCompUnitType;
import persistence.PersistentCompoundQuantity;
import persistence.PersistentProxi;
import persistence.PersistentQuantity;
import persistence.PersistentReferenceType;
import persistence.PersistentUnitType;
import persistence.Predcate;
import persistence.QuantityProxi;
import persistence.TDObserver;

import common.Fraction;

/* Additional import section end */

public class Quantity extends model.quantity.AbsQuantity implements PersistentQuantity {

	public static PersistentQuantity createQuantity(common.Fraction amount, PersistentAbsUnit unit)
			throws PersistenceException {
		return createQuantity(amount, unit, false);
	}

	public static PersistentQuantity createQuantity(common.Fraction amount, PersistentAbsUnit unit,
			boolean delayed$Persistence) throws PersistenceException {
		PersistentQuantity result = null;
		if (delayed$Persistence) {
			result = ConnectionHandler.getTheConnectionHandler().theQuantityFacade.newDelayedQuantity(amount);
			result.setDelayed$Persistence(true);
		} else {
			result = ConnectionHandler.getTheConnectionHandler().theQuantityFacade.newQuantity(amount, -1);
		}
		java.util.Hashtable<String, Object> final$$Fields = new java.util.Hashtable<String, Object>();
		final$$Fields.put("amount", amount);
		final$$Fields.put("unit", unit);
		result.initialize(result, final$$Fields);
		result.initializeOnCreation();
		return result;
	}

	public static PersistentQuantity createQuantity(common.Fraction amount, PersistentAbsUnit unit,
			boolean delayed$Persistence, PersistentQuantity This) throws PersistenceException {
		PersistentQuantity result = null;
		if (delayed$Persistence) {
			result = ConnectionHandler.getTheConnectionHandler().theQuantityFacade.newDelayedQuantity(amount);
			result.setDelayed$Persistence(true);
		} else {
			result = ConnectionHandler.getTheConnectionHandler().theQuantityFacade.newQuantity(amount, -1);
		}
		java.util.Hashtable<String, Object> final$$Fields = new java.util.Hashtable<String, Object>();
		final$$Fields.put("amount", amount);
		final$$Fields.put("unit", unit);
		result.initialize(This, final$$Fields);
		result.initializeOnCreation();
		return result;
	}

	@Override
	public java.util.Hashtable<String, Object> toHashtable(java.util.Hashtable<String, Object> allResults, int depth,
			int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
		java.util.Hashtable<String, Object> result = null;
		if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth) {
			result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
			result.put("amount", this.getAmount().toString());
			AbstractPersistentRoot unit = this.getUnit();
			if (unit != null) {
				result.put("unit", unit.createProxiInformation(false));
				if (depth > 1) {
					unit.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true, tdObserver);
				} else {
					if (forGUI && unit.hasEssentialFields())
						unit.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
				}
			}
			String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
			if (leaf && !allResults.contains(uniqueKey))
				allResults.put(uniqueKey, result);
		}
		return result;
	}

	@Override
	public Quantity provideCopy() throws PersistenceException {
		Quantity result = this;
		result = new Quantity(this.This, this.amount, this.unit, this.getId());
		this.copyingPrivateUserAttributes(result);
		return result;
	}

	@Override
	public boolean hasEssentialFields() throws PersistenceException {
		return false;
	}

	protected common.Fraction amount;
	protected PersistentAbsUnit unit;

	public Quantity(PersistentAbsQuantity This, common.Fraction amount, PersistentAbsUnit unit, long id)
			throws persistence.PersistenceException {
		/* Shall not be used by clients for object construction! Use static create operation instead! */
		super(This, id);
		this.amount = amount;
		this.unit = unit;
	}

	static public long getTypeId() {
		return 194;
	}

	@Override
	public long getClassId() {
		return getTypeId();
	}

	@Override
	public void store() throws PersistenceException {
		if (!this.isDelayed$Persistence())
			return;
		if (this.getClassId() == 194)
			ConnectionHandler.getTheConnectionHandler().theQuantityFacade.newQuantity(amount, this.getId());
		super.store();
		if (this.getUnit() != null) {
			this.getUnit().store();
			ConnectionHandler.getTheConnectionHandler().theQuantityFacade.unitSet(this.getId(), getUnit());
		}

	}

	@Override
	public common.Fraction getAmount() throws PersistenceException {
		return this.amount;
	}

	@Override
	public void setAmount(common.Fraction newValue) throws PersistenceException {
		if (!this.isDelayed$Persistence())
			ConnectionHandler.getTheConnectionHandler().theQuantityFacade.amountSet(this.getId(), newValue);
		this.amount = newValue;
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
			ConnectionHandler.getTheConnectionHandler().theQuantityFacade.unitSet(this.getId(), newValue);
		}
	}

	@Override
	public PersistentQuantity getThis() throws PersistenceException {
		if (this.This == null) {
			PersistentQuantity result = new QuantityProxi(this.getId());
			result.getTheObject();
			return result;
		}
		return (PersistentQuantity) this.This;
	}

	@Override
	public void accept(AbsQuantityVisitor visitor) throws PersistenceException {
		visitor.handleQuantity(this);
	}

	@Override
	public <R> R accept(AbsQuantityReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleQuantity(this);
	}

	@Override
	public <E extends UserException> void accept(AbsQuantityExceptionVisitor<E> visitor) throws PersistenceException, E {
		visitor.handleQuantity(this);
	}

	@Override
	public <R, E extends UserException> R accept(AbsQuantityReturnExceptionVisitor<R, E> visitor)
			throws PersistenceException, E {
		return visitor.handleQuantity(this);
	}

	@Override
	public void accept(AnythingVisitor visitor) throws PersistenceException {
		visitor.handleQuantity(this);
	}

	@Override
	public <R> R accept(AnythingReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleQuantity(this);
	}

	@Override
	public <E extends UserException> void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
		visitor.handleQuantity(this);
	}

	@Override
	public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E> visitor)
			throws PersistenceException, E {
		return visitor.handleQuantity(this);
	}

	@Override
	public int getLeafInfo() throws PersistenceException {
		return 0 + (this.getUnit() == null ? 0 : 1);
	}

	@Override
	public void initializeOnInstantiation() throws PersistenceException {
		// TODO: implement method: initializeOnInstantiation

	}

	@Override
	public void copyingPrivateUserAttributes(final Anything copy) throws PersistenceException {
		// TODO: implement method: copyingPrivateUserAttributes

	}

	@Override
	public void initialize(final Anything This, final java.util.Hashtable<String, Object> final$$Fields)
			throws PersistenceException {
		this.setThis((PersistentQuantity) This);
		if (this.equals(This)) {
			this.setAmount((common.Fraction) final$$Fields.get("amount"));
			this.setUnit((PersistentAbsUnit) final$$Fields.get("unit"));
		}
	}

	@Override
	public void initializeOnCreation() throws PersistenceException {
		// TODO: implement method: initializeOnCreation

	}

	@Override
	public PersistentAbsQuantity sub(final PersistentAbsQuantity subtrahend) throws model.NotComputableException,
			PersistenceException {

		if (!this.isArgumentCompound(subtrahend)) {
			// summand instanceof Quantity
			PersistentQuantity subtrahendCast = (PersistentQuantity) subtrahend;
			if (this.hasSameUnitAs(subtrahendCast))
				return this.simpleSub(subtrahendCast);

			if (!this.hasSameUnitTypeAs(subtrahendCast))
				throw new NotComputableException("Addition / Subtraktion nur mit gleichem Typ möglich!");

			return this.complexSub(subtrahendCast);

		} else {
			PersistentCompoundQuantity subtrahendCast = (PersistentCompoundQuantity) subtrahend;
			return subtrahendCast.sub(getThis());
		}
	}

	@Override
	public PersistentAbsQuantity mul(final PersistentAbsQuantity factor) throws model.NotComputableException,
			PersistenceException {
		if (!this.isArgumentCompound(factor)) {
			PersistentQuantity factorCast = (PersistentQuantity) factor;
			PersistentAbsQuantity result = null;
			// Errechne Konfiguration von getThis()
			java.util.Map<PersistentUnitType, Integer> myConfiguration = this.fetchUnitConfiguration(getThis()
					.getUnit().getType());

			// Errechne Konfiguration von factorCast.
			java.util.Map<PersistentUnitType, Integer> factorConfiguration = this.fetchUnitConfiguration(factorCast
					.getUnit().getType());

			// Errechne Ziel-Konfiguration
			java.util.Map<PersistentUnitType, Integer> targetConfiguration = this.calculateTargetConfiguration(
					myConfiguration, factorConfiguration);

			// Finde UnitType, der mit Zielkonfiguration übereinstimmt.
			PersistentAbsUnitType targetType = this.searchTargetUnitType(targetConfiguration);

			if (targetType == null) {
				throw new NotComputableException("Es gibt keinen UnitType, der der Ergebniskonfiguration entspricht");
			}

			// Finde Unit, die dem targetType entspricht.
			PersistentAbsUnit targetUnit = this.searchTargetUnit(targetType);
			try {
				Fraction product = getThis().getAmount().mul(factorCast.getAmount());
				result = QuantityManager.getTheQuantityManager().createQuantity(targetUnit, product);
				return result;
			} catch (Throwable e) {
				throw new NotComputableException(e.getMessage());
			}

		} else {
			PersistentCompoundQuantity factorCast = (PersistentCompoundQuantity) factor;
			return factorCast.mul(getThis());
		}
	}

	@Override
	public PersistentAbsQuantity div(final PersistentAbsQuantity divisor) throws model.NotComputableException,
			PersistenceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PersistentAbsQuantity add(final PersistentAbsQuantity summand) throws model.NotComputableException,
			PersistenceException {

		if (!this.isArgumentCompound(summand)) {
			// summand instanceof Quantity
			PersistentQuantity summandCast = (PersistentQuantity) summand;
			if (this.hasSameUnitAs(summandCast))
				return this.simpleAdd(summandCast);

			if (!this.hasSameUnitTypeAs(summandCast))
				throw new NotComputableException("Addition / Subtraktion nur mit gleichem Typ möglich!");

			return this.complexAdd(summandCast);

		} else {
			PersistentCompoundQuantity summandCast = (PersistentCompoundQuantity) summand;
			return summandCast.add(getThis());
		}
	}

	/* Start of protected part that is not overridden by persistence generator */
	private PersistentQuantity simpleAdd(PersistentQuantity summand) throws PersistenceException,
			NotComputableException {
		try {
			Fraction sum = getThis().getAmount().add(summand.getAmount());
			PersistentQuantity resultSimple = QuantityManager.getTheQuantityManager().createQuantity(
					getThis().getUnit(), sum);
			return resultSimple;
		} catch (Throwable e) {
			throw new NotComputableException(e.getMessage());
		}
	}

	private PersistentAbsQuantity simpleSub(PersistentQuantity minuend) throws PersistenceException,
			NotComputableException {
		Fraction difference;
		try {
			difference = getThis().getAmount().sub(minuend.getAmount());
			PersistentQuantity resultSimple = QuantityManager.getTheQuantityManager().createQuantity(
					getThis().getUnit(), difference);
			return resultSimple;
		} catch (Throwable e) {
			throw new NotComputableException(e.getMessage());
		}

	}

	private boolean hasSameUnitAs(PersistentQuantity summandCast) throws PersistenceException {
		return getThis().getUnit().equals(summandCast.getUnit());
	}

	private boolean hasSameUnitTypeAs(PersistentQuantity summandCast) throws PersistenceException {
		return getThis().getUnit().getType().equals(summandCast.getUnit().getType());
	}

	private PersistentAbsQuantity complexAdd(PersistentQuantity summandCast) throws PersistenceException {
		PersistentCompoundQuantity newCompoundQuantity = CompoundQuantity.createCompoundQuantity();
		newCompoundQuantity.getParts().add(getThis());
		newCompoundQuantity.getParts().add(summandCast);
		QuantityManager.getTheQuantityManager().getQuantities().add(newCompoundQuantity);
		return newCompoundQuantity;
	}

	private PersistentAbsQuantity complexSub(PersistentQuantity minuend) throws PersistenceException {
		PersistentCompoundQuantity newCompoundQuantity = CompoundQuantity.createCompoundQuantity();
		newCompoundQuantity.getParts().add(getThis());
		// minuend muss mit -1 vorher multipliziert werden!
		String fractionSearchString = "-" + minuend.getAmount().toString();
		try {
			FractionManager.getTheFractionManager().getFraction(fractionSearchString);
		} catch (NotFoundException e) {
			try {
				// TODO: evtl globale Konstante "-1" einführen?
				Fraction f = minuend.getAmount().mul(Fraction.parse("-1/1"));
				FractionManager.getTheFractionManager().addFraction(f.toString(), f);
				PersistentQuantity q = QuantityManager.getTheQuantityManager().createQuantity(minuend.getUnit(), f);
				newCompoundQuantity.getParts().add(q);
			} catch (Throwable e1) {
			}
		}
		QuantityManager.getTheQuantityManager().getQuantities().add(newCompoundQuantity);
		return newCompoundQuantity;
	}

	private boolean isArgumentCompound(PersistentAbsQuantity summand) throws PersistenceException {
		return summand.accept(new AbsQuantityReturnVisitor<Boolean>() {
			@Override
			public Boolean handleCompoundQuantity(PersistentCompoundQuantity compoundQuantity)
					throws PersistenceException {
				return true;
			}

			@Override
			public Boolean handleQuantity(PersistentQuantity quantity) throws PersistenceException {
				return false;
			}
		});
	}

	private boolean isUnitTypeCompound(PersistentAbsUnitType unitType) throws PersistenceException {
		return unitType.accept(new AbsUnitTypeReturnVisitor<Boolean>() {

			@Override
			public Boolean handleCompUnitType(PersistentCompUnitType compUnitType) throws PersistenceException {
				return true;
			}

			@Override
			public Boolean handleUnitType(PersistentUnitType unitType) throws PersistenceException {
				return false;
			}
		});
	}

	private Map<PersistentUnitType, Integer> fetchUnitConfiguration(PersistentAbsUnitType unitType)
			throws PersistenceException {
		return unitType.accept(new AbsUnitTypeReturnVisitor<Map<PersistentUnitType, Integer>>() {

			@Override
			public Map<PersistentUnitType, Integer> handleCompUnitType(PersistentCompUnitType compUnitType)
					throws PersistenceException {
				Map<PersistentUnitType, Integer> result = new HashMap<PersistentUnitType, Integer>();
				java.util.Iterator<PersistentReferenceType> iterator = compUnitType.getRefs().iterator();
				while (iterator.hasNext()) {
					PersistentReferenceType current = iterator.next();
					result.put(current.getRef(), (int) current.getExponent());
				}
				return result;
			}

			@Override
			public Map<PersistentUnitType, Integer> handleUnitType(PersistentUnitType unitType)
					throws PersistenceException {
				Map<PersistentUnitType, Integer> result = new HashMap<PersistentUnitType, Integer>();
				result.put(unitType, 1);
				return result;
			}
		});
	}

	private Map<PersistentUnitType, Integer> calculateTargetConfiguration(
			Map<PersistentUnitType, Integer> myConfiguration, Map<PersistentUnitType, Integer> factorConfiguration) {
		Map<PersistentUnitType, Integer> result = new HashMap<PersistentUnitType, Integer>();
		Iterator<PersistentUnitType> i = myConfiguration.keySet().iterator();

		while (i.hasNext()) {
			PersistentUnitType current = i.next();
			this.calculateTargetConfigurationEntry(myConfiguration, factorConfiguration, current, result);
		}

		i = factorConfiguration.keySet().iterator();
		while (i.hasNext()) {
			PersistentUnitType current = i.next();
			this.calculateTargetConfigurationEntry(factorConfiguration, myConfiguration, current, result);
		}

		return result;
	}

	private void calculateTargetConfigurationEntry(Map<PersistentUnitType, Integer> currentConfiguration,
			Map<PersistentUnitType, Integer> factorConfiguration, PersistentUnitType currentType,
			Map<PersistentUnitType, Integer> result) {
		if (result.get(currentType) != null)
			return;
		if (factorConfiguration.get(currentType) == null) {
			result.put(currentType, currentConfiguration.get(currentType));
			return;
		} else {
			result.put(currentType, currentConfiguration.get(currentType) + factorConfiguration.get(currentType));
		}
	}

	private PersistentAbsUnitType searchTargetUnitType(final Map<PersistentUnitType, Integer> targetConfiguration)
			throws PersistenceException {
		PersistentAbsUnitType result = null;
		if (targetConfiguration.size() == 1 & targetConfiguration.containsValue(1)) {
			// Ergebnistyp ist atomar
			result = UnitTypeManager.getTheUnitTypeManager().getAtomicUnitTypes()
					.findFirst(new Predcate<PersistentUnitType>() {

						@Override
						public boolean test(PersistentUnitType argument) throws PersistenceException {
							boolean result = false;
							if (argument.equals(targetConfiguration.keySet().iterator().next())) {
								result = true;
							}
							return result;
						}
					});
		} else {
			result = UnitTypeManager.getTheUnitTypeManager().getUnitTypes()
					.findFirst(new Predcate<PersistentAbsUnitType>() {

						@Override
						public boolean test(PersistentAbsUnitType argument) throws PersistenceException {
							boolean result = false;
							Iterator<PersistentUnitType> i = targetConfiguration.keySet().iterator();
							while (i.hasNext()) {
								PersistentUnitType current = i.next();
								if (!this.doTest(argument, current))
									break;
							}

							if (result == true
									& !(((PersistentCompUnitType) argument).getRefs().getList().getLength() != targetConfiguration
											.size()))
								result = false;

							return result;
						}

						private boolean doTest(PersistentAbsUnitType argument, PersistentUnitType current) {

							return false;
						}
					});

		}

		return result;

	}

	private PersistentAbsUnit searchTargetUnit(final PersistentAbsUnitType targetType) throws PersistenceException {
		Boolean isComp = targetType.accept(new AbsUnitTypeReturnVisitor<Boolean>() {

			@Override
			public Boolean handleCompUnitType(PersistentCompUnitType compUnitType) throws PersistenceException {
				return true;
			}

			@Override
			public Boolean handleUnitType(PersistentUnitType unitType) throws PersistenceException {
				return false;
			}
		});
		if (!isComp & (((PersistentUnitType) targetType).getDefaultUnit() != null)) {
			return ((PersistentUnitType) targetType).getDefaultUnit();
		} else {
			// nimm den erstbesten
			// TODO: klären, ob AbsUnitType auch eine DefaultUnit benötigt.
			return UnitTypeManager.getTheUnitTypeManager().getUnits().findFirst(new Predcate<PersistentAbsUnit>() {

				@Override
				public boolean test(PersistentAbsUnit argument) throws PersistenceException {
					boolean result = false;
					if (argument.getType().equals(targetType))
						result = true;
					return result;
				}
			});
		}
	}

	/* End of protected part that is not overridden by persistence generator */

}

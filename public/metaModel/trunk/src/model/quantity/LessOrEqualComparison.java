package model.quantity;

import java.util.Iterator;

import model.ConsistencyException;
import model.NotComputableException;
import model.UserException;
import model.visitor.AbsQuantityReturnExceptionVisitor;
import model.visitor.AbsQuantityReturnVisitor;
import model.visitor.AnythingExceptionVisitor;
import model.visitor.AnythingReturnExceptionVisitor;
import model.visitor.AnythingReturnVisitor;
import model.visitor.AnythingVisitor;
import persistence.AbstractPersistentRoot;
import persistence.Anything;
import persistence.ConnectionHandler;
import persistence.LessOrEqualComparisonProxi;
import persistence.PersistenceException;
import persistence.PersistentAbsQuantity;
import persistence.PersistentAbsUnitType;
import persistence.PersistentCompoundQuantity;
import persistence.PersistentLessOrEqualComparison;
import persistence.PersistentMBoolean;
import persistence.PersistentObject;
import persistence.PersistentProxi;
import persistence.PersistentQuantity;
import persistence.TDObserver;

import common.Fraction;

/* Additional import section end */

public class LessOrEqualComparison extends PersistentObject implements PersistentLessOrEqualComparison {

	/** Throws persistence exception if the object with the given id does not exist. */
	public static PersistentLessOrEqualComparison getById(final long objectId) throws PersistenceException {
		final long classId = ConnectionHandler.getTheConnectionHandler().theLessOrEqualComparisonFacade
				.getClass(objectId);
		return (PersistentLessOrEqualComparison) PersistentProxi.createProxi(objectId, classId);
	}

	public static PersistentLessOrEqualComparison createLessOrEqualComparison() throws PersistenceException {
		return createLessOrEqualComparison(false);
	}

	public static PersistentLessOrEqualComparison createLessOrEqualComparison(final boolean delayed$Persistence)
			throws PersistenceException {
		PersistentLessOrEqualComparison result = null;
		if (delayed$Persistence) {
			result = ConnectionHandler.getTheConnectionHandler().theLessOrEqualComparisonFacade
					.newDelayedLessOrEqualComparison();
			result.setDelayed$Persistence(true);
		} else {
			result = ConnectionHandler.getTheConnectionHandler().theLessOrEqualComparisonFacade
					.newLessOrEqualComparison(-1);
		}
		final java.util.Hashtable<String, Object> final$$Fields = new java.util.Hashtable<String, Object>();
		result.initialize(result, final$$Fields);
		result.initializeOnCreation();
		return result;
	}

	public static PersistentLessOrEqualComparison createLessOrEqualComparison(final boolean delayed$Persistence,
			final PersistentLessOrEqualComparison This) throws PersistenceException {
		PersistentLessOrEqualComparison result = null;
		if (delayed$Persistence) {
			result = ConnectionHandler.getTheConnectionHandler().theLessOrEqualComparisonFacade
					.newDelayedLessOrEqualComparison();
			result.setDelayed$Persistence(true);
		} else {
			result = ConnectionHandler.getTheConnectionHandler().theLessOrEqualComparisonFacade
					.newLessOrEqualComparison(-1);
		}
		final java.util.Hashtable<String, Object> final$$Fields = new java.util.Hashtable<String, Object>();
		result.initialize(This, final$$Fields);
		result.initializeOnCreation();
		return result;
	}

	@Override
	public java.util.Hashtable<String, Object> toHashtable(final java.util.Hashtable<String, Object> allResults,
			final int depth, final int essentialLevel, final boolean forGUI, final boolean leaf,
			final TDObserver tdObserver) throws PersistenceException {
		java.util.Hashtable<String, Object> result = null;
		if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth) {
			result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
			final AbstractPersistentRoot arg1 = this.getArg1();
			if (arg1 != null) {
				result.put("arg1", arg1.createProxiInformation(false, essentialLevel == 0));
				if (depth > 1) {
					arg1.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true, tdObserver);
				} else {
					if (forGUI && arg1.hasEssentialFields())
						arg1.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
				}
			}
			final AbstractPersistentRoot arg2 = this.getArg2();
			if (arg2 != null) {
				result.put("arg2", arg2.createProxiInformation(false, essentialLevel == 0));
				if (depth > 1) {
					arg2.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true, tdObserver);
				} else {
					if (forGUI && arg2.hasEssentialFields())
						arg2.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
				}
			}
			final String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
			if (leaf && !allResults.contains(uniqueKey))
				allResults.put(uniqueKey, result);
		}
		return result;
	}

	@Override
	public LessOrEqualComparison provideCopy() throws PersistenceException {
		LessOrEqualComparison result = this;
		result = new LessOrEqualComparison(this.getId());
		result.arg1 = this.arg1;
		result.arg2 = this.arg2;
		result.This = this.This;
		this.copyingPrivateUserAttributes(result);
		return result;
	}

	@Override
	public boolean hasEssentialFields() throws PersistenceException {
		return false;
	}

	protected PersistentAbsQuantity arg1;
	protected PersistentAbsQuantity arg2;
	protected PersistentLessOrEqualComparison This;

	public LessOrEqualComparison(final long id) throws persistence.PersistenceException {
		/* Shall not be used by clients for object construction! Use static create operation instead! */
		super(id);
	}

	static public long getTypeId() {
		return -380;
	}

	@Override
	public long getClassId() {
		return getTypeId();
	}

	@Override
	public void store() throws PersistenceException {
		if (!this.isDelayed$Persistence())
			return;
		if (this.getClassId() == -380)
			ConnectionHandler.getTheConnectionHandler().theLessOrEqualComparisonFacade.newLessOrEqualComparison(this
					.getId());
		super.store();

	}

	@Override
	public PersistentAbsQuantity getArg1() throws PersistenceException {
		return this.arg1;
	}

	@Override
	public void setArg1(final PersistentAbsQuantity newValue) throws PersistenceException {
		if (newValue == null)
			throw new PersistenceException("Null values not allowed!", 0);
		if (newValue.equals(this.arg1))
			return;
		final long objectId = newValue.getId();
		final long classId = newValue.getClassId();
		this.arg1 = (PersistentAbsQuantity) PersistentProxi.createProxi(objectId, classId);
	}

	@Override
	public PersistentAbsQuantity getArg2() throws PersistenceException {
		return this.arg2;
	}

	@Override
	public void setArg2(final PersistentAbsQuantity newValue) throws PersistenceException {
		if (newValue == null)
			throw new PersistenceException("Null values not allowed!", 0);
		if (newValue.equals(this.arg2))
			return;
		final long objectId = newValue.getId();
		final long classId = newValue.getClassId();
		this.arg2 = (PersistentAbsQuantity) PersistentProxi.createProxi(objectId, classId);
	}

	protected void setThis(final PersistentLessOrEqualComparison newValue) throws PersistenceException {
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
		this.This = (PersistentLessOrEqualComparison) PersistentProxi.createProxi(objectId, classId);
	}

	@Override
	public PersistentLessOrEqualComparison getThis() throws PersistenceException {
		if (this.This == null) {
			final PersistentLessOrEqualComparison result = new LessOrEqualComparisonProxi(this.getId());
			result.getTheObject();
			return result;
		}
		return this.This;
	}

	@Override
	public void accept(final AnythingVisitor visitor) throws PersistenceException {
		visitor.handleLessOrEqualComparison(this);
	}

	@Override
	public <R> R accept(final AnythingReturnVisitor<R> visitor) throws PersistenceException {
		return visitor.handleLessOrEqualComparison(this);
	}

	@Override
	public <E extends UserException> void accept(final AnythingExceptionVisitor<E> visitor)
			throws PersistenceException, E {
		visitor.handleLessOrEqualComparison(this);
	}

	@Override
	public <R, E extends UserException> R accept(final AnythingReturnExceptionVisitor<R, E> visitor)
			throws PersistenceException, E {
		return visitor.handleLessOrEqualComparison(this);
	}

	@Override
	public int getLeafInfo() throws PersistenceException {
		if (this.getArg1() != null)
			return 1;
		if (this.getArg2() != null)
			return 1;
		return 0;
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
	public PersistentMBoolean compareComp(final PersistentCompoundQuantity comp1, final PersistentCompoundQuantity comp2)
			throws model.NotComputableException, PersistenceException {

		return null;
		// TODO Kann weg, auch in GOJA
	}

	@Override
	public void initialize(final Anything This, final java.util.Hashtable<String, Object> final$$Fields)
			throws PersistenceException {
		this.setThis((PersistentLessOrEqualComparison) This);
		if (this.equals(This)) {
		}
	}

	@Override
	public PersistentMBoolean compareMixed(final PersistentCompoundQuantity comp, final PersistentQuantity atom) {

		return null;
		// TODO Kann weg, auch in GOJA

		// throws model.NotComputableException, PersistenceException {
		// if (!atom.getUnit().getType().equals(comp.getParts().iterator().next().getUnit().getType())) {
		// throw new model.NotComputableException("Die Typen stimmen nicht überein"); // TODO Fehlertext
		// }
		//
		// if (!this.checkForConversion(comp)) {
		// throw new model.NotComputableException("Es fehlt/fehlen eine/mehrere Conversion(s) für " + comp); // TODO
		// // Fehlertext
		// }
		// if (!this.checkForConversion(atom)) {
		// throw new model.NotComputableException("Es fehlt eine Conversion für " + atom); // TODO Fehlertext
		// }
		//
		// final Fraction compSum = Fraction.Null;
		// final Iterator<PersistentQuantity> i = comp.getParts().iterator();
		// while (i.hasNext()) {
		// final PersistentQuantity curQuantity = i.next();
		// try {
		// compSum.add(QuantityManager.getTheQuantityManager().convertAmount(curQuantity,
		// curQuantity.getUnit().getType().fetchDefaultUnit()));
		// } catch (final Throwable e) {
		// throw new model.NotComputableException("Es fehlt eine DefaultUnit für "
		// + curQuantity.getUnit().getType()); // TODO
		// // Fehlertext
		// }
		// }
		// try {
		// return atom.getAmount().isLessOrEqual(compSum);
		// } catch (final Throwable e) {
		// return null;
		// }
	}

	@Override
	public void initializeOnCreation() throws PersistenceException {
		// TODO: implement method: initializeOnCreation

	}

	@Override
	public PersistentMBoolean compare() throws model.NotComputableException, PersistenceException {
		final PersistentAbsQuantity myArg1 = getThis().getArg1();
		final PersistentAbsQuantity myArg2 = getThis().getArg2();

		// Prüfen, ob die Typen übereinstimmen
		final FetchQuantityUnitTypeVisitor fetchQuantityUnitTypeVisitor = new FetchQuantityUnitTypeVisitor();
		if (!myArg1.accept(fetchQuantityUnitTypeVisitor).equals(myArg2.accept(fetchQuantityUnitTypeVisitor))) {
			throw new model.NotComputableException("Die Typen stimmen nicht überein"); // TODO Fehlertext
		}

		final boolean convertUnits = !checkForSameUnits(myArg1, myArg2);

		// TODO compare the units of the quantities - in case of a full match, no conversions to defUnit is necessary
		final FetchQuantityAmountVisitor fetchQuantityAmountVisitor = new FetchQuantityAmountVisitor(convertUnits);
		final Fraction arg1Amount = myArg1.accept(fetchQuantityAmountVisitor);
		final Fraction arg2Amount = myArg2.accept(fetchQuantityAmountVisitor);
		try {
			return arg1Amount.isLessOrEqual(arg2Amount);
		} catch (final Throwable e) {
			return null;
		}
		// return getThis().getArg1().accept(new AbsQuantityReturnExceptionVisitor<PersistentMBoolean,
		// model.NotComputableException>() {
		//
		// @Override
		// public PersistentMBoolean handleCompoundQuantity(final PersistentCompoundQuantity compoundQuantity) throws
		// PersistenceException,
		// model.NotComputableException {
		// final boolean arg2Comp = LessOrEqualComparison.this.getThis().getArg2().accept(new
		// AbsQuantityReturnVisitor<Boolean>() {
		//
		// @Override
		// public Boolean handleCompoundQuantity(final PersistentCompoundQuantity compoundQuantity) throws
		// PersistenceException {
		// return true;
		// }
		//
		// @Override
		// public Boolean handleQuantity(final PersistentQuantity quantity) throws PersistenceException {
		// return false;
		// }
		// });
		// if (arg2Comp) {
		// return LessOrEqualComparison.this.getThis().compareComp(compoundQuantity,
		// (PersistentCompoundQuantity) LessOrEqualComparison.this.getThis().getArg2());
		// } else {
		// return LessOrEqualComparison.this.getThis().compareMixed(compoundQuantity,
		// (PersistentQuantity) LessOrEqualComparison.this.getThis().getArg2());
		// }
		//
		// }
		//
		// @Override
		// public PersistentMBoolean handleQuantity(final PersistentQuantity quantity) throws PersistenceException,
		// model.NotComputableException {
		// final boolean arg2Comp = LessOrEqualComparison.this.getThis().getArg2().accept(new
		// AbsQuantityReturnVisitor<Boolean>() {
		//
		// @Override
		// public Boolean handleCompoundQuantity(final PersistentCompoundQuantity compoundQuantity) throws
		// PersistenceException {
		// return true;
		// }
		//
		// @Override
		// public Boolean handleQuantity(final PersistentQuantity quantity) throws PersistenceException {
		// return false;
		// }
		// });
		// if (arg2Comp) {
		// return LessOrEqualComparison.this.getThis().compareMixed(
		// (PersistentCompoundQuantity) LessOrEqualComparison.this.getThis().getArg2(), quantity);
		// } else {
		// return LessOrEqualComparison.this.getThis().compareAtomar(quantity,
		// (PersistentQuantity) LessOrEqualComparison.this.getThis().getArg2());
		// }
		//
		// }
		// });
	}

	@Override
	public PersistentMBoolean compareAtomar(final PersistentQuantity arg1, final PersistentQuantity arg2)
			throws model.NotComputableException, PersistenceException {

		return null;
		// TODO Kann weg, auch in GOJA

		// PersistentMBoolean result = MFalse.getTheMFalse();
		// if (arg1.getUnit().getType().equals(arg2.getUnit().getType())) {
		// if (arg1.getUnit().equals(arg2.getUnit())) {
		// try {
		// result = arg1.getAmount().isLessOrEqual(arg2.getAmount());
		// } catch (final Throwable e) {
		// throw new model.NotComputableException(e.getMessage());
		// }
		// } else {
		// QuantityManager.getTheQuantityManager().convert(arg1, arg2.getUnit());
		// try {
		// return arg1.getAmount().isLessOrEqual(arg2.getAmount());
		// } catch (final Throwable e) {
		// throw new model.NotComputableException(e.getMessage());
		// }
		// }
		// } else {
		// throw new model.NotComputableException(ExceptionConstants.NOT_COMPARABLE_UT);
		// }
		// return result;
	}

	/* Start of protected part that is not overridden by persistence generator */
	//
	// private boolean checkForConversion(final PersistentQuantity atom) throws PersistenceException {
	// return atom.getUnit().accept(new AbsUnitReturnVisitor<Boolean>() {
	//
	// @Override
	// public Boolean handleUnit(final PersistentUnit unit) throws PersistenceException {
	// return LessOrEqualComparison.this.checkForConversion(unit);
	// }
	//
	// @Override
	// public Boolean handleCompUnit(final PersistentCompUnit compUnit) throws PersistenceException {
	// return LessOrEqualComparison.this.checkForConversion(compUnit);
	// }
	// }).booleanValue();
	// }
	//
	// protected Boolean checkForConversion(final PersistentCompUnit compUnit) throws PersistenceException {
	// final Iterator<PersistentReference> i = compUnit.getRefs().iterator();
	// while (i.hasNext()) {
	// final PersistentReference curRef = i.next();
	// if (!this.checkForConversion(curRef.getRef()))
	// return false;
	// }
	// return null;
	// }
	//
	// protected Boolean checkForConversion(final PersistentUnit unit) throws PersistenceException {
	// return unit.getMyConversion() != null;
	// }
	//
	// private boolean checkForConversion(final PersistentCompoundQuantity comp) throws PersistenceException {
	// final Iterator<PersistentQuantity> i = comp.getParts().iterator();
	// while (i.hasNext()) {
	// final PersistentQuantity curQuantity = i.next();
	// if (!this.checkForConversion(curQuantity))
	// return false;
	// }
	// return true;
	// }

	private class FetchQuantityAmountVisitor implements
			AbsQuantityReturnExceptionVisitor<Fraction, model.NotComputableException> {

		public boolean convertUnits;

		public FetchQuantityAmountVisitor(final boolean convertUnits) {
			super();
			this.convertUnits = convertUnits;
		}

		@Override
		public Fraction handleCompoundQuantity(final PersistentCompoundQuantity compoundQuantity)
				throws PersistenceException, NotComputableException {
			Fraction compSum = Fraction.Null;
			final Iterator<PersistentQuantity> i = compoundQuantity.getParts().iterator();
			while (i.hasNext()) {
				final PersistentQuantity curQuantity = i.next();
				try {
					if (this.convertUnits) {
						compSum = compSum.add(QuantityManager.getTheQuantityManager().convertAmount(curQuantity,
								curQuantity.getUnit().getType().fetchDefaultUnit()));
					} else {
						compSum = compSum.add(curQuantity.getAmount());
					}
				} catch (final Throwable e) {
					throw new model.NotComputableException("Es fehlt eine DefaultUnit für "
							+ curQuantity.getUnit().getType()); // TODO
																// Fehlertext
				}
			}
			return compSum;
		}

		@Override
		public Fraction handleQuantity(final PersistentQuantity quantity) throws PersistenceException,
				NotComputableException {
			if (this.convertUnits) {
				try {
					return QuantityManager.getTheQuantityManager().convertAmount(quantity,
							quantity.getUnit().getType().fetchDefaultUnit());
				} catch (final ConsistencyException e) {
					throw new NotComputableException(e.getMessage());
				}
			}
			return quantity.getAmount();
		}
	}

	private class FetchQuantityUnitTypeVisitor implements AbsQuantityReturnVisitor<PersistentAbsUnitType> {

		@Override
		public PersistentAbsUnitType handleCompoundQuantity(final PersistentCompoundQuantity compoundQuantity)
				throws PersistenceException {
			return compoundQuantity.getParts().iterator().next().getUnit().getType();
		}

		@Override
		public PersistentAbsUnitType handleQuantity(final PersistentQuantity quantity) throws PersistenceException {
			return quantity.getUnit().getType();
		}
	}

	private boolean checkForSameUnits(final PersistentAbsQuantity myArg1, final PersistentAbsQuantity myArg2)
			throws PersistenceException {
		final PersistentQuantity quantity1 = myArg1.accept(new AbsQuantityReturnVisitor<PersistentQuantity>() {

			@Override
			public PersistentQuantity handleCompoundQuantity(final PersistentCompoundQuantity compoundQuantity)
					throws PersistenceException {
				return null;
			}

			@Override
			public PersistentQuantity handleQuantity(final PersistentQuantity quantity) throws PersistenceException {
				return quantity;
			}
		});
		if (quantity1 == null)
			return false;

		return myArg2.accept(new AbsQuantityReturnVisitor<Boolean>() {

			@Override
			public Boolean handleCompoundQuantity(final PersistentCompoundQuantity compoundQuantity)
					throws PersistenceException {
				return false;
			}

			@Override
			public Boolean handleQuantity(final PersistentQuantity quantity) throws PersistenceException {
				return quantity1.getUnit().equals(quantity.getUnit());
			}
		});
	}
	/* End of protected part that is not overridden by persistence generator */

}

package model.quantity;

import java.util.Iterator;
import java.util.Map;

import model.DoubleDefinitionException;
import model.NotComputableException;
import persistence.AbstractPersistentRoot;
import persistence.Anything;
import persistence.ConnectionHandler;
import persistence.PersistenceException;
import persistence.PersistentAbsQuantity;
import persistence.PersistentAbsUnit;
import persistence.PersistentAbsUnitType;
import persistence.PersistentBasicCalculation;
import persistence.PersistentCompoundQuantity;
import persistence.PersistentProxi;
import persistence.PersistentQuantity;
import persistence.PersistentUnit;
import persistence.PersistentUnitMutabCalc;
import persistence.PersistentUnitType;
import persistence.Predcate;
import persistence.ReferenceSearchList;
import persistence.TDObserver;

import common.Fraction;
import common.SummableHashMap;

/* Additional import section end */

public abstract class UnitMutabCalc extends model.quantity.BasicCalculation implements PersistentUnitMutabCalc {

	@Override
	public java.util.Hashtable<String, Object> toHashtable(final java.util.Hashtable<String, Object> allResults, final int depth,
			final int essentialLevel, final boolean forGUI, final boolean leaf, final TDObserver tdObserver) throws PersistenceException {
		java.util.Hashtable<String, Object> result = null;
		if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth) {
			result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
			final AbstractPersistentRoot targetUnit = this.getTargetUnit();
			if (targetUnit != null) {
				result.put("targetUnit", targetUnit.createProxiInformation(false, essentialLevel == 0));
				if (depth > 1) {
					targetUnit.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true, tdObserver);
				} else {
					if (forGUI && targetUnit.hasEssentialFields())
						targetUnit.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
				}
			}
			final AbstractPersistentRoot targetUnitType = this.getTargetUnitType();
			if (targetUnitType != null) {
				result.put("targetUnitType", targetUnitType.createProxiInformation(false, essentialLevel == 0));
				if (depth > 1) {
					targetUnitType.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true, tdObserver);
				} else {
					if (forGUI && targetUnitType.hasEssentialFields())
						targetUnitType.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
				}
			}
			final String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
			if (leaf && !allResults.contains(uniqueKey))
				allResults.put(uniqueKey, result);
		}
		return result;
	}

	@Override
	public abstract UnitMutabCalc provideCopy() throws PersistenceException;

	@Override
	public boolean hasEssentialFields() throws PersistenceException {
		return false;
	}

	protected PersistentAbsUnit targetUnit;
	protected PersistentAbsUnitType targetUnitType;

	public UnitMutabCalc(final PersistentAbsQuantity arg1, final PersistentAbsQuantity arg2, final PersistentAbsQuantity resultt,
			final PersistentBasicCalculation This, final PersistentAbsUnit targetUnit, final PersistentAbsUnitType targetUnitType, final long id)
			throws persistence.PersistenceException {
		/* Shall not be used by clients for object construction! Use static create operation instead! */
		super(arg1, arg2, resultt, This, id);
		this.targetUnit = targetUnit;
		this.targetUnitType = targetUnitType;
	}

	static public long getTypeId() {
		return 334;
	}

	@Override
	public long getClassId() {
		return getTypeId();
	}

	@Override
	public void store() throws PersistenceException {
		if (!this.isDelayed$Persistence())
			return;
		super.store();
		if (this.getTargetUnit() != null) {
			this.getTargetUnit().store();
			ConnectionHandler.getTheConnectionHandler().theUnitMutabCalcFacade.targetUnitSet(this.getId(), getTargetUnit());
		}
		if (this.getTargetUnitType() != null) {
			this.getTargetUnitType().store();
			ConnectionHandler.getTheConnectionHandler().theUnitMutabCalcFacade.targetUnitTypeSet(this.getId(), getTargetUnitType());
		}

	}

	@Override
	public PersistentAbsUnit getTargetUnit() throws PersistenceException {
		return this.targetUnit;
	}

	@Override
	public void setTargetUnit(final PersistentAbsUnit newValue) throws PersistenceException {
		if (newValue == null)
			throw new PersistenceException("Null values not allowed!", 0);
		if (newValue.equals(this.targetUnit))
			return;
		final long objectId = newValue.getId();
		final long classId = newValue.getClassId();
		this.targetUnit = (PersistentAbsUnit) PersistentProxi.createProxi(objectId, classId);
		if (!this.isDelayed$Persistence()) {
			newValue.store();
			ConnectionHandler.getTheConnectionHandler().theUnitMutabCalcFacade.targetUnitSet(this.getId(), newValue);
		}
	}

	@Override
	public PersistentAbsUnitType getTargetUnitType() throws PersistenceException {
		return this.targetUnitType;
	}

	@Override
	public void setTargetUnitType(final PersistentAbsUnitType newValue) throws PersistenceException {
		if (newValue == null)
			throw new PersistenceException("Null values not allowed!", 0);
		if (newValue.equals(this.targetUnitType))
			return;
		final long objectId = newValue.getId();
		final long classId = newValue.getClassId();
		this.targetUnitType = (PersistentAbsUnitType) PersistentProxi.createProxi(objectId, classId);
		if (!this.isDelayed$Persistence()) {
			newValue.store();
			ConnectionHandler.getTheConnectionHandler().theUnitMutabCalcFacade.targetUnitTypeSet(this.getId(), newValue);
		}
	}

	@Override
	public abstract PersistentUnitMutabCalc getThis() throws PersistenceException;

	@Override
	public void initialize(final Anything This, final java.util.Hashtable<String, Object> final$$Fields) throws PersistenceException {
		this.setThis((PersistentUnitMutabCalc) This);
		if (this.equals(This)) {
		}
	}

	// Start of section that contains operations that must be implemented.

	@Override
	public void copyingPrivateUserAttributes(final Anything copy) throws PersistenceException {
		// TODO: implement method: copyingPrivateUserAttributes

	}

	@Override
	public void initializeOnCreation() throws PersistenceException {
	}

	@Override
	public void initializeOnInstantiation() throws PersistenceException {
		// TODO: implement method: initializeOnInstantiation

	}

	// Start of section that contains overridden operations only.

	@Override
	public void calc1Compound1Atomar(final PersistentQuantity atom, final PersistentCompoundQuantity comp) throws model.NotComputableException,
			PersistenceException {
		getThis().setResultt(this.doCalc1Compound1Atomar(atom, comp));
	}

	@Override
	public void calcAtomar(final PersistentQuantity atom1, final PersistentQuantity atom2) throws model.NotComputableException, PersistenceException {
		getThis().setResultt(this.doCalcAtomar(atom1, atom2));

	}

	@Override
	public void calcComp(final PersistentCompoundQuantity comp1, final PersistentCompoundQuantity comp2) throws model.NotComputableException,
			PersistenceException {
		final PersistentCompoundQuantity result = CompoundQuantity.createCompoundQuantity();

		// über comp1 iterieren
		final Iterator<PersistentQuantity> i1 = comp1.getParts().iterator();
		while (i1.hasNext()) {
			final PersistentQuantity i1_current = i1.next();
			// über comp2 iterieren
			final Iterator<PersistentQuantity> i2 = comp2.getParts().iterator();
			while (i2.hasNext()) {
				final PersistentQuantity i2_current = i2.next();
				final PersistentQuantity i1_current_o_i2_current = this.doCalcAtomar(i1_current, i2_current);
				result.getParts().add(i1_current_o_i2_current);
			}
		}

	}

	@Override
	public void createTargetUnitType() throws model.NotComputableException, PersistenceException {
		// TODO Kann weg (auch in goja)

	}

	@Override
	public void createTargetUnit() throws model.NotComputableException, PersistenceException {
		// TODO Kann weg (auch in goja)

	}

	@Override
	public void findTargetUnitType() throws model.NotComputableException, PersistenceException {
		// TODO Kann weg (auch in goja)

		// PersistentAbsUnitType result = null;
		// if (targetRefTypes.getMap().isEmpty()) {
		// result = null;
		// }
		// if (targetRefTypes.getMap().size() == 1
		// & targetRefTypes.getMap().values().iterator().next().equals(new Long(1))) {
		// result = targetRefTypes.getMap().keySet().iterator().next();
		// }
		//
		//
		// final ReferenceTypeSearchList refTypeList = new ReferenceTypeSearchList();
		// for (final Map.Entry<PersistentUnitType, Long> entry : targetRefTypes.getMap().entrySet()) {
		// final Long exponent = entry.getValue();
		// if (exponent != 0) {
		// refTypeList.add(UnitTypeManager.getTheUnitTypeManager().fetchReferenceType(entry.getKey(), exponent));
		// }
		// }
		//
		// result = UnitTypeManager.getTheUnitTypeManager().getUnitTypes()
		// .findFirst(new Predcate<PersistentAbsUnitType>() {
		//
		// @Override
		// public boolean test(final PersistentAbsUnitType argument) throws PersistenceException {
		// return argument.accept(new AbsUnitTypeReturnVisitor<Boolean>() {
		//
		// @Override
		// public Boolean handleCompUnitType(final PersistentCompUnitType compUnitType)
		// throws PersistenceException {
		// if (!(compUnitType.getRefs().getLength() == targetRefTypes.getMap().size())) {
		// return false;
		// }
		// final Iterator<PersistentReferenceType> i = compUnitType.getRefs().iterator();
		// boolean currentResult = true;
		// while (i.hasNext() & currentResult) {
		// final PersistentReferenceType rt = i.next();
		// final PersistentUnitType ut = rt.getRef();
		// final Long exponent = rt.getExponent();
		//
		// if (!targetRefTypes.getMap().containsKey(ut)
		// && exponent.equals(targetRefTypes.getMap().get(ut))) {
		// currentResult = false;
		// }
		// }
		// return currentResult;
		// }
		//
		// @Override
		// public Boolean handleUnitType(final PersistentUnitType unitType)
		// throws PersistenceException {
		// return false;
		// }
		// });
		// }
		// });
		//
		// this.targetUnitType = result;
	}

	@Override
	public void findTargetUnit() throws model.NotComputableException, PersistenceException {
		PersistentAbsUnit result = null;
		// TODO: neue Exception, wenn result null bleibt?
		boolean targetTypeIsScalar = false;
		boolean targetTypeIsAtomar = false;

		if (targetRefs.getMap().isEmpty()) {
			targetTypeIsScalar = true;
		}

		if ((targetRefs.getMap().size() == 1) & (targetRefs.getMap().values().iterator().next().equals(new Long(1)))) {
			targetTypeIsAtomar = true;
		}

		if (targetTypeIsScalar) {
			result = UnitTypeManager.getTheUnitTypeManager().fetchScalar();
		}

		if (targetTypeIsAtomar) { // bedeutet aber auch, dass ein Faktor skalar sein kann ODER z.B. (m^2/s) * (s/m)

			result = UnitTypeManager.getTheUnitTypeManager().getUnits().findFirst(new Predcate<PersistentAbsUnit>() {

				@Override
				public boolean test(final PersistentAbsUnit argument) throws PersistenceException {
					boolean result = false;
					if (argument.equals(targetRefs.getMap().keySet().iterator().next())) {
						result = true;
					}
					return result;
				}

			});
		} else {

			final ReferenceSearchList refList = new ReferenceSearchList();
			for (final Map.Entry<PersistentUnit, Long> entry : targetRefs.getMap().entrySet()) {
				final Long exponent = entry.getValue();
				if (exponent != 0) {
					refList.add(UnitTypeManager.getTheUnitTypeManager().fetchReference(entry.getKey(), exponent));
				}
			}
			try {
				result = UnitTypeManager.getTheUnitTypeManager().fetchCU("", refList);
			} catch (final DoubleDefinitionException e) {
				e.printStackTrace();
			}
			// result = UnitTypeManager.getTheUnitTypeManager().getUnits().findFirst(new Predcate<PersistentAbsUnit>() {
			//
			// @Override
			// public boolean test(final PersistentAbsUnit argument) throws PersistenceException {
			//
			// boolean result = false;
			//
			// result = argument.accept(new AbsUnitReturnVisitor<Boolean>() {
			// // TO DO: evtl eine Operation getAllCompoundUnits() bereitstellen. Würde den Code verkürzen.
			// @Override
			// public Boolean handleUnit(final PersistentUnit unit) throws PersistenceException {
			// return false;
			// }
			//
			// @Override
			// public Boolean handleCompUnit(final PersistentCompUnit compUnit) throws PersistenceException {
			// boolean result = false;
			// final Iterator<PersistentReference> i = compUnit.getRefs().iterator();
			// while (i.hasNext()) {
			// final PersistentReference current = i.next();
			// final PersistentUnit actUnit = current.getRef();
			// final Long actExponent = current.getExponent();
			//
			// if (!targetRefs.getMap().containsKey(actUnit)) {
			// result = false;
			// break;
			// }
			// if (!actExponent.equals(targetRefs.getMap().get(actUnit))) {
			// result = false;
			// break;
			// }
			// result = true;
			//
			// }
			// return result;
			// }
			// });
			// return result;
			// }
			// });
		}

		this.targetUnit = result;

	}

	/* Start of protected part that is not overridden by persistence generator */

	protected SummableHashMap<PersistentUnit> targetRefs;
	protected SummableHashMap<PersistentUnitType> targetRefTypes;

	// private String errorMessageNoUnitFound(final SummableHashMap<PersistentUnit> referenceMap, final
	// PersistentAbsUnitType unitType) {
	// final String s1 = "Es wurde keine Einheit mit folgender Ausprägung gefunden: ";
	// String unitReferenceSet = TextConstants.CURLY_BRACKET_OPEN;
	// final Iterator<PersistentUnit> i = referenceMap.getMap().keySet().iterator();
	// while (i.hasNext()) {
	// String currentUnitReferenceString = "";
	// final PersistentUnit current = i.next();
	// if (!i.hasNext()) {
	// currentUnitReferenceString = current.toString() + TextConstants.POWER +
	// referenceMap.getMap().get(current).toString()
	// + TextConstants.CURLY_BRACKET_CLOSED + TextConstants.SPACE;
	// } else {
	// currentUnitReferenceString = current.toString() + TextConstants.POWER +
	// referenceMap.getMap().get(current).toString()
	// + TextConstants.SEMICOLON + TextConstants.SPACE;
	// }
	// unitReferenceSet = unitReferenceSet + currentUnitReferenceString;
	// }
	// final String s2 = "Bitte Einheit mit dieser Ausprägung erstellen, welche in " + unitType.toString()
	// + " typisiert ist. Noch keine Automatische Einheits-Generierung verfügbar.";
	//
	// return s1 + unitReferenceSet + s2;
	// }
	//
	// private String errorMessageNoUnitTypeFound(final SummableHashMap<PersistentUnitType> referenceTypeMap) {
	// final String s1 = "Es existiert kein Einheitstyp mit folgender Ausprägung: ";
	// String unitReferenceTypeSet = TextConstants.CURLY_BRACKET_OPEN;
	// final Iterator<PersistentUnitType> i = referenceTypeMap.getMap().keySet().iterator();
	// while (i.hasNext()) {
	// String currentUnitReferenceTypeString = "";
	// final PersistentUnitType current = i.next();
	// if (!i.hasNext()) {
	// currentUnitReferenceTypeString = current.toString() + TextConstants.POWER +
	// referenceTypeMap.getMap().get(current).toString()
	// + TextConstants.CURLY_BRACKET_CLOSED + TextConstants.SPACE;
	// } else {
	// currentUnitReferenceTypeString = current.toString() + TextConstants.POWER +
	// referenceTypeMap.getMap().get(current).toString()
	// + TextConstants.SEMICOLON + TextConstants.SPACE;
	// }
	// unitReferenceTypeSet = unitReferenceTypeSet + currentUnitReferenceTypeString;
	// }
	// final String s2 = " Bitte Einheitstyp und Einheit anlegen";
	// return s1 + unitReferenceTypeSet + s2;
	//
	// }

	private PersistentQuantity doCalcAtomar(final PersistentQuantity atom1, final PersistentQuantity atom2) throws NotComputableException,
			PersistenceException {
		getThis().calcTargetRefs(atom1, atom2);
		getThis().findTargetUnit();
		// if (getThis().getTargetUnit() != null) {
		// // Zieleinheit im Modell vorhanden
		// } else {
		// // Zieleinheit muss anhand der Typebene gefunden werden
		// getThis().calcTargetRefTypes(atom1, atom2);
		// // getThis().findTargetUnitType();
		// this.targetUnitType = this.getTargetUnit().getType();
		// if (getThis().getTargetUnitType() != null) {
		// // Zieleinheitstyp im Modell vorhanden
		// throw new model.NotComputableException(errorMessageNoUnitFound(targetRefs, getThis().getTargetUnitType()));
		// // TO DO: automatisch Einheit erstellen und umrechnen, falls es Conversions gibt.
		// } else {
		// throw new model.NotComputableException(errorMessageNoUnitTypeFound(targetRefTypes));
		// // TO DO: automatisch Typ + Einheit erstellen.
		// }
		// }

		// Zieleinheit bestimmt. Ergebnis-Quantität kann berechnet werden.
		final Fraction amount = getThis().calcFraction(atom1.getAmount(), atom2.getAmount());
		final PersistentQuantity result = QuantityManager.getTheQuantityManager().createQuantity(getThis().getTargetUnit(), amount);
		return result;

	}

	private PersistentAbsQuantity doCalc1Compound1Atomar(final PersistentQuantity atom, final PersistentCompoundQuantity comp)
			throws PersistenceException, NotComputableException {
		final PersistentCompoundQuantity result = CompoundQuantity.createCompoundQuantity();
		final Iterator<PersistentQuantity> i = comp.getParts().iterator();
		while (i.hasNext()) {
			final PersistentQuantity q = i.next();
			final PersistentQuantity currentResult = doCalcAtomar(q, atom);
			result.getParts().add(currentResult);
		}
		return result;
	}

	/* End of protected part that is not overridden by persistence generator */

}

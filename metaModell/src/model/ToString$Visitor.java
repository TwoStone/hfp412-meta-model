package model;

import java.util.Iterator;

import model.visitor.MBooleanVisitor;
import persistence.Anything;
import persistence.PersistenceException;
import persistence.PersistentAccount;
import persistence.PersistentAccountManager;
import persistence.PersistentAccountTypeManager;
import persistence.PersistentActualParameter;
import persistence.PersistentAddition;
import persistence.PersistentAspectManager;
import persistence.PersistentAssociation;
import persistence.PersistentAssociationManager;
import persistence.PersistentAvgStrategy;
import persistence.PersistentCompUnit;
import persistence.PersistentCompUnitType;
import persistence.PersistentCompoundQuantity;
import persistence.PersistentConversion;
import persistence.PersistentDivision;
import persistence.PersistentEnumValueManager;
import persistence.PersistentEnumerationManager;
import persistence.PersistentFormalParameter;
import persistence.PersistentFractionManager;
import persistence.PersistentFractionWrapper;
import persistence.PersistentFunction;
import persistence.PersistentFunctionManager;
import persistence.PersistentHierarchy;
import persistence.PersistentLessOrEqualComparison;
import persistence.PersistentLink;
import persistence.PersistentLinkManager;
import persistence.PersistentMAccountType;
import persistence.PersistentMAspect;
import persistence.PersistentMAtomicType;
import persistence.PersistentMEmptyTypeConjunction;
import persistence.PersistentMEmptyTypeDisjunction;
import persistence.PersistentMEnum;
import persistence.PersistentMEnumValue;
import persistence.PersistentMFalse;
import persistence.PersistentMMeasurementType;
import persistence.PersistentMMixedConjunction;
import persistence.PersistentMMixedTypeDisjunction;
import persistence.PersistentMNonEmptyAtomicTypeConjunction;
import persistence.PersistentMNonEmptyDisjunctiveNormalForm;
import persistence.PersistentMObject;
import persistence.PersistentMObservation;
import persistence.PersistentMObservationType;
import persistence.PersistentMSingletonObject;
import persistence.PersistentMTrue;
import persistence.PersistentMaxStrategy;
import persistence.PersistentMeasurement;
import persistence.PersistentMeasurementTypeManager;
import persistence.PersistentMessage;
import persistence.PersistentMessageManager;
import persistence.PersistentMinStrategy;
import persistence.PersistentMultiplication;
import persistence.PersistentName;
import persistence.PersistentNameInstance;
import persistence.PersistentNameScheme;
import persistence.PersistentNameSchemeInstance;
import persistence.PersistentNameSchemeManager;
import persistence.PersistentObjectManager;
import persistence.PersistentObsTypeManager;
import persistence.PersistentObservationManager;
import persistence.PersistentOperation;
import persistence.PersistentOperationManager;
import persistence.PersistentQuantity;
import persistence.PersistentQuantityManager;
import persistence.PersistentReference;
import persistence.PersistentReferenceType;
import persistence.PersistentServer;
import persistence.PersistentSubtraction;
import persistence.PersistentSumStrategy;
import persistence.PersistentTypeManager;
import persistence.PersistentUnit;
import persistence.PersistentUnitType;
import persistence.PersistentUnitTypeManager;
import utils.Strings;

import common.Fraction;

import constants.TextConstants;

public class ToString$Visitor extends model.visitor.ToString$Visitor {

	private static final boolean DEBUG_MODE_ON = true;

	private static final String DEBUG_PREFIX_NULL = "[null] ";

	private static final String APPENDIX_OF_PROXIES = "Proxi";

	private String result;

	public ToString$Visitor() {
	}

	public synchronized String toString(final Anything anything) throws PersistenceException {
		result = null;
		anything.accept(this);
		if (result == null) {
			this.standardHandling(anything);
		}
		if (DEBUG_MODE_ON) {
			result = this.formatClassNameForDebug(anything) + result;
		}
		return result;
	}

	/**
	 * Formatiert den Klassennamen des �bergebenen Objekts f�r die Debug-Ausgabe.
	 * 
	 * @param anything
	 *            Das zu formatierende Objekt
	 * @return F�r Debug-Ausgabe formatierter Klassenname
	 */
	private String formatClassNameForDebug(final Object anything) {
		if (anything == null) {
			return DEBUG_PREFIX_NULL;
		}

		String className = anything.getClass().getSimpleName();

		if (className == null) {
			return DEBUG_PREFIX_NULL;
		}

		if (className.contains("Manager")) {
			return "";
		}

		if (className.endsWith(APPENDIX_OF_PROXIES)) {
			className = className.substring(0, className.length() - APPENDIX_OF_PROXIES.length());
		}

		return "[" + className + "] ";
	}

	@Override
	protected void standardHandling(final Anything anything) {
		result = anything.getClassId() + ";" + anything.getId();
	}

	@Override
	public void handleMAtomicType(final PersistentMAtomicType mAtomicType) throws PersistenceException {
		result = mAtomicType.fetchName();
	}

	@Override
	public void handleTypeManager(final PersistentTypeManager typeManager) throws PersistenceException {
		result = "Liste der Typen";
	}

	@Override
	public void handleAspectManager(final PersistentAspectManager aspectManager) throws PersistenceException {
		result = "Liste der Aspekte";

	}

	@Override
	public void handleMAspect(final PersistentMAspect mAspect) throws PersistenceException {
		result = mAspect.getName();
	}

	@Override
	public void handleMFalse(final PersistentMFalse mFalse) throws PersistenceException {
		result = "false";
	}

	@Override
	public void handleMTrue(final PersistentMTrue mTrue) throws PersistenceException {
		result = "true";
	}

	@Override
	public void handleAssociationManager(final PersistentAssociationManager associationManager) throws PersistenceException {
		result = "Liste der Assoziationen";
	}

	@Override
	public void handleHierarchy(final PersistentHierarchy hierarchy) throws PersistenceException {
		result = hierarchy.getName();
	}

	@Override
	public void handleAssociation(final PersistentAssociation association) throws PersistenceException {
		result = association.getName() + " (" + association.getSource().fetchName() + ")";
	}

	@Override
	public void handleQuantity(final PersistentQuantity quantity) throws PersistenceException {
		result = quantity.getAmount() + TextConstants.SPACE + quantity.getUnit().getName();

	}

	@Override
	public void handleCompoundQuantity(final PersistentCompoundQuantity compoundQuantity) throws PersistenceException {
		String currentResult = TextConstants.CURLY_BRACKET_OPEN;
		final Iterator<PersistentQuantity> i = compoundQuantity.getParts().iterator();
		while (i.hasNext()) {
			final PersistentQuantity q = i.next();
			if (!i.hasNext()) {
				currentResult = currentResult + q.toString() + TextConstants.CURLY_BRACKET_CLOSED;
			} else {
				currentResult = currentResult + TextConstants.SPACE + q.toString() + TextConstants.SEMICOLON;
			}
		}
		result = currentResult;

	}

	@Override
	public void handleReferenceType(final PersistentReferenceType referenceType) throws PersistenceException {
		this.result = referenceType.getRef() + "^" + referenceType.getExponent();
	}

	@Override
	public void handleQuantityManager(final PersistentQuantityManager quantityManager) throws PersistenceException {
		this.result = constants.TextConstants.LABEL_QUANTITY_MANAGER;
	}

	@Override
	public void handleUnitType(final PersistentUnitType unitType) throws PersistenceException {
		this.result = unitType.getName();

	}

	@Override
	public void handleUnit(final PersistentUnit unit) throws PersistenceException {
		this.result = unit.getName() + " (" + unit.getType().getName() + ")";

	}

	@Override
	public void handleServer(final PersistentServer server) throws PersistenceException {
		// TODO Auto-generated method stub

	}

	@Override
	public void handleReference(final PersistentReference reference) throws PersistenceException {
		this.result = reference.getRef() + "^" + reference.getExponent();
	}

	@Override
	public void handleConversion(final PersistentConversion conversion) throws PersistenceException {
		final PersistentUnit defaultUnit = ((PersistentUnitType) conversion.getSource().getType()).getDefaultUnit();
		if (defaultUnit == null)
			return;
		final Fraction m = conversion.getMyFunction().getFactor();
		final Fraction b = conversion.getMyFunction().getConstant();
		if (b.equals(Fraction.Null)) {
			this.result = "1 " + defaultUnit.getName() + " = " + m + " " + conversion.getSource().getName();
		} else {
			this.result = "y " + defaultUnit.getName() + " = (" + m + "*x + " + b + ") " + conversion.getSource().getName();
		}
	}

	@Override
	public void handleCompUnit(final PersistentCompUnit compUnit) throws PersistenceException {
		this.result = compUnit.getName() + " (" + compUnit.getType().getName() + ")";
	}

	@Override
	public void handleCompUnitType(final PersistentCompUnitType compUnitType) throws PersistenceException {
		this.result = compUnitType.getName();

	}

	@Override
	public void handleUnitTypeManager(final PersistentUnitTypeManager unitTypeManager) throws PersistenceException {
		this.result = constants.TextConstants.LABEL_UNIT_TYPE_MANAGER;

	}

	@Override
	public void handleFractionManager(final PersistentFractionManager fractionManager) throws PersistenceException {
		this.result = constants.TextConstants.LABEL_FRACTION_MANAGER;

	}

	@Override
	public void handleFunction(final PersistentFunction function) throws PersistenceException {
		this.result = "y = " + function.getFactor() + " * x + " + function.getConstant();

	}

	@Override
	public void handleMAccountType(final PersistentMAccountType mAccountType) throws PersistenceException {
		this.result = mAccountType.getName();

	}

	@Override
	public void handleMeasurement(final PersistentMeasurement measurement) throws PersistenceException {
		this.result = measurement.getQuantity().toString();
	}

	@Override
	public void handleOperation(final PersistentOperation operation) throws PersistenceException {
		final StringBuilder parameterListe = new StringBuilder();
		final Iterator<PersistentFormalParameter> iterator = operation.getParameters().iterator();
		PersistentFormalParameter current = null;
		int count = 0;
		while (iterator.hasNext()) {
			if (count == 0) {
				parameterListe.append(", ");
			}
			current = iterator.next();
			parameterListe.append(current.getName() + " : " + current.getOfType().toString());
			count++;
		}

		result = operation.getName() + "(" + parameterListe.toString() + ") : " + operation.getTarget().toString();
	}

	@Override
	public void handleAccount(final PersistentAccount account) throws PersistenceException {
		this.result = account.getName();
	}

	@Override
	public void handleMMeasurementType(final PersistentMMeasurementType mMeasurementType) throws PersistenceException {
		this.result = mMeasurementType.getName();
	}

	@Override
	public void handleFormalParameter(final PersistentFormalParameter formalParameter) throws PersistenceException {
		this.result = formalParameter.getName();
	}

	@Override
	public void handleMessage(final PersistentMessage message) throws PersistenceException {
		final PersistentMessage internalMessage = message;

		message.getType().isStatic().accept(new MBooleanVisitor() {

			@Override
			public void handleMTrue(final PersistentMTrue mTrue) throws PersistenceException {
				result = "";
			}

			@Override
			public void handleMFalse(final PersistentMFalse mFalse) throws PersistenceException {
				result = internalMessage.getSource().toString();
			}
		});
		result += "#" + message.getTarget().toString() + " " + message.getType().toString() + "(";

		final Iterator<PersistentActualParameter> it = message.getActualParameters().iterator();

		// Sonderbehandlung fuer den Ersten
		if (it.hasNext()) {
			result += it.next();
		}

		while (it.hasNext()) {
			result += ", " + it.next().toString();
		}

		result += ")";
	}

	@Override
	public void handleActualParameter(final PersistentActualParameter actualParameter) throws PersistenceException {
		this.result = actualParameter.getType().toString() + "=" + actualParameter.getValue().toString();
	}

	@Override
	public void handleLink(final PersistentLink link) throws PersistenceException {
		this.result = link.getSource().toString() + "." + link.getType().getName() + ">>" + link.getTarget().toString();
	}

	@Override
	public void handleMeasurementTypeManager(final PersistentMeasurementTypeManager measurementTypeManager) throws PersistenceException {
		this.result = constants.TextConstants.LABEL_MEASUREMENT_TYPE_MANAGER;
	}

	@Override
	public void handleAccountTypeManager(final PersistentAccountTypeManager accountTypeManager) throws PersistenceException {
		this.result = constants.TextConstants.LABEL_ACCOUNT_TYPE_MANAGER;
	}

	@Override
	public void handleAccountManager(final PersistentAccountManager accountManager) throws PersistenceException {
		this.result = constants.TextConstants.LABEL_ACCOUNT_MANAGER;
	}

	@Override
	public void handleMessageManager(final PersistentMessageManager messageManager) throws PersistenceException {
		this.result = "Liste der Nachrichten";
	}

	@Override
	public void handleOperationManager(final PersistentOperationManager operationManager) throws PersistenceException {
		this.result = "Liste der Operationen";
	}

	@Override
	public void handleLinkManager(final PersistentLinkManager linkManager) throws PersistenceException {
		this.result = "Liste der Links";
	}

	@Override
	public void handleMObject(final PersistentMObject mObject) throws PersistenceException {
		result = String.valueOf(mObject.getId());
		result += Strings.join(", ", mObject.getNames().iterator(), new Strings.ToStringStrategy<PersistentNameInstance>() {

			@Override
			public String getString(final PersistentNameInstance element) throws PersistenceException {
				return element.toString(true);
			}
		});
	}

	@Override
	public void handleObjectManager(final PersistentObjectManager objectManager) throws PersistenceException {
		this.result = "Liste der Objekte";
	}

	@Override
	public void handleNameSchemeInstance(final PersistentNameSchemeInstance nameSchemeInstance) throws PersistenceException {
		this.result = nameSchemeInstance.getName();
	}

	@Override
	public void handleNameScheme(final PersistentNameScheme nameScheme) throws PersistenceException {
		this.result = nameScheme.getName();
	}

	@Override
	public void handleNameInstance(final PersistentNameInstance nameInstance) throws PersistenceException {
		this.result = nameInstance.getNameScheme().getName() + "(" + nameInstance.getNameScheme().getType().getName() + ")";
	}

	@Override
	public void handleNameSchemeManager(final PersistentNameSchemeManager nameSchemeManager) throws PersistenceException {
		this.result = "Liste der Namensschemata";
	}

	@Override
	public void handleName(final PersistentName name) throws PersistenceException {
		this.result = name.getFromType().getName() + "->" + name.getNameScheme().getName();
	}

	@Override
	public void handleFunctionManager(final PersistentFunctionManager functionManager) throws PersistenceException {
		//

	}

	@Override
	public void handleFractionWrapper(final PersistentFractionWrapper fractionWrapper) throws PersistenceException {
		this.result = fractionWrapper.getFraction().toString();
	}

	@Override
	public void handleMSingletonObject(final PersistentMSingletonObject mSingletonObject) throws PersistenceException {
		this.result = " of " + mSingletonObject.getType().getName();
	}

	@Override
	public void handleMinStrategy(final PersistentMinStrategy minStrategy) throws PersistenceException {
		this.result = "Minimum-Aggregations-Strategie";
	}

	@Override
	public void handleAvgStrategy(final PersistentAvgStrategy avgStrategy) throws PersistenceException {
		this.result = "Arithmetisches-Mittel-Aggregations-Strategie";
	}

	@Override
	public void handleSumStrategy(final PersistentSumStrategy sumStrategy) throws PersistenceException {
		this.result = "Summen-Aggregations-Strategie";
	}

	@Override
	public void handleMaxStrategy(final PersistentMaxStrategy maxStrategy) throws PersistenceException {
		this.result = "Maximum-Aggregations-Strategie";
	}

	@Override
	public void handleMEmptyTypeDisjunction(final PersistentMEmptyTypeDisjunction mEmptyTypeDisjunction) throws PersistenceException {
		result = mEmptyTypeDisjunction.fetchName();
	}

	@Override
	public void handleMMixedConjunction(final PersistentMMixedConjunction mMixedConjunction) throws PersistenceException {
		result = mMixedConjunction.fetchName();
	}

	@Override
	public void handleMEmptyTypeConjunction(final PersistentMEmptyTypeConjunction mEmptyTypeConjunction) throws PersistenceException {
		result = mEmptyTypeConjunction.fetchName();
	}

	@Override
	public void handleMMixedTypeDisjunction(final PersistentMMixedTypeDisjunction mMixedTypeDisjunction) throws PersistenceException {
		result = mMixedTypeDisjunction.fetchName();
	}

	@Override
	public void handleMNonEmptyAtomicTypeConjunction(final PersistentMNonEmptyAtomicTypeConjunction mNonEmptyAtomicTypeConjunction)
			throws PersistenceException {
		result = mNonEmptyAtomicTypeConjunction.fetchName();
	}

	@Override
	public void handleMNonEmptyDisjunctiveNormalForm(final PersistentMNonEmptyDisjunctiveNormalForm mNonEmptyDisjunctiveNormalForm)
			throws PersistenceException {
		result = mNonEmptyDisjunctiveNormalForm.fetchName();
	}

	@Override
	public void handleMultiplication(final PersistentMultiplication multiplication) throws PersistenceException {
		// TODO Auto-generated method stub

	}

	@Override
	public void handleSubtraction(final PersistentSubtraction subtraction) throws PersistenceException {
		// TODO Auto-generated method stub

	}

	@Override
	public void handleAddition(final PersistentAddition addition) throws PersistenceException {
		// TODO Auto-generated method stub

	}

	@Override
	public void handleDivision(final PersistentDivision division) throws PersistenceException {
		// TODO Auto-generated method stub

	}

	@Override
	public void handleMEnum(final PersistentMEnum mEnum) throws PersistenceException {
		result = mEnum.getName();

	}

	@Override
	public void handleMObservationType(final PersistentMObservationType mObservationType) throws PersistenceException {
		result = mObservationType.getName();

	}

	@Override
	public void handleMObservation(final PersistentMObservation mObservation) throws PersistenceException {
		result = mObservation.getName();

	}

	@Override
	public void handleObservationManager(final PersistentObservationManager observationManager) throws PersistenceException {
		result = "Liste der Observationen";

	}

	@Override
	public void handleMEnumValue(final PersistentMEnumValue mEnumValue) throws PersistenceException {
		result = mEnumValue.getName();

	}

	@Override
	public void handleEnumerationManager(final PersistentEnumerationManager enumerationManager) throws PersistenceException {
		result = "Liste der Enumerationen";

	}

	@Override
	public void handleEnumValueManager(final PersistentEnumValueManager enumValueManager) throws PersistenceException {
		result = "Liste der Enum-Werte";
	}

	@Override
	public void handleObsTypeManager(final PersistentObsTypeManager obsTypeManager) throws PersistenceException {
		result = "Liste der Observationstypen";

	}

	@Override
	public void handleLessOrEqualComparison(final PersistentLessOrEqualComparison lessOrEqualComparison) throws PersistenceException {
		// TODO Auto-generated method stub

	}

}

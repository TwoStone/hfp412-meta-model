package model;

import model.visitor.MBooleanReturnVisitor;
import persistence.Anything;
import persistence.PersistenceException;
import persistence.PersistentAccount;
import persistence.PersistentAccountManager;
import persistence.PersistentAccountTypeManager;
import persistence.PersistentActualParameter;
import persistence.PersistentAspectManager;
import persistence.PersistentAssociationManager;
import persistence.PersistentCompUnit;
import persistence.PersistentCompUnitType;
import persistence.PersistentCompoundQuantity;
import persistence.PersistentConversion;
import persistence.PersistentConversionManager;
import persistence.PersistentFractionManager;
import persistence.PersistentFunction;
import persistence.PersistentInstanceObject;
import persistence.PersistentLink;
import persistence.PersistentMAHierarchy;
import persistence.PersistentMAbstractProductType;
import persistence.PersistentMAccountType;
import persistence.PersistentMAspect;
import persistence.PersistentMAssociation;
import persistence.PersistentMAtomicType;
import persistence.PersistentMEmptyProduct;
import persistence.PersistentMEmptySumType;
import persistence.PersistentMFalse;
import persistence.PersistentMFormalParameter;
import persistence.PersistentMMeasurementType;
import persistence.PersistentMOperation;
import persistence.PersistentMProductType;
import persistence.PersistentMSumType;
import persistence.PersistentMTrue;
import persistence.PersistentMeasurement;
import persistence.PersistentMeasurementTypeManager;
import persistence.PersistentMessage;
import persistence.PersistentQuantity;
import persistence.PersistentQuantityManager;
import persistence.PersistentReference;
import persistence.PersistentReferenceType;
import persistence.PersistentServer;
import persistence.PersistentTypeManager;
import persistence.PersistentUnit;
import persistence.PersistentUnitType;
import persistence.PersistentUnitTypeManager;

public class ToString$Visitor extends model.visitor.ToString$Visitor {

	private static final boolean DEBUG_MODE_ON = true;

	private static final String DEBUG_PREFIX_NULL = "[null] ";

	private static final String APPENDIX_OF_PROXIES = "Proxi";

	private String result;

	public ToString$Visitor() {
	}

	public synchronized String toString(Anything anything) throws PersistenceException {
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
	 * Formatiert den Klassennamen des übergebenen Objekts für die Debug-Ausgabe.
	 * 
	 * @param anything
	 *            Das zu formatierende Objekt
	 * @return Für Debug-Ausgabe formatierter Klassenname
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
	protected void standardHandling(Anything anything) {
		result = anything.getClassId() + ";" + anything.getId();
	}

	@Override
	public void handleMAtomicType(PersistentMAtomicType mAtomicType) throws PersistenceException {
		result = mAtomicType.fetchName();
	}

	@Override
	public void handleMProductType(PersistentMProductType mProductType) throws PersistenceException {
		result = mProductType.fetchName();

	}

	@Override
	public void handleMSumType(PersistentMSumType mSumType) throws PersistenceException {
		result = mSumType.fetchName();
	}

	@Override
	public void handleTypeManager(PersistentTypeManager typeManager) throws PersistenceException {
		result = "Liste der Typen";
	}

	@Override
	public void handleAspectManager(PersistentAspectManager aspectManager) throws PersistenceException {
		result = "Liste der Aspekte";

	}

	@Override
	public void handleMAspect(PersistentMAspect mAspect) throws PersistenceException {
		result = mAspect.getName();
	}

	@Override
	public void handleMFalse(PersistentMFalse mFalse) throws PersistenceException {
		result = "false";
	}

	@Override
	public void handleMTrue(PersistentMTrue mTrue) throws PersistenceException {
		result = "true";
	}

	@Override
	public void handleAssociationManager(PersistentAssociationManager associationManager) throws PersistenceException {
		result = "Liste der Assoziationen";
	}

	@Override
	public void handleMAHierarchy(PersistentMAHierarchy mAHierarchy) throws PersistenceException {
		result = mAHierarchy.getName();
	}

	@Override
	public void handleMAssociation(PersistentMAssociation mAssociation) throws PersistenceException {
		result = mAssociation.getName() + " (" + mAssociation.getSource().fetchName() + ")";
	}

	@Override
	public void handleQuantity(PersistentQuantity quantity) throws PersistenceException {
		// TODO Auto-generated method stub

	}

	@Override
	public void handleConversionManager(PersistentConversionManager conversionManager) throws PersistenceException {
		this.result = constants.TextConstants.LABEL_CONVERSION_MANAGER;
	}

	@Override
	public void handleCompoundQuantity(PersistentCompoundQuantity compoundQuantity) throws PersistenceException {
		// TODO Auto-generated method stub

	}

	@Override
	public void handleReferenceType(PersistentReferenceType referenceType) throws PersistenceException {
		this.result = referenceType.getRef() + "^" + referenceType.getExponent();
	}

	@Override
	public void handleQuantityManager(PersistentQuantityManager quantityManager) throws PersistenceException {
		this.result = constants.TextConstants.LABEL_QUANTITY_MANAGER;
	}

	@Override
	public void handleUnitType(PersistentUnitType unitType) throws PersistenceException {
		this.result = unitType.getName();

	}

	@Override
	public void handleUnit(PersistentUnit unit) throws PersistenceException {
		this.result = unit.getName() + " (" + unit.getType().getName() + ")";

	}

	@Override
	public void handleServer(PersistentServer server) throws PersistenceException {
		// TODO Auto-generated method stub

	}

	@Override
	public void handleReference(PersistentReference reference) throws PersistenceException {
		// TODO Auto-generated method stub

	}

	@Override
	public void handleConversion(PersistentConversion conversion) throws PersistenceException {
		// TODO Auto-generated method stub

	}

	@Override
	public void handleCompUnit(PersistentCompUnit compUnit) throws PersistenceException {
		this.result = compUnit.getName() + " (" + compUnit.getType().getName() + ")";
	}

	@Override
	public void handleCompUnitType(PersistentCompUnitType compUnitType) throws PersistenceException {
		String state = compUnitType.isFinal().accept(new MBooleanReturnVisitor<String>() {

			@Override
			public String handleMFalse(PersistentMFalse booleanFalse) throws PersistenceException {
				return " (draft)";
			}

			@Override
			public String handleMTrue(PersistentMTrue booleanTrue) throws PersistenceException {
				return "";
			}

		});
		this.result = compUnitType.getName() + state;

	}

	@Override
	public void handleUnitTypeManager(PersistentUnitTypeManager unitTypeManager) throws PersistenceException {
		this.result = constants.TextConstants.LABEL_UNIT_TYPE_MANAGER;

	}

	@Override
	public void handleFractionManager(PersistentFractionManager fractionManager) throws PersistenceException {
		this.result = constants.TextConstants.LABEL_FRACTION_MANAGER;

	}

	@Override
	public void handleFunction(PersistentFunction function) throws PersistenceException {
		// TODO Auto-generated method stub

	}

	@Override
	public void handleMEmptyProduct(PersistentMEmptyProduct mEmptyProduct) throws PersistenceException {
		result = "[Empty Product]";
	}

	@Override
	public void handleMEmptySumType(PersistentMEmptySumType mEmptySumType) throws PersistenceException {
		result = "[Empty Sum]";
	}

	@Override
	public void handleMAbstractProductType(PersistentMAbstractProductType mAbstractProductType)
			throws PersistenceException {
		result = "[AbstractProductType]";
	}

	@Override
	public void handleMAccountType(PersistentMAccountType mAccountType) throws PersistenceException {
		// TODO Auto-generated method stub

	}

	@Override
	public void handleMeasurement(PersistentMeasurement measurement) throws PersistenceException {
		// TODO Auto-generated method stub

	}

	@Override
	public void handleMOperation(PersistentMOperation mOperation) throws PersistenceException {
		// TODO Auto-generated method stub

	}

	@Override
	public void handleAccount(PersistentAccount account) throws PersistenceException {
		// TODO Auto-generated method stub

	}

	@Override
	public void handleMMeasurementType(PersistentMMeasurementType mMeasurementType) throws PersistenceException {
		// TODO Auto-generated method stub

	}

	@Override
	public void handleMFormalParameter(PersistentMFormalParameter mFormalParameter) throws PersistenceException {
		// TODO Auto-generated method stub

	}

	@Override
	public void handleInstanceObject(PersistentInstanceObject instanceObject) throws PersistenceException {
		// TODO Auto-generated method stub

	}

	@Override
	public void handleMessage(PersistentMessage message) throws PersistenceException {
		// TODO Auto-generated method stub

	}

	@Override
	public void handleActualParameter(PersistentActualParameter actualParameter) throws PersistenceException {
		// TODO Auto-generated method stub

	}

	@Override
	public void handleLink(PersistentLink link) throws PersistenceException {
		// TODO Auto-generated method stub

	}

	@Override
	public void handleMeasurementTypeManager(PersistentMeasurementTypeManager measurementTypeManager)
			throws PersistenceException {
		this.result = constants.TextConstants.LABEL_MEASUREMENT_TYPE_MANAGER;
	}

	@Override
	public void handleAccountTypeManager(PersistentAccountTypeManager accountTypeManager) throws PersistenceException {
		this.result = constants.TextConstants.LABEL_ACCOUNT_TYPE_MANAGER;
	}

	@Override
	public void handleAccountManager(PersistentAccountManager accountManager) throws PersistenceException {
		this.result = constants.TextConstants.LABEL_ACCOUNT_MANAGER;
	}
}

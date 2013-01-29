package model;

import java.util.Iterator;

import model.visitor.MBooleanReturnVisitor;
import model.visitor.MBooleanVisitor;
import persistence.*;
import utils.Strings;

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
	public void handleHierarchy(PersistentHierarchy hierarchy) throws PersistenceException {
		result = hierarchy.getName();
	}

	@Override
	public void handleAssociation(PersistentAssociation association) throws PersistenceException {
		result = association.getName() + " (" + association.getSource().fetchName() + ")";
	}

	@Override
	public void handleQuantity(PersistentQuantity quantity) throws PersistenceException {
		// TODO Auto-generated method stub

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
	public void handleMEmptyProductType(PersistentMEmptyProductType mEmptyProduct) throws PersistenceException {
		result = "[Empty Product]";
	}

	@Override
	public void handleMEmptySumType(PersistentMEmptySumType mEmptySumType) throws PersistenceException {
		result = "[Empty Sum]";
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
	public void handleOperation(PersistentOperation operation) throws PersistenceException {
		result = operation.getName();
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
	public void handleFormalParameter(PersistentFormalParameter formalParameter) throws PersistenceException {
		result = formalParameter.getName();
	}

	@Override
	public void handleInstanceObject(PersistentInstanceObject instanceObject) throws PersistenceException {
		// TODO Auto-generated method stub

	}

	@Override
	public void handleMessage(PersistentMessage message) throws PersistenceException {
		final PersistentMessage internalMessage = message;

		message.getType().isStatic().accept(new MBooleanVisitor() {

			@Override
			public void handleMTrue(PersistentMTrue mTrue) throws PersistenceException {
				result = "";
			}

			@Override
			public void handleMFalse(PersistentMFalse mFalse) throws PersistenceException {
				result = internalMessage.getSource().toString();
			}
		});
		result += "#" + message.getTarget().toString() + " " + message.getType().toString() + "(";

		Iterator<PersistentActualParameter> it = message.getActualParameters().iterator();

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
	public void handleActualParameter(PersistentActualParameter actualParameter) throws PersistenceException {
		result = actualParameter.getType().toString() + "=" + actualParameter.getValue().toString();
	}

	@Override
	public void handleLink(PersistentLink link) throws PersistenceException {
		result = link.getSource().toString() + "." + link.getType().getName() + ">>" + link.getTarget().toString();
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

	@Override
	public void handleMessageManager(PersistentMessageManager messageManager) throws PersistenceException {
		result = "Liste der Nachrichten";
	}

	@Override
	public void handleOperationManager(PersistentOperationManager operationManager) throws PersistenceException {
		result = "Liste der Operationen";
	}

	@Override
	public void handleLinkManager(PersistentLinkManager linkManager) throws PersistenceException {
		result = "Liste der Links";
	}

	@Override
	public void handleMObject(PersistentMObject mObject) throws PersistenceException {
		result = String.valueOf(mObject.getId());
		result += Strings.join(", ", mObject.getNames().iterator(),
				new Strings.ToStringStrategy<PersistentNameInstance>() {

					@Override
					public String getString(PersistentNameInstance element) throws PersistenceException {
						return element.toString(true);
					}
				});
	}

	@Override
	public void handleObjectManager(PersistentObjectManager objectManager) throws PersistenceException {
		result = "Objektwelt";
	}

	@Override
	public void handleNameSchemeInstance(PersistentNameSchemeInstance nameSchemeInstance) throws PersistenceException {
		result = nameSchemeInstance.getName();
	}

	@Override
	public void handleNameScheme(PersistentNameScheme nameScheme) throws PersistenceException {
		result = nameScheme.getName();
	}

	@Override
	public void handleNameInstance(PersistentNameInstance nameInstance) throws PersistenceException {
		result = nameInstance.getNameScheme().getName() + "(" + nameInstance.getNameScheme().getType().getName() + ")";
	}

	@Override
	public void handleNameSchemeManager(PersistentNameSchemeManager nameSchemeManager) throws PersistenceException {
		result = "Liste von Namensschemata";
	}

	@Override
	public void handleName(PersistentName name) throws PersistenceException {
		result = name.getFromType().getName() + "->" + name.getNameScheme().getName();
	}

	@Override
	public void handleFunctionManager(PersistentFunctionManager functionManager) throws PersistenceException {
		// TODO Auto-generated method stub

	}
}

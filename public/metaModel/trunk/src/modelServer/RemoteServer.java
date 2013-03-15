package modelServer;

import persistence.AbsQuantitySearchList;
import persistence.AbsUnitSearchList;
import persistence.AccountSearchList;
import persistence.AssociationSearchList;
import persistence.FormalParameterSearchList;
import persistence.MAccountTypeSearchList;
import persistence.MAtomicTypeSearchList;
import persistence.MEnumSearchList;
import persistence.MEnumValueSearchList;
import persistence.MMeasurementTypeSearchList;
import persistence.MObjectSearchList;
import persistence.MTypeSearchList;
import persistence.NameSchemeSearchList;
import persistence.PersistenceException;
import persistence.PersistentAbsQuantity;
import persistence.PersistentAbsUnit;
import persistence.PersistentAbsUnitType;
import persistence.PersistentAccount;
import persistence.PersistentAccountManager;
import persistence.PersistentAccountTypeManager;
import persistence.PersistentAspectManager;
import persistence.PersistentAssociation;
import persistence.PersistentAssociationManager;
import persistence.PersistentEnumerationManager;
import persistence.PersistentFormalParameter;
import persistence.PersistentHierarchy;
import persistence.PersistentLink;
import persistence.PersistentLinkManager;
import persistence.PersistentMAccountType;
import persistence.PersistentMAspect;
import persistence.PersistentMAtomicType;
import persistence.PersistentMComplexType;
import persistence.PersistentMEnum;
import persistence.PersistentMEnumValue;
import persistence.PersistentMMeasurementType;
import persistence.PersistentMObject;
import persistence.PersistentMObservation;
import persistence.PersistentMObservationType;
import persistence.PersistentMType;
import persistence.PersistentMeasurement;
import persistence.PersistentMeasurementTypeManager;
import persistence.PersistentName;
import persistence.PersistentNameScheme;
import persistence.PersistentNameSchemeManager;
import persistence.PersistentObsTypeManager;
import persistence.PersistentOperation;
import persistence.PersistentOperationManager;
import persistence.PersistentProxi;
import persistence.PersistentQuantity;
import persistence.PersistentQuantityManager;
import persistence.PersistentServer;
import persistence.PersistentTypeManager;
import persistence.PersistentUnit;
import persistence.PersistentUnitType;
import persistence.PersistentUnitTypeManager;
import persistence.Remote;
import persistence.UnitTypeSearchList;

public class RemoteServer extends RemoteServerMaster {

	protected PersistentServer server;

	public RemoteServer(final String connectionName, final String userName, final PersistentServer server) {
		super(connectionName, userName);
		this.server = server;
	}

	@Override
	protected Remote getServer() {
		return this.server;
	}

	public synchronized java.util.Hashtable<?, ?> a_Path_In_CreateHierarchy() {
		try {
			final AssociationSearchList result = this.server.a_Path_In_CreateHierarchy();
			return createOKResult(result.getVector(1, 0, false, this, false, true));
		} catch (final PersistenceException pe) {
			return createExceptionResult(pe);
		} catch (final model.UserException e0) {
			return createExceptionResult(e0, this);
		}
	}

	public synchronized java.util.Hashtable<?, ?> child_Path_In_AddSubAccountType() {
		try {
			final MAccountTypeSearchList result = this.server.child_Path_In_AddSubAccountType();
			return createOKResult(result.getVector(1, 0, false, this, false, true));
		} catch (final PersistenceException pe) {
			return createExceptionResult(pe);
		} catch (final model.UserException e0) {
			return createExceptionResult(e0, this);
		}
	}

	public synchronized java.util.Hashtable<?, ?> child_Path_In_AddSubAccount() {
		try {
			final AccountSearchList result = this.server.child_Path_In_AddSubAccount();
			return createOKResult(result.getVector(1, 0, false, this, false, true));
		} catch (final PersistenceException pe) {
			return createExceptionResult(pe);
		} catch (final model.UserException e0) {
			return createExceptionResult(e0, this);
		}
	}

	public synchronized java.util.Hashtable<?, ?> containees_Path_In_CreateTypeConjunction() {
		try {
			final MTypeSearchList result = this.server.containees_Path_In_CreateTypeConjunction();
			return createOKResult(result.getVector(1, 0, false, this, false, true));
		} catch (final PersistenceException pe) {
			return createExceptionResult(pe);
		} catch (final model.UserException e0) {
			return createExceptionResult(e0, this);
		}
	}

	public synchronized java.util.Hashtable<?, ?> containees_Path_In_CreateTypeDisjunction() {
		try {
			final MTypeSearchList result = this.server.containees_Path_In_CreateTypeDisjunction();
			return createOKResult(result.getVector(1, 0, false, this, false, true));
		} catch (final PersistenceException pe) {
			return createExceptionResult(pe);
		} catch (final model.UserException e0) {
			return createExceptionResult(e0, this);
		}
	}

	public synchronized java.util.Hashtable<?, ?> defaultUnit_Path_In_SetDefaultUnit() {
		try {
			final AbsUnitSearchList result = this.server.defaultUnit_Path_In_SetDefaultUnit();
			return createOKResult(result.getVector(1, 0, false, this, false, true));
		} catch (final PersistenceException pe) {
			return createExceptionResult(pe);
		} catch (final model.UserException e0) {
			return createExceptionResult(e0, this);
		}
	}

	public synchronized java.util.Hashtable<?, ?> dividend_Path_In_Div() {
		try {
			final AbsQuantitySearchList result = this.server.dividend_Path_In_Div();
			return createOKResult(result.getVector(1, 0, false, this, false, true));
		} catch (final PersistenceException pe) {
			return createExceptionResult(pe);
		} catch (final model.UserException e0) {
			return createExceptionResult(e0, this);
		}
	}

	public synchronized java.util.Hashtable<?, ?> divisor_Path_In_Div() {
		try {
			final AbsQuantitySearchList result = this.server.divisor_Path_In_Div();
			return createOKResult(result.getVector(1, 0, false, this, false, true));
		} catch (final PersistenceException pe) {
			return createExceptionResult(pe);
		} catch (final model.UserException e0) {
			return createExceptionResult(e0, this);
		}
	}

	public synchronized java.util.Hashtable<?, ?> enumType_Path_In_CreateObsType() {
		try {
			final MEnumSearchList result = this.server.enumType_Path_In_CreateObsType();
			return createOKResult(result.getVector(1, 0, false, this, false, true));
		} catch (final PersistenceException pe) {
			return createExceptionResult(pe);
		} catch (final model.UserException e0) {
			return createExceptionResult(e0, this);
		}
	}

	public synchronized java.util.Hashtable<?, ?> enumValue_Path_In_CreateObservation() {
		try {
			final MEnumValueSearchList result = this.server.enumValue_Path_In_CreateObservation();
			return createOKResult(result.getVector(1, 0, false, this, false, true));
		} catch (final PersistenceException pe) {
			return createExceptionResult(pe);
		} catch (final model.UserException e0) {
			return createExceptionResult(e0, this);
		}
	}

	public synchronized java.util.Hashtable<?, ?> factor1_Path_In_Mul() {
		try {
			final AbsQuantitySearchList result = this.server.factor1_Path_In_Mul();
			return createOKResult(result.getVector(1, 0, false, this, false, true));
		} catch (final PersistenceException pe) {
			return createExceptionResult(pe);
		} catch (final model.UserException e0) {
			return createExceptionResult(e0, this);
		}
	}

	public synchronized java.util.Hashtable<?, ?> factor2_Path_In_Mul() {
		try {
			final AbsQuantitySearchList result = this.server.factor2_Path_In_Mul();
			return createOKResult(result.getVector(1, 0, false, this, false, true));
		} catch (final PersistenceException pe) {
			return createExceptionResult(pe);
		} catch (final model.UserException e0) {
			return createExceptionResult(e0, this);
		}
	}

	public synchronized java.util.Hashtable<?, ?> fp_Path_In_AddFp() {
		try {
			final FormalParameterSearchList result = this.server.fp_Path_In_AddFp();
			return createOKResult(result.getVector(1, 0, false, this, false, true));
		} catch (final PersistenceException pe) {
			return createExceptionResult(pe);
		} catch (final model.UserException e0) {
			return createExceptionResult(e0, this);
		}
	}

	public synchronized java.util.Hashtable<?, ?> fp_Path_In_CreateOperation() {
		try {
			final FormalParameterSearchList result = this.server.fp_Path_In_CreateOperation();
			return createOKResult(result.getVector(1, 0, false, this, false, true));
		} catch (final PersistenceException pe) {
			return createExceptionResult(pe);
		} catch (final model.UserException e0) {
			return createExceptionResult(e0, this);
		}
	}

	public synchronized java.util.Hashtable<?, ?> fp_Path_In_CreateStaticOp() {
		try {
			final FormalParameterSearchList result = this.server.fp_Path_In_CreateStaticOp();
			return createOKResult(result.getVector(1, 0, false, this, false, true));
		} catch (final PersistenceException pe) {
			return createExceptionResult(pe);
		} catch (final model.UserException e0) {
			return createExceptionResult(e0, this);
		}
	}

	public synchronized java.util.Hashtable<?, ?> fp_Path_In_CreateVoidOperation() {
		try {
			final FormalParameterSearchList result = this.server.fp_Path_In_CreateVoidOperation();
			return createOKResult(result.getVector(1, 0, false, this, false, true));
		} catch (final PersistenceException pe) {
			return createExceptionResult(pe);
		} catch (final model.UserException e0) {
			return createExceptionResult(e0, this);
		}
	}

	public synchronized java.util.Hashtable<?, ?> measurementType_Path_In_CreateEntry() {
		try {
			final MMeasurementTypeSearchList result = this.server.measurementType_Path_In_CreateEntry();
			return createOKResult(result.getVector(1, 0, false, this, false, true));
		} catch (final PersistenceException pe) {
			return createExceptionResult(pe);
		} catch (final model.UserException e0) {
			return createExceptionResult(e0, this);
		}
	}

	public synchronized java.util.Hashtable<?, ?> minuend_Path_In_Sub() {
		try {
			final AbsQuantitySearchList result = this.server.minuend_Path_In_Sub();
			return createOKResult(result.getVector(1, 0, false, this, false, true));
		} catch (final PersistenceException pe) {
			return createExceptionResult(pe);
		} catch (final model.UserException e0) {
			return createExceptionResult(e0, this);
		}
	}

	public synchronized java.util.Hashtable<?, ?> newType_Path_In_AddType() {
		try {
			final MTypeSearchList result = this.server.newType_Path_In_AddType();
			return createOKResult(result.getVector(1, 0, false, this, false, true));
		} catch (final PersistenceException pe) {
			return createExceptionResult(pe);
		} catch (final model.UserException e0) {
			return createExceptionResult(e0, this);
		}
	}

	public synchronized java.util.Hashtable<?, ?> newType_Path_In_ReplaceType(final String oldTypeProxiString) {
		try {
			final PersistentMAtomicType oldType = (PersistentMAtomicType) PersistentProxi.createProxi(common.RPCConstantsAndServices
					.createProxiInformation(oldTypeProxiString));
			final MAtomicTypeSearchList result = this.server.newType_Path_In_ReplaceType(oldType);
			return createOKResult(result.getVector(1, 0, false, this, false, true));
		} catch (final PersistenceException pe) {
			return createExceptionResult(pe);
		} catch (final model.UserException e0) {
			return createExceptionResult(e0, this);
		}
	}

	public synchronized java.util.Hashtable<?, ?> object_Path_In_CreateAccount() {
		try {
			final MObjectSearchList result = this.server.object_Path_In_CreateAccount();
			return createOKResult(result.getVector(1, 0, false, this, false, true));
		} catch (final PersistenceException pe) {
			return createExceptionResult(pe);
		} catch (final model.UserException e0) {
			return createExceptionResult(e0, this);
		}
	}

	public synchronized java.util.Hashtable<?, ?> object_Path_In_CreateEntry() {
		try {
			final MObjectSearchList result = this.server.object_Path_In_CreateEntry();
			return createOKResult(result.getVector(1, 0, false, this, false, true));
		} catch (final PersistenceException pe) {
			return createExceptionResult(pe);
		} catch (final model.UserException e0) {
			return createExceptionResult(e0, this);
		}
	}

	public synchronized java.util.Hashtable<?, ?> ofType_Path_In_CreateFp() {
		try {
			final MTypeSearchList result = this.server.ofType_Path_In_CreateFp();
			return createOKResult(result.getVector(1, 0, false, this, false, true));
		} catch (final PersistenceException pe) {
			return createExceptionResult(pe);
		} catch (final model.UserException e0) {
			return createExceptionResult(e0, this);
		}
	}

	public synchronized java.util.Hashtable<?, ?> oldType_Path_In_RemoveType(final String objectProxiString) {
		try {
			final PersistentMObject object = (PersistentMObject) PersistentProxi.createProxi(common.RPCConstantsAndServices
					.createProxiInformation(objectProxiString));
			final MAtomicTypeSearchList result = this.server.oldType_Path_In_RemoveType(object);
			return createOKResult(result.getVector(1, 0, false, this, false, true));
		} catch (final PersistenceException pe) {
			return createExceptionResult(pe);
		} catch (final model.UserException e0) {
			return createExceptionResult(e0, this);
		}
	}

	public synchronized java.util.Hashtable<?, ?> oldType_Path_In_ReplaceType(final String objectProxiString) {
		try {
			final PersistentMObject object = (PersistentMObject) PersistentProxi.createProxi(common.RPCConstantsAndServices
					.createProxiInformation(objectProxiString));
			final MAtomicTypeSearchList result = this.server.oldType_Path_In_ReplaceType(object);
			return createOKResult(result.getVector(1, 0, false, this, false, true));
		} catch (final PersistenceException pe) {
			return createExceptionResult(pe);
		} catch (final model.UserException e0) {
			return createExceptionResult(e0, this);
		}
	}

	public synchronized java.util.Hashtable<?, ?> otherTypes_Path_In_CreateMObject() {
		try {
			final MTypeSearchList result = this.server.otherTypes_Path_In_CreateMObject();
			return createOKResult(result.getVector(1, 0, false, this, false, true));
		} catch (final PersistenceException pe) {
			return createExceptionResult(pe);
		} catch (final model.UserException e0) {
			return createExceptionResult(e0, this);
		}
	}

	public synchronized java.util.Hashtable<?, ?> quantity_Path_In_CreateEntry() {
		try {
			final AbsQuantitySearchList result = this.server.quantity_Path_In_CreateEntry();
			return createOKResult(result.getVector(1, 0, false, this, false, true));
		} catch (final PersistenceException pe) {
			return createExceptionResult(pe);
		} catch (final model.UserException e0) {
			return createExceptionResult(e0, this);
		}
	}

	public synchronized java.util.Hashtable<?, ?> referenceUnitType_Path_In_AddReferenceType() {
		try {
			final UnitTypeSearchList result = this.server.referenceUnitType_Path_In_AddReferenceType();
			return createOKResult(result.getVector(1, 0, false, this, false, true));
		} catch (final PersistenceException pe) {
			return createExceptionResult(pe);
		} catch (final model.UserException e0) {
			return createExceptionResult(e0, this);
		}
	}

	public synchronized java.util.Hashtable<?, ?> referenceUnit_Path_In_AddReference() {
		try {
			final AbsUnitSearchList result = this.server.referenceUnit_Path_In_AddReference();
			return createOKResult(result.getVector(1, 0, false, this, false, true));
		} catch (final PersistenceException pe) {
			return createExceptionResult(pe);
		} catch (final model.UserException e0) {
			return createExceptionResult(e0, this);
		}
	}

	public synchronized java.util.Hashtable<?, ?> scheme_Path_In_AssignNameScheme() {
		try {
			final NameSchemeSearchList result = this.server.scheme_Path_In_AssignNameScheme();
			return createOKResult(result.getVector(1, 0, false, this, false, true));
		} catch (final PersistenceException pe) {
			return createExceptionResult(pe);
		} catch (final model.UserException e0) {
			return createExceptionResult(e0, this);
		}
	}

	public synchronized java.util.Hashtable<?, ?> scheme_Path_In_AssignName(final String objectProxiString) {
		try {
			final PersistentMObject object = (PersistentMObject) PersistentProxi.createProxi(common.RPCConstantsAndServices
					.createProxiInformation(objectProxiString));
			final MAtomicTypeSearchList result = this.server.scheme_Path_In_AssignName(object);
			return createOKResult(result.getVector(1, 0, false, this, false, true));
		} catch (final PersistenceException pe) {
			return createExceptionResult(pe);
		} catch (final model.UserException e0) {
			return createExceptionResult(e0, this);
		}
	}

	public synchronized java.util.Hashtable<?, ?> source_Path_In_CreateAssociation() {
		try {
			final MTypeSearchList result = this.server.source_Path_In_CreateAssociation();
			return createOKResult(result.getVector(1, 0, false, this, false, true));
		} catch (final PersistenceException pe) {
			return createExceptionResult(pe);
		} catch (final model.UserException e0) {
			return createExceptionResult(e0, this);
		}
	}

	public synchronized java.util.Hashtable<?, ?> source_Path_In_CreateLink() {
		try {
			final MObjectSearchList result = this.server.source_Path_In_CreateLink();
			return createOKResult(result.getVector(1, 0, false, this, false, true));
		} catch (final PersistenceException pe) {
			return createExceptionResult(pe);
		} catch (final model.UserException e0) {
			return createExceptionResult(e0, this);
		}
	}

	public synchronized java.util.Hashtable<?, ?> source_Path_In_CreateOperation() {
		try {
			final MTypeSearchList result = this.server.source_Path_In_CreateOperation();
			return createOKResult(result.getVector(1, 0, false, this, false, true));
		} catch (final PersistenceException pe) {
			return createExceptionResult(pe);
		} catch (final model.UserException e0) {
			return createExceptionResult(e0, this);
		}
	}

	public synchronized java.util.Hashtable<?, ?> source_Path_In_CreateVoidOperation() {
		try {
			final MTypeSearchList result = this.server.source_Path_In_CreateVoidOperation();
			return createOKResult(result.getVector(1, 0, false, this, false, true));
		} catch (final PersistenceException pe) {
			return createExceptionResult(pe);
		} catch (final model.UserException e0) {
			return createExceptionResult(e0, this);
		}
	}

	public synchronized java.util.Hashtable<?, ?> subtrahend_Path_In_Sub() {
		try {
			final AbsQuantitySearchList result = this.server.subtrahend_Path_In_Sub();
			return createOKResult(result.getVector(1, 0, false, this, false, true));
		} catch (final PersistenceException pe) {
			return createExceptionResult(pe);
		} catch (final model.UserException e0) {
			return createExceptionResult(e0, this);
		}
	}

	public synchronized java.util.Hashtable<?, ?> summand1_Path_In_Add() {
		try {
			final AbsQuantitySearchList result = this.server.summand1_Path_In_Add();
			return createOKResult(result.getVector(1, 0, false, this, false, true));
		} catch (final PersistenceException pe) {
			return createExceptionResult(pe);
		} catch (final model.UserException e0) {
			return createExceptionResult(e0, this);
		}
	}

	public synchronized java.util.Hashtable<?, ?> summand2_Path_In_Add() {
		try {
			final AbsQuantitySearchList result = this.server.summand2_Path_In_Add();
			return createOKResult(result.getVector(1, 0, false, this, false, true));
		} catch (final PersistenceException pe) {
			return createExceptionResult(pe);
		} catch (final model.UserException e0) {
			return createExceptionResult(e0, this);
		}
	}

	public synchronized java.util.Hashtable<?, ?> target_Path_In_CreateAssociation() {
		try {
			final MTypeSearchList result = this.server.target_Path_In_CreateAssociation();
			return createOKResult(result.getVector(1, 0, false, this, false, true));
		} catch (final PersistenceException pe) {
			return createExceptionResult(pe);
		} catch (final model.UserException e0) {
			return createExceptionResult(e0, this);
		}
	}

	public synchronized java.util.Hashtable<?, ?> target_Path_In_CreateConstant() {
		try {
			final MTypeSearchList result = this.server.target_Path_In_CreateConstant();
			return createOKResult(result.getVector(1, 0, false, this, false, true));
		} catch (final PersistenceException pe) {
			return createExceptionResult(pe);
		} catch (final model.UserException e0) {
			return createExceptionResult(e0, this);
		}
	}

	public synchronized java.util.Hashtable<?, ?> target_Path_In_CreateLink() {
		try {
			final MObjectSearchList result = this.server.target_Path_In_CreateLink();
			return createOKResult(result.getVector(1, 0, false, this, false, true));
		} catch (final PersistenceException pe) {
			return createExceptionResult(pe);
		} catch (final model.UserException e0) {
			return createExceptionResult(e0, this);
		}
	}

	public synchronized java.util.Hashtable<?, ?> target_Path_In_CreateOperation() {
		try {
			final MTypeSearchList result = this.server.target_Path_In_CreateOperation();
			return createOKResult(result.getVector(1, 0, false, this, false, true));
		} catch (final PersistenceException pe) {
			return createExceptionResult(pe);
		} catch (final model.UserException e0) {
			return createExceptionResult(e0, this);
		}
	}

	public synchronized java.util.Hashtable<?, ?> target_Path_In_CreateStaticOp() {
		try {
			final MTypeSearchList result = this.server.target_Path_In_CreateStaticOp();
			return createOKResult(result.getVector(1, 0, false, this, false, true));
		} catch (final PersistenceException pe) {
			return createExceptionResult(pe);
		} catch (final model.UserException e0) {
			return createExceptionResult(e0, this);
		}
	}

	public synchronized java.util.Hashtable<?, ?> theObsObject_Path_In_CreateObservation() {
		try {
			final MObjectSearchList result = this.server.theObsObject_Path_In_CreateObservation();
			return createOKResult(result.getVector(1, 0, false, this, false, true));
		} catch (final PersistenceException pe) {
			return createExceptionResult(pe);
		} catch (final model.UserException e0) {
			return createExceptionResult(e0, this);
		}
	}

	public synchronized java.util.Hashtable<?, ?> theType_Path_In_CreateObsType() {
		try {
			final MTypeSearchList result = this.server.theType_Path_In_CreateObsType();
			return createOKResult(result.getVector(1, 0, false, this, false, true));
		} catch (final PersistenceException pe) {
			return createExceptionResult(pe);
		} catch (final model.UserException e0) {
			return createExceptionResult(e0, this);
		}
	}

	public synchronized java.util.Hashtable<?, ?> type_Path_In_CreateAccountType() {
		try {
			final MTypeSearchList result = this.server.type_Path_In_CreateAccountType();
			return createOKResult(result.getVector(1, 0, false, this, false, true));
		} catch (final PersistenceException pe) {
			return createExceptionResult(pe);
		} catch (final model.UserException e0) {
			return createExceptionResult(e0, this);
		}
	}

	public synchronized java.util.Hashtable<?, ?> type_Path_In_CreateAccount() {
		try {
			final MAccountTypeSearchList result = this.server.type_Path_In_CreateAccount();
			return createOKResult(result.getVector(1, 0, false, this, false, true));
		} catch (final PersistenceException pe) {
			return createExceptionResult(pe);
		} catch (final model.UserException e0) {
			return createExceptionResult(e0, this);
		}
	}

	public synchronized java.util.Hashtable<?, ?> type_Path_In_CreateLink() {
		try {
			final AssociationSearchList result = this.server.type_Path_In_CreateLink();
			return createOKResult(result.getVector(1, 0, false, this, false, true));
		} catch (final PersistenceException pe) {
			return createExceptionResult(pe);
		} catch (final model.UserException e0) {
			return createExceptionResult(e0, this);
		}
	}

	public synchronized java.util.Hashtable<?, ?> type_Path_In_CreateMObject() {
		try {
			final MTypeSearchList result = this.server.type_Path_In_CreateMObject();
			return createOKResult(result.getVector(1, 0, false, this, false, true));
		} catch (final PersistenceException pe) {
			return createExceptionResult(pe);
		} catch (final model.UserException e0) {
			return createExceptionResult(e0, this);
		}
	}

	public synchronized java.util.Hashtable<?, ?> type_Path_In_CreateMeasurementType() {
		try {
			final MTypeSearchList result = this.server.type_Path_In_CreateMeasurementType();
			return createOKResult(result.getVector(1, 0, false, this, false, true));
		} catch (final PersistenceException pe) {
			return createExceptionResult(pe);
		} catch (final model.UserException e0) {
			return createExceptionResult(e0, this);
		}
	}

	public synchronized java.util.Hashtable<?, ?> unitType_Path_In_CreateAccountType() {
		try {
			final UnitTypeSearchList result = this.server.unitType_Path_In_CreateAccountType();
			return createOKResult(result.getVector(1, 0, false, this, false, true));
		} catch (final PersistenceException pe) {
			return createExceptionResult(pe);
		} catch (final model.UserException e0) {
			return createExceptionResult(e0, this);
		}
	}

	public synchronized java.util.Hashtable<?, ?> unitType_Path_In_CreateMeasurementType() {
		try {
			final UnitTypeSearchList result = this.server.unitType_Path_In_CreateMeasurementType();
			return createOKResult(result.getVector(1, 0, false, this, false, true));
		} catch (final PersistenceException pe) {
			return createExceptionResult(pe);
		} catch (final model.UserException e0) {
			return createExceptionResult(e0, this);
		}
	}

	public synchronized java.util.Hashtable<?, ?> unit_Path_In_Convert() {
		try {
			final AbsUnitSearchList result = this.server.unit_Path_In_Convert();
			return createOKResult(result.getVector(1, 0, false, this, false, true));
		} catch (final PersistenceException pe) {
			return createExceptionResult(pe);
		} catch (final model.UserException e0) {
			return createExceptionResult(e0, this);
		}
	}

	public synchronized java.util.Hashtable<?, ?> unit_Path_In_CreateQuantity() {
		try {
			final AbsUnitSearchList result = this.server.unit_Path_In_CreateQuantity();
			return createOKResult(result.getVector(1, 0, false, this, false, true));
		} catch (final PersistenceException pe) {
			return createExceptionResult(pe);
		} catch (final model.UserException e0) {
			return createExceptionResult(e0, this);
		}
	}

	public synchronized java.util.Hashtable<?, ?> addAssociation(final String hProxiString, final String aProxiString) {
		try {
			final PersistentHierarchy h = (PersistentHierarchy) PersistentProxi.createProxi(common.RPCConstantsAndServices
					.createProxiInformation(hProxiString));
			final PersistentAssociation a = (PersistentAssociation) PersistentProxi.createProxi(common.RPCConstantsAndServices
					.createProxiInformation(aProxiString));
			this.server.addAssociation(h, a);
			return createOKResult();
		} catch (final PersistenceException pe) {
			return createExceptionResult(pe);
		}
	}

	public synchronized java.util.Hashtable<?, ?> addFp(final String opProxiString, final String fpProxiString) {
		try {
			final PersistentOperation op = (PersistentOperation) PersistentProxi.createProxi(common.RPCConstantsAndServices
					.createProxiInformation(opProxiString));
			final PersistentFormalParameter fp = (PersistentFormalParameter) PersistentProxi.createProxi(common.RPCConstantsAndServices
					.createProxiInformation(fpProxiString));
			this.server.addFp(op, fp);
			return createOKResult();
		} catch (final PersistenceException pe) {
			return createExceptionResult(pe);
		}
	}

	public synchronized java.util.Hashtable<?, ?> addReferenceType(final String unitTypeProxiString, final String name,
			final String referenceUnitTypeProxiString, final String exponentAsString) {
		try {
			final PersistentAbsUnitType unitType = (PersistentAbsUnitType) PersistentProxi.createProxi(common.RPCConstantsAndServices
					.createProxiInformation(unitTypeProxiString));
			final PersistentUnitType referenceUnitType = (PersistentUnitType) PersistentProxi.createProxi(common.RPCConstantsAndServices
					.createProxiInformation(referenceUnitTypeProxiString));
			final long exponent = new Long(exponentAsString).longValue();
			this.server.addReferenceType(unitType, name, referenceUnitType, exponent);
			return createOKResult();
		} catch (final PersistenceException pe) {
			return createExceptionResult(pe);
		}
	}

	public synchronized java.util.Hashtable<?, ?> addReference(final String unitProxiString, final String name,
			final String referenceUnitProxiString, final String exponentAsString) {
		try {
			final PersistentAbsUnit unit = (PersistentAbsUnit) PersistentProxi.createProxi(common.RPCConstantsAndServices
					.createProxiInformation(unitProxiString));
			final PersistentUnit referenceUnit = (PersistentUnit) PersistentProxi.createProxi(common.RPCConstantsAndServices
					.createProxiInformation(referenceUnitProxiString));
			final long exponent = new Long(exponentAsString).longValue();
			this.server.addReference(unit, name, referenceUnit, exponent);
			return createOKResult();
		} catch (final PersistenceException pe) {
			return createExceptionResult(pe);
		}
	}

	public synchronized java.util.Hashtable<?, ?> addSubAccountType(final String parentProxiString, final String childProxiString) {
		try {
			final PersistentMAccountType parent = (PersistentMAccountType) PersistentProxi.createProxi(common.RPCConstantsAndServices
					.createProxiInformation(parentProxiString));
			final PersistentMAccountType child = (PersistentMAccountType) PersistentProxi.createProxi(common.RPCConstantsAndServices
					.createProxiInformation(childProxiString));
			this.server.addSubAccountType(parent, child);
			return createOKResult();
		} catch (final PersistenceException pe) {
			return createExceptionResult(pe);
		} catch (final model.CycleException e0) {
			return createExceptionResult(e0, this);
		}
	}

	public synchronized java.util.Hashtable<?, ?> addSubAccount(final String parentProxiString, final String childProxiString) {
		try {
			final PersistentAccount parent = (PersistentAccount) PersistentProxi.createProxi(common.RPCConstantsAndServices
					.createProxiInformation(parentProxiString));
			final PersistentAccount child = (PersistentAccount) PersistentProxi.createProxi(common.RPCConstantsAndServices
					.createProxiInformation(childProxiString));
			this.server.addSubAccount(parent, child);
			return createOKResult();
		} catch (final PersistenceException pe) {
			return createExceptionResult(pe);
		} catch (final model.CycleException e0) {
			return createExceptionResult(e0, this);
		}
	}

	public synchronized java.util.Hashtable<?, ?> addToHierarchy(final String associationProxiString, final String theHierarchyProxiString) {
		try {
			final PersistentAssociation association = (PersistentAssociation) PersistentProxi.createProxi(common.RPCConstantsAndServices
					.createProxiInformation(associationProxiString));
			final PersistentHierarchy theHierarchy = (PersistentHierarchy) PersistentProxi.createProxi(common.RPCConstantsAndServices
					.createProxiInformation(theHierarchyProxiString));
			this.server.addToHierarchy(association, theHierarchy);
			return createOKResult();
		} catch (final PersistenceException pe) {
			return createExceptionResult(pe);
		}
	}

	public synchronized java.util.Hashtable<?, ?> addType(final String objectProxiString, final String newTypeProxiString) {
		try {
			final PersistentMObject object = (PersistentMObject) PersistentProxi.createProxi(common.RPCConstantsAndServices
					.createProxiInformation(objectProxiString));
			final PersistentMAtomicType newType = (PersistentMAtomicType) PersistentProxi.createProxi(common.RPCConstantsAndServices
					.createProxiInformation(newTypeProxiString));
			this.server.addType(object, newType);
			return createOKResult();
		} catch (final PersistenceException pe) {
			return createExceptionResult(pe);
		}
	}

	public synchronized java.util.Hashtable<?, ?> add(final String summand1ProxiString, final String summand2ProxiString) {
		try {
			final PersistentAbsQuantity summand1 = (PersistentAbsQuantity) PersistentProxi.createProxi(common.RPCConstantsAndServices
					.createProxiInformation(summand1ProxiString));
			final PersistentAbsQuantity summand2 = (PersistentAbsQuantity) PersistentProxi.createProxi(common.RPCConstantsAndServices
					.createProxiInformation(summand2ProxiString));
			this.server.add(summand1, summand2);
			return createOKResult();
		} catch (final PersistenceException pe) {
			return createExceptionResult(pe);
		} catch (final model.NotComputableException e0) {
			return createExceptionResult(e0, this);
		}
	}

	@SuppressWarnings("unchecked")
	public synchronized java.util.Hashtable<?, ?> aggregateByStrategy(final String accountProxiString, final String strategy) {
		try {
			final PersistentAccount account = (PersistentAccount) PersistentProxi.createProxi(common.RPCConstantsAndServices
					.createProxiInformation(accountProxiString));
			final PersistentAbsQuantity result = this.server.aggregateByStrategy(account, strategy);
			return createOKResult(result, 1, this);
		} catch (final PersistenceException pe) {
			return createExceptionResult(pe);
		} catch (final model.ConsistencyException e0) {
			return createExceptionResult(e0, this);
		} catch (final model.NotComputableException e1) {
			return createExceptionResult(e1, this);
		}
	}

	public synchronized java.util.Hashtable<?, ?> assignNameScheme(final String typeProxiString, final String schemeProxiString) {
		try {
			final PersistentMAtomicType type = (PersistentMAtomicType) PersistentProxi.createProxi(common.RPCConstantsAndServices
					.createProxiInformation(typeProxiString));
			final PersistentNameScheme scheme = (PersistentNameScheme) PersistentProxi.createProxi(common.RPCConstantsAndServices
					.createProxiInformation(schemeProxiString));
			this.server.assignNameScheme(type, scheme);
			return createOKResult();
		} catch (final PersistenceException pe) {
			return createExceptionResult(pe);
		}
	}

	public synchronized java.util.Hashtable<?, ?> assignName(final String objectProxiString, final String schemeProxiString, final String name) {
		try {
			final PersistentMObject object = (PersistentMObject) PersistentProxi.createProxi(common.RPCConstantsAndServices
					.createProxiInformation(objectProxiString));
			final PersistentName scheme = (PersistentName) PersistentProxi.createProxi(common.RPCConstantsAndServices
					.createProxiInformation(schemeProxiString));
			this.server.assignName(object, scheme, name);
			return createOKResult();
		} catch (final PersistenceException pe) {
			return createExceptionResult(pe);
		}
	}

	public synchronized java.util.Hashtable<?, ?> assignType(final String schemeProxiString, final String typeProxiString) {
		try {
			final PersistentNameScheme scheme = (PersistentNameScheme) PersistentProxi.createProxi(common.RPCConstantsAndServices
					.createProxiInformation(schemeProxiString));
			final PersistentMAtomicType type = (PersistentMAtomicType) PersistentProxi.createProxi(common.RPCConstantsAndServices
					.createProxiInformation(typeProxiString));
			this.server.assignType(scheme, type);
			return createOKResult();
		} catch (final PersistenceException pe) {
			return createExceptionResult(pe);
		}
	}

	public synchronized java.util.Hashtable<?, ?> changeAbstract(final String typeProxiString, final String newAbstractType) {
		try {
			final PersistentMAtomicType type = (PersistentMAtomicType) PersistentProxi.createProxi(common.RPCConstantsAndServices
					.createProxiInformation(typeProxiString));
			this.server.changeAbstract(type, newAbstractType);
			return createOKResult();
		} catch (final PersistenceException pe) {
			return createExceptionResult(pe);
		}
	}

	public synchronized java.util.Hashtable<?, ?> changeSingleton(final String typeProxiString, final String newSingletonType) {
		try {
			final PersistentMAtomicType type = (PersistentMAtomicType) PersistentProxi.createProxi(common.RPCConstantsAndServices
					.createProxiInformation(typeProxiString));
			this.server.changeSingleton(type, newSingletonType);
			return createOKResult();
		} catch (final PersistenceException pe) {
			return createExceptionResult(pe);
		}
	}

	public synchronized java.util.Hashtable<?, ?> changeUnitName(final String unitProxiString, final String name) {
		try {
			final PersistentAbsUnit unit = (PersistentAbsUnit) PersistentProxi.createProxi(common.RPCConstantsAndServices
					.createProxiInformation(unitProxiString));
			this.server.changeUnitName(unit, name);
			return createOKResult();
		} catch (final PersistenceException pe) {
			return createExceptionResult(pe);
		}
	}

	public synchronized java.util.Hashtable<?, ?> changeUnitTypeName(final String unitTypeProxiString, final String name) {
		try {
			final PersistentAbsUnitType unitType = (PersistentAbsUnitType) PersistentProxi.createProxi(common.RPCConstantsAndServices
					.createProxiInformation(unitTypeProxiString));
			this.server.changeUnitTypeName(unitType, name);
			return createOKResult();
		} catch (final PersistenceException pe) {
			return createExceptionResult(pe);
		}
	}

	public synchronized java.util.Hashtable<?, ?> convert(final String quantityProxiString, final String unitProxiString) {
		try {
			final PersistentQuantity quantity = (PersistentQuantity) PersistentProxi.createProxi(common.RPCConstantsAndServices
					.createProxiInformation(quantityProxiString));
			final PersistentAbsUnit unit = (PersistentAbsUnit) PersistentProxi.createProxi(common.RPCConstantsAndServices
					.createProxiInformation(unitProxiString));
			this.server.convert(quantity, unit);
			return createOKResult();
		} catch (final PersistenceException pe) {
			return createExceptionResult(pe);
		}
	}

	public synchronized java.util.Hashtable<?, ?> createAccountType(final String accountTypeManagerProxiString, final String name,
			final String typeProxiString, final String unitTypeProxiString) {
		try {
			final PersistentAccountTypeManager accountTypeManager = (PersistentAccountTypeManager) PersistentProxi
					.createProxi(common.RPCConstantsAndServices.createProxiInformation(accountTypeManagerProxiString));
			final PersistentMType type = (PersistentMType) PersistentProxi.createProxi(common.RPCConstantsAndServices
					.createProxiInformation(typeProxiString));
			final PersistentUnitType unitType = (PersistentUnitType) PersistentProxi.createProxi(common.RPCConstantsAndServices
					.createProxiInformation(unitTypeProxiString));
			this.server.createAccountType(accountTypeManager, name, type, unitType);
			return createOKResult();
		} catch (final PersistenceException pe) {
			return createExceptionResult(pe);
		}
	}

	public synchronized java.util.Hashtable<?, ?> createAccount(final String accountManagerProxiString, final String name,
			final String typeProxiString, final String objectProxiString) {
		try {
			final PersistentAccountManager accountManager = (PersistentAccountManager) PersistentProxi.createProxi(common.RPCConstantsAndServices
					.createProxiInformation(accountManagerProxiString));
			final PersistentMAccountType type = (PersistentMAccountType) PersistentProxi.createProxi(common.RPCConstantsAndServices
					.createProxiInformation(typeProxiString));
			final PersistentMObject object = (PersistentMObject) PersistentProxi.createProxi(common.RPCConstantsAndServices
					.createProxiInformation(objectProxiString));
			this.server.createAccount(accountManager, name, type, object);
			return createOKResult();
		} catch (final PersistenceException pe) {
			return createExceptionResult(pe);
		}
	}

	public synchronized java.util.Hashtable<?, ?> createAspect(final String aspectManagerProxiString, final String name) {
		try {
			final PersistentAspectManager aspectManager = (PersistentAspectManager) PersistentProxi.createProxi(common.RPCConstantsAndServices
					.createProxiInformation(aspectManagerProxiString));
			this.server.createAspect(aspectManager, name);
			return createOKResult();
		} catch (final PersistenceException pe) {
			return createExceptionResult(pe);
		}
	}

	public synchronized java.util.Hashtable<?, ?> createAssociation(final String managerProxiString, final String sourceProxiString,
			final String targetProxiString, final String name) {
		try {
			final PersistentAssociationManager manager = (PersistentAssociationManager) PersistentProxi.createProxi(common.RPCConstantsAndServices
					.createProxiInformation(managerProxiString));
			final PersistentMType source = (PersistentMType) PersistentProxi.createProxi(common.RPCConstantsAndServices
					.createProxiInformation(sourceProxiString));
			final PersistentMType target = (PersistentMType) PersistentProxi.createProxi(common.RPCConstantsAndServices
					.createProxiInformation(targetProxiString));
			this.server.createAssociation(manager, source, target, name);
			return createOKResult();
		} catch (final PersistenceException pe) {
			return createExceptionResult(pe);
		}
	}

	public synchronized java.util.Hashtable<?, ?> createAtomicRootType(final String aspectProxiString, final String typeName,
			final String singletonType, final String abstractType) {
		try {
			final PersistentMAspect aspect = (PersistentMAspect) PersistentProxi.createProxi(common.RPCConstantsAndServices
					.createProxiInformation(aspectProxiString));
			this.server.createAtomicRootType(aspect, typeName, singletonType, abstractType);
			return createOKResult();
		} catch (final PersistenceException pe) {
			return createExceptionResult(pe);
		}
	}

	public synchronized java.util.Hashtable<?, ?> createAtomicSubType(final String superTypeProxiString, final String typeName,
			final String singletonType, final String abstractType) {
		try {
			final PersistentMAtomicType superType = (PersistentMAtomicType) PersistentProxi.createProxi(common.RPCConstantsAndServices
					.createProxiInformation(superTypeProxiString));
			this.server.createAtomicSubType(superType, typeName, singletonType, abstractType);
			return createOKResult();
		} catch (final PersistenceException pe) {
			return createExceptionResult(pe);
		}
	}

	public synchronized java.util.Hashtable<?, ?> createConstant(final String operationManagerProxiString, final String name,
			final String targetProxiString) {
		try {
			final PersistentOperationManager operationManager = (PersistentOperationManager) PersistentProxi
					.createProxi(common.RPCConstantsAndServices.createProxiInformation(operationManagerProxiString));
			final PersistentMType target = (PersistentMType) PersistentProxi.createProxi(common.RPCConstantsAndServices
					.createProxiInformation(targetProxiString));
			this.server.createConstant(operationManager, name, target);
			return createOKResult();
		} catch (final PersistenceException pe) {
			return createExceptionResult(pe);
		}
	}

	public synchronized java.util.Hashtable<?, ?> createEntry(final String accountProxiString, final String objectProxiString,
			final String measurementTypeProxiString, final String quantityProxiString) {
		try {
			final PersistentAccount account = (PersistentAccount) PersistentProxi.createProxi(common.RPCConstantsAndServices
					.createProxiInformation(accountProxiString));
			final PersistentMObject object = (PersistentMObject) PersistentProxi.createProxi(common.RPCConstantsAndServices
					.createProxiInformation(objectProxiString));
			final PersistentMMeasurementType measurementType = (PersistentMMeasurementType) PersistentProxi
					.createProxi(common.RPCConstantsAndServices.createProxiInformation(measurementTypeProxiString));
			final PersistentQuantity quantity = (PersistentQuantity) PersistentProxi.createProxi(common.RPCConstantsAndServices
					.createProxiInformation(quantityProxiString));
			this.server.createEntry(account, object, measurementType, quantity);
			return createOKResult();
		} catch (final PersistenceException pe) {
			return createExceptionResult(pe);
		} catch (final model.ConsistencyException e0) {
			return createExceptionResult(e0, this);
		}
	}

	public synchronized java.util.Hashtable<?, ?> createEnumValue(final String typeProxiString, final String name) {
		try {
			final PersistentMEnum type = (PersistentMEnum) PersistentProxi.createProxi(common.RPCConstantsAndServices
					.createProxiInformation(typeProxiString));
			this.server.createEnumValue(type, name);
			return createOKResult();
		} catch (final PersistenceException pe) {
			return createExceptionResult(pe);
		}
	}

	public synchronized java.util.Hashtable<?, ?> createEnum(final String enumManagerProxiString, final String name) {
		try {
			final PersistentEnumerationManager enumManager = (PersistentEnumerationManager) PersistentProxi
					.createProxi(common.RPCConstantsAndServices.createProxiInformation(enumManagerProxiString));
			this.server.createEnum(enumManager, name);
			return createOKResult();
		} catch (final PersistenceException pe) {
			return createExceptionResult(pe);
		}
	}

	public synchronized java.util.Hashtable<?, ?> createFp(final String operationManagerProxiString, final String name, final String ofTypeProxiString) {
		try {
			final PersistentOperationManager operationManager = (PersistentOperationManager) PersistentProxi
					.createProxi(common.RPCConstantsAndServices.createProxiInformation(operationManagerProxiString));
			final PersistentMType ofType = (PersistentMType) PersistentProxi.createProxi(common.RPCConstantsAndServices
					.createProxiInformation(ofTypeProxiString));
			this.server.createFp(operationManager, name, ofType);
			return createOKResult();
		} catch (final PersistenceException pe) {
			return createExceptionResult(pe);
		}
	}

	public synchronized java.util.Hashtable<?, ?> createHierarchy(final String managerProxiString, final String aProxiString, final String name) {
		try {
			final PersistentAssociationManager manager = (PersistentAssociationManager) PersistentProxi.createProxi(common.RPCConstantsAndServices
					.createProxiInformation(managerProxiString));
			final PersistentAssociation a = (PersistentAssociation) PersistentProxi.createProxi(common.RPCConstantsAndServices
					.createProxiInformation(aProxiString));
			this.server.createHierarchy(manager, a, name);
			return createOKResult();
		} catch (final PersistenceException pe) {
			return createExceptionResult(pe);
		}
	}

	public synchronized java.util.Hashtable<?, ?> createHierarchy(final String aProxiString, final String name) {
		try {
			final PersistentAssociation a = (PersistentAssociation) PersistentProxi.createProxi(common.RPCConstantsAndServices
					.createProxiInformation(aProxiString));
			this.server.createHierarchy(a, name);
			return createOKResult();
		} catch (final PersistenceException pe) {
			return createExceptionResult(pe);
		}
	}

	public synchronized java.util.Hashtable<?, ?> createLink(final String linkProxiString, final String typeProxiString,
			final String sourceProxiString, final String targetProxiString) {
		try {
			final PersistentLinkManager link = (PersistentLinkManager) PersistentProxi.createProxi(common.RPCConstantsAndServices
					.createProxiInformation(linkProxiString));
			final PersistentAssociation type = (PersistentAssociation) PersistentProxi.createProxi(common.RPCConstantsAndServices
					.createProxiInformation(typeProxiString));
			final PersistentMObject source = (PersistentMObject) PersistentProxi.createProxi(common.RPCConstantsAndServices
					.createProxiInformation(sourceProxiString));
			final PersistentMObject target = (PersistentMObject) PersistentProxi.createProxi(common.RPCConstantsAndServices
					.createProxiInformation(targetProxiString));
			this.server.createLink(link, type, source, target);
			return createOKResult();
		} catch (final PersistenceException pe) {
			return createExceptionResult(pe);
		}
	}

	public synchronized java.util.Hashtable<?, ?> createLink(final String sourceProxiString, final String typeProxiString,
			final String targetProxiString) {
		try {
			final PersistentMObject source = (PersistentMObject) PersistentProxi.createProxi(common.RPCConstantsAndServices
					.createProxiInformation(sourceProxiString));
			final PersistentAssociation type = (PersistentAssociation) PersistentProxi.createProxi(common.RPCConstantsAndServices
					.createProxiInformation(typeProxiString));
			final PersistentMObject target = (PersistentMObject) PersistentProxi.createProxi(common.RPCConstantsAndServices
					.createProxiInformation(targetProxiString));
			this.server.createLink(source, type, target);
			return createOKResult();
		} catch (final PersistenceException pe) {
			return createExceptionResult(pe);
		}
	}

	public synchronized java.util.Hashtable<?, ?> createMObject(final String typeProxiString, final java.util.Vector<String> otherTypesTrnsprt) {
		try {
			final PersistentMAtomicType type = (PersistentMAtomicType) PersistentProxi.createProxi(common.RPCConstantsAndServices
					.createProxiInformation(typeProxiString));
			final MAtomicTypeSearchList otherTypes = new MAtomicTypeSearchList();
			final java.util.Iterator<String> otherTypesItrtr = otherTypesTrnsprt.iterator();
			while (otherTypesItrtr.hasNext()) {
				final PersistentMAtomicType currentProxi = (PersistentMAtomicType) PersistentProxi.createProxi(common.RPCConstantsAndServices
						.createProxiInformation(otherTypesItrtr.next()));
				otherTypes.add(currentProxi);
			}
			this.server.createMObject(type, otherTypes);
			return createOKResult();
		} catch (final PersistenceException pe) {
			return createExceptionResult(pe);
		}
	}

	public synchronized java.util.Hashtable<?, ?> createMeasurementType(final String measurementTypeManagerProxiString, final String name,
			final String typeProxiString, final String unitTypeProxiString) {
		try {
			final PersistentMeasurementTypeManager measurementTypeManager = (PersistentMeasurementTypeManager) PersistentProxi
					.createProxi(common.RPCConstantsAndServices.createProxiInformation(measurementTypeManagerProxiString));
			final PersistentMType type = (PersistentMType) PersistentProxi.createProxi(common.RPCConstantsAndServices
					.createProxiInformation(typeProxiString));
			final PersistentUnitType unitType = (PersistentUnitType) PersistentProxi.createProxi(common.RPCConstantsAndServices
					.createProxiInformation(unitTypeProxiString));
			this.server.createMeasurementType(measurementTypeManager, name, type, unitType);
			return createOKResult();
		} catch (final PersistenceException pe) {
			return createExceptionResult(pe);
		}
	}

	public synchronized java.util.Hashtable<?, ?> createNameScheme(final String managerProxiString, final String schemeName, final String regExp,
			final String isIterable) {
		try {
			final PersistentNameSchemeManager manager = (PersistentNameSchemeManager) PersistentProxi.createProxi(common.RPCConstantsAndServices
					.createProxiInformation(managerProxiString));
			this.server.createNameScheme(manager, schemeName, regExp, isIterable);
			return createOKResult();
		} catch (final PersistenceException pe) {
			return createExceptionResult(pe);
		}
	}

	public synchronized java.util.Hashtable<?, ?> createObsType(final String obsTypeManagerProxiString, final String name,
			final String enumTypeProxiString, final String theTypeProxiString) {
		try {
			final PersistentObsTypeManager obsTypeManager = (PersistentObsTypeManager) PersistentProxi.createProxi(common.RPCConstantsAndServices
					.createProxiInformation(obsTypeManagerProxiString));
			final PersistentMEnum enumType = (PersistentMEnum) PersistentProxi.createProxi(common.RPCConstantsAndServices
					.createProxiInformation(enumTypeProxiString));
			final PersistentMType theType = (PersistentMType) PersistentProxi.createProxi(common.RPCConstantsAndServices
					.createProxiInformation(theTypeProxiString));
			this.server.createObsType(obsTypeManager, name, enumType, theType);
			return createOKResult();
		} catch (final PersistenceException pe) {
			return createExceptionResult(pe);
		}
	}

	public synchronized java.util.Hashtable<?, ?> createObservation(final String theTypeProxiString, final String name,
			final String theObsObjectProxiString, final String enumValueProxiString) {
		try {
			final PersistentMObservationType theType = (PersistentMObservationType) PersistentProxi.createProxi(common.RPCConstantsAndServices
					.createProxiInformation(theTypeProxiString));
			final PersistentMObject theObsObject = (PersistentMObject) PersistentProxi.createProxi(common.RPCConstantsAndServices
					.createProxiInformation(theObsObjectProxiString));
			final PersistentMEnumValue enumValue = (PersistentMEnumValue) PersistentProxi.createProxi(common.RPCConstantsAndServices
					.createProxiInformation(enumValueProxiString));
			this.server.createObservation(theType, name, theObsObject, enumValue);
			return createOKResult();
		} catch (final PersistenceException pe) {
			return createExceptionResult(pe);
		}
	}

	public synchronized java.util.Hashtable<?, ?> createOperation(final String sourceProxiString, final String targetProxiString, final String name,
			final java.util.Vector<String> fpTrnsprt) {
		try {
			final PersistentMType source = (PersistentMType) PersistentProxi.createProxi(common.RPCConstantsAndServices
					.createProxiInformation(sourceProxiString));
			final PersistentMType target = (PersistentMType) PersistentProxi.createProxi(common.RPCConstantsAndServices
					.createProxiInformation(targetProxiString));
			final FormalParameterSearchList fp = new FormalParameterSearchList();
			final java.util.Iterator<String> fpItrtr = fpTrnsprt.iterator();
			while (fpItrtr.hasNext()) {
				final PersistentFormalParameter currentProxi = (PersistentFormalParameter) PersistentProxi.createProxi(common.RPCConstantsAndServices
						.createProxiInformation(fpItrtr.next()));
				fp.add(currentProxi);
			}
			this.server.createOperation(source, target, name, fp);
			return createOKResult();
		} catch (final PersistenceException pe) {
			return createExceptionResult(pe);
		}
	}

	public synchronized java.util.Hashtable<?, ?> createOperation(final String operationManagerProxiString, final String sourceProxiString,
			final String targetProxiString, final String name, final java.util.Vector<String> fpTrnsprt) {
		try {
			final PersistentOperationManager operationManager = (PersistentOperationManager) PersistentProxi
					.createProxi(common.RPCConstantsAndServices.createProxiInformation(operationManagerProxiString));
			final PersistentMType source = (PersistentMType) PersistentProxi.createProxi(common.RPCConstantsAndServices
					.createProxiInformation(sourceProxiString));
			final PersistentMType target = (PersistentMType) PersistentProxi.createProxi(common.RPCConstantsAndServices
					.createProxiInformation(targetProxiString));
			final FormalParameterSearchList fp = new FormalParameterSearchList();
			final java.util.Iterator<String> fpItrtr = fpTrnsprt.iterator();
			while (fpItrtr.hasNext()) {
				final PersistentFormalParameter currentProxi = (PersistentFormalParameter) PersistentProxi.createProxi(common.RPCConstantsAndServices
						.createProxiInformation(fpItrtr.next()));
				fp.add(currentProxi);
			}
			this.server.createOperation(operationManager, source, target, name, fp);
			return createOKResult();
		} catch (final PersistenceException pe) {
			return createExceptionResult(pe);
		}
	}

	public synchronized java.util.Hashtable<?, ?> createQuantity(final String managerProxiString, final String unitProxiString, final String fAsString) {
		try {
			final PersistentQuantityManager manager = (PersistentQuantityManager) PersistentProxi.createProxi(common.RPCConstantsAndServices
					.createProxiInformation(managerProxiString));
			final PersistentAbsUnit unit = (PersistentAbsUnit) PersistentProxi.createProxi(common.RPCConstantsAndServices
					.createProxiInformation(unitProxiString));
			final common.Fraction f = common.Fraction.parse(fAsString);
			this.server.createQuantity(manager, unit, f);
			return createOKResult();
		} catch (final PersistenceException pe) {
			return createExceptionResult(pe);
		}
	}

	public synchronized java.util.Hashtable<?, ?> createStaticOp(final String operationManagerProxiString, final String name,
			final String targetProxiString, final java.util.Vector<String> fpTrnsprt) {
		try {
			final PersistentOperationManager operationManager = (PersistentOperationManager) PersistentProxi
					.createProxi(common.RPCConstantsAndServices.createProxiInformation(operationManagerProxiString));
			final PersistentMType target = (PersistentMType) PersistentProxi.createProxi(common.RPCConstantsAndServices
					.createProxiInformation(targetProxiString));
			final FormalParameterSearchList fp = new FormalParameterSearchList();
			final java.util.Iterator<String> fpItrtr = fpTrnsprt.iterator();
			while (fpItrtr.hasNext()) {
				final PersistentFormalParameter currentProxi = (PersistentFormalParameter) PersistentProxi.createProxi(common.RPCConstantsAndServices
						.createProxiInformation(fpItrtr.next()));
				fp.add(currentProxi);
			}
			this.server.createStaticOp(operationManager, name, target, fp);
			return createOKResult();
		} catch (final PersistenceException pe) {
			return createExceptionResult(pe);
		}
	}

	public synchronized java.util.Hashtable<?, ?> createTypeConjunction(final String typeManagerProxiString,
			final java.util.Vector<String> containeesTrnsprt) {
		try {
			final PersistentTypeManager typeManager = (PersistentTypeManager) PersistentProxi.createProxi(common.RPCConstantsAndServices
					.createProxiInformation(typeManagerProxiString));
			final MTypeSearchList containees = new MTypeSearchList();
			final java.util.Iterator<String> containeesItrtr = containeesTrnsprt.iterator();
			while (containeesItrtr.hasNext()) {
				final PersistentMType currentProxi = (PersistentMType) PersistentProxi.createProxi(common.RPCConstantsAndServices
						.createProxiInformation(containeesItrtr.next()));
				containees.add(currentProxi);
			}
			this.server.createTypeConjunction(typeManager, containees);
			return createOKResult();
		} catch (final PersistenceException pe) {
			return createExceptionResult(pe);
		}
	}

	public synchronized java.util.Hashtable<?, ?> createTypeDisjunction(final String typeManagerProxiString,
			final java.util.Vector<String> containeesTrnsprt) {
		try {
			final PersistentTypeManager typeManager = (PersistentTypeManager) PersistentProxi.createProxi(common.RPCConstantsAndServices
					.createProxiInformation(typeManagerProxiString));
			final MTypeSearchList containees = new MTypeSearchList();
			final java.util.Iterator<String> containeesItrtr = containeesTrnsprt.iterator();
			while (containeesItrtr.hasNext()) {
				final PersistentMType currentProxi = (PersistentMType) PersistentProxi.createProxi(common.RPCConstantsAndServices
						.createProxiInformation(containeesItrtr.next()));
				containees.add(currentProxi);
			}
			this.server.createTypeDisjunction(typeManager, containees);
			return createOKResult();
		} catch (final PersistenceException pe) {
			return createExceptionResult(pe);
		}
	}

	public synchronized java.util.Hashtable<?, ?> createUnitType(final String managerProxiString, final String name) {
		try {
			final PersistentUnitTypeManager manager = (PersistentUnitTypeManager) PersistentProxi.createProxi(common.RPCConstantsAndServices
					.createProxiInformation(managerProxiString));
			this.server.createUnitType(manager, name);
			return createOKResult();
		} catch (final PersistenceException pe) {
			return createExceptionResult(pe);
		}
	}

	public synchronized java.util.Hashtable<?, ?> createUnit(final String typeProxiString, final String name) {
		try {
			final PersistentUnitType type = (PersistentUnitType) PersistentProxi.createProxi(common.RPCConstantsAndServices
					.createProxiInformation(typeProxiString));
			this.server.createUnit(type, name);
			return createOKResult();
		} catch (final PersistenceException pe) {
			return createExceptionResult(pe);
		}
	}

	public synchronized java.util.Hashtable<?, ?> createVoidOperation(final String sourceProxiString, final String name,
			final java.util.Vector<String> fpTrnsprt) {
		try {
			final PersistentMType source = (PersistentMType) PersistentProxi.createProxi(common.RPCConstantsAndServices
					.createProxiInformation(sourceProxiString));
			final FormalParameterSearchList fp = new FormalParameterSearchList();
			final java.util.Iterator<String> fpItrtr = fpTrnsprt.iterator();
			while (fpItrtr.hasNext()) {
				final PersistentFormalParameter currentProxi = (PersistentFormalParameter) PersistentProxi.createProxi(common.RPCConstantsAndServices
						.createProxiInformation(fpItrtr.next()));
				fp.add(currentProxi);
			}
			this.server.createVoidOperation(source, name, fp);
			return createOKResult();
		} catch (final PersistenceException pe) {
			return createExceptionResult(pe);
		}
	}

	public synchronized java.util.Hashtable<?, ?> createVoidOperation(final String operationManagerProxiString, final String sourceProxiString,
			final String name, final java.util.Vector<String> fpTrnsprt) {
		try {
			final PersistentOperationManager operationManager = (PersistentOperationManager) PersistentProxi
					.createProxi(common.RPCConstantsAndServices.createProxiInformation(operationManagerProxiString));
			final PersistentMType source = (PersistentMType) PersistentProxi.createProxi(common.RPCConstantsAndServices
					.createProxiInformation(sourceProxiString));
			final FormalParameterSearchList fp = new FormalParameterSearchList();
			final java.util.Iterator<String> fpItrtr = fpTrnsprt.iterator();
			while (fpItrtr.hasNext()) {
				final PersistentFormalParameter currentProxi = (PersistentFormalParameter) PersistentProxi.createProxi(common.RPCConstantsAndServices
						.createProxiInformation(fpItrtr.next()));
				fp.add(currentProxi);
			}
			this.server.createVoidOperation(operationManager, source, name, fp);
			return createOKResult();
		} catch (final PersistenceException pe) {
			return createExceptionResult(pe);
		}
	}

	public synchronized java.util.Hashtable<?, ?> deleteAccountType(final String accountTypeProxiString) {
		try {
			final PersistentMAccountType accountType = (PersistentMAccountType) PersistentProxi.createProxi(common.RPCConstantsAndServices
					.createProxiInformation(accountTypeProxiString));
			this.server.deleteAccountType(accountType);
			return createOKResult();
		} catch (final PersistenceException pe) {
			return createExceptionResult(pe);
		} catch (final model.ConsistencyException e0) {
			return createExceptionResult(e0, this);
		}
	}

	public synchronized java.util.Hashtable<?, ?> deleteAccount(final String accountProxiString) {
		try {
			final PersistentAccount account = (PersistentAccount) PersistentProxi.createProxi(common.RPCConstantsAndServices
					.createProxiInformation(accountProxiString));
			this.server.deleteAccount(account);
			return createOKResult();
		} catch (final PersistenceException pe) {
			return createExceptionResult(pe);
		} catch (final model.ConsistencyException e0) {
			return createExceptionResult(e0, this);
		}
	}

	public synchronized java.util.Hashtable<?, ?> deleteAspect(final String aspectProxiString) {
		try {
			final PersistentMAspect aspect = (PersistentMAspect) PersistentProxi.createProxi(common.RPCConstantsAndServices
					.createProxiInformation(aspectProxiString));
			this.server.deleteAspect(aspect);
			return createOKResult();
		} catch (final PersistenceException pe) {
			return createExceptionResult(pe);
		}
	}

	public synchronized java.util.Hashtable<?, ?> deleteAtomicType(final String typeProxiString) {
		try {
			final PersistentMAtomicType type = (PersistentMAtomicType) PersistentProxi.createProxi(common.RPCConstantsAndServices
					.createProxiInformation(typeProxiString));
			this.server.deleteAtomicType(type);
			return createOKResult();
		} catch (final PersistenceException pe) {
			return createExceptionResult(pe);
		}
	}

	public synchronized java.util.Hashtable<?, ?> deleteComplexType(final String typeProxiString) {
		try {
			final PersistentMComplexType type = (PersistentMComplexType) PersistentProxi.createProxi(common.RPCConstantsAndServices
					.createProxiInformation(typeProxiString));
			this.server.deleteComplexType(type);
			return createOKResult();
		} catch (final PersistenceException pe) {
			return createExceptionResult(pe);
		}
	}

	public synchronized java.util.Hashtable<?, ?> deleteEntry(final String measurementProxiString) {
		try {
			final PersistentMeasurement measurement = (PersistentMeasurement) PersistentProxi.createProxi(common.RPCConstantsAndServices
					.createProxiInformation(measurementProxiString));
			this.server.deleteEntry(measurement);
			return createOKResult();
		} catch (final PersistenceException pe) {
			return createExceptionResult(pe);
		} catch (final model.ConsistencyException e0) {
			return createExceptionResult(e0, this);
		}
	}

	public synchronized java.util.Hashtable<?, ?> deleteEnumValue(final String enumValueProxiString) {
		try {
			final PersistentMEnumValue enumValue = (PersistentMEnumValue) PersistentProxi.createProxi(common.RPCConstantsAndServices
					.createProxiInformation(enumValueProxiString));
			this.server.deleteEnumValue(enumValue);
			return createOKResult();
		} catch (final PersistenceException pe) {
			return createExceptionResult(pe);
		}
	}

	public synchronized java.util.Hashtable<?, ?> deleteEnum(final String typeProxiString) {
		try {
			final PersistentMEnum type = (PersistentMEnum) PersistentProxi.createProxi(common.RPCConstantsAndServices
					.createProxiInformation(typeProxiString));
			this.server.deleteEnum(type);
			return createOKResult();
		} catch (final PersistenceException pe) {
			return createExceptionResult(pe);
		}
	}

	public synchronized java.util.Hashtable<?, ?> deleteMeasurementType(final String measurementTypeProxiString) {
		try {
			final PersistentMMeasurementType measurementType = (PersistentMMeasurementType) PersistentProxi
					.createProxi(common.RPCConstantsAndServices.createProxiInformation(measurementTypeProxiString));
			this.server.deleteMeasurementType(measurementType);
			return createOKResult();
		} catch (final PersistenceException pe) {
			return createExceptionResult(pe);
		} catch (final model.ConsistencyException e0) {
			return createExceptionResult(e0, this);
		}
	}

	public synchronized java.util.Hashtable<?, ?> deleteObject(final String objectProxiString) {
		try {
			final PersistentMObject object = (PersistentMObject) PersistentProxi.createProxi(common.RPCConstantsAndServices
					.createProxiInformation(objectProxiString));
			this.server.deleteObject(object);
			return createOKResult();
		} catch (final PersistenceException pe) {
			return createExceptionResult(pe);
		}
	}

	public synchronized java.util.Hashtable<?, ?> deleteObsType(final String theTypeProxiString) {
		try {
			final PersistentMObservationType theType = (PersistentMObservationType) PersistentProxi.createProxi(common.RPCConstantsAndServices
					.createProxiInformation(theTypeProxiString));
			this.server.deleteObsType(theType);
			return createOKResult();
		} catch (final PersistenceException pe) {
			return createExceptionResult(pe);
		}
	}

	public synchronized java.util.Hashtable<?, ?> deleteObservation(final String observationProxiString) {
		try {
			final PersistentMObservation observation = (PersistentMObservation) PersistentProxi.createProxi(common.RPCConstantsAndServices
					.createProxiInformation(observationProxiString));
			this.server.deleteObservation(observation);
			return createOKResult();
		} catch (final PersistenceException pe) {
			return createExceptionResult(pe);
		}
	}

	public synchronized java.util.Hashtable<?, ?> div(final String dividendProxiString, final String divisorProxiString) {
		try {
			final PersistentAbsQuantity dividend = (PersistentAbsQuantity) PersistentProxi.createProxi(common.RPCConstantsAndServices
					.createProxiInformation(dividendProxiString));
			final PersistentAbsQuantity divisor = (PersistentAbsQuantity) PersistentProxi.createProxi(common.RPCConstantsAndServices
					.createProxiInformation(divisorProxiString));
			this.server.div(dividend, divisor);
			return createOKResult();
		} catch (final PersistenceException pe) {
			return createExceptionResult(pe);
		} catch (final model.NotComputableException e0) {
			return createExceptionResult(e0, this);
		}
	}

	public synchronized java.util.Hashtable<?, ?> fetchScalarType(final String managerProxiString) {
		try {
			final PersistentUnitTypeManager manager = (PersistentUnitTypeManager) PersistentProxi.createProxi(common.RPCConstantsAndServices
					.createProxiInformation(managerProxiString));
			this.server.fetchScalarType(manager);
			return createOKResult();
		} catch (final PersistenceException pe) {
			return createExceptionResult(pe);
		}
	}

	public synchronized java.util.Hashtable<?, ?> fetchScalar(final String managerProxiString) {
		try {
			final PersistentUnitTypeManager manager = (PersistentUnitTypeManager) PersistentProxi.createProxi(common.RPCConstantsAndServices
					.createProxiInformation(managerProxiString));
			this.server.fetchScalar(manager);
			return createOKResult();
		} catch (final PersistenceException pe) {
			return createExceptionResult(pe);
		}
	}

	public synchronized java.util.Hashtable<?, ?> mul(final String factor1ProxiString, final String factor2ProxiString) {
		try {
			final PersistentAbsQuantity factor1 = (PersistentAbsQuantity) PersistentProxi.createProxi(common.RPCConstantsAndServices
					.createProxiInformation(factor1ProxiString));
			final PersistentAbsQuantity factor2 = (PersistentAbsQuantity) PersistentProxi.createProxi(common.RPCConstantsAndServices
					.createProxiInformation(factor2ProxiString));
			this.server.mul(factor1, factor2);
			return createOKResult();
		} catch (final PersistenceException pe) {
			return createExceptionResult(pe);
		} catch (final model.DoubleDefinitionException e0) {
			return createExceptionResult(e0, this);
		} catch (final model.NotComputableException e1) {
			return createExceptionResult(e1, this);
		}
	}

	public synchronized java.util.Hashtable<?, ?> removeAssociation(final String aProxiString) {
		try {
			final PersistentAssociation a = (PersistentAssociation) PersistentProxi.createProxi(common.RPCConstantsAndServices
					.createProxiInformation(aProxiString));
			this.server.removeAssociation(a);
			return createOKResult();
		} catch (final PersistenceException pe) {
			return createExceptionResult(pe);
		}
	}

	public synchronized java.util.Hashtable<?, ?> removeFpFromOp(final String operationProxiString, final String fpProxiString) {
		try {
			final PersistentOperation operation = (PersistentOperation) PersistentProxi.createProxi(common.RPCConstantsAndServices
					.createProxiInformation(operationProxiString));
			final PersistentFormalParameter fp = (PersistentFormalParameter) PersistentProxi.createProxi(common.RPCConstantsAndServices
					.createProxiInformation(fpProxiString));
			this.server.removeFpFromOp(operation, fp);
			return createOKResult();
		} catch (final PersistenceException pe) {
			return createExceptionResult(pe);
		}
	}

	public synchronized java.util.Hashtable<?, ?> removeFp(final String fpProxiString) {
		try {
			final PersistentFormalParameter fp = (PersistentFormalParameter) PersistentProxi.createProxi(common.RPCConstantsAndServices
					.createProxiInformation(fpProxiString));
			this.server.removeFp(fp);
			return createOKResult();
		} catch (final PersistenceException pe) {
			return createExceptionResult(pe);
		}
	}

	public synchronized java.util.Hashtable<?, ?> removeFromHierarchy(final String hProxiString, final String aProxiString) {
		try {
			final PersistentHierarchy h = (PersistentHierarchy) PersistentProxi.createProxi(common.RPCConstantsAndServices
					.createProxiInformation(hProxiString));
			final PersistentAssociation a = (PersistentAssociation) PersistentProxi.createProxi(common.RPCConstantsAndServices
					.createProxiInformation(aProxiString));
			this.server.removeFromHierarchy(h, a);
			return createOKResult();
		} catch (final PersistenceException pe) {
			return createExceptionResult(pe);
		}
	}

	public synchronized java.util.Hashtable<?, ?> removeHierarchy(final String hProxiString) {
		try {
			final PersistentHierarchy h = (PersistentHierarchy) PersistentProxi.createProxi(common.RPCConstantsAndServices
					.createProxiInformation(hProxiString));
			this.server.removeHierarchy(h);
			return createOKResult();
		} catch (final PersistenceException pe) {
			return createExceptionResult(pe);
		}
	}

	public synchronized java.util.Hashtable<?, ?> removeLink(final String linkProxiString) {
		try {
			final PersistentLink link = (PersistentLink) PersistentProxi.createProxi(common.RPCConstantsAndServices
					.createProxiInformation(linkProxiString));
			this.server.removeLink(link);
			return createOKResult();
		} catch (final PersistenceException pe) {
			return createExceptionResult(pe);
		}
	}

	public synchronized java.util.Hashtable<?, ?> removeOperation(final String opProxiString) {
		try {
			final PersistentOperation op = (PersistentOperation) PersistentProxi.createProxi(common.RPCConstantsAndServices
					.createProxiInformation(opProxiString));
			this.server.removeOperation(op);
			return createOKResult();
		} catch (final PersistenceException pe) {
			return createExceptionResult(pe);
		}
	}

	public synchronized java.util.Hashtable<?, ?> removeType(final String objectProxiString, final String oldTypeProxiString) {
		try {
			final PersistentMObject object = (PersistentMObject) PersistentProxi.createProxi(common.RPCConstantsAndServices
					.createProxiInformation(objectProxiString));
			final PersistentMAtomicType oldType = (PersistentMAtomicType) PersistentProxi.createProxi(common.RPCConstantsAndServices
					.createProxiInformation(oldTypeProxiString));
			this.server.removeType(object, oldType);
			return createOKResult();
		} catch (final PersistenceException pe) {
			return createExceptionResult(pe);
		}
	}

	public synchronized java.util.Hashtable<?, ?> renameAspect(final String aspectProxiString, final String newName) {
		try {
			final PersistentMAspect aspect = (PersistentMAspect) PersistentProxi.createProxi(common.RPCConstantsAndServices
					.createProxiInformation(aspectProxiString));
			this.server.renameAspect(aspect, newName);
			return createOKResult();
		} catch (final PersistenceException pe) {
			return createExceptionResult(pe);
		}
	}

	public synchronized java.util.Hashtable<?, ?> renameAtomicType(final String typeProxiString, final String newName) {
		try {
			final PersistentMAtomicType type = (PersistentMAtomicType) PersistentProxi.createProxi(common.RPCConstantsAndServices
					.createProxiInformation(typeProxiString));
			this.server.renameAtomicType(type, newName);
			return createOKResult();
		} catch (final PersistenceException pe) {
			return createExceptionResult(pe);
		}
	}

	public synchronized java.util.Hashtable<?, ?> replaceType(final String objectProxiString, final String oldTypeProxiString,
			final String newTypeProxiString) {
		try {
			final PersistentMObject object = (PersistentMObject) PersistentProxi.createProxi(common.RPCConstantsAndServices
					.createProxiInformation(objectProxiString));
			final PersistentMAtomicType oldType = (PersistentMAtomicType) PersistentProxi.createProxi(common.RPCConstantsAndServices
					.createProxiInformation(oldTypeProxiString));
			final PersistentMAtomicType newType = (PersistentMAtomicType) PersistentProxi.createProxi(common.RPCConstantsAndServices
					.createProxiInformation(newTypeProxiString));
			this.server.replaceType(object, oldType, newType);
			return createOKResult();
		} catch (final PersistenceException pe) {
			return createExceptionResult(pe);
		}
	}

	public synchronized java.util.Hashtable<?, ?> setConversion(final String unitProxiString, final String factorAsString,
			final String constantAsString) {
		try {
			final PersistentUnit unit = (PersistentUnit) PersistentProxi.createProxi(common.RPCConstantsAndServices
					.createProxiInformation(unitProxiString));
			final common.Fraction factor = common.Fraction.parse(factorAsString);
			final common.Fraction constant = common.Fraction.parse(constantAsString);
			this.server.setConversion(unit, factor, constant);
			return createOKResult();
		} catch (final PersistenceException pe) {
			return createExceptionResult(pe);
		}
	}

	public synchronized java.util.Hashtable<?, ?> setDefaultUnit(final String typeProxiString, final String defaultUnitProxiString) {
		try {
			final PersistentUnitType type = (PersistentUnitType) PersistentProxi.createProxi(common.RPCConstantsAndServices
					.createProxiInformation(typeProxiString));
			final PersistentUnit defaultUnit = (PersistentUnit) PersistentProxi.createProxi(common.RPCConstantsAndServices
					.createProxiInformation(defaultUnitProxiString));
			this.server.setDefaultUnit(type, defaultUnit);
			return createOKResult();
		} catch (final PersistenceException pe) {
			return createExceptionResult(pe);
		}
	}

	public synchronized java.util.Hashtable<?, ?> sub(final String minuendProxiString, final String subtrahendProxiString) {
		try {
			final PersistentAbsQuantity minuend = (PersistentAbsQuantity) PersistentProxi.createProxi(common.RPCConstantsAndServices
					.createProxiInformation(minuendProxiString));
			final PersistentAbsQuantity subtrahend = (PersistentAbsQuantity) PersistentProxi.createProxi(common.RPCConstantsAndServices
					.createProxiInformation(subtrahendProxiString));
			this.server.sub(minuend, subtrahend);
			return createOKResult();
		} catch (final PersistenceException pe) {
			return createExceptionResult(pe);
		} catch (final model.NotComputableException e0) {
			return createExceptionResult(e0, this);
		}
	}

}
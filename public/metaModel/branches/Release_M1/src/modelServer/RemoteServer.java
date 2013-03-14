
package modelServer;


import model.*;
import persistence.*;

public  class RemoteServer extends RemoteServerMaster {

	protected PersistentServer server;

	public RemoteServer(String connectionName, String userName, PersistentServer server){
		super (connectionName, userName );
        this.server = server;
	}

	protected Remote getServer(){
        return this.server;
    } 

    public synchronized java.util.Hashtable<?,?> containees_Path_In_CreateTypeConjunction(){
        try {
            MTypeSearchList result = ((PersistentServer)this.server).containees_Path_In_CreateTypeConjunction();
            return createOKResult(result.getVector(1, 0, false, this, false, true));
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.UserException e0){
            return createExceptionResult(e0, this);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> containees_Path_In_CreateTypeDisjunction(){
        try {
            MTypeSearchList result = ((PersistentServer)this.server).containees_Path_In_CreateTypeDisjunction();
            return createOKResult(result.getVector(1, 0, false, this, false, true));
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.UserException e0){
            return createExceptionResult(e0, this);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> defaultUnit_Path_In_SetDefaultUnit(){
        try {
            AbsUnitSearchList result = ((PersistentServer)this.server).defaultUnit_Path_In_SetDefaultUnit();
            return createOKResult(result.getVector(1, 0, false, this, false, true));
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.UserException e0){
            return createExceptionResult(e0, this);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> fp_Path_In_AddFp(){
        try {
            FormalParameterSearchList result = ((PersistentServer)this.server).fp_Path_In_AddFp();
            return createOKResult(result.getVector(1, 0, false, this, false, true));
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.UserException e0){
            return createExceptionResult(e0, this);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> fp_Path_In_CreateOperation(){
        try {
            FormalParameterSearchList result = ((PersistentServer)this.server).fp_Path_In_CreateOperation();
            return createOKResult(result.getVector(1, 0, false, this, false, true));
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.UserException e0){
            return createExceptionResult(e0, this);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> fp_Path_In_CreateStaticOp(){
        try {
            FormalParameterSearchList result = ((PersistentServer)this.server).fp_Path_In_CreateStaticOp();
            return createOKResult(result.getVector(1, 0, false, this, false, true));
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.UserException e0){
            return createExceptionResult(e0, this);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> fp_Path_In_CreateVoidOperation(){
        try {
            FormalParameterSearchList result = ((PersistentServer)this.server).fp_Path_In_CreateVoidOperation();
            return createOKResult(result.getVector(1, 0, false, this, false, true));
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.UserException e0){
            return createExceptionResult(e0, this);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> measurementType_Path_In_CreateEntry(){
        try {
            MMeasurementTypeSearchList result = ((PersistentServer)this.server).measurementType_Path_In_CreateEntry();
            return createOKResult(result.getVector(1, 0, false, this, false, true));
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.UserException e0){
            return createExceptionResult(e0, this);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> newType_Path_In_AddType(){
        try {
            MTypeSearchList result = ((PersistentServer)this.server).newType_Path_In_AddType();
            return createOKResult(result.getVector(1, 0, false, this, false, true));
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.UserException e0){
            return createExceptionResult(e0, this);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> newType_Path_In_ReplaceType(String oldTypeProxiString){
        try {
            PersistentMAtomicType oldType = (PersistentMAtomicType)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(oldTypeProxiString));
            MAtomicTypeSearchList result = ((PersistentServer)this.server).newType_Path_In_ReplaceType(oldType);
            return createOKResult(result.getVector(1, 0, false, this, false, true));
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.UserException e0){
            return createExceptionResult(e0, this);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> object_Path_In_CreateEntry(){
        try {
            MObjectSearchList result = ((PersistentServer)this.server).object_Path_In_CreateEntry();
            return createOKResult(result.getVector(1, 0, false, this, false, true));
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.UserException e0){
            return createExceptionResult(e0, this);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> ofType_Path_In_CreateFp(){
        try {
            MTypeSearchList result = ((PersistentServer)this.server).ofType_Path_In_CreateFp();
            return createOKResult(result.getVector(1, 0, false, this, false, true));
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.UserException e0){
            return createExceptionResult(e0, this);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> oldType_Path_In_RemoveType(String objectProxiString){
        try {
            PersistentMObject object = (PersistentMObject)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(objectProxiString));
            MAtomicTypeSearchList result = ((PersistentServer)this.server).oldType_Path_In_RemoveType(object);
            return createOKResult(result.getVector(1, 0, false, this, false, true));
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.UserException e0){
            return createExceptionResult(e0, this);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> oldType_Path_In_ReplaceType(String objectProxiString){
        try {
            PersistentMObject object = (PersistentMObject)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(objectProxiString));
            MAtomicTypeSearchList result = ((PersistentServer)this.server).oldType_Path_In_ReplaceType(object);
            return createOKResult(result.getVector(1, 0, false, this, false, true));
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.UserException e0){
            return createExceptionResult(e0, this);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> otherTypes_Path_In_CreateMObject(){
        try {
            MTypeSearchList result = ((PersistentServer)this.server).otherTypes_Path_In_CreateMObject();
            return createOKResult(result.getVector(1, 0, false, this, false, true));
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.UserException e0){
            return createExceptionResult(e0, this);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> quantity_Path_In_CreateEntry(){
        try {
            AbsQuantitySearchList result = ((PersistentServer)this.server).quantity_Path_In_CreateEntry();
            return createOKResult(result.getVector(1, 0, false, this, false, true));
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.UserException e0){
            return createExceptionResult(e0, this);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> referenceUnitType_Path_In_AddReferenceType(){
        try {
            UnitTypeSearchList result = ((PersistentServer)this.server).referenceUnitType_Path_In_AddReferenceType();
            return createOKResult(result.getVector(1, 0, false, this, false, true));
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.UserException e0){
            return createExceptionResult(e0, this);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> referenceUnit_Path_In_AddReference(){
        try {
            AbsUnitSearchList result = ((PersistentServer)this.server).referenceUnit_Path_In_AddReference();
            return createOKResult(result.getVector(1, 0, false, this, false, true));
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.UserException e0){
            return createExceptionResult(e0, this);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> scheme_Path_In_AssignNameScheme(){
        try {
            NameSchemeSearchList result = ((PersistentServer)this.server).scheme_Path_In_AssignNameScheme();
            return createOKResult(result.getVector(1, 0, false, this, false, true));
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.UserException e0){
            return createExceptionResult(e0, this);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> scheme_Path_In_AssignName(String objectProxiString){
        try {
            PersistentMObject object = (PersistentMObject)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(objectProxiString));
            MAtomicTypeSearchList result = ((PersistentServer)this.server).scheme_Path_In_AssignName(object);
            return createOKResult(result.getVector(1, 0, false, this, false, true));
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.UserException e0){
            return createExceptionResult(e0, this);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> source_Path_In_CreateLink(){
        try {
            MObjectSearchList result = ((PersistentServer)this.server).source_Path_In_CreateLink();
            return createOKResult(result.getVector(1, 0, false, this, false, true));
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.UserException e0){
            return createExceptionResult(e0, this);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> source_Path_In_CreateOperation(){
        try {
            MTypeSearchList result = ((PersistentServer)this.server).source_Path_In_CreateOperation();
            return createOKResult(result.getVector(1, 0, false, this, false, true));
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.UserException e0){
            return createExceptionResult(e0, this);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> source_Path_In_CreateVoidOperation(){
        try {
            MTypeSearchList result = ((PersistentServer)this.server).source_Path_In_CreateVoidOperation();
            return createOKResult(result.getVector(1, 0, false, this, false, true));
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.UserException e0){
            return createExceptionResult(e0, this);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> target_Path_In_CreateConstant(){
        try {
            MTypeSearchList result = ((PersistentServer)this.server).target_Path_In_CreateConstant();
            return createOKResult(result.getVector(1, 0, false, this, false, true));
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.UserException e0){
            return createExceptionResult(e0, this);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> target_Path_In_CreateLink(){
        try {
            MObjectSearchList result = ((PersistentServer)this.server).target_Path_In_CreateLink();
            return createOKResult(result.getVector(1, 0, false, this, false, true));
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.UserException e0){
            return createExceptionResult(e0, this);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> target_Path_In_CreateOperation(){
        try {
            MTypeSearchList result = ((PersistentServer)this.server).target_Path_In_CreateOperation();
            return createOKResult(result.getVector(1, 0, false, this, false, true));
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.UserException e0){
            return createExceptionResult(e0, this);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> target_Path_In_CreateStaticOp(){
        try {
            MTypeSearchList result = ((PersistentServer)this.server).target_Path_In_CreateStaticOp();
            return createOKResult(result.getVector(1, 0, false, this, false, true));
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.UserException e0){
            return createExceptionResult(e0, this);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> type_Path_In_CreateAccountType(){
        try {
            MTypeSearchList result = ((PersistentServer)this.server).type_Path_In_CreateAccountType();
            return createOKResult(result.getVector(1, 0, false, this, false, true));
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.UserException e0){
            return createExceptionResult(e0, this);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> type_Path_In_CreateAccount(){
        try {
            MAccountTypeSearchList result = ((PersistentServer)this.server).type_Path_In_CreateAccount();
            return createOKResult(result.getVector(1, 0, false, this, false, true));
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.UserException e0){
            return createExceptionResult(e0, this);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> type_Path_In_CreateLink(){
        try {
            AssociationSearchList result = ((PersistentServer)this.server).type_Path_In_CreateLink();
            return createOKResult(result.getVector(1, 0, false, this, false, true));
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.UserException e0){
            return createExceptionResult(e0, this);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> type_Path_In_CreateMObject(){
        try {
            MTypeSearchList result = ((PersistentServer)this.server).type_Path_In_CreateMObject();
            return createOKResult(result.getVector(1, 0, false, this, false, true));
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.UserException e0){
            return createExceptionResult(e0, this);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> type_Path_In_CreateMeasurementType(){
        try {
            MTypeSearchList result = ((PersistentServer)this.server).type_Path_In_CreateMeasurementType();
            return createOKResult(result.getVector(1, 0, false, this, false, true));
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.UserException e0){
            return createExceptionResult(e0, this);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> unitType_Path_In_CreateAccountType(){
        try {
            UnitTypeSearchList result = ((PersistentServer)this.server).unitType_Path_In_CreateAccountType();
            return createOKResult(result.getVector(1, 0, false, this, false, true));
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.UserException e0){
            return createExceptionResult(e0, this);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> unitType_Path_In_CreateMeasurementType(){
        try {
            UnitTypeSearchList result = ((PersistentServer)this.server).unitType_Path_In_CreateMeasurementType();
            return createOKResult(result.getVector(1, 0, false, this, false, true));
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.UserException e0){
            return createExceptionResult(e0, this);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> addAssociation(String hProxiString, String aProxiString){
        try {
            PersistentHierarchy h = (PersistentHierarchy)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(hProxiString));
            PersistentAssociation a = (PersistentAssociation)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(aProxiString));
            ((PersistentServer)this.server).addAssociation(h, a);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> addFp(String opProxiString, String fpProxiString){
        try {
            PersistentOperation op = (PersistentOperation)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(opProxiString));
            PersistentFormalParameter fp = (PersistentFormalParameter)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(fpProxiString));
            ((PersistentServer)this.server).addFp(op, fp);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> addReferenceType(String unitTypeProxiString, String name, String referenceUnitTypeProxiString, String exponentAsString){
        try {
            PersistentAbsUnitType unitType = (PersistentAbsUnitType)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(unitTypeProxiString));
            PersistentUnitType referenceUnitType = (PersistentUnitType)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(referenceUnitTypeProxiString));
            long exponent = new Long(exponentAsString).longValue();
            ((PersistentServer)this.server).addReferenceType(unitType, name, referenceUnitType, exponent);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> addReference(String unitProxiString, String name, String referenceUnitProxiString, String exponentAsString){
        try {
            PersistentAbsUnit unit = (PersistentAbsUnit)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(unitProxiString));
            PersistentUnit referenceUnit = (PersistentUnit)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(referenceUnitProxiString));
            long exponent = new Long(exponentAsString).longValue();
            ((PersistentServer)this.server).addReference(unit, name, referenceUnit, exponent);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> addSubAccountType(String parentProxiString, String childProxiString){
        try {
            PersistentMAccountType parent = (PersistentMAccountType)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(parentProxiString));
            PersistentMAccountType child = (PersistentMAccountType)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(childProxiString));
            ((PersistentServer)this.server).addSubAccountType(parent, child);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.CycleException e0){
            return createExceptionResult(e0, this);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> addSubAccount(String parentProxiString, String childProxiString){
        try {
            PersistentAccount parent = (PersistentAccount)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(parentProxiString));
            PersistentAccount child = (PersistentAccount)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(childProxiString));
            ((PersistentServer)this.server).addSubAccount(parent, child);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.CycleException e0){
            return createExceptionResult(e0, this);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> addToHierarchy(String associationProxiString, String theHierarchyProxiString){
        try {
            PersistentAssociation association = (PersistentAssociation)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(associationProxiString));
            PersistentHierarchy theHierarchy = (PersistentHierarchy)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(theHierarchyProxiString));
            ((PersistentServer)this.server).addToHierarchy(association, theHierarchy);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> addType(String objectProxiString, String newTypeProxiString){
        try {
            PersistentMObject object = (PersistentMObject)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(objectProxiString));
            PersistentMAtomicType newType = (PersistentMAtomicType)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(newTypeProxiString));
            ((PersistentServer)this.server).addType(object, newType);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> add(String summand1ProxiString, String summand2ProxiString){
        try {
            PersistentAbsQuantity summand1 = (PersistentAbsQuantity)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(summand1ProxiString));
            PersistentAbsQuantity summand2 = (PersistentAbsQuantity)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(summand2ProxiString));
            ((PersistentServer)this.server).add(summand1, summand2);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.NotComputableException e0){
            return createExceptionResult(e0, this);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> assignNameScheme(String typeProxiString, String schemeProxiString){
        try {
            PersistentMAtomicType type = (PersistentMAtomicType)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(typeProxiString));
            PersistentNameScheme scheme = (PersistentNameScheme)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(schemeProxiString));
            ((PersistentServer)this.server).assignNameScheme(type, scheme);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> assignName(String objectProxiString, String schemeProxiString, String name){
        try {
            PersistentMObject object = (PersistentMObject)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(objectProxiString));
            PersistentName scheme = (PersistentName)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(schemeProxiString));
            ((PersistentServer)this.server).assignName(object, scheme, name);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> assignType(String schemeProxiString, String typeProxiString){
        try {
            PersistentNameScheme scheme = (PersistentNameScheme)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(schemeProxiString));
            PersistentMAtomicType type = (PersistentMAtomicType)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(typeProxiString));
            ((PersistentServer)this.server).assignType(scheme, type);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> changeAbstract(String typeProxiString, String newAbstractType){
        try {
            PersistentMAtomicType type = (PersistentMAtomicType)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(typeProxiString));
            ((PersistentServer)this.server).changeAbstract(type, newAbstractType);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> changeSingleton(String typeProxiString, String newSingletonType){
        try {
            PersistentMAtomicType type = (PersistentMAtomicType)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(typeProxiString));
            ((PersistentServer)this.server).changeSingleton(type, newSingletonType);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> changeUnitName(String unitProxiString, String name){
        try {
            PersistentAbsUnit unit = (PersistentAbsUnit)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(unitProxiString));
            ((PersistentServer)this.server).changeUnitName(unit, name);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> changeUnitTypeName(String unitTypeProxiString, String name){
        try {
            PersistentAbsUnitType unitType = (PersistentAbsUnitType)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(unitTypeProxiString));
            ((PersistentServer)this.server).changeUnitTypeName(unitType, name);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> convertToDefault(String quantityProxiString){
        try {
            PersistentQuantity quantity = (PersistentQuantity)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(quantityProxiString));
            ((PersistentServer)this.server).convertToDefault(quantity);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> convert(String quantityProxiString, String unitProxiString){
        try {
            PersistentQuantity quantity = (PersistentQuantity)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(quantityProxiString));
            PersistentAbsUnit unit = (PersistentAbsUnit)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(unitProxiString));
            ((PersistentServer)this.server).convert(quantity, unit);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> createAccountType(String accountTypeManagerProxiString, String name, String typeProxiString, String unitTypeProxiString){
        try {
            PersistentAccountTypeManager accountTypeManager = (PersistentAccountTypeManager)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(accountTypeManagerProxiString));
            PersistentMType type = (PersistentMType)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(typeProxiString));
            PersistentUnitType unitType = (PersistentUnitType)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(unitTypeProxiString));
            ((PersistentServer)this.server).createAccountType(accountTypeManager, name, type, unitType);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> createAccount(String accountManagerProxiString, String name, String typeProxiString, String objectProxiString){
        try {
            PersistentAccountManager accountManager = (PersistentAccountManager)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(accountManagerProxiString));
            PersistentMAccountType type = (PersistentMAccountType)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(typeProxiString));
            PersistentMObject object = (PersistentMObject)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(objectProxiString));
            ((PersistentServer)this.server).createAccount(accountManager, name, type, object);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> createAspect(String aspectManagerProxiString, String name){
        try {
            PersistentAspectManager aspectManager = (PersistentAspectManager)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(aspectManagerProxiString));
            ((PersistentServer)this.server).createAspect(aspectManager, name);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> createAssociation(String managerProxiString, String sourceProxiString, String targetProxiString, String name){
        try {
            PersistentAssociationManager manager = (PersistentAssociationManager)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(managerProxiString));
            PersistentMType source = (PersistentMType)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(sourceProxiString));
            PersistentMType target = (PersistentMType)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(targetProxiString));
            ((PersistentServer)this.server).createAssociation(manager, source, target, name);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> createAtomicRootType(String aspectProxiString, String typeName, String singletonType, String abstractType){
        try {
            PersistentMAspect aspect = (PersistentMAspect)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(aspectProxiString));
            ((PersistentServer)this.server).createAtomicRootType(aspect, typeName, singletonType, abstractType);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> createAtomicSubType(String superTypeProxiString, String typeName, String singletonType, String abstractType){
        try {
            PersistentMAtomicType superType = (PersistentMAtomicType)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(superTypeProxiString));
            ((PersistentServer)this.server).createAtomicSubType(superType, typeName, singletonType, abstractType);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> createConstant(String operationManagerProxiString, String name, String targetProxiString){
        try {
            PersistentOperationManager operationManager = (PersistentOperationManager)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(operationManagerProxiString));
            PersistentMType target = (PersistentMType)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(targetProxiString));
            ((PersistentServer)this.server).createConstant(operationManager, name, target);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> createEntry(String accountProxiString, String objectProxiString, String measurementTypeProxiString, String quantityProxiString){
        try {
            PersistentAccount account = (PersistentAccount)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(accountProxiString));
            PersistentMObject object = (PersistentMObject)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(objectProxiString));
            PersistentMMeasurementType measurementType = (PersistentMMeasurementType)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(measurementTypeProxiString));
            PersistentQuantity quantity = (PersistentQuantity)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(quantityProxiString));
            ((PersistentServer)this.server).createEntry(account, object, measurementType, quantity);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.ConsistencyException e0){
            return createExceptionResult(e0, this);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> createEnumValue(String typeProxiString, String name){
        try {
            PersistentMEnum type = (PersistentMEnum)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(typeProxiString));
            ((PersistentServer)this.server).createEnumValue(type, name);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> createEnum(String name){
        try {
            ((PersistentServer)this.server).createEnum(name);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> createFp(String operationManagerProxiString, String name, String ofTypeProxiString){
        try {
            PersistentOperationManager operationManager = (PersistentOperationManager)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(operationManagerProxiString));
            PersistentMType ofType = (PersistentMType)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(ofTypeProxiString));
            ((PersistentServer)this.server).createFp(operationManager, name, ofType);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> createHierarchy(String managerProxiString, String aProxiString, String name){
        try {
            PersistentAssociationManager manager = (PersistentAssociationManager)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(managerProxiString));
            PersistentAssociation a = (PersistentAssociation)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(aProxiString));
            ((PersistentServer)this.server).createHierarchy(manager, a, name);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> createHierarchy(String aProxiString, String name){
        try {
            PersistentAssociation a = (PersistentAssociation)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(aProxiString));
            ((PersistentServer)this.server).createHierarchy(a, name);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> createLink(String linkProxiString, String typeProxiString, String sourceProxiString, String targetProxiString){
        try {
            PersistentLinkManager link = (PersistentLinkManager)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(linkProxiString));
            PersistentAssociation type = (PersistentAssociation)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(typeProxiString));
            PersistentMObject source = (PersistentMObject)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(sourceProxiString));
            PersistentMObject target = (PersistentMObject)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(targetProxiString));
            ((PersistentServer)this.server).createLink(link, type, source, target);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> createLink(String sourceProxiString, String typeProxiString, String targetProxiString){
        try {
            PersistentMObject source = (PersistentMObject)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(sourceProxiString));
            PersistentAssociation type = (PersistentAssociation)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(typeProxiString));
            PersistentMObject target = (PersistentMObject)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(targetProxiString));
            ((PersistentServer)this.server).createLink(source, type, target);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> createMObject(String typeProxiString, java.util.Vector<String> otherTypesTrnsprt){
        try {
            PersistentMAtomicType type = (PersistentMAtomicType)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(typeProxiString));
            MAtomicTypeSearchList otherTypes = new MAtomicTypeSearchList();
			java.util.Iterator<String> otherTypesItrtr = otherTypesTrnsprt.iterator();
			while (otherTypesItrtr.hasNext()){
				PersistentMAtomicType currentProxi = (PersistentMAtomicType)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(otherTypesItrtr.next()));
				otherTypes.add(currentProxi);
			}
            ((PersistentServer)this.server).createMObject(type, otherTypes);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> createMeasurementType(String measurementTypeManagerProxiString, String name, String typeProxiString, String unitTypeProxiString){
        try {
            PersistentMeasurementTypeManager measurementTypeManager = (PersistentMeasurementTypeManager)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(measurementTypeManagerProxiString));
            PersistentMType type = (PersistentMType)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(typeProxiString));
            PersistentUnitType unitType = (PersistentUnitType)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(unitTypeProxiString));
            ((PersistentServer)this.server).createMeasurementType(measurementTypeManager, name, type, unitType);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> createNameScheme(String managerProxiString, String schemeName, String regExp, String isIterable){
        try {
            PersistentNameSchemeManager manager = (PersistentNameSchemeManager)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(managerProxiString));
            ((PersistentServer)this.server).createNameScheme(manager, schemeName, regExp, isIterable);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> createObsType(String name, String enumTypeProxiString, String theTypeProxiString){
        try {
            PersistentMEnum enumType = (PersistentMEnum)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(enumTypeProxiString));
            PersistentMType theType = (PersistentMType)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(theTypeProxiString));
            ((PersistentServer)this.server).createObsType(name, enumType, theType);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> createObservation(String theTypeProxiString, String name, String theObsObjectProxiString, String enumValueProxiString){
        try {
            PersistentMObservationType theType = (PersistentMObservationType)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(theTypeProxiString));
            PersistentMObject theObsObject = (PersistentMObject)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(theObsObjectProxiString));
            PersistentMEnumValue enumValue = (PersistentMEnumValue)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(enumValueProxiString));
            ((PersistentServer)this.server).createObservation(theType, name, theObsObject, enumValue);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> createOperation(String sourceProxiString, String targetProxiString, String name, java.util.Vector<String> fpTrnsprt){
        try {
            PersistentMType source = (PersistentMType)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(sourceProxiString));
            PersistentMType target = (PersistentMType)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(targetProxiString));
            FormalParameterSearchList fp = new FormalParameterSearchList();
			java.util.Iterator<String> fpItrtr = fpTrnsprt.iterator();
			while (fpItrtr.hasNext()){
				PersistentFormalParameter currentProxi = (PersistentFormalParameter)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(fpItrtr.next()));
				fp.add(currentProxi);
			}
            ((PersistentServer)this.server).createOperation(source, target, name, fp);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> createOperation(String operationManagerProxiString, String sourceProxiString, String targetProxiString, String name, java.util.Vector<String> fpTrnsprt){
        try {
            PersistentOperationManager operationManager = (PersistentOperationManager)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(operationManagerProxiString));
            PersistentMType source = (PersistentMType)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(sourceProxiString));
            PersistentMType target = (PersistentMType)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(targetProxiString));
            FormalParameterSearchList fp = new FormalParameterSearchList();
			java.util.Iterator<String> fpItrtr = fpTrnsprt.iterator();
			while (fpItrtr.hasNext()){
				PersistentFormalParameter currentProxi = (PersistentFormalParameter)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(fpItrtr.next()));
				fp.add(currentProxi);
			}
            ((PersistentServer)this.server).createOperation(operationManager, source, target, name, fp);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> createQuantity(String managerProxiString, String unitProxiString, String fAsString){
        try {
            PersistentQuantityManager manager = (PersistentQuantityManager)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(managerProxiString));
            PersistentAbsUnit unit = (PersistentAbsUnit)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(unitProxiString));
            common.Fraction f = common.Fraction.parse(fAsString);
            ((PersistentServer)this.server).createQuantity(manager, unit, f);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> createStaticOp(String operationManagerProxiString, String name, String targetProxiString, java.util.Vector<String> fpTrnsprt){
        try {
            PersistentOperationManager operationManager = (PersistentOperationManager)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(operationManagerProxiString));
            PersistentMType target = (PersistentMType)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(targetProxiString));
            FormalParameterSearchList fp = new FormalParameterSearchList();
			java.util.Iterator<String> fpItrtr = fpTrnsprt.iterator();
			while (fpItrtr.hasNext()){
				PersistentFormalParameter currentProxi = (PersistentFormalParameter)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(fpItrtr.next()));
				fp.add(currentProxi);
			}
            ((PersistentServer)this.server).createStaticOp(operationManager, name, target, fp);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> createTypeConjunction(java.util.Vector<String> containeesTrnsprt){
        try {
            MTypeSearchList containees = new MTypeSearchList();
			java.util.Iterator<String> containeesItrtr = containeesTrnsprt.iterator();
			while (containeesItrtr.hasNext()){
				PersistentMType currentProxi = (PersistentMType)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(containeesItrtr.next()));
				containees.add(currentProxi);
			}
            ((PersistentServer)this.server).createTypeConjunction(containees);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> createTypeDisjunction(java.util.Vector<String> containeesTrnsprt){
        try {
            MTypeSearchList containees = new MTypeSearchList();
			java.util.Iterator<String> containeesItrtr = containeesTrnsprt.iterator();
			while (containeesItrtr.hasNext()){
				PersistentMType currentProxi = (PersistentMType)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(containeesItrtr.next()));
				containees.add(currentProxi);
			}
            ((PersistentServer)this.server).createTypeDisjunction(containees);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> createUnitType(String managerProxiString, String name){
        try {
            PersistentUnitTypeManager manager = (PersistentUnitTypeManager)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(managerProxiString));
            ((PersistentServer)this.server).createUnitType(manager, name);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> createUnit(String typeProxiString, String name){
        try {
            PersistentUnitType type = (PersistentUnitType)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(typeProxiString));
            ((PersistentServer)this.server).createUnit(type, name);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> createVoidOperation(String sourceProxiString, String name, java.util.Vector<String> fpTrnsprt){
        try {
            PersistentMType source = (PersistentMType)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(sourceProxiString));
            FormalParameterSearchList fp = new FormalParameterSearchList();
			java.util.Iterator<String> fpItrtr = fpTrnsprt.iterator();
			while (fpItrtr.hasNext()){
				PersistentFormalParameter currentProxi = (PersistentFormalParameter)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(fpItrtr.next()));
				fp.add(currentProxi);
			}
            ((PersistentServer)this.server).createVoidOperation(source, name, fp);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> createVoidOperation(String operationManagerProxiString, String sourceProxiString, String name, java.util.Vector<String> fpTrnsprt){
        try {
            PersistentOperationManager operationManager = (PersistentOperationManager)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(operationManagerProxiString));
            PersistentMType source = (PersistentMType)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(sourceProxiString));
            FormalParameterSearchList fp = new FormalParameterSearchList();
			java.util.Iterator<String> fpItrtr = fpTrnsprt.iterator();
			while (fpItrtr.hasNext()){
				PersistentFormalParameter currentProxi = (PersistentFormalParameter)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(fpItrtr.next()));
				fp.add(currentProxi);
			}
            ((PersistentServer)this.server).createVoidOperation(operationManager, source, name, fp);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> deleteAspect(String aspectProxiString){
        try {
            PersistentMAspect aspect = (PersistentMAspect)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(aspectProxiString));
            ((PersistentServer)this.server).deleteAspect(aspect);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> deleteAtomicType(String typeProxiString){
        try {
            PersistentMAtomicType type = (PersistentMAtomicType)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(typeProxiString));
            ((PersistentServer)this.server).deleteAtomicType(type);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> deleteComplexType(String typeProxiString){
        try {
            PersistentMComplexType type = (PersistentMComplexType)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(typeProxiString));
            ((PersistentServer)this.server).deleteComplexType(type);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> deleteEnumValue(String enumValueProxiString){
        try {
            PersistentMEnumValue enumValue = (PersistentMEnumValue)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(enumValueProxiString));
            ((PersistentServer)this.server).deleteEnumValue(enumValue);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> deleteEnum(String typeProxiString){
        try {
            PersistentMEnum type = (PersistentMEnum)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(typeProxiString));
            ((PersistentServer)this.server).deleteEnum(type);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> deleteObsType(String theTypeProxiString){
        try {
            PersistentMObservationType theType = (PersistentMObservationType)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(theTypeProxiString));
            ((PersistentServer)this.server).deleteObsType(theType);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> deleteObservation(String observationProxiString){
        try {
            PersistentMObservation observation = (PersistentMObservation)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(observationProxiString));
            ((PersistentServer)this.server).deleteObservation(observation);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> div(String dividendProxiString, String divisorProxiString){
        try {
            PersistentAbsQuantity dividend = (PersistentAbsQuantity)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(dividendProxiString));
            PersistentAbsQuantity divisor = (PersistentAbsQuantity)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(divisorProxiString));
            ((PersistentServer)this.server).div(dividend, divisor);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.NotComputableException e0){
            return createExceptionResult(e0, this);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> fetchScalarType(String managerProxiString){
        try {
            PersistentUnitTypeManager manager = (PersistentUnitTypeManager)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(managerProxiString));
            ((PersistentServer)this.server).fetchScalarType(manager);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> fetchScalar(String managerProxiString){
        try {
            PersistentUnitTypeManager manager = (PersistentUnitTypeManager)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(managerProxiString));
            ((PersistentServer)this.server).fetchScalar(manager);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> mul(String factor1ProxiString, String factor2ProxiString){
        try {
            PersistentAbsQuantity factor1 = (PersistentAbsQuantity)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(factor1ProxiString));
            PersistentAbsQuantity factor2 = (PersistentAbsQuantity)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(factor2ProxiString));
            ((PersistentServer)this.server).mul(factor1, factor2);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.DoubleDefinitionException e0){
            return createExceptionResult(e0, this);
        }catch(model.NotComputableException e1){
            return createExceptionResult(e1, this);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> removeAssociation(String aProxiString){
        try {
            PersistentAssociation a = (PersistentAssociation)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(aProxiString));
            ((PersistentServer)this.server).removeAssociation(a);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> removeFpFromOp(String operationProxiString, String fpProxiString){
        try {
            PersistentOperation operation = (PersistentOperation)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(operationProxiString));
            PersistentFormalParameter fp = (PersistentFormalParameter)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(fpProxiString));
            ((PersistentServer)this.server).removeFpFromOp(operation, fp);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> removeFp(String fpProxiString){
        try {
            PersistentFormalParameter fp = (PersistentFormalParameter)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(fpProxiString));
            ((PersistentServer)this.server).removeFp(fp);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> removeFromHierarchy(String hProxiString, String aProxiString){
        try {
            PersistentHierarchy h = (PersistentHierarchy)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(hProxiString));
            PersistentAssociation a = (PersistentAssociation)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(aProxiString));
            ((PersistentServer)this.server).removeFromHierarchy(h, a);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> removeHierarchy(String hProxiString){
        try {
            PersistentHierarchy h = (PersistentHierarchy)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(hProxiString));
            ((PersistentServer)this.server).removeHierarchy(h);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> removeLink(String linkProxiString){
        try {
            PersistentLink link = (PersistentLink)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(linkProxiString));
            ((PersistentServer)this.server).removeLink(link);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> removeOperation(String opProxiString){
        try {
            PersistentOperation op = (PersistentOperation)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(opProxiString));
            ((PersistentServer)this.server).removeOperation(op);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> removeType(String objectProxiString, String oldTypeProxiString){
        try {
            PersistentMObject object = (PersistentMObject)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(objectProxiString));
            PersistentMAtomicType oldType = (PersistentMAtomicType)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(oldTypeProxiString));
            ((PersistentServer)this.server).removeType(object, oldType);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> renameAspect(String aspectProxiString, String newName){
        try {
            PersistentMAspect aspect = (PersistentMAspect)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(aspectProxiString));
            ((PersistentServer)this.server).renameAspect(aspect, newName);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> renameAtomicType(String typeProxiString, String newName){
        try {
            PersistentMAtomicType type = (PersistentMAtomicType)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(typeProxiString));
            ((PersistentServer)this.server).renameAtomicType(type, newName);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> replaceType(String objectProxiString, String oldTypeProxiString, String newTypeProxiString){
        try {
            PersistentMObject object = (PersistentMObject)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(objectProxiString));
            PersistentMAtomicType oldType = (PersistentMAtomicType)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(oldTypeProxiString));
            PersistentMAtomicType newType = (PersistentMAtomicType)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(newTypeProxiString));
            ((PersistentServer)this.server).replaceType(object, oldType, newType);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> setConversion(String unitProxiString, String factorAsString, String constantAsString){
        try {
            PersistentUnit unit = (PersistentUnit)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(unitProxiString));
            common.Fraction factor = common.Fraction.parse(factorAsString);
            common.Fraction constant = common.Fraction.parse(constantAsString);
            ((PersistentServer)this.server).setConversion(unit, factor, constant);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> setDefaultUnit(String typeProxiString, String defaultUnitProxiString){
        try {
            PersistentUnitType type = (PersistentUnitType)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(typeProxiString));
            PersistentUnit defaultUnit = (PersistentUnit)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(defaultUnitProxiString));
            ((PersistentServer)this.server).setDefaultUnit(type, defaultUnit);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> sub(String minuendProxiString, String subtrahendProxiString){
        try {
            PersistentAbsQuantity minuend = (PersistentAbsQuantity)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(minuendProxiString));
            PersistentAbsQuantity subtrahend = (PersistentAbsQuantity)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(subtrahendProxiString));
            ((PersistentServer)this.server).sub(minuend, subtrahend);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.NotComputableException e0){
            return createExceptionResult(e0, this);
        }
    }
    


}
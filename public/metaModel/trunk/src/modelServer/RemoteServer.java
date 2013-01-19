
package modelServer;



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

    public synchronized java.util.Hashtable<?,?> removeMessage(String mProxiString){
        try {
            PersistentMessage m = (PersistentMessage)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(mProxiString));
            ((PersistentServer)this.server).removeMessage(m);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> addConversion(String unitProxiString, String factorAsString, String constantAsString){
        try {
            PersistentUnit unit = (PersistentUnit)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(unitProxiString));
            common.Fraction factor = common.Fraction.parse(factorAsString);
            common.Fraction constant = common.Fraction.parse(constantAsString);
            ((PersistentServer)this.server).addConversion(unit, factor, constant);
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
    
    public synchronized java.util.Hashtable<?,?> createUnitType(String managerProxiString, String name){
        try {
            PersistentUnitTypeManager manager = (PersistentUnitTypeManager)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(managerProxiString));
            ((PersistentServer)this.server).createUnitType(manager, name);
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
    
    public synchronized java.util.Hashtable<?,?> createAtomicRootType(String aspectProxiString, String typeName, String singletonTypeProxiString, String abstractTypeProxiString){
        try {
            PersistentMAspect aspect = (PersistentMAspect)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(aspectProxiString));
            PersistentMBoolean singletonType = (PersistentMBoolean)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(singletonTypeProxiString));
            PersistentMBoolean abstractType = (PersistentMBoolean)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(abstractTypeProxiString));
            ((PersistentServer)this.server).createAtomicRootType(aspect, typeName, singletonType, abstractType);
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
    
    public synchronized java.util.Hashtable<?,?> createQuantity(String unitProxiString, String fAsString){
        try {
            PersistentAbsUnit unit = (PersistentAbsUnit)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(unitProxiString));
            common.Fraction f = common.Fraction.parse(fAsString);
            ((PersistentServer)this.server).createQuantity(unit, f);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> createStaticMessage(String managerProxiString, String typeProxiString, String name, String targetProxiString, java.util.Vector<String> apTrnsprt){
        try {
            PersistentMessageManager manager = (PersistentMessageManager)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(managerProxiString));
            PersistentOperation type = (PersistentOperation)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(typeProxiString));
            PersistentInstanceObject target = (PersistentInstanceObject)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(targetProxiString));
            ActualParameterSearchList ap = new ActualParameterSearchList();
			java.util.Iterator<String> apItrtr = apTrnsprt.iterator();
			while (apItrtr.hasNext()){
				PersistentActualParameter currentProxi = (PersistentActualParameter)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(apItrtr.next()));
				ap.add(currentProxi);
			}
            ((PersistentServer)this.server).createStaticMessage(manager, type, name, target, ap);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> createMessage(String managerProxiString, String typeProxiString, String sourceProxiString, String targetProxiString, java.util.Vector<String> apTrnsprt){
        try {
            PersistentMessageManager manager = (PersistentMessageManager)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(managerProxiString));
            PersistentOperation type = (PersistentOperation)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(typeProxiString));
            PersistentInstanceObject source = (PersistentInstanceObject)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(sourceProxiString));
            PersistentInstanceObject target = (PersistentInstanceObject)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(targetProxiString));
            ActualParameterSearchList ap = new ActualParameterSearchList();
			java.util.Iterator<String> apItrtr = apTrnsprt.iterator();
			while (apItrtr.hasNext()){
				PersistentActualParameter currentProxi = (PersistentActualParameter)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(apItrtr.next()));
				ap.add(currentProxi);
			}
            ((PersistentServer)this.server).createMessage(manager, type, source, target, ap);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
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
    
    public synchronized java.util.Hashtable<?,?> removeFp(String fpProxiString){
        try {
            PersistentFormalParameter fp = (PersistentFormalParameter)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(fpProxiString));
            ((PersistentServer)this.server).removeFp(fp);
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
    
    public synchronized java.util.Hashtable<?,?> createUnit(String typeProxiString, String name){
        try {
            PersistentUnitType type = (PersistentUnitType)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(typeProxiString));
            ((PersistentServer)this.server).createUnit(type, name);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> createVoidMessage(String sourceProxiString, String typeProxiString, java.util.Vector<String> apTrnsprt){
        try {
            PersistentInstanceObject source = (PersistentInstanceObject)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(sourceProxiString));
            PersistentOperation type = (PersistentOperation)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(typeProxiString));
            ActualParameterSearchList ap = new ActualParameterSearchList();
			java.util.Iterator<String> apItrtr = apTrnsprt.iterator();
			while (apItrtr.hasNext()){
				PersistentActualParameter currentProxi = (PersistentActualParameter)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(apItrtr.next()));
				ap.add(currentProxi);
			}
            ((PersistentServer)this.server).createVoidMessage(source, type, ap);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> createAtomicSubType(String superTypeProxiString, String typeName, String singletonTypeProxiString, String abstractTypeProxiString){
        try {
            PersistentMAtomicType superType = (PersistentMAtomicType)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(superTypeProxiString));
            PersistentMBoolean singletonType = (PersistentMBoolean)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(singletonTypeProxiString));
            PersistentMBoolean abstractType = (PersistentMBoolean)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(abstractTypeProxiString));
            ((PersistentServer)this.server).createAtomicSubType(superType, typeName, singletonType, abstractType);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
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
    
    public synchronized java.util.Hashtable<?,?> addDefaultUnit(String typeProxiString, String defaultUnitProxiString){
        try {
            PersistentUnitType type = (PersistentUnitType)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(typeProxiString));
            PersistentUnit defaultUnit = (PersistentUnit)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(defaultUnitProxiString));
            ((PersistentServer)this.server).addDefaultUnit(type, defaultUnit);
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
    
    public synchronized java.util.Hashtable<?,?> addReference(String compUnitProxiString, String unitProxiString, String exponentAsString){
        try {
            PersistentCompUnit compUnit = (PersistentCompUnit)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(compUnitProxiString));
            PersistentUnit unit = (PersistentUnit)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(unitProxiString));
            long exponent = new Long(exponentAsString).longValue();
            ((PersistentServer)this.server).addReference(compUnit, unit, exponent);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> createCompUnit(String compUnitTypeProxiString, String name){
        try {
            PersistentCompUnitType compUnitType = (PersistentCompUnitType)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(compUnitTypeProxiString));
            ((PersistentServer)this.server).createCompUnit(compUnitType, name);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> createMessage(String sourceProxiString, String typeProxiString, String targetProxiString, java.util.Vector<String> apTrnsprt){
        try {
            PersistentInstanceObject source = (PersistentInstanceObject)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(sourceProxiString));
            PersistentOperation type = (PersistentOperation)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(typeProxiString));
            PersistentInstanceObject target = (PersistentInstanceObject)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(targetProxiString));
            ActualParameterSearchList ap = new ActualParameterSearchList();
			java.util.Iterator<String> apItrtr = apTrnsprt.iterator();
			while (apItrtr.hasNext()){
				PersistentActualParameter currentProxi = (PersistentActualParameter)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(apItrtr.next()));
				ap.add(currentProxi);
			}
            ((PersistentServer)this.server).createMessage(source, type, target, ap);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> addReferenceType(String compUnitTypeProxiString, String unitTypeProxiString, String exponentAsString){
        try {
            PersistentCompUnitType compUnitType = (PersistentCompUnitType)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(compUnitTypeProxiString));
            PersistentUnitType unitType = (PersistentUnitType)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(unitTypeProxiString));
            long exponent = new Long(exponentAsString).longValue();
            ((PersistentServer)this.server).addReferenceType(compUnitType, unitType, exponent);
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
    
    public synchronized java.util.Hashtable<?,?> createLink(String sourceProxiString, String typeProxiString, String targetProxiString){
        try {
            PersistentInstanceObject source = (PersistentInstanceObject)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(sourceProxiString));
            PersistentAssociation type = (PersistentAssociation)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(typeProxiString));
            PersistentInstanceObject target = (PersistentInstanceObject)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(targetProxiString));
            ((PersistentServer)this.server).createLink(source, type, target);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> createCompUnitType(String name){
        try {
            ((PersistentServer)this.server).createCompUnitType(name);
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
    
    public synchronized java.util.Hashtable<?,?> createVoidMessage(String managerProxiString, String typeProxiString, String sourceProxiString, java.util.Vector<String> apTrnsprt){
        try {
            PersistentMessageManager manager = (PersistentMessageManager)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(managerProxiString));
            PersistentOperation type = (PersistentOperation)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(typeProxiString));
            PersistentInstanceObject source = (PersistentInstanceObject)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(sourceProxiString));
            ActualParameterSearchList ap = new ActualParameterSearchList();
			java.util.Iterator<String> apItrtr = apTrnsprt.iterator();
			while (apItrtr.hasNext()){
				PersistentActualParameter currentProxi = (PersistentActualParameter)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(apItrtr.next()));
				ap.add(currentProxi);
			}
            ((PersistentServer)this.server).createVoidMessage(manager, type, source, ap);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> createAccount(String accountManagerProxiString, String name, String typeProxiString, String objectProxiString){
        try {
            PersistentAccountManager accountManager = (PersistentAccountManager)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(accountManagerProxiString));
            PersistentMAccountType type = (PersistentMAccountType)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(typeProxiString));
            PersistentInstanceObject object = (PersistentInstanceObject)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(objectProxiString));
            ((PersistentServer)this.server).createAccount(accountManager, name, type, object);
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
    
    public synchronized java.util.Hashtable<?,?> removeLink(String linkProxiString){
        try {
            PersistentLink link = (PersistentLink)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(linkProxiString));
            ((PersistentServer)this.server).removeLink(link);
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
    
    public synchronized java.util.Hashtable<?,?> finishModeling(String compUnitTypeProxiString){
        try {
            PersistentCompUnitType compUnitType = (PersistentCompUnitType)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(compUnitTypeProxiString));
            ((PersistentServer)this.server).finishModeling(compUnitType);
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
    
    public synchronized java.util.Hashtable<?,?> createConst(String managerProxiString, String typeProxiString, String name, String targetProxiString){
        try {
            PersistentMessageManager manager = (PersistentMessageManager)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(managerProxiString));
            PersistentOperation type = (PersistentOperation)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(typeProxiString));
            PersistentInstanceObject target = (PersistentInstanceObject)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(targetProxiString));
            ((PersistentServer)this.server).createConst(manager, type, name, target);
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
    
    public synchronized java.util.Hashtable<?,?> createLink(String linkProxiString, String typeProxiString, String sourceProxiString, String targetProxiString){
        try {
            PersistentLinkManager link = (PersistentLinkManager)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(linkProxiString));
            PersistentAssociation type = (PersistentAssociation)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(typeProxiString));
            PersistentInstanceObject source = (PersistentInstanceObject)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(sourceProxiString));
            PersistentInstanceObject target = (PersistentInstanceObject)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(targetProxiString));
            ((PersistentServer)this.server).createLink(link, type, source, target);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    


}
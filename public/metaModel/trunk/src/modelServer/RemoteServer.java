
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

    public synchronized java.util.Hashtable<?,?> createAssociationFrom(String sourceProxiString, String name, String targetProxiString){
        try {
            PersistentMType source = (PersistentMType)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(sourceProxiString));
            PersistentMType target = (PersistentMType)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(targetProxiString));
            ((PersistentServer)this.server).createAssociationFrom(source, name, target);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> createAssociationTo(String targetProxiString, String name, String sourceProxiString){
        try {
            PersistentMType target = (PersistentMType)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(targetProxiString));
            PersistentMType source = (PersistentMType)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(sourceProxiString));
            ((PersistentServer)this.server).createAssociationTo(target, name, source);
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
    
    public synchronized java.util.Hashtable<?,?> createHierarchy(String name){
        try {
            ((PersistentServer)this.server).createHierarchy(name);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> createUnitType(String unitTypeManagerProxiString, String name){
        try {
            PersistentUnitTypeManager unitTypeManager = (PersistentUnitTypeManager)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(unitTypeManagerProxiString));
            ((PersistentServer)this.server).createUnitType(unitTypeManager, name);
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
    
    public synchronized java.util.Hashtable<?,?> createAssociation(String managerProxiString, String name, String sourceProxiString, String targetProxiString){
        try {
            PersistentAssociationManager manager = (PersistentAssociationManager)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(managerProxiString));
            PersistentMType source = (PersistentMType)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(sourceProxiString));
            PersistentMType target = (PersistentMType)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(targetProxiString));
            ((PersistentServer)this.server).createAssociation(manager, name, source, target);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> addToHierarchy(String associationProxiString, String theHierarchyProxiString){
        try {
            PersistentMAssociation association = (PersistentMAssociation)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(associationProxiString));
            PersistentMAHierarchy theHierarchy = (PersistentMAHierarchy)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(theHierarchyProxiString));
            ((PersistentServer)this.server).addToHierarchy(association, theHierarchy);
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
    
    public synchronized java.util.Hashtable<?,?> createCompUnitType(String unitTypeManagerProxiString, String name){
        try {
            PersistentUnitTypeManager unitTypeManager = (PersistentUnitTypeManager)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(unitTypeManagerProxiString));
            ((PersistentServer)this.server).createCompUnitType(unitTypeManager, name);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> addAssociations(String theHierarchyProxiString, String associationProxiString){
        try {
            PersistentMAHierarchy theHierarchy = (PersistentMAHierarchy)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(theHierarchyProxiString));
            PersistentMAssociation association = (PersistentMAssociation)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(associationProxiString));
            ((PersistentServer)this.server).addAssociations(theHierarchy, association);
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
    
    public synchronized java.util.Hashtable<?,?> createUnit(String typeProxiString, String name){
        try {
            PersistentAbsUnitType type = (PersistentAbsUnitType)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(typeProxiString));
            ((PersistentServer)this.server).createUnit(type, name);
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
    


}
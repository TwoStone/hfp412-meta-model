
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

    public synchronized java.util.Hashtable<?,?> addSubType(String superTypeProxiString, String subTypeProxiString){
        try {
            PersistentMAtomicType superType = (PersistentMAtomicType)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(superTypeProxiString));
            PersistentMAtomicType subType = (PersistentMAtomicType)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(subTypeProxiString));
            ((PersistentServer)this.server).addSubType(superType, subType);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> createAssociationFrom(String sourceProxiString, String name, String targetProxiString){
        try {
            MType source = (MType)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(sourceProxiString));
            MType target = (MType)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(targetProxiString));
            ((PersistentServer)this.server).createAssociationFrom(source, name, target);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> createAssociationTo(String targetProxiString, String name, String sourceProxiString){
        try {
            MType target = (MType)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(targetProxiString));
            MType source = (MType)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(sourceProxiString));
            ((PersistentServer)this.server).createAssociationTo(target, name, source);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> createAspect(String aspectManagerProxiString, String aspectName){
        try {
            PersistentAspectManager aspectManager = (PersistentAspectManager)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(aspectManagerProxiString));
            ((PersistentServer)this.server).createAspect(aspectManager, aspectName);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.DoubleDefinitionException e0){
            return createExceptionResult(e0, this);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> createAtomicType(String parentProxiString, String typeName, String singletonTypeProxiString, String abstractTypeProxiString){
        try {
            PersistentMAspect parent = (PersistentMAspect)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(parentProxiString));
            PersistentMBoolean singletonType = (PersistentMBoolean)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(singletonTypeProxiString));
            PersistentMBoolean abstractType = (PersistentMBoolean)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(abstractTypeProxiString));
            ((PersistentServer)this.server).createAtomicType(parent, typeName, singletonType, abstractType);
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
    
    public synchronized java.util.Hashtable<?,?> createAssociation(String managerProxiString, String name, String sourceProxiString, String targetProxiString){
        try {
            PersistentAssociationManager manager = (PersistentAssociationManager)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(managerProxiString));
            MType source = (MType)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(sourceProxiString));
            MType target = (MType)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(targetProxiString));
            ((PersistentServer)this.server).createAssociation(manager, name, source, target);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> createSubType(String superTypeProxiString, String typeName, String singletonTypeProxiString, String abstractTypeProxiString){
        try {
            PersistentMAtomicType superType = (PersistentMAtomicType)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(superTypeProxiString));
            PersistentMBoolean singletonType = (PersistentMBoolean)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(singletonTypeProxiString));
            PersistentMBoolean abstractType = (PersistentMBoolean)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(abstractTypeProxiString));
            ((PersistentServer)this.server).createSubType(superType, typeName, singletonType, abstractType);
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
    


}

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
    
    public synchronized java.util.Hashtable<?,?> createAtomicType(String parentProxiString, String typeName){
        try {
            PersistentMAspect parent = (PersistentMAspect)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(parentProxiString));
            ((PersistentServer)this.server).createAtomicType(parent, typeName);
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
    
    public synchronized java.util.Hashtable<?,?> createSubType(String superTypeProxiString, String typeName){
        try {
            PersistentMAtomicType superType = (PersistentMAtomicType)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(superTypeProxiString));
            ((PersistentServer)this.server).createSubType(superType, typeName);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    


}

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

    public synchronized java.util.Hashtable<?,?> addSubType(String superTypeProxiString, String typeunderProxiString){
        try {
            PersistentMAtomicType superType = (PersistentMAtomicType)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(superTypeProxiString));
            PersistentMAtomicType typeunder = (PersistentMAtomicType)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(typeunderProxiString));
            ((PersistentServer)this.server).addSubType(superType, typeunder);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> addAspect(String name){
        try {
            ((PersistentServer)this.server).addAspect(name);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }catch(model.DoubleDefinitionException e0){
            return createExceptionResult(e0, this);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> addAtomicType(String aspectProxiString, String name){
        try {
            PersistentMAspect aspect = (PersistentMAspect)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(aspectProxiString));
            ((PersistentServer)this.server).addAtomicType(aspect, name);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    


}
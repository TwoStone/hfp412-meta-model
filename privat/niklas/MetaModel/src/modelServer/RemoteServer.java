
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

    public synchronized java.util.Hashtable<?,?> createAspect(String name){
        try {
            ((PersistentServer)this.server).createAspect(name);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> createSumType(java.util.Vector<String> typesTrnsprt){
        try {
            AbstractMetaTypeSearchList types = new AbstractMetaTypeSearchList();
			java.util.Iterator<String> typesItrtr = typesTrnsprt.iterator();
			while (typesItrtr.hasNext()){
				PersistentAbstractMetaType currentProxi = (PersistentAbstractMetaType)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(typesItrtr.next()));
				types.add(currentProxi);
			}
            ((PersistentServer)this.server).createSumType(types);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> createType(String name, String aspectProxiString){
        try {
            PersistentMetaAspect aspect = (PersistentMetaAspect)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(aspectProxiString));
            ((PersistentServer)this.server).createType(name, aspect);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> addSupertype(String typeProxiString, String superTypeProxiString){
        try {
            PersistentMetaType type = (PersistentMetaType)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(typeProxiString));
            PersistentMetaType superType = (PersistentMetaType)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(superTypeProxiString));
            ((PersistentServer)this.server).addSupertype(type, superType);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    


}
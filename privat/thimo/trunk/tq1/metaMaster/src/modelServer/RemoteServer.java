
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

    public synchronized java.util.Hashtable<?,?> deleteErrors(){
        try {
            ((PersistentServer)this.server).deleteErrors();
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> changeName(String actorProxiString, String nme){
        try {
            PersistentActor actor = (PersistentActor)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(actorProxiString));
            ((PersistentServer)this.server).changeName(actor, nme);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> createActor(String name){
        try {
            ((PersistentServer)this.server).createActor(name);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> addRole(String actorProxiString, String roleName){
        try {
            PersistentActor actor = (PersistentActor)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(actorProxiString));
            ((PersistentServer)this.server).addRole(actor, roleName);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    


}
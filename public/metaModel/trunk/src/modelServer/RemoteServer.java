
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
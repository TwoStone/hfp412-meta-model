
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

    public synchronized java.util.Hashtable<?,?> changeName(String akteurProxiString, String nme){
        try {
            PersistentAkteur akteur = (PersistentAkteur)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(akteurProxiString));
            ((PersistentServer)this.server).changeName(akteur, nme);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> createAkteur(String name){
        try {
            ((PersistentServer)this.server).createAkteur(name);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> deleteErrors(){
        try {
            ((PersistentServer)this.server).deleteErrors();
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> addRole(String akteurProxiString, String rollenName){
        try {
            PersistentAkteur akteur = (PersistentAkteur)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(akteurProxiString));
            ((PersistentServer)this.server).addRole(akteur, rollenName);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    


}
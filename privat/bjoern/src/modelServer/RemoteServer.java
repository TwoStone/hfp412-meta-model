
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
    
    public synchronized java.util.Hashtable<?,?> createProdukt(String lieferantProxiString, String name){
        try {
            PersistentAkteur lieferant = (PersistentAkteur)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(lieferantProxiString));
            ((PersistentServer)this.server).createProdukt(lieferant, name);
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
    
    public synchronized java.util.Hashtable<?,?> addPosition(String auftragProxiString, String produktProxiString, String anzahlAsString){
        try {
            PersistentAuftrag auftrag = (PersistentAuftrag)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(auftragProxiString));
            PersistentProdukt produkt = (PersistentProdukt)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(produktProxiString));
            long anzahl = new Long(anzahlAsString).longValue();
            ((PersistentServer)this.server).addPosition(auftrag, produkt, anzahl);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> createAuftrag(String kundeProxiString, String lieferantProxiString, java.util.Vector<String> positionenTrnsprt){
        try {
            PersistentAkteur kunde = (PersistentAkteur)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(kundeProxiString));
            PersistentAkteur lieferant = (PersistentAkteur)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(lieferantProxiString));
            PositionSearchList positionen = new PositionSearchList();
			java.util.Iterator<String> positionenItrtr = positionenTrnsprt.iterator();
			while (positionenItrtr.hasNext()){
				PersistentPosition currentProxi = (PersistentPosition)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(positionenItrtr.next()));
				positionen.add(currentProxi);
			}
            ((PersistentServer)this.server).createAuftrag(kunde, lieferant, positionen);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
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
    


}
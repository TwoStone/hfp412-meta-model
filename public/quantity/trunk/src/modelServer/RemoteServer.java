
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

    public synchronized java.util.Hashtable<?,?> createUnit(String name, String typeProxiString){
        try {
            PersistentUnitType type = (PersistentUnitType)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(typeProxiString));
            ((PersistentServer)this.server).createUnit(name, type);
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
    
    public synchronized java.util.Hashtable<?,?> createCompUnit(String name, String typeProxiString){
        try {
            PersistentCompUnitType type = (PersistentCompUnitType)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(typeProxiString));
            ((PersistentServer)this.server).createCompUnit(name, type);
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
    
    public synchronized java.util.Hashtable<?,?> createQuantity(String fAsString, String unitProxiString){
        try {
            common.Fraction f = common.Fraction.parse(fAsString);
            PersistentAbsUnit unit = (PersistentAbsUnit)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(unitProxiString));
            ((PersistentServer)this.server).createQuantity(f, unit);
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
    
    public synchronized java.util.Hashtable<?,?> createUnitType(String name){
        try {
            ((PersistentServer)this.server).createUnitType(name);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    


}

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
    
    public synchronized java.util.Hashtable<?,?> createUnitType(String unitTypeManagerProxiString, String name){
        try {
            PersistentUnitTypeManager unitTypeManager = (PersistentUnitTypeManager)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(unitTypeManagerProxiString));
            ((PersistentServer)this.server).createUnitType(unitTypeManager, name);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    


}
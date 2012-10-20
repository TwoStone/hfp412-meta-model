
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

    public synchronized java.util.Hashtable<?,?> addPosition(String orderProxiString, String productProxiString, String quanitityAsString){
        try {
            PersistentOrder order = (PersistentOrder)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(orderProxiString));
            PersistentProduct product = (PersistentProduct)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(productProxiString));
            long quanitity = new Long(quanitityAsString).longValue();
            ((PersistentServer)this.server).addPosition(order, product, quanitity);
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
    
    public synchronized java.util.Hashtable<?,?> changeName(String actorProxiString, String name){
        try {
            PersistentActor actor = (PersistentActor)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(actorProxiString));
            ((PersistentServer)this.server).changeName(actor, name);
            return createOKResult();
        }catch(PersistenceException pe){
            return createExceptionResult(pe);
        }
    }
    
    public synchronized java.util.Hashtable<?,?> createProduct(String manufacturerProxiString, String name){
        try {
            PersistentSupplier manufacturer = (PersistentSupplier)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(manufacturerProxiString));
            ((PersistentServer)this.server).createProduct(manufacturer, name);
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
    
    public synchronized java.util.Hashtable<?,?> createOrder(String customerProxiString, String supplierProxiString){
        try {
            PersistentCustomer customer = (PersistentCustomer)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(customerProxiString));
            PersistentSupplier supplier = (PersistentSupplier)PersistentProxi.createProxi(common.RPCConstantsAndServices.createProxiInformation(supplierProxiString));
            ((PersistentServer)this.server).createOrder(customer, supplier);
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

package model;

import persistence.*;


/* Additional import section end */

public class Product extends PersistentObject implements PersistentProduct{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentProduct getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theProductFacade.getClass(objectId);
        return (PersistentProduct)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static PersistentProduct createProduct(String name) throws PersistenceException {
        if (name == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        PersistentProduct result = ConnectionHandler.getTheConnectionHandler().theProductFacade
            .newProduct(name);
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        final$$Fields.put("name", name);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentProduct createProduct(String name,PersistentProduct This) throws PersistenceException {
        if (name == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        PersistentProduct result = ConnectionHandler.getTheConnectionHandler().theProductFacade
            .newProduct(name);
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        final$$Fields.put("name", name);
        result.initialize(This, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public java.util.Hashtable<String,Object> toHashtable(java.util.Hashtable<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.Hashtable<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            result.put("name", this.getName());
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.contains(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public static ProductSearchList getProductByName(String index) throws PersistenceException{
        return ConnectionHandler.getTheConnectionHandler().theProductFacade
            .getProductByName(index);
    }
    
    public Product provideCopy() throws PersistenceException{
        Product result = this;
        result = new Product(this.name, 
                             this.This, 
                             this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected String name;
    protected PersistentProduct This;
    
    public Product(String name,PersistentProduct This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.name = name;
        if (This != null && !(this.equals(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 126;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public String getName() throws PersistenceException {
        return this.name;
    }
    public void setName(String newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null not allowed for persistent strings, since null = \"\" in Oracle!", 0);
        ConnectionHandler.getTheConnectionHandler().theProductFacade.nameSet(this.getId(), newValue);
        this.name = newValue;
    }
    protected void setThis(PersistentProduct newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.equals(this)){
            this.This = null;
            return;
        }
        if(newValue.equals(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentProduct)PersistentProxi.createProxi(objectId, classId);
        ConnectionHandler.getTheConnectionHandler().theProductFacade.ThisSet(this.getId(), newValue);
    }
    public PersistentProduct getThis() throws PersistenceException {
        if(this.This == null){
            PersistentProduct result = new ProductProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentProduct)this.This;
    }
    
    public void accept(model.visitor.AnythingVisitor visitor) throws PersistenceException {
        visitor.handleProduct(this);
    }
    public <R> R accept(model.visitor.AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleProduct(this);
    }
    public <E extends model.UserException>  void accept(model.visitor.AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleProduct(this);
    }
    public <R, E extends model.UserException> R accept(model.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleProduct(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return 0;
    }
    
    
    public void initializeOnInstantiation() 
				throws PersistenceException{
        //TODO: implement method: initializeOnInstantiation
        
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        //TODO: implement method: copyingPrivateUserAttributes
        
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentProduct)This);
		if(this.equals(This)){
			this.setName((String)final$$Fields.get("name"));
		}
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        //TODO: implement method: initializeOnCreation
        
    }

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}
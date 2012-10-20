
package model;

import persistence.*;


/* Additional import section end */

public class Position extends PersistentObject implements PersistentPosition{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentPosition getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().thePositionFacade.getClass(objectId);
        return (PersistentPosition)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static PersistentPosition createPosition(PersistentProduct product,long quantity) throws PersistenceException {
        PersistentPosition result = ConnectionHandler.getTheConnectionHandler().thePositionFacade
            .newPosition(quantity);
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        final$$Fields.put("product", product);
        final$$Fields.put("quantity", quantity);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentPosition createPosition(PersistentProduct product,long quantity,PersistentPosition This) throws PersistenceException {
        PersistentPosition result = ConnectionHandler.getTheConnectionHandler().thePositionFacade
            .newPosition(quantity);
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        final$$Fields.put("product", product);
        final$$Fields.put("quantity", quantity);
        result.initialize(This, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public java.util.Hashtable<String,Object> toHashtable(java.util.Hashtable<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.Hashtable<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            AbstractPersistentRoot product = (AbstractPersistentRoot)this.getProduct();
            if (product != null) {
                result.put("product", product.createProxiInformation());
                if(depth > 1) {
                    product.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && product.hasEssentialFields())product.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            result.put("quantity", new Long(this.getQuantity()).toString());
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.contains(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public Position provideCopy() throws PersistenceException{
        Position result = this;
        result = new Position(this.product, 
                              this.quantity, 
                              this.This, 
                              this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected PersistentProduct product;
    protected long quantity;
    protected PersistentPosition This;
    
    public Position(PersistentProduct product,long quantity,PersistentPosition This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.product = product;
        this.quantity = quantity;
        if (This != null && !(this.equals(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 115;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public PersistentProduct getProduct() throws PersistenceException {
        return this.product;
    }
    public void setProduct(PersistentProduct newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.product)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.product = (PersistentProduct)PersistentProxi.createProxi(objectId, classId);
        ConnectionHandler.getTheConnectionHandler().thePositionFacade.productSet(this.getId(), newValue);
    }
    public long getQuantity() throws PersistenceException {
        return this.quantity;
    }
    public void setQuantity(long newValue) throws PersistenceException {
        ConnectionHandler.getTheConnectionHandler().thePositionFacade.quantitySet(this.getId(), newValue);
        this.quantity = newValue;
    }
    protected void setThis(PersistentPosition newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.equals(this)){
            this.This = null;
            return;
        }
        if(newValue.equals(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentPosition)PersistentProxi.createProxi(objectId, classId);
        ConnectionHandler.getTheConnectionHandler().thePositionFacade.ThisSet(this.getId(), newValue);
    }
    public PersistentPosition getThis() throws PersistenceException {
        if(this.This == null){
            PersistentPosition result = new PositionProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentPosition)this.This;
    }
    
    public void accept(model.visitor.AnythingVisitor visitor) throws PersistenceException {
        visitor.handlePosition(this);
    }
    public <R> R accept(model.visitor.AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handlePosition(this);
    }
    public <E extends model.UserException>  void accept(model.visitor.AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handlePosition(this);
    }
    public <R, E extends model.UserException> R accept(model.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handlePosition(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return (int) (0 
            + (this.getProduct() == null ? 0 : 1));
    }
    
    
    public void initializeOnInstantiation() 
				throws PersistenceException{
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{        
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentPosition)This);
		if(this.equals(This)){
			this.setProduct((PersistentProduct)final$$Fields.get("product"));
			this.setQuantity((Long)final$$Fields.get("quantity"));
		}
    }
    public void initializeOnCreation() 
				throws PersistenceException{
    }

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}

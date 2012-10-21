
package model;

import persistence.*;


/* Additional import section end */

public class OrderItem extends PersistentObject implements PersistentOrderItem{
    
    /** Throws persistence exception if the object with the given id does not exist. */
    public static PersistentOrderItem getById(long objectId) throws PersistenceException{
        long classId = ConnectionHandler.getTheConnectionHandler().theOrderItemFacade.getClass(objectId);
        return (PersistentOrderItem)PersistentProxi.createProxi(objectId, classId);
    }
    
    public static PersistentOrderItem createOrderItem(long quantity,PersistentProduct product) throws PersistenceException {
        PersistentOrderItem result = ConnectionHandler.getTheConnectionHandler().theOrderItemFacade
            .newOrderItem(quantity);
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        final$$Fields.put("quantity", quantity);
        final$$Fields.put("product", product);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        if(result.getThis().getProduct() == null)throw new PersistenceException("Field product in type OrderItem has not been initialized!",0);
        return result;
    }
    
    public static PersistentOrderItem createOrderItem(long quantity,PersistentProduct product,PersistentOrderItem This) throws PersistenceException {
        PersistentOrderItem result = ConnectionHandler.getTheConnectionHandler().theOrderItemFacade
            .newOrderItem(quantity);
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        final$$Fields.put("quantity", quantity);
        final$$Fields.put("product", product);
        result.initialize(This, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public java.util.Hashtable<String,Object> toHashtable(java.util.Hashtable<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.Hashtable<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            result.put("quantity", new Long(this.getQuantity()).toString());
            AbstractPersistentRoot product = (AbstractPersistentRoot)this.getProduct();
            if (product != null) {
                result.put("product", product.createProxiInformation());
                if(depth > 1) {
                    product.toHashtable(allResults, depth - 1, essentialLevel, forGUI, true , tdObserver);
                }else{
                    if(forGUI && product.hasEssentialFields())product.toHashtable(allResults, depth, essentialLevel + 1, false, true, tdObserver);
                }
            }
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.contains(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public OrderItem provideCopy() throws PersistenceException{
        OrderItem result = this;
        result = new OrderItem(this.quantity, 
                               this.product, 
                               this.This, 
                               this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected long quantity;
    protected PersistentProduct product;
    protected PersistentOrderItem This;
    
    public OrderItem(long quantity,PersistentProduct product,PersistentOrderItem This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super(id);
        this.quantity = quantity;
        this.product = product;
        if (This != null && !(this.equals(This))) this.This = This;        
    }
    
    static public long getTypeId() {
        return 112;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public long getQuantity() throws PersistenceException {
        return this.quantity;
    }
    public void setQuantity(long newValue) throws PersistenceException {
        ConnectionHandler.getTheConnectionHandler().theOrderItemFacade.quantitySet(this.getId(), newValue);
        this.quantity = newValue;
    }
    public PersistentProduct getProduct() throws PersistenceException {
        return this.product;
    }
    public void setProduct(PersistentProduct newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if(newValue.equals(this.product)) return;
        if(getThis().getProduct() != null)throw new PersistenceException("Final field product in type OrderItem has been set already!",0);
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.product = (PersistentProduct)PersistentProxi.createProxi(objectId, classId);
        ConnectionHandler.getTheConnectionHandler().theOrderItemFacade.productSet(this.getId(), newValue);
    }
    protected void setThis(PersistentOrderItem newValue) throws PersistenceException {
        if (newValue == null) throw new PersistenceException("Null values not allowed!", 0);
        if (newValue.equals(this)){
            this.This = null;
            return;
        }
        if(newValue.equals(this.This)) return;
        long objectId = newValue.getId();
        long classId = newValue.getClassId();
        this.This = (PersistentOrderItem)PersistentProxi.createProxi(objectId, classId);
        ConnectionHandler.getTheConnectionHandler().theOrderItemFacade.ThisSet(this.getId(), newValue);
    }
    public PersistentOrderItem getThis() throws PersistenceException {
        if(this.This == null){
            PersistentOrderItem result = new OrderItemProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentOrderItem)this.This;
    }
    
    public void accept(model.visitor.AnythingVisitor visitor) throws PersistenceException {
        visitor.handleOrderItem(this);
    }
    public <R> R accept(model.visitor.AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleOrderItem(this);
    }
    public <E extends model.UserException>  void accept(model.visitor.AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleOrderItem(this);
    }
    public <R, E extends model.UserException> R accept(model.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleOrderItem(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return (int) (0 
            + (this.getProduct() == null ? 0 : 1));
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
        this.setThis((PersistentOrderItem)This);
		if(this.equals(This)){
			this.setQuantity((Long)final$$Fields.get("quantity"));
			this.setProduct((PersistentProduct)final$$Fields.get("product"));
		}
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        //TODO: implement method: initializeOnCreation
        
    }

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}

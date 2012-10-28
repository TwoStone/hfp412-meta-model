
package model;

import persistence.*;


/* Additional import section end */

public class ComposedQuantity extends model.AbsQuantity implements PersistentComposedQuantity{
    
    
    public static PersistentComposedQuantity createComposedQuantity() throws PersistenceException {
        PersistentComposedQuantity result = ConnectionHandler.getTheConnectionHandler().theComposedQuantityFacade
            .newComposedQuantity();
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentComposedQuantity createComposedQuantity(PersistentComposedQuantity This) throws PersistenceException {
        PersistentComposedQuantity result = ConnectionHandler.getTheConnectionHandler().theComposedQuantityFacade
            .newComposedQuantity();
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        result.initialize(This, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public java.util.Hashtable<String,Object> toHashtable(java.util.Hashtable<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.Hashtable<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            result.put("parts", this.getParts().getVector(allResults, depth, essentialLevel, forGUI, tdObserver));
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.contains(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public ComposedQuantity provideCopy() throws PersistenceException{
        ComposedQuantity result = this;
        result = new ComposedQuantity(this.This, 
                                      this.getId());
        result.parts = this.parts.copy(result);
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected ComposedQuantity_PartsProxi parts;
    
    public ComposedQuantity(PersistentAbsQuantity This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((PersistentAbsQuantity)This,id);
        this.parts = new ComposedQuantity_PartsProxi(this);        
    }
    
    static public long getTypeId() {
        return 123;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public ComposedQuantity_PartsProxi getParts() throws PersistenceException {
        return this.parts;
    }
    public PersistentComposedQuantity getThis() throws PersistenceException {
        if(this.This == null){
            PersistentComposedQuantity result = new ComposedQuantityProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentComposedQuantity)this.This;
    }
    
    public void accept(model.visitor.AbsQuantityVisitor visitor) throws PersistenceException {
        visitor.handleComposedQuantity(this);
    }
    public <R> R accept(model.visitor.AbsQuantityReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleComposedQuantity(this);
    }
    public <E extends model.UserException>  void accept(model.visitor.AbsQuantityExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleComposedQuantity(this);
    }
    public <R, E extends model.UserException> R accept(model.visitor.AbsQuantityReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleComposedQuantity(this);
    }
    public void accept(model.visitor.AnythingVisitor visitor) throws PersistenceException {
        visitor.handleComposedQuantity(this);
    }
    public <R> R accept(model.visitor.AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleComposedQuantity(this);
    }
    public <E extends model.UserException>  void accept(model.visitor.AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleComposedQuantity(this);
    }
    public <R, E extends model.UserException> R accept(model.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleComposedQuantity(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return (int) (0 
            + this.getParts().getLength());
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
        this.setThis((PersistentComposedQuantity)This);
		if(this.equals(This)){
		}
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        //TODO: implement method: initializeOnCreation
        
    }

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}


package model;

import persistence.*;


/* Additional import section end */

public class Supplier extends model.Role implements PersistentSupplier{
    
    
    public static PersistentSupplier createSupplier(PersistentActor owner) throws PersistenceException {
        PersistentSupplier result = ConnectionHandler.getTheConnectionHandler().theSupplierFacade
            .newSupplier();
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        final$$Fields.put("owner", owner);
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentSupplier createSupplier(PersistentActor owner,PersistentSupplier This) throws PersistenceException {
        PersistentSupplier result = ConnectionHandler.getTheConnectionHandler().theSupplierFacade
            .newSupplier();
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        final$$Fields.put("owner", owner);
        result.initialize(This, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public java.util.Hashtable<String,Object> toHashtable(java.util.Hashtable<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.Hashtable<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            result.put("portfolio", this.getPortfolio().getVector(allResults, depth, essentialLevel, forGUI, tdObserver));
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.contains(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public Supplier provideCopy() throws PersistenceException{
        Supplier result = this;
        result = new Supplier(this.owner, 
                              this.This, 
                              this.getId());
        result.portfolio = this.portfolio.copy(result);
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    protected Supplier_PortfolioProxi portfolio;
    
    public Supplier(PersistentActor owner,PersistentRole This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((PersistentActor)owner,(PersistentRole)This,id);
        this.portfolio = new Supplier_PortfolioProxi(this);        
    }
    
    static public long getTypeId() {
        return 113;
    }
    
    public long getClassId() {
        return getTypeId();
    }
    
    public Supplier_PortfolioProxi getPortfolio() throws PersistenceException {
        return this.portfolio;
    }
    public PersistentSupplier getThis() throws PersistenceException {
        if(this.This == null){
            PersistentSupplier result = new SupplierProxi(this.getId());
            result.getTheObject();
            return result;
        }return (PersistentSupplier)this.This;
    }
    
    public void accept(model.visitor.RoleVisitor visitor) throws PersistenceException {
        visitor.handleSupplier(this);
    }
    public <R> R accept(model.visitor.RoleReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleSupplier(this);
    }
    public <E extends model.UserException>  void accept(model.visitor.RoleExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleSupplier(this);
    }
    public <R, E extends model.UserException> R accept(model.visitor.RoleReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleSupplier(this);
    }
    public void accept(model.visitor.AnythingVisitor visitor) throws PersistenceException {
        visitor.handleSupplier(this);
    }
    public <R> R accept(model.visitor.AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleSupplier(this);
    }
    public <E extends model.UserException>  void accept(model.visitor.AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleSupplier(this);
    }
    public <R, E extends model.UserException> R accept(model.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleSupplier(this);
    }
    public int getLeafInfo() throws PersistenceException{
        return (int) (0 
            + this.getPortfolio().getLength());
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
        this.setThis((PersistentSupplier)This);
		if(this.equals(This)){
			this.setOwner((PersistentActor)final$$Fields.get("owner"));
		}
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        //TODO: implement method: initializeOnCreation
        
    }

    /* Start of protected part that is not overridden by persistence generator */
    
    /* End of protected part that is not overridden by persistence generator */
    
}

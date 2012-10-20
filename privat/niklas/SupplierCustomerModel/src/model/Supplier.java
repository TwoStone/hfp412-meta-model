
package model;

import persistence.*;


/* Additional import section end */

public class Supplier extends model.Role implements PersistentSupplier{
    
    
    public static PersistentSupplier createSupplier() throws PersistenceException {
        PersistentSupplier result = ConnectionHandler.getTheConnectionHandler().theSupplierFacade
            .newSupplier();
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        result.initialize(result, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public static PersistentSupplier createSupplier(PersistentSupplier This) throws PersistenceException {
        PersistentSupplier result = ConnectionHandler.getTheConnectionHandler().theSupplierFacade
            .newSupplier();
        java.util.Hashtable<String,Object> final$$Fields = new java.util.Hashtable<String,Object>();
        result.initialize(This, final$$Fields);
        result.initializeOnCreation();
        return result;
    }
    
    public java.util.Hashtable<String,Object> toHashtable(java.util.Hashtable<String,Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, TDObserver tdObserver) throws PersistenceException {
    java.util.Hashtable<String,Object> result = null;
        if (depth > 0 && essentialLevel <= common.RPCConstantsAndServices.EssentialDepth){
            result = super.toHashtable(allResults, depth, essentialLevel, forGUI, false, tdObserver);
            result.put("products", this.getProducts(tdObserver).getVector(allResults, (depth > 1 ? depth : depth + 1), essentialLevel, forGUI, tdObserver));
            String uniqueKey = common.RPCConstantsAndServices.createHashtableKey(this.getClassId(), this.getId());
            if (leaf && !allResults.contains(uniqueKey)) allResults.put(uniqueKey, result);
        }
        return result;
    }
    
    public Supplier provideCopy() throws PersistenceException{
        Supplier result = this;
        result = new Supplier(this.This, 
                              this.getId());
        this.copyingPrivateUserAttributes(result);
        return result;
    }
    
    public boolean hasEssentialFields() throws PersistenceException{
        return false;
    }
    
    public Supplier(PersistentRole This,long id) throws persistence.PersistenceException {
        /* Shall not be used by clients for object construction! Use static create operation instead! */
        super((PersistentRole)This,id);        
    }
    
    static public long getTypeId() {
        return 110;
    }
    
    public long getClassId() {
        return getTypeId();
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
            + this.getProducts().getLength());
    }
    
    
    public ProductSearchList getProducts() 
				throws PersistenceException{
		return this.getThis().inverseGetProducer();
	}
    public void initializeOnInstantiation() 
				throws PersistenceException{
	}
    public ProductSearchList getProducts(final TDObserver observer) 
				throws PersistenceException{
        ProductSearchList result = getThis().getProducts();
		observer.updateTransientDerived(getThis(), "products", result);
		return result;
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
		//TODO: implement method: copyingPrivateUserAttributes

	}
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        this.setThis((PersistentSupplier)This);
		if(this.equals(This)){
		}
    }
    public void initializeOnCreation() 
				throws PersistenceException{
	}
    public void createProduct(final String name) 
				throws model.DoubleDefinition, PersistenceException{
		SearchListRoot<PersistentProduct> all = this.getProducts().findAll(new Predcate<PersistentProduct>() {

			@Override
			public boolean test(final PersistentProduct argument) throws PersistenceException {
				return argument.getName().equals(name);
			}
		});
		if (all.iterator().hasNext()) {
			throw new DoubleDefinition(name);
		}
		Product.createProduct(name, this.getThis());
	}
    public ProductSearchList inverseGetProducer() 
				throws PersistenceException{
        ProductSearchList result = null;
		if (result == null) result = ConnectionHandler.getTheConnectionHandler().theProductFacade
							.inverseGetProducer(this.getId(), this.getClassId());
		return result;
    }

    /* Start of protected part that is not overridden by persistence generator */

	/* End of protected part that is not overridden by persistence generator */
    
}

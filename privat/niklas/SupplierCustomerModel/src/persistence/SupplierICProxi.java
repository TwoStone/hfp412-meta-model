package persistence;

import model.*;

public class SupplierICProxi extends RoleICProxi implements PersistentSupplier{
    
    public SupplierICProxi(long objectId) {
        super(objectId);
    }
    public SupplierICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theSupplierFacade
            .getSupplier(this.getId());
    }
    
    public long getClassId() {
        return 110;
    }
    
    public PersistentSupplier getThis() throws PersistenceException {
        return ((PersistentSupplier)this.getTheObject()).getThis();
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
    
    
    public ProductSearchList getProducts() 
				throws PersistenceException{
        return ((PersistentSupplier)this.getTheObject()).getProducts();
    }
    public ProductSearchList getProducts(final TDObserver observer) 
				throws PersistenceException{
        return ((PersistentSupplier)this.getTheObject()).getProducts(observer);
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentSupplier)this.getTheObject()).initializeOnInstantiation();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentSupplier)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentSupplier)this.getTheObject()).initialize(This, final$$Fields);
    }
    public ActorSearchList inverseGetRoles() 
				throws PersistenceException{
        return ((PersistentSupplier)this.getTheObject()).inverseGetRoles();
    }
    public void createProduct(final String name) 
				throws model.DoubleDefinition, PersistenceException{
        ((PersistentSupplier)this.getTheObject()).createProduct(name);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentSupplier)this.getTheObject()).initializeOnCreation();
    }
    public ProductSearchList inverseGetProducer() 
				throws PersistenceException{
        return ((PersistentSupplier)this.getTheObject()).inverseGetProducer();
    }

    
}

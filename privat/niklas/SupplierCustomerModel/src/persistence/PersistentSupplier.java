package persistence;

import model.*;
public interface PersistentSupplier extends PersistentRole {
    
    public PersistentSupplier getThis() throws PersistenceException ;
    
    public void accept(model.visitor.RoleVisitor visitor) throws PersistenceException;
    public <R> R accept(model.visitor.RoleReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(model.visitor.RoleExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(model.visitor.RoleReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(model.visitor.AnythingVisitor visitor) throws PersistenceException;
    public <R> R accept(model.visitor.AnythingReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends model.UserException>  void accept(model.visitor.AnythingExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends model.UserException> R accept(model.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public ProductSearchList getProducts() 
				throws PersistenceException;
    public ProductSearchList getProducts(final TDObserver observer) 
				throws PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public void createProduct(final String name) 
				throws model.DoubleDefinition, PersistenceException;
    public ProductSearchList inverseGetProducer() 
				throws PersistenceException;

}


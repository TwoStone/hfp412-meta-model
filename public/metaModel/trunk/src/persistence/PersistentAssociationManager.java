package persistence;

import model.UserException;

import model.visitor.*;

public interface PersistentAssociationManager extends Anything, AbstractPersistentProxi {
    
    public AssociationManager_AssociationsProxi getAssociations() throws PersistenceException ;
    public AssociationManager_HierarchiesProxi getHierarchies() throws PersistenceException ;
    public PersistentAssociationManager getThis() throws PersistenceException ;
    
    public void accept(AnythingVisitor visitor) throws PersistenceException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public void initializeOnInstantiation() 
				throws PersistenceException;
    public void createAssociation(final PersistentMType source, final PersistentMType target, final String name) 
				throws model.DoubleDefinitionException, PersistenceException;
    public void addAssociation(final PersistentHierarchy h, final PersistentAssociation a, final Invoker invoker) 
				throws PersistenceException;
    public void addAssociation(final PersistentHierarchy h, final PersistentAssociation a) 
				throws model.DoubleDefinitionException, model.CycleException, PersistenceException;
    public void removeAssoFrmHier(final PersistentHierarchy h, final PersistentAssociation a) 
				throws model.NotAvailableException, model.CycleException, PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public void removeAssoFrmHier(final PersistentHierarchy h, final PersistentAssociation a, final Invoker invoker) 
				throws PersistenceException;
    public void removeAssociation(final PersistentAssociation a) 
				throws model.ConsistencyException, model.CycleException, PersistenceException;
    public void createAssociation(final PersistentMType source, final PersistentMType target, final String name, final Invoker invoker) 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public void createHierarchy(final PersistentAssociation a, final String name, final Invoker invoker) 
				throws PersistenceException;
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException;
    public void removeAssociation(final PersistentAssociation a, final Invoker invoker) 
				throws PersistenceException;
    public void createHierarchy(final PersistentAssociation a, final String name) 
				throws model.DoubleDefinitionException, PersistenceException;

}


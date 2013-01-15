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
    
    public void addToHierarchy(final PersistentMAssociation association, final PersistentMAHierarchy theHierarchy) 
				throws PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public void createHierarchy(final String name, final Invoker invoker) 
				throws PersistenceException;
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException;
    public void addToHierarchy(final PersistentMAssociation association, final PersistentMAHierarchy theHierarchy, final Invoker invoker) 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public void createAssociation(final String name, final PersistentMType source, final PersistentMType target, final Invoker invoker) 
				throws PersistenceException;
    public void createAssociation(final String name, final PersistentMType source, final PersistentMType target) 
				throws model.DoubleDefinitionException, PersistenceException;
    public void createHierarchy(final String name) 
				throws model.DoubleDefinitionException, PersistenceException;

}


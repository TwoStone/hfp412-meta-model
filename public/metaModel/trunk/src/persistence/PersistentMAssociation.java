package persistence;

import model.UserException;

import model.visitor.*;

public interface PersistentMAssociation extends Anything, AbstractPersistentProxi {
    
    public String getName() throws PersistenceException ;
    public void setName(String newValue) throws PersistenceException ;
    public MType getSource() throws PersistenceException ;
    public void setSource(MType newValue) throws PersistenceException ;
    public MType getTarget() throws PersistenceException ;
    public void setTarget(MType newValue) throws PersistenceException ;
    public MAssociation_HierarchiesProxi getHierarchies() throws PersistenceException ;
    public PersistentMAssociation getThis() throws PersistenceException ;
    
    public void accept(AnythingVisitor visitor) throws PersistenceException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public void initializeOnInstantiation() 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException;
    public PersistentMBoolean isObservation() 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;

}


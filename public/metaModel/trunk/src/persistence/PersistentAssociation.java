package persistence;

import model.UserException;

import model.visitor.*;

public interface PersistentAssociation extends Anything, AbstractPersistentProxi {
    
    public String getName() throws PersistenceException ;
    public void setName(String newValue) throws PersistenceException ;
    public PersistentMType getSource() throws PersistenceException ;
    public void setSource(PersistentMType newValue) throws PersistenceException ;
    public PersistentMType getTarget() throws PersistenceException ;
    public void setTarget(PersistentMType newValue) throws PersistenceException ;
    public Association_HierarchiesProxi getHierarchies() throws PersistenceException ;
    public PersistentAssociation getThis() throws PersistenceException ;
    
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


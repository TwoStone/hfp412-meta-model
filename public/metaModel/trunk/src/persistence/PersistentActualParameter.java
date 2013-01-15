package persistence;

import model.UserException;

import model.visitor.*;

public interface PersistentActualParameter extends Anything, AbstractPersistentProxi {
    
    public PersistentMFormalParameter getType() throws PersistenceException ;
    public void setType(PersistentMFormalParameter newValue) throws PersistenceException ;
    public PersistentInstanceObject getValue() throws PersistenceException ;
    public void setValue(PersistentInstanceObject newValue) throws PersistenceException ;
    public PersistentActualParameter getThis() throws PersistenceException ;
    
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
    public void initializeOnCreation() 
				throws PersistenceException;

}


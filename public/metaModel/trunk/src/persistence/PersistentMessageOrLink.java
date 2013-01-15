package persistence;

import model.UserException;

import model.visitor.*;

public interface PersistentMessageOrLink extends Anything, AbstractPersistentProxi {
    
    public PersistentInstanceObject getSource() throws PersistenceException ;
    public void setSource(PersistentInstanceObject newValue) throws PersistenceException ;
    public PersistentInstanceObject getTarget() throws PersistenceException ;
    public void setTarget(PersistentInstanceObject newValue) throws PersistenceException ;
    public abstract PersistentMessageOrLink getThis() throws PersistenceException ;
    
    public void accept(MessageOrLinkVisitor visitor) throws PersistenceException;
    public <R> R accept(MessageOrLinkReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(MessageOrLinkExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(MessageOrLinkReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public void initializeOnInstantiation() 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;

}


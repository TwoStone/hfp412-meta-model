package persistence;

import model.UserException;

import model.visitor.*;

public interface PersistentMessage extends PersistentMessageOrLink {
    
    public PersistentOperation getType() throws PersistenceException ;
    public void setType(PersistentOperation newValue) throws PersistenceException ;
    public Message_ActualParametersProxi getActualParameters() throws PersistenceException ;
    public PersistentMessage getThis() throws PersistenceException ;
    
    public void accept(MessageOrLinkVisitor visitor) throws PersistenceException;
    public <R> R accept(MessageOrLinkReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(MessageOrLinkExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(MessageOrLinkReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
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

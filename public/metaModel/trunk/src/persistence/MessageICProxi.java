package persistence;

import model.UserException;

import model.visitor.*;

public class MessageICProxi extends MessageOrLinkICProxi implements PersistentMessage{
    
    public MessageICProxi(long objectId) {
        super(objectId);
    }
    public MessageICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theMessageFacade
            .getMessage(this.getId());
    }
    
    public long getClassId() {
        return 205;
    }
    
    public PersistentOperation getType() throws PersistenceException {
        return ((PersistentMessage)this.getTheObject()).getType();
    }
    public void setType(PersistentOperation newValue) throws PersistenceException {
        ((PersistentMessage)this.getTheObject()).setType(newValue);
    }
    public Message_ActualParametersProxi getActualParameters() throws PersistenceException {
        return ((PersistentMessage)this.getTheObject()).getActualParameters();
    }
    public PersistentMessage getThis() throws PersistenceException {
        return ((PersistentMessage)this.getTheObject()).getThis();
    }
    
    public void accept(MessageOrLinkVisitor visitor) throws PersistenceException {
        visitor.handleMessage(this);
    }
    public <R> R accept(MessageOrLinkReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMessage(this);
    }
    public <E extends UserException>  void accept(MessageOrLinkExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMessage(this);
    }
    public <R, E extends UserException> R accept(MessageOrLinkReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMessage(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleMessage(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMessage(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMessage(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMessage(this);
    }
    
    
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentMessage)this.getTheObject()).initializeOnInstantiation();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentMessage)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentMessage)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentMessage)this.getTheObject()).initializeOnCreation();
    }

    
}

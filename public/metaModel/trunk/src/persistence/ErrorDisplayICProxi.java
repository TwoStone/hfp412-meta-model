package persistence;

import model.UserException;

import model.visitor.*;

public class ErrorDisplayICProxi extends PersistentInCacheProxiOptimistic implements PersistentErrorDisplay{
    
    public ErrorDisplayICProxi(long objectId) {
        super(objectId);
    }
    public ErrorDisplayICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theErrorDisplayFacade
            .getErrorDisplay(this.getId());
    }
    
    public long getClassId() {
        return -122;
    }
    
    public String getMessage() throws PersistenceException {
        return ((PersistentErrorDisplay)this.getTheObject()).getMessage();
    }
    public void setMessage(String newValue) throws PersistenceException {
        ((PersistentErrorDisplay)this.getTheObject()).setMessage(newValue);
    }
    public PersistentErrorDisplay getThis() throws PersistenceException {
        return ((PersistentErrorDisplay)this.getTheObject()).getThis();
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleErrorDisplay(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleErrorDisplay(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleErrorDisplay(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleErrorDisplay(this);
    }
    
    
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentErrorDisplay)this.getTheObject()).initializeOnInstantiation();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentErrorDisplay)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentErrorDisplay)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentErrorDisplay)this.getTheObject()).initializeOnCreation();
    }

    
}

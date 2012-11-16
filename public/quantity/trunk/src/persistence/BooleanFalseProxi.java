package persistence;

import model.UserException;

import model.visitor.*;

public class BooleanFalseProxi extends BooleanValueProxi implements PersistentBooleanFalse{
    
    public BooleanFalseProxi(long objectId) {
        super(objectId);
    }
    public BooleanFalseProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theBooleanFalseFacade
            .getBooleanFalse(this.getId());
    }
    
    public long getClassId() {
        return 140;
    }
    
    public PersistentBooleanFalse getThis() throws PersistenceException {
        return ((PersistentBooleanFalse)this.getTheObject()).getThis();
    }
    
    public void accept(BooleanValueVisitor visitor) throws PersistenceException {
        visitor.handleBooleanFalse(this);
    }
    public <R> R accept(BooleanValueReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleBooleanFalse(this);
    }
    public <E extends UserException>  void accept(BooleanValueExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleBooleanFalse(this);
    }
    public <R, E extends UserException> R accept(BooleanValueReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleBooleanFalse(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleBooleanFalse(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleBooleanFalse(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleBooleanFalse(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleBooleanFalse(this);
    }
    
    
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentBooleanFalse)this.getTheObject()).initializeOnInstantiation();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentBooleanFalse)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentBooleanFalse)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentBooleanFalse)this.getTheObject()).initializeOnCreation();
    }

    
}

package persistence;

import model.UserException;

import model.visitor.*;

public class MBooleanICProxi extends PersistentInCacheProxiOptimistic implements PersistentMBoolean{
    
    public MBooleanICProxi(long objectId) {
        super(objectId);
    }
    public MBooleanICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theMBooleanFacade
            .getMBoolean(this.getId());
    }
    
    public long getClassId() {
        return 137;
    }
    
    public PersistentMBoolean getThis() throws PersistenceException {
        return ((PersistentMBoolean)this.getTheObject()).getThis();
    }
    
    public void accept(MBooleanVisitor visitor) throws PersistenceException {
        visitor.handleMBoolean(this);
    }
    public <R> R accept(MBooleanReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMBoolean(this);
    }
    public <E extends UserException>  void accept(MBooleanExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMBoolean(this);
    }
    public <R, E extends UserException> R accept(MBooleanReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMBoolean(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleMBoolean(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMBoolean(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMBoolean(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMBoolean(this);
    }
    
    
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentMBoolean)this.getTheObject()).initializeOnInstantiation();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentMBoolean)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentMBoolean)this.getTheObject()).initialize(This, final$$Fields);
    }
    public boolean toBoolean() 
				throws PersistenceException{
        return ((PersistentMBoolean)this.getTheObject()).toBoolean();
    }
    public PersistentMBoolean createFromBoolean(final boolean bool) 
				throws PersistenceException{
        return ((PersistentMBoolean)this.getTheObject()).createFromBoolean(bool);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentMBoolean)this.getTheObject()).initializeOnCreation();
    }

    
}

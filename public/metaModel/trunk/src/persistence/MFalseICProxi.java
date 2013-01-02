package persistence;

import model.UserException;

import model.visitor.*;

public class MFalseICProxi extends MBooleanICProxi implements PersistentMFalse{
    
    public MFalseICProxi(long objectId) {
        super(objectId);
    }
    public MFalseICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theMFalseFacade
            .getMFalse(this.getId());
    }
    
    public long getClassId() {
        return 136;
    }
    
    public PersistentMFalse getThis() throws PersistenceException {
        return ((PersistentMFalse)this.getTheObject()).getThis();
    }
    
    public void accept(MBooleanVisitor visitor) throws PersistenceException {
        visitor.handleMFalse(this);
    }
    public <R> R accept(MBooleanReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMFalse(this);
    }
    public <E extends UserException>  void accept(MBooleanExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMFalse(this);
    }
    public <R, E extends UserException> R accept(MBooleanReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMFalse(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleMFalse(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMFalse(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMFalse(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMFalse(this);
    }
    
    
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentMFalse)this.getTheObject()).initializeOnInstantiation();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentMFalse)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentMFalse)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentMFalse)this.getTheObject()).initializeOnCreation();
    }
    public PersistentMBoolean createFromBoolean(final boolean bool) 
				throws PersistenceException{
        return ((PersistentMFalse)this.getTheObject()).createFromBoolean(bool);
    }
    public boolean toBoolean() 
				throws PersistenceException{
        return ((PersistentMFalse)this.getTheObject()).toBoolean();
    }
    public PersistentMBoolean invert() 
				throws PersistenceException{
        return ((PersistentMFalse)this.getTheObject()).invert();
    }

    
}

package persistence;

import model.UserException;

import model.visitor.*;

public class MTrueProxi extends MBooleanProxi implements PersistentMTrue{
    
    public MTrueProxi(long objectId) {
        super(objectId);
    }
    public MTrueProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theMTrueFacade
            .getMTrue(this.getId());
    }
    
    public long getClassId() {
        return 138;
    }
    
    public PersistentMTrue getThis() throws PersistenceException {
        return ((PersistentMTrue)this.getTheObject()).getThis();
    }
    
    public void accept(MBooleanVisitor visitor) throws PersistenceException {
        visitor.handleMTrue(this);
    }
    public <R> R accept(MBooleanReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMTrue(this);
    }
    public <E extends UserException>  void accept(MBooleanExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMTrue(this);
    }
    public <R, E extends UserException> R accept(MBooleanReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMTrue(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleMTrue(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMTrue(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMTrue(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMTrue(this);
    }
    
    
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentMTrue)this.getTheObject()).initializeOnInstantiation();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentMTrue)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentMTrue)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentMTrue)this.getTheObject()).initializeOnCreation();
    }
    public boolean toBoolean() 
				throws PersistenceException{
        return ((PersistentMTrue)this.getTheObject()).toBoolean();
    }
    public PersistentMBoolean invert() 
				throws PersistenceException{
        return ((PersistentMTrue)this.getTheObject()).invert();
    }

    
}

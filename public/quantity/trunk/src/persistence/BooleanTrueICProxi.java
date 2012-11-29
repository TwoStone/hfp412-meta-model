package persistence;

import model.UserException;

import model.visitor.*;

public class BooleanTrueICProxi extends BooleanValueICProxi implements PersistentBooleanTrue{
    
    public BooleanTrueICProxi(long objectId) {
        super(objectId);
    }
    public BooleanTrueICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theBooleanTrueFacade
            .getBooleanTrue(this.getId());
    }
    
    public long getClassId() {
        return 117;
    }
    
    public PersistentBooleanTrue getThis() throws PersistenceException {
        return ((PersistentBooleanTrue)this.getTheObject()).getThis();
    }
    
    public void accept(BooleanValueVisitor visitor) throws PersistenceException {
        visitor.handleBooleanTrue(this);
    }
    public <R> R accept(BooleanValueReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleBooleanTrue(this);
    }
    public <E extends UserException>  void accept(BooleanValueExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleBooleanTrue(this);
    }
    public <R, E extends UserException> R accept(BooleanValueReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleBooleanTrue(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleBooleanTrue(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleBooleanTrue(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleBooleanTrue(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleBooleanTrue(this);
    }
    
    
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentBooleanTrue)this.getTheObject()).initializeOnInstantiation();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentBooleanTrue)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentBooleanTrue)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentBooleanTrue)this.getTheObject()).initializeOnCreation();
    }

    
}

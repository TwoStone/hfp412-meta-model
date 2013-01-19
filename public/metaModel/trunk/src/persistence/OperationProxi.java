package persistence;

import model.UserException;

import model.visitor.*;

public class OperationProxi extends AbsOperationProxi implements PersistentOperation{
    
    public OperationProxi(long objectId) {
        super(objectId);
    }
    public OperationProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theOperationFacade
            .getOperation(this.getId());
    }
    
    public long getClassId() {
        return 146;
    }
    
    public PersistentOperation getThis() throws PersistenceException {
        return ((PersistentOperation)this.getTheObject()).getThis();
    }
    
    public void accept(AbsOperationVisitor visitor) throws PersistenceException {
        visitor.handleOperation(this);
    }
    public <R> R accept(AbsOperationReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleOperation(this);
    }
    public <E extends UserException>  void accept(AbsOperationExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleOperation(this);
    }
    public <R, E extends UserException> R accept(AbsOperationReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleOperation(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleOperation(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleOperation(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleOperation(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleOperation(this);
    }
    
    
    public PersistentMBoolean isStatic() 
				throws PersistenceException{
        return ((PersistentOperation)this.getTheObject()).isStatic();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentOperation)this.getTheObject()).initializeOnInstantiation();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentOperation)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentOperation)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentOperation)this.getTheObject()).initializeOnCreation();
    }

    
}

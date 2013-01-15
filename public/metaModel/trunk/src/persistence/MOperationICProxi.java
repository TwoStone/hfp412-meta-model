package persistence;

import model.UserException;

import model.visitor.*;

public class MOperationICProxi extends MAbsOperationICProxi implements PersistentMOperation{
    
    public MOperationICProxi(long objectId) {
        super(objectId);
    }
    public MOperationICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theMOperationFacade
            .getMOperation(this.getId());
    }
    
    public long getClassId() {
        return 197;
    }
    
    public PersistentMOperation getThis() throws PersistenceException {
        return ((PersistentMOperation)this.getTheObject()).getThis();
    }
    
    public void accept(MAbsOperationVisitor visitor) throws PersistenceException {
        visitor.handleMOperation(this);
    }
    public <R> R accept(MAbsOperationReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMOperation(this);
    }
    public <E extends UserException>  void accept(MAbsOperationExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMOperation(this);
    }
    public <R, E extends UserException> R accept(MAbsOperationReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMOperation(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleMOperation(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMOperation(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMOperation(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMOperation(this);
    }
    
    
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentMOperation)this.getTheObject()).initializeOnInstantiation();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentMOperation)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentMOperation)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentMOperation)this.getTheObject()).initializeOnCreation();
    }

    
}

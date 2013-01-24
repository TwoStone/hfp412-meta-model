package persistence;

import model.UserException;

import model.visitor.*;

public class ActualParameterProxi extends PersistentProxi implements PersistentActualParameter{
    
    public ActualParameterProxi(long objectId) {
        super(objectId);
    }
    public ActualParameterProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theActualParameterFacade
            .getActualParameter(this.getId());
    }
    
    public long getClassId() {
        return 194;
    }
    
    public PersistentFormalParameter getType() throws PersistenceException {
        return ((PersistentActualParameter)this.getTheObject()).getType();
    }
    public void setType(PersistentFormalParameter newValue) throws PersistenceException {
        ((PersistentActualParameter)this.getTheObject()).setType(newValue);
    }
    public PersistentInstanceObject getValue() throws PersistenceException {
        return ((PersistentActualParameter)this.getTheObject()).getValue();
    }
    public void setValue(PersistentInstanceObject newValue) throws PersistenceException {
        ((PersistentActualParameter)this.getTheObject()).setValue(newValue);
    }
    public PersistentActualParameter getThis() throws PersistenceException {
        return ((PersistentActualParameter)this.getTheObject()).getThis();
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleActualParameter(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleActualParameter(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleActualParameter(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleActualParameter(this);
    }
    
    
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentActualParameter)this.getTheObject()).initializeOnInstantiation();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentActualParameter)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentActualParameter)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentActualParameter)this.getTheObject()).initializeOnCreation();
    }

    
}

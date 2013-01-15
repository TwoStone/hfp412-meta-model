package persistence;

import model.UserException;

import model.visitor.*;

public class InstanceObjectProxi extends PersistentProxi implements PersistentInstanceObject{
    
    public InstanceObjectProxi(long objectId) {
        super(objectId);
    }
    public InstanceObjectProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theInstanceObjectFacade
            .getInstanceObject(this.getId());
    }
    
    public long getClassId() {
        return 205;
    }
    
    public PersistentMAtomicType getType() throws PersistenceException {
        return ((PersistentInstanceObject)this.getTheObject()).getType();
    }
    public void setType(PersistentMAtomicType newValue) throws PersistenceException {
        ((PersistentInstanceObject)this.getTheObject()).setType(newValue);
    }
    public PersistentInstanceObject getThis() throws PersistenceException {
        return ((PersistentInstanceObject)this.getTheObject()).getThis();
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleInstanceObject(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleInstanceObject(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleInstanceObject(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleInstanceObject(this);
    }
    
    
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentInstanceObject)this.getTheObject()).initializeOnInstantiation();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentInstanceObject)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentInstanceObject)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentInstanceObject)this.getTheObject()).initializeOnCreation();
    }

    
}

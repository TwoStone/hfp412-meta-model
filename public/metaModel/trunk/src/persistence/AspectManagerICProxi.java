package persistence;

import model.UserException;

import model.visitor.*;

public class AspectManagerICProxi extends PersistentInCacheProxiOptimistic implements PersistentAspectManager{
    
    public AspectManagerICProxi(long objectId) {
        super(objectId);
    }
    public AspectManagerICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theAspectManagerFacade
            .getAspectManager(this.getId());
    }
    
    public long getClassId() {
        return 136;
    }
    
    public AspectManager_AspectsProxi getAspects() throws PersistenceException {
        return ((PersistentAspectManager)this.getTheObject()).getAspects();
    }
    public PersistentAspectManager getThis() throws PersistenceException {
        return ((PersistentAspectManager)this.getTheObject()).getThis();
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleAspectManager(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAspectManager(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAspectManager(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAspectManager(this);
    }
    
    
    public PersistentMAspect createAspect(final String name) 
				throws model.ConsistencyException, PersistenceException{
        return ((PersistentAspectManager)this.getTheObject()).createAspect(name);
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentAspectManager)this.getTheObject()).initializeOnInstantiation();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentAspectManager)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentAspectManager)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void createAspect(final String name, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentAspectManager)this.getTheObject()).createAspect(name, invoker);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentAspectManager)this.getTheObject()).initializeOnCreation();
    }

    
}

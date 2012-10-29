package persistence;

import model.UserException;

import model.visitor.*;

public class AspectManagerProxi extends PersistentProxi implements PersistentAspectManager{
    
    public AspectManagerProxi(long objectId) {
        super(objectId);
    }
    public AspectManagerProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theAspectManagerFacade
            .getAspectManager(this.getId());
    }
    
    public long getClassId() {
        return 126;
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
    
    
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentAspectManager)this.getTheObject()).initializeOnInstantiation();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentAspectManager)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void addAspect(final String name, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentAspectManager)this.getTheObject()).addAspect(name, invoker);
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentAspectManager)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void addAspect(final String name) 
				throws model.DoubleDefinitionException, PersistenceException{
        ((PersistentAspectManager)this.getTheObject()).addAspect(name);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentAspectManager)this.getTheObject()).initializeOnCreation();
    }

    
}

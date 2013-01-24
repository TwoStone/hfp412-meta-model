package persistence;

import model.UserException;

import model.visitor.*;

public class ObjectManagerICProxi extends PersistentInCacheProxiOptimistic implements PersistentObjectManager{
    
    public ObjectManagerICProxi(long objectId) {
        super(objectId);
    }
    public ObjectManagerICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theObjectManagerFacade
            .getObjectManager(this.getId());
    }
    
    public long getClassId() {
        return 237;
    }
    
    public ObjectManager_ObjectsProxi getObjects() throws PersistenceException {
        return ((PersistentObjectManager)this.getTheObject()).getObjects();
    }
    public PersistentObjectManager getThis() throws PersistenceException {
        return ((PersistentObjectManager)this.getTheObject()).getThis();
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleObjectManager(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleObjectManager(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleObjectManager(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleObjectManager(this);
    }
    
    
    public PersistentMObject createMObject(final MAtomicTypeSearchList types) 
				throws model.ConsistencyException, PersistenceException{
        return ((PersistentObjectManager)this.getTheObject()).createMObject(types);
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentObjectManager)this.getTheObject()).initializeOnInstantiation();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentObjectManager)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentObjectManager)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentObjectManager)this.getTheObject()).initializeOnCreation();
    }
    public void createMObject(final MAtomicTypeSearchList types, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentObjectManager)this.getTheObject()).createMObject(types, invoker);
    }

    
}

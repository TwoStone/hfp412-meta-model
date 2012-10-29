package persistence;

import model.UserException;

import model.visitor.*;

public class TypeManagerProxi extends PersistentProxi implements PersistentTypeManager{
    
    public TypeManagerProxi(long objectId) {
        super(objectId);
    }
    public TypeManagerProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theTypeManagerFacade
            .getTypeManager(this.getId());
    }
    
    public long getClassId() {
        return 118;
    }
    
    public TypeManager_AtomicTypesProxi getAtomicTypes() throws PersistenceException {
        return ((PersistentTypeManager)this.getTheObject()).getAtomicTypes();
    }
    public TypeManager_ProductTypesProxi getProductTypes() throws PersistenceException {
        return ((PersistentTypeManager)this.getTheObject()).getProductTypes();
    }
    public TypeManager_SumTypesProxi getSumTypes() throws PersistenceException {
        return ((PersistentTypeManager)this.getTheObject()).getSumTypes();
    }
    public PersistentTypeManager getThis() throws PersistenceException {
        return ((PersistentTypeManager)this.getTheObject()).getThis();
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleTypeManager(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleTypeManager(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleTypeManager(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleTypeManager(this);
    }
    
    
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentTypeManager)this.getTheObject()).initializeOnInstantiation();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentTypeManager)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentTypeManager)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void addAtomicType(final PersistentMAspect aspect, final String name) 
				throws model.DoubleDefinitionException, PersistenceException{
        ((PersistentTypeManager)this.getTheObject()).addAtomicType(aspect, name);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentTypeManager)this.getTheObject()).initializeOnCreation();
    }
    public void addAtomicType(final PersistentMAspect aspect, final String name, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentTypeManager)this.getTheObject()).addAtomicType(aspect, name, invoker);
    }

    
}

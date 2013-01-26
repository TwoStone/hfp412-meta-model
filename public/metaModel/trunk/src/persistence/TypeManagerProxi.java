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
        return 169;
    }
    
    public TypeManager_TypesProxi getTypes() throws PersistenceException {
        return ((PersistentTypeManager)this.getTheObject()).getTypes();
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
    
    
    public PersistentMAbstractSumType createSumType(final MTypeSearchList addends) 
				throws model.ConsistencyException, PersistenceException{
        return ((PersistentTypeManager)this.getTheObject()).createSumType(addends);
    }
    public void createAtomicRootType(final PersistentMAspect aspect, final String name, final PersistentMBoolean singletonType, final PersistentMBoolean abstractType, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentTypeManager)this.getTheObject()).createAtomicRootType(aspect, name, singletonType, abstractType, invoker);
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentTypeManager)this.getTheObject()).initializeOnInstantiation();
    }
    public void createSumType(final MTypeSearchList addends, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentTypeManager)this.getTheObject()).createSumType(addends, invoker);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentTypeManager)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void createProductType(final MTypeSearchList factors, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentTypeManager)this.getTheObject()).createProductType(factors, invoker);
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentTypeManager)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void createAtomicSubType(final PersistentMAtomicType superType, final String name, final PersistentMBoolean singletonType, final PersistentMBoolean abstractType, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentTypeManager)this.getTheObject()).createAtomicSubType(superType, name, singletonType, abstractType, invoker);
    }
    public PersistentMAbstractProductType createProductType(final MTypeSearchList factors) 
				throws model.ConsistencyException, PersistenceException{
        return ((PersistentTypeManager)this.getTheObject()).createProductType(factors);
    }
    public PersistentMAtomicType createAtomicSubType(final PersistentMAtomicType superType, final String name, final PersistentMBoolean singletonType, final PersistentMBoolean abstractType) 
				throws model.ConsistencyException, PersistenceException{
        return ((PersistentTypeManager)this.getTheObject()).createAtomicSubType(superType, name, singletonType, abstractType);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentTypeManager)this.getTheObject()).initializeOnCreation();
    }
    public PersistentMAtomicType createAtomicRootType(final PersistentMAspect aspect, final String name, final PersistentMBoolean singletonType, final PersistentMBoolean abstractType) 
				throws model.ConsistencyException, PersistenceException{
        return ((PersistentTypeManager)this.getTheObject()).createAtomicRootType(aspect, name, singletonType, abstractType);
    }

    
}

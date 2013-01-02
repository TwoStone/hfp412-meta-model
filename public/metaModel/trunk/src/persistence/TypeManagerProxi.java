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
    public TypeManager_AllTypesProxi getAllTypes() throws PersistenceException {
        return ((PersistentTypeManager)this.getTheObject()).getAllTypes();
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
    
    
    public void addSubType(final PersistentMAtomicType superType, final PersistentMAtomicType typeunder) 
				throws model.WrongSubTypeAspectException, model.CycleException, PersistenceException{
        ((PersistentTypeManager)this.getTheObject()).addSubType(superType, typeunder);
    }
    public void addSubType(final PersistentMAtomicType superType, final PersistentMAtomicType typeunder, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentTypeManager)this.getTheObject()).addSubType(superType, typeunder, invoker);
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
    public void createSubType(final PersistentMAtomicType superType, final String name, final PersistentMBoolean singletonType, final PersistentMBoolean abstractType, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentTypeManager)this.getTheObject()).createSubType(superType, name, singletonType, abstractType, invoker);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentTypeManager)this.getTheObject()).initializeOnCreation();
    }
    public void createSubType(final PersistentMAtomicType superType, final String name, final PersistentMBoolean singletonType, final PersistentMBoolean abstractType) 
				throws model.WrongSubTypeAspectException, model.DoubleDefinitionException, model.ConsistencyException, model.CycleException, PersistenceException{
        ((PersistentTypeManager)this.getTheObject()).createSubType(superType, name, singletonType, abstractType);
    }
    public void createAtomicType(final PersistentMAspect aspect, final String name, final PersistentMBoolean singletonType, final PersistentMBoolean abstractType, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentTypeManager)this.getTheObject()).createAtomicType(aspect, name, singletonType, abstractType, invoker);
    }
    public void createAtomicType(final PersistentMAspect aspect, final String name, final PersistentMBoolean singletonType, final PersistentMBoolean abstractType) 
				throws model.DoubleDefinitionException, model.ConsistencyException, PersistenceException{
        ((PersistentTypeManager)this.getTheObject()).createAtomicType(aspect, name, singletonType, abstractType);
    }

    
}

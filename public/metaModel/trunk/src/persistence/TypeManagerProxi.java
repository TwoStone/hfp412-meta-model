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
    
    
    public void addSubType(final PersistentMAtomicType superType, final PersistentMAtomicType typeunder) 
				throws model.WrongSubTypeAspectException, model.CycleException, PersistenceException{
        ((PersistentTypeManager)this.getTheObject()).addSubType(superType, typeunder);
    }
    public void createSubType(final PersistentMAtomicType superType, final String name) 
				throws model.WrongSubTypeAspectException, model.DoubleDefinitionException, model.CycleException, PersistenceException{
        ((PersistentTypeManager)this.getTheObject()).createSubType(superType, name);
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
    public void createSubType(final PersistentMAtomicType superType, final String name, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentTypeManager)this.getTheObject()).createSubType(superType, name, invoker);
    }
    public void createAtomicType(final PersistentMAspect aspect, final String name, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentTypeManager)this.getTheObject()).createAtomicType(aspect, name, invoker);
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentTypeManager)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void createAtomicType(final PersistentMAspect aspect, final String name) 
				throws model.DoubleDefinitionException, PersistenceException{
        ((PersistentTypeManager)this.getTheObject()).createAtomicType(aspect, name);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentTypeManager)this.getTheObject()).initializeOnCreation();
    }

    
}

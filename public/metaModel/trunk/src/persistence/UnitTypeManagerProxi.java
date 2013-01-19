package persistence;

import model.UserException;

import model.visitor.*;

public class UnitTypeManagerProxi extends PersistentProxi implements PersistentUnitTypeManager{
    
    public UnitTypeManagerProxi(long objectId) {
        super(objectId);
    }
    public UnitTypeManagerProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theUnitTypeManagerFacade
            .getUnitTypeManager(this.getId());
    }
    
    public long getClassId() {
        return 169;
    }
    
    public UnitTypeManager_UnitTypesProxi getUnitTypes() throws PersistenceException {
        return ((PersistentUnitTypeManager)this.getTheObject()).getUnitTypes();
    }
    public UnitTypeManager_UnitsProxi getUnits() throws PersistenceException {
        return ((PersistentUnitTypeManager)this.getTheObject()).getUnits();
    }
    public PersistentUnitTypeManager getThis() throws PersistenceException {
        return ((PersistentUnitTypeManager)this.getTheObject()).getThis();
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleUnitTypeManager(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleUnitTypeManager(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleUnitTypeManager(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleUnitTypeManager(this);
    }
    
    
    public void addReferenceType(final PersistentCompUnitType compUnitType, final PersistentUnitType unitType, final long exponent, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentUnitTypeManager)this.getTheObject()).addReferenceType(compUnitType, unitType, exponent, invoker);
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentUnitTypeManager)this.getTheObject()).initializeOnInstantiation();
    }
    public void createUnit(final String name, final PersistentUnitType type) 
				throws model.DoubleDefinitionException, PersistenceException{
        ((PersistentUnitTypeManager)this.getTheObject()).createUnit(name, type);
    }
    public UnitTypeSearchList getAtomicUnitTypes() 
				throws PersistenceException{
        return ((PersistentUnitTypeManager)this.getTheObject()).getAtomicUnitTypes();
    }
    public void createCompUnit(final String name, final PersistentCompUnitType type, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentUnitTypeManager)this.getTheObject()).createCompUnit(name, type, invoker);
    }
    public UnitTypeSearchList getAtomicUnitTypes(final TDObserver observer) 
				throws PersistenceException{
        return ((PersistentUnitTypeManager)this.getTheObject()).getAtomicUnitTypes(observer);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentUnitTypeManager)this.getTheObject()).initializeOnCreation();
    }
    public void addReferenceType(final PersistentCompUnitType compUnitType, final PersistentUnitType unitType, final long exponent) 
				throws model.DoubleDefinitionException, model.AlreadyFinalizedException, PersistenceException{
        ((PersistentUnitTypeManager)this.getTheObject()).addReferenceType(compUnitType, unitType, exponent);
    }
    public void createCompUnit(final String name, final PersistentCompUnitType type) 
				throws model.DoubleDefinitionException, model.NotFinalizedException, PersistenceException{
        ((PersistentUnitTypeManager)this.getTheObject()).createCompUnit(name, type);
    }
    public void finishModeling(final PersistentCompUnitType compUnitType, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentUnitTypeManager)this.getTheObject()).finishModeling(compUnitType, invoker);
    }
    public void finishModeling(final PersistentCompUnitType compUnitType) 
				throws model.AlreadyFinalizedException, PersistenceException{
        ((PersistentUnitTypeManager)this.getTheObject()).finishModeling(compUnitType);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentUnitTypeManager)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void createUnitType(final String name, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentUnitTypeManager)this.getTheObject()).createUnitType(name, invoker);
    }
    public void createCompUnitType(final String name) 
				throws model.DoubleDefinitionException, PersistenceException{
        ((PersistentUnitTypeManager)this.getTheObject()).createCompUnitType(name);
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentUnitTypeManager)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void addDefaultUnit(final PersistentAbsUnitType type, final PersistentAbsUnit unit, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentUnitTypeManager)this.getTheObject()).addDefaultUnit(type, unit, invoker);
    }
    public void addDefaultUnit(final PersistentAbsUnitType type, final PersistentAbsUnit unit) 
				throws PersistenceException{
        ((PersistentUnitTypeManager)this.getTheObject()).addDefaultUnit(type, unit);
    }
    public void createUnit(final String name, final PersistentUnitType type, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentUnitTypeManager)this.getTheObject()).createUnit(name, type, invoker);
    }
    public void createUnitType(final String name) 
				throws model.DoubleDefinitionException, PersistenceException{
        ((PersistentUnitTypeManager)this.getTheObject()).createUnitType(name);
    }
    public void createCompUnitType(final String name, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentUnitTypeManager)this.getTheObject()).createCompUnitType(name, invoker);
    }

    
}

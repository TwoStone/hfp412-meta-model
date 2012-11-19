package persistence;

import model.UserException;

import model.visitor.*;

public class UnitTypeManagerICProxi extends PersistentInCacheProxiOptimistic implements PersistentUnitTypeManager{
    
    public UnitTypeManagerICProxi(long objectId) {
        super(objectId);
    }
    public UnitTypeManagerICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theUnitTypeManagerFacade
            .getUnitTypeManager(this.getId());
    }
    
    public long getClassId() {
        return 118;
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
    public void createUnit(final PersistentUnitType type, final String name, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentUnitTypeManager)this.getTheObject()).createUnit(type, name, invoker);
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentUnitTypeManager)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void createUnit(final PersistentUnitType type, final String name) 
				throws model.DoubleDefinitionException, PersistenceException{
        ((PersistentUnitTypeManager)this.getTheObject()).createUnit(type, name);
    }
    public void addDefaultUnit(final PersistentAbsUnitType type, final PersistentAbsUnit unit, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentUnitTypeManager)this.getTheObject()).addDefaultUnit(type, unit, invoker);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentUnitTypeManager)this.getTheObject()).initializeOnCreation();
    }
    public void addDefaultUnit(final PersistentAbsUnitType type, final PersistentAbsUnit unit) 
				throws PersistenceException{
        ((PersistentUnitTypeManager)this.getTheObject()).addDefaultUnit(type, unit);
    }
    public void addReferenceType(final PersistentCompUnitType compUnitType, final PersistentUnitType unitType, final long exponent) 
				throws model.DoubleDefinitionException, PersistenceException{
        ((PersistentUnitTypeManager)this.getTheObject()).addReferenceType(compUnitType, unitType, exponent);
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

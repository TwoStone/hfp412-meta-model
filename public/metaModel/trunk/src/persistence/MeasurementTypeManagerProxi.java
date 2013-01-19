package persistence;

import model.UserException;

import model.visitor.*;

public class MeasurementTypeManagerProxi extends PersistentProxi implements PersistentMeasurementTypeManager{
    
    public MeasurementTypeManagerProxi(long objectId) {
        super(objectId);
    }
    public MeasurementTypeManagerProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theMeasurementTypeManagerFacade
            .getMeasurementTypeManager(this.getId());
    }
    
    public long getClassId() {
        return 212;
    }
    
    public MeasurementTypeManager_MeasurementTypesProxi getMeasurementTypes() throws PersistenceException {
        return ((PersistentMeasurementTypeManager)this.getTheObject()).getMeasurementTypes();
    }
    public PersistentMeasurementTypeManager getThis() throws PersistenceException {
        return ((PersistentMeasurementTypeManager)this.getTheObject()).getThis();
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleMeasurementTypeManager(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMeasurementTypeManager(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMeasurementTypeManager(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMeasurementTypeManager(this);
    }
    
    
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentMeasurementTypeManager)this.getTheObject()).initializeOnInstantiation();
    }
    public void createMeasurementType(final String name, final PersistentMType type, final PersistentUnitType unitType, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentMeasurementTypeManager)this.getTheObject()).createMeasurementType(name, type, unitType, invoker);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentMeasurementTypeManager)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentMeasurementTypeManager)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void createMeasurementType(final String name, final PersistentMType type, final PersistentUnitType unitType) 
				throws PersistenceException{
        ((PersistentMeasurementTypeManager)this.getTheObject()).createMeasurementType(name, type, unitType);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentMeasurementTypeManager)this.getTheObject()).initializeOnCreation();
    }

    
}

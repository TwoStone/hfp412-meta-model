package persistence;

import model.UserException;

import model.visitor.*;

public interface PersistentMeasurementTypeManager extends Anything, AbstractPersistentProxi {
    
    public MeasurementTypeManager_MeasurementTypesProxi getMeasurementTypes() throws PersistenceException ;
    public PersistentMeasurementTypeManager getThis() throws PersistenceException ;
    
    public void accept(AnythingVisitor visitor) throws PersistenceException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public void initializeOnInstantiation() 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public void createMeasurementType(final String name, final PersistentMType type, final PersistentUnitType unitType, final Invoker invoker) 
				throws PersistenceException;
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException;
    public void createMeasurementType(final String name, final PersistentMType type, final PersistentUnitType unitType) 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;

}

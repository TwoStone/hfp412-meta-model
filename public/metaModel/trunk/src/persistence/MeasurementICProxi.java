package persistence;

import model.UserException;

import model.visitor.*;

public class MeasurementICProxi extends PersistentInCacheProxiOptimistic implements PersistentMeasurement{
    
    public MeasurementICProxi(long objectId) {
        super(objectId);
    }
    public MeasurementICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theMeasurementFacade
            .getMeasurement(this.getId());
    }
    
    public long getClassId() {
        return 189;
    }
    
    public PersistentMMeasurementType getType() throws PersistenceException {
        return ((PersistentMeasurement)this.getTheObject()).getType();
    }
    public void setType(PersistentMMeasurementType newValue) throws PersistenceException {
        ((PersistentMeasurement)this.getTheObject()).setType(newValue);
    }
    public PersistentAbsQuantity getQuantity() throws PersistenceException {
        return ((PersistentMeasurement)this.getTheObject()).getQuantity();
    }
    public void setQuantity(PersistentAbsQuantity newValue) throws PersistenceException {
        ((PersistentMeasurement)this.getTheObject()).setQuantity(newValue);
    }
    public PersistentMeasurement getThis() throws PersistenceException {
        return ((PersistentMeasurement)this.getTheObject()).getThis();
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleMeasurement(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMeasurement(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMeasurement(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMeasurement(this);
    }
    
    
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentMeasurement)this.getTheObject()).initializeOnInstantiation();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentMeasurement)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentMeasurement)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentMeasurement)this.getTheObject()).initializeOnCreation();
    }

    
}

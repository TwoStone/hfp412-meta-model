package persistence;



public class ConversionRateProxi extends PersistentProxi implements PersistentConversionRate{
    
    public ConversionRateProxi(long objectId) {
        super(objectId);
    }
    public ConversionRateProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theConversionRateFacade
            .getConversionRate(this.getId());
    }
    
    public long getClassId() {
        return 120;
    }
    
    public PersistentUnit getFromUnit() throws PersistenceException {
        return ((PersistentConversionRate)this.getTheObject()).getFromUnit();
    }
    public void setFromUnit(PersistentUnit newValue) throws PersistenceException {
        ((PersistentConversionRate)this.getTheObject()).setFromUnit(newValue);
    }
    public PersistentUnit getToUnit() throws PersistenceException {
        return ((PersistentConversionRate)this.getTheObject()).getToUnit();
    }
    public void setToUnit(PersistentUnit newValue) throws PersistenceException {
        ((PersistentConversionRate)this.getTheObject()).setToUnit(newValue);
    }
    public PersistentFraction getConversionRate() throws PersistenceException {
        return ((PersistentConversionRate)this.getTheObject()).getConversionRate();
    }
    public void setConversionRate(PersistentFraction newValue) throws PersistenceException {
        ((PersistentConversionRate)this.getTheObject()).setConversionRate(newValue);
    }
    public PersistentConversionRate getThis() throws PersistenceException {
        return ((PersistentConversionRate)this.getTheObject()).getThis();
    }
    
    public void accept(model.visitor.AnythingVisitor visitor) throws PersistenceException {
        visitor.handleConversionRate(this);
    }
    public <R> R accept(model.visitor.AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleConversionRate(this);
    }
    public <E extends model.UserException>  void accept(model.visitor.AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleConversionRate(this);
    }
    public <R, E extends model.UserException> R accept(model.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleConversionRate(this);
    }
    
    
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentConversionRate)this.getTheObject()).initializeOnInstantiation();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentConversionRate)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentConversionRate)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentConversionRate)this.getTheObject()).initializeOnCreation();
    }

    
}

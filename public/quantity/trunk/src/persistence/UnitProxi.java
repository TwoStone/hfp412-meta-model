package persistence;



public class UnitProxi extends AbsUnitProxi implements PersistentUnit{
    
    public UnitProxi(long objectId) {
        super(objectId);
    }
    public UnitProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theUnitFacade
            .getUnit(this.getId());
    }
    
    public long getClassId() {
        return 118;
    }
    
    public PersistentUnitType getUnitType() throws PersistenceException {
        return ((PersistentUnit)this.getTheObject()).getUnitType();
    }
    public void setUnitType(PersistentUnitType newValue) throws PersistenceException {
        ((PersistentUnit)this.getTheObject()).setUnitType(newValue);
    }
    public PersistentUnit getThis() throws PersistenceException {
        return ((PersistentUnit)this.getTheObject()).getThis();
    }
    
    public void accept(model.visitor.AbsUnitVisitor visitor) throws PersistenceException {
        visitor.handleUnit(this);
    }
    public <R> R accept(model.visitor.AbsUnitReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleUnit(this);
    }
    public <E extends model.UserException>  void accept(model.visitor.AbsUnitExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleUnit(this);
    }
    public <R, E extends model.UserException> R accept(model.visitor.AbsUnitReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleUnit(this);
    }
    public void accept(model.visitor.AnythingVisitor visitor) throws PersistenceException {
        visitor.handleUnit(this);
    }
    public <R> R accept(model.visitor.AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleUnit(this);
    }
    public <E extends model.UserException>  void accept(model.visitor.AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleUnit(this);
    }
    public <R, E extends model.UserException> R accept(model.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleUnit(this);
    }
    
    
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentUnit)this.getTheObject()).initializeOnInstantiation();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentUnit)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentUnit)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentUnit)this.getTheObject()).initializeOnCreation();
    }

    
}

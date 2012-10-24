package persistence;



public class UnitTypeICProxi extends AbsUnitTypeICProxi implements PersistentUnitType{
    
    public UnitTypeICProxi(long objectId) {
        super(objectId);
    }
    public UnitTypeICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theUnitTypeFacade
            .getUnitType(this.getId());
    }
    
    public long getClassId() {
        return 117;
    }
    
    public PersistentUnit getDefaultUnit() throws PersistenceException {
        return ((PersistentUnitType)this.getTheObject()).getDefaultUnit();
    }
    public void setDefaultUnit(PersistentUnit newValue) throws PersistenceException {
        ((PersistentUnitType)this.getTheObject()).setDefaultUnit(newValue);
    }
    public PersistentUnitType getThis() throws PersistenceException {
        return ((PersistentUnitType)this.getTheObject()).getThis();
    }
    
    public void accept(model.visitor.AbsUnitTypeVisitor visitor) throws PersistenceException {
        visitor.handleUnitType(this);
    }
    public <R> R accept(model.visitor.AbsUnitTypeReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleUnitType(this);
    }
    public <E extends model.UserException>  void accept(model.visitor.AbsUnitTypeExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleUnitType(this);
    }
    public <R, E extends model.UserException> R accept(model.visitor.AbsUnitTypeReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleUnitType(this);
    }
    public void accept(model.visitor.AnythingVisitor visitor) throws PersistenceException {
        visitor.handleUnitType(this);
    }
    public <R> R accept(model.visitor.AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleUnitType(this);
    }
    public <E extends model.UserException>  void accept(model.visitor.AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleUnitType(this);
    }
    public <R, E extends model.UserException> R accept(model.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleUnitType(this);
    }
    
    
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentUnitType)this.getTheObject()).initializeOnInstantiation();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentUnitType)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentUnitType)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentUnitType)this.getTheObject()).initializeOnCreation();
    }

    
}

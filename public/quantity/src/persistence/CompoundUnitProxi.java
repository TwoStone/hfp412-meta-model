package persistence;



public class CompoundUnitProxi extends AbsUnitProxi implements PersistentCompoundUnit{
    
    public CompoundUnitProxi(long objectId) {
        super(objectId);
    }
    public CompoundUnitProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theCompoundUnitFacade
            .getCompoundUnit(this.getId());
    }
    
    public long getClassId() {
        return 122;
    }
    
    public PersistentCompoundUnit getThis() throws PersistenceException {
        return ((PersistentCompoundUnit)this.getTheObject()).getThis();
    }
    
    public void accept(model.visitor.AbsUnitVisitor visitor) throws PersistenceException {
        visitor.handleCompoundUnit(this);
    }
    public <R> R accept(model.visitor.AbsUnitReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCompoundUnit(this);
    }
    public <E extends model.UserException>  void accept(model.visitor.AbsUnitExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCompoundUnit(this);
    }
    public <R, E extends model.UserException> R accept(model.visitor.AbsUnitReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCompoundUnit(this);
    }
    public void accept(model.visitor.AnythingVisitor visitor) throws PersistenceException {
        visitor.handleCompoundUnit(this);
    }
    public <R> R accept(model.visitor.AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCompoundUnit(this);
    }
    public <E extends model.UserException>  void accept(model.visitor.AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCompoundUnit(this);
    }
    public <R, E extends model.UserException> R accept(model.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCompoundUnit(this);
    }
    
    
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentCompoundUnit)this.getTheObject()).initializeOnInstantiation();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentCompoundUnit)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentCompoundUnit)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentCompoundUnit)this.getTheObject()).initializeOnCreation();
    }

    
}

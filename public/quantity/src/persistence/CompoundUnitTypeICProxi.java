package persistence;



public class CompoundUnitTypeICProxi extends AbsUnitTypeICProxi implements PersistentCompoundUnitType{
    
    public CompoundUnitTypeICProxi(long objectId) {
        super(objectId);
    }
    public CompoundUnitTypeICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theCompoundUnitTypeFacade
            .getCompoundUnitType(this.getId());
    }
    
    public long getClassId() {
        return 114;
    }
    
    public PersistentCompoundUnitType getThis() throws PersistenceException {
        return ((PersistentCompoundUnitType)this.getTheObject()).getThis();
    }
    
    public void accept(model.visitor.AbsUnitTypeVisitor visitor) throws PersistenceException {
        visitor.handleCompoundUnitType(this);
    }
    public <R> R accept(model.visitor.AbsUnitTypeReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCompoundUnitType(this);
    }
    public <E extends model.UserException>  void accept(model.visitor.AbsUnitTypeExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCompoundUnitType(this);
    }
    public <R, E extends model.UserException> R accept(model.visitor.AbsUnitTypeReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCompoundUnitType(this);
    }
    public void accept(model.visitor.AnythingVisitor visitor) throws PersistenceException {
        visitor.handleCompoundUnitType(this);
    }
    public <R> R accept(model.visitor.AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCompoundUnitType(this);
    }
    public <E extends model.UserException>  void accept(model.visitor.AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCompoundUnitType(this);
    }
    public <R, E extends model.UserException> R accept(model.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCompoundUnitType(this);
    }
    
    
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentCompoundUnitType)this.getTheObject()).initializeOnInstantiation();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentCompoundUnitType)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentCompoundUnitType)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentCompoundUnitType)this.getTheObject()).initializeOnCreation();
    }

    
}

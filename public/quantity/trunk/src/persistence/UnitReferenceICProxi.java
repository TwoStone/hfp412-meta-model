package persistence;



public class UnitReferenceICProxi extends AbsUnitICProxi implements PersistentUnitReference{
    
    public UnitReferenceICProxi(long objectId) {
        super(objectId);
    }
    public UnitReferenceICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theUnitReferenceFacade
            .getUnitReference(this.getId());
    }
    
    public long getClassId() {
        return 119;
    }
    
    public PersistentUnitReference getThis() throws PersistenceException {
        return ((PersistentUnitReference)this.getTheObject()).getThis();
    }
    
    public void accept(model.visitor.AbsUnitVisitor visitor) throws PersistenceException {
        visitor.handleUnitReference(this);
    }
    public <R> R accept(model.visitor.AbsUnitReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleUnitReference(this);
    }
    public <E extends model.UserException>  void accept(model.visitor.AbsUnitExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleUnitReference(this);
    }
    public <R, E extends model.UserException> R accept(model.visitor.AbsUnitReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleUnitReference(this);
    }
    public void accept(model.visitor.AnythingVisitor visitor) throws PersistenceException {
        visitor.handleUnitReference(this);
    }
    public <R> R accept(model.visitor.AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleUnitReference(this);
    }
    public <E extends model.UserException>  void accept(model.visitor.AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleUnitReference(this);
    }
    public <R, E extends model.UserException> R accept(model.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleUnitReference(this);
    }
    
    
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentUnitReference)this.getTheObject()).initializeOnInstantiation();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentUnitReference)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentUnitReference)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentUnitReference)this.getTheObject()).initializeOnCreation();
    }

    
}

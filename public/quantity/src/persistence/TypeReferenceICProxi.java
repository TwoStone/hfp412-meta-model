package persistence;



public class TypeReferenceICProxi extends AbsUnitTypeICProxi implements PersistentTypeReference{
    
    public TypeReferenceICProxi(long objectId) {
        super(objectId);
    }
    public TypeReferenceICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theTypeReferenceFacade
            .getTypeReference(this.getId());
    }
    
    public long getClassId() {
        return 113;
    }
    
    public PersistentTypeReference getThis() throws PersistenceException {
        return ((PersistentTypeReference)this.getTheObject()).getThis();
    }
    
    public void accept(model.visitor.AbsUnitTypeVisitor visitor) throws PersistenceException {
        visitor.handleTypeReference(this);
    }
    public <R> R accept(model.visitor.AbsUnitTypeReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleTypeReference(this);
    }
    public <E extends model.UserException>  void accept(model.visitor.AbsUnitTypeExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleTypeReference(this);
    }
    public <R, E extends model.UserException> R accept(model.visitor.AbsUnitTypeReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleTypeReference(this);
    }
    public void accept(model.visitor.AnythingVisitor visitor) throws PersistenceException {
        visitor.handleTypeReference(this);
    }
    public <R> R accept(model.visitor.AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleTypeReference(this);
    }
    public <E extends model.UserException>  void accept(model.visitor.AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleTypeReference(this);
    }
    public <R, E extends model.UserException> R accept(model.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleTypeReference(this);
    }
    
    
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentTypeReference)this.getTheObject()).initializeOnInstantiation();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentTypeReference)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentTypeReference)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentTypeReference)this.getTheObject()).initializeOnCreation();
    }

    
}

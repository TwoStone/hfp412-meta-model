package persistence;



public class CONCNamedEntityICProxi extends NamedEntityICProxi implements PersistentCONCNamedEntity{
    
    public CONCNamedEntityICProxi(long objectId) {
        super(objectId);
    }
    public CONCNamedEntityICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theCONCNamedEntityFacade
            .getCONCNamedEntity(this.getId());
    }
    
    public long getClassId() {
        return 128;
    }
    
    public PersistentCONCNamedEntity getThis() throws PersistenceException {
        return ((PersistentCONCNamedEntity)this.getTheObject()).getThis();
    }
    
    public void accept(model.visitor.NamedEntityVisitor visitor) throws PersistenceException {
        visitor.handleCONCNamedEntity(this);
    }
    public <R> R accept(model.visitor.NamedEntityReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCONCNamedEntity(this);
    }
    public <E extends model.UserException>  void accept(model.visitor.NamedEntityExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCONCNamedEntity(this);
    }
    public <R, E extends model.UserException> R accept(model.visitor.NamedEntityReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCONCNamedEntity(this);
    }
    public void accept(model.visitor.AnythingVisitor visitor) throws PersistenceException {
        visitor.handleCONCNamedEntity(this);
    }
    public <R> R accept(model.visitor.AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleCONCNamedEntity(this);
    }
    public <E extends model.UserException>  void accept(model.visitor.AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleCONCNamedEntity(this);
    }
    public <R, E extends model.UserException> R accept(model.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleCONCNamedEntity(this);
    }
    
    
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentCONCNamedEntity)this.getTheObject()).initializeOnInstantiation();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentCONCNamedEntity)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentCONCNamedEntity)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentCONCNamedEntity)this.getTheObject()).initializeOnCreation();
    }

    
}

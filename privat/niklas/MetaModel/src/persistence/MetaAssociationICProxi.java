package persistence;



public class MetaAssociationICProxi extends NamedEntityICProxi implements PersistentMetaAssociation{
    
    public MetaAssociationICProxi(long objectId) {
        super(objectId);
    }
    public MetaAssociationICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theMetaAssociationFacade
            .getMetaAssociation(this.getId());
    }
    
    public long getClassId() {
        return 126;
    }
    
    public PersistentAbstractMetaType getFromType() throws PersistenceException {
        return ((PersistentMetaAssociation)this.getTheObject()).getFromType();
    }
    public void setFromType(PersistentAbstractMetaType newValue) throws PersistenceException {
        ((PersistentMetaAssociation)this.getTheObject()).setFromType(newValue);
    }
    public PersistentAbstractMetaType getToType() throws PersistenceException {
        return ((PersistentMetaAssociation)this.getTheObject()).getToType();
    }
    public void setToType(PersistentAbstractMetaType newValue) throws PersistenceException {
        ((PersistentMetaAssociation)this.getTheObject()).setToType(newValue);
    }
    public MetaAssociation_HierarchiesProxi getHierarchies() throws PersistenceException {
        return ((PersistentMetaAssociation)this.getTheObject()).getHierarchies();
    }
    public PersistentMetaAssociation getThis() throws PersistenceException {
        return ((PersistentMetaAssociation)this.getTheObject()).getThis();
    }
    
    public void accept(model.visitor.NamedEntityVisitor visitor) throws PersistenceException {
        visitor.handleMetaAssociation(this);
    }
    public <R> R accept(model.visitor.NamedEntityReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMetaAssociation(this);
    }
    public <E extends model.UserException>  void accept(model.visitor.NamedEntityExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMetaAssociation(this);
    }
    public <R, E extends model.UserException> R accept(model.visitor.NamedEntityReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMetaAssociation(this);
    }
    public void accept(model.visitor.AnythingVisitor visitor) throws PersistenceException {
        visitor.handleMetaAssociation(this);
    }
    public <R> R accept(model.visitor.AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMetaAssociation(this);
    }
    public <E extends model.UserException>  void accept(model.visitor.AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMetaAssociation(this);
    }
    public <R, E extends model.UserException> R accept(model.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMetaAssociation(this);
    }
    
    
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentMetaAssociation)this.getTheObject()).initializeOnInstantiation();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentMetaAssociation)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentMetaAssociation)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentMetaAssociation)this.getTheObject()).initializeOnCreation();
    }

    
}

package persistence;



public class MetaAssociationProxi extends NamedEntityProxi implements PersistentMetaAssociation{
    
    public MetaAssociationProxi(long objectId) {
        super(objectId);
    }
    public MetaAssociationProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theMetaAssociationFacade
            .getMetaAssociation(this.getId());
    }
    
    public long getClassId() {
        return 126;
    }
    
    public PersistentAbstractMetaType getSource() throws PersistenceException {
        return ((PersistentMetaAssociation)this.getTheObject()).getSource();
    }
    public void setSource(PersistentAbstractMetaType newValue) throws PersistenceException {
        ((PersistentMetaAssociation)this.getTheObject()).setSource(newValue);
    }
    public PersistentAbstractMetaType getTarget() throws PersistenceException {
        return ((PersistentMetaAssociation)this.getTheObject()).getTarget();
    }
    public void setTarget(PersistentAbstractMetaType newValue) throws PersistenceException {
        ((PersistentMetaAssociation)this.getTheObject()).setTarget(newValue);
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

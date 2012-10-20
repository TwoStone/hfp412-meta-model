package persistence;



public class MetaTypeProxi extends AbstractMetaTypeProxi implements PersistentMetaType{
    
    public MetaTypeProxi(long objectId) {
        super(objectId);
    }
    public MetaTypeProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theMetaTypeFacade
            .getMetaType(this.getId());
    }
    
    public long getClassId() {
        return 122;
    }
    
    public MetaType_SubtypesProxi getSubtypes() throws PersistenceException {
        return ((PersistentMetaType)this.getTheObject()).getSubtypes();
    }
    public PersistentMetaAspect getMyAspect() throws PersistenceException {
        return ((PersistentMetaType)this.getTheObject()).getMyAspect();
    }
    public void setMyAspect(PersistentMetaAspect newValue) throws PersistenceException {
        ((PersistentMetaType)this.getTheObject()).setMyAspect(newValue);
    }
    public PersistentNamedEntity getMyCONCNamedEntity() throws PersistenceException {
        return ((PersistentMetaType)this.getTheObject()).getMyCONCNamedEntity();
    }
    public void setMyCONCNamedEntity(PersistentNamedEntity newValue) throws PersistenceException {
        ((PersistentMetaType)this.getTheObject()).setMyCONCNamedEntity(newValue);
    }
    public PersistentMetaType getThis() throws PersistenceException {
        return ((PersistentMetaType)this.getTheObject()).getThis();
    }
    public String getName() throws PersistenceException {
        return ((PersistentMetaType)this.getTheObject()).getName();
    }
    public void setName(String newValue) throws PersistenceException {
        ((PersistentMetaType)this.getTheObject()).setName(newValue);
    }
    
    public void accept(model.visitor.AbstractMetaTypeVisitor visitor) throws PersistenceException {
        visitor.handleMetaType(this);
    }
    public <R> R accept(model.visitor.AbstractMetaTypeReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMetaType(this);
    }
    public <E extends model.UserException>  void accept(model.visitor.AbstractMetaTypeExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMetaType(this);
    }
    public <R, E extends model.UserException> R accept(model.visitor.AbstractMetaTypeReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMetaType(this);
    }
    public void accept(model.visitor.AnythingVisitor visitor) throws PersistenceException {
        visitor.handleMetaType(this);
    }
    public <R> R accept(model.visitor.AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMetaType(this);
    }
    public <E extends model.UserException>  void accept(model.visitor.AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMetaType(this);
    }
    public <R, E extends model.UserException> R accept(model.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMetaType(this);
    }
    public void accept(model.visitor.NamedEntityVisitor visitor) throws PersistenceException {
        visitor.handleMetaType(this);
    }
    public <R> R accept(model.visitor.NamedEntityReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMetaType(this);
    }
    public <E extends model.UserException>  void accept(model.visitor.NamedEntityExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMetaType(this);
    }
    public <R, E extends model.UserException> R accept(model.visitor.NamedEntityReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMetaType(this);
    }
    
    
    public MetaTypeSearchList inverseGetSubtypes() 
				throws PersistenceException{
        return ((PersistentMetaType)this.getTheObject()).inverseGetSubtypes();
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentMetaType)this.getTheObject()).initializeOnInstantiation();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentMetaType)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentMetaType)this.getTheObject()).initialize(This, final$$Fields);
    }
    public java.lang.Boolean specializes(final PersistentAbstractMetaType metaType) 
				throws PersistenceException{
        return ((PersistentMetaType)this.getTheObject()).specializes(metaType);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentMetaType)this.getTheObject()).initializeOnCreation();
    }

    
}

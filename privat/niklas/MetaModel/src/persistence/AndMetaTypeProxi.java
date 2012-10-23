package persistence;



public class AndMetaTypeProxi extends ComposedMetaTypeProxi implements PersistentAndMetaType{
    
    public AndMetaTypeProxi(long objectId) {
        super(objectId);
    }
    public AndMetaTypeProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theAndMetaTypeFacade
            .getAndMetaType(this.getId());
    }
    
    public long getClassId() {
        return 118;
    }
    
    public PersistentAndMetaType getThis() throws PersistenceException {
        return ((PersistentAndMetaType)this.getTheObject()).getThis();
    }
    
    public void accept(model.visitor.ComposedMetaTypeVisitor visitor) throws PersistenceException {
        visitor.handleAndMetaType(this);
    }
    public <R> R accept(model.visitor.ComposedMetaTypeReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAndMetaType(this);
    }
    public <E extends model.UserException>  void accept(model.visitor.ComposedMetaTypeExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAndMetaType(this);
    }
    public <R, E extends model.UserException> R accept(model.visitor.ComposedMetaTypeReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAndMetaType(this);
    }
    public void accept(model.visitor.AbstractMetaTypeVisitor visitor) throws PersistenceException {
        visitor.handleAndMetaType(this);
    }
    public <R> R accept(model.visitor.AbstractMetaTypeReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAndMetaType(this);
    }
    public <E extends model.UserException>  void accept(model.visitor.AbstractMetaTypeExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAndMetaType(this);
    }
    public <R, E extends model.UserException> R accept(model.visitor.AbstractMetaTypeReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAndMetaType(this);
    }
    public void accept(model.visitor.AnythingVisitor visitor) throws PersistenceException {
        visitor.handleAndMetaType(this);
    }
    public <R> R accept(model.visitor.AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleAndMetaType(this);
    }
    public <E extends model.UserException>  void accept(model.visitor.AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleAndMetaType(this);
    }
    public <R, E extends model.UserException> R accept(model.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleAndMetaType(this);
    }
    
    
    public PersistentOrMetaType getDisjunctiveNormalform(final TDObserver observer) 
				throws PersistenceException{
        return ((PersistentAndMetaType)this.getTheObject()).getDisjunctiveNormalform(observer);
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentAndMetaType)this.getTheObject()).initializeOnInstantiation();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentAndMetaType)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public PersistentOrMetaType getDisjunctiveNormalform() 
				throws PersistenceException{
        return ((PersistentAndMetaType)this.getTheObject()).getDisjunctiveNormalform();
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentAndMetaType)this.getTheObject()).initialize(This, final$$Fields);
    }
    public java.lang.Boolean specializes(final PersistentAbstractMetaType metaType) 
				throws PersistenceException{
        return ((PersistentAndMetaType)this.getTheObject()).specializes(metaType);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentAndMetaType)this.getTheObject()).initializeOnCreation();
    }

    
}

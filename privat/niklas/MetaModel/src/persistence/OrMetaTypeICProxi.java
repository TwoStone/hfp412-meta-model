package persistence;



public class OrMetaTypeICProxi extends ComposedMetaTypeICProxi implements PersistentOrMetaType{
    
    public OrMetaTypeICProxi(long objectId) {
        super(objectId);
    }
    public OrMetaTypeICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theOrMetaTypeFacade
            .getOrMetaType(this.getId());
    }
    
    public long getClassId() {
        return 117;
    }
    
    public PersistentOrMetaType getThis() throws PersistenceException {
        return ((PersistentOrMetaType)this.getTheObject()).getThis();
    }
    
    public void accept(model.visitor.ComposedMetaTypeVisitor visitor) throws PersistenceException {
        visitor.handleOrMetaType(this);
    }
    public <R> R accept(model.visitor.ComposedMetaTypeReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleOrMetaType(this);
    }
    public <E extends model.UserException>  void accept(model.visitor.ComposedMetaTypeExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleOrMetaType(this);
    }
    public <R, E extends model.UserException> R accept(model.visitor.ComposedMetaTypeReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleOrMetaType(this);
    }
    public void accept(model.visitor.AbstractMetaTypeVisitor visitor) throws PersistenceException {
        visitor.handleOrMetaType(this);
    }
    public <R> R accept(model.visitor.AbstractMetaTypeReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleOrMetaType(this);
    }
    public <E extends model.UserException>  void accept(model.visitor.AbstractMetaTypeExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleOrMetaType(this);
    }
    public <R, E extends model.UserException> R accept(model.visitor.AbstractMetaTypeReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleOrMetaType(this);
    }
    public void accept(model.visitor.AnythingVisitor visitor) throws PersistenceException {
        visitor.handleOrMetaType(this);
    }
    public <R> R accept(model.visitor.AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleOrMetaType(this);
    }
    public <E extends model.UserException>  void accept(model.visitor.AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleOrMetaType(this);
    }
    public <R, E extends model.UserException> R accept(model.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleOrMetaType(this);
    }
    
    
    public PersistentOrMetaType getDisjunctiveNormalform(final TDObserver observer) 
				throws PersistenceException{
        return ((PersistentOrMetaType)this.getTheObject()).getDisjunctiveNormalform(observer);
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentOrMetaType)this.getTheObject()).initializeOnInstantiation();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentOrMetaType)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public PersistentOrMetaType getDisjunctiveNormalform() 
				throws PersistenceException{
        return ((PersistentOrMetaType)this.getTheObject()).getDisjunctiveNormalform();
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentOrMetaType)this.getTheObject()).initialize(This, final$$Fields);
    }
    public java.lang.Boolean specializes(final PersistentAbstractMetaType metaType) 
				throws PersistenceException{
        return ((PersistentOrMetaType)this.getTheObject()).specializes(metaType);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentOrMetaType)this.getTheObject()).initializeOnCreation();
    }

    
}

package persistence;



public class MProductTypeProxi extends MComplexTypeProxi implements PersistentMProductType{
    
    public MProductTypeProxi(long objectId) {
        super(objectId);
    }
    public MProductTypeProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theMProductTypeFacade
            .getMProductType(this.getId());
    }
    
    public long getClassId() {
        return 138;
    }
    
    public PersistentMProductType getThis() throws PersistenceException {
        return ((PersistentMProductType)this.getTheObject()).getThis();
    }
    
    public void accept(model.visitor.MComplexTypeVisitor visitor) throws PersistenceException {
        visitor.handleMProductType(this);
    }
    public <R> R accept(model.visitor.MComplexTypeReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMProductType(this);
    }
    public <E extends model.UserException>  void accept(model.visitor.MComplexTypeExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMProductType(this);
    }
    public <R, E extends model.UserException> R accept(model.visitor.MComplexTypeReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMProductType(this);
    }
    public void accept(model.visitor.MTypeVisitor visitor) throws PersistenceException {
        visitor.handleMProductType(this);
    }
    public <R> R accept(model.visitor.MTypeReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMProductType(this);
    }
    public <E extends model.UserException>  void accept(model.visitor.MTypeExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMProductType(this);
    }
    public <R, E extends model.UserException> R accept(model.visitor.MTypeReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMProductType(this);
    }
    public void accept(model.visitor.MCTypeHierarchyHIERARCHYVisitor visitor) throws PersistenceException {
        visitor.handleMProductType(this);
    }
    public <R> R accept(model.visitor.MCTypeHierarchyHIERARCHYReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMProductType(this);
    }
    public <E extends model.UserException>  void accept(model.visitor.MCTypeHierarchyHIERARCHYExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMProductType(this);
    }
    public <R, E extends model.UserException> R accept(model.visitor.MCTypeHierarchyHIERARCHYReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMProductType(this);
    }
    public void accept(model.visitor.AnythingVisitor visitor) throws PersistenceException {
        visitor.handleMProductType(this);
    }
    public <R> R accept(model.visitor.AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMProductType(this);
    }
    public <E extends model.UserException>  void accept(model.visitor.AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMProductType(this);
    }
    public <R, E extends model.UserException> R accept(model.visitor.AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMProductType(this);
    }
    
    
    public boolean containsMCTypeHierarchy(final MCTypeHierarchyHIERARCHY part) 
				throws PersistenceException{
        return ((PersistentMProductType)this.getTheObject()).containsMCTypeHierarchy(part);
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentMProductType)this.getTheObject()).initializeOnInstantiation();
    }
    public <T> T strategyMCTypeHierarchy(final T parameter, final MCTypeHierarchyHIERARCHYStrategy<T> strategy) 
				throws PersistenceException{
        return ((PersistentMProductType)this.getTheObject()).strategyMCTypeHierarchy(parameter, strategy);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentMProductType)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public String fetchName() 
				throws PersistenceException{
        return ((PersistentMProductType)this.getTheObject()).fetchName();
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentMProductType)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentMProductType)this.getTheObject()).initializeOnCreation();
    }
    public String getTypeLinkOperator() 
				throws PersistenceException{
        return ((PersistentMProductType)this.getTheObject()).getTypeLinkOperator();
    }

    
}

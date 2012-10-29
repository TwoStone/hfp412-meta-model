package persistence;

import model.UserException;

import model.visitor.*;

public class MAtomicTypeICProxi extends PersistentInCacheProxiOptimistic implements PersistentMAtomicType{
    
    public MAtomicTypeICProxi(long objectId) {
        super(objectId);
    }
    public MAtomicTypeICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theMAtomicTypeFacade
            .getMAtomicType(this.getId());
    }
    
    public long getClassId() {
        return 102;
    }
    
    public String getName() throws PersistenceException {
        return ((PersistentMAtomicType)this.getTheObject()).getName();
    }
    public void setName(String newValue) throws PersistenceException {
        ((PersistentMAtomicType)this.getTheObject()).setName(newValue);
    }
    public PersistentMAspect getAspect() throws PersistenceException {
        return ((PersistentMAtomicType)this.getTheObject()).getAspect();
    }
    public void setAspect(PersistentMAspect newValue) throws PersistenceException {
        ((PersistentMAtomicType)this.getTheObject()).setAspect(newValue);
    }
    public PersistentMAtomicType getThis() throws PersistenceException {
        return ((PersistentMAtomicType)this.getTheObject()).getThis();
    }
    
    public void accept(MTypeVisitor visitor) throws PersistenceException {
        visitor.handleMAtomicType(this);
    }
    public <R> R accept(MTypeReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMAtomicType(this);
    }
    public <E extends UserException>  void accept(MTypeExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMAtomicType(this);
    }
    public <R, E extends UserException> R accept(MTypeReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMAtomicType(this);
    }
    public void accept(MCTypeHierarchyHIERARCHYVisitor visitor) throws PersistenceException {
        visitor.handleMAtomicType(this);
    }
    public <R> R accept(MCTypeHierarchyHIERARCHYReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMAtomicType(this);
    }
    public <E extends UserException>  void accept(MCTypeHierarchyHIERARCHYExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMAtomicType(this);
    }
    public <R, E extends UserException> R accept(MCTypeHierarchyHIERARCHYReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMAtomicType(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleMAtomicType(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMAtomicType(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMAtomicType(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMAtomicType(this);
    }
    
    
    public boolean containsMCTypeHierarchy(final MCTypeHierarchyHIERARCHY part) 
				throws PersistenceException{
        return ((PersistentMAtomicType)this.getTheObject()).containsMCTypeHierarchy(part);
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentMAtomicType)this.getTheObject()).initializeOnInstantiation();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentMAtomicType)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public <T> T strategyMCTypeHierarchy(final T parameter, final MCTypeHierarchyHIERARCHYStrategy<T> strategy) 
				throws PersistenceException{
        return ((PersistentMAtomicType)this.getTheObject()).strategyMCTypeHierarchy(parameter, strategy);
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentMAtomicType)this.getTheObject()).initialize(This, final$$Fields);
    }
    public String fetchName() 
				throws PersistenceException{
        return ((PersistentMAtomicType)this.getTheObject()).fetchName();
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentMAtomicType)this.getTheObject()).initializeOnCreation();
    }

    
}

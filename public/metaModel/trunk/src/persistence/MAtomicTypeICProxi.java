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
    public PersistentMAtomicType getSuperType() throws PersistenceException {
        return ((PersistentMAtomicType)this.getTheObject()).getSuperType();
    }
    public void setSuperType(PersistentMAtomicType newValue) throws PersistenceException , model.CycleException{
        ((PersistentMAtomicType)this.getTheObject()).setSuperType(newValue);
    }
    public PersistentMAtomicType getThis() throws PersistenceException {
        return ((PersistentMAtomicType)this.getTheObject()).getThis();
    }
    
    public void accept(MComplexTypeHierarchyHIERARCHYVisitor visitor) throws PersistenceException {
        visitor.handleMAtomicType(this);
    }
    public <R> R accept(MComplexTypeHierarchyHIERARCHYReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMAtomicType(this);
    }
    public <E extends UserException>  void accept(MComplexTypeHierarchyHIERARCHYExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMAtomicType(this);
    }
    public <R, E extends UserException> R accept(MComplexTypeHierarchyHIERARCHYReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMAtomicType(this);
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
    public void accept(MAtomicTypeHierarchyHIERARCHYVisitor visitor) throws PersistenceException {
        visitor.handleMAtomicType(this);
    }
    public <R> R accept(MAtomicTypeHierarchyHIERARCHYReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMAtomicType(this);
    }
    public <E extends UserException>  void accept(MAtomicTypeHierarchyHIERARCHYExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMAtomicType(this);
    }
    public <R, E extends UserException> R accept(MAtomicTypeHierarchyHIERARCHYReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
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
    
    
    public <T> T strategyMAtomicTypeHierarchy(final T parameter, final MAtomicTypeHierarchyHIERARCHYStrategy<T> strategy) 
				throws PersistenceException{
        return ((PersistentMAtomicType)this.getTheObject()).strategyMAtomicTypeHierarchy(parameter, strategy);
    }
    public boolean containsMAtomicTypeHierarchy(final MAtomicTypeHierarchyHIERARCHY part) 
				throws PersistenceException{
        return ((PersistentMAtomicType)this.getTheObject()).containsMAtomicTypeHierarchy(part);
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentMAtomicType)this.getTheObject()).initializeOnInstantiation();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentMAtomicType)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public boolean containsMComplexTypeHierarchy(final MComplexTypeHierarchyHIERARCHY part) 
				throws PersistenceException{
        return ((PersistentMAtomicType)this.getTheObject()).containsMComplexTypeHierarchy(part);
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentMAtomicType)this.getTheObject()).initialize(This, final$$Fields);
    }
    public String fetchName() 
				throws PersistenceException{
        return ((PersistentMAtomicType)this.getTheObject()).fetchName();
    }
    public <T> T strategyMComplexTypeHierarchy(final T parameter, final MComplexTypeHierarchyHIERARCHYStrategy<T> strategy) 
				throws PersistenceException{
        return ((PersistentMAtomicType)this.getTheObject()).strategyMComplexTypeHierarchy(parameter, strategy);
    }
    public PersistentMBoolean lessOrEqual(final MType otherType) 
				throws PersistenceException{
        return ((PersistentMAtomicType)this.getTheObject()).lessOrEqual(otherType);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentMAtomicType)this.getTheObject()).initializeOnCreation();
    }
    public void addSubType(final PersistentMAtomicType typeunder) 
				throws model.WrongSubTypeAspectException, model.CycleException, PersistenceException{
        ((PersistentMAtomicType)this.getTheObject()).addSubType(typeunder);
    }
    public MAtomicTypeSearchList getSubTypes() 
				throws PersistenceException{
        return ((PersistentMAtomicType)this.getTheObject()).getSubTypes();
    }

    
}

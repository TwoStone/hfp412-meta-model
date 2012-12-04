package persistence;

import model.UserException;

import model.visitor.*;

public class MAtomicTypeProxi extends PersistentProxi implements PersistentMAtomicType{
    
    public MAtomicTypeProxi(long objectId) {
        super(objectId);
    }
    public MAtomicTypeProxi(PersistentInCacheProxi object) {
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
    public PersistentMBoolean getSingletonType() throws PersistenceException {
        return ((PersistentMAtomicType)this.getTheObject()).getSingletonType();
    }
    public void setSingletonType(PersistentMBoolean newValue) throws PersistenceException {
        ((PersistentMAtomicType)this.getTheObject()).setSingletonType(newValue);
    }
    public PersistentMBoolean getAbstractType() throws PersistenceException {
        return ((PersistentMAtomicType)this.getTheObject()).getAbstractType();
    }
    public void setAbstractType(PersistentMBoolean newValue) throws PersistenceException {
        ((PersistentMAtomicType)this.getTheObject()).setAbstractType(newValue);
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
    
    
    public boolean containsMAtomicTypeHierarchy(final MAtomicTypeHierarchyHIERARCHY part) 
				throws PersistenceException{
        return ((PersistentMAtomicType)this.getTheObject()).containsMAtomicTypeHierarchy(part);
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentMAtomicType)this.getTheObject()).initializeOnInstantiation();
    }
    public PersistentMBoolean isStructuralEqual(final MType otherType) 
				throws PersistenceException{
        return ((PersistentMAtomicType)this.getTheObject()).isStructuralEqual(otherType);
    }
    public boolean containsMComplexTypeHierarchy(final MComplexTypeHierarchyHIERARCHY part) 
				throws PersistenceException{
        return ((PersistentMAtomicType)this.getTheObject()).containsMComplexTypeHierarchy(part);
    }
    public String fetchName() 
				throws PersistenceException{
        return ((PersistentMAtomicType)this.getTheObject()).fetchName();
    }
    public PersistentMBoolean isLessOrEqual(final MType otherType) 
				throws PersistenceException{
        return ((PersistentMAtomicType)this.getTheObject()).isLessOrEqual(otherType);
    }
    public <T> T strategyMComplexTypeHierarchy(final T parameter, final MComplexTypeHierarchyHIERARCHYStrategy<T> strategy) 
				throws PersistenceException{
        return ((PersistentMAtomicType)this.getTheObject()).strategyMComplexTypeHierarchy(parameter, strategy);
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
    public <T> T strategyMAtomicTypeHierarchy(final T parameter, final MAtomicTypeHierarchyHIERARCHYStrategy<T> strategy) 
				throws PersistenceException{
        return ((PersistentMAtomicType)this.getTheObject()).strategyMAtomicTypeHierarchy(parameter, strategy);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentMAtomicType)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public PersistentMBoolean contains(final MType otherType) 
				throws PersistenceException{
        return ((PersistentMAtomicType)this.getTheObject()).contains(otherType);
    }
    public MAssociationSearchList fetchAssociations() 
				throws PersistenceException{
        return ((PersistentMAtomicType)this.getTheObject()).fetchAssociations();
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentMAtomicType)this.getTheObject()).initialize(This, final$$Fields);
    }
    public PersistentMBoolean allObjectsOfTypeAreSingleton() 
				throws PersistenceException{
        return ((PersistentMAtomicType)this.getTheObject()).allObjectsOfTypeAreSingleton();
    }
    public PersistentMBoolean isAbstract() 
				throws PersistenceException{
        return ((PersistentMAtomicType)this.getTheObject()).isAbstract();
    }

    
}
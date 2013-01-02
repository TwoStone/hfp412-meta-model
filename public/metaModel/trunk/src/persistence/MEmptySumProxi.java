package persistence;

import model.UserException;

import model.visitor.*;

public class MEmptySumProxi extends MSumTypeProxi implements PersistentMEmptySum{
    
    public MEmptySumProxi(long objectId) {
        super(objectId);
    }
    public MEmptySumProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theMEmptySumFacade
            .getMEmptySum(this.getId());
    }
    
    public long getClassId() {
        return 185;
    }
    
    public PersistentMEmptySum getThis() throws PersistenceException {
        return ((PersistentMEmptySum)this.getTheObject()).getThis();
    }
    
    public void accept(MSumTypeVisitor visitor) throws PersistenceException {
        visitor.handleMEmptySum(this);
    }
    public <R> R accept(MSumTypeReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMEmptySum(this);
    }
    public <E extends UserException>  void accept(MSumTypeExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMEmptySum(this);
    }
    public <R, E extends UserException> R accept(MSumTypeReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMEmptySum(this);
    }
    public void accept(MComplexTypeVisitor visitor) throws PersistenceException {
        visitor.handleMEmptySum(this);
    }
    public <R> R accept(MComplexTypeReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMEmptySum(this);
    }
    public <E extends UserException>  void accept(MComplexTypeExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMEmptySum(this);
    }
    public <R, E extends UserException> R accept(MComplexTypeReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMEmptySum(this);
    }
    public void accept(MComplexTypeHierarchyHIERARCHYVisitor visitor) throws PersistenceException {
        visitor.handleMEmptySum(this);
    }
    public <R> R accept(MComplexTypeHierarchyHIERARCHYReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMEmptySum(this);
    }
    public <E extends UserException>  void accept(MComplexTypeHierarchyHIERARCHYExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMEmptySum(this);
    }
    public <R, E extends UserException> R accept(MComplexTypeHierarchyHIERARCHYReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMEmptySum(this);
    }
    public void accept(MTypeVisitor visitor) throws PersistenceException {
        visitor.handleMEmptySum(this);
    }
    public <R> R accept(MTypeReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMEmptySum(this);
    }
    public <E extends UserException>  void accept(MTypeExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMEmptySum(this);
    }
    public <R, E extends UserException> R accept(MTypeReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMEmptySum(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleMEmptySum(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMEmptySum(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMEmptySum(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMEmptySum(this);
    }
    
    
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentMEmptySum)this.getTheObject()).initializeOnInstantiation();
    }
    public PersistentMProductType transientAddFactor(final MType factor) 
				throws model.ConsistencyException, PersistenceException{
        return ((PersistentMEmptySum)this.getTheObject()).transientAddFactor(factor);
    }
    public boolean containsMComplexTypeHierarchy(final MComplexTypeHierarchyHIERARCHY part) 
				throws PersistenceException{
        return ((PersistentMEmptySum)this.getTheObject()).containsMComplexTypeHierarchy(part);
    }
    public PersistentMBoolean isStructuralEqual(final MType otherType) 
				throws PersistenceException{
        return ((PersistentMEmptySum)this.getTheObject()).isStructuralEqual(otherType);
    }
    public String fetchName() 
				throws PersistenceException{
        return ((PersistentMEmptySum)this.getTheObject()).fetchName();
    }
    public PersistentMSumType transientAddAddend(final MType addend) 
				throws model.ConsistencyException, PersistenceException{
        return ((PersistentMEmptySum)this.getTheObject()).transientAddAddend(addend);
    }
    public <T> T strategyMComplexTypeHierarchy(final T parameter, final MComplexTypeHierarchyHIERARCHYStrategy<T> strategy) 
				throws PersistenceException{
        return ((PersistentMEmptySum)this.getTheObject()).strategyMComplexTypeHierarchy(parameter, strategy);
    }
    public PersistentMBoolean isLessOrEqual(final MType otherType) 
				throws PersistenceException{
        return ((PersistentMEmptySum)this.getTheObject()).isLessOrEqual(otherType);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentMEmptySum)this.getTheObject()).initializeOnCreation();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentMEmptySum)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public PersistentMBoolean contains(final MType otherType) 
				throws PersistenceException{
        return ((PersistentMEmptySum)this.getTheObject()).contains(otherType);
    }
    public MAssociationSearchList fetchAssociations() 
				throws PersistenceException{
        return ((PersistentMEmptySum)this.getTheObject()).fetchAssociations();
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentMEmptySum)this.getTheObject()).initialize(This, final$$Fields);
    }
    public PersistentMBoolean isSingleton() 
				throws PersistenceException{
        return ((PersistentMEmptySum)this.getTheObject()).isSingleton();
    }
    public PersistentMSumType fetchDisjunctiveNormalform() 
				throws PersistenceException{
        return ((PersistentMEmptySum)this.getTheObject()).fetchDisjunctiveNormalform();
    }
    public String getTypeLinkOperator() 
				throws PersistenceException{
        return ((PersistentMEmptySum)this.getTheObject()).getTypeLinkOperator();
    }
    public PersistentMBoolean isAbstract() 
				throws PersistenceException{
        return ((PersistentMEmptySum)this.getTheObject()).isAbstract();
    }
    public PersistentMBoolean allObjectsOfTypeAreSingleton() 
				throws PersistenceException{
        return ((PersistentMEmptySum)this.getTheObject()).allObjectsOfTypeAreSingleton();
    }

    
}

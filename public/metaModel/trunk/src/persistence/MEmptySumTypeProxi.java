package persistence;

import model.UserException;

import model.visitor.*;

public class MEmptySumTypeProxi extends MAbstractSumTypeProxi implements PersistentMEmptySumType{
    
    public MEmptySumTypeProxi(long objectId) {
        super(objectId);
    }
    public MEmptySumTypeProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theMEmptySumTypeFacade
            .getMEmptySumType(this.getId());
    }
    
    public long getClassId() {
        return 185;
    }
    
    public PersistentMEmptySumType getThis() throws PersistenceException {
        return ((PersistentMEmptySumType)this.getTheObject()).getThis();
    }
    
    public void accept(MAbstractSumTypeVisitor visitor) throws PersistenceException {
        visitor.handleMEmptySumType(this);
    }
    public <R> R accept(MAbstractSumTypeReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMEmptySumType(this);
    }
    public <E extends UserException>  void accept(MAbstractSumTypeExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMEmptySumType(this);
    }
    public <R, E extends UserException> R accept(MAbstractSumTypeReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMEmptySumType(this);
    }
    public void accept(MComplexTypeVisitor visitor) throws PersistenceException {
        visitor.handleMEmptySumType(this);
    }
    public <R> R accept(MComplexTypeReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMEmptySumType(this);
    }
    public <E extends UserException>  void accept(MComplexTypeExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMEmptySumType(this);
    }
    public <R, E extends UserException> R accept(MComplexTypeReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMEmptySumType(this);
    }
    public void accept(MTypeVisitor visitor) throws PersistenceException {
        visitor.handleMEmptySumType(this);
    }
    public <R> R accept(MTypeReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMEmptySumType(this);
    }
    public <E extends UserException>  void accept(MTypeExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMEmptySumType(this);
    }
    public <R, E extends UserException> R accept(MTypeReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMEmptySumType(this);
    }
    public void accept(MComplexTypeHierarchyHIERARCHYVisitor visitor) throws PersistenceException {
        visitor.handleMEmptySumType(this);
    }
    public <R> R accept(MComplexTypeHierarchyHIERARCHYReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMEmptySumType(this);
    }
    public <E extends UserException>  void accept(MComplexTypeHierarchyHIERARCHYExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMEmptySumType(this);
    }
    public <R, E extends UserException> R accept(MComplexTypeHierarchyHIERARCHYReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMEmptySumType(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleMEmptySumType(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMEmptySumType(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMEmptySumType(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMEmptySumType(this);
    }
    
    
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentMEmptySumType)this.getTheObject()).initializeOnInstantiation();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentMEmptySumType)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public boolean containsMComplexTypeHierarchy(final MComplexTypeHierarchyHIERARCHY part) 
				throws PersistenceException{
        return ((PersistentMEmptySumType)this.getTheObject()).containsMComplexTypeHierarchy(part);
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentMEmptySumType)this.getTheObject()).initialize(This, final$$Fields);
    }
    public PersistentMBoolean isStructuralEquivalant(final PersistentMType other) 
				throws PersistenceException{
        return ((PersistentMEmptySumType)this.getTheObject()).isStructuralEquivalant(other);
    }
    public String fetchName() 
				throws PersistenceException{
        return ((PersistentMEmptySumType)this.getTheObject()).fetchName();
    }
    public <T> T strategyMComplexTypeHierarchy(final T parameter, final MComplexTypeHierarchyHIERARCHYStrategy<T> strategy) 
				throws PersistenceException{
        return ((PersistentMEmptySumType)this.getTheObject()).strategyMComplexTypeHierarchy(parameter, strategy);
    }
    public String fetchTypeLinkOperator() 
				throws PersistenceException{
        return ((PersistentMEmptySumType)this.getTheObject()).fetchTypeLinkOperator();
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentMEmptySumType)this.getTheObject()).initializeOnCreation();
    }
    public PersistentMBoolean isSingleton() 
				throws PersistenceException{
        return ((PersistentMEmptySumType)this.getTheObject()).isSingleton();
    }
    public PersistentMBoolean isLessOrEqual() 
				throws PersistenceException{
        return ((PersistentMEmptySumType)this.getTheObject()).isLessOrEqual();
    }
    public PersistentMBoolean isAbstract() 
				throws PersistenceException{
        return ((PersistentMEmptySumType)this.getTheObject()).isAbstract();
    }

    
}

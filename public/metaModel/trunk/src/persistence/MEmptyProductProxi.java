package persistence;

import model.UserException;

import model.visitor.*;

public class MEmptyProductProxi extends MAbstractProductTypeProxi implements PersistentMEmptyProduct{
    
    public MEmptyProductProxi(long objectId) {
        super(objectId);
    }
    public MEmptyProductProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theMEmptyProductFacade
            .getMEmptyProduct(this.getId());
    }
    
    public long getClassId() {
        return 107;
    }
    
    public PersistentMEmptyProduct getThis() throws PersistenceException {
        return ((PersistentMEmptyProduct)this.getTheObject()).getThis();
    }
    
    public void accept(MAbstractProductTypeVisitor visitor) throws PersistenceException {
        visitor.handleMEmptyProduct(this);
    }
    public <R> R accept(MAbstractProductTypeReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMEmptyProduct(this);
    }
    public <E extends UserException>  void accept(MAbstractProductTypeExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMEmptyProduct(this);
    }
    public <R, E extends UserException> R accept(MAbstractProductTypeReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMEmptyProduct(this);
    }
    public void accept(MComplexTypeVisitor visitor) throws PersistenceException {
        visitor.handleMEmptyProduct(this);
    }
    public <R> R accept(MComplexTypeReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMEmptyProduct(this);
    }
    public <E extends UserException>  void accept(MComplexTypeExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMEmptyProduct(this);
    }
    public <R, E extends UserException> R accept(MComplexTypeReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMEmptyProduct(this);
    }
    public void accept(MTypeVisitor visitor) throws PersistenceException {
        visitor.handleMEmptyProduct(this);
    }
    public <R> R accept(MTypeReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMEmptyProduct(this);
    }
    public <E extends UserException>  void accept(MTypeExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMEmptyProduct(this);
    }
    public <R, E extends UserException> R accept(MTypeReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMEmptyProduct(this);
    }
    public void accept(MComplexTypeHierarchyHIERARCHYVisitor visitor) throws PersistenceException {
        visitor.handleMEmptyProduct(this);
    }
    public <R> R accept(MComplexTypeHierarchyHIERARCHYReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMEmptyProduct(this);
    }
    public <E extends UserException>  void accept(MComplexTypeHierarchyHIERARCHYExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMEmptyProduct(this);
    }
    public <R, E extends UserException> R accept(MComplexTypeHierarchyHIERARCHYReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMEmptyProduct(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleMEmptyProduct(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMEmptyProduct(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMEmptyProduct(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMEmptyProduct(this);
    }
    
    
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentMEmptyProduct)this.getTheObject()).initializeOnInstantiation();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentMEmptyProduct)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public boolean containsMComplexTypeHierarchy(final MComplexTypeHierarchyHIERARCHY part) 
				throws PersistenceException{
        return ((PersistentMEmptyProduct)this.getTheObject()).containsMComplexTypeHierarchy(part);
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentMEmptyProduct)this.getTheObject()).initialize(This, final$$Fields);
    }
    public PersistentMBoolean isStructuralEquivalant(final PersistentMType other) 
				throws PersistenceException{
        return ((PersistentMEmptyProduct)this.getTheObject()).isStructuralEquivalant(other);
    }
    public String fetchName() 
				throws PersistenceException{
        return ((PersistentMEmptyProduct)this.getTheObject()).fetchName();
    }
    public <T> T strategyMComplexTypeHierarchy(final T parameter, final MComplexTypeHierarchyHIERARCHYStrategy<T> strategy) 
				throws PersistenceException{
        return ((PersistentMEmptyProduct)this.getTheObject()).strategyMComplexTypeHierarchy(parameter, strategy);
    }
    public String fetchTypeLinkOperator() 
				throws PersistenceException{
        return ((PersistentMEmptyProduct)this.getTheObject()).fetchTypeLinkOperator();
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentMEmptyProduct)this.getTheObject()).initializeOnCreation();
    }
    public PersistentMBoolean isSingleton() 
				throws PersistenceException{
        return ((PersistentMEmptyProduct)this.getTheObject()).isSingleton();
    }
    public PersistentMBoolean isLessOrEqual() 
				throws PersistenceException{
        return ((PersistentMEmptyProduct)this.getTheObject()).isLessOrEqual();
    }
    public PersistentMBoolean isAbstract() 
				throws PersistenceException{
        return ((PersistentMEmptyProduct)this.getTheObject()).isAbstract();
    }

    
}

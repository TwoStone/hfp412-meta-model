package persistence;

import model.UserException;

import model.visitor.*;

public class MEmptyProductICProxi extends MProductTypeICProxi implements PersistentMEmptyProduct{
    
    public MEmptyProductICProxi(long objectId) {
        super(objectId);
    }
    public MEmptyProductICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theMEmptyProductFacade
            .getMEmptyProduct(this.getId());
    }
    
    public long getClassId() {
        return 186;
    }
    
    public PersistentMEmptyProduct getThis() throws PersistenceException {
        return ((PersistentMEmptyProduct)this.getTheObject()).getThis();
    }
    
    public void accept(MProductTypeVisitor visitor) throws PersistenceException {
        visitor.handleMEmptyProduct(this);
    }
    public <R> R accept(MProductTypeReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMEmptyProduct(this);
    }
    public <E extends UserException>  void accept(MProductTypeExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMEmptyProduct(this);
    }
    public <R, E extends UserException> R accept(MProductTypeReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
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
    public PersistentMProductType transientAddFactor(final MType factor) 
				throws model.ConsistencyException, PersistenceException{
        return ((PersistentMEmptyProduct)this.getTheObject()).transientAddFactor(factor);
    }
    public boolean containsMComplexTypeHierarchy(final MComplexTypeHierarchyHIERARCHY part) 
				throws PersistenceException{
        return ((PersistentMEmptyProduct)this.getTheObject()).containsMComplexTypeHierarchy(part);
    }
    public PersistentMBoolean isStructuralEqual(final MType otherType) 
				throws PersistenceException{
        return ((PersistentMEmptyProduct)this.getTheObject()).isStructuralEqual(otherType);
    }
    public String fetchName() 
				throws PersistenceException{
        return ((PersistentMEmptyProduct)this.getTheObject()).fetchName();
    }
    public PersistentMSumType transientAddAddend(final MType addend) 
				throws model.ConsistencyException, PersistenceException{
        return ((PersistentMEmptyProduct)this.getTheObject()).transientAddAddend(addend);
    }
    public <T> T strategyMComplexTypeHierarchy(final T parameter, final MComplexTypeHierarchyHIERARCHYStrategy<T> strategy) 
				throws PersistenceException{
        return ((PersistentMEmptyProduct)this.getTheObject()).strategyMComplexTypeHierarchy(parameter, strategy);
    }
    public PersistentMBoolean isLessOrEqual(final MType otherType) 
				throws PersistenceException{
        return ((PersistentMEmptyProduct)this.getTheObject()).isLessOrEqual(otherType);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentMEmptyProduct)this.getTheObject()).initializeOnCreation();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentMEmptyProduct)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public PersistentMBoolean contains(final MType otherType) 
				throws PersistenceException{
        return ((PersistentMEmptyProduct)this.getTheObject()).contains(otherType);
    }
    public MAssociationSearchList fetchAssociations() 
				throws PersistenceException{
        return ((PersistentMEmptyProduct)this.getTheObject()).fetchAssociations();
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentMEmptyProduct)this.getTheObject()).initialize(This, final$$Fields);
    }
    public PersistentMBoolean isSingleton() 
				throws PersistenceException{
        return ((PersistentMEmptyProduct)this.getTheObject()).isSingleton();
    }
    public PersistentMSumType fetchDisjunctiveNormalform() 
				throws PersistenceException{
        return ((PersistentMEmptyProduct)this.getTheObject()).fetchDisjunctiveNormalform();
    }
    public String getTypeLinkOperator() 
				throws PersistenceException{
        return ((PersistentMEmptyProduct)this.getTheObject()).getTypeLinkOperator();
    }
    public PersistentMBoolean isAbstract() 
				throws PersistenceException{
        return ((PersistentMEmptyProduct)this.getTheObject()).isAbstract();
    }
    public PersistentMBoolean allObjectsOfTypeAreSingleton() 
				throws PersistenceException{
        return ((PersistentMEmptyProduct)this.getTheObject()).allObjectsOfTypeAreSingleton();
    }

    
}

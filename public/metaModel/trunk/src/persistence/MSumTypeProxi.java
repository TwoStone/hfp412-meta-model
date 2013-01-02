package persistence;

import model.UserException;

import model.visitor.*;

public class MSumTypeProxi extends MComplexTypeProxi implements PersistentMSumType{
    
    public MSumTypeProxi(long objectId) {
        super(objectId);
    }
    public MSumTypeProxi(PersistentInCacheProxi object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theMSumTypeFacade
            .getMSumType(this.getId());
    }
    
    public long getClassId() {
        return 103;
    }
    
    public PersistentMSumType getThis() throws PersistenceException {
        return ((PersistentMSumType)this.getTheObject()).getThis();
    }
    
    public void accept(MComplexTypeVisitor visitor) throws PersistenceException {
        visitor.handleMSumType(this);
    }
    public <R> R accept(MComplexTypeReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMSumType(this);
    }
    public <E extends UserException>  void accept(MComplexTypeExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMSumType(this);
    }
    public <R, E extends UserException> R accept(MComplexTypeReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMSumType(this);
    }
    public void accept(MComplexTypeHierarchyHIERARCHYVisitor visitor) throws PersistenceException {
        visitor.handleMSumType(this);
    }
    public <R> R accept(MComplexTypeHierarchyHIERARCHYReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMSumType(this);
    }
    public <E extends UserException>  void accept(MComplexTypeHierarchyHIERARCHYExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMSumType(this);
    }
    public <R, E extends UserException> R accept(MComplexTypeHierarchyHIERARCHYReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMSumType(this);
    }
    public void accept(MTypeVisitor visitor) throws PersistenceException {
        visitor.handleMSumType(this);
    }
    public <R> R accept(MTypeReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMSumType(this);
    }
    public <E extends UserException>  void accept(MTypeExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMSumType(this);
    }
    public <R, E extends UserException> R accept(MTypeReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMSumType(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleMSumType(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMSumType(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMSumType(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMSumType(this);
    }
    
    
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentMSumType)this.getTheObject()).initializeOnInstantiation();
    }
    public PersistentMBoolean isStructuralEqual(final MType otherType) 
				throws PersistenceException{
        return ((PersistentMSumType)this.getTheObject()).isStructuralEqual(otherType);
    }
    public boolean containsMComplexTypeHierarchy(final MComplexTypeHierarchyHIERARCHY part) 
				throws PersistenceException{
        return ((PersistentMSumType)this.getTheObject()).containsMComplexTypeHierarchy(part);
    }
    public String fetchName() 
				throws PersistenceException{
        return ((PersistentMSumType)this.getTheObject()).fetchName();
    }
    public PersistentMBoolean isLessOrEqual(final MType otherType) 
				throws PersistenceException{
        return ((PersistentMSumType)this.getTheObject()).isLessOrEqual(otherType);
    }
    public <T> T strategyMComplexTypeHierarchy(final T parameter, final MComplexTypeHierarchyHIERARCHYStrategy<T> strategy) 
				throws PersistenceException{
        return ((PersistentMSumType)this.getTheObject()).strategyMComplexTypeHierarchy(parameter, strategy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentMSumType)this.getTheObject()).initializeOnCreation();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentMSumType)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public PersistentMBoolean contains(final MType otherType) 
				throws PersistenceException{
        return ((PersistentMSumType)this.getTheObject()).contains(otherType);
    }
    public MAssociationSearchList fetchAssociations() 
				throws PersistenceException{
        return ((PersistentMSumType)this.getTheObject()).fetchAssociations();
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentMSumType)this.getTheObject()).initialize(This, final$$Fields);
    }
    public PersistentMBoolean isSingleton() 
				throws PersistenceException{
        return ((PersistentMSumType)this.getTheObject()).isSingleton();
    }
    public String getTypeLinkOperator() 
				throws PersistenceException{
        return ((PersistentMSumType)this.getTheObject()).getTypeLinkOperator();
    }
    public PersistentMBoolean isAbstract() 
				throws PersistenceException{
        return ((PersistentMSumType)this.getTheObject()).isAbstract();
    }
    public PersistentMBoolean allObjectsOfTypeAreSingleton() 
				throws PersistenceException{
        return ((PersistentMSumType)this.getTheObject()).allObjectsOfTypeAreSingleton();
    }

    
}

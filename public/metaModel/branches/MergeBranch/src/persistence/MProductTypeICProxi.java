package persistence;

import model.UserException;

import model.visitor.*;

public class MProductTypeICProxi extends MComplexTypeICProxi implements PersistentMProductType{
    
    public MProductTypeICProxi(long objectId) {
        super(objectId);
    }
    public MProductTypeICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theMProductTypeFacade
            .getMProductType(this.getId());
    }
    
    public long getClassId() {
        return 101;
    }
    
    public PersistentMProductType getThis() throws PersistenceException {
        return ((PersistentMProductType)this.getTheObject()).getThis();
    }
    
    public void accept(MComplexTypeVisitor visitor) throws PersistenceException {
        visitor.handleMProductType(this);
    }
    public <R> R accept(MComplexTypeReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMProductType(this);
    }
    public <E extends UserException>  void accept(MComplexTypeExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMProductType(this);
    }
    public <R, E extends UserException> R accept(MComplexTypeReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMProductType(this);
    }
    public void accept(MComplexTypeHierarchyHIERARCHYVisitor visitor) throws PersistenceException {
        visitor.handleMProductType(this);
    }
    public <R> R accept(MComplexTypeHierarchyHIERARCHYReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMProductType(this);
    }
    public <E extends UserException>  void accept(MComplexTypeHierarchyHIERARCHYExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMProductType(this);
    }
    public <R, E extends UserException> R accept(MComplexTypeHierarchyHIERARCHYReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMProductType(this);
    }
    public void accept(MTypeVisitor visitor) throws PersistenceException {
        visitor.handleMProductType(this);
    }
    public <R> R accept(MTypeReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMProductType(this);
    }
    public <E extends UserException>  void accept(MTypeExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMProductType(this);
    }
    public <R, E extends UserException> R accept(MTypeReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMProductType(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleMProductType(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMProductType(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMProductType(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMProductType(this);
    }
    
    
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentMProductType)this.getTheObject()).initializeOnInstantiation();
    }
    public boolean containsMComplexTypeHierarchy(final MComplexTypeHierarchyHIERARCHY part) 
				throws PersistenceException{
        return ((PersistentMProductType)this.getTheObject()).containsMComplexTypeHierarchy(part);
    }
    public PersistentMBoolean isStructuralEqual(final MType otherType) 
				throws PersistenceException{
        return ((PersistentMProductType)this.getTheObject()).isStructuralEqual(otherType);
    }
    public String fetchName() 
				throws PersistenceException{
        return ((PersistentMProductType)this.getTheObject()).fetchName();
    }
    public <T> T strategyMComplexTypeHierarchy(final T parameter, final MComplexTypeHierarchyHIERARCHYStrategy<T> strategy) 
				throws PersistenceException{
        return ((PersistentMProductType)this.getTheObject()).strategyMComplexTypeHierarchy(parameter, strategy);
    }
    public PersistentMBoolean isLessOrEqual(final MType otherType) 
				throws PersistenceException{
        return ((PersistentMProductType)this.getTheObject()).isLessOrEqual(otherType);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentMProductType)this.getTheObject()).initializeOnCreation();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentMProductType)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public PersistentMBoolean contains(final MType otherType) 
				throws PersistenceException{
        return ((PersistentMProductType)this.getTheObject()).contains(otherType);
    }
    public MAssociationSearchList fetchAssociations() 
				throws PersistenceException{
        return ((PersistentMProductType)this.getTheObject()).fetchAssociations();
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentMProductType)this.getTheObject()).initialize(This, final$$Fields);
    }
    public String getTypeLinkOperator() 
				throws PersistenceException{
        return ((PersistentMProductType)this.getTheObject()).getTypeLinkOperator();
    }
    public PersistentMBoolean allObjectsOfTypeAreSingleton() 
				throws PersistenceException{
        return ((PersistentMProductType)this.getTheObject()).allObjectsOfTypeAreSingleton();
    }
    public PersistentMBoolean isAbstract() 
				throws PersistenceException{
        return ((PersistentMProductType)this.getTheObject()).isAbstract();
    }

    
}

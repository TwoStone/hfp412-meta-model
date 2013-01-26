package persistence;

import model.UserException;

import model.visitor.*;

public class MAccountTypeICProxi extends MQuantiObjectTypeICProxi implements PersistentMAccountType{
    
    public MAccountTypeICProxi(long objectId) {
        super(objectId);
    }
    public MAccountTypeICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theMAccountTypeFacade
            .getMAccountType(this.getId());
    }
    
    public long getClassId() {
        return 194;
    }
    
    public MAccountType_SubAccountTypesProxi getSubAccountTypes() throws PersistenceException {
        return ((PersistentMAccountType)this.getTheObject()).getSubAccountTypes();
    }
    public PersistentMAccountType getThis() throws PersistenceException {
        return ((PersistentMAccountType)this.getTheObject()).getThis();
    }
    
    public void accept(MQuantiObjectTypeVisitor visitor) throws PersistenceException {
        visitor.handleMAccountType(this);
    }
    public <R> R accept(MQuantiObjectTypeReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMAccountType(this);
    }
    public <E extends UserException>  void accept(MQuantiObjectTypeExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMAccountType(this);
    }
    public <R, E extends UserException> R accept(MQuantiObjectTypeReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMAccountType(this);
    }
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleMAccountType(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMAccountType(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMAccountType(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMAccountType(this);
    }
    public void accept(MAccountTypeHierarchyHIERARCHYVisitor visitor) throws PersistenceException {
        visitor.handleMAccountType(this);
    }
    public <R> R accept(MAccountTypeHierarchyHIERARCHYReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleMAccountType(this);
    }
    public <E extends UserException>  void accept(MAccountTypeHierarchyHIERARCHYExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleMAccountType(this);
    }
    public <R, E extends UserException> R accept(MAccountTypeHierarchyHIERARCHYReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleMAccountType(this);
    }
    
    
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentMAccountType)this.getTheObject()).initializeOnInstantiation();
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentMAccountType)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public boolean containsMAccountTypeHierarchy(final MAccountTypeHierarchyHIERARCHY part) 
				throws PersistenceException{
        return ((PersistentMAccountType)this.getTheObject()).containsMAccountTypeHierarchy(part);
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentMAccountType)this.getTheObject()).initialize(This, final$$Fields);
    }
    public <T> T strategyMAccountTypeHierarchy(final T parameter, final MAccountTypeHierarchyHIERARCHYStrategy<T> strategy) 
				throws PersistenceException{
        return ((PersistentMAccountType)this.getTheObject()).strategyMAccountTypeHierarchy(parameter, strategy);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentMAccountType)this.getTheObject()).initializeOnCreation();
    }

    
}

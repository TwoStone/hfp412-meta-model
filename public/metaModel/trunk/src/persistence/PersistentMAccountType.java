package persistence;

import model.UserException;

import model.visitor.*;

public interface PersistentMAccountType extends MAccountTypeHierarchyHIERARCHY, PersistentMQuantiObjectType {
    
    public MAccountType_SubAccountTypesProxi getSubAccountTypes() throws PersistenceException ;
    public PersistentMAccountType getThis() throws PersistenceException ;
    
    public void accept(MQuantiObjectTypeVisitor visitor) throws PersistenceException;
    public <R> R accept(MQuantiObjectTypeReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(MQuantiObjectTypeExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(MQuantiObjectTypeReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(AnythingVisitor visitor) throws PersistenceException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(MAccountTypeHierarchyHIERARCHYVisitor visitor) throws PersistenceException;
    public <R> R accept(MAccountTypeHierarchyHIERARCHYReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(MAccountTypeHierarchyHIERARCHYExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(MAccountTypeHierarchyHIERARCHYReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public void initializeOnInstantiation() 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public boolean containsMAccountTypeHierarchy(final MAccountTypeHierarchyHIERARCHY part) 
				throws PersistenceException;
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException;
    public <T> T strategyMAccountTypeHierarchy(final T parameter, final MAccountTypeHierarchyHIERARCHYStrategy<T> strategy) 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;

}


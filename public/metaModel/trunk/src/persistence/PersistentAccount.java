package persistence;

import model.UserException;

import model.visitor.*;

public interface PersistentAccount extends AccountHierarchyHIERARCHY, Anything, AbstractPersistentProxi {
    
    public PersistentMAccountType getType() throws PersistenceException ;
    public void setType(PersistentMAccountType newValue) throws PersistenceException ;
    public Account_SubAccountsProxi getSubAccounts() throws PersistenceException ;
    public PersistentAccount getThis() throws PersistenceException ;
    
    public void accept(AccountHierarchyHIERARCHYVisitor visitor) throws PersistenceException;
    public <R> R accept(AccountHierarchyHIERARCHYReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(AccountHierarchyHIERARCHYExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(AccountHierarchyHIERARCHYReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(AnythingVisitor visitor) throws PersistenceException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public boolean containsAccountHierarchy(final AccountHierarchyHIERARCHY part) 
				throws PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public <T> T strategyAccountHierarchy(final T parameter, final AccountHierarchyHIERARCHYStrategy<T> strategy) 
				throws PersistenceException;
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;

}


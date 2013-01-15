package persistence;

import model.UserException;

import model.visitor.*;

public interface PersistentMAbstractSumType extends PersistentMComplexType {
    
    public abstract PersistentMAbstractSumType getThis() throws PersistenceException ;
    
    public void accept(MAbstractSumTypeVisitor visitor) throws PersistenceException;
    public <R> R accept(MAbstractSumTypeReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(MAbstractSumTypeExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(MAbstractSumTypeReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public void initializeOnInstantiation() 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;

}


package persistence;

import model.UserException;

import model.visitor.*;

public interface PersistentMAbstractProductType extends PersistentMComplexType {
    
    public abstract PersistentMAbstractProductType getThis() throws PersistenceException ;
    
    public void accept(MAbstractProductTypeVisitor visitor) throws PersistenceException;
    public <R> R accept(MAbstractProductTypeReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(MAbstractProductTypeExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(MAbstractProductTypeReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public void initializeOnInstantiation() 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;

}


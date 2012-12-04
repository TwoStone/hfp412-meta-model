package persistence;

import model.UserException;

import model.visitor.*;

public interface PersistentMComplexType extends MType, Anything, AbstractPersistentProxi {
    
    public MComplexType_ContainedTypesProxi getContainedTypes() throws PersistenceException ;
    public abstract PersistentMComplexType getThis() throws PersistenceException ;
    
    public void accept(MComplexTypeVisitor visitor) throws PersistenceException;
    public <R> R accept(MComplexTypeReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(MComplexTypeExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(MComplexTypeReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public void initializeOnInstantiation() 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public String getTypeLinkOperator() 
				throws PersistenceException;

}


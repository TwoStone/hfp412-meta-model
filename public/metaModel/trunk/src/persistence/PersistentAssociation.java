package persistence;

import model.UserException;

import model.visitor.*;

public interface PersistentAssociation extends PersistentAbsOperation {
    
    public Association_HierarchiesProxi getHierarchies() throws PersistenceException ;
    public PersistentAssociation getThis() throws PersistenceException ;
    
    public void accept(AbsOperationVisitor visitor) throws PersistenceException;
    public <R> R accept(AbsOperationReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(AbsOperationExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(AbsOperationReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    public void accept(AnythingVisitor visitor) throws PersistenceException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public void initializeOnInstantiation() 
				throws PersistenceException;
    public PersistentMBoolean hasEqualSourceTargetName(final PersistentAssociation other) 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException;
    public PersistentMBoolean isObservation() 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;

}


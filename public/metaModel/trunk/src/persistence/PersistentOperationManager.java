package persistence;

import model.UserException;

import model.visitor.*;

public interface PersistentOperationManager extends Anything, AbstractPersistentProxi {
    
    public OperationManager_OperationsProxi getOperations() throws PersistenceException ;
    public OperationManager_FormalParametersProxi getFormalParameters() throws PersistenceException ;
    public PersistentOperationManager getThis() throws PersistenceException ;
    
    public void accept(AnythingVisitor visitor) throws PersistenceException;
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException;
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E;
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E;
    
    public OperationSearchList getConstants(final TDObserver observer) 
				throws PersistenceException;
    public void removeOperation(final PersistentOperation op, final Invoker invoker) 
				throws PersistenceException;
    public void createOperation(final PersistentMType source, final PersistentMType target, final String name, final FormalParameterSearchList fp, final Invoker invoker) 
				throws PersistenceException;
    public void createConstant(final String name, final PersistentMType target) 
				throws model.DoubleDefinitionException, PersistenceException;
    public void createFp(final String name, final PersistentMType ofType, final Invoker invoker) 
				throws PersistenceException;
    public void createOperation(final PersistentMType source, final PersistentMType target, final String name, final FormalParameterSearchList fp) 
				throws model.DoubleDefinitionException, PersistenceException;
    public void createVoidOperation(final PersistentMType source, final String name, final FormalParameterSearchList fp) 
				throws model.DoubleDefinitionException, PersistenceException;
    public void removeFp(final PersistentFormalParameter fp, final Invoker invoker) 
				throws PersistenceException;
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException;
    public OperationSearchList getConstants() 
				throws PersistenceException;
    public void createStaticOp(final String name, final PersistentMType target, final FormalParameterSearchList fp) 
				throws model.DoubleDefinitionException, PersistenceException;
    public void removeFpFromOp(final PersistentOperation op, final PersistentFormalParameter fp, final Invoker invoker) 
				throws PersistenceException;
    public void createConstant(final String name, final PersistentMType target, final Invoker invoker) 
				throws PersistenceException;
    public void removeOperation(final PersistentOperation op) 
				throws PersistenceException;
    public void createVoidOperation(final PersistentMType source, final String name, final FormalParameterSearchList fp, final Invoker invoker) 
				throws PersistenceException;
    public OperationSearchList getStaticOperations() 
				throws PersistenceException;
    public void initializeOnInstantiation() 
				throws PersistenceException;
    public void initializeOnCreation() 
				throws PersistenceException;
    public OperationSearchList getStaticOperations(final TDObserver observer) 
				throws PersistenceException;
    public void createStaticOp(final String name, final PersistentMType target, final FormalParameterSearchList fp, final Invoker invoker) 
				throws PersistenceException;
    public void removeFp(final PersistentFormalParameter fp) 
				throws PersistenceException;
    public void createFp(final String name, final PersistentMType ofType) 
				throws model.DoubleDefinitionException, PersistenceException;
    public void addFp(final PersistentOperation op, final PersistentFormalParameter fp, final Invoker invoker) 
				throws PersistenceException;
    public void addFp(final PersistentOperation op, final PersistentFormalParameter fp) 
				throws PersistenceException;
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException;
    public void removeFpFromOp(final PersistentOperation op, final PersistentFormalParameter fp) 
				throws model.NotAvailableException, PersistenceException;

}


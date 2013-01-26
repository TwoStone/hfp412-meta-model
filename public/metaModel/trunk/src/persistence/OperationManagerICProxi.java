package persistence;

import model.UserException;

import model.visitor.*;

public class OperationManagerICProxi extends PersistentInCacheProxiOptimistic implements PersistentOperationManager{
    
    public OperationManagerICProxi(long objectId) {
        super(objectId);
    }
    public OperationManagerICProxi(PersistentObject object) {
        super(object);
    }
    
    protected PersistentObject getRemote() throws PersistenceException {
        return ConnectionHandler.getTheConnectionHandler().theOperationManagerFacade
            .getOperationManager(this.getId());
    }
    
    public long getClassId() {
        return 226;
    }
    
    public OperationManager_OperationsProxi getOperations() throws PersistenceException {
        return ((PersistentOperationManager)this.getTheObject()).getOperations();
    }
    public OperationManager_FormalParametersProxi getFormalParameters() throws PersistenceException {
        return ((PersistentOperationManager)this.getTheObject()).getFormalParameters();
    }
    public PersistentOperationManager getThis() throws PersistenceException {
        return ((PersistentOperationManager)this.getTheObject()).getThis();
    }
    
    public void accept(AnythingVisitor visitor) throws PersistenceException {
        visitor.handleOperationManager(this);
    }
    public <R> R accept(AnythingReturnVisitor<R>  visitor) throws PersistenceException {
         return visitor.handleOperationManager(this);
    }
    public <E extends UserException>  void accept(AnythingExceptionVisitor<E> visitor) throws PersistenceException, E {
         visitor.handleOperationManager(this);
    }
    public <R, E extends UserException> R accept(AnythingReturnExceptionVisitor<R, E>  visitor) throws PersistenceException, E {
         return visitor.handleOperationManager(this);
    }
    
    
    public void createConstant(final String name, final PersistentMType target, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentOperationManager)this.getTheObject()).createConstant(name, target, invoker);
    }
    public OperationSearchList getConstants(final TDObserver observer) 
				throws PersistenceException{
        return ((PersistentOperationManager)this.getTheObject()).getConstants(observer);
    }
    public void removeOperation(final PersistentOperation op, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentOperationManager)this.getTheObject()).removeOperation(op, invoker);
    }
    public OperationSearchList getStaticOperations() 
				throws PersistenceException{
        return ((PersistentOperationManager)this.getTheObject()).getStaticOperations();
    }
    public void createVoidOperation(final PersistentMType source, final String name, final FormalParameterSearchList fp, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentOperationManager)this.getTheObject()).createVoidOperation(source, name, fp, invoker);
    }
    public void removeOperation(final PersistentOperation op) 
				throws PersistenceException{
        ((PersistentOperationManager)this.getTheObject()).removeOperation(op);
    }
    public void createOperation(final PersistentMType source, final PersistentMType target, final String name, final FormalParameterSearchList fp, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentOperationManager)this.getTheObject()).createOperation(source, target, name, fp, invoker);
    }
    public void initializeOnInstantiation() 
				throws PersistenceException{
        ((PersistentOperationManager)this.getTheObject()).initializeOnInstantiation();
    }
    public void createConstant(final String name, final PersistentMType target) 
				throws model.DoubleDefinitionException, PersistenceException{
        ((PersistentOperationManager)this.getTheObject()).createConstant(name, target);
    }
    public void createFp(final String name, final PersistentMType ofType, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentOperationManager)this.getTheObject()).createFp(name, ofType, invoker);
    }
    public void createOperation(final PersistentMType source, final PersistentMType target, final String name, final FormalParameterSearchList fp) 
				throws model.DoubleDefinitionException, PersistenceException{
        ((PersistentOperationManager)this.getTheObject()).createOperation(source, target, name, fp);
    }
    public OperationSearchList getStaticOperations(final TDObserver observer) 
				throws PersistenceException{
        return ((PersistentOperationManager)this.getTheObject()).getStaticOperations(observer);
    }
    public void initializeOnCreation() 
				throws PersistenceException{
        ((PersistentOperationManager)this.getTheObject()).initializeOnCreation();
    }
    public void createStaticOp(final String name, final PersistentMType target, final FormalParameterSearchList fp, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentOperationManager)this.getTheObject()).createStaticOp(name, target, fp, invoker);
    }
    public void createVoidOperation(final PersistentMType source, final String name, final FormalParameterSearchList fp) 
				throws model.DoubleDefinitionException, PersistenceException{
        ((PersistentOperationManager)this.getTheObject()).createVoidOperation(source, name, fp);
    }
    public void removeFp(final PersistentFormalParameter fp) 
				throws PersistenceException{
        ((PersistentOperationManager)this.getTheObject()).removeFp(fp);
    }
    public void removeFp(final PersistentFormalParameter fp, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentOperationManager)this.getTheObject()).removeFp(fp, invoker);
    }
    public void createFp(final String name, final PersistentMType ofType) 
				throws model.DoubleDefinitionException, PersistenceException{
        ((PersistentOperationManager)this.getTheObject()).createFp(name, ofType);
    }
    public void addFp(final PersistentOperation op, final PersistentFormalParameter fp, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentOperationManager)this.getTheObject()).addFp(op, fp, invoker);
    }
    public void copyingPrivateUserAttributes(final Anything copy) 
				throws PersistenceException{
        ((PersistentOperationManager)this.getTheObject()).copyingPrivateUserAttributes(copy);
    }
    public void addFp(final PersistentOperation op, final PersistentFormalParameter fp) 
				throws PersistenceException{
        ((PersistentOperationManager)this.getTheObject()).addFp(op, fp);
    }
    public void initialize(final Anything This, final java.util.Hashtable<String,Object> final$$Fields) 
				throws PersistenceException{
        ((PersistentOperationManager)this.getTheObject()).initialize(This, final$$Fields);
    }
    public void removeFpFromOp(final PersistentOperation op, final PersistentFormalParameter fp) 
				throws model.NotAvailableException, PersistenceException{
        ((PersistentOperationManager)this.getTheObject()).removeFpFromOp(op, fp);
    }
    public OperationSearchList getConstants() 
				throws PersistenceException{
        return ((PersistentOperationManager)this.getTheObject()).getConstants();
    }
    public void createStaticOp(final String name, final PersistentMType target, final FormalParameterSearchList fp) 
				throws model.DoubleDefinitionException, PersistenceException{
        ((PersistentOperationManager)this.getTheObject()).createStaticOp(name, target, fp);
    }
    public void removeFpFromOp(final PersistentOperation op, final PersistentFormalParameter fp, final Invoker invoker) 
				throws PersistenceException{
        ((PersistentOperationManager)this.getTheObject()).removeFpFromOp(op, fp, invoker);
    }

    
}

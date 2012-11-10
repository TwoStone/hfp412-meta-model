
package model.visitor;

import persistence.*;

public interface AnythingReturnVisitor<R> extends AbsUnitTypeReturnVisitor<R> ,AbsUnitReturnVisitor<R> ,AbsQuantityReturnVisitor<R> {
    
    public R handleTypeManager(PersistentTypeManager typeManager) throws PersistenceException;
    public R handleConversionManager(PersistentConversionManager conversionManager) throws PersistenceException;
    public R handleTransactionFcde(PersistentTransactionFcde transactionFcde) throws PersistenceException;
    public R handleReferenceType(PersistentReferenceType referenceType) throws PersistenceException;
    public R handleQuantityManager(PersistentQuantityManager quantityManager) throws PersistenceException;
    public R handleErrorDisplay(PersistentErrorDisplay errorDisplay) throws PersistenceException;
    public R handleServer(PersistentServer server) throws PersistenceException;
    public R handleConversion(PersistentConversion conversion) throws PersistenceException;
    public R handleReference(PersistentReference reference) throws PersistenceException;
    public R handleUnitManager(PersistentUnitManager unitManager) throws PersistenceException;
    
}

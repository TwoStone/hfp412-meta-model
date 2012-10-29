
package model.visitor;

import persistence.*;

public interface AnythingVisitor extends AbsUnitTypeVisitor,AbsUnitVisitor,AbsQuantityVisitor{
    
    public void handleTypeManager(PersistentTypeManager typeManager) throws PersistenceException;
    public void handleConversionManager(PersistentConversionManager conversionManager) throws PersistenceException;
    public void handleTransactionFcde(PersistentTransactionFcde transactionFcde) throws PersistenceException;
    public void handleReferenceType(PersistentReferenceType referenceType) throws PersistenceException;
    public void handleFunction(PersistentFunction function) throws PersistenceException;
    public void handleQuantityManager(PersistentQuantityManager quantityManager) throws PersistenceException;
    public void handleErrorDisplay(PersistentErrorDisplay errorDisplay) throws PersistenceException;
    public void handleServer(PersistentServer server) throws PersistenceException;
    public void handleConversion(PersistentConversion conversion) throws PersistenceException;
    public void handleReference(PersistentReference reference) throws PersistenceException;
    public void handleUnitManager(PersistentUnitManager unitManager) throws PersistenceException;
    
}

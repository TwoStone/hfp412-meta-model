
package model.visitor;
import model.UserException;
import persistence.*;

public interface AnythingExceptionVisitor<E extends UserException> extends AbsUnitTypeExceptionVisitor<E>,AbsUnitExceptionVisitor<E>,AbsQuantityExceptionVisitor<E>{
    
    public void handleTypeManager(PersistentTypeManager typeManager) throws PersistenceException, E;
    public void handleConversionManager(PersistentConversionManager conversionManager) throws PersistenceException, E;
    public void handleTransactionFcde(PersistentTransactionFcde transactionFcde) throws PersistenceException, E;
    public void handleReferenceType(PersistentReferenceType referenceType) throws PersistenceException, E;
    public void handleQuantityManager(PersistentQuantityManager quantityManager) throws PersistenceException, E;
    public void handleErrorDisplay(PersistentErrorDisplay errorDisplay) throws PersistenceException, E;
    public void handleServer(PersistentServer server) throws PersistenceException, E;
    public void handleConversion(PersistentConversion conversion) throws PersistenceException, E;
    public void handleReference(PersistentReference reference) throws PersistenceException, E;
    public void handleUnitManager(PersistentUnitManager unitManager) throws PersistenceException, E;
    
}

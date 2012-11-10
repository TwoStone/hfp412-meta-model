
package model.visitor;
import model.UserException;
import persistence.*;

public interface AnythingReturnExceptionVisitor<R, E extends UserException> extends AbsUnitTypeReturnExceptionVisitor<R, E> ,AbsUnitReturnExceptionVisitor<R, E> ,AbsQuantityReturnExceptionVisitor<R, E> {
    
    public R handleTypeManager(PersistentTypeManager typeManager) throws PersistenceException, E;
    public R handleConversionManager(PersistentConversionManager conversionManager) throws PersistenceException, E;
    public R handleTransactionFcde(PersistentTransactionFcde transactionFcde) throws PersistenceException, E;
    public R handleReferenceType(PersistentReferenceType referenceType) throws PersistenceException, E;
    public R handleQuantityManager(PersistentQuantityManager quantityManager) throws PersistenceException, E;
    public R handleErrorDisplay(PersistentErrorDisplay errorDisplay) throws PersistenceException, E;
    public R handleServer(PersistentServer server) throws PersistenceException, E;
    public R handleConversion(PersistentConversion conversion) throws PersistenceException, E;
    public R handleReference(PersistentReference reference) throws PersistenceException, E;
    public R handleUnitManager(PersistentUnitManager unitManager) throws PersistenceException, E;
    
}

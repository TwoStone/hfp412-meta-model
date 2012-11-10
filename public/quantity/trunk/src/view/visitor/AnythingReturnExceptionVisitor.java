
package view.visitor;
import view.UserException;
import view.*;

public interface AnythingReturnExceptionVisitor<R, E extends UserException> extends AbsUnitTypeReturnExceptionVisitor<R, E> ,AbsUnitReturnExceptionVisitor<R, E> ,AbsQuantityReturnExceptionVisitor<R, E> {
    
    public R handleTypeManager(TypeManagerView typeManager) throws ModelException, E;
    public R handleConversionManager(ConversionManagerView conversionManager) throws ModelException, E;
    public R handleTransactionFcde(TransactionFcdeView transactionFcde) throws ModelException, E;
    public R handleReferenceType(ReferenceTypeView referenceType) throws ModelException, E;
    public R handleQuantityManager(QuantityManagerView quantityManager) throws ModelException, E;
    public R handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException, E;
    public R handleServer(ServerView server) throws ModelException, E;
    public R handleConversion(ConversionView conversion) throws ModelException, E;
    public R handleReference(ReferenceView reference) throws ModelException, E;
    public R handleUnitManager(UnitManagerView unitManager) throws ModelException, E;
    
}


package view.visitor;

import view.*;

public interface AnythingReturnVisitor<R> extends AbsUnitTypeReturnVisitor<R> ,AbsUnitReturnVisitor<R> ,AbsQuantityReturnVisitor<R> {
    
    public R handleTypeManager(TypeManagerView typeManager) throws ModelException;
    public R handleConversionManager(ConversionManagerView conversionManager) throws ModelException;
    public R handleTransactionFcde(TransactionFcdeView transactionFcde) throws ModelException;
    public R handleReferenceType(ReferenceTypeView referenceType) throws ModelException;
    public R handleFunction(FunctionView function) throws ModelException;
    public R handleQuantityManager(QuantityManagerView quantityManager) throws ModelException;
    public R handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException;
    public R handleServer(ServerView server) throws ModelException;
    public R handleConversion(ConversionView conversion) throws ModelException;
    public R handleReference(ReferenceView reference) throws ModelException;
    public R handleUnitManager(UnitManagerView unitManager) throws ModelException;
    
}

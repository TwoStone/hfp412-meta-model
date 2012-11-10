
package view.visitor;
import view.UserException;
import view.*;

public interface AnythingExceptionVisitor<E extends UserException> extends AbsUnitTypeExceptionVisitor<E>,AbsUnitExceptionVisitor<E>,AbsQuantityExceptionVisitor<E>{
    
    public void handleTypeManager(TypeManagerView typeManager) throws ModelException, E;
    public void handleConversionManager(ConversionManagerView conversionManager) throws ModelException, E;
    public void handleTransactionFcde(TransactionFcdeView transactionFcde) throws ModelException, E;
    public void handleReferenceType(ReferenceTypeView referenceType) throws ModelException, E;
    public void handleQuantityManager(QuantityManagerView quantityManager) throws ModelException, E;
    public void handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException, E;
    public void handleServer(ServerView server) throws ModelException, E;
    public void handleConversion(ConversionView conversion) throws ModelException, E;
    public void handleReference(ReferenceView reference) throws ModelException, E;
    public void handleUnitManager(UnitManagerView unitManager) throws ModelException, E;
    
}


package view.visitor;

import view.*;

public interface AnythingVisitor extends AbsUnitTypeVisitor,AbsUnitVisitor,AbsQuantityVisitor{
    
    public void handleTypeManager(TypeManagerView typeManager) throws ModelException;
    public void handleConversionManager(ConversionManagerView conversionManager) throws ModelException;
    public void handleTransactionFcde(TransactionFcdeView transactionFcde) throws ModelException;
    public void handleReferenceType(ReferenceTypeView referenceType) throws ModelException;
    public void handleQuantityManager(QuantityManagerView quantityManager) throws ModelException;
    public void handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException;
    public void handleServer(ServerView server) throws ModelException;
    public void handleConversion(ConversionView conversion) throws ModelException;
    public void handleReference(ReferenceView reference) throws ModelException;
    public void handleUnitManager(UnitManagerView unitManager) throws ModelException;
    
}

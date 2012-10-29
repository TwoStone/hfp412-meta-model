
package view.visitor;

import view.*;

public abstract class AnythingStandardVisitor implements AnythingVisitor {
    
    public void handleTypeManager(TypeManagerView typeManager) throws ModelException{
        this.standardHandling(typeManager);
    }
    public void handleQuantity(QuantityView quantity) throws ModelException{
        this.standardHandling(quantity);
    }
    public void handleConversionManager(ConversionManagerView conversionManager) throws ModelException{
        this.standardHandling(conversionManager);
    }
    public void handleTransactionFcde(TransactionFcdeView transactionFcde) throws ModelException{
        this.standardHandling(transactionFcde);
    }
    public void handleCompoundQuantity(CompoundQuantityView compoundQuantity) throws ModelException{
        this.standardHandling(compoundQuantity);
    }
    public void handleReferenceType(ReferenceTypeView referenceType) throws ModelException{
        this.standardHandling(referenceType);
    }
    public void handleFunction(FunctionView function) throws ModelException{
        this.standardHandling(function);
    }
    public void handleQuantityManager(QuantityManagerView quantityManager) throws ModelException{
        this.standardHandling(quantityManager);
    }
    public void handleErrorDisplay(ErrorDisplayView errorDisplay) throws ModelException{
        this.standardHandling(errorDisplay);
    }
    public void handleUnitType(UnitTypeView unitType) throws ModelException{
        this.standardHandling(unitType);
    }
    public void handleUnit(UnitView unit) throws ModelException{
        this.standardHandling(unit);
    }
    public void handleServer(ServerView server) throws ModelException{
        this.standardHandling(server);
    }
    public void handleReference(ReferenceView reference) throws ModelException{
        this.standardHandling(reference);
    }
    public void handleConversion(ConversionView conversion) throws ModelException{
        this.standardHandling(conversion);
    }
    public void handleCompUnit(CompUnitView compUnit) throws ModelException{
        this.standardHandling(compUnit);
    }
    public void handleUnitManager(UnitManagerView unitManager) throws ModelException{
        this.standardHandling(unitManager);
    }
    public void handleCompUnitType(CompUnitTypeView compUnitType) throws ModelException{
        this.standardHandling(compUnitType);
    }
    protected abstract void standardHandling(Anything anything) throws ModelException;
}

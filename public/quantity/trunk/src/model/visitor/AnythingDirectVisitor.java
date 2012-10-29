
package model.visitor;

import persistence.*;

public abstract class AnythingDirectVisitor implements AnythingVisitor {
    
    public abstract void handleTypeManager(PersistentTypeManager typeManager) throws PersistenceException;
    
    public abstract void handleConversionManager(PersistentConversionManager conversionManager) throws PersistenceException;
    
    public abstract void handleTransactionFcde(PersistentTransactionFcde transactionFcde) throws PersistenceException;
    
    public abstract void handleReferenceType(PersistentReferenceType referenceType) throws PersistenceException;
    
    public abstract void handleFunction(PersistentFunction function) throws PersistenceException;
    
    public abstract void handleAbsUnitType(PersistentAbsUnitType absUnitType) throws PersistenceException;
    
    public void handleUnitType(PersistentUnitType unitType) throws PersistenceException{
        this.handleAbsUnitType(unitType);
    }
    public void handleCompUnitType(PersistentCompUnitType compUnitType) throws PersistenceException{
        this.handleAbsUnitType(compUnitType);
    }
    public abstract void handleQuantityManager(PersistentQuantityManager quantityManager) throws PersistenceException;
    
    public abstract void handleAbsUnit(PersistentAbsUnit absUnit) throws PersistenceException;
    
    public void handleCompUnit(PersistentCompUnit compUnit) throws PersistenceException{
        this.handleAbsUnit(compUnit);
    }
    public void handleUnit(PersistentUnit unit) throws PersistenceException{
        this.handleAbsUnit(unit);
    }
    public abstract void handleErrorDisplay(PersistentErrorDisplay errorDisplay) throws PersistenceException;
    
    public abstract void handleServer(PersistentServer server) throws PersistenceException;
    
    public abstract void handleAbsQuantity(PersistentAbsQuantity absQuantity) throws PersistenceException;
    
    public void handleQuantity(PersistentQuantity quantity) throws PersistenceException{
        this.handleAbsQuantity(quantity);
    }
    public void handleCompoundQuantity(PersistentCompoundQuantity compoundQuantity) throws PersistenceException{
        this.handleAbsQuantity(compoundQuantity);
    }
    public abstract void handleConversion(PersistentConversion conversion) throws PersistenceException;
    
    public abstract void handleReference(PersistentReference reference) throws PersistenceException;
    
    public abstract void handleUnitManager(PersistentUnitManager unitManager) throws PersistenceException;
    
    
}
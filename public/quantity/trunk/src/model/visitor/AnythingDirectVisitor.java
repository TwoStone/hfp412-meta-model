
package model.visitor;

import persistence.*;

public abstract class AnythingDirectVisitor implements AnythingVisitor {
    
    public abstract void handleConversionManager(PersistentConversionManager conversionManager) throws PersistenceException;
    
    public abstract void handleCommandExecuter(PersistentCommandExecuter commandExecuter) throws PersistenceException;
    
    public abstract void handleUnitTypeManager(PersistentUnitTypeManager unitTypeManager) throws PersistenceException;
    
    public abstract void handleReferenceType(PersistentReferenceType referenceType) throws PersistenceException;
    
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
    public abstract void handleFractionManager(PersistentFractionManager fractionManager) throws PersistenceException;
    
    public abstract void handleCommandCoordinator(PersistentCommandCoordinator commandCoordinator) throws PersistenceException;
    
    public abstract void handleCommonDate(PersistentCommonDate commonDate) throws PersistenceException;
    
    public void handleCreateConversionCommand(PersistentCreateConversionCommand createConversionCommand) throws PersistenceException{
        this.handleCommonDate(createConversionCommand);
    }
    public void handleCreateUnitCommand(PersistentCreateUnitCommand createUnitCommand) throws PersistenceException{
        this.handleCommonDate(createUnitCommand);
    }
    public void handleAddDefaultUnitCommand(PersistentAddDefaultUnitCommand addDefaultUnitCommand) throws PersistenceException{
        this.handleCommonDate(addDefaultUnitCommand);
    }
    public void handleCreateQuantityCommand(PersistentCreateQuantityCommand createQuantityCommand) throws PersistenceException{
        this.handleCommonDate(createQuantityCommand);
    }
    public void handleCreateUnitTypeCommand(PersistentCreateUnitTypeCommand createUnitTypeCommand) throws PersistenceException{
        this.handleCommonDate(createUnitTypeCommand);
    }
    public abstract void handleReference(PersistentReference reference) throws PersistenceException;
    
    public abstract void handleConversion(PersistentConversion conversion) throws PersistenceException;
    
    
}

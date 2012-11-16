
package model.visitor;

import persistence.*;

public interface AnythingVisitor extends AbsUnitTypeVisitor,AbsQuantityVisitor,BooleanValueVisitor,CommonDateVisitor,AbsUnitVisitor{
    
    public void handleCommandCoordinator(PersistentCommandCoordinator commandCoordinator) throws PersistenceException;
    public void handleCommandExecuter(PersistentCommandExecuter commandExecuter) throws PersistenceException;
    public void handleConversionManager(PersistentConversionManager conversionManager) throws PersistenceException;
    public void handleReferenceType(PersistentReferenceType referenceType) throws PersistenceException;
    public void handleQuantityManager(PersistentQuantityManager quantityManager) throws PersistenceException;
    public void handleErrorDisplay(PersistentErrorDisplay errorDisplay) throws PersistenceException;
    public void handleCreateUnitTypeCommand(PersistentCreateUnitTypeCommand createUnitTypeCommand) throws PersistenceException;
    public void handleCreateConversionCommand(PersistentCreateConversionCommand createConversionCommand) throws PersistenceException;
    public void handleCreateUnitCommand(PersistentCreateUnitCommand createUnitCommand) throws PersistenceException;
    public void handleCommonDate(PersistentCommonDate commonDate) throws PersistenceException;
    public void handleCreateQuantityCommand(PersistentCreateQuantityCommand createQuantityCommand) throws PersistenceException;
    public void handleUnitTypeManager(PersistentUnitTypeManager unitTypeManager) throws PersistenceException;
    public void handleAddDefaultUnitCommand(PersistentAddDefaultUnitCommand addDefaultUnitCommand) throws PersistenceException;
    public void handleServer(PersistentServer server) throws PersistenceException;
    public void handleFractionManager(PersistentFractionManager fractionManager) throws PersistenceException;
    public void handleReference(PersistentReference reference) throws PersistenceException;
    public void handleConversion(PersistentConversion conversion) throws PersistenceException;
    
}


package model.visitor;

import persistence.*;

public interface AnythingReturnVisitor<R> extends AbsUnitTypeReturnVisitor<R> ,AbsQuantityReturnVisitor<R> ,CommonDateReturnVisitor<R> ,AbsUnitReturnVisitor<R> {
    
    public R handleCommandCoordinator(PersistentCommandCoordinator commandCoordinator) throws PersistenceException;
    public R handleCommandExecuter(PersistentCommandExecuter commandExecuter) throws PersistenceException;
    public R handleConversionManager(PersistentConversionManager conversionManager) throws PersistenceException;
    public R handleReferenceType(PersistentReferenceType referenceType) throws PersistenceException;
    public R handleQuantityManager(PersistentQuantityManager quantityManager) throws PersistenceException;
    public R handleErrorDisplay(PersistentErrorDisplay errorDisplay) throws PersistenceException;
    public R handleCreateUnitTypeCommand(PersistentCreateUnitTypeCommand createUnitTypeCommand) throws PersistenceException;
    public R handleCreateConversionCommand(PersistentCreateConversionCommand createConversionCommand) throws PersistenceException;
    public R handleCreateUnitCommand(PersistentCreateUnitCommand createUnitCommand) throws PersistenceException;
    public R handleCommonDate(PersistentCommonDate commonDate) throws PersistenceException;
    public R handleCreateQuantityCommand(PersistentCreateQuantityCommand createQuantityCommand) throws PersistenceException;
    public R handleUnitTypeManager(PersistentUnitTypeManager unitTypeManager) throws PersistenceException;
    public R handleAddDefaultUnitCommand(PersistentAddDefaultUnitCommand addDefaultUnitCommand) throws PersistenceException;
    public R handleServer(PersistentServer server) throws PersistenceException;
    public R handleFractionManager(PersistentFractionManager fractionManager) throws PersistenceException;
    public R handleReference(PersistentReference reference) throws PersistenceException;
    public R handleConversion(PersistentConversion conversion) throws PersistenceException;
    
}


package model.visitor;
import model.UserException;
import persistence.*;

public interface AnythingExceptionVisitor<E extends UserException> extends AbsUnitTypeExceptionVisitor<E>,AbsQuantityExceptionVisitor<E>,CommonDateExceptionVisitor<E>,AbsUnitExceptionVisitor<E>{
    
    public void handleCommandCoordinator(PersistentCommandCoordinator commandCoordinator) throws PersistenceException, E;
    public void handleCommandExecuter(PersistentCommandExecuter commandExecuter) throws PersistenceException, E;
    public void handleConversionManager(PersistentConversionManager conversionManager) throws PersistenceException, E;
    public void handleReferenceType(PersistentReferenceType referenceType) throws PersistenceException, E;
    public void handleQuantityManager(PersistentQuantityManager quantityManager) throws PersistenceException, E;
    public void handleErrorDisplay(PersistentErrorDisplay errorDisplay) throws PersistenceException, E;
    public void handleCreateUnitTypeCommand(PersistentCreateUnitTypeCommand createUnitTypeCommand) throws PersistenceException, E;
    public void handleCreateConversionCommand(PersistentCreateConversionCommand createConversionCommand) throws PersistenceException, E;
    public void handleCreateUnitCommand(PersistentCreateUnitCommand createUnitCommand) throws PersistenceException, E;
    public void handleCommonDate(PersistentCommonDate commonDate) throws PersistenceException, E;
    public void handleCreateQuantityCommand(PersistentCreateQuantityCommand createQuantityCommand) throws PersistenceException, E;
    public void handleUnitTypeManager(PersistentUnitTypeManager unitTypeManager) throws PersistenceException, E;
    public void handleAddDefaultUnitCommand(PersistentAddDefaultUnitCommand addDefaultUnitCommand) throws PersistenceException, E;
    public void handleServer(PersistentServer server) throws PersistenceException, E;
    public void handleFractionManager(PersistentFractionManager fractionManager) throws PersistenceException, E;
    public void handleReference(PersistentReference reference) throws PersistenceException, E;
    public void handleConversion(PersistentConversion conversion) throws PersistenceException, E;
    
}

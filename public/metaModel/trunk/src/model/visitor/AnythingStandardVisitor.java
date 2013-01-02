
package model.visitor;

import persistence.*;

public abstract class AnythingStandardVisitor implements AnythingVisitor {
    
    public void handleMProductType(PersistentMProductType mProductType) throws PersistenceException{
        this.standardHandling(mProductType);
    }
    public void handleFinishModelingCommand(PersistentFinishModelingCommand finishModelingCommand) throws PersistenceException{
        this.standardHandling(finishModelingCommand);
    }
    public void handleConversionManager(PersistentConversionManager conversionManager) throws PersistenceException{
        this.standardHandling(conversionManager);
    }
    public void handleReferenceType(PersistentReferenceType referenceType) throws PersistenceException{
        this.standardHandling(referenceType);
    }
    public void handleQuantityManager(PersistentQuantityManager quantityManager) throws PersistenceException{
        this.standardHandling(quantityManager);
    }
    public void handleCreateHierarchyCommand(PersistentCreateHierarchyCommand createHierarchyCommand) throws PersistenceException{
        this.standardHandling(createHierarchyCommand);
    }
    public void handleErrorDisplay(PersistentErrorDisplay errorDisplay) throws PersistenceException{
        this.standardHandling(errorDisplay);
    }
    public void handleMFalse(PersistentMFalse mFalse) throws PersistenceException{
        this.standardHandling(mFalse);
    }
    public void handleUnit(PersistentUnit unit) throws PersistenceException{
        this.standardHandling(unit);
    }
    public void handleCreateUnitTypeCommand(PersistentCreateUnitTypeCommand createUnitTypeCommand) throws PersistenceException{
        this.standardHandling(createUnitTypeCommand);
    }
    public void handleAssociationManager(PersistentAssociationManager associationManager) throws PersistenceException{
        this.standardHandling(associationManager);
    }
    public void handleUnitType(PersistentUnitType unitType) throws PersistenceException{
        this.standardHandling(unitType);
    }
    public void handleCreateConversionCommand(PersistentCreateConversionCommand createConversionCommand) throws PersistenceException{
        this.standardHandling(createConversionCommand);
    }
    public void handleCreateAspectCommand(PersistentCreateAspectCommand createAspectCommand) throws PersistenceException{
        this.standardHandling(createAspectCommand);
    }
    public void handleMAHierarchy(PersistentMAHierarchy mAHierarchy) throws PersistenceException{
        this.standardHandling(mAHierarchy);
    }
    public void handleCreateUnitCommand(PersistentCreateUnitCommand createUnitCommand) throws PersistenceException{
        this.standardHandling(createUnitCommand);
    }
    public void handleCommandCoordinator(PersistentCommandCoordinator commandCoordinator) throws PersistenceException{
        this.standardHandling(commandCoordinator);
    }
    public void handleCreateCompUnitCommand(PersistentCreateCompUnitCommand createCompUnitCommand) throws PersistenceException{
        this.standardHandling(createCompUnitCommand);
    }
    public void handleCreateCompUnitTypeCommand(PersistentCreateCompUnitTypeCommand createCompUnitTypeCommand) throws PersistenceException{
        this.standardHandling(createCompUnitTypeCommand);
    }
    public void handleCommonDate(PersistentCommonDate commonDate) throws PersistenceException{
        this.standardHandling(commonDate);
    }
    public void handleMAssociation(PersistentMAssociation mAssociation) throws PersistenceException{
        this.standardHandling(mAssociation);
    }
    public void handleCreateQuantityCommand(PersistentCreateQuantityCommand createQuantityCommand) throws PersistenceException{
        this.standardHandling(createQuantityCommand);
    }
    public void handleCreateAssociationCommand(PersistentCreateAssociationCommand createAssociationCommand) throws PersistenceException{
        this.standardHandling(createAssociationCommand);
    }
    public void handleMTrue(PersistentMTrue mTrue) throws PersistenceException{
        this.standardHandling(mTrue);
    }
    public void handleTypeManager(PersistentTypeManager typeManager) throws PersistenceException{
        this.standardHandling(typeManager);
    }
    public void handleQuantity(PersistentQuantity quantity) throws PersistenceException{
        this.standardHandling(quantity);
    }
    public void handleCommandExecuter(PersistentCommandExecuter commandExecuter) throws PersistenceException{
        this.standardHandling(commandExecuter);
    }
    public void handleAddReferenceTypeCommand(PersistentAddReferenceTypeCommand addReferenceTypeCommand) throws PersistenceException{
        this.standardHandling(addReferenceTypeCommand);
    }
    public void handleUnitTypeManager(PersistentUnitTypeManager unitTypeManager) throws PersistenceException{
        this.standardHandling(unitTypeManager);
    }
    public void handleCompoundQuantity(PersistentCompoundQuantity compoundQuantity) throws PersistenceException{
        this.standardHandling(compoundQuantity);
    }
    public void handleFunction(PersistentFunction function) throws PersistenceException{
        this.standardHandling(function);
    }
    public void handleAddDefaultUnitCommand(PersistentAddDefaultUnitCommand addDefaultUnitCommand) throws PersistenceException{
        this.standardHandling(addDefaultUnitCommand);
    }
    public void handleAspectManager(PersistentAspectManager aspectManager) throws PersistenceException{
        this.standardHandling(aspectManager);
    }
    public void handleAddToHierarchyCommand(PersistentAddToHierarchyCommand addToHierarchyCommand) throws PersistenceException{
        this.standardHandling(addToHierarchyCommand);
    }
    public void handleServer(PersistentServer server) throws PersistenceException{
        this.standardHandling(server);
    }
    public void handleAddSubTypeCommand(PersistentAddSubTypeCommand addSubTypeCommand) throws PersistenceException{
        this.standardHandling(addSubTypeCommand);
    }
    public void handleMAtomicType(PersistentMAtomicType mAtomicType) throws PersistenceException{
        this.standardHandling(mAtomicType);
    }
    public void handleCreateAtomicTypeCommand(PersistentCreateAtomicTypeCommand createAtomicTypeCommand) throws PersistenceException{
        this.standardHandling(createAtomicTypeCommand);
    }
    public void handleMAspect(PersistentMAspect mAspect) throws PersistenceException{
        this.standardHandling(mAspect);
    }
    public void handleFractionManager(PersistentFractionManager fractionManager) throws PersistenceException{
        this.standardHandling(fractionManager);
    }
    public void handleMSumType(PersistentMSumType mSumType) throws PersistenceException{
        this.standardHandling(mSumType);
    }
    public void handleReference(PersistentReference reference) throws PersistenceException{
        this.standardHandling(reference);
    }
    public void handleConversion(PersistentConversion conversion) throws PersistenceException{
        this.standardHandling(conversion);
    }
    public void handleCompUnit(PersistentCompUnit compUnit) throws PersistenceException{
        this.standardHandling(compUnit);
    }
    public void handleCreateSubTypeCommand(PersistentCreateSubTypeCommand createSubTypeCommand) throws PersistenceException{
        this.standardHandling(createSubTypeCommand);
    }
    public void handleCompUnitType(PersistentCompUnitType compUnitType) throws PersistenceException{
        this.standardHandling(compUnitType);
    }
    protected abstract void standardHandling(Anything anything) throws PersistenceException;
}

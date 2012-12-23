
package model.visitor;

import persistence.*;

public abstract class AnythingDirectVisitor implements AnythingVisitor {
    
    public abstract void handleConversionManager(PersistentConversionManager conversionManager) throws PersistenceException;
    
    public abstract void handleReferenceType(PersistentReferenceType referenceType) throws PersistenceException;
    
    public abstract void handleAbsUnitType(PersistentAbsUnitType absUnitType) throws PersistenceException;
    
    public void handleUnitType(PersistentUnitType unitType) throws PersistenceException{
        this.handleAbsUnitType(unitType);
    }
    public void handleCompUnitType(PersistentCompUnitType compUnitType) throws PersistenceException{
        this.handleAbsUnitType(compUnitType);
    }
    public abstract void handleQuantityManager(PersistentQuantityManager quantityManager) throws PersistenceException;
    
    public abstract void handleErrorDisplay(PersistentErrorDisplay errorDisplay) throws PersistenceException;
    
    public abstract void handleAssociationManager(PersistentAssociationManager associationManager) throws PersistenceException;
    
    public abstract void handleMComplexType(PersistentMComplexType mComplexType) throws PersistenceException;
    
    public void handleMProductType(PersistentMProductType mProductType) throws PersistenceException{
        this.handleMComplexType(mProductType);
    }
    public void handleMSumType(PersistentMSumType mSumType) throws PersistenceException{
        this.handleMComplexType(mSumType);
    }
    public abstract void handleAbsQuantity(PersistentAbsQuantity absQuantity) throws PersistenceException;
    
    public void handleQuantity(PersistentQuantity quantity) throws PersistenceException{
        this.handleAbsQuantity(quantity);
    }
    public void handleCompoundQuantity(PersistentCompoundQuantity compoundQuantity) throws PersistenceException{
        this.handleAbsQuantity(compoundQuantity);
    }
    public abstract void handleMAHierarchy(PersistentMAHierarchy mAHierarchy) throws PersistenceException;
    
    public abstract void handleCommandCoordinator(PersistentCommandCoordinator commandCoordinator) throws PersistenceException;
    
    public abstract void handleCommonDate(PersistentCommonDate commonDate) throws PersistenceException;
    
    public void handleFinishModelingCommand(PersistentFinishModelingCommand finishModelingCommand) throws PersistenceException{
        this.handleCommonDate(finishModelingCommand);
    }
    public void handleAddReferenceTypeCommand(PersistentAddReferenceTypeCommand addReferenceTypeCommand) throws PersistenceException{
        this.handleCommonDate(addReferenceTypeCommand);
    }
    public void handleAddDefaultUnitCommand(PersistentAddDefaultUnitCommand addDefaultUnitCommand) throws PersistenceException{
        this.handleCommonDate(addDefaultUnitCommand);
    }
    public void handleCreateHierarchyCommand(PersistentCreateHierarchyCommand createHierarchyCommand) throws PersistenceException{
        this.handleCommonDate(createHierarchyCommand);
    }
    public void handleAddToHierarchyCommand(PersistentAddToHierarchyCommand addToHierarchyCommand) throws PersistenceException{
        this.handleCommonDate(addToHierarchyCommand);
    }
    public void handleAddSubTypeCommand(PersistentAddSubTypeCommand addSubTypeCommand) throws PersistenceException{
        this.handleCommonDate(addSubTypeCommand);
    }
    public void handleCreateUnitTypeCommand(PersistentCreateUnitTypeCommand createUnitTypeCommand) throws PersistenceException{
        this.handleCommonDate(createUnitTypeCommand);
    }
    public void handleCreateConversionCommand(PersistentCreateConversionCommand createConversionCommand) throws PersistenceException{
        this.handleCommonDate(createConversionCommand);
    }
    public void handleCreateAspectCommand(PersistentCreateAspectCommand createAspectCommand) throws PersistenceException{
        this.handleCommonDate(createAspectCommand);
    }
    public void handleCreateUnitCommand(PersistentCreateUnitCommand createUnitCommand) throws PersistenceException{
        this.handleCommonDate(createUnitCommand);
    }
    public void handleCreateAtomicTypeCommand(PersistentCreateAtomicTypeCommand createAtomicTypeCommand) throws PersistenceException{
        this.handleCommonDate(createAtomicTypeCommand);
    }
    public void handleCreateCompUnitCommand(PersistentCreateCompUnitCommand createCompUnitCommand) throws PersistenceException{
        this.handleCommonDate(createCompUnitCommand);
    }
    public void handleCreateCompUnitTypeCommand(PersistentCreateCompUnitTypeCommand createCompUnitTypeCommand) throws PersistenceException{
        this.handleCommonDate(createCompUnitTypeCommand);
    }
    public void handleCreateAssociationCommand(PersistentCreateAssociationCommand createAssociationCommand) throws PersistenceException{
        this.handleCommonDate(createAssociationCommand);
    }
    public void handleCreateQuantityCommand(PersistentCreateQuantityCommand createQuantityCommand) throws PersistenceException{
        this.handleCommonDate(createQuantityCommand);
    }
    public void handleCreateSubTypeCommand(PersistentCreateSubTypeCommand createSubTypeCommand) throws PersistenceException{
        this.handleCommonDate(createSubTypeCommand);
    }
    public abstract void handleMAssociation(PersistentMAssociation mAssociation) throws PersistenceException;
    
    public abstract void handleMBoolean(PersistentMBoolean mBoolean) throws PersistenceException;
    
    public void handleMFalse(PersistentMFalse mFalse) throws PersistenceException{
        this.handleMBoolean(mFalse);
    }
    public void handleMTrue(PersistentMTrue mTrue) throws PersistenceException{
        this.handleMBoolean(mTrue);
    }
    public abstract void handleTypeManager(PersistentTypeManager typeManager) throws PersistenceException;
    
    public abstract void handleCommandExecuter(PersistentCommandExecuter commandExecuter) throws PersistenceException;
    
    public abstract void handleUnitTypeManager(PersistentUnitTypeManager unitTypeManager) throws PersistenceException;
    
    public abstract void handleFunction(PersistentFunction function) throws PersistenceException;
    
    public abstract void handleAbsUnit(PersistentAbsUnit absUnit) throws PersistenceException;
    
    public void handleCompUnit(PersistentCompUnit compUnit) throws PersistenceException{
        this.handleAbsUnit(compUnit);
    }
    public void handleUnit(PersistentUnit unit) throws PersistenceException{
        this.handleAbsUnit(unit);
    }
    public abstract void handleAspectManager(PersistentAspectManager aspectManager) throws PersistenceException;
    
    public abstract void handleServer(PersistentServer server) throws PersistenceException;
    
    public abstract void handleMAtomicType(PersistentMAtomicType mAtomicType) throws PersistenceException;
    
    public abstract void handleMAspect(PersistentMAspect mAspect) throws PersistenceException;
    
    public abstract void handleFractionManager(PersistentFractionManager fractionManager) throws PersistenceException;
    
    public abstract void handleConversion(PersistentConversion conversion) throws PersistenceException;
    
    public abstract void handleReference(PersistentReference reference) throws PersistenceException;
    
    
}

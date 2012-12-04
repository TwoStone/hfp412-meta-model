
package model.visitor;

import persistence.*;

public abstract class AnythingDirectVisitor implements AnythingVisitor {
    
    public abstract void handleTypeManager(PersistentTypeManager typeManager) throws PersistenceException;
    
    public abstract void handleCommandExecuter(PersistentCommandExecuter commandExecuter) throws PersistenceException;
    
    public abstract void handleAspectManager(PersistentAspectManager aspectManager) throws PersistenceException;
    
    public abstract void handleErrorDisplay(PersistentErrorDisplay errorDisplay) throws PersistenceException;
    
    public abstract void handleServer(PersistentServer server) throws PersistenceException;
    
    public abstract void handleAssociationManager(PersistentAssociationManager associationManager) throws PersistenceException;
    
    public abstract void handleMComplexType(PersistentMComplexType mComplexType) throws PersistenceException;
    
    public void handleMProductType(PersistentMProductType mProductType) throws PersistenceException{
        this.handleMComplexType(mProductType);
    }
    public void handleMSumType(PersistentMSumType mSumType) throws PersistenceException{
        this.handleMComplexType(mSumType);
    }
    public abstract void handleMAtomicType(PersistentMAtomicType mAtomicType) throws PersistenceException;
    
    public abstract void handleMAHierarchy(PersistentMAHierarchy mAHierarchy) throws PersistenceException;
    
    public abstract void handleMAspect(PersistentMAspect mAspect) throws PersistenceException;
    
    public abstract void handleCommandCoordinator(PersistentCommandCoordinator commandCoordinator) throws PersistenceException;
    
    public abstract void handleCommonDate(PersistentCommonDate commonDate) throws PersistenceException;
    
    public void handleCreateAtomicTypeCommand(PersistentCreateAtomicTypeCommand createAtomicTypeCommand) throws PersistenceException{
        this.handleCommonDate(createAtomicTypeCommand);
    }
    public void handleCreateAspectCommand(PersistentCreateAspectCommand createAspectCommand) throws PersistenceException{
        this.handleCommonDate(createAspectCommand);
    }
    public void handleCreateAssociationCommand(PersistentCreateAssociationCommand createAssociationCommand) throws PersistenceException{
        this.handleCommonDate(createAssociationCommand);
    }
    public void handleCreateHierarchyCommand(PersistentCreateHierarchyCommand createHierarchyCommand) throws PersistenceException{
        this.handleCommonDate(createHierarchyCommand);
    }
    public void handleAddToHierarchyCommand(PersistentAddToHierarchyCommand addToHierarchyCommand) throws PersistenceException{
        this.handleCommonDate(addToHierarchyCommand);
    }
    public void handleCreateSubTypeCommand(PersistentCreateSubTypeCommand createSubTypeCommand) throws PersistenceException{
        this.handleCommonDate(createSubTypeCommand);
    }
    public void handleAddSubTypeCommand(PersistentAddSubTypeCommand addSubTypeCommand) throws PersistenceException{
        this.handleCommonDate(addSubTypeCommand);
    }
    public abstract void handleMAssociation(PersistentMAssociation mAssociation) throws PersistenceException;
    
    public abstract void handleMBoolean(PersistentMBoolean mBoolean) throws PersistenceException;
    
    public void handleMFalse(PersistentMFalse mFalse) throws PersistenceException{
        this.handleMBoolean(mFalse);
    }
    public void handleMTrue(PersistentMTrue mTrue) throws PersistenceException{
        this.handleMBoolean(mTrue);
    }
    
}

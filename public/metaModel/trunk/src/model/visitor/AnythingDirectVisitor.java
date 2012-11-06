
package model.visitor;

import persistence.*;

public abstract class AnythingDirectVisitor implements AnythingVisitor {
    
    public abstract void handleMAtomicType(PersistentMAtomicType mAtomicType) throws PersistenceException;
    
    public abstract void handleTypeManager(PersistentTypeManager typeManager) throws PersistenceException;
    
    public abstract void handleCommandExecuter(PersistentCommandExecuter commandExecuter) throws PersistenceException;
    
    public abstract void handleCommandCoordinator(PersistentCommandCoordinator commandCoordinator) throws PersistenceException;
    
    public abstract void handleMAspect(PersistentMAspect mAspect) throws PersistenceException;
    
    public abstract void handleCommonDate(PersistentCommonDate commonDate) throws PersistenceException;
    
    public void handleAddAspectCommand(PersistentAddAspectCommand addAspectCommand) throws PersistenceException{
        this.handleCommonDate(addAspectCommand);
    }
    public void handleAddAtomicTypeCommand(PersistentAddAtomicTypeCommand addAtomicTypeCommand) throws PersistenceException{
        this.handleCommonDate(addAtomicTypeCommand);
    }
    public void handleAddSubTypeCommand(PersistentAddSubTypeCommand addSubTypeCommand) throws PersistenceException{
        this.handleCommonDate(addSubTypeCommand);
    }
    public abstract void handleAspectManager(PersistentAspectManager aspectManager) throws PersistenceException;
    
    public abstract void handleErrorDisplay(PersistentErrorDisplay errorDisplay) throws PersistenceException;
    
    public abstract void handleServer(PersistentServer server) throws PersistenceException;
    
    public abstract void handleMComplexType(PersistentMComplexType mComplexType) throws PersistenceException;
    
    public void handleMProductType(PersistentMProductType mProductType) throws PersistenceException{
        this.handleMComplexType(mProductType);
    }
    public void handleMSumType(PersistentMSumType mSumType) throws PersistenceException{
        this.handleMComplexType(mSumType);
    }
    
}

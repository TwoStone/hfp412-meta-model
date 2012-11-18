
package model.visitor;

import persistence.*;

public abstract class CommonDateStandardVisitor implements CommonDateVisitor {
    
    public void handleCreateAtomicTypeCommand(PersistentCreateAtomicTypeCommand createAtomicTypeCommand) throws PersistenceException{
        this.standardHandling(createAtomicTypeCommand);
    }
    public void handleCreateAspectCommand(PersistentCreateAspectCommand createAspectCommand) throws PersistenceException{
        this.standardHandling(createAspectCommand);
    }
    public void handleCommonDate(PersistentCommonDate commonDate) throws PersistenceException{
        this.standardHandling(commonDate);
    }
    public void handleCreateSubTypeCommand(PersistentCreateSubTypeCommand createSubTypeCommand) throws PersistenceException{
        this.standardHandling(createSubTypeCommand);
    }
    public void handleAddSubTypeCommand(PersistentAddSubTypeCommand addSubTypeCommand) throws PersistenceException{
        this.standardHandling(addSubTypeCommand);
    }
    protected abstract void standardHandling(PersistentCommonDate commonDate) throws PersistenceException;
}

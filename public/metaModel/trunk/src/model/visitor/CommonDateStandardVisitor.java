
package model.visitor;

import persistence.*;

public abstract class CommonDateStandardVisitor implements CommonDateVisitor {
    
    public void handleAddAspectCommand(PersistentAddAspectCommand addAspectCommand) throws PersistenceException{
        this.standardHandling(addAspectCommand);
    }
    public void handleCommonDate(PersistentCommonDate commonDate) throws PersistenceException{
        this.standardHandling(commonDate);
    }
    public void handleAddAtomicTypeCommand(PersistentAddAtomicTypeCommand addAtomicTypeCommand) throws PersistenceException{
        this.standardHandling(addAtomicTypeCommand);
    }
    public void handleAddSubTypeCommand(PersistentAddSubTypeCommand addSubTypeCommand) throws PersistenceException{
        this.standardHandling(addSubTypeCommand);
    }
    protected abstract void standardHandling(PersistentCommonDate commonDate) throws PersistenceException;
}

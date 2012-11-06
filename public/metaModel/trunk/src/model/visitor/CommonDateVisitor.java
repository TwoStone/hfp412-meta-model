
package model.visitor;

import persistence.*;

public interface CommonDateVisitor {
    
    public void handleAddAspectCommand(PersistentAddAspectCommand addAspectCommand) throws PersistenceException;
    public void handleAddSubTypeCommand(PersistentAddSubTypeCommand addSubTypeCommand) throws PersistenceException;
    public void handleAddAtomicTypeCommand(PersistentAddAtomicTypeCommand addAtomicTypeCommand) throws PersistenceException;
    public void handleCommonDate(PersistentCommonDate commonDate) throws PersistenceException;
    
}

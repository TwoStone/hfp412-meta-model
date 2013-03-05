
package model.visitor;

import persistence.PersistenceException;
import persistence.PersistentAddFpCommand;
import persistence.PersistentAddMultipleFpCommand;
import persistence.PersistentCreateConstantCommand;
import persistence.PersistentCreateFpCommand;
import persistence.PersistentCreateOperationCommand;
import persistence.PersistentCreateStaticOpCommand;
import persistence.PersistentCreateVoidOperationCommand;
import persistence.PersistentRemoveFpCommand;
import persistence.PersistentRemoveFpFromOpCommand;
import persistence.PersistentRemoveOperationCommand;

public interface OperationManagerCommandVisitor {
    
    public void handleRemoveFpCommand(PersistentRemoveFpCommand removeFpCommand) throws PersistenceException;
    public void handleRemoveOperationCommand(PersistentRemoveOperationCommand removeOperationCommand) throws PersistenceException;
    public void handleCreateConstantCommand(PersistentCreateConstantCommand createConstantCommand) throws PersistenceException;
    public void handleCreateStaticOpCommand(PersistentCreateStaticOpCommand createStaticOpCommand) throws PersistenceException;
    public void handleCreateVoidOperationCommand(PersistentCreateVoidOperationCommand createVoidOperationCommand) throws PersistenceException;
    public void handleAddFpCommand(PersistentAddFpCommand addFpCommand) throws PersistenceException;
    public void handleCreateOperationCommand(PersistentCreateOperationCommand createOperationCommand) throws PersistenceException;
    public void handleAddMultipleFpCommand(PersistentAddMultipleFpCommand addMultipleFpCommand) throws PersistenceException;
    public void handleRemoveFpFromOpCommand(PersistentRemoveFpFromOpCommand removeFpFromOpCommand) throws PersistenceException;
    public void handleCreateFpCommand(PersistentCreateFpCommand createFpCommand) throws PersistenceException;
    
}

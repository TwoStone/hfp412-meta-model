
package model.visitor;
import model.UserException;
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

public interface OperationManagerCommandExceptionVisitor<E extends UserException> {
    
    public void handleRemoveFpCommand(PersistentRemoveFpCommand removeFpCommand) throws PersistenceException, E;
    public void handleRemoveOperationCommand(PersistentRemoveOperationCommand removeOperationCommand) throws PersistenceException, E;
    public void handleCreateConstantCommand(PersistentCreateConstantCommand createConstantCommand) throws PersistenceException, E;
    public void handleCreateStaticOpCommand(PersistentCreateStaticOpCommand createStaticOpCommand) throws PersistenceException, E;
    public void handleCreateVoidOperationCommand(PersistentCreateVoidOperationCommand createVoidOperationCommand) throws PersistenceException, E;
    public void handleAddFpCommand(PersistentAddFpCommand addFpCommand) throws PersistenceException, E;
    public void handleCreateOperationCommand(PersistentCreateOperationCommand createOperationCommand) throws PersistenceException, E;
    public void handleAddMultipleFpCommand(PersistentAddMultipleFpCommand addMultipleFpCommand) throws PersistenceException, E;
    public void handleRemoveFpFromOpCommand(PersistentRemoveFpFromOpCommand removeFpFromOpCommand) throws PersistenceException, E;
    public void handleCreateFpCommand(PersistentCreateFpCommand createFpCommand) throws PersistenceException, E;
    
}

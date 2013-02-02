
package model.visitor;
import model.UserException;
import persistence.PersistenceException;
import persistence.PersistentCreateLinkCommand;
import persistence.PersistentRemoveLinkCommand;

public interface LinkManagerCommandReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleRemoveLinkCommand(PersistentRemoveLinkCommand removeLinkCommand) throws PersistenceException, E;
    public R handleCreateLinkCommand(PersistentCreateLinkCommand createLinkCommand) throws PersistenceException, E;
    
}

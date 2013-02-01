
package model.visitor;
import model.UserException;
import persistence.*;

public interface LinkManagerCommandExceptionVisitor<E extends UserException> {
    
    public void handleRemoveLinkCommand(PersistentRemoveLinkCommand removeLinkCommand) throws PersistenceException, E;
    public void handleCreateLinkCommand(PersistentCreateLinkCommand createLinkCommand) throws PersistenceException, E;
    
}

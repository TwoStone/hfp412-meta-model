
package model.visitor;
import model.UserException;
import persistence.PersistenceException;
import persistence.PersistentLink;
import persistence.PersistentMessage;

public interface MessageOrLinkExceptionVisitor<E extends UserException> {
    
    public void handleMessage(PersistentMessage message) throws PersistenceException, E;
    public void handleLink(PersistentLink link) throws PersistenceException, E;
    
}

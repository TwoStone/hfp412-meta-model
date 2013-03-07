
package model.visitor;

import persistence.PersistenceException;
import persistence.PersistentLink;
import persistence.PersistentMessage;

public interface MessageOrLinkVisitor {
    
    public void handleMessage(PersistentMessage message) throws PersistenceException;
    public void handleLink(PersistentLink link) throws PersistenceException;
    
}

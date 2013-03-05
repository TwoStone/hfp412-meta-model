
package model.visitor;

import persistence.*;

public interface MessageOrLinkVisitor {
    
    public void handleMessage(PersistentMessage message) throws PersistenceException;
    public void handleLink(PersistentLink link) throws PersistenceException;
    
}

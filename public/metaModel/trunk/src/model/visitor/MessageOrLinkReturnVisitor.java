
package model.visitor;

import persistence.PersistenceException;
import persistence.PersistentLink;
import persistence.PersistentMessage;

public interface MessageOrLinkReturnVisitor<R> {
    
    public R handleMessage(PersistentMessage message) throws PersistenceException;
    public R handleLink(PersistentLink link) throws PersistenceException;
    
}

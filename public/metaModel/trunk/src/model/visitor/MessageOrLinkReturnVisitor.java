
package model.visitor;

import persistence.*;

public interface MessageOrLinkReturnVisitor<R> {
    
    public R handleMessage(PersistentMessage message) throws PersistenceException;
    public R handleLink(PersistentLink link) throws PersistenceException;
    
}


package model.visitor;
import model.UserException;
import persistence.*;

public interface MessageOrLinkReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleMessage(PersistentMessage message) throws PersistenceException, E;
    public R handleLink(PersistentLink link) throws PersistenceException, E;
    
}

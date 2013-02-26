
package model.visitor;
import model.UserException;
import persistence.*;

public interface AbsQuantityReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleCompoundQuantity(PersistentCompoundQuantity compoundQuantity) throws PersistenceException, E;
    public R handleQuantity(PersistentQuantity quantity) throws PersistenceException, E;
    
}

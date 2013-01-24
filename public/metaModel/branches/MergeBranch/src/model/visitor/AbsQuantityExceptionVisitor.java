
package model.visitor;
import model.UserException;
import persistence.*;

public interface AbsQuantityExceptionVisitor<E extends UserException> {
    
    public void handleQuantity(PersistentQuantity quantity) throws PersistenceException, E;
    public void handleCompoundQuantity(PersistentCompoundQuantity compoundQuantity) throws PersistenceException, E;
    
}
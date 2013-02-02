
package model.visitor;
import model.UserException;
import persistence.PersistenceException;
import persistence.PersistentCompoundQuantity;
import persistence.PersistentQuantity;

public interface AbsQuantityExceptionVisitor<E extends UserException> {
    
    public void handleCompoundQuantity(PersistentCompoundQuantity compoundQuantity) throws PersistenceException, E;
    public void handleQuantity(PersistentQuantity quantity) throws PersistenceException, E;
    
}

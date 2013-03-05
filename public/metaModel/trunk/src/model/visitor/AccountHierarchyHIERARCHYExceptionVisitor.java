
package model.visitor;
import model.UserException;
import persistence.*;

public interface AccountHierarchyHIERARCHYExceptionVisitor<E extends UserException> {
    
    public void handleAccount(PersistentAccount account) throws PersistenceException, E;
    
}

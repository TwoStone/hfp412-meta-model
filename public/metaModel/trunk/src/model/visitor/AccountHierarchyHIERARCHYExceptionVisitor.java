
package model.visitor;
import model.UserException;
import persistence.PersistenceException;
import persistence.PersistentAccount;

public interface AccountHierarchyHIERARCHYExceptionVisitor<E extends UserException> {
    
    public void handleAccount(PersistentAccount account) throws PersistenceException, E;
    
}

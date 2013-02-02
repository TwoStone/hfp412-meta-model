
package model.visitor;
import model.UserException;
import persistence.PersistenceException;
import persistence.PersistentAccount;

public interface AccountHierarchyHIERARCHYReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleAccount(PersistentAccount account) throws PersistenceException, E;
    
}

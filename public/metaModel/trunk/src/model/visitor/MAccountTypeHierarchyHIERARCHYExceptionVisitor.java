
package model.visitor;
import model.UserException;
import persistence.PersistenceException;
import persistence.PersistentMAccountType;

public interface MAccountTypeHierarchyHIERARCHYExceptionVisitor<E extends UserException> {
    
    public void handleMAccountType(PersistentMAccountType mAccountType) throws PersistenceException, E;
    
}

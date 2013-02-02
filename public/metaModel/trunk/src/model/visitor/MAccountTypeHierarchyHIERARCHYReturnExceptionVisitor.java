
package model.visitor;
import model.UserException;
import persistence.PersistenceException;
import persistence.PersistentMAccountType;

public interface MAccountTypeHierarchyHIERARCHYReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleMAccountType(PersistentMAccountType mAccountType) throws PersistenceException, E;
    
}

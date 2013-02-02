
package model.visitor;

import persistence.PersistenceException;
import persistence.PersistentAccount;

public interface AccountHierarchyHIERARCHYReturnVisitor<R> {
    
    public R handleAccount(PersistentAccount account) throws PersistenceException;
    
}

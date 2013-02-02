
package model.visitor;

import persistence.PersistenceException;
import persistence.PersistentAccount;

public interface AccountHierarchyHIERARCHYVisitor {
    
    public void handleAccount(PersistentAccount account) throws PersistenceException;
    
}


package model.visitor;

import persistence.PersistenceException;
import persistence.PersistentMAccountType;

public interface MAccountTypeHierarchyHIERARCHYVisitor {
    
    public void handleMAccountType(PersistentMAccountType mAccountType) throws PersistenceException;
    
}

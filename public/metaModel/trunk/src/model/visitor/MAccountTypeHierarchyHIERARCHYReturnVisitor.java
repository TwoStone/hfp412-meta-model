
package model.visitor;

import persistence.PersistenceException;
import persistence.PersistentMAccountType;

public interface MAccountTypeHierarchyHIERARCHYReturnVisitor<R> {
    
    public R handleMAccountType(PersistentMAccountType mAccountType) throws PersistenceException;
    
}

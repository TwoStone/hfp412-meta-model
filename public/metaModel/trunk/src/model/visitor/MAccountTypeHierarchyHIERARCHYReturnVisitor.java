
package model.visitor;

import persistence.*;

public interface MAccountTypeHierarchyHIERARCHYReturnVisitor<R> {
    
    public R handleMAccountType(PersistentMAccountType mAccountType) throws PersistenceException;
    
}

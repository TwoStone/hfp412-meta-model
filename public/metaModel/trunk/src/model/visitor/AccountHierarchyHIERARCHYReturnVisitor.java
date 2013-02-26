
package model.visitor;

import persistence.*;

public interface AccountHierarchyHIERARCHYReturnVisitor<R> {
    
    public R handleAccount(PersistentAccount account) throws PersistenceException;
    
}

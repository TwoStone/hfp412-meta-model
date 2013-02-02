
package model.visitor;

import persistence.*;

public interface AccountHierarchyHIERARCHYVisitor {
    
    public void handleAccount(PersistentAccount account) throws PersistenceException;
    
}

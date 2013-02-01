
package model.visitor;

import persistence.*;

public interface MAccountTypeHierarchyHIERARCHYVisitor {
    
    public void handleMAccountType(PersistentMAccountType mAccountType) throws PersistenceException;
    
}

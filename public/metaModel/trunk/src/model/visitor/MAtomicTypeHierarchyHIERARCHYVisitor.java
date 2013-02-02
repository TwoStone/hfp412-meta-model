
package model.visitor;

import persistence.*;

public interface MAtomicTypeHierarchyHIERARCHYVisitor {
    
    public void handleMAtomicType(PersistentMAtomicType mAtomicType) throws PersistenceException;
    
}

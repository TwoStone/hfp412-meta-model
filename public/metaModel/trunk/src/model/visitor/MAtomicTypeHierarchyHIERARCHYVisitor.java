
package model.visitor;

import persistence.PersistenceException;
import persistence.PersistentMAtomicType;

public interface MAtomicTypeHierarchyHIERARCHYVisitor {
    
    public void handleMAtomicType(PersistentMAtomicType mAtomicType) throws PersistenceException;
    
}

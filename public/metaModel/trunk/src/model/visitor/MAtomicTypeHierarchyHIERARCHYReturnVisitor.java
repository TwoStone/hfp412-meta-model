
package model.visitor;

import persistence.PersistenceException;
import persistence.PersistentMAtomicType;

public interface MAtomicTypeHierarchyHIERARCHYReturnVisitor<R> {
    
    public R handleMAtomicType(PersistentMAtomicType mAtomicType) throws PersistenceException;
    
}

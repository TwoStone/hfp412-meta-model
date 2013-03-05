
package model.visitor;

import persistence.*;

public interface MAtomicTypeHierarchyHIERARCHYReturnVisitor<R> {
    
    public R handleMAtomicType(PersistentMAtomicType mAtomicType) throws PersistenceException;
    
}

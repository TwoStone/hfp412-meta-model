
package model.visitor;

import persistence.MAtomicTypeHierarchyHIERARCHY;
import persistence.PersistenceException;
import persistence.PersistentMAtomicType;

public abstract class MAtomicTypeHierarchyHIERARCHYStandardVisitor implements MAtomicTypeHierarchyHIERARCHYVisitor {
    
    public void handleMAtomicType(PersistentMAtomicType mAtomicType) throws PersistenceException{
        this.standardHandling(mAtomicType);
    }
    protected abstract void standardHandling(MAtomicTypeHierarchyHIERARCHY mAtomicTypeHierarchyHIERARCHY) throws PersistenceException;
}

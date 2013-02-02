
package model.visitor;

import persistence.MComplexTypeHierarchyHIERARCHY;
import persistence.PersistenceException;
import persistence.PersistentMAtomicType;
import persistence.PersistentMEmptyProductType;
import persistence.PersistentMEmptySumType;
import persistence.PersistentMProductType;
import persistence.PersistentMSumType;

public abstract class MComplexTypeHierarchyHIERARCHYStandardVisitor implements MComplexTypeHierarchyHIERARCHYVisitor {
    
    public void handleMProductType(PersistentMProductType mProductType) throws PersistenceException{
        this.standardHandling(mProductType);
    }
    public void handleMAtomicType(PersistentMAtomicType mAtomicType) throws PersistenceException{
        this.standardHandling(mAtomicType);
    }
    public void handleMEmptySumType(PersistentMEmptySumType mEmptySumType) throws PersistenceException{
        this.standardHandling(mEmptySumType);
    }
    public void handleMSumType(PersistentMSumType mSumType) throws PersistenceException{
        this.standardHandling(mSumType);
    }
    public void handleMEmptyProductType(PersistentMEmptyProductType mEmptyProductType) throws PersistenceException{
        this.standardHandling(mEmptyProductType);
    }
    protected abstract void standardHandling(MComplexTypeHierarchyHIERARCHY mComplexTypeHierarchyHIERARCHY) throws PersistenceException;
}

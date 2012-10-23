
package model.visitor;

import persistence.*;

public abstract class MCTypeHierarchyHIERARCHYStandardVisitor implements MCTypeHierarchyHIERARCHYVisitor {
    
    public void handleMAtomicType(PersistentMAtomicType mAtomicType) throws PersistenceException{
        this.standardHandling(mAtomicType);
    }
    public void handleMProductType(PersistentMProductType mProductType) throws PersistenceException{
        this.standardHandling(mProductType);
    }
    public void handleMSumType(PersistentMSumType mSumType) throws PersistenceException{
        this.standardHandling(mSumType);
    }
    protected abstract void standardHandling(MCTypeHierarchyHIERARCHY mCTypeHierarchyHIERARCHY) throws PersistenceException;
}

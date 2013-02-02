
package model.visitor;

import persistence.*;

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
    public void handleMAtomicTypeProduct(PersistentMAtomicTypeProduct mAtomicTypeProduct) throws PersistenceException{
        this.standardHandling(mAtomicTypeProduct);
    }
    public void handleMDisjunctiveNF(PersistentMDisjunctiveNF mDisjunctiveNF) throws PersistenceException{
        this.standardHandling(mDisjunctiveNF);
    }
    protected abstract void standardHandling(MComplexTypeHierarchyHIERARCHY mComplexTypeHierarchyHIERARCHY) throws PersistenceException;
}


package model.visitor;

import persistence.*;

public abstract class MTypeStandardVisitor implements MTypeVisitor {
    
    public void handleMAtomicType(PersistentMAtomicType mAtomicType) throws PersistenceException{
        this.standardHandling(mAtomicType);
    }
    public void handleMProductType(PersistentMProductType mProductType) throws PersistenceException{
        this.standardHandling(mProductType);
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
    public void handleMDisjunctiveNF(PersistentMDisjunctiveNF mDisjunctiveNF) throws PersistenceException{
        this.standardHandling(mDisjunctiveNF);
    }
    public void handleMAtomicTypeProduct(PersistentMAtomicTypeProduct mAtomicTypeProduct) throws PersistenceException{
        this.standardHandling(mAtomicTypeProduct);
    }
    protected abstract void standardHandling(PersistentMType mType) throws PersistenceException;
}


package model.visitor;

import persistence.*;

public abstract class MTypeDirectVisitor implements MTypeVisitor {
    
    public abstract void handleMAtomicType(PersistentMAtomicType mAtomicType) throws PersistenceException;
    
    public abstract void handleMComplexType(PersistentMComplexType mComplexType) throws PersistenceException;
    
    public void handleMProductType(PersistentMProductType mProductType) throws PersistenceException{
        this.handleMComplexType(mProductType);
    }
    public void handleMEmptySumType(PersistentMEmptySumType mEmptySumType) throws PersistenceException{
        this.handleMComplexType(mEmptySumType);
    }
    public void handleMSumType(PersistentMSumType mSumType) throws PersistenceException{
        this.handleMComplexType(mSumType);
    }
    public void handleMEmptyProductType(PersistentMEmptyProductType mEmptyProductType) throws PersistenceException{
        this.handleMComplexType(mEmptyProductType);
    }
    public void handleMAtomicTypeProduct(PersistentMAtomicTypeProduct mAtomicTypeProduct) throws PersistenceException{
        this.handleMComplexType(mAtomicTypeProduct);
    }
    public void handleMDisjunctiveNF(PersistentMDisjunctiveNF mDisjunctiveNF) throws PersistenceException{
        this.handleMComplexType(mDisjunctiveNF);
    }
    
}

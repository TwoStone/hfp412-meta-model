
package model.visitor;

import persistence.*;

public abstract class MComplexTypeDirectVisitor implements MComplexTypeVisitor {
    
    public abstract void handleMAbstractSumType(PersistentMAbstractSumType mAbstractSumType) throws PersistenceException;
    
    public void handleMEmptySumType(PersistentMEmptySumType mEmptySumType) throws PersistenceException{
        this.handleMAbstractSumType(mEmptySumType);
    }
    public void handleMSumType(PersistentMSumType mSumType) throws PersistenceException{
        this.handleMAbstractSumType(mSumType);
    }
    public void handleMDisjunctiveNF(PersistentMDisjunctiveNF mDisjunctiveNF) throws PersistenceException{
        this.handleMAbstractSumType(mDisjunctiveNF);
    }
    public abstract void handleMAbstractProductType(PersistentMAbstractProductType mAbstractProductType) throws PersistenceException;
    
    public void handleMProductType(PersistentMProductType mProductType) throws PersistenceException{
        this.handleMAbstractProductType(mProductType);
    }
    public void handleMEmptyProductType(PersistentMEmptyProductType mEmptyProductType) throws PersistenceException{
        this.handleMAbstractProductType(mEmptyProductType);
    }
    public void handleMAtomicTypeProduct(PersistentMAtomicTypeProduct mAtomicTypeProduct) throws PersistenceException{
        this.handleMAbstractProductType(mAtomicTypeProduct);
    }
    
}

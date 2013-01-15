
package model.visitor;

import persistence.*;

public abstract class MAbstractProductTypeStandardVisitor implements MAbstractProductTypeVisitor {
    
    public void handleMProductType(PersistentMProductType mProductType) throws PersistenceException{
        this.standardHandling(mProductType);
    }
    public void handleMEmptyProduct(PersistentMEmptyProduct mEmptyProduct) throws PersistenceException{
        this.standardHandling(mEmptyProduct);
    }
    public void handleMAbstractProductType(PersistentMAbstractProductType mAbstractProductType) throws PersistenceException{
        this.standardHandling(mAbstractProductType);
    }
    protected abstract void standardHandling(PersistentMAbstractProductType mAbstractProductType) throws PersistenceException;
}

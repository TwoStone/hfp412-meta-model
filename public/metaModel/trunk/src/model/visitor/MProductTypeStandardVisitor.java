
package model.visitor;

import persistence.*;

public abstract class MProductTypeStandardVisitor implements MProductTypeVisitor {
    
    public void handleMProductType(PersistentMProductType mProductType) throws PersistenceException{
        this.standardHandling(mProductType);
    }
    public void handleMEmptyProduct(PersistentMEmptyProduct mEmptyProduct) throws PersistenceException{
        this.standardHandling(mEmptyProduct);
    }
    protected abstract void standardHandling(PersistentMProductType mProductType) throws PersistenceException;
}


package model.visitor;

import persistence.PersistenceException;
import persistence.PersistentMAbstractProductType;
import persistence.PersistentMEmptyProductType;
import persistence.PersistentMProductType;

public abstract class MAbstractProductTypeStandardVisitor implements MAbstractProductTypeVisitor {
    
    public void handleMProductType(PersistentMProductType mProductType) throws PersistenceException{
        this.standardHandling(mProductType);
    }
    public void handleMEmptyProductType(PersistentMEmptyProductType mEmptyProductType) throws PersistenceException{
        this.standardHandling(mEmptyProductType);
    }
    protected abstract void standardHandling(PersistentMAbstractProductType mAbstractProductType) throws PersistenceException;
}

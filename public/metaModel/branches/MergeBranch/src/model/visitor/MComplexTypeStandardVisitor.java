
package model.visitor;

import persistence.*;

public abstract class MComplexTypeStandardVisitor implements MComplexTypeVisitor {
    
    public void handleMProductType(PersistentMProductType mProductType) throws PersistenceException{
        this.standardHandling(mProductType);
    }
    public void handleMSumType(PersistentMSumType mSumType) throws PersistenceException{
        this.standardHandling(mSumType);
    }
    protected abstract void standardHandling(PersistentMComplexType mComplexType) throws PersistenceException;
}

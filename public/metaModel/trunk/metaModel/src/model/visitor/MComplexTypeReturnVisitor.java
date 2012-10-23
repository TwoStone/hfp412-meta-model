
package model.visitor;

import persistence.*;

public interface MComplexTypeReturnVisitor<R> {
    
    public R handleMProductType(PersistentMProductType mProductType) throws PersistenceException;
    public R handleMSumType(PersistentMSumType mSumType) throws PersistenceException;
    
}

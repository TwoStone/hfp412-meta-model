
package model.visitor;

import persistence.*;

public interface MComplexTypeReturnVisitor<R> extends MProductTypeReturnVisitor<R> ,MSumTypeReturnVisitor<R> {
    
    public R handleMProductType(PersistentMProductType mProductType) throws PersistenceException;
    public R handleMSumType(PersistentMSumType mSumType) throws PersistenceException;
    
}


package model.visitor;

import persistence.*;

public interface MComplexTypeReturnVisitor<R> extends MAbstractSumTypeReturnVisitor<R> ,MAbstractProductTypeReturnVisitor<R> {
    
    public R handleMAbstractProductType(PersistentMAbstractProductType mAbstractProductType) throws PersistenceException;
    
}

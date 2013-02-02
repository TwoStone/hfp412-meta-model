
package model.visitor;

import persistence.*;

public interface MAbstractProductTypeReturnVisitor<R> extends MNonEmptyProductTypeReturnVisitor<R> {
    
    public R handleMEmptyProductType(PersistentMEmptyProductType mEmptyProductType) throws PersistenceException;
    
}

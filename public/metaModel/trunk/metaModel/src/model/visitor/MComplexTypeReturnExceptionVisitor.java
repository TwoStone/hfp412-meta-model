
package model.visitor;

import persistence.*;

public interface MComplexTypeReturnExceptionVisitor<R, E extends model.UserException> {
    
    public R handleMProductType(PersistentMProductType mProductType) throws PersistenceException, E;
    public R handleMSumType(PersistentMSumType mSumType) throws PersistenceException, E;
    
}


package model.visitor;

import persistence.*;

public interface MComplexTypeExceptionVisitor<E extends model.UserException> {
    
    public void handleMProductType(PersistentMProductType mProductType) throws PersistenceException, E;
    public void handleMSumType(PersistentMSumType mSumType) throws PersistenceException, E;
    
}

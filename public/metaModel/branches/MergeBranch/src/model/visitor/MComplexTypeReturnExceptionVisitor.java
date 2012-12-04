
package model.visitor;
import model.UserException;
import persistence.*;

public interface MComplexTypeReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleMProductType(PersistentMProductType mProductType) throws PersistenceException, E;
    public R handleMSumType(PersistentMSumType mSumType) throws PersistenceException, E;
    
}

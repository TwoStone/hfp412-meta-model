
package model.visitor;
import model.UserException;
import persistence.*;

public interface MComplexTypeReturnExceptionVisitor<R, E extends UserException> extends MProductTypeReturnExceptionVisitor<R, E> ,MSumTypeReturnExceptionVisitor<R, E> {
    
    public R handleMProductType(PersistentMProductType mProductType) throws PersistenceException, E;
    public R handleMSumType(PersistentMSumType mSumType) throws PersistenceException, E;
    
}

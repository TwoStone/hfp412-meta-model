
package model.visitor;
import model.UserException;
import persistence.*;

public interface MComplexTypeReturnExceptionVisitor<R, E extends UserException> extends MAbstractSumTypeReturnExceptionVisitor<R, E> ,MAbstractProductTypeReturnExceptionVisitor<R, E> {
    
    public R handleMAbstractProductType(PersistentMAbstractProductType mAbstractProductType) throws PersistenceException, E;
    
}

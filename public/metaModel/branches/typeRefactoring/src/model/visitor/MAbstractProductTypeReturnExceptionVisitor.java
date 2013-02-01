
package model.visitor;
import model.UserException;
import persistence.*;

public interface MAbstractProductTypeReturnExceptionVisitor<R, E extends UserException> extends MNonEmptyProductTypeReturnExceptionVisitor<R, E> {
    
    public R handleMEmptyProductType(PersistentMEmptyProductType mEmptyProductType) throws PersistenceException, E;
    
}

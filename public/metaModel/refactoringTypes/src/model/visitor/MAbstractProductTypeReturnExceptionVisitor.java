
package model.visitor;
import model.UserException;
import persistence.*;

public interface MAbstractProductTypeReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleMProductType(PersistentMProductType mProductType) throws PersistenceException, E;
    public R handleMEmptyProductType(PersistentMEmptyProductType mEmptyProductType) throws PersistenceException, E;
    
}

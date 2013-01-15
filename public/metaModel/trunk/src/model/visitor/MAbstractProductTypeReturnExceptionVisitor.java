
package model.visitor;
import model.UserException;
import persistence.*;

public interface MAbstractProductTypeReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleMEmptyProduct(PersistentMEmptyProduct mEmptyProduct) throws PersistenceException, E;
    public R handleMProductType(PersistentMProductType mProductType) throws PersistenceException, E;
    public R handleMAbstractProductType(PersistentMAbstractProductType mAbstractProductType) throws PersistenceException, E;
    
}

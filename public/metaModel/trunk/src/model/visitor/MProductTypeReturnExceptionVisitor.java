
package model.visitor;
import model.UserException;
import persistence.*;

public interface MProductTypeReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleMEmptyProduct(PersistentMEmptyProduct mEmptyProduct) throws PersistenceException, E;
    public R handleMProductType(PersistentMProductType mProductType) throws PersistenceException, E;
    
}

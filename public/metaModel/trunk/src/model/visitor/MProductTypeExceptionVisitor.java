
package model.visitor;
import model.UserException;
import persistence.*;

public interface MProductTypeExceptionVisitor<E extends UserException> {
    
    public void handleMEmptyProduct(PersistentMEmptyProduct mEmptyProduct) throws PersistenceException, E;
    public void handleMProductType(PersistentMProductType mProductType) throws PersistenceException, E;
    
}

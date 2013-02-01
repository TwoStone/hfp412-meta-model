
package model.visitor;
import model.UserException;
import persistence.*;

public interface MNonEmptyProductTypeReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleMAtomicTypeProduct(PersistentMAtomicTypeProduct mAtomicTypeProduct) throws PersistenceException, E;
    public R handleMProductType(PersistentMProductType mProductType) throws PersistenceException, E;
    
}

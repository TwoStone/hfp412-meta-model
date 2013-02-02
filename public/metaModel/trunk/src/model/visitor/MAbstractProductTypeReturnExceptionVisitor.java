
package model.visitor;
import model.UserException;
import persistence.PersistenceException;
import persistence.PersistentMEmptyProductType;
import persistence.PersistentMProductType;

public interface MAbstractProductTypeReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleMProductType(PersistentMProductType mProductType) throws PersistenceException, E;
    public R handleMEmptyProductType(PersistentMEmptyProductType mEmptyProductType) throws PersistenceException, E;
    
}

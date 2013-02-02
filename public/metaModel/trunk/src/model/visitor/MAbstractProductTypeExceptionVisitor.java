
package model.visitor;
import model.UserException;
import persistence.PersistenceException;
import persistence.PersistentMEmptyProductType;
import persistence.PersistentMProductType;

public interface MAbstractProductTypeExceptionVisitor<E extends UserException> {
    
    public void handleMProductType(PersistentMProductType mProductType) throws PersistenceException, E;
    public void handleMEmptyProductType(PersistentMEmptyProductType mEmptyProductType) throws PersistenceException, E;
    
}

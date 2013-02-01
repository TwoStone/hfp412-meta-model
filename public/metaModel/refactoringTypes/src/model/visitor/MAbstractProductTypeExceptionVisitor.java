
package model.visitor;
import model.UserException;
import persistence.*;

public interface MAbstractProductTypeExceptionVisitor<E extends UserException> {
    
    public void handleMProductType(PersistentMProductType mProductType) throws PersistenceException, E;
    public void handleMEmptyProductType(PersistentMEmptyProductType mEmptyProductType) throws PersistenceException, E;
    
}

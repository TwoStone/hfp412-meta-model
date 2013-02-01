
package model.visitor;
import model.UserException;
import persistence.*;

public interface MNonEmptyProductTypeExceptionVisitor<E extends UserException> {
    
    public void handleMAtomicTypeProduct(PersistentMAtomicTypeProduct mAtomicTypeProduct) throws PersistenceException, E;
    public void handleMProductType(PersistentMProductType mProductType) throws PersistenceException, E;
    
}

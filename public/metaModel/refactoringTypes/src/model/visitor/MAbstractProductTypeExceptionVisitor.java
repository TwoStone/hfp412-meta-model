
package model.visitor;
import model.UserException;
import persistence.*;

public interface MAbstractProductTypeExceptionVisitor<E extends UserException> extends MNonEmptyProductTypeExceptionVisitor<E>{
    
    public void handleMEmptyProductType(PersistentMEmptyProductType mEmptyProductType) throws PersistenceException, E;
    
}

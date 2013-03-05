
package model.visitor;
import model.UserException;
import persistence.*;

public interface MModelItemReturnExceptionVisitor<R, E extends UserException> extends AbstractObjectReturnExceptionVisitor<R, E> ,MTypeReturnExceptionVisitor<R, E> ,MessageOrLinkReturnExceptionVisitor<R, E> {
    
    public R handleCONCMModelItem(PersistentCONCMModelItem cONCMModelItem) throws PersistenceException, E;
    
}

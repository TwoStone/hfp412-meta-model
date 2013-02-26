
package model.visitor;
import model.UserException;
import persistence.*;

public interface MModelItemReturnExceptionVisitor<R, E extends UserException> extends MTypeReturnExceptionVisitor<R, E> {
    
    public R handleCONCMModelItem(PersistentCONCMModelItem cONCMModelItem) throws PersistenceException, E;
    
}


package model.visitor;
import model.UserException;
import persistence.*;

public interface MModelItemExceptionVisitor<E extends UserException> extends MTypeExceptionVisitor<E>{
    
    public void handleCONCMModelItem(PersistentCONCMModelItem cONCMModelItem) throws PersistenceException, E;
    
}


package model.visitor;
import model.UserException;
import persistence.*;

public interface MModelItemExceptionVisitor<E extends UserException> extends AbstractObjectExceptionVisitor<E>,MTypeExceptionVisitor<E>,MessageOrLinkExceptionVisitor<E>{
    
    public void handleCONCMModelItem(PersistentCONCMModelItem cONCMModelItem) throws PersistenceException, E;
    
}

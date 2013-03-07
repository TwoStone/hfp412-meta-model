
package model.visitor;
import model.UserException;
import persistence.*;

public interface MModelItemReturnExceptionVisitor<R, E extends UserException> extends AbstractObjectReturnExceptionVisitor<R, E> ,MTypeReturnExceptionVisitor<R, E> ,MessageOrLinkReturnExceptionVisitor<R, E> {
    
    public R handleMEnum(PersistentMEnum mEnum) throws PersistenceException, E;
    public R handleMEnumValue(PersistentMEnumValue mEnumValue) throws PersistenceException, E;
    public R handleMObservationType(PersistentMObservationType mObservationType) throws PersistenceException, E;
    public R handleMObservation(PersistentMObservation mObservation) throws PersistenceException, E;
    public R handleCONCMModelItem(PersistentCONCMModelItem cONCMModelItem) throws PersistenceException, E;
    
}

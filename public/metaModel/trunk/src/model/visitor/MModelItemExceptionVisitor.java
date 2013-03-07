
package model.visitor;
import model.UserException;
import persistence.PersistenceException;
import persistence.PersistentCONCMModelItem;
import persistence.PersistentMEnum;
import persistence.PersistentMEnumValue;
import persistence.PersistentMObservation;
import persistence.PersistentMObservationType;

public interface MModelItemExceptionVisitor<E extends UserException> extends AbstractObjectExceptionVisitor<E>,MTypeExceptionVisitor<E>,MessageOrLinkExceptionVisitor<E>{
    
    public void handleMEnum(PersistentMEnum mEnum) throws PersistenceException, E;
    public void handleMEnumValue(PersistentMEnumValue mEnumValue) throws PersistenceException, E;
    public void handleMObservationType(PersistentMObservationType mObservationType) throws PersistenceException, E;
    public void handleMObservation(PersistentMObservation mObservation) throws PersistenceException, E;
    public void handleCONCMModelItem(PersistentCONCMModelItem cONCMModelItem) throws PersistenceException, E;
    
}

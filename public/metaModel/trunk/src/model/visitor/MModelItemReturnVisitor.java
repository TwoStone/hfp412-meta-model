
package model.visitor;

import persistence.PersistenceException;
import persistence.PersistentCONCMModelItem;
import persistence.PersistentMEnum;
import persistence.PersistentMEnumValue;
import persistence.PersistentMObservation;
import persistence.PersistentMObservationType;

public interface MModelItemReturnVisitor<R> extends AbstractObjectReturnVisitor<R> ,MTypeReturnVisitor<R> ,MessageOrLinkReturnVisitor<R> {
    
    public R handleMEnum(PersistentMEnum mEnum) throws PersistenceException;
    public R handleMEnumValue(PersistentMEnumValue mEnumValue) throws PersistenceException;
    public R handleMObservationType(PersistentMObservationType mObservationType) throws PersistenceException;
    public R handleMObservation(PersistentMObservation mObservation) throws PersistenceException;
    public R handleCONCMModelItem(PersistentCONCMModelItem cONCMModelItem) throws PersistenceException;
    
}

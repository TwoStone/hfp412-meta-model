
package model.visitor;

import persistence.PersistenceException;
import persistence.PersistentCONCMModelItem;
import persistence.PersistentMEnum;
import persistence.PersistentMEnumValue;
import persistence.PersistentMObservation;
import persistence.PersistentMObservationType;

public interface MModelItemVisitor extends AbstractObjectVisitor,MTypeVisitor,MessageOrLinkVisitor{
    
    public void handleMEnum(PersistentMEnum mEnum) throws PersistenceException;
    public void handleMEnumValue(PersistentMEnumValue mEnumValue) throws PersistenceException;
    public void handleMObservationType(PersistentMObservationType mObservationType) throws PersistenceException;
    public void handleMObservation(PersistentMObservation mObservation) throws PersistenceException;
    public void handleCONCMModelItem(PersistentCONCMModelItem cONCMModelItem) throws PersistenceException;
    
}

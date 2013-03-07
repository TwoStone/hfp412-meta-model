
package model.visitor;

import persistence.*;

public abstract class MModelItemStandardVisitor implements MModelItemVisitor {
    
    public void handleMEnum(PersistentMEnum mEnum) throws PersistenceException{
        this.standardHandling(mEnum);
    }
    public void handleMMixedTypeDisjunction(PersistentMMixedTypeDisjunction mMixedTypeDisjunction) throws PersistenceException{
        this.standardHandling(mMixedTypeDisjunction);
    }
    public void handleMEnumValue(PersistentMEnumValue mEnumValue) throws PersistenceException{
        this.standardHandling(mEnumValue);
    }
    public void handleMNonEmptyAtomicTypeConjunction(PersistentMNonEmptyAtomicTypeConjunction mNonEmptyAtomicTypeConjunction) throws PersistenceException{
        this.standardHandling(mNonEmptyAtomicTypeConjunction);
    }
    public void handleMEmptyTypeConjunction(PersistentMEmptyTypeConjunction mEmptyTypeConjunction) throws PersistenceException{
        this.standardHandling(mEmptyTypeConjunction);
    }
    public void handleCONCMModelItem(PersistentCONCMModelItem cONCMModelItem) throws PersistenceException{
        this.standardHandling(cONCMModelItem);
    }
    public void handleMessage(PersistentMessage message) throws PersistenceException{
        this.standardHandling(message);
    }
    public void handleMObservationType(PersistentMObservationType mObservationType) throws PersistenceException{
        this.standardHandling(mObservationType);
    }
    public void handleMMixedConjunction(PersistentMMixedConjunction mMixedConjunction) throws PersistenceException{
        this.standardHandling(mMixedConjunction);
    }
    public void handleMNonEmptyDisjunctiveNormalForm(PersistentMNonEmptyDisjunctiveNormalForm mNonEmptyDisjunctiveNormalForm) throws PersistenceException{
        this.standardHandling(mNonEmptyDisjunctiveNormalForm);
    }
    public void handleMSingletonObject(PersistentMSingletonObject mSingletonObject) throws PersistenceException{
        this.standardHandling(mSingletonObject);
    }
    public void handleMAtomicType(PersistentMAtomicType mAtomicType) throws PersistenceException{
        this.standardHandling(mAtomicType);
    }
    public void handleLink(PersistentLink link) throws PersistenceException{
        this.standardHandling(link);
    }
    public void handleMEmptyTypeDisjunction(PersistentMEmptyTypeDisjunction mEmptyTypeDisjunction) throws PersistenceException{
        this.standardHandling(mEmptyTypeDisjunction);
    }
    public void handleMObservation(PersistentMObservation mObservation) throws PersistenceException{
        this.standardHandling(mObservation);
    }
    public void handleMObject(PersistentMObject mObject) throws PersistenceException{
        this.standardHandling(mObject);
    }
    protected abstract void standardHandling(PersistentMModelItem mModelItem) throws PersistenceException;
}

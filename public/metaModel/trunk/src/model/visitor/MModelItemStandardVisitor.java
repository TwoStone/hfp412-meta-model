
package model.visitor;

import persistence.*;

public abstract class MModelItemStandardVisitor implements MModelItemVisitor {
    
    public void handleMAtomicType(PersistentMAtomicType mAtomicType) throws PersistenceException{
        this.standardHandling(mAtomicType);
    }
    public void handleMMixedTypeDisjunction(PersistentMMixedTypeDisjunction mMixedTypeDisjunction) throws PersistenceException{
        this.standardHandling(mMixedTypeDisjunction);
    }
    public void handleLink(PersistentLink link) throws PersistenceException{
        this.standardHandling(link);
    }
    public void handleMEmptyTypeConjunction(PersistentMEmptyTypeConjunction mEmptyTypeConjunction) throws PersistenceException{
        this.standardHandling(mEmptyTypeConjunction);
    }
    public void handleMNonEmptyAtomicTypeConjunction(PersistentMNonEmptyAtomicTypeConjunction mNonEmptyAtomicTypeConjunction) throws PersistenceException{
        this.standardHandling(mNonEmptyAtomicTypeConjunction);
    }
    public void handleCONCMModelItem(PersistentCONCMModelItem cONCMModelItem) throws PersistenceException{
        this.standardHandling(cONCMModelItem);
    }
    public void handleMessage(PersistentMessage message) throws PersistenceException{
        this.standardHandling(message);
    }
    public void handleMEmptyTypeDisjunction(PersistentMEmptyTypeDisjunction mEmptyTypeDisjunction) throws PersistenceException{
        this.standardHandling(mEmptyTypeDisjunction);
    }
    public void handleMMixedConjunction(PersistentMMixedConjunction mMixedConjunction) throws PersistenceException{
        this.standardHandling(mMixedConjunction);
    }
    public void handleMNonEmptyDisjunctiveNormalForm(PersistentMNonEmptyDisjunctiveNormalForm mNonEmptyDisjunctiveNormalForm) throws PersistenceException{
        this.standardHandling(mNonEmptyDisjunctiveNormalForm);
    }
    protected abstract void standardHandling(PersistentMModelItem mModelItem) throws PersistenceException;
}


package model.visitor;

import persistence.PersistenceException;
import persistence.PersistentAbstractObject;
import persistence.PersistentCONCMModelItem;
import persistence.PersistentLink;
import persistence.PersistentMAtomicType;
import persistence.PersistentMEmptyTypeConjunction;
import persistence.PersistentMEmptyTypeDisjunction;
import persistence.PersistentMMixedConjunction;
import persistence.PersistentMMixedTypeDisjunction;
import persistence.PersistentMNonEmptyAtomicTypeConjunction;
import persistence.PersistentMNonEmptyDisjunctiveNormalForm;
import persistence.PersistentMObject;
import persistence.PersistentMSingletonObject;
import persistence.PersistentMType;
import persistence.PersistentMessage;
import persistence.PersistentMessageOrLink;

public abstract class MModelItemDirectVisitor implements MModelItemVisitor {
    
    public abstract void handleAbstractObject(PersistentAbstractObject abstractObject) throws PersistenceException;
    
    public void handleMSingletonObject(PersistentMSingletonObject mSingletonObject) throws PersistenceException{
        this.handleAbstractObject(mSingletonObject);
    }
    public void handleMObject(PersistentMObject mObject) throws PersistenceException{
        this.handleAbstractObject(mObject);
    }
    public abstract void handleMType(PersistentMType mType) throws PersistenceException;
    
    public void handleMAtomicType(PersistentMAtomicType mAtomicType) throws PersistenceException{
        this.handleMType(mAtomicType);
    }
    public void handleMMixedTypeDisjunction(PersistentMMixedTypeDisjunction mMixedTypeDisjunction) throws PersistenceException{
        this.handleMType(mMixedTypeDisjunction);
    }
    public void handleMNonEmptyAtomicTypeConjunction(PersistentMNonEmptyAtomicTypeConjunction mNonEmptyAtomicTypeConjunction) throws PersistenceException{
        this.handleMType(mNonEmptyAtomicTypeConjunction);
    }
    public void handleMEmptyTypeConjunction(PersistentMEmptyTypeConjunction mEmptyTypeConjunction) throws PersistenceException{
        this.handleMType(mEmptyTypeConjunction);
    }
    public void handleMEmptyTypeDisjunction(PersistentMEmptyTypeDisjunction mEmptyTypeDisjunction) throws PersistenceException{
        this.handleMType(mEmptyTypeDisjunction);
    }
    public void handleMMixedConjunction(PersistentMMixedConjunction mMixedConjunction) throws PersistenceException{
        this.handleMType(mMixedConjunction);
    }
    public void handleMNonEmptyDisjunctiveNormalForm(PersistentMNonEmptyDisjunctiveNormalForm mNonEmptyDisjunctiveNormalForm) throws PersistenceException{
        this.handleMType(mNonEmptyDisjunctiveNormalForm);
    }
    public abstract void handleCONCMModelItem(PersistentCONCMModelItem cONCMModelItem) throws PersistenceException;
    
    public abstract void handleMessageOrLink(PersistentMessageOrLink messageOrLink) throws PersistenceException;
    
    public void handleLink(PersistentLink link) throws PersistenceException{
        this.handleMessageOrLink(link);
    }
    public void handleMessage(PersistentMessage message) throws PersistenceException{
        this.handleMessageOrLink(message);
    }
    
}

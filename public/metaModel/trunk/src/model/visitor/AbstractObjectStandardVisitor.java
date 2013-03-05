
package model.visitor;

import persistence.*;

public abstract class AbstractObjectStandardVisitor implements AbstractObjectVisitor {
    
    public void handleMSingletonObject(PersistentMSingletonObject mSingletonObject) throws PersistenceException{
        this.standardHandling(mSingletonObject);
    }
    public void handleMObject(PersistentMObject mObject) throws PersistenceException{
        this.standardHandling(mObject);
    }
    protected abstract void standardHandling(PersistentAbstractObject abstractObject) throws PersistenceException;
}

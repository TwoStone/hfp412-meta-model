
package model.visitor;

import persistence.PersistenceException;
import persistence.PersistentMObject;
import persistence.PersistentMSingletonObject;

public interface AbstractObjectVisitor {
    
    public void handleMObject(PersistentMObject mObject) throws PersistenceException;
    public void handleMSingletonObject(PersistentMSingletonObject mSingletonObject) throws PersistenceException;
    
}

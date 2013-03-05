
package model.visitor;

import persistence.PersistenceException;
import persistence.PersistentMObject;
import persistence.PersistentMSingletonObject;

public interface AbstractObjectReturnVisitor<R> {
    
    public R handleMObject(PersistentMObject mObject) throws PersistenceException;
    public R handleMSingletonObject(PersistentMSingletonObject mSingletonObject) throws PersistenceException;
    
}

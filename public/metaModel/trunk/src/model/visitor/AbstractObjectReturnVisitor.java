
package model.visitor;

import persistence.*;

public interface AbstractObjectReturnVisitor<R> {
    
    public R handleMObject(PersistentMObject mObject) throws PersistenceException;
    public R handleMSingletonObject(PersistentMSingletonObject mSingletonObject) throws PersistenceException;
    
}

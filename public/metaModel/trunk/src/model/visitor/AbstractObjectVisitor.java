
package model.visitor;

import persistence.*;

public interface AbstractObjectVisitor {
    
    public void handleMObject(PersistentMObject mObject) throws PersistenceException;
    public void handleMSingletonObject(PersistentMSingletonObject mSingletonObject) throws PersistenceException;
    
}


package model.visitor;
import model.UserException;
import persistence.*;

public interface AbstractObjectExceptionVisitor<E extends UserException> {
    
    public void handleMObject(PersistentMObject mObject) throws PersistenceException, E;
    public void handleMSingletonObject(PersistentMSingletonObject mSingletonObject) throws PersistenceException, E;
    
}

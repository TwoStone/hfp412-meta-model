
package model.visitor;
import model.UserException;
import persistence.*;

public interface MBooleanExceptionVisitor<E extends UserException> {
    
    public void handleMFalse(PersistentMFalse mFalse) throws PersistenceException, E;
    public void handleMTrue(PersistentMTrue mTrue) throws PersistenceException, E;
    
}


package model.visitor;
import model.UserException;
import persistence.*;

public interface BooleanValueExceptionVisitor<E extends UserException> {
    
    public void handleBooleanFalse(PersistentBooleanFalse booleanFalse) throws PersistenceException, E;
    public void handleBooleanTrue(PersistentBooleanTrue booleanTrue) throws PersistenceException, E;
    
}

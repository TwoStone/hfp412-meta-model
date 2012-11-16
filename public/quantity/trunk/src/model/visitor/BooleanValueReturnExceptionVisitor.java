
package model.visitor;
import model.UserException;
import persistence.*;

public interface BooleanValueReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleBooleanFalse(PersistentBooleanFalse booleanFalse) throws PersistenceException, E;
    public R handleBooleanTrue(PersistentBooleanTrue booleanTrue) throws PersistenceException, E;
    
}

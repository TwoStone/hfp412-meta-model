
package model.visitor;
import model.UserException;
import persistence.*;

public interface AbsUnitReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleUnit(PersistentUnit unit) throws PersistenceException, E;
    public R handleCompUnit(PersistentCompUnit compUnit) throws PersistenceException, E;
    
}

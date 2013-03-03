
package model.visitor;
import model.UserException;
import persistence.*;

public interface UnitImutabCalcReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleSubtraction(PersistentSubtraction subtraction) throws PersistenceException, E;
    public R handleAddition(PersistentAddition addition) throws PersistenceException, E;
    
}

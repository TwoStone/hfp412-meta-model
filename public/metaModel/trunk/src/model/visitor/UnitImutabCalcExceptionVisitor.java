
package model.visitor;
import model.UserException;
import persistence.*;

public interface UnitImutabCalcExceptionVisitor<E extends UserException> {
    
    public void handleSubtraction(PersistentSubtraction subtraction) throws PersistenceException, E;
    public void handleAddition(PersistentAddition addition) throws PersistenceException, E;
    
}

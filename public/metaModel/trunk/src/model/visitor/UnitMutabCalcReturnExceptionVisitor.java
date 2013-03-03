
package model.visitor;
import model.UserException;
import persistence.*;

public interface UnitMutabCalcReturnExceptionVisitor<R, E extends UserException> {
    
    public R handleMultiplication(PersistentMultiplication multiplication) throws PersistenceException, E;
    public R handleDivision(PersistentDivision division) throws PersistenceException, E;
    
}

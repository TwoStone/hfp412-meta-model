
package model.visitor;
import model.UserException;
import persistence.PersistenceException;
import persistence.PersistentDivision;
import persistence.PersistentMultiplication;

public interface UnitMutabCalcExceptionVisitor<E extends UserException> {
    
    public void handleMultiplication(PersistentMultiplication multiplication) throws PersistenceException, E;
    public void handleDivision(PersistentDivision division) throws PersistenceException, E;
    
}

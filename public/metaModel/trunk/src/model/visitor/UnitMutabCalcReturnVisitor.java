
package model.visitor;

import persistence.PersistenceException;
import persistence.PersistentDivision;
import persistence.PersistentMultiplication;

public interface UnitMutabCalcReturnVisitor<R> {
    
    public R handleMultiplication(PersistentMultiplication multiplication) throws PersistenceException;
    public R handleDivision(PersistentDivision division) throws PersistenceException;
    
}

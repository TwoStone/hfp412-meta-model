
package model.visitor;

import persistence.*;

public interface UnitMutabCalcReturnVisitor<R> {
    
    public R handleMultiplication(PersistentMultiplication multiplication) throws PersistenceException;
    public R handleDivision(PersistentDivision division) throws PersistenceException;
    
}

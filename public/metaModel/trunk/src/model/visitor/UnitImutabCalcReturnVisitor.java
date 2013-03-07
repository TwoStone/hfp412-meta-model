
package model.visitor;

import persistence.*;

public interface UnitImutabCalcReturnVisitor<R> {
    
    public R handleSubtraction(PersistentSubtraction subtraction) throws PersistenceException;
    public R handleAddition(PersistentAddition addition) throws PersistenceException;
    
}

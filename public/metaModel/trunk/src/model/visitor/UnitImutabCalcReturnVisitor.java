
package model.visitor;

import persistence.PersistenceException;
import persistence.PersistentAddition;
import persistence.PersistentSubtraction;

public interface UnitImutabCalcReturnVisitor<R> {
    
    public R handleSubtraction(PersistentSubtraction subtraction) throws PersistenceException;
    public R handleAddition(PersistentAddition addition) throws PersistenceException;
    
}


package model.visitor;

import persistence.PersistenceException;
import persistence.PersistentAddition;
import persistence.PersistentSubtraction;

public interface UnitImutabCalcVisitor {
    
    public void handleSubtraction(PersistentSubtraction subtraction) throws PersistenceException;
    public void handleAddition(PersistentAddition addition) throws PersistenceException;
    
}

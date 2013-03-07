
package model.visitor;

import persistence.*;

public interface UnitImutabCalcVisitor {
    
    public void handleSubtraction(PersistentSubtraction subtraction) throws PersistenceException;
    public void handleAddition(PersistentAddition addition) throws PersistenceException;
    
}

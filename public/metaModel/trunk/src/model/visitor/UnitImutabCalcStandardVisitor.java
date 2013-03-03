
package model.visitor;

import persistence.*;

public abstract class UnitImutabCalcStandardVisitor implements UnitImutabCalcVisitor {
    
    public void handleSubtraction(PersistentSubtraction subtraction) throws PersistenceException{
        this.standardHandling(subtraction);
    }
    public void handleAddition(PersistentAddition addition) throws PersistenceException{
        this.standardHandling(addition);
    }
    protected abstract void standardHandling(PersistentUnitImutabCalc unitImutabCalc) throws PersistenceException;
}

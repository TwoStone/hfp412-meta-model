
package model.visitor;

import persistence.PersistenceException;
import persistence.PersistentDivision;
import persistence.PersistentMultiplication;
import persistence.PersistentUnitMutabCalc;

public abstract class UnitMutabCalcStandardVisitor implements UnitMutabCalcVisitor {
    
    public void handleMultiplication(PersistentMultiplication multiplication) throws PersistenceException{
        this.standardHandling(multiplication);
    }
    public void handleDivision(PersistentDivision division) throws PersistenceException{
        this.standardHandling(division);
    }
    protected abstract void standardHandling(PersistentUnitMutabCalc unitMutabCalc) throws PersistenceException;
}

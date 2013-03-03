
package model.visitor;

import persistence.*;

public abstract class BasicCalculationDirectVisitor implements BasicCalculationVisitor {
    
    public abstract void handleUnitImutabCalc(PersistentUnitImutabCalc unitImutabCalc) throws PersistenceException;
    
    public void handleSubtraction(PersistentSubtraction subtraction) throws PersistenceException{
        this.handleUnitImutabCalc(subtraction);
    }
    public void handleAddition(PersistentAddition addition) throws PersistenceException{
        this.handleUnitImutabCalc(addition);
    }
    public abstract void handleUnitMutabCalc(PersistentUnitMutabCalc unitMutabCalc) throws PersistenceException;
    
    public void handleMultiplication(PersistentMultiplication multiplication) throws PersistenceException{
        this.handleUnitMutabCalc(multiplication);
    }
    public void handleDivision(PersistentDivision division) throws PersistenceException{
        this.handleUnitMutabCalc(division);
    }
    
}

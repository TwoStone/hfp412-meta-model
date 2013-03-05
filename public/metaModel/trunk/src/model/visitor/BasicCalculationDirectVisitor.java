
package model.visitor;

import persistence.PersistenceException;
import persistence.PersistentAddition;
import persistence.PersistentDivision;
import persistence.PersistentMultiplication;
import persistence.PersistentSubtraction;
import persistence.PersistentUnitImutabCalc;
import persistence.PersistentUnitMutabCalc;

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

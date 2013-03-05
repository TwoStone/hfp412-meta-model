
package model.visitor;

import persistence.PersistenceException;
import persistence.PersistentAddition;
import persistence.PersistentBasicCalculation;
import persistence.PersistentDivision;
import persistence.PersistentMultiplication;
import persistence.PersistentSubtraction;

public abstract class BasicCalculationStandardVisitor implements BasicCalculationVisitor {
    
    public void handleMultiplication(PersistentMultiplication multiplication) throws PersistenceException{
        this.standardHandling(multiplication);
    }
    public void handleSubtraction(PersistentSubtraction subtraction) throws PersistenceException{
        this.standardHandling(subtraction);
    }
    public void handleDivision(PersistentDivision division) throws PersistenceException{
        this.standardHandling(division);
    }
    public void handleAddition(PersistentAddition addition) throws PersistenceException{
        this.standardHandling(addition);
    }
    protected abstract void standardHandling(PersistentBasicCalculation basicCalculation) throws PersistenceException;
}


package model.visitor;

import persistence.PersistenceException;
import persistence.PersistentDivision;
import persistence.PersistentMultiplication;

public interface UnitMutabCalcVisitor {
    
    public void handleMultiplication(PersistentMultiplication multiplication) throws PersistenceException;
    public void handleDivision(PersistentDivision division) throws PersistenceException;
    
}

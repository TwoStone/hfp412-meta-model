
package model.visitor;

import persistence.*;

public interface UnitMutabCalcVisitor {
    
    public void handleMultiplication(PersistentMultiplication multiplication) throws PersistenceException;
    public void handleDivision(PersistentDivision division) throws PersistenceException;
    
}


package model.visitor;

import persistence.*;

public interface AbsUnitVisitor {
    
    public void handleUnit(PersistentUnit unit) throws PersistenceException;
    public void handleCompUnit(PersistentCompUnit compUnit) throws PersistenceException;
    
}

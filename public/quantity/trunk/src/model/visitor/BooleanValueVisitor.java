
package model.visitor;

import persistence.*;

public interface BooleanValueVisitor {
    
    public void handleBooleanFalse(PersistentBooleanFalse booleanFalse) throws PersistenceException;
    public void handleBooleanTrue(PersistentBooleanTrue booleanTrue) throws PersistenceException;
    
}

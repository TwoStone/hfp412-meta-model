
package model.visitor;

import persistence.*;

public interface BooleanValueReturnVisitor<R> {
    
    public R handleBooleanFalse(PersistentBooleanFalse booleanFalse) throws PersistenceException;
    public R handleBooleanTrue(PersistentBooleanTrue booleanTrue) throws PersistenceException;
    
}

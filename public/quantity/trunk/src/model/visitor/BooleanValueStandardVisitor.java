
package model.visitor;

import persistence.*;

public abstract class BooleanValueStandardVisitor implements BooleanValueVisitor {
    
    public void handleBooleanTrue(PersistentBooleanTrue booleanTrue) throws PersistenceException{
        this.standardHandling(booleanTrue);
    }
    public void handleBooleanFalse(PersistentBooleanFalse booleanFalse) throws PersistenceException{
        this.standardHandling(booleanFalse);
    }
    protected abstract void standardHandling(PersistentBooleanValue booleanValue) throws PersistenceException;
}

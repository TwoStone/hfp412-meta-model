
package model.visitor;

import persistence.*;

public interface MBooleanVisitor {
    
    public void handleMFalse(PersistentMFalse mFalse) throws PersistenceException;
    public void handleMTrue(PersistentMTrue mTrue) throws PersistenceException;
    public void handleMBoolean(PersistentMBoolean mBoolean) throws PersistenceException;
    
}

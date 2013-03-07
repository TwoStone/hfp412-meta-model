
package model.visitor;

import persistence.PersistenceException;
import persistence.PersistentMFalse;
import persistence.PersistentMTrue;

public interface MBooleanVisitor {
    
    public void handleMFalse(PersistentMFalse mFalse) throws PersistenceException;
    public void handleMTrue(PersistentMTrue mTrue) throws PersistenceException;
    
}

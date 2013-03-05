
package model.visitor;

import persistence.PersistenceException;
import persistence.PersistentMFalse;
import persistence.PersistentMTrue;

public interface MBooleanReturnVisitor<R> {
    
    public R handleMFalse(PersistentMFalse mFalse) throws PersistenceException;
    public R handleMTrue(PersistentMTrue mTrue) throws PersistenceException;
    
}

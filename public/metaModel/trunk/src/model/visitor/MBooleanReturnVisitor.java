
package model.visitor;

import persistence.*;

public interface MBooleanReturnVisitor<R> {
    
    public R handleMFalse(PersistentMFalse mFalse) throws PersistenceException;
    public R handleMTrue(PersistentMTrue mTrue) throws PersistenceException;
    public R handleMBoolean(PersistentMBoolean mBoolean) throws PersistenceException;
    
}

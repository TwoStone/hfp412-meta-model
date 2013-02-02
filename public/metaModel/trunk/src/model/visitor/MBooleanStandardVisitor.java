
package model.visitor;

import persistence.*;

public abstract class MBooleanStandardVisitor implements MBooleanVisitor {
    
    public void handleMFalse(PersistentMFalse mFalse) throws PersistenceException{
        this.standardHandling(mFalse);
    }
    public void handleMTrue(PersistentMTrue mTrue) throws PersistenceException{
        this.standardHandling(mTrue);
    }
    protected abstract void standardHandling(PersistentMBoolean mBoolean) throws PersistenceException;
}

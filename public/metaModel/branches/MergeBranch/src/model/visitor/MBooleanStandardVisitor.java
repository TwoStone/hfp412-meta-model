
package model.visitor;

import persistence.*;

public abstract class MBooleanStandardVisitor implements MBooleanVisitor {
    
    public void handleMFalse(PersistentMFalse mFalse) throws PersistenceException{
        this.standardHandling(mFalse);
    }
    public void handleMBoolean(PersistentMBoolean mBoolean) throws PersistenceException{
        this.standardHandling(mBoolean);
    }
    public void handleMTrue(PersistentMTrue mTrue) throws PersistenceException{
        this.standardHandling(mTrue);
    }
    protected abstract void standardHandling(PersistentMBoolean mBoolean) throws PersistenceException;
}

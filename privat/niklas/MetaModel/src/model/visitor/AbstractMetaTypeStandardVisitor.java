
package model.visitor;

import persistence.*;

public abstract class AbstractMetaTypeStandardVisitor implements AbstractMetaTypeVisitor {
    
    public void handleOrMetaType(PersistentOrMetaType orMetaType) throws PersistenceException{
        this.standardHandling(orMetaType);
    }
    public void handleAndMetaType(PersistentAndMetaType andMetaType) throws PersistenceException{
        this.standardHandling(andMetaType);
    }
    public void handleMetaType(PersistentMetaType metaType) throws PersistenceException{
        this.standardHandling(metaType);
    }
    protected abstract void standardHandling(PersistentAbstractMetaType abstractMetaType) throws PersistenceException;
}

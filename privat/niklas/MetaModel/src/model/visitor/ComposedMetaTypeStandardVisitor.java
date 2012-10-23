
package model.visitor;

import persistence.*;

public abstract class ComposedMetaTypeStandardVisitor implements ComposedMetaTypeVisitor {
    
    public void handleOrMetaType(PersistentOrMetaType orMetaType) throws PersistenceException{
        this.standardHandling(orMetaType);
    }
    public void handleAndMetaType(PersistentAndMetaType andMetaType) throws PersistenceException{
        this.standardHandling(andMetaType);
    }
    protected abstract void standardHandling(PersistentComposedMetaType composedMetaType) throws PersistenceException;
}

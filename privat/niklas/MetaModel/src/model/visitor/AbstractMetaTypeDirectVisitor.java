
package model.visitor;

import persistence.*;

public abstract class AbstractMetaTypeDirectVisitor implements AbstractMetaTypeVisitor {
    
    public abstract void handleComposedMetaType(PersistentComposedMetaType composedMetaType) throws PersistenceException;
    
    public void handleOrMetaType(PersistentOrMetaType orMetaType) throws PersistenceException{
        this.handleComposedMetaType(orMetaType);
    }
    public void handleAndMetaType(PersistentAndMetaType andMetaType) throws PersistenceException{
        this.handleComposedMetaType(andMetaType);
    }
    public abstract void handleMetaType(PersistentMetaType metaType) throws PersistenceException;
    
    
}

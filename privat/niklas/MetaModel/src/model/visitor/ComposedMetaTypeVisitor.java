
package model.visitor;

import persistence.*;

public interface ComposedMetaTypeVisitor {
    
    public void handleOrMetaType(PersistentOrMetaType orMetaType) throws PersistenceException;
    public void handleAndMetaType(PersistentAndMetaType andMetaType) throws PersistenceException;
    
}

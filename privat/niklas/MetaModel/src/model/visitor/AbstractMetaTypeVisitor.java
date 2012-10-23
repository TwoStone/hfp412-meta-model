
package model.visitor;

import persistence.*;

public interface AbstractMetaTypeVisitor extends ComposedMetaTypeVisitor{
    
    public void handleMetaType(PersistentMetaType metaType) throws PersistenceException;
    
}

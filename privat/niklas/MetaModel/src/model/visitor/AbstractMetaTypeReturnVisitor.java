
package model.visitor;

import persistence.*;

public interface AbstractMetaTypeReturnVisitor<R> extends ComposedMetaTypeReturnVisitor<R> {
    
    public R handleMetaType(PersistentMetaType metaType) throws PersistenceException;
    
}

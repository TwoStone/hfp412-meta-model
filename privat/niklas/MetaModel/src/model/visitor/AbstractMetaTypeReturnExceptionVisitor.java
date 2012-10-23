
package model.visitor;

import persistence.*;

public interface AbstractMetaTypeReturnExceptionVisitor<R, E extends model.UserException> extends ComposedMetaTypeReturnExceptionVisitor<R, E> {
    
    public R handleMetaType(PersistentMetaType metaType) throws PersistenceException, E;
    
}

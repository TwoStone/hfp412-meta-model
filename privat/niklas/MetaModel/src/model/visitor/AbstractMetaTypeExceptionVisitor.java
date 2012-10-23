
package model.visitor;

import persistence.*;

public interface AbstractMetaTypeExceptionVisitor<E extends model.UserException> extends ComposedMetaTypeExceptionVisitor<E>{
    
    public void handleMetaType(PersistentMetaType metaType) throws PersistenceException, E;
    
}

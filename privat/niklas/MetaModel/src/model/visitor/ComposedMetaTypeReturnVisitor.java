
package model.visitor;

import persistence.*;

public interface ComposedMetaTypeReturnVisitor<R> {
    
    public R handleOrMetaType(PersistentOrMetaType orMetaType) throws PersistenceException;
    public R handleAndMetaType(PersistentAndMetaType andMetaType) throws PersistenceException;
    
}

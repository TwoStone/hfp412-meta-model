
package model.visitor;

import persistence.*;

public interface ComposedMetaTypeReturnExceptionVisitor<R, E extends model.UserException> {
    
    public R handleOrMetaType(PersistentOrMetaType orMetaType) throws PersistenceException, E;
    public R handleAndMetaType(PersistentAndMetaType andMetaType) throws PersistenceException, E;
    
}

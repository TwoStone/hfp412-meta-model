
package model.visitor;

import persistence.*;

public interface ComposedMetaTypeExceptionVisitor<E extends model.UserException> {
    
    public void handleOrMetaType(PersistentOrMetaType orMetaType) throws PersistenceException, E;
    public void handleAndMetaType(PersistentAndMetaType andMetaType) throws PersistenceException, E;
    
}

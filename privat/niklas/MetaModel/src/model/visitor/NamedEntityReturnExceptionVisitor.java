
package model.visitor;

import persistence.*;

public interface NamedEntityReturnExceptionVisitor<R, E extends model.UserException> {
    
    public R handleMetaAspect(PersistentMetaAspect metaAspect) throws PersistenceException, E;
    public R handleMetaAssociation(PersistentMetaAssociation metaAssociation) throws PersistenceException, E;
    public R handleMetaHierarchy(PersistentMetaHierarchy metaHierarchy) throws PersistenceException, E;
    public R handleMetaType(PersistentMetaType metaType) throws PersistenceException, E;
    public R handleCONCNamedEntity(PersistentCONCNamedEntity cONCNamedEntity) throws PersistenceException, E;
    
}

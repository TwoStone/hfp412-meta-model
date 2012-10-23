
package model.visitor;

import persistence.*;

public interface NamedEntityReturnVisitor<R> {
    
    public R handleMetaAspect(PersistentMetaAspect metaAspect) throws PersistenceException;
    public R handleMetaAssociation(PersistentMetaAssociation metaAssociation) throws PersistenceException;
    public R handleMetaHierarchy(PersistentMetaHierarchy metaHierarchy) throws PersistenceException;
    public R handleMetaType(PersistentMetaType metaType) throws PersistenceException;
    public R handleCONCNamedEntity(PersistentCONCNamedEntity cONCNamedEntity) throws PersistenceException;
    
}

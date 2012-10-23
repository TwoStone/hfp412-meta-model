
package model.visitor;

import persistence.*;

public interface NamedEntityVisitor {
    
    public void handleMetaAspect(PersistentMetaAspect metaAspect) throws PersistenceException;
    public void handleMetaAssociation(PersistentMetaAssociation metaAssociation) throws PersistenceException;
    public void handleMetaHierarchy(PersistentMetaHierarchy metaHierarchy) throws PersistenceException;
    public void handleMetaType(PersistentMetaType metaType) throws PersistenceException;
    public void handleCONCNamedEntity(PersistentCONCNamedEntity cONCNamedEntity) throws PersistenceException;
    
}

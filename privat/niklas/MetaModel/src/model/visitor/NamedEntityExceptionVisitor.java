
package model.visitor;

import persistence.*;

public interface NamedEntityExceptionVisitor<E extends model.UserException> {
    
    public void handleMetaAspect(PersistentMetaAspect metaAspect) throws PersistenceException, E;
    public void handleMetaAssociation(PersistentMetaAssociation metaAssociation) throws PersistenceException, E;
    public void handleMetaHierarchy(PersistentMetaHierarchy metaHierarchy) throws PersistenceException, E;
    public void handleMetaType(PersistentMetaType metaType) throws PersistenceException, E;
    public void handleCONCNamedEntity(PersistentCONCNamedEntity cONCNamedEntity) throws PersistenceException, E;
    
}

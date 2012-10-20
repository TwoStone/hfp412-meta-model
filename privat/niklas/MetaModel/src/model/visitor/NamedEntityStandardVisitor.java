
package model.visitor;

import persistence.*;

public abstract class NamedEntityStandardVisitor implements NamedEntityVisitor {
    
    public void handleCONCNamedEntity(PersistentCONCNamedEntity cONCNamedEntity) throws PersistenceException{
        this.standardHandling(cONCNamedEntity);
    }
    public void handleMetaAspect(PersistentMetaAspect metaAspect) throws PersistenceException{
        this.standardHandling(metaAspect);
    }
    public void handleMetaHierarchy(PersistentMetaHierarchy metaHierarchy) throws PersistenceException{
        this.standardHandling(metaHierarchy);
    }
    public void handleMetaType(PersistentMetaType metaType) throws PersistenceException{
        this.standardHandling(metaType);
    }
    public void handleMetaAssociation(PersistentMetaAssociation metaAssociation) throws PersistenceException{
        this.standardHandling(metaAssociation);
    }
    protected abstract void standardHandling(PersistentNamedEntity namedEntity) throws PersistenceException;
}

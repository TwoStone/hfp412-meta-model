
package view.visitor;

import view.*;

public abstract class NamedEntityStandardVisitor implements NamedEntityVisitor {
    
    public void handleCONCNamedEntity(CONCNamedEntityView cONCNamedEntity) throws ModelException{
        this.standardHandling(cONCNamedEntity);
    }
    public void handleMetaAspect(MetaAspectView metaAspect) throws ModelException{
        this.standardHandling(metaAspect);
    }
    public void handleMetaHierarchy(MetaHierarchyView metaHierarchy) throws ModelException{
        this.standardHandling(metaHierarchy);
    }
    public void handleMetaType(MetaTypeView metaType) throws ModelException{
        this.standardHandling(metaType);
    }
    public void handleMetaAssociation(MetaAssociationView metaAssociation) throws ModelException{
        this.standardHandling(metaAssociation);
    }
    protected abstract void standardHandling(NamedEntityView namedEntity) throws ModelException;
}

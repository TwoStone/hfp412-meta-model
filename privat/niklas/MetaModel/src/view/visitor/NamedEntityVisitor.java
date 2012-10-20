
package view.visitor;

import view.*;

public interface NamedEntityVisitor {
    
    public void handleMetaAspect(MetaAspectView metaAspect) throws ModelException;
    public void handleMetaAssociation(MetaAssociationView metaAssociation) throws ModelException;
    public void handleMetaHierarchy(MetaHierarchyView metaHierarchy) throws ModelException;
    public void handleMetaType(MetaTypeView metaType) throws ModelException;
    public void handleCONCNamedEntity(CONCNamedEntityView cONCNamedEntity) throws ModelException;
    
}

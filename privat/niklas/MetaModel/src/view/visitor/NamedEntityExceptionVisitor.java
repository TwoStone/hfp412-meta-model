
package view.visitor;

import view.*;

public interface NamedEntityExceptionVisitor<E extends model.UserException> {
    
    public void handleMetaAspect(MetaAspectView metaAspect) throws ModelException, E;
    public void handleMetaAssociation(MetaAssociationView metaAssociation) throws ModelException, E;
    public void handleMetaHierarchy(MetaHierarchyView metaHierarchy) throws ModelException, E;
    public void handleMetaType(MetaTypeView metaType) throws ModelException, E;
    public void handleCONCNamedEntity(CONCNamedEntityView cONCNamedEntity) throws ModelException, E;
    
}

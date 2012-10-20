
package view.visitor;

import view.*;

public interface NamedEntityReturnExceptionVisitor<R, E extends model.UserException> {
    
    public R handleMetaAspect(MetaAspectView metaAspect) throws ModelException, E;
    public R handleMetaAssociation(MetaAssociationView metaAssociation) throws ModelException, E;
    public R handleMetaHierarchy(MetaHierarchyView metaHierarchy) throws ModelException, E;
    public R handleMetaType(MetaTypeView metaType) throws ModelException, E;
    public R handleCONCNamedEntity(CONCNamedEntityView cONCNamedEntity) throws ModelException, E;
    
}

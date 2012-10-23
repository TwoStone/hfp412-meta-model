
package view.visitor;

import view.*;

public interface NamedEntityReturnVisitor<R> {
    
    public R handleMetaAspect(MetaAspectView metaAspect) throws ModelException;
    public R handleMetaAssociation(MetaAssociationView metaAssociation) throws ModelException;
    public R handleMetaHierarchy(MetaHierarchyView metaHierarchy) throws ModelException;
    public R handleMetaType(MetaTypeView metaType) throws ModelException;
    public R handleCONCNamedEntity(CONCNamedEntityView cONCNamedEntity) throws ModelException;
    
}

package model.meta;

public interface NamedEntityMssgsVisitor extends NamedEntityDOWNMssgsVisitor, NamedEntityUPMssgsVisitor {}


interface NamedEntityDOWNMssgsVisitor extends MetaAspectDOWNMssgsVisitor, MetaAssociationDOWNMssgsVisitor, MetaHierarchyDOWNMssgsVisitor, MetaTypeDOWNMssgsVisitor, AbstractMetaTypeUPMssgsVisitor {

    
}


interface NamedEntityUPMssgsVisitor  {

    
}

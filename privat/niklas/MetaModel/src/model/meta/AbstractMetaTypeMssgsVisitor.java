package model.meta;

public interface AbstractMetaTypeMssgsVisitor extends AbstractMetaTypeDOWNMssgsVisitor, AbstractMetaTypeUPMssgsVisitor {}


interface AbstractMetaTypeDOWNMssgsVisitor extends ComposedMetaTypeDOWNMssgsVisitor, MetaTypeDOWNMssgsVisitor, NamedEntityUPMssgsVisitor {

    
}


interface AbstractMetaTypeUPMssgsVisitor  {

    
}

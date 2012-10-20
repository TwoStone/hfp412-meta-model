package model.meta;

public interface MetaTypeMssgsVisitor extends MetaTypeDOWNMssgsVisitor, MetaTypeUPMssgsVisitor {}


interface MetaTypeDOWNMssgsVisitor  {

    
}


interface MetaTypeUPMssgsVisitor extends AbstractMetaTypeUPMssgsVisitor, NamedEntityUPMssgsVisitor {

    
}

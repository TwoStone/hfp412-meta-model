package model.meta;

public interface ComposedMetaTypeMssgsVisitor extends ComposedMetaTypeDOWNMssgsVisitor, ComposedMetaTypeUPMssgsVisitor {}


interface ComposedMetaTypeDOWNMssgsVisitor extends OrMetaTypeDOWNMssgsVisitor, AndMetaTypeDOWNMssgsVisitor {

    
}


interface ComposedMetaTypeUPMssgsVisitor extends AbstractMetaTypeUPMssgsVisitor {

    
}

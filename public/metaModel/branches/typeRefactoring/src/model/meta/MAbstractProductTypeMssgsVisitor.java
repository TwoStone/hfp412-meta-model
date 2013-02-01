package model.meta;

public interface MAbstractProductTypeMssgsVisitor extends MAbstractProductTypeDOWNMssgsVisitor, MAbstractProductTypeUPMssgsVisitor {}


interface MAbstractProductTypeDOWNMssgsVisitor extends MNonEmptyProductTypeDOWNMssgsVisitor, MEmptyProductTypeDOWNMssgsVisitor {

    
}


interface MAbstractProductTypeUPMssgsVisitor extends MComplexTypeUPMssgsVisitor {

    
}

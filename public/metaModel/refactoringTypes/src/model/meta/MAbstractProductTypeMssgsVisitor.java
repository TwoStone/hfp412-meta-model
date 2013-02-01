package model.meta;

public interface MAbstractProductTypeMssgsVisitor extends MAbstractProductTypeDOWNMssgsVisitor, MAbstractProductTypeUPMssgsVisitor {}


interface MAbstractProductTypeDOWNMssgsVisitor extends MProductTypeDOWNMssgsVisitor, MEmptyProductTypeDOWNMssgsVisitor {

    
}


interface MAbstractProductTypeUPMssgsVisitor extends MComplexTypeUPMssgsVisitor {

    
}

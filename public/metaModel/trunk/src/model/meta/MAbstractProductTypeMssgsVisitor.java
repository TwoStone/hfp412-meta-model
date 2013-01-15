package model.meta;

public interface MAbstractProductTypeMssgsVisitor extends MAbstractProductTypeDOWNMssgsVisitor, MAbstractProductTypeUPMssgsVisitor {}


interface MAbstractProductTypeDOWNMssgsVisitor extends MEmptyProductDOWNMssgsVisitor, MProductTypeDOWNMssgsVisitor {

    
}


interface MAbstractProductTypeUPMssgsVisitor extends MComplexTypeUPMssgsVisitor {

    
}

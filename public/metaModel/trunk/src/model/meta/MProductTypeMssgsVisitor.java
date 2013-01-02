package model.meta;

public interface MProductTypeMssgsVisitor extends MProductTypeDOWNMssgsVisitor, MProductTypeUPMssgsVisitor {}


interface MProductTypeDOWNMssgsVisitor extends MEmptyProductDOWNMssgsVisitor {

    
}


interface MProductTypeUPMssgsVisitor extends MComplexTypeUPMssgsVisitor {

    
}

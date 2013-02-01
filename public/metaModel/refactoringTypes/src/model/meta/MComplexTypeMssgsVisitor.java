package model.meta;

public interface MComplexTypeMssgsVisitor extends MComplexTypeDOWNMssgsVisitor, MComplexTypeUPMssgsVisitor {}


interface MComplexTypeDOWNMssgsVisitor extends MAbstractSumTypeDOWNMssgsVisitor, MAbstractProductTypeDOWNMssgsVisitor {

    
}


interface MComplexTypeUPMssgsVisitor extends MTypeUPMssgsVisitor {

    
}

package model.meta;

public interface MAbstractSumTypeMssgsVisitor extends MAbstractSumTypeDOWNMssgsVisitor, MAbstractSumTypeUPMssgsVisitor {}


interface MAbstractSumTypeDOWNMssgsVisitor extends MEmptySumTypeDOWNMssgsVisitor, MSumTypeDOWNMssgsVisitor {

    
}


interface MAbstractSumTypeUPMssgsVisitor extends MComplexTypeUPMssgsVisitor {

    
}

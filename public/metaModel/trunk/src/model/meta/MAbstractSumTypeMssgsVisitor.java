package model.meta;

public interface MAbstractSumTypeMssgsVisitor extends MAbstractSumTypeDOWNMssgsVisitor, MAbstractSumTypeUPMssgsVisitor {}


interface MAbstractSumTypeDOWNMssgsVisitor extends MEmptySumTypeDOWNMssgsVisitor, MNonEmptySumTypeDOWNMssgsVisitor {

    
}


interface MAbstractSumTypeUPMssgsVisitor extends MComplexTypeUPMssgsVisitor {

    
}

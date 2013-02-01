package model.meta;

public interface MNonEmptySumTypeMssgsVisitor extends MNonEmptySumTypeDOWNMssgsVisitor, MNonEmptySumTypeUPMssgsVisitor {}


interface MNonEmptySumTypeDOWNMssgsVisitor extends MDisjuncitveNFDOWNMssgsVisitor, MSumTypeDOWNMssgsVisitor {

    
}


interface MNonEmptySumTypeUPMssgsVisitor extends MAbstractSumTypeUPMssgsVisitor {

    
}

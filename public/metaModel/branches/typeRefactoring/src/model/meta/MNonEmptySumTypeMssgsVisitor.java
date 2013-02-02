package model.meta;

public interface MNonEmptySumTypeMssgsVisitor extends MNonEmptySumTypeDOWNMssgsVisitor, MNonEmptySumTypeUPMssgsVisitor {}


interface MNonEmptySumTypeDOWNMssgsVisitor extends MDisjunctiveNFDOWNMssgsVisitor, MSumTypeDOWNMssgsVisitor {

    
}


interface MNonEmptySumTypeUPMssgsVisitor extends MAbstractSumTypeUPMssgsVisitor {

    
}

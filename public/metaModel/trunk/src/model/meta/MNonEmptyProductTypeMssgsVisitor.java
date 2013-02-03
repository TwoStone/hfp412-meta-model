package model.meta;

public interface MNonEmptyProductTypeMssgsVisitor extends MNonEmptyProductTypeDOWNMssgsVisitor, MNonEmptyProductTypeUPMssgsVisitor {}


interface MNonEmptyProductTypeDOWNMssgsVisitor extends MAtomicTypeProductDOWNMssgsVisitor, MProductTypeDOWNMssgsVisitor {

    
}


interface MNonEmptyProductTypeUPMssgsVisitor extends MAbstractProductTypeUPMssgsVisitor {

    
}

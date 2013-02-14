package model.meta;

public interface MComplexTypeMssgsVisitor extends MComplexTypeDOWNMssgsVisitor, MComplexTypeUPMssgsVisitor {}


interface MComplexTypeDOWNMssgsVisitor extends MAbstractTypeDisjunctionDOWNMssgsVisitor, MAbstractTypeConjunctionDOWNMssgsVisitor {

    
}


interface MComplexTypeUPMssgsVisitor extends MTypeUPMssgsVisitor {

    
}

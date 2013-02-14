package model.meta;

public interface MAbstractTypeConjunctionMssgsVisitor extends MAbstractTypeConjunctionDOWNMssgsVisitor, MAbstractTypeConjunctionUPMssgsVisitor {}


interface MAbstractTypeConjunctionDOWNMssgsVisitor extends MMixedConjunctionDOWNMssgsVisitor, MAtomicTypeConjunctionDOWNMssgsVisitor {

    
}


interface MAbstractTypeConjunctionUPMssgsVisitor extends MComplexTypeUPMssgsVisitor {

    
}

package model.meta;

public interface MAtomicTypeConjunctionMssgsVisitor extends MAtomicTypeConjunctionDOWNMssgsVisitor, MAtomicTypeConjunctionUPMssgsVisitor {}


interface MAtomicTypeConjunctionDOWNMssgsVisitor extends MNonEmptyAtomicTypeConjunctionDOWNMssgsVisitor, MEmptyTypeConjunctionDOWNMssgsVisitor {

    
}


interface MAtomicTypeConjunctionUPMssgsVisitor extends MAbstractTypeConjunctionUPMssgsVisitor {

    
}

package model.meta;

public interface MAbstractTypeDisjunctionMssgsVisitor extends MAbstractTypeDisjunctionDOWNMssgsVisitor, MAbstractTypeDisjunctionUPMssgsVisitor {}


interface MAbstractTypeDisjunctionDOWNMssgsVisitor extends MMixedTypeDisjunctionDOWNMssgsVisitor, MDisjunctiveNormalFormDOWNMssgsVisitor {

    
}


interface MAbstractTypeDisjunctionUPMssgsVisitor extends MComplexTypeUPMssgsVisitor {

    
}

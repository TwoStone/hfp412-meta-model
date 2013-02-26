package model.meta;

public interface MDisjunctiveNormalFormMssgsVisitor extends MDisjunctiveNormalFormDOWNMssgsVisitor, MDisjunctiveNormalFormUPMssgsVisitor {}


interface MDisjunctiveNormalFormDOWNMssgsVisitor extends MNonEmptyDisjunctiveNormalFormDOWNMssgsVisitor, MEmptyTypeDisjunctionDOWNMssgsVisitor {

    
}


interface MDisjunctiveNormalFormUPMssgsVisitor extends MAbstractTypeDisjunctionUPMssgsVisitor {

    
}

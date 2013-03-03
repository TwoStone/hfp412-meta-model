package model.meta;

public interface UnitMutabCalcMssgsVisitor extends UnitMutabCalcDOWNMssgsVisitor, UnitMutabCalcUPMssgsVisitor {}


interface UnitMutabCalcDOWNMssgsVisitor extends MultiplicationDOWNMssgsVisitor, DivisionDOWNMssgsVisitor {

    
}


interface UnitMutabCalcUPMssgsVisitor extends BasicCalculationUPMssgsVisitor {

    
}

package model.meta;

public interface UnitImutabCalcMssgsVisitor extends UnitImutabCalcDOWNMssgsVisitor, UnitImutabCalcUPMssgsVisitor {}


interface UnitImutabCalcDOWNMssgsVisitor extends SubtractionDOWNMssgsVisitor, AdditionDOWNMssgsVisitor {

    
}


interface UnitImutabCalcUPMssgsVisitor extends BasicCalculationUPMssgsVisitor {

    
}

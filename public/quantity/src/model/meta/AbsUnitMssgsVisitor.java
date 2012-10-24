package model.meta;

public interface AbsUnitMssgsVisitor extends AbsUnitDOWNMssgsVisitor, AbsUnitUPMssgsVisitor {}


interface AbsUnitDOWNMssgsVisitor extends UnitDOWNMssgsVisitor, UnitReferenceDOWNMssgsVisitor, CompoundUnitDOWNMssgsVisitor {

    
}


interface AbsUnitUPMssgsVisitor  {

    
}

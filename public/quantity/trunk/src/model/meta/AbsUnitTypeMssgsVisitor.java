package model.meta;

public interface AbsUnitTypeMssgsVisitor extends AbsUnitTypeDOWNMssgsVisitor, AbsUnitTypeUPMssgsVisitor {}


interface AbsUnitTypeDOWNMssgsVisitor extends TypeReferenceDOWNMssgsVisitor, CompoundUnitTypeDOWNMssgsVisitor, UnitTypeDOWNMssgsVisitor {

    
}


interface AbsUnitTypeUPMssgsVisitor  {

    
}

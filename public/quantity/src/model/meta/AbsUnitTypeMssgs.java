package model.meta;

public interface AbsUnitTypeMssgs {
    void accept(AbsUnitTypeMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface AbsUnitTypeDOWNMssgs extends Mssgs, AbsUnitTypeMssgs{}
interface AbsUnitTypeUPMssgs extends TypeReferenceUPMssgs, CompoundUnitTypeUPMssgs, UnitTypeUPMssgs, AbsUnitTypeMssgs{}

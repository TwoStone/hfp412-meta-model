package model.meta;

public interface AbsUnitMssgs {
    void accept(AbsUnitMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface AbsUnitDOWNMssgs extends Mssgs, AbsUnitMssgs{}
interface AbsUnitUPMssgs extends UnitUPMssgs, UnitReferenceUPMssgs, CompoundUnitUPMssgs, AbsUnitMssgs{}

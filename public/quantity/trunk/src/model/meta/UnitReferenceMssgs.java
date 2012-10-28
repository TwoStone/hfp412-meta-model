package model.meta;

public interface UnitReferenceMssgs {
    void accept(UnitReferenceMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface UnitReferenceDOWNMssgs extends AbsUnitDOWNMssgs, UnitReferenceMssgs{}
interface UnitReferenceUPMssgs extends Mssgs, UnitReferenceMssgs{}

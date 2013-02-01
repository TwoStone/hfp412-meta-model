package model.meta;

public interface UnitTypeMssgs {
    void accept(UnitTypeMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface UnitTypeDOWNMssgs extends AbsUnitTypeDOWNMssgs, UnitTypeMssgs{}
interface UnitTypeUPMssgs extends Mssgs, UnitTypeMssgs{}

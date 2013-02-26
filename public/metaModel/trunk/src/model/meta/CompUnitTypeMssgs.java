package model.meta;

public interface CompUnitTypeMssgs {
    void accept(CompUnitTypeMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface CompUnitTypeDOWNMssgs extends AbsUnitTypeDOWNMssgs, CompUnitTypeMssgs{}
interface CompUnitTypeUPMssgs extends Mssgs, CompUnitTypeMssgs{}

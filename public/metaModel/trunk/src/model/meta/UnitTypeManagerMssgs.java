package model.meta;

public interface UnitTypeManagerMssgs {
    void accept(UnitTypeManagerMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface UnitTypeManagerDOWNMssgs extends Mssgs, UnitTypeManagerMssgs{}
interface UnitTypeManagerUPMssgs extends Mssgs, UnitTypeManagerMssgs{}

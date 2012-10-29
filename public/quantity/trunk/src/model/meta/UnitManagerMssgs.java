package model.meta;

public interface UnitManagerMssgs {
    void accept(UnitManagerMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface UnitManagerDOWNMssgs extends Mssgs, UnitManagerMssgs{}
interface UnitManagerUPMssgs extends Mssgs, UnitManagerMssgs{}

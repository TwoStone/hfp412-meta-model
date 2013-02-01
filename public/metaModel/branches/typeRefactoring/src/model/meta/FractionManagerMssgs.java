package model.meta;

public interface FractionManagerMssgs {
    void accept(FractionManagerMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface FractionManagerDOWNMssgs extends Mssgs, FractionManagerMssgs{}
interface FractionManagerUPMssgs extends Mssgs, FractionManagerMssgs{}

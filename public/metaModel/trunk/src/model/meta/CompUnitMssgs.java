package model.meta;

public interface CompUnitMssgs {
    void accept(CompUnitMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface CompUnitDOWNMssgs extends AbsUnitDOWNMssgs, CompUnitMssgs{}
interface CompUnitUPMssgs extends Mssgs, CompUnitMssgs{}

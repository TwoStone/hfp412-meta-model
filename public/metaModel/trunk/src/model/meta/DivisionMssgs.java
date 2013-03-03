package model.meta;

public interface DivisionMssgs {
    void accept(DivisionMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface DivisionDOWNMssgs extends UnitMutabCalcDOWNMssgs, DivisionMssgs{}
interface DivisionUPMssgs extends Mssgs, DivisionMssgs{}

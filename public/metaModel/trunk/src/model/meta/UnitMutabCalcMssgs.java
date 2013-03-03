package model.meta;

public interface UnitMutabCalcMssgs {
    void accept(UnitMutabCalcMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface UnitMutabCalcDOWNMssgs extends BasicCalculationDOWNMssgs, UnitMutabCalcMssgs{}
interface UnitMutabCalcUPMssgs extends MultiplicationUPMssgs, DivisionUPMssgs, UnitMutabCalcMssgs{}

package model.meta;

public interface UnitImutabCalcMssgs {
    void accept(UnitImutabCalcMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface UnitImutabCalcDOWNMssgs extends BasicCalculationDOWNMssgs, UnitImutabCalcMssgs{}
interface UnitImutabCalcUPMssgs extends SubtractionUPMssgs, AdditionUPMssgs, UnitImutabCalcMssgs{}

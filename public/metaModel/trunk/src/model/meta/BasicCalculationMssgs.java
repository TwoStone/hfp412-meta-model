package model.meta;

public interface BasicCalculationMssgs {
    void accept(BasicCalculationMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface BasicCalculationDOWNMssgs extends Mssgs, BasicCalculationMssgs{}
interface BasicCalculationUPMssgs extends UnitImutabCalcUPMssgs, UnitMutabCalcUPMssgs, BasicCalculationMssgs{}

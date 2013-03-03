package model.meta;

public interface SubtractionMssgs {
    void accept(SubtractionMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface SubtractionDOWNMssgs extends UnitImutabCalcDOWNMssgs, SubtractionMssgs{}
interface SubtractionUPMssgs extends Mssgs, SubtractionMssgs{}

package model.meta;

public interface AdditionMssgs {
    void accept(AdditionMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface AdditionDOWNMssgs extends UnitImutabCalcDOWNMssgs, AdditionMssgs{}
interface AdditionUPMssgs extends Mssgs, AdditionMssgs{}

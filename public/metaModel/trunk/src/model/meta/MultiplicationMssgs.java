package model.meta;

public interface MultiplicationMssgs {
    void accept(MultiplicationMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface MultiplicationDOWNMssgs extends UnitMutabCalcDOWNMssgs, MultiplicationMssgs{}
interface MultiplicationUPMssgs extends Mssgs, MultiplicationMssgs{}

package model.meta;

public interface PositionMssgs {
    void accept(PositionMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface PositionDOWNMssgs extends Mssgs, PositionMssgs{}
interface PositionUPMssgs extends Mssgs, PositionMssgs{}

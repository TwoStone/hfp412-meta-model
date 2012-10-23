package model.meta;

public interface FractionMssgs {
    void accept(FractionMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface FractionDOWNMssgs extends Mssgs, FractionMssgs{}
interface FractionUPMssgs extends Mssgs, FractionMssgs{}

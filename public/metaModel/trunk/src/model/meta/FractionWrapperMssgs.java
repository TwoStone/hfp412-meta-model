package model.meta;

public interface FractionWrapperMssgs {
    void accept(FractionWrapperMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface FractionWrapperDOWNMssgs extends Mssgs, FractionWrapperMssgs{}
interface FractionWrapperUPMssgs extends Mssgs, FractionWrapperMssgs{}

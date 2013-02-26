package model.meta;

public interface FunctionManagerMssgs {
    void accept(FunctionManagerMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface FunctionManagerDOWNMssgs extends Mssgs, FunctionManagerMssgs{}
interface FunctionManagerUPMssgs extends Mssgs, FunctionManagerMssgs{}

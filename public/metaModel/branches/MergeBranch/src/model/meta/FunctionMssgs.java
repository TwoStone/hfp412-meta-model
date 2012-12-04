package model.meta;

public interface FunctionMssgs {
    void accept(FunctionMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface FunctionDOWNMssgs extends Mssgs, FunctionMssgs{}
interface FunctionUPMssgs extends Mssgs, FunctionMssgs{}

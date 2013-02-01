package model.meta;

public interface OperationManagerMssgs {
    void accept(OperationManagerMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface OperationManagerDOWNMssgs extends Mssgs, OperationManagerMssgs{}
interface OperationManagerUPMssgs extends Mssgs, OperationManagerMssgs{}

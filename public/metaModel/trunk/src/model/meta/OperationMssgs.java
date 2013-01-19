package model.meta;

public interface OperationMssgs {
    void accept(OperationMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface OperationDOWNMssgs extends AbsOperationDOWNMssgs, OperationMssgs{}
interface OperationUPMssgs extends Mssgs, OperationMssgs{}

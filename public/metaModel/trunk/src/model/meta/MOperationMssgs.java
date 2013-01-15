package model.meta;

public interface MOperationMssgs {
    void accept(MOperationMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface MOperationDOWNMssgs extends MAbsOperationDOWNMssgs, MOperationMssgs{}
interface MOperationUPMssgs extends Mssgs, MOperationMssgs{}

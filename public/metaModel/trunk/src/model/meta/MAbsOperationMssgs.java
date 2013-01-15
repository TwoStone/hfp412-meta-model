package model.meta;

public interface MAbsOperationMssgs {
    void accept(MAbsOperationMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface MAbsOperationDOWNMssgs extends Mssgs, MAbsOperationMssgs{}
interface MAbsOperationUPMssgs extends MOperationUPMssgs, MAbsOperationMssgs{}

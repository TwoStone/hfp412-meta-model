package model.meta;

public interface AbsOperationMssgs {
    void accept(AbsOperationMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface AbsOperationDOWNMssgs extends Mssgs, AbsOperationMssgs{}
interface AbsOperationUPMssgs extends OperationUPMssgs, AssociationUPMssgs, AbsOperationMssgs{}

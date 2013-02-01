package model.meta;

public interface ActualParameterMssgs {
    void accept(ActualParameterMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface ActualParameterDOWNMssgs extends Mssgs, ActualParameterMssgs{}
interface ActualParameterUPMssgs extends Mssgs, ActualParameterMssgs{}

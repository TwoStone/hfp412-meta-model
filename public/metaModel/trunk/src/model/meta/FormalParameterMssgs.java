package model.meta;

public interface FormalParameterMssgs {
    void accept(FormalParameterMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface FormalParameterDOWNMssgs extends Mssgs, FormalParameterMssgs{}
interface FormalParameterUPMssgs extends Mssgs, FormalParameterMssgs{}

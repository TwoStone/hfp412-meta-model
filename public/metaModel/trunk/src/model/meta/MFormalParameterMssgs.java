package model.meta;

public interface MFormalParameterMssgs {
    void accept(MFormalParameterMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface MFormalParameterDOWNMssgs extends Mssgs, MFormalParameterMssgs{}
interface MFormalParameterUPMssgs extends Mssgs, MFormalParameterMssgs{}

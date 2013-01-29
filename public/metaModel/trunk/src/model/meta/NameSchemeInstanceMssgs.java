package model.meta;

public interface NameSchemeInstanceMssgs {
    void accept(NameSchemeInstanceMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface NameSchemeInstanceDOWNMssgs extends Mssgs, NameSchemeInstanceMssgs{}
interface NameSchemeInstanceUPMssgs extends Mssgs, NameSchemeInstanceMssgs{}

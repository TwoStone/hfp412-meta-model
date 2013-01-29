package model.meta;

public interface NameSchemeManagerMssgs {
    void accept(NameSchemeManagerMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface NameSchemeManagerDOWNMssgs extends Mssgs, NameSchemeManagerMssgs{}
interface NameSchemeManagerUPMssgs extends Mssgs, NameSchemeManagerMssgs{}

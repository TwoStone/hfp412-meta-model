package model.meta;

public interface EnumerationManagerMssgs {
    void accept(EnumerationManagerMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface EnumerationManagerDOWNMssgs extends Mssgs, EnumerationManagerMssgs{}
interface EnumerationManagerUPMssgs extends Mssgs, EnumerationManagerMssgs{}

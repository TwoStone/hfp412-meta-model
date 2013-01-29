package model.meta;

public interface NameSchemeInstaceManagerMssgs {
    void accept(NameSchemeInstaceManagerMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface NameSchemeInstaceManagerDOWNMssgs extends Mssgs, NameSchemeInstaceManagerMssgs{}
interface NameSchemeInstaceManagerUPMssgs extends Mssgs, NameSchemeInstaceManagerMssgs{}

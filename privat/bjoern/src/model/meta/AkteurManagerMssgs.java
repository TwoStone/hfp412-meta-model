package model.meta;

public interface AkteurManagerMssgs {
    void accept(AkteurManagerMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface AkteurManagerDOWNMssgs extends Mssgs, AkteurManagerMssgs{}
interface AkteurManagerUPMssgs extends Mssgs, AkteurManagerMssgs{}

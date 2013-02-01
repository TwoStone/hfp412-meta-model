package model.meta;

public interface TypeManagerMssgs {
    void accept(TypeManagerMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface TypeManagerDOWNMssgs extends Mssgs, TypeManagerMssgs{}
interface TypeManagerUPMssgs extends Mssgs, TypeManagerMssgs{}

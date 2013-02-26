package model.meta;

public interface ObjectManagerMssgs {
    void accept(ObjectManagerMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface ObjectManagerDOWNMssgs extends Mssgs, ObjectManagerMssgs{}
interface ObjectManagerUPMssgs extends Mssgs, ObjectManagerMssgs{}

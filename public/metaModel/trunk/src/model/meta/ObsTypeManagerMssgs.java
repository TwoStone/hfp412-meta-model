package model.meta;

public interface ObsTypeManagerMssgs {
    void accept(ObsTypeManagerMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface ObsTypeManagerDOWNMssgs extends Mssgs, ObsTypeManagerMssgs{}
interface ObsTypeManagerUPMssgs extends Mssgs, ObsTypeManagerMssgs{}

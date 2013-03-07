package model.meta;

public interface ObservationManagerMssgs {
    void accept(ObservationManagerMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface ObservationManagerDOWNMssgs extends Mssgs, ObservationManagerMssgs{}
interface ObservationManagerUPMssgs extends Mssgs, ObservationManagerMssgs{}

package model.meta;

public interface MeasurementTypeManagerMssgs {
    void accept(MeasurementTypeManagerMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface MeasurementTypeManagerDOWNMssgs extends Mssgs, MeasurementTypeManagerMssgs{}
interface MeasurementTypeManagerUPMssgs extends Mssgs, MeasurementTypeManagerMssgs{}

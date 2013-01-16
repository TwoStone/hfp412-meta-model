package model.meta;

public interface MeasurementMssgs {
    void accept(MeasurementMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface MeasurementDOWNMssgs extends QuantifObjectDOWNMssgs, MeasurementMssgs{}
interface MeasurementUPMssgs extends Mssgs, MeasurementMssgs{}

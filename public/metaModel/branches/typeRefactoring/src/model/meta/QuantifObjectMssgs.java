package model.meta;

public interface QuantifObjectMssgs {
    void accept(QuantifObjectMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface QuantifObjectDOWNMssgs extends Mssgs, QuantifObjectMssgs{}
interface QuantifObjectUPMssgs extends MeasurementUPMssgs, AccountUPMssgs, QuantifObjectMssgs{}

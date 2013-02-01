package model.meta;

public interface MMeasurementTypeMssgs {
    void accept(MMeasurementTypeMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface MMeasurementTypeDOWNMssgs extends MQuantiObjectTypeDOWNMssgs, MMeasurementTypeMssgs{}
interface MMeasurementTypeUPMssgs extends Mssgs, MMeasurementTypeMssgs{}

package model.meta;

public interface MQuantiObjectTypeMssgs {
    void accept(MQuantiObjectTypeMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface MQuantiObjectTypeDOWNMssgs extends Mssgs, MQuantiObjectTypeMssgs{}
interface MQuantiObjectTypeUPMssgs extends MAccountTypeUPMssgs, MMeasurementTypeUPMssgs, MQuantiObjectTypeMssgs{}

package model.meta;

public interface MObservationTypeMssgs {
    void accept(MObservationTypeMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface MObservationTypeDOWNMssgs extends MModelItemDOWNMssgs, MObservationTypeMssgs{}
interface MObservationTypeUPMssgs extends Mssgs, MObservationTypeMssgs{}

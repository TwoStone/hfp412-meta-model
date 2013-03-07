package model.meta;

public interface MObservationMssgs {
    void accept(MObservationMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface MObservationDOWNMssgs extends MModelItemDOWNMssgs, MObservationMssgs{}
interface MObservationUPMssgs extends Mssgs, MObservationMssgs{}

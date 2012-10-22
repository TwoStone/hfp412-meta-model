package model.meta;

public interface AnythingMssgs {
    void accept(AnythingMssgsVisitor visitor) throws persistence.PersistenceException;
}

interface AnythingDOWNMssgs extends Mssgs, AnythingMssgs{}
interface AnythingUPMssgs extends Mssgs, AnythingMssgs{}
